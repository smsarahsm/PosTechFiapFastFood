package br.com.fiap.postechfasfood.gateways;

import br.com.fiap.postechfasfood.entities.PedidoVO;
import br.com.fiap.postechfasfood.entities.ProdutosPedidoVO;
import br.com.fiap.postechfasfood.interfaces.DbConnection;
import br.com.fiap.postechfasfood.interfaces.PedidoGatewayInterface;
import br.com.fiap.postechfasfood.interfaces.PedidoRepositoryInterface;

public class PedidoGateway implements PedidoGatewayInterface {

    private final PedidoRepositoryInterface pedidoRepository;

    public PedidoGateway(PedidoRepositoryInterface pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public PedidoVO cadastrar(PedidoVO pedidoVO) {
        return pedidoRepository.cadastrarPedido(pedidoVO);
   }

    @Override
    public ProdutosPedidoVO cadastrarProdutoPedido(ProdutosPedidoVO pedidoVO) {
        return pedidoRepository.cadastrarProdutosPedido(pedidoVO);
    }

    @Override
    public int buscarUltimoNumeroPedido() {
        return pedidoRepository.buscarUltimoNumeroPedido();
    }
}
