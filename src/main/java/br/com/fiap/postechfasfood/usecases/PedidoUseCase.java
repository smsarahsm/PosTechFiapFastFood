package br.com.fiap.postechfasfood.usecases;

import br.com.fiap.postechfasfood.apis.requests.PedidoWebHandlerRequest;
import br.com.fiap.postechfasfood.entities.ItensPedidoVO;
import br.com.fiap.postechfasfood.entities.PedidoVO;
import br.com.fiap.postechfasfood.entities.ProdutosPedidoVO;
import br.com.fiap.postechfasfood.gateways.PedidoGateway;
import br.com.fiap.postechfasfood.types.TipoStatusPedidoEnum;

import java.time.LocalDateTime;
import java.util.UUID;

import static br.com.fiap.postechfasfood.types.TipoStatusPedidoEnum.RECEBIDO;

public class PedidoUseCase {

    private final PedidoGateway pedidoGateway;

    public PedidoUseCase(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public PedidoVO criarPedido(PedidoWebHandlerRequest pedidoWebHandlerRequest) {
        var pedido = new PedidoVO(
                UUID.randomUUID(),
                pedidoWebHandlerRequest.cdDocCliente(),
                "0", //deixei zero por assumir que o totem é o funcionario zero, mas podemos alterar isto
                RECEBIDO,
                this.geraNumeroPedido(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                pedidoWebHandlerRequest.itens()
        );
        var pedidoVo = pedidoGateway.cadastrar(pedido);

        pedidoWebHandlerRequest.itens().forEach(item -> {
            var itensPedidoVO = new ItensPedidoVO(
               pedidoWebHandlerRequest.itens().getFirst().getProduto(),
               pedidoWebHandlerRequest.itens().getFirst().getVlQuantidade()
            );

            this.criaProdutoPedido(pedidoVo, itensPedidoVO);
        });

        return pedidoVo;
    }

    public ProdutosPedidoVO criaProdutoPedido(PedidoVO pedidoVO, ItensPedidoVO itensPedidoVO) {
        var produtoPedido = new ProdutosPedidoVO(
                pedidoVO,
                itensPedidoVO.getProduto(),
                itensPedidoVO.getVlQuantidade()
        );

        return pedidoGateway.cadastrarProdutoPedido(produtoPedido);
    }

    private int geraNumeroPedido() {
        var ultimoNumeroPedido = pedidoGateway.buscarUltimoNumeroPedido();

        return ultimoNumeroPedido >= 999 ? 1 : ultimoNumeroPedido + 1;
    }

}
