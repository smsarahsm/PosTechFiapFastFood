package br.com.fiap.postechfasfood.gateways;

import br.com.fiap.postechfasfood.entities.PagamentoVO;
import br.com.fiap.postechfasfood.entities.ProdutosPedidoVO;
import br.com.fiap.postechfasfood.externals.PedidoRepository;
import br.com.fiap.postechfasfood.externals.dto.MercadoPagoExternalApiRequestDTO;
import br.com.fiap.postechfasfood.entities.PedidoVO;
import br.com.fiap.postechfasfood.interfaces.PagamentoGatewayInterface;
import br.com.fiap.postechfasfood.interfaces.PagamentoClientInterface;
import br.com.fiap.postechfasfood.interfaces.PedidoRepositoryInterface;

import java.util.List;
import java.util.UUID;

public class PagamentoGateway implements PagamentoGatewayInterface {

    private final PagamentoClientInterface pagamentoClient;
    private final PedidoRepositoryInterface pedidoRepository;

    public PagamentoGateway(PagamentoClientInterface pagamentoClient, PedidoRepositoryInterface pedidoRepository) {
        this.pagamentoClient = pagamentoClient;
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public PedidoVO getPedido(int nrPedido) {
        return pedidoRepository.buscarPorNrPedido(nrPedido);
    }

    @Override
    public PagamentoVO realizaPagamento(List<ProdutosPedidoVO> produtosPedidoVO) {
        return pagamentoClient.realizaPagamento(produtosPedidoVO);
    }

    @Override
    public List<ProdutosPedidoVO> buscarProdutoPedido(PedidoVO pedidoVO) {
        return pedidoRepository.buscarProdutoPedido(pedidoVO);
    }
}
