package br.com.fiap.postechfasfood.usecases;

import br.com.fiap.postechfasfood.apis.requests.PedidoWebHandlerRequest;
import br.com.fiap.postechfasfood.entities.ItensPedidoVO;
import br.com.fiap.postechfasfood.entities.PedidoVO;
import br.com.fiap.postechfasfood.entities.ProdutoVO;
import br.com.fiap.postechfasfood.entities.ProdutosPedidoVO;
import br.com.fiap.postechfasfood.gateways.PedidoGateway;
import br.com.fiap.postechfasfood.gateways.ProdutoGateway;
import br.com.fiap.postechfasfood.types.TipoStatusPedidoEnum;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
                UUID.randomUUID().toString(),
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

    public PedidoVO buscarPorNumeroPedido(int nrPedido) {
        return pedidoGateway.buscarPorNumeroPedido(nrPedido);
    }

    public PedidoVO buscarPorStatusPedido(String cdPedido) {
        return pedidoGateway.buscarPorStatusPedido(cdPedido);
    }

    public PedidoVO atualizarStatusPedido(String cdPedido, TipoStatusPedidoEnum novoStatus) {
        return pedidoGateway.atualizarStatusPedido(cdPedido, novoStatus);
    }

    public List<PedidoVO> listarTodosPedidos() {
        List<PedidoVO> todosPedidos = pedidoGateway.listarTodosPedidos();

        List<PedidoVO> pedidosFiltrados = todosPedidos.stream()
                .filter(p -> !p.getTxStatus().name().equals("FINALIZADO"))
                .toList();

        List<PedidoVO> prontos = pedidosFiltrados.stream()
                .filter(p -> p.getTxStatus().name().equals("PRONTO"))
                .sorted(Comparator.comparing(PedidoVO::getDhCriacaoPedido))
                .toList();

        List<PedidoVO> emPreparacao = pedidosFiltrados.stream()
                .filter(p -> p.getTxStatus().name().equals("EM_PREPARACAO"))
                .sorted(Comparator.comparing(PedidoVO::getDhCriacaoPedido))
                .toList();

        List<PedidoVO> recebidos = pedidosFiltrados.stream()
                .filter(p -> p.getTxStatus().name().equals("RECEBIDO"))
                .sorted(Comparator.comparing(PedidoVO::getDhCriacaoPedido))
                .toList();

        List<PedidoVO> pedidosOrdenados = new ArrayList<>();
        pedidosOrdenados.addAll(prontos);
        pedidosOrdenados.addAll(emPreparacao);
        pedidosOrdenados.addAll(recebidos);

        return pedidosOrdenados;
    }

    private int geraNumeroPedido() {
        var ultimoNumeroPedido = pedidoGateway.buscarUltimoNumeroPedido();

        return ultimoNumeroPedido >= 999 ? 1 : ultimoNumeroPedido + 1;
    }
}
