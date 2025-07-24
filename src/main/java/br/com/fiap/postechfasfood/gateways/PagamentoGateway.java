package br.com.fiap.postechfasfood.gateways;

import br.com.fiap.postechfasfood.entities.PagamentoVO;
import br.com.fiap.postechfasfood.entities.PedidoVO;
import br.com.fiap.postechfasfood.interfaces.PagamentoGatewayInterface;
import br.com.fiap.postechfasfood.interfaces.PagamentoRepositoryInterface;

public class PagamentoGateway implements PagamentoGatewayInterface {

    private final PagamentoRepositoryInterface pagamentoRepository;

    public PagamentoGateway(PagamentoRepositoryInterface pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    @Override
    public PedidoVO getPedido(int nrPedido) {
        return null;
    }

    @Override
    public PagamentoVO realizaPagamento(PagamentoVO pagamentoVO) {
        return pagamentoRepository.realizaPagamento(pagamentoVO);
    }
}
