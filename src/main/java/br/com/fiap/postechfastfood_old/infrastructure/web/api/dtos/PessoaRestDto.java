package br.com.fiap.postechfastfood_old.infrastructure.web.api.dtos;

import br.com.fiap.postechfastfood_old.domain.enums.TipoPessoaEnum;
import br.com.fiap.postechfastfood_old.domain.models.PessoaModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record PessoaRestDto(
        @Valid
        @NotNull(message = "O atributo cdDocPessoa é obrigatório.")
        @CPF(message = "O CPF informado no atributo cdDocPessoa é inválido.")
        String cdDocPessoa,
        @Valid
        @NotNull(message = "O atributo nmPessoa é obrigatório.")
        @Size(min = 3, max = 200, message = "O atributo nmPessoa deve ter entre 3 e 200 caracteres.")
        String nmPessoa,
        @Valid
        @NotNull(message = "O atributo tpPessoa é obrigatório.")
        TipoPessoaEnum tpPessoa,
        @Valid
        @NotNull(message = "O atributo dsEmail é obrigatório.")
        @Email(message = "O valor informado para dsEmail não é um e-mail válido")
        String dsEmail) {
    public PessoaRestDto(PessoaModel model) {
        this(model.getCdDocPessoa(), model.getNmPessoa(), model.getTpPessoa(), model.getDsEmail());
    }
}
