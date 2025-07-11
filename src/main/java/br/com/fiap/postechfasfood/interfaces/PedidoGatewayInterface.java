package br.com.fiap.postechfasfood.interfaces;

import br.com.fiap.postechfasfood.entities.PedidoVO;
import br.com.fiap.postechfasfood.entities.ProdutosPedidoVO;

public interface PedidoGatewayInterface {
    PedidoVO cadastrar(PedidoVO pedidoVO);

    ProdutosPedidoVO cadastrarProdutoPedido(ProdutosPedidoVO pedidoVO);

    int buscarUltimoNumeroPedido();
}
