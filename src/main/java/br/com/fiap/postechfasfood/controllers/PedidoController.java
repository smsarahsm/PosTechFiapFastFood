package br.com.fiap.postechfasfood.controllers;

import br.com.fiap.postechfasfood.adapters.PedidoWebHandlerAdapter;
import br.com.fiap.postechfasfood.apis.requests.PedidoWebHandlerRequest;
import br.com.fiap.postechfasfood.apis.responses.PedidoWebHandlerResponse;
import br.com.fiap.postechfasfood.gateways.PedidoGateway;
import br.com.fiap.postechfasfood.interfaces.DbConnection;
import br.com.fiap.postechfasfood.interfaces.PedidoRepositoryInterface;
import br.com.fiap.postechfasfood.usecases.PedidoUseCase;

public class PedidoController {

    public PedidoWebHandlerResponse criarPedido(PedidoRepositoryInterface pedidoRepository, PedidoWebHandlerRequest pedidoWebHandlerRequest) {
        PedidoGateway pedidoGateway = new PedidoGateway(pedidoRepository);
        PedidoUseCase pedidoUseCase = new PedidoUseCase(pedidoGateway);
        var pedidoCriado = pedidoUseCase.criarPedido(pedidoWebHandlerRequest);
        final PedidoWebHandlerAdapter pedidoWebHandlerAdapter = new PedidoWebHandlerAdapter();
        return pedidoWebHandlerAdapter.toResponseDto(pedidoCriado);
    }
}
