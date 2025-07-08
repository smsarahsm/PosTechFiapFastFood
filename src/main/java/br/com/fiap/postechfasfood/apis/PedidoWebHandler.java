package br.com.fiap.postechfasfood.apis;

import br.com.fiap.postechfasfood.apis.requests.PedidoWebHandlerRequest;
import br.com.fiap.postechfasfood.controllers.PedidoController;
import br.com.fiap.postechfasfood.interfaces.DbConnection;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(name="Pedidos", description = "end-point para gerenciar os pedidos")
public class PedidoWebHandler {

    private DbConnection dbConnection;

    public PedidoWebHandler(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @PostMapping("/api/v1/pedidos/checkout")
    @Operation(summary = "Cadastra pedidos", description = "Cadastra os pedidos")
    public ResponseEntity<T> cadastrarPedido(@RequestBody PedidoWebHandlerRequest pedidoWebHandlerRequest) {
        PedidoController pedidoController = new PedidoController();
        pedidoController.criarPedido(dbConnection, pedidoWebHandlerRequest);
    }
}
