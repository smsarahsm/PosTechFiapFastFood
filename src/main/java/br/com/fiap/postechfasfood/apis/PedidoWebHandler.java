package br.com.fiap.postechfasfood.apis;

import br.com.fiap.postechfasfood.apis.requests.PedidoWebHandlerRequest;
import br.com.fiap.postechfasfood.apis.responses.PedidoWebHandlerResponse;
import br.com.fiap.postechfasfood.controllers.PedidoController;
import br.com.fiap.postechfasfood.entities.PedidoVO;
import br.com.fiap.postechfasfood.interfaces.PedidoRepositoryInterface;
import br.com.fiap.postechfasfood.interfaces.ProdutoRepositoryInterface;
import br.com.fiap.postechfasfood.types.TipoStatusPedidoEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.*;


@Service
@RestController
@RequestMapping("/api")
@Tag(name="Pedidos", description = "end-point para gerenciar os pedidos")
public class PedidoWebHandler {

    private final PedidoRepositoryInterface pedidoRepository;
    private final ProdutoRepositoryInterface produtoRepository;

    public PedidoWebHandler(PedidoRepositoryInterface pedidoRepository, ProdutoRepositoryInterface produtoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
    }

    @PostMapping("/v1/pedidos/checkout")
    @Operation(summary = "Cadastra pedidos", description = "Cadastra os pedidos")
    public ResponseEntity<PedidoWebHandlerResponse> cadastrarPedido(@RequestBody PedidoWebHandlerRequest pedidoWebHandlerRequest) {
        PedidoController pedidoController = new PedidoController();
        var response = pedidoController.criarPedido(pedidoRepository, produtoRepository, pedidoWebHandlerRequest);
        return ResponseEntity.created(URI.create("/api/v1/pedidos/checkout" + response.nrPedido()))
                .body(response);
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

        PedidoVO pedido = pedidoRepository.buscarPorStatusPedido(cdPedido);
        if (pedido == null) {
            return ResponseEntity.notFound().build();
        }

        if (!pedido.getTxStatus().name().equals("RECEBIDO")) {
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
                        "cdProduto", item.getCdProduto(),
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
                        "cdProduto", item.getCdProduto(),
                        "vlQuantidade", item.getVlQuantidade()
                )).toList()
        )).toList();
        return ResponseEntity.ok(response);
    }

}
