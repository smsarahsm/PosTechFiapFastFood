package br.com.fiap.postechfasfood.externals;

import br.com.fiap.postechfasfood.entities.PagamentoVO;
import br.com.fiap.postechfasfood.entities.ProdutosPedidoVO;
import br.com.fiap.postechfasfood.externals.config.RestTemplateConfiguration;
import br.com.fiap.postechfasfood.externals.dto.ItemMercadoPagoDTO;
import br.com.fiap.postechfasfood.externals.dto.MercadoPagoExternalApiRequestDTO;
import br.com.fiap.postechfasfood.externals.dto.MercadoPagoExternalApiResponseDTO;
import br.com.fiap.postechfasfood.externals.mappers.PagamentoMapper;
import br.com.fiap.postechfasfood.externals.mappers.PedidoRowMapper;
import br.com.fiap.postechfasfood.interfaces.PagamentoClientInterface;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class PagamentoClient implements PagamentoClientInterface {

    private final RestTemplateConfiguration restTemplate;

    public PagamentoClient(RestTemplateConfiguration restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public PagamentoVO realizaPagamento(List<ProdutosPedidoVO> produtosPedidoVO) {

        var pagamento = new MercadoPagoExternalApiRequestDTO(
                "reference_12345",
                "Product order",
                "Purchase description.",
                "https://webhook.site/3ea60d80-8c2d-41df-9fc2-6f2a2e3a75aa",
                100,
                List.of(new ItemMercadoPagoDTO("Point Mini", 100, 1, "unit", 100))
        );

        //TODO interpolar  com a url
        var userId = "2574083283";
        var posExternalId = "SUC5555POS5555";
        //TODO remover o token, apenas para teste
        var token = "TEST-3397683625960643-072308-576ea9105392e03a222a1c40c1b4df44-2574083283";
        String url = "https://api.mercadopago.com/instore/orders/qr/seller/collectors/2574083283/pos/SUC5555POS5555/qrs";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);

        HttpEntity<MercadoPagoExternalApiRequestDTO> request = new HttpEntity<>(pagamento, headers);

        var result = restTemplate.restTemplate().exchange(url, HttpMethod.PUT, request, MercadoPagoExternalApiResponseDTO.class);

        return PagamentoMapper.mapPagamento(Objects.requireNonNull(result.getBody()));
    }

    private List<ItemMercadoPagoDTO> toItemMercadoPagoDTO(List<ProdutosPedidoVO> produtosPedidoVO) {
        return produtosPedidoVO.stream()
                .map(produtoPedido -> new ItemMercadoPagoDTO(
                        produtoPedido.getProduto().getNmProduto(),
                        produtoPedido.getProduto().getVlPreco(),
                        produtoPedido.getVlQuantidade(),
                        "unit",
                        produtoPedido.getProduto().getVlPreco())
                ).collect(Collectors.toList());
    }
}
