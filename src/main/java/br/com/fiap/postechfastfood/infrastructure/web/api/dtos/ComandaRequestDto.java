package br.com.fiap.postechfastfood.infrastructure.web.api.dtos;

import br.com.fiap.postechfastfood.domain.models.ComandaModel;

public record ComandaRequestDto(
        String cdPedido,
        String stPedido
) {
    public ComandaRequestDto(ComandaModel model) {
        this(model.getCdPedido(), model.getStPedido());
    }
}
