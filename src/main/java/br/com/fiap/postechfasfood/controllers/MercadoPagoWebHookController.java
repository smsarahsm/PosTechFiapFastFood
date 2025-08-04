package br.com.fiap.postechfasfood.controllers;

import br.com.fiap.postechfasfood.gateways.PagamentoGateway;
import br.com.fiap.postechfasfood.gateways.PedidoGateway;
import br.com.fiap.postechfasfood.interfaces.PagamentoRepositoryInterface;
import br.com.fiap.postechfasfood.interfaces.PedidoRepositoryInterface;
import br.com.fiap.postechfasfood.usecases.PagamentoUseCase;

import java.io.IOException;

public class MercadoPagoWebHookController {
    public void processarNotificacao(PedidoRepositoryInterface pedidoRepository,
                                     PagamentoRepositoryInterface pagamentoRepository,
                                     String payload,
                                     int nrPedido) throws IOException {
        PedidoGateway pedidoGateway = new PedidoGateway(pedidoRepository);
        PagamentoGateway pagamentoGateway = new PagamentoGateway(pagamentoRepository);

        PagamentoUseCase pagamentoUseCase = new PagamentoUseCase(pedidoGateway, pagamentoGateway);
        pagamentoUseCase.processarNotificacao(nrPedido, payload);
    }
}
