package br.com.fiap.postechfastfood_old.infrastructure.web.api.dtos;

import br.com.fiap.postechfastfood_old.domain.enums.TipoStatusPedidoEnum;
import br.com.fiap.postechfastfood_old.domain.models.ItensPedidoModel;
import br.com.fiap.postechfastfood_old.domain.models.PedidoModel;

import java.time.LocalDateTime;
import java.util.List;

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

