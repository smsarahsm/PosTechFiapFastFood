package br.com.fiap.postechfasfood.apis.responses;

import br.com.fiap.postechfasfood.entities.PagamentoVO;

public record PagamentoWebHandlerResponse(
        String qr_data
) {
    public PagamentoWebHandlerResponse(PagamentoVO pagamentoVO) {
        this(pagamentoVO.getQrCode());
    }
}
