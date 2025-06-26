package br.com.fiap.postechfastfood_old.domain.services;

import br.com.fiap.postechfastfood_old.domain.enums.TipoStatusPedidoEnum;
import br.com.fiap.postechfastfood_old.domain.models.PedidoModel;
import br.com.fiap.postechfastfood_old.domain.models.ProdutosPedidoModel;
import br.com.fiap.postechfastfood_old.domain.ports.in.PedidoServicePort;
import br.com.fiap.postechfastfood_old.domain.ports.out.PedidoRepositoryPort;

import java.util.List;
import java.util.UUID;

public class PedidoService implements PedidoServicePort {

    private final PedidoRepositoryPort pedidoRepositoryPort;

    public PedidoService(PedidoRepositoryPort pedidoRepositoryPort) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
    }

    @Override
    public PedidoModel criar(PedidoModel pedido) {
        int ultimoNumero = pedidoRepositoryPort.buscarUltimoNumeroPedido();
        int proximoNumero = (ultimoNumero >= 999) ? 1 : ultimoNumero + 1;
        pedido.setCdPedido(UUID.randomUUID());
        pedido.setNrPedido(proximoNumero);
        PedidoModel pedidoSalvo = pedidoRepositoryPort.cadastrarPedido(pedido);
        pedido.getItens().forEach(item -> {
            ProdutosPedidoModel produtosPedidoModel = new ProdutosPedidoModel();
            produtosPedidoModel.setPedido(pedido);
            produtosPedidoModel.setProduto(item.getProduto());
            produtosPedidoModel.setVlQuantidade(item.getVlQuantidade());
            pedidoRepositoryPort.cadastrarProdutosPedido(produtosPedidoModel);
        });
        return pedidoSalvo;
    }

    @Override
    public PedidoModel atualizar(UUID cdPedido, PedidoModel model) {
        return pedidoRepositoryPort.atualizarStatusPedido(cdPedido, model.getTxStatus());
    }

    @Override
    public PedidoModel atualizaStatus(UUID cdPedido, TipoStatusPedidoEnum status) {
        return pedidoRepositoryPort.atualizarStatusPedido(cdPedido, status);
    }

    @Override
    public void deletar(UUID cdPedido) {
        pedidoRepositoryPort.removerPedido(cdPedido);
    }

    public List<PedidoModel> buscar() {
        return pedidoRepositoryPort.listarTodosPedidos();
    }

    @Override
    public List<PedidoModel> buscarPorStatus(TipoStatusPedidoEnum status) {
        return pedidoRepositoryPort.buscarPedidosPorStatus(status);
    }
}