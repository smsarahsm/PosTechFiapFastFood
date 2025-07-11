package br.com.fiap.postechfasfood.apis.requests;

import br.com.fiap.postechfasfood.entities.ItensPedidoVO;

import java.util.List;

public record PedidoWebHandlerRequest(
    String cdDocCliente,
    List<ItensPedidoVO> itens
) {
}
