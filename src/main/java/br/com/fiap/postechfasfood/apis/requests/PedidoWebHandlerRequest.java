package br.com.fiap.postechfasfood.apis.requests;

import br.com.fiap.postechfasfood.entities.ItensPedidoVO;
import br.com.fiap.postechfasfood.types.TipoStatusPedidoEnum;

import java.time.LocalDateTime;
import java.util.List;
//TODO rever se aqui temos um vo ou outro webHandlerRequest
public record PedidoWebHandlerRequest(
    String cdDocCliente,
    String cdDocFuncionario,
    TipoStatusPedidoEnum txStatus,
    int nrPedido,
    LocalDateTime dhCriacaoPedido,
    LocalDateTime dhUltAtualizacao,
    List<ItensPedidoVO> itens
) {
}
