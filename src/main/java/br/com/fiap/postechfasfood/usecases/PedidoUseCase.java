package br.com.fiap.postechfasfood.usecases;

import br.com.fiap.postechfasfood.apis.requests.PedidoWebHandlerRequest;
import br.com.fiap.postechfasfood.entities.ItensPedidoVO;
import br.com.fiap.postechfasfood.entities.PedidoVO;
import br.com.fiap.postechfasfood.entities.ProdutoVO;
import br.com.fiap.postechfasfood.entities.ProdutosPedidoVO;
import br.com.fiap.postechfasfood.gateways.PedidoGateway;
import br.com.fiap.postechfasfood.gateways.ProdutoGateway;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

import static br.com.fiap.postechfasfood.types.TipoStatusPedidoEnum.AGUARDANDO_PAGAMENTO;

@Service
public class PedidoUseCase {

    private final PedidoGateway pedidoGateway;
    private final ProdutoGateway produtoGateway;

    public PedidoUseCase(PedidoGateway pedidoGateway, ProdutoGateway produtoGateway) {
        this.pedidoGateway = pedidoGateway;
        this.produtoGateway = produtoGateway;
    }

    public PedidoVO criarPedido(PedidoWebHandlerRequest pedidoWebHandlerRequest) {
        var pedido = new PedidoVO(
                UUID.randomUUID(),
                pedidoWebHandlerRequest.cdDocCliente(),
                AGUARDANDO_PAGAMENTO,
                this.geraNumeroPedido(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                pedidoWebHandlerRequest.itens()
        );
        var pedidoVo = pedidoGateway.cadastrar(pedido);

        pedidoWebHandlerRequest.itens().forEach(item -> {
            var itensPedidoVO = new ItensPedidoVO(
               item.getCdProduto(),
               item.getVlQuantidade()
            );

            this.criaProdutoPedido(pedidoVo, itensPedidoVO);
        });

        return pedidoVo;
    }

    public ProdutosPedidoVO criaProdutoPedido(PedidoVO pedidoVO, ItensPedidoVO itensPedidoVO) {
        ProdutoVO produto = produtoGateway.buscarPorCdProduto(itensPedidoVO.getCdProduto());
        var produtoPedido = new ProdutosPedidoVO(
                pedidoVO,
                produto,
                itensPedidoVO.getVlQuantidade()
        );

        return pedidoGateway.cadastrarProdutoPedido(produtoPedido);
    }

    private int geraNumeroPedido() {
        var ultimoNumeroPedido = pedidoGateway.buscarUltimoNumeroPedido();

        return ultimoNumeroPedido >= 999 ? 1 : ultimoNumeroPedido + 1;
    }

}
