package br.com.fiap.postechfasfood.apis.responses;

import br.com.fiap.postechfasfood.entities.PedidoVO;
import br.com.fiap.postechfasfood.types.TipoStatusPedidoEnum;

public record PedidoPorStatusWebHandlerResponse(
        TipoStatusPedidoEnum txStatus
) {
    public PedidoPorStatusWebHandlerResponse(PedidoVO pedidoVO) {
        this(pedidoVO.getTxStatus());
    }
}
