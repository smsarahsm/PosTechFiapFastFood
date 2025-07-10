package br.com.fiap.postechfasfood.adapters;

import br.com.fiap.postechfasfood.apis.responses.ProdutoWebHandlerResponse;
import br.com.fiap.postechfasfood.entities.ProdutoVO;

public class ProdutoWebHandlerAdapter {
    public ProdutoWebHandlerResponse toResponseDto(ProdutoVO produto) {
        return new ProdutoWebHandlerResponse(produto);
    }
    
}
