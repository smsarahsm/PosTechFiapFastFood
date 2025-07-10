package br.com.fiap.postechfasfood.externals;

import br.com.fiap.postechfasfood.entities.PessoaVO;
import br.com.fiap.postechfasfood.externals.mappers.PessoaRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PessoaRepository implements br.com.fiap.postechfasfood.interfaces.PessoaRepositoryInterface {

    private final NamedParameterJdbcTemplate namedJdbcTemplate;

    private static final String SELECT_TB_PESSOAS = "SELECT cd_doc_pessoa, nm_pessoa, tp_pessoa, ds_email FROM tb_pessoas";

    public PessoaRepository(NamedParameterJdbcTemplate namedJdbcTemplate) {
        this.namedJdbcTemplate = namedJdbcTemplate;
    }

    @Override
    public void criarPessoa(PessoaVO pessoa) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("cdDocPessoa", pessoa.getCdDocPessoa());
        params.addValue("nmPessoa", pessoa.getNmPessoa());
        params.addValue("tpPessoa", pessoa.getTpPessoa().name());
        params.addValue("dsEmail", pessoa.getDsEmail());

        String sql = "INSERT INTO tb_pessoas (cd_doc_pessoa, nm_pessoa, tp_pessoa, ds_email) " +
                "VALUES (:cdDocPessoa, :nmPessoa, :tpPessoa, :dsEmail)";
        namedJdbcTemplate.update(sql, params);
    }

    @Override
    public PessoaVO buscarPessoaPorCpf(String cdDocPessoa) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("cdDocPessoa", cdDocPessoa);

        String sql = SELECT_TB_PESSOAS + " WHERE cd_doc_pessoa = :cdDocPessoa";
        try {
            return namedJdbcTemplate.queryForObject(sql, params, new PessoaRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<PessoaVO> listarTodasPessoas() {
        return namedJdbcTemplate.query(SELECT_TB_PESSOAS, new PessoaRowMapper());
    }

    @Override
    public void removerPessoa(String cdDocPessoa) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("cdDocPessoa", cdDocPessoa);

        String sql = "DELETE FROM tb_pessoas WHERE cd_doc_pessoa = :cdDocPessoa";
        namedJdbcTemplate.update(sql, params);
    }
}
