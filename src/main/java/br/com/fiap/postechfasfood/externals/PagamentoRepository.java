package br.com.fiap.postechfasfood.externals;

import br.com.fiap.postechfasfood.entities.PagamentoVO;
import br.com.fiap.postechfasfood.interfaces.PagamentoRepositoryInterface;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository

public class PagamentoRepository implements PagamentoRepositoryInterface {

    private final RestTemplate restTemplate;

    public PagamentoRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public PagamentoVO realizaPagamento(PagamentoVO pagamentoVO) {
        //TODO adicionar na url
        var userId = "2574083283";
        var posExternalId = "SUC5555POS5555";
        //TODO remover o token, apenas para teste
        var token = "{inserir-token}";
        String url = "https://api.mercadopago.com/instore/orders/qr/seller/collectors/2574083283/pos/SUC5555POS5555/qrs";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);

        HttpEntity<PagamentoVO> request = new HttpEntity<>(pagamentoVO, headers);

        restTemplate.exchange(url, HttpMethod.PUT, request, PagamentoVO.class);
        pagamentoVO.setQrCode("qr_data");

        return pagamentoVO;
    }
}
