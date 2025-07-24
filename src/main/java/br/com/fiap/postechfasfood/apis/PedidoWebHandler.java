package br.com.fiap.postechfasfood.apis;

import br.com.fiap.postechfasfood.entities.PedidoVO;
import br.com.fiap.postechfasfood.interfaces.PedidoRepositoryInterface;
import br.com.fiap.postechfasfood.types.TipoStatusPedidoEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Service
@RestController
@RequestMapping("/api")

public class PedidoWebHandler {

    private final PedidoRepositoryInterface pedidoRepository;

    public PedidoWebHandler(PedidoRepositoryInterface pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }


    @GetMapping("/v1/pedidos/{nrPedido}/pagamento/status")
    public ResponseEntity<Map<String, String>> consultarStatusPagamento(@PathVariable int nrPedido) {
        PedidoVO pedido = pedidoRepository.buscarPorNumeroPedido(nrPedido);
        if (pedido == null) {
            return ResponseEntity.notFound().build();
        }
        Map<String, String> response = Map.of("txStatus", pedido.getTxStatus().name());
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/v1/pedidos/{cdPedido}/status/{txStatus}")
    public ResponseEntity<?> atualizarStatusPedido(
            @PathVariable UUID cdPedido,
            @PathVariable String txStatus) {

        PedidoVO pedido = pedidoRepository.buscarPorCdPedido(cdPedido);
        if (pedido == null) {
            return ResponseEntity.notFound().build();
        }

        // Só permite alteração se o status atual for "PAGO"
        if (!pedido.getTxStatus().name().equals("PAGO")) {
            return ResponseEntity.status(409).body(Map.of("erro", "Status só pode ser alterado após pagamento concluído."));
        }

        TipoStatusPedidoEnum novoStatus;
        try {
            novoStatus = TipoStatusPedidoEnum.valueOf(txStatus);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("erro", "Status inválido."));
        }

        pedido = pedidoRepository.atualizarStatusPedido(cdPedido, novoStatus);

        Map<String, Object> response = Map.of(
                "txStatus", pedido.getTxStatus().name(),
                "nrPedido", pedido.getNrPedido(),
                "itens", pedido.getItens().stream().map(item -> Map.of(
                        "cdProduto", item.getProduto().getCdProduto(),
                        "vlQuantidade", item.getVlQuantidade()
                )).toList()
        );

        return ResponseEntity.ok(response);
    }


    @GetMapping("/v1/pedidos")
    public ResponseEntity<?> listarPedidos() {
        List<PedidoVO> todosPedidos = pedidoRepository.listarTodosPedidos();
        List<PedidoVO> pedidosFiltrados = todosPedidos.stream()
                .filter(p -> !p.getTxStatus().name().equals("FINALIZADO"))
                .toList();

        List<PedidoVO> prontos = pedidosFiltrados.stream()
                .filter(p -> p.getTxStatus().name().equals("PRONTO"))
                .sorted(Comparator.comparing(PedidoVO::getDhCriacaoPedido))
                .toList();

        List<PedidoVO> emPreparacao = pedidosFiltrados.stream()
                .filter(p -> p.getTxStatus().name().equals("EM_PREPARACAO"))
                .sorted(Comparator.comparing(PedidoVO::getDhCriacaoPedido))
                .toList();

        List<PedidoVO> recebidos = pedidosFiltrados.stream()
                .filter(p -> p.getTxStatus().name().equals("RECEBIDO"))
                .sorted(Comparator.comparing(PedidoVO::getDhCriacaoPedido))
                .toList();

        List<PedidoVO> pedidosOrdenados = new ArrayList<>();
        pedidosOrdenados.addAll(prontos);
        pedidosOrdenados.addAll(emPreparacao);
        pedidosOrdenados.addAll(recebidos);
        
        List<Map<String, Object>> response = pedidosOrdenados.stream().map(pedido -> Map.of(
                "txStatus", pedido.getTxStatus().name(),
                "nrPedido", pedido.getNrPedido(),
                "dhCriacao", pedido.getDhCriacaoPedido().toString().substring(0, 16),
                "itens", pedido.getItens().stream().map(item -> Map.of(
                        "cdProduto", item.getProduto().getCdProduto(),
                        "vlQuantidade", item.getVlQuantidade()
                )).toList()
        )).toList();
        return ResponseEntity.ok(response);
    }

}
