package br.com.fiap.postechfasfood.controllers;

import br.com.fiap.postechfasfood.apis.requests.PedidoWebHandlerRequest;
import br.com.fiap.postechfasfood.gateways.PedidoGateway;
import br.com.fiap.postechfasfood.interfaces.DbConnection;

public class PedidoController {

    public T criarPedido(DbConnection dbConnection, PedidoWebHandlerRequest pedidoWebHandlerRequest) {
        PedidoGateway pedidoGateway = new PedidoGateway(dbConnection);

    }
}
