package br.com.fiap.postechfasfood.interfaces;

import br.com.fiap.postechfasfood.entities.PagamentoVO;
import br.com.fiap.postechfasfood.entities.ProdutosPedidoVO;

import java.util.List;

public interface PagamentoClientInterface {
    PagamentoVO realizaPagamento(List<ProdutosPedidoVO> produtosPedidoVO);
}
