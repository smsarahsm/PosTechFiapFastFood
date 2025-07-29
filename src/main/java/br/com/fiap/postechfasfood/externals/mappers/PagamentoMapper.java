package br.com.fiap.postechfasfood.externals.mappers;

import br.com.fiap.postechfasfood.entities.PagamentoVO;
import br.com.fiap.postechfasfood.externals.dto.MercadoPagoExternalApiResponseDTO;

public class PagamentoMapper {

    public static PagamentoVO mapPagamento(MercadoPagoExternalApiResponseDTO mercadoPagoExternalApiResponseDTO) {
        return new PagamentoVO.Builder()
                .setQrData(mercadoPagoExternalApiResponseDTO.getQrData())
                .build();
    }
}
