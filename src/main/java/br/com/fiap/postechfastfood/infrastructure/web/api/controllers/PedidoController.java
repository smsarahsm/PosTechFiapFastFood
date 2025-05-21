package br.com.fiap.postechfastfood.infrastructure.web.api.controllers;

import br.com.fiap.postechfastfood.domain.enums.TipoProdutoStatusEnum;
import br.com.fiap.postechfastfood.domain.ports.in.PedidoServicePort;
import br.com.fiap.postechfastfood.domain.services.PedidoService;
import br.com.fiap.postechfastfood.infrastructure.commons.mappers.PedidoMapper;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.PedidoRequestDto;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.PedidoResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;
    private final PedidoServicePort pedidoServicePort;

    public PedidoController(PedidoService pedidoService, PedidoServicePort pedidoServicePort) {
        this.pedidoService = pedidoService;
        this.pedidoServicePort = pedidoServicePort;
    }

//    @PostMapping
//    public ResponseEntity<PedidoResponseDto> cadastrar(@RequestBody PedidoRequestDto pedidoRequestDto) {
//        PedidoResponseDto pedido = pedidoService.cadastrar(pedidoRequestDto);
//        return ResponseEntity.created(URI.create("/api/pedidos/" + pedido.cdPedido())).body(pedido);
//    }

    @PostMapping
    public ResponseEntity<PedidoResponseDto> cadastrar(@RequestBody PedidoRequestDto pedidoRequestDto) {
        System.out.println("controller:" + pedidoRequestDto.toString());
        PedidoResponseDto pedido = PedidoMapper.modelToResponse(pedidoServicePort.criar(PedidoMapper.requestToModel(pedidoRequestDto)));
        return ResponseEntity.created(URI.create("/api/pedidos/" + pedido.cdPedido())).body(pedido);
    }

    @PutMapping("/{cdPedido}/status")
    public ResponseEntity<PedidoResponseDto> atualizar(@PathVariable UUID cdPedido, @RequestBody PedidoRequestDto pedidoRequestDto) {
        var pedidoAtualizado = pedidoService.atualizar(cdPedido, pedidoRequestDto);
        return ResponseEntity.ok(pedidoAtualizado);
    }


    @DeleteMapping("/{cdPedido}")
    public ResponseEntity<Void> deletar(@PathVariable UUID cdPedido) {
        pedidoService.deletar(cdPedido);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponseDto>> buscar() {
        var pedidos = pedidoService.buscar();
        if (pedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/status")
    public ResponseEntity<List<PedidoResponseDto>> buscarPorStatus(@RequestParam TipoProdutoStatusEnum status) {
        var pedidos = pedidoService.buscarPorStatus(status);
        if (pedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pedidos);
    }
}