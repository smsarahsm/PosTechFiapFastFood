package br.com.fiap.postechfastfood.infrastructure.web.api.dtos;

import br.com.fiap.postechfastfood.domain.enums.TipoStatusPedidoEnum;
import br.com.fiap.postechfastfood.domain.models.ItensPedidoModel;
import br.com.fiap.postechfastfood.domain.models.PedidoModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record PedidoRequestDto(
    String cdDocCliente,
    String cdDocFuncionario,
    TipoStatusPedidoEnum txStatus,
    int nrPedido,
    LocalDateTime dhCriacaoPedido,
    LocalDateTime dhUltAtualizacao,
    List<ItensPedidoModel> itens
)

    {
        public PedidoRequestDto(PedidoModel model) {
            this(model.getCdDocCliente(),
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
                    "cdDocCliente='" + cdDocCliente + '\'' +
                    ", cdDocFuncionario='" + cdDocFuncionario + '\'' +
                    ", txStatus=" + txStatus +
                    ", nrPedido=" + nrPedido +
                    ", dhCriacaoPedido=" + dhCriacaoPedido +
                    ", dhUltAtualizacao=" + dhUltAtualizacao +
                    ", itens=" + itens +
                    '}';
        }
    }

