package br.com.fiap.postechfasfood.apis.responses;

import br.com.fiap.postechfasfood.entities.PessoaVO;
import br.com.fiap.postechfasfood.types.TipoPessoaEnum;


public record PessoaWebHandlerResponse(
        String cdDocPessoa,
        String nmPessoa,
        TipoPessoaEnum tpPessoa,
        String dsEmail
) {
    public PessoaWebHandlerResponse(PessoaVO pessoa) {
        this(pessoa.getCdDocPessoa(), pessoa.getNmPessoa(), pessoa.getTpPessoa(), pessoa.getDsEmail());
    }
}
