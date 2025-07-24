package br.com.fiap.postechfastfood_old.infrastructure.web.api.dtos;

import br.com.fiap.postechfastfood_old.domain.enums.TipoPessoaEnum;
import br.com.fiap.postechfastfood_old.domain.models.PessoaModel;

public record PessoaResponseDto(
        String cdDocPessoa,
        String nmPessoa,
        TipoPessoaEnum tpPessoa,
        String dsEmail
) {
    public PessoaResponseDto(PessoaModel model) {
        this(model.getCdDocPessoa(), model.getNmPessoa(), model.getTpPessoa(), model.getDsEmail());
    }
}
