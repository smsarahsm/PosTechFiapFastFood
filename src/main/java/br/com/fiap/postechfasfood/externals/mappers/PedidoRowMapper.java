package br.com.fiap.postechfasfood.externals.mappers;

import br.com.fiap.postechfasfood.entities.PedidoVO;
import br.com.fiap.postechfasfood.types.TipoStatusPedidoEnum;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.UUID;

public class PedidoRowMapper implements RowMapper<PedidoVO> {
    @Override
    public PedidoVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new PedidoVO.Builder()
                .setCdPedido(rs.getObject("cd_pedido", UUID.class))
                .setCdDocCliente(rs.getString("cd_doc_cliente"))
                .setCdDocFuncionario(rs.getString("cd_doc_funcionario"))
                .setTxStatus(TipoStatusPedidoEnum.valueOf(rs.getString("tx_status")))
                .setNrPedido(rs.getInt("nr_pedido"))
                .setDhCriacaoPedido(rs.getObject("dh_criacao_pedido", LocalDateTime.class))
                .setDhUltAtualizacao(rs.getObject("dh_ultima_atualizacao", LocalDateTime.class))
                .build();
    }
}
