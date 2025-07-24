package br.com.fiap.postechfasfood.interfaces;

import br.com.fiap.postechfasfood.entities.PagamentoVO;

public interface PagamentoRepositoryInterface {
    PagamentoVO salvarPagamento(PagamentoVO pagamento);
}
