package br.com.fiap.postechfasfood.usecases;

import br.com.fiap.postechfasfood.apis.requests.PedidoWebHandlerRequest;
import br.com.fiap.postechfasfood.entities.ItensPedidoVO;
import br.com.fiap.postechfasfood.entities.PedidoVO;
import br.com.fiap.postechfasfood.entities.ProdutosPedidoVO;
import br.com.fiap.postechfasfood.gateways.PedidoGateway;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static br.com.fiap.postechfasfood.types.TipoStatusPedidoEnum.AGUARDANDO_PAGAMENTO;

@Service
public class PedidoUseCase {

    private final PedidoGateway pedidoGateway;

    public PedidoUseCase(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public PedidoVO criarPedido(PedidoWebHandlerRequest pedidoWebHandlerRequest) {

        var numeroPedido = this.geraNumeroPedido();
        var itensPedido = pedidoWebHandlerRequest.itens();

        var pedido = new PedidoVO(
                UUID.randomUUID(),
                pedidoWebHandlerRequest.cdDocCliente(),
                null,
                AGUARDANDO_PAGAMENTO,
                numeroPedido,
                LocalDateTime.now(),
                LocalDateTime.now(),
                itensPedido
        );
        var pedidoVo = pedidoGateway.cadastrar(pedido);

        itensPedido.forEach(item -> {
            var itensPedidoVO = new ItensPedidoVO(
               item.getProduto(),
               item.getVlQuantidade()
            );

            this.criaProdutoPedido(pedidoVo, itensPedidoVO);
        });

        var valorTotal = this.somaTotal(itensPedido);
        pedidoGateway.gerarPagamento(numeroPedido, valorTotal);

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

    private double somaTotal(List<ItensPedidoVO> itens) {
        return itens.stream().mapToDouble(v -> v.getProduto().getVlPreco() * v.getVlQuantidade()).sum();
    }
}
