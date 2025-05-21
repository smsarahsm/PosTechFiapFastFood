package br.com.fiap.postechfastfood.domain.ports.out;

import br.com.fiap.postechfastfood.domain.enums.TipoProdutoStatusEnum;
import br.com.fiap.postechfastfood.domain.models.PedidoModel;
import br.com.fiap.postechfastfood.domain.models.ProdutosPedidoModel;

import java.util.List;
import java.util.UUID;

public interface PedidoRepositoryPort {

    PedidoModel cadastrarPedido(PedidoModel pedidoModel);

    List<PedidoModel> listarTodosPedidos();

    void removerPedido(UUID cdPedido);

    PedidoModel atualizarStatusPedido(UUID cdPedido, TipoProdutoStatusEnum status);

    List<PedidoModel> buscarPedidosPorStatus(TipoProdutoStatusEnum status);

    ProdutosPedidoModel cadastrarProdutosPedido(ProdutosPedidoModel produtosPedidoModel);
}