package br.com.fiap.postechfasfood.apis;

import br.com.fiap.postechfasfood.apis.requests.PedidoWebHandlerRequest;
import br.com.fiap.postechfasfood.apis.responses.PedidoWebHandlerResponse;
import br.com.fiap.postechfasfood.controllers.PedidoController;
import br.com.fiap.postechfasfood.interfaces.PedidoRepositoryInterface;
import br.com.fiap.postechfasfood.interfaces.ProdutoRepositoryInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

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
}
