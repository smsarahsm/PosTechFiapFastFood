package br.com.fiap.postechfasfood.adapters;

import br.com.fiap.postechfasfood.apis.responses.PagamentoWebHandlerResponse;
import br.com.fiap.postechfasfood.entities.PagamentoVO;
import br.com.fiap.postechfasfood.externals.dto.MercadoPagoExternalApiRequestDTO;

public class PagamentoWebHandlerAdapter {
    public PagamentoWebHandlerResponse toResponseDto(PagamentoVO pagamentoVO) {
        return new PagamentoWebHandlerResponse(pagamentoVO);}
}
