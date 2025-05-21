package br.com.fiap.postechfastfood.infrastructure.web.api.dtos;

import br.com.fiap.postechfastfood.domain.enums.TipoProdutoStatusEnum;
import br.com.fiap.postechfastfood.domain.models.ItensPedidoModel;
import br.com.fiap.postechfastfood.domain.models.PedidoModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record PedidoRequestDto(
    UUID cdPedido,
    String cdDocCliente,
    String cdDocFuncionario,
    TipoProdutoStatusEnum txStatus,
    int nrPedido,
    LocalDateTime dhCriacaoPedido,
    LocalDateTime dhUltAtualizacao,
    List<ItensPedidoModel> itens
)

    {
        public PedidoRequestDto(PedidoModel model) {
            this(model.getCdPedido(),
                    model.getCdDocCliente(),
                    model.getCdDocFuncionario(),
                    model.getTxStatus(),
                    model.getNrPedido(),
                    model.getDhCriacaoPedido(),
                    model.getDhUltAtualizacao(),
                    model.getItens());
        }

        @Override
        public String toString() {
            return "PedidoRequestDto{" +
                    "cdPedido=" + cdPedido +
                    ", cdDocCliente='" + cdDocCliente + '\'' +
                    ", cdDocFuncionario='" + cdDocFuncionario + '\'' +
                    ", txStatus=" + txStatus +
                    ", nrPedido=" + nrPedido +
                    ", dhCriacaoPedido=" + dhCriacaoPedido +
                    ", dhUltAtualizacao=" + dhUltAtualizacao +
                    ", itens=" + itens +
                    '}';
        }
    }

