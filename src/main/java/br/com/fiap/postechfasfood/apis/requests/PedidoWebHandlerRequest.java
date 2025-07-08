package br.com.fiap.postechfasfood.apis.requests;

import java.util.List;
//TODO criar a classe de itens do pedido
public record PedidoWebHandlerRequest(
    String cdDocCliente,
    List<String> itens
) {
}
