package br.com.fiap.postechfastfood.domain.services;

import br.com.fiap.postechfastfood.domain.enums.TipoProdutoStatusEnum;
import br.com.fiap.postechfastfood.domain.models.PedidoModel;
import br.com.fiap.postechfastfood.domain.models.ProdutosPedidoModel;
import br.com.fiap.postechfastfood.domain.ports.out.PedidoRepositoryPort;
import br.com.fiap.postechfastfood.domain.ports.in.PedidoServicePort;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.PedidoRequestDto;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.PedidoResponseDto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class PedidoService implements PedidoServicePort {

    private final PedidoRepositoryPort pedidoRepositoryPort;

    public PedidoService(PedidoRepositoryPort pedidoRepositoryPort) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
    }

    public PedidoResponseDto cadastrar(PedidoRequestDto pedido) {
        PedidoModel model = new PedidoModel.Builder()
                .setCdPedido(UUID.randomUUID())
                .setCdDocCliente(pedido.cdDocCliente())
                .setCdDocFuncionario(pedido.cdDocFuncionario())
                .setTxStatus(pedido.txStatus())
                .setNrPedido(pedido.nrPedido())
                .setDhCriacaoPedido(pedido.dhCriacaoPedido())
                .setDhUltAtualizacao(pedido.dhUltAtualizacao())
                .build();
        PedidoModel savedModel = pedidoRepositoryPort.cadastrarPedido(model);
        return toResponse(savedModel);
    }

    public PedidoResponseDto atualizar(UUID cdPedido, PedidoRequestDto pedido) {
        PedidoModel model = new PedidoModel.Builder()
                .setCdPedido(cdPedido)
                .setCdDocCliente(pedido.cdDocCliente())
                .setCdDocFuncionario(pedido.cdDocFuncionario())
                .setTxStatus(pedido.txStatus())
                .setNrPedido(pedido.nrPedido())
                .setDhCriacaoPedido(pedido.dhCriacaoPedido())
                .setDhUltAtualizacao(pedido.dhUltAtualizacao())
                .build();
        PedidoModel updatedModel = pedidoRepositoryPort.cadastrarPedido(model);
        return toResponse(updatedModel);
    }

    public void deletar(UUID cdPedido) {
        pedidoRepositoryPort.removerPedido(cdPedido);
    }

    public List<PedidoResponseDto> buscar() {
        return pedidoRepositoryPort.listarTodosPedidos()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public List<PedidoResponseDto> buscarPorStatus(TipoProdutoStatusEnum status) {
        List<PedidoModel> pedidos = pedidoRepositoryPort.buscarPedidosPorStatus(status);
        return pedidos.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private PedidoResponseDto toResponse(PedidoModel pedidoModel) {
        return new PedidoResponseDto(pedidoModel);
    }

    @Override
    public PedidoModel criar(PedidoModel pedido) {
        pedido.setCdPedido(UUID.randomUUID());
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
}