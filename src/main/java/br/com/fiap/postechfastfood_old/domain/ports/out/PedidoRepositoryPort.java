package br.com.fiap.postechfastfood_old.domain.ports.out;

import br.com.fiap.postechfastfood_old.domain.enums.TipoStatusPedidoEnum;
import br.com.fiap.postechfastfood_old.domain.models.PedidoModel;
import br.com.fiap.postechfastfood_old.domain.models.ProdutosPedidoModel;

import java.util.List;
import java.util.UUID;

public interface PedidoRepositoryPort {

    PedidoModel cadastrarPedido(PedidoModel pedidoModel);

    List<PedidoModel> listarTodosPedidos();

    void removerPedido(UUID cdPedido);

    PedidoModel atualizarStatusPedido(UUID cdPedido, TipoStatusPedidoEnum status);

    List<PedidoModel> buscarPedidosPorStatus(TipoStatusPedidoEnum status);

    ProdutosPedidoModel cadastrarProdutosPedido(ProdutosPedidoModel produtosPedidoModel);
    int buscarUltimoNumeroPedido();
}