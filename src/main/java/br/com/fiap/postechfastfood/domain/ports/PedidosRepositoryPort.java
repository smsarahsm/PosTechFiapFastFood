package br.com.fiap.postechfastfood.domain.ports;

import br.com.fiap.postechfastfood.domain.enums.TipoProdutoStatusEnum;
import br.com.fiap.postechfastfood.domain.models.PedidosModel;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.PedidoRequestDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PedidosRepositoryPort {

    PedidosModel cadastrarPedido(PedidosModel pedidoModel);

    List<PedidosModel> listarTodosPedidos();

    void removerPedido(UUID cdPedido);

    PedidosModel atualizarStatusPedido(UUID cdPedido, TipoProdutoStatusEnum status);

    List<PedidosModel> buscarPedidosPorStatus(TipoProdutoStatusEnum status);
}