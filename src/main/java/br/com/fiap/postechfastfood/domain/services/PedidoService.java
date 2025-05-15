package br.com.fiap.postechfastfood.domain.services;

import br.com.fiap.postechfastfood.domain.enums.TipoProdutoStatusEnum;
import br.com.fiap.postechfastfood.domain.models.PedidosModel;
import br.com.fiap.postechfastfood.domain.ports.PedidosRepositoryPort;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.PedidoRequestDto;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.PedidosResponseDto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class PedidoService {

    private final PedidosRepositoryPort pedidosRepositoryPort;

    public PedidoService(PedidosRepositoryPort pedidosRepositoryPort) {
        this.pedidosRepositoryPort = pedidosRepositoryPort;
    }

    public PedidosResponseDto cadastrar(PedidoRequestDto pedido) {
        PedidosModel model = new PedidosModel.Builder()
                .setCd_pedido(UUID.randomUUID())
                .setCd_doc_cliente(pedido.cdDocCliente())
                .setCd_doc_funcionario(pedido.cdDocFuncionario())
                .setTx_status(pedido.txStatus())
                .setNr_pedido(pedido.nrPedido())
                .setDh_criacao_pedido(pedido.dhCriacaoPedido())
                .setDh_ult_atualizacao(pedido.dhUltAtualizacao())
                .build();
        PedidosModel savedModel = pedidosRepositoryPort.cadastrarPedido(model);
        return toResponse(savedModel);
    }

    public PedidosResponseDto atualizar(UUID cdPedido, PedidoRequestDto pedido) {
        PedidosModel model = new PedidosModel.Builder()
                .setCd_pedido(cdPedido)
                .setCd_doc_cliente(pedido.cdDocCliente())
                .setCd_doc_funcionario(pedido.cdDocFuncionario())
                .setTx_status(pedido.txStatus())
                .setNr_pedido(pedido.nrPedido())
                .setDh_criacao_pedido(pedido.dhCriacaoPedido())
                .setDh_ult_atualizacao(pedido.dhUltAtualizacao())
                .build();
        PedidosModel updatedModel = pedidosRepositoryPort.cadastrarPedido(model);
        return toResponse(updatedModel);
    }

    public void deletar(UUID cdPedido) {
        pedidosRepositoryPort.removerPedido(cdPedido);
    }

    public List<PedidosResponseDto> buscar() {
        return pedidosRepositoryPort.listarTodosPedidos()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public List<PedidosResponseDto> buscarPorStatus(TipoProdutoStatusEnum status) {
        List<PedidosModel> pedidos = pedidosRepositoryPort.buscarPedidosPorStatus(status);
        return pedidos.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private PedidosResponseDto toResponse(PedidosModel pedidosModel) {
        return new PedidosResponseDto(pedidosModel);
    }
}