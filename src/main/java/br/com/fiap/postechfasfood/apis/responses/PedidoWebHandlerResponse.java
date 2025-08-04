package br.com.fiap.postechfasfood.apis.responses;

import br.com.fiap.postechfasfood.entities.ItensPedidoVO;
import br.com.fiap.postechfasfood.entities.PedidoVO;
import br.com.fiap.postechfasfood.types.TipoStatusPedidoEnum;

import java.util.List;

public record PedidoWebHandlerResponse(
        int nrPedido,
        TipoStatusPedidoEnum txStatus
) {
    public PedidoWebHandlerResponse(PedidoVO pedidoVO) {
        this(pedidoVO.getNrPedido(), pedidoVO.getTxStatus());
    }
}
