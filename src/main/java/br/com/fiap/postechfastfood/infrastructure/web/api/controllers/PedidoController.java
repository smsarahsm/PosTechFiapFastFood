package br.com.fiap.postechfastfood.infrastructure.web.api.controllers;

import br.com.fiap.postechfastfood.domain.enums.TipoStatusPedidoEnum;
import br.com.fiap.postechfastfood.domain.ports.in.PedidoServicePort;
import br.com.fiap.postechfastfood.infrastructure.commons.mappers.PedidoMapper;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.PedidoRequestDto;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.PedidoResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/pedidos")
@Tag(name="Pedidos", description = "end-point para gerenciar os pedidos")
public class PedidoController {

    private final PedidoServicePort pedidoServicePort;

    public PedidoController(PedidoServicePort pedidoServicePort) {
        this.pedidoServicePort = pedidoServicePort;
    }

    @PostMapping
    @Operation(summary = "Cadastra pedidos", description = "Cadastra os pedidos")
    public ResponseEntity<PedidoResponseDto> cadastrar(@RequestBody PedidoRequestDto pedidoRequestDto) {
        PedidoResponseDto pedido = PedidoMapper.modelToResponse(pedidoServicePort.criar(PedidoMapper.requestToModel(pedidoRequestDto)));
        return ResponseEntity.created(URI.create("/api/pedidos/" + pedido.cdPedido())).body(pedido);
    }

    @PutMapping("/{cdPedido}/status")
    @Operation(summary = "Atualiza pedidos", description = "Atualiza o status dos pedidos")
    public ResponseEntity<PedidoResponseDto> atualizar(@PathVariable UUID cdPedido, @RequestBody PedidoRequestDto pedidoRequestDto) {
        var pedidoAtualizado = PedidoMapper.modelToResponse(pedidoServicePort.atualizar(cdPedido, PedidoMapper.requestToModel(pedidoRequestDto)));
        return ResponseEntity.ok(pedidoAtualizado);
    }


    @DeleteMapping("/{cdPedido}")
    @Operation(summary = "Remove pedidos", description = "Remove os pedidos existentes")
    public ResponseEntity<Void> deletar(@PathVariable UUID cdPedido) {
        pedidoServicePort.deletar(cdPedido);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @Operation(summary = "Lista pedidos", description = "Lista todos pedidos existentes")
    public ResponseEntity<List<PedidoResponseDto>> buscar() {
        var pedidos = PedidoMapper.modelToListResponse(pedidoServicePort.buscar());
        if (pedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/status")
    @Operation(summary = "Lista pedidos", description = "Lista todos pedidos existentes por status")
    public ResponseEntity<List<PedidoResponseDto>> buscarPorStatus(@RequestParam TipoStatusPedidoEnum status) {
        var pedidos = PedidoMapper.modelToListResponse(pedidoServicePort.buscarPorStatus(status));
        if (pedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pedidos);
    }
}