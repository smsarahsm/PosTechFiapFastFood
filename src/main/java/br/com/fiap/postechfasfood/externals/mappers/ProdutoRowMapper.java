package br.com.fiap.postechfasfood.externals.mappers;

import br.com.fiap.postechfasfood.types.TipoCategoriaProdutoEnum;
import br.com.fiap.postechfasfood.entities.ProdutoVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class ProdutoRowMapper implements RowMapper<ProdutoVO> {
    @Override
    public ProdutoVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ProdutoVO.Builder()
                .setCdProduto(rs.getString("cd_produto"))
                .setNmProduto(rs.getString("nm_produto"))
                .setDsDescricao(rs.getString("ds_descricao"))
                .setVlPreco(rs.getDouble("vl_preco"))
                .setSnAtivo(rs.getBoolean("sn_ativo"))
                .setTpCategoria(TipoCategoriaProdutoEnum.valueOf(rs.getString("tp_categoria")))
                .build();
    }
}
