package br.com.fiap.postechfasfood.gateways;

import br.com.fiap.postechfasfood.entities.PedidoVO;
import br.com.fiap.postechfasfood.entities.ProdutosPedidoVO;
import br.com.fiap.postechfasfood.interfaces.PedidoGatewayInterface;
import br.com.fiap.postechfasfood.interfaces.PedidoRepositoryInterface;
import br.com.fiap.postechfasfood.types.TipoStatusPedidoEnum;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
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

    @Override
    public PedidoVO buscarPorNumeroPedido(int nrPedido) {
        return pedidoRepository.buscarPorNumeroPedido(nrPedido);
    }

    @Override
    public PedidoVO buscarPorStatusPedido(String cdPedido) {
        return pedidoRepository.buscarPorStatusPedido(cdPedido);
    }

    @Override
    public PedidoVO atualizarStatusPedido(String cdPedido, TipoStatusPedidoEnum novoStatus) {
        return pedidoRepository.atualizarStatusPedido(cdPedido, novoStatus);
    }

    @Override
    public List<PedidoVO> listarTodosPedidos() {
        return pedidoRepository.listarTodosPedidos();
    }

}
