package br.com.fiap.postechfasfood.externals;

import br.com.fiap.postechfasfood.entities.PagamentoVO;
import br.com.fiap.postechfasfood.interfaces.PagamentoRepositoryInterface;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PagamentoRepository implements PagamentoRepositoryInterface {

    private final NamedParameterJdbcTemplate namedJdbcTemplate;

    public PagamentoRepository(NamedParameterJdbcTemplate namedJdbcTemplate) {
        this.namedJdbcTemplate = namedJdbcTemplate;
    }

    @Override
    public PagamentoVO salvarPagamento(PagamentoVO pagamento) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("cdPagamento", pagamento.getCdPagamento());
        params.addValue("cdPedido", pagamento.getCdPedido());
        params.addValue("vlPagamento", pagamento.getVlPagamento());
        params.addValue("tpStatus", pagamento.getTpStatus());

        String sql = "INSERT INTO tb_pagamentos (cd_pagamento, cd_pedido, vl_pagamento, tp_status) " +
                "VALUES (:cdPagamento, :cdPedido, :vlPagamento, :tpStatus)";
        namedJdbcTemplate.update(sql, params);
        return pagamento;
    }
}
