package br.com.fiap.postechfasfood.interfaces;

import br.com.fiap.postechfasfood.entities.PagamentoVO;
import br.com.fiap.postechfasfood.entities.PedidoVO;
import br.com.fiap.postechfasfood.gateways.PagamentoGateway;

public interface PagamentoGatewayInterface {
    PedidoVO getPedido(int nrPedido);
    PagamentoVO realizaPagamento(PagamentoVO pagamentoVO);
}
