package br.com.fiap.postechfasfood.interfaces;

import br.com.fiap.postechfasfood.entities.PedidoVO;
import br.com.fiap.postechfasfood.entities.ProdutosPedidoVO;
import br.com.fiap.postechfasfood.types.TipoStatusPedidoEnum;

import java.util.List;
import java.util.UUID;

public interface PedidoRepositoryInterface {
    PedidoVO cadastrarPedido(PedidoVO pedidoModel);

    PedidoVO buscarPorCdPedido(UUID cdPedido);

    PedidoVO buscarPorStatusPedido(UUID cdPedido);

    List<PedidoVO> listarTodosPedidos();

    void removerPedido(UUID cdPedido);

    PedidoVO atualizarStatusPedido(UUID cdPedido, TipoStatusPedidoEnum txStatus);

    List<PedidoVO> buscarPedidosPorStatus(TipoStatusPedidoEnum txStatus);

    ProdutosPedidoVO cadastrarProdutosPedido(ProdutosPedidoVO produtosPedidoModel);

    int buscarUltimoNumeroPedido();

    PedidoVO buscarPorNumeroPedido(int nrPedido);
}
