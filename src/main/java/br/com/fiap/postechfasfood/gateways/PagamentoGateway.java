package br.com.fiap.postechfasfood.gateways;

import br.com.fiap.postechfasfood.entities.PagamentoVO;
import br.com.fiap.postechfasfood.interfaces.PagamentoGatewayInterface;
import br.com.fiap.postechfasfood.interfaces.PagamentoRepositoryInterface;
import org.springframework.stereotype.Service;

@Service
public class PagamentoGateway implements PagamentoGatewayInterface {

    private final PagamentoRepositoryInterface pagamentoRepository;

    public PagamentoGateway( PagamentoRepositoryInterface pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    @Override
    public PagamentoVO salvarPagamento(PagamentoVO pagamentoVO) {
        return pagamentoRepository.salvarPagamento(pagamentoVO);
    }
}
