package br.com.fiap.postechfasfood.usecases;

import br.com.fiap.postechfasfood.entities.PagamentoVO;
import br.com.fiap.postechfasfood.gateways.PagamentoGateway;

public class PagamentoUseCase {
    private final PagamentoGateway pagamentoGateway;

    public PagamentoUseCase(PagamentoGateway pagamentoGateway) {
        this.pagamentoGateway = pagamentoGateway;
    }


    public PagamentoVO realizarPagamento(int nrPedido) {
        //TODO fazer select no banco para pedidos
        //pagamentoGateway.getPedido(nrPedido);

        var pagamento = new PagamentoVO(
                "reference_12345",
                "Product order",
                "Purchase description.",
                "Purchase description.",
                100
        );

        return pagamentoGateway.realizaPagamento(pagamento);
    }
}
