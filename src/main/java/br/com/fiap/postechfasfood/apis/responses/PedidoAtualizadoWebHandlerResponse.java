package br.com.fiap.postechfasfood.apis.responses;

import br.com.fiap.postechfasfood.entities.ItensPedidoVO;
import br.com.fiap.postechfasfood.entities.PedidoVO;
import br.com.fiap.postechfasfood.types.TipoStatusPedidoEnum;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record PedidoAtualizadoWebHandlerResponse(
        String cdPedido,
        TipoStatusPedidoEnum txStatus,
        int nrPedido,
        List<ItensPedidoVO> itens
) {
    public PedidoAtualizadoWebHandlerResponse(PedidoVO pedidoVO) {
        this(pedidoVO.getCdPedido(), pedidoVO.getTxStatus(), pedidoVO.getNrPedido(), pedidoVO.getItens());
    }
}
