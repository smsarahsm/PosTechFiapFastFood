package br.com.fiap.postechfasfood.apis.responses;

import br.com.fiap.postechfasfood.entities.ItensPedidoVO;
import br.com.fiap.postechfasfood.entities.PedidoVO;
import br.com.fiap.postechfasfood.types.TipoStatusPedidoEnum;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record PedidosWebHandlerResponse(
        String cdPedido,
        TipoStatusPedidoEnum txStatus,
        int nrPedido,
        LocalDateTime dhCriacaoPedido,
        List<ItensPedidoVO> itens
) {
    public PedidosWebHandlerResponse (PedidoVO pedidoVO) {
        this(pedidoVO.getCdPedido(), pedidoVO.getTxStatus(), pedidoVO.getNrPedido(), pedidoVO.getDhCriacaoPedido(), pedidoVO.getItens());
    }
}
