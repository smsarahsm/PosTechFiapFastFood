package br.com.fiap.postechfastfood.domain.services;

import br.com.fiap.postechfastfood.domain.enums.TipoStatusPedidoEnum;
import br.com.fiap.postechfastfood.domain.models.PedidoModel;
import br.com.fiap.postechfastfood.domain.ports.in.PedidoServicePort;
import br.com.fiap.postechfastfood.domain.ports.out.PedidoRepositoryPort;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.PedidoRequestDto;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.PedidosResponseDto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class PedidoService implements PedidoServicePort {

    private final PedidoRepositoryPort pedidoRepositoryPort;

    public PedidoService(PedidoRepositoryPort pedidoRepositoryPort) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
    }

    public PedidosResponseDto cadastrar(PedidoRequestDto pedido) {
        PedidoModel model = new PedidoModel.Builder()
                .setCdPedido(UUID.randomUUID())
                .setcdDocCliente(pedido.cdDocCliente())
                .setCdDocFuncionario(pedido.cdDocFuncionario())
                .setTxStatus(pedido.txStatus())
                .setNrPedido(pedido.nrPedido())
                .setDhCriacaoPedido(pedido.dhCriacaoPedido())
                .setDhUltAtualizacao(pedido.dhUltAtualizacao())
                .build();
        PedidoModel savedModel = pedidoRepositoryPort.cadastrarPedido(model);
        return toResponse(savedModel);
    }

    public PedidosResponseDto atualizar(UUID cdPedido, PedidoRequestDto pedido) {
        PedidoModel model = new PedidoModel.Builder()
                .setCdPedido(cdPedido)
                .setcdDocCliente(pedido.cdDocCliente())
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

    public List<PedidosResponseDto> buscar() {
        return pedidoRepositoryPort.listarTodosPedidos()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public List<PedidosResponseDto> buscarPorStatus(TipoStatusPedidoEnum status) {
        List<PedidoModel> pedidos = pedidoRepositoryPort.buscarPedidosPorStatus(status);
        return pedidos.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private PedidosResponseDto toResponse(PedidoModel pedidoModel) {
        return new PedidosResponseDto(pedidoModel);
    }

    @Override
    public PedidoModel cadastrar(PedidoModel pedido) {
        pedido.setCdPedido(UUID.randomUUID());
        return pedidoRepositoryPort.cadastrarPedido(pedido);
    }
}