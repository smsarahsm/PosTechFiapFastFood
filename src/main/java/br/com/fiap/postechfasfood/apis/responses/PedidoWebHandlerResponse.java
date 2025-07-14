package br.com.fiap.postechfasfood.apis.responses;

import br.com.fiap.postechfasfood.entities.ItensPedidoVO;
import br.com.fiap.postechfasfood.entities.PedidoVO;

import java.util.List;

public record PedidoWebHandlerResponse(
        String cdDocCliente,
        List<ItensPedidoVO> itens
) {
    public PedidoWebHandlerResponse(PedidoVO pedidoVO) {
        this(pedidoVO.getCdDocCliente(), pedidoVO.getItens());
    }
}
