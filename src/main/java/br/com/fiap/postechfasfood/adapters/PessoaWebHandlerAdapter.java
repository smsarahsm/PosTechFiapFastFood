package br.com.fiap.postechfasfood.adapters;

import br.com.fiap.postechfastfood_old.domain.models.PessoaModel;
import br.com.fiap.postechfastfood_old.infrastructure.web.api.dtos.PessoaResponseDto;

public class PessoaWebHandlerAdapter {
    public PessoaResponseDto toResponseDto(PessoaModel model) {
        return new PessoaResponseDto(model);
    }
}
