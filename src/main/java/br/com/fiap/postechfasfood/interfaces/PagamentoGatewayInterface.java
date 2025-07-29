package br.com.fiap.postechfasfood.interfaces;

import br.com.fiap.postechfasfood.entities.PagamentoVO;
import br.com.fiap.postechfasfood.entities.ProdutosPedidoVO;
import br.com.fiap.postechfasfood.externals.dto.MercadoPagoExternalApiRequestDTO;
import br.com.fiap.postechfasfood.entities.PedidoVO;

import java.util.List;
import java.util.UUID;

public interface PagamentoGatewayInterface {
    PedidoVO getPedido(int nrPedido);
    PagamentoVO realizaPagamento(List<ProdutosPedidoVO> produtosPedidoVO);
    List<ProdutosPedidoVO> buscarProdutoPedido(PedidoVO pedidoVO);
}
