package br.com.fiap.postechfasfood.adapters;

import br.com.fiap.postechfasfood.apis.responses.PedidoAtualizadoWebHandlerResponse;
import br.com.fiap.postechfasfood.apis.responses.PedidoPorStatusWebHandlerResponse;
import br.com.fiap.postechfasfood.apis.responses.PedidoWebHandlerResponse;
import br.com.fiap.postechfasfood.apis.responses.PedidosWebHandlerResponse;
import br.com.fiap.postechfasfood.entities.PedidoVO;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoWebHandlerAdapter {
    public PedidoWebHandlerResponse toResponseDto(PedidoVO pedidoVO) { return new PedidoWebHandlerResponse(pedidoVO); }

    public PedidoPorStatusWebHandlerResponse toResponsePorStatusDto(PedidoVO pedidoVO) { return new PedidoPorStatusWebHandlerResponse(pedidoVO); }

    public PedidoAtualizadoWebHandlerResponse toResponsePedidoAtualizadoDto(PedidoVO pedidoVO) { return new PedidoAtualizadoWebHandlerResponse(pedidoVO); }

    public PedidosWebHandlerResponse toResponsePedidos(PedidoVO pedidosVO) { return new PedidosWebHandlerResponse(pedidosVO);  }

    public List<PedidosWebHandlerResponse> toResponsePedidosDto(List<PedidoVO> pedidosVO) {
        return pedidosVO.stream().map(this::toResponsePedidos).collect(Collectors.toList());
    }
}
