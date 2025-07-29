package br.com.fiap.postechfasfood.usecases;

import br.com.fiap.postechfasfood.entities.PagamentoVO;
import br.com.fiap.postechfasfood.externals.dto.ItemMercadoPagoDTO;
import br.com.fiap.postechfasfood.externals.dto.MercadoPagoExternalApiRequestDTO;
import br.com.fiap.postechfasfood.gateways.PagamentoGateway;

import java.util.List;
import java.util.UUID;

public class PagamentoUseCase {
    private final PagamentoGateway pagamentoGateway;

    public PagamentoUseCase(PagamentoGateway pagamentoGateway) {
        this.pagamentoGateway = pagamentoGateway;
    }


    public PagamentoVO realizarPagamento(int nrPedido) {
        var pedido = pagamentoGateway.getPedido(nrPedido);
        var produtosPedidos = pagamentoGateway.buscarProdutoPedido(pedido);
        return pagamentoGateway.realizaPagamento(produtosPedidos);
    }
}
