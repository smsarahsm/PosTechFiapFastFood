package br.com.fiap.postechfasfood.externals.mappers;

import br.com.fiap.postechfasfood.entities.PessoaVO;
import br.com.fiap.postechfasfood.types.TipoPessoaEnum;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaRowMapper implements RowMapper<PessoaVO> {
    @Override
    public PessoaVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new PessoaVO.Builder()
                .setCdDocPessoa(rs.getString("cd_doc_pessoa"))
                .setNmPessoa(rs.getString("nm_pessoa"))
                .setTpPessoa(TipoPessoaEnum.valueOf(rs.getString("tp_pessoa")))
                .setDsEmail(rs.getString("ds_email"))
                .build();
    }
}
