package br.com.fiap.postechfasfood.adapters;

import br.com.fiap.postechfasfood.apis.responses.PessoaWebHandlerResponse;
import br.com.fiap.postechfasfood.entities.PessoaVO;

public class PessoaWebHandlerAdapter {
    public PessoaWebHandlerResponse toResponseDto(PessoaVO pessoa) {
        return new PessoaWebHandlerResponse(pessoa);
    }
}
