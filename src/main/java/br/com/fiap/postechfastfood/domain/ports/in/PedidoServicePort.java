package br.com.fiap.postechfastfood.domain.ports.in;

import br.com.fiap.postechfastfood.domain.models.PedidoModel;

public interface PedidoServicePort {
    PedidoModel criar(PedidoModel pedido);
}
