package br.com.fiap.postechfastfood.infrastructure.web.api.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.fiap.postechfastfood.domain.enums.TipoProdutoStatusEnum;
import br.com.fiap.postechfastfood.domain.models.ComandaModel;

public record ComandaRequestDto(
    UUID cdPedido,
    String cdDocCliente,
    String cdDocFuncionario,
    TipoProdutoStatusEnum txStatus,
    int nrPedido,
    LocalDateTime dhCriacaoPedido,
    LocalDateTime dhUltAtualizacao
) {
    public ComandaRequestDto(ComandaModel model) {
            this(model.getCdPedido(),
                    model.getCdDocCliente(),
                    model.getCdDocFuncionario(),
                    model.getTxStatus(),
                    model.getNrPedido(),
                    model.getDhCriacaoPedido(),
                    model.getDhUltAtualizacao());
        }
    }

