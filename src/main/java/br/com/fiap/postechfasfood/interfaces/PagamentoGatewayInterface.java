package br.com.fiap.postechfasfood.interfaces;

import br.com.fiap.postechfasfood.entities.PagamentoVO;

public interface PagamentoGatewayInterface {
    PagamentoVO salvarPagamento(PagamentoVO pagamentoVO);
}
