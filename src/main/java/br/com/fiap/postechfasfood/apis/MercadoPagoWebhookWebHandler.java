package br.com.fiap.postechfasfood.apis;

import br.com.fiap.postechfasfood.usecases.PagamentoUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook/mercado-pago")
public class MercadoPagoWebhookWebHandler {

    private final PagamentoUseCase pagamentoUseCase;

    public MercadoPagoWebhookWebHandler(PagamentoUseCase pagamentoUseCase) {
        this.pagamentoUseCase = pagamentoUseCase;
    }

    @PostMapping("/pagamentos/{nrPedido}")
    public ResponseEntity<String> receberNotificacaoPagamento(@RequestBody String payload,
                                                              @PathVariable int nrPedido) {
        try {
            pagamentoUseCase.processarNotificacao(nrPedido, payload);
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