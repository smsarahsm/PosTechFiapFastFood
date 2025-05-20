package br.com.fiap.postechfastfood.domain.services;

import br.com.fiap.postechfastfood.domain.enums.TipoProdutoStatusEnum;
import br.com.fiap.postechfastfood.domain.models.PedidoModel;
import br.com.fiap.postechfastfood.domain.ports.PedidoRepositoryPort;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.PedidoRequestDto;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.PedidoResponseDto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class PedidoService {

    private final PedidoRepositoryPort pedidoRepositoryPort;

    public PedidoService(PedidoRepositoryPort pedidoRepositoryPort) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
    }

    public PedidoResponseDto cadastrar(PedidoRequestDto pedido) {
        PedidoModel model = new PedidoModel.Builder()
                .setCd_pedido(UUID.randomUUID())
                .setCd_doc_cliente(pedido.cdDocCliente())
                .setCd_doc_funcionario(pedido.cdDocFuncionario())
                .setTx_status(pedido.txStatus())
                .setNr_pedido(pedido.nrPedido())
                .setDh_criacao_pedido(pedido.dhCriacaoPedido())
                .setDh_ult_atualizacao(pedido.dhUltAtualizacao())
                .build();
        PedidoModel savedModel = pedidoRepositoryPort.cadastrarPedido(model);
        return toResponse(savedModel);
    }

    public PedidoResponseDto atualizar(UUID cdPedido, PedidoRequestDto pedido) {
        PedidoModel model = new PedidoModel.Builder()
                .setCd_pedido(cdPedido)
                .setCd_doc_cliente(pedido.cdDocCliente())
                .setCd_doc_funcionario(pedido.cdDocFuncionario())
                .setTx_status(pedido.txStatus())
                .setNr_pedido(pedido.nrPedido())
                .setDh_criacao_pedido(pedido.dhCriacaoPedido())
                .setDh_ult_atualizacao(pedido.dhUltAtualizacao())
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
}