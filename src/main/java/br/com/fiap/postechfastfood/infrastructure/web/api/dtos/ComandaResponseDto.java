package br.com.fiap.postechfastfood.infrastructure.web.api.dtos;

import br.com.fiap.postechfastfood.domain.models.ComandaModel;

public record ComandaResponseDto(
        String cdPedido,
        String stPedido
) {
    public ComandaResponseDto(ComandaModel model) {
        this(model.getCdPedido(), model.getStPedido());
    }
}
