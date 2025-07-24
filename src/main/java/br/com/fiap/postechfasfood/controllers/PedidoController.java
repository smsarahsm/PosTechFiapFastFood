package br.com.fiap.postechfasfood.controllers;

import br.com.fiap.postechfasfood.adapters.PedidoWebHandlerAdapter;
import br.com.fiap.postechfasfood.apis.requests.PedidoWebHandlerRequest;
import br.com.fiap.postechfasfood.apis.responses.PedidoWebHandlerResponse;
import br.com.fiap.postechfasfood.gateways.PedidoGateway;
import br.com.fiap.postechfasfood.gateways.ProdutoGateway;
import br.com.fiap.postechfasfood.interfaces.DbConnection;
import br.com.fiap.postechfasfood.interfaces.PedidoRepositoryInterface;
import br.com.fiap.postechfasfood.interfaces.ProdutoRepositoryInterface;
import br.com.fiap.postechfasfood.usecases.PedidoUseCase;
import br.com.fiap.postechfastfood_old.infrastructure.persistence.jpa.repositories.ProdutoRepository;

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
}
