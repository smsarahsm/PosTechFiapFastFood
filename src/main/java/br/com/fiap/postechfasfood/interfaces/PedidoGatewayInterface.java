package br.com.fiap.postechfasfood.interfaces;

import br.com.fiap.postechfasfood.entities.PedidoVO;
import br.com.fiap.postechfasfood.entities.ProdutosPedidoVO;
import br.com.fiap.postechfasfood.types.TipoStatusPedidoEnum;

import java.util.List;
import java.util.UUID;

public interface PedidoGatewayInterface {
    PedidoVO cadastrar(PedidoVO pedidoVO);

    ProdutosPedidoVO cadastrarProdutoPedido(ProdutosPedidoVO pedidoVO);

    int buscarUltimoNumeroPedido();

    PedidoVO buscarPorNumeroPedido(int nrPedido);

    PedidoVO buscarPorStatusPedido(String cdPedido);

    PedidoVO atualizarStatusPedido(String cdPedido, TipoStatusPedidoEnum novoStatus);

    List<PedidoVO> listarTodosPedidos();
}
