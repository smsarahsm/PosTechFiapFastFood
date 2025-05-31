package br.com.fiap.postechfastfood.domain.ports.in;

import br.com.fiap.postechfastfood.domain.enums.TipoStatusPedidoEnum;
import br.com.fiap.postechfastfood.domain.models.PedidoModel;

import java.util.List;
import java.util.UUID;

public interface PedidoServicePort {
    PedidoModel criar(PedidoModel pedido);
    PedidoModel atualizar(UUID cdPedido, PedidoModel pedido);
    PedidoModel atualizaStatus(UUID cdPedido, TipoStatusPedidoEnum status);
    void deletar(UUID cdPedido);
    List<PedidoModel> buscar();
    List<PedidoModel> buscarPorStatus(TipoStatusPedidoEnum status);
}
