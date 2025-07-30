package br.com.fiap.postechfasfood.usecases;

import br.com.fiap.postechfasfood.entities.PagamentoVO;
import br.com.fiap.postechfasfood.entities.PedidoVO;
import br.com.fiap.postechfasfood.interfaces.PagamentoRepositoryInterface;
import br.com.fiap.postechfasfood.interfaces.PedidoRepositoryInterface;
import br.com.fiap.postechfasfood.types.TipoStatusPedidoEnum;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
public class PagamentoUseCase {

    private final PedidoRepositoryInterface pedidoRepository;
    private final PagamentoRepositoryInterface pagamentoRepository;
    private final ObjectMapper objectMapper;

    public PagamentoUseCase(PedidoRepositoryInterface pedidoRepository, PagamentoRepositoryInterface pagamentoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.pagamentoRepository = pagamentoRepository;
        this.objectMapper = new ObjectMapper();
    }

    public void processarNotificacao(int nrPedido, String payload) throws IOException {
        JsonNode root = objectMapper.readTree(payload);
        String statusPagamento = root.path("pagamento").path("status").asText();
        double vlPagamento = root.path("pagamento").path("vlPagamento").asDouble(0.0);

        if ("approved".equalsIgnoreCase(statusPagamento)) {
            PedidoVO pedido = pedidoRepository.buscarPorNumeroPedido(nrPedido);
            if (pedido != null) {
                pedidoRepository.atualizarStatusPedido(pedido.getCdPedido(), TipoStatusPedidoEnum.RECEBIDO);

                PagamentoVO pagamento = new PagamentoVO();
                pagamento.setCdPagamento(UUID.randomUUID());
                pagamento.setCdPedido(pedido.getCdPedido());
                pagamento.setVlPagamento(vlPagamento);
                pagamento.setTpStatus("PAGO");
                pagamentoRepository.salvarPagamento(pagamento);
            } else {
                throw new RuntimeException("Pedido não encontrado");
            }
        }
    }
}