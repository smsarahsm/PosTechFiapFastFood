package br.com.fiap.postechfasfood.gateways;

import br.com.fiap.postechfasfood.entities.PedidoVO;
import br.com.fiap.postechfasfood.interfaces.DbConnection;
import br.com.fiap.postechfasfood.interfaces.PedidoGatewayInterface;
import br.com.fiap.postechfasfood.interfaces.PedidoRepositoryInterface;

public class PedidoGateway implements PedidoGatewayInterface {

    private final PedidoRepositoryInterface pedidoRepository;

    public PedidoGateway(PedidoRepositoryInterface pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public PedidoVO inserirPedidoNaBase(PedidoVO pedidoVO) {
        pedidoRepository.criarPedido(pedidoVO);
        return pedidoVO;
    }
}
