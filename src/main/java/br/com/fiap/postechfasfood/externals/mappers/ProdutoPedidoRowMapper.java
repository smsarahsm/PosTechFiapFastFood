package br.com.fiap.postechfasfood.externals.mappers;

import br.com.fiap.postechfasfood.entities.PedidoVO;
import br.com.fiap.postechfasfood.entities.ProdutoVO;
import br.com.fiap.postechfasfood.entities.ProdutosPedidoVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoPedidoRowMapper implements RowMapper<ProdutosPedidoVO> {
    @Override
    public ProdutosPedidoVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        /*return new ProdutosPedidoVO.Builder()
                .setPedido(rs.getObject("tb_pedidos_produtos.cd_pedido", PedidoVO.class))
                .setProduto(rs.getObject("tb_pedidos_produtos.cd_produto", ProdutoVO.class))
                .vlQuantidade(rs.getInt("vl_qtd"))
                .build();*/
        return null;
    }
}
