package br.com.fiap.postechfasfood.externals;

import br.com.fiap.postechfasfood.entities.ItensPedidoVO;
import br.com.fiap.postechfasfood.entities.PedidoVO;
import br.com.fiap.postechfasfood.entities.ProdutosPedidoVO;
import br.com.fiap.postechfasfood.externals.mappers.PedidoRowMapper;
import br.com.fiap.postechfasfood.interfaces.PedidoRepositoryInterface;
import br.com.fiap.postechfasfood.types.TipoStatusPedidoEnum;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class PedidoRepository implements PedidoRepositoryInterface {

    private final NamedParameterJdbcTemplate namedJdbcTemplate;
    private final JdbcTemplate jdbcTemplate;

    private static final String SELECT_TB_PEDIDOS = "SELECT cd_pedido, cd_doc_cliente, cd_doc_funcionario, tx_status, nr_pedido, dh_criacao_pedido, dh_ult_atualizacao FROM tb_pedidos";

    public PedidoRepository(NamedParameterJdbcTemplate namedJdbcTemplate,
                            JdbcTemplate jdbcTemplate) {
        this.namedJdbcTemplate = namedJdbcTemplate;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public PedidoVO cadastrarPedido(PedidoVO pedidoModel) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("cdPedido", pedidoModel.getCdPedido());
        params.addValue("cdDocCliente", pedidoModel.getCdDocCliente());
        params.addValue("cdDocFuncionario", pedidoModel.getCdDocFuncionario());
        params.addValue("txStatus", pedidoModel.getTxStatus().name());
        params.addValue("nrPedido", pedidoModel.getNrPedido());
        params.addValue("dhCriacaoPedido", pedidoModel.getDhCriacaoPedido());
        params.addValue("dhUltAtualizacao", pedidoModel.getDhUltAtualizacao());

        String sql = "INSERT INTO tb_pedidos (cd_pedido, cd_doc_cliente, cd_doc_funcionario, tx_status, nr_pedido, dh_criacao_pedido, dh_ult_atualizacao) " +

                "VALUES (:cdPedido, :cdDocCliente, :cdDocFuncionario, :txStatus, :nrPedido, :dhCriacaoPedido, :dhUltAtualizacao)";

        this.namedJdbcTemplate.update(sql, params);
        return pedidoModel;
    }

    @Override
    public PedidoVO buscarPorCdPedido(String cdPedido) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("cdPedido", cdPedido);

        String sql = SELECT_TB_PEDIDOS + " WHERE cd_pedido = :cdPedido";
        try {
            return namedJdbcTemplate.queryForObject(sql, params, new PedidoRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    @Override
    public PedidoVO buscarPorStatusPedido(String cdPedido) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("cdPedido", cdPedido);

        String sql = SELECT_TB_PEDIDOS + " WHERE cd_pedido = :cdPedido";
        try {
            PedidoVO pedido = namedJdbcTemplate.queryForObject(sql, params, new PedidoRowMapper());
            String sqlItens = "SELECT cd_produto, vl_qtd FROM tb_pedidos_produtos WHERE cd_pedido = :cdPedido";
            List<ItensPedidoVO> itens = namedJdbcTemplate.query(sqlItens, params, (rs, rowNum) ->
                    new ItensPedidoVO(
                            rs.getString("cd_produto"),
                            rs.getInt("vl_qtd")
                    )
            );
            pedido.setItens(itens);
            return pedido;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    @Override
    public List<PedidoVO> listarTodosPedidos() {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("listaStatus", List.of(
                TipoStatusPedidoEnum.PRONTO.name(),
                TipoStatusPedidoEnum.EM_PREPARACAO.name(),
                TipoStatusPedidoEnum.RECEBIDO.name()
        ));
        String sql = SELECT_TB_PEDIDOS + " WHERE tx_status IN (:listaStatus) " +
                "ORDER BY " +
                "  CASE tx_status " +
                "    WHEN 'PRONTO' THEN 1 " +
                "    WHEN 'EM_PREPARACAO' THEN 2 " +
                "    WHEN 'RECEBIDO' THEN 3 " +
                "    ELSE 4 " +
                "  END, " +
                "dh_criacao_pedido ASC";
        List<PedidoVO> pedidos = namedJdbcTemplate.query(sql, params, new PedidoRowMapper());
        for (PedidoVO pedido : pedidos) {
            pedido.setItens(this.buscarPorStatusPedido(pedido.getCdPedido()).getItens());
        }
        return pedidos;
    }

    @Override
    public void removerPedido(String cdPedido) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("cdPedido", cdPedido);
        String sql = "DELETE FROM tb_pedidos WHERE cd_pedido = :cdPedido";
        this.namedJdbcTemplate.update(sql, params);
    }

    @Override
    public PedidoVO atualizarStatusPedido(String cdPedido, TipoStatusPedidoEnum txStatus) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("cdPedido", cdPedido);
        params.addValue("txStatus", txStatus.name());
        String sql = "UPDATE tb_pedidos SET tx_status = :txStatus WHERE cd_pedido = :cdPedido";
        this.namedJdbcTemplate.update(sql, params);
        return this.buscarPorStatusPedido(cdPedido);
    }

    @Override
    public List<PedidoVO> buscarPedidosPorStatus(TipoStatusPedidoEnum txStatus) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("txStatus", txStatus.name());
        String sql = SELECT_TB_PEDIDOS + " WHERE tx_status = :txStatus ORDER BY dh_criacao_pedido ASC";
        return namedJdbcTemplate.query(sql, params, new PedidoRowMapper());
    }

    @Override
    public ProdutosPedidoVO cadastrarProdutosPedido(ProdutosPedidoVO produtosPedidoModel) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("cdPedido", produtosPedidoModel.getPedido().getCdPedido());
        params.addValue("cdProduto", produtosPedidoModel.getProduto().getCdProduto());
        params.addValue("vlQtd", produtosPedidoModel.getVlQuantidade());

        String sql = "INSERT INTO tb_pedidos_produtos (cd_pedido, cd_produto, vl_qtd) " +
                "VALUES (:cdPedido, :cdProduto, :vlQtd)";
        namedJdbcTemplate.update(sql, params);
        return produtosPedidoModel;
    }

    @Override
    public int buscarUltimoNumeroPedido() {
        String sql = "SELECT MAX(nr_pedido) FROM tb_pedidos";
        Integer ultimoPedido = jdbcTemplate.queryForObject(sql, Integer.class);
        return ultimoPedido != null ? ultimoPedido : 0;
    }

    public PedidoVO buscarPorNumeroPedido(int nrPedido) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("nrPedido", nrPedido);
        String sql = SELECT_TB_PEDIDOS + " WHERE nr_pedido = :nrPedido";
        List<PedidoVO> pedidos = namedJdbcTemplate.query(sql, params, new PedidoRowMapper());
        return pedidos.isEmpty() ? null : pedidos.get(0);
    }
}
