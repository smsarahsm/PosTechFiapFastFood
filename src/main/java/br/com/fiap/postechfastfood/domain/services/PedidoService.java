package br.com.fiap.postechfastfood.domain.services;

import br.com.fiap.postechfastfood.domain.enums.TipoProdutoStatusEnum;
import br.com.fiap.postechfastfood.domain.models.PedidoModel;
import br.com.fiap.postechfastfood.domain.models.ProdutosPedidoModel;
import br.com.fiap.postechfastfood.domain.ports.in.PedidoServicePort;
import br.com.fiap.postechfastfood.domain.ports.out.PedidoRepositoryPort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class PedidoService implements PedidoServicePort {

    private final PedidoRepositoryPort pedidoRepositoryPort;

    public PedidoService(PedidoRepositoryPort pedidoRepositoryPort) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
    }

    @Override
    public PedidoModel criar(PedidoModel pedido) {
        pedido.setCdPedido(UUID.randomUUID());
        pedido.setDhCriacaoPedido(LocalDateTime.now());
        pedido.setDhUltAtualizacao(LocalDateTime.now());
        PedidoModel pedidoSalvo = pedidoRepositoryPort.cadastrarPedido(pedido);
        pedido.getItens().forEach(item -> {
            ProdutosPedidoModel produtosPedidoModel = new ProdutosPedidoModel();
            produtosPedidoModel.setPedido(pedido);
            produtosPedidoModel.setProduto(item.getProduto());
            produtosPedidoModel.setVlQuantidade(item.getVlQuantidade());
            ProdutosPedidoModel response = pedidoRepositoryPort.cadastrarProdutosPedido(produtosPedidoModel);
        });
        return pedido;
    }

    @Override
    public PedidoModel atualizar(UUID cdPedido, PedidoModel model) {
        return pedidoRepositoryPort.atualizarStatusPedido(cdPedido, model.getTxStatus());
    }

    @Override
    public void deletar(UUID cdPedido) {
        pedidoRepositoryPort.removerPedido(cdPedido);
    }

    public List<PedidoModel> buscar() {
        return pedidoRepositoryPort.listarTodosPedidos();
    }

    @Override
    public List<PedidoModel> buscarPorStatus(TipoProdutoStatusEnum status) {
        return pedidoRepositoryPort.buscarPedidosPorStatus(status);
    }
}