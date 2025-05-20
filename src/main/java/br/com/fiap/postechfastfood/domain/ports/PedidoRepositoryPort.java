package br.com.fiap.postechfastfood.domain.ports;

import br.com.fiap.postechfastfood.domain.enums.TipoProdutoStatusEnum;
import br.com.fiap.postechfastfood.domain.models.PedidoModel;

import java.util.List;
import java.util.UUID;

public interface PedidoRepositoryPort {

    PedidoModel cadastrarPedido(PedidoModel pedidoModel);

    List<PedidoModel> listarTodosPedidos();

    void removerPedido(UUID cdPedido);

    PedidoModel atualizarStatusPedido(UUID cdPedido, TipoProdutoStatusEnum status);

    List<PedidoModel> buscarPedidosPorStatus(TipoProdutoStatusEnum status);
}