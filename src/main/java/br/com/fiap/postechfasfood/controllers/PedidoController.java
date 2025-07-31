package br.com.fiap.postechfasfood.controllers;

import br.com.fiap.postechfasfood.adapters.PedidoWebHandlerAdapter;
import br.com.fiap.postechfasfood.apis.requests.PedidoWebHandlerRequest;
import br.com.fiap.postechfasfood.apis.responses.PedidoAtualizadoWebHandlerResponse;
import br.com.fiap.postechfasfood.apis.responses.PedidoPorStatusWebHandlerResponse;
import br.com.fiap.postechfasfood.apis.responses.PedidoWebHandlerResponse;
import br.com.fiap.postechfasfood.apis.responses.PedidosWebHandlerResponse;
import br.com.fiap.postechfasfood.gateways.PedidoGateway;
import br.com.fiap.postechfasfood.gateways.ProdutoGateway;
import br.com.fiap.postechfasfood.interfaces.PedidoRepositoryInterface;
import br.com.fiap.postechfasfood.interfaces.ProdutoRepositoryInterface;
import br.com.fiap.postechfasfood.types.TipoStatusPedidoEnum;
import br.com.fiap.postechfasfood.usecases.PedidoUseCase;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class PedidoController {

    public PedidoWebHandlerResponse criarPedido(PedidoRepositoryInterface pedidoRepository,
                                                ProdutoRepositoryInterface produtoRepository,
                                                PedidoWebHandlerRequest pedidoWebHandlerRequest) {
        PedidoGateway pedidoGateway = new PedidoGateway(pedidoRepository);
        ProdutoGateway produtoGateway = new ProdutoGateway(produtoRepository);

        PedidoUseCase pedidoUseCase = new PedidoUseCase(pedidoGateway, produtoGateway);
        var pedidoCriado = pedidoUseCase.criarPedido(pedidoWebHandlerRequest);

        final PedidoWebHandlerAdapter pedidoWebHandlerAdapter = new PedidoWebHandlerAdapter();
        return pedidoWebHandlerAdapter.toResponseDto(pedidoCriado);
    }

    public PedidoPorStatusWebHandlerResponse buscarPorNumeroPedido(PedidoRepositoryInterface pedidoRepository,
                                                                   ProdutoRepositoryInterface produtoRepository,
                                                                   int nrPedido) {
        PedidoGateway pedidoGateway = new PedidoGateway(pedidoRepository);
        ProdutoGateway produtoGateway = new ProdutoGateway(produtoRepository);

        PedidoUseCase pedidoUseCase = new PedidoUseCase(pedidoGateway, produtoGateway);
        var pedido = pedidoUseCase.buscarPorNumeroPedido(nrPedido);

        final PedidoWebHandlerAdapter pedidoWebHandlerAdapter = new PedidoWebHandlerAdapter();
        return pedidoWebHandlerAdapter.toResponsePorStatusDto(pedido);
    }

    public TipoStatusPedidoEnum buscarPorStatusPedido(PedidoRepositoryInterface pedidoRepository,
                                                      ProdutoRepositoryInterface produtoRepository,
                                                      UUID cdPedido) {
        PedidoGateway pedidoGateway = new PedidoGateway(pedidoRepository);
        ProdutoGateway produtoGateway = new ProdutoGateway(produtoRepository);

        PedidoUseCase pedidoUseCase = new PedidoUseCase(pedidoGateway, produtoGateway);
        var pedido = pedidoUseCase.buscarPorStatusPedido(cdPedido);

        return pedido.getTxStatus();
    }

    public PedidoAtualizadoWebHandlerResponse atualizarStatusPedido(PedidoRepositoryInterface pedidoRepository,
                                                                    ProdutoRepositoryInterface produtoRepository,
                                                                    UUID cdPedido, TipoStatusPedidoEnum novoStatus) {
        PedidoGateway pedidoGateway = new PedidoGateway(pedidoRepository);
        ProdutoGateway produtoGateway = new ProdutoGateway(produtoRepository);

        PedidoUseCase pedidoUseCase = new PedidoUseCase(pedidoGateway, produtoGateway);
        var pedido = pedidoUseCase.atualizarStatusPedido(cdPedido,novoStatus);

        final PedidoWebHandlerAdapter pedidoWebHandlerAdapter = new PedidoWebHandlerAdapter();

        return pedidoWebHandlerAdapter.toResponsePedidoAtualizadoDto(pedido);
    }

    public List<PedidosWebHandlerResponse> listarTodosPedidos(PedidoRepositoryInterface pedidoRepository, ProdutoRepositoryInterface produtoRepository) {
        PedidoGateway pedidoGateway = new PedidoGateway(pedidoRepository);
        ProdutoGateway produtoGateway = new ProdutoGateway(produtoRepository);

        PedidoUseCase pedidoUseCase = new PedidoUseCase(pedidoGateway, produtoGateway);
        var pedidos = pedidoUseCase.listarTodosPedidos();

        final PedidoWebHandlerAdapter pedidoWebHandlerAdapter = new PedidoWebHandlerAdapter();

        return pedidoWebHandlerAdapter.toResponsePedidosDto(pedidos);
    }
}
