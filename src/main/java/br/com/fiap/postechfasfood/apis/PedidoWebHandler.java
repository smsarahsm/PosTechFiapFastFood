package br.com.fiap.postechfasfood.apis;

import br.com.fiap.postechfasfood.apis.requests.PedidoWebHandlerRequest;
import br.com.fiap.postechfasfood.apis.responses.PedidoAtualizadoWebHandlerResponse;
import br.com.fiap.postechfasfood.apis.responses.PedidoPorStatusWebHandlerResponse;
import br.com.fiap.postechfasfood.apis.responses.PedidoWebHandlerResponse;
import br.com.fiap.postechfasfood.apis.responses.PedidosWebHandlerResponse;
import br.com.fiap.postechfasfood.controllers.PedidoController;
import br.com.fiap.postechfasfood.interfaces.PedidoRepositoryInterface;
import br.com.fiap.postechfasfood.interfaces.ProdutoRepositoryInterface;
import br.com.fiap.postechfasfood.types.TipoStatusPedidoEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;


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
    public ResponseEntity<PedidoPorStatusWebHandlerResponse> consultarStatusPagamento(@PathVariable int nrPedido) {
        PedidoController pedidoController = new PedidoController();
        PedidoPorStatusWebHandlerResponse pedido = pedidoController.buscarPorNumeroPedido(pedidoRepository, produtoRepository, nrPedido);
        if (pedido == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pedido);
    }

    @PatchMapping("/v1/pedidos/{cdPedido}/status/{txStatus}")
    public ResponseEntity<PedidoAtualizadoWebHandlerResponse> atualizarStatusPedido(
            @PathVariable String cdPedido,
            @PathVariable String txStatus) {
        PedidoController pedidoController = new PedidoController();
        var tipoStatusPedido = pedidoController.buscarPorStatusPedido(pedidoRepository, produtoRepository, cdPedido);
        if (tipoStatusPedido == null) {
            return ResponseEntity.notFound().build();
        }

        if (!tipoStatusPedido.name().equals("RECEBIDO")) {
            return ResponseEntity.status(409).build();
        }

        TipoStatusPedidoEnum novoStatus;
        try {
            novoStatus = TipoStatusPedidoEnum.valueOf(txStatus);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }

        var pedidoAtualizado = pedidoController.atualizarStatusPedido(pedidoRepository, produtoRepository, cdPedido, novoStatus);

        return ResponseEntity.ok(pedidoAtualizado);
    }

    @GetMapping("/v1/pedidos")
    public ResponseEntity<List<PedidosWebHandlerResponse>> listarPedidos() {
        PedidoController pedidoController = new PedidoController();
        var pedidos = pedidoController.listarTodosPedidos(pedidoRepository, produtoRepository);

        return ResponseEntity.ok(pedidos);
    }
}
