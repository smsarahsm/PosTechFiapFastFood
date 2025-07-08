package br.com.fiap.postechfasfood.externals;

import br.com.fiap.postechfasfood.entities.ProdutoVO;
import br.com.fiap.postechfasfood.externals.mappers.ProdutoRowMapper;
import br.com.fiap.postechfasfood.interfaces.ProdutoRepositoryInterface;
import br.com.fiap.postechfasfood.types.TipoCategoriaProdutoEnum;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ProdutoRepository implements ProdutoRepositoryInterface {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ProdutoRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void cadastrar(ProdutoVO produto) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("cdProduto", produto.getCdProduto());
        params.addValue("nmProduto", produto.getNmProduto());
        params.addValue("dsDescricao", produto.getDsDescricao());
        params.addValue("vlPreco", produto.getVlPreco());
        params.addValue("snAtivo", produto.getSnAtivo());
        params.addValue("tpCategoria", produto.getTpCategoria());

        String sql = "INSERT INTO tb_produtos (cd_produto, nm_produto, ds_descricao, vl_preco, sn_ativo, tp_categoria) " +
                "VALUES (:cdProduto, :nmProduto, :dsDescricao, :vlPreco, :snAtivo, :tpCategoria)";
        namedParameterJdbcTemplate.update(sql, params);
    }

    @Override
    public void atualizar(UUID cdProduto, ProdutoVO produto) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("cdProduto", cdProduto);
        params.addValue("nmProduto", produto.getNmProduto());
        params.addValue("dsDescricao", produto.getDsDescricao());
        params.addValue("vlPreco", produto.getVlPreco());
        params.addValue("snAtivo", produto.getSnAtivo());
        params.addValue("tpCategoria", produto.getTpCategoria());

        String sql = "UPDATE tb_produtos SET " +
                "nm_produto = :cdProduto, " +
                "ds_descricao = :dsDescricao, " +
                "vl_preco = :vlPreco, " +
                "sn_ativo = :snAtivo, " +
                "tp_categoria = :tpCategoria " +
                "WHERE cd_produto = :cdProduto";
        namedParameterJdbcTemplate.update(sql, params);
    }

    @Override
    public void desativar(UUID cdProduto) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("cdProduto", cdProduto);
        params.addValue("snAtivo", false);

        String sql = "UPDATE tb_produtos SET " +
                "sn_ativo = :snAtivo " +
                "WHERE cd_produto = :cdProduto";
        namedParameterJdbcTemplate.update(sql, params);
    }

    @Override
    public void ativar(UUID cdProduto) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("cdProduto", cdProduto);
        params.addValue("snAtivo", true);

        String sql = "UPDATE tb_produtos SET " +
                "sn_ativo = :snAtivo " +
                "WHERE cd_produto = :cdProduto";
        namedParameterJdbcTemplate.update(sql, params);
    }

    @Override
    public List<ProdutoVO> listar() {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("snAtivo", true);

        String sql = "SELECT cd_produto, " +
                "nm_produto, " +
                "ds_descricao, " +
                "vl_preco, " +
                "sn_ativo, " +
                "tp_categoria " +
                "FROM tb_produtos " +
                "WHERE sn_ativo = :snAtivo";
        return namedParameterJdbcTemplate.query(sql, params, new ProdutoRowMapper());
    }

    @Override
    public List<ProdutoVO> listar(TipoCategoriaProdutoEnum tpCategoria) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("snAtivo", true);
        params.addValue("tpCategoria", tpCategoria);

        String sql = "SELECT cd_produto, " +
                "nm_produto, " +
                "ds_descricao, " +
                "vl_preco, " +
                "sn_ativo, " +
                "tp_categoria " +
                "FROM tb_produtos " +
                "WHERE sn_ativo = :snAtivo " +
                "AND tp_categoria = :tpCategoria";
        return namedParameterJdbcTemplate.query(sql, params, new ProdutoRowMapper());
    }

    @Override
    public ProdutoVO buscarPorCdProduto(UUID cdProduto) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("cdProduto", cdProduto);

        String sql = "SELECT cd_produto, " +
                "nm_produto, " +
                "ds_descricao, " +
                "vl_preco, " +
                "sn_ativo, " +
                "tp_categoria " +
                "FROM tb_produtos " +
                "WHERE cd_produto = :cdProduto";
        return namedParameterJdbcTemplate.queryForObject(sql, params, new ProdutoRowMapper());
    }
}
