package br.com.fiap.postechfasfood.adapters;

import br.com.fiap.postechfasfood.apis.responses.PedidoWebHandlerResponse;
import br.com.fiap.postechfasfood.entities.PedidoVO;

public class PedidoWebHandlerAdapter {
    public PedidoWebHandlerResponse toResponseDto(PedidoVO pedidoVO) { return new PedidoWebHandlerResponse(pedidoVO); }
}
