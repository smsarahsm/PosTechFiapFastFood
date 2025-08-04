package br.com.fiap.postechfasfood.apis;

import br.com.fiap.postechfasfood.controllers.MercadoPagoWebHookController;
import br.com.fiap.postechfasfood.interfaces.PagamentoRepositoryInterface;
import br.com.fiap.postechfasfood.interfaces.PedidoRepositoryInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook/mercado-pago")
public class MercadoPagoWebhookWebHandler {

    private final PedidoRepositoryInterface pedidoRepository;
    private final PagamentoRepositoryInterface pagamentoRepository;


    public MercadoPagoWebhookWebHandler(PedidoRepositoryInterface pedidoRepository, PagamentoRepositoryInterface pagamentoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.pagamentoRepository = pagamentoRepository;
    }

    @PostMapping("/pagamentos/{nrPedido}")
    @Operation(
            summary = "Recebe notificação de pagamento do Mercado Pago",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Payload da notificação de pagamento",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Exemplo de notificação",
                                    value = "{\n  \"pagamento\": {\n    \"status\": \"approved\",\n    \"vlPagamento\": 49.90\n  }\n}"
                            )
                    )
            )
    )
    public ResponseEntity<String> receberNotificacaoPagamento(@RequestBody String payload,
                                                              @PathVariable int nrPedido) {
        try {
            MercadoPagoWebHookController mercadoPagoWebHookController = new MercadoPagoWebHookController();
            mercadoPagoWebHookController.processarNotificacao(pedidoRepository, pagamentoRepository, payload, nrPedido);

            String resposta = "{\"mensagem\": \"Transação aprovada\"}";
            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .body(resposta);
        } catch (Exception e) {
            String resposta = "{\"mensagem\": \"Erro ao processar o pagamento\"}";
            return ResponseEntity.badRequest()
                    .header("Content-Type", "application/json")
                    .body(resposta);
        }
    }
}