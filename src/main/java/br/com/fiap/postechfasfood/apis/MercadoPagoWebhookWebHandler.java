package br.com.fiap.postechfasfood.apis;

import br.com.fiap.postechfasfood.usecases.PagamentoUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhook/mercado-pago")
public class MercadoPagoWebhookWebHandler {

    private final PagamentoUseCase pagamentoUseCase;

    public MercadoPagoWebhookWebHandler(PagamentoUseCase pagamentoUseCase) {
        this.pagamentoUseCase = pagamentoUseCase;
    }

    @PostMapping("/pagamentos")
    public ResponseEntity<String> receberNotificacaoPagamento(@RequestBody String payload) {
        try {
            pagamentoUseCase.processarNotificacao(payload);
            String resposta = "{\"mensagem\": \"Transação aprovada\"}";
            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .body(resposta);
        } catch (Exception e) {
            String resposta = "{\"mensagem\": \"Erro ao processar notificação\"}";
            return ResponseEntity.badRequest()
                    .header("Content-Type", "application/json")
                    .body(resposta);
        }
    }
}