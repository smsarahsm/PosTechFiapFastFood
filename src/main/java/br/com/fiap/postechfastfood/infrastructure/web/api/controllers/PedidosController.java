package br.com.fiap.postechfastfood.infrastructure.web.api.controllers;

import br.com.fiap.postechfastfood.domain.enums.TipoProdutoStatusEnum;
import br.com.fiap.postechfastfood.domain.services.PedidoService;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.PedidoRequestDto;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.PedidosResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.sql.Time;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

    private final PedidoService pedidoService;

    public PedidosController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<PedidosResponseDto> cadastrar(@RequestBody PedidoRequestDto pedidoRequestDto) {
        PedidosResponseDto pedido = pedidoService.cadastrar(pedidoRequestDto);
        return ResponseEntity.created(URI.create("/api/pedidos/" + pedido.cdPedido())).body(pedido);
    }

    @PutMapping("/{cdPedido}/status")
    public ResponseEntity<PedidosResponseDto> atualizar(@PathVariable UUID cdPedido, @RequestBody PedidoRequestDto pedidoRequestDto) {
        var pedidoAtualizado = pedidoService.atualizar(cdPedido, pedidoRequestDto);
        return ResponseEntity.ok(pedidoAtualizado);
    }


    @DeleteMapping("/{cdPedido}")
    public ResponseEntity<Void> deletar(@PathVariable UUID cdPedido) {
        pedidoService.deletar(cdPedido);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<PedidosResponseDto>> buscar() {
        var pedidos = pedidoService.buscar();
        if (pedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/status")
    public ResponseEntity<List<PedidosResponseDto>> buscarPorStatus(@RequestParam TipoProdutoStatusEnum status) {
        var pedidos = pedidoService.buscarPorStatus(status);
        if (pedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pedidos);
    }
}