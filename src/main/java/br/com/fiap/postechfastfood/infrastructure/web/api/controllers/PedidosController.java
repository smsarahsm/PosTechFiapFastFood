package br.com.fiap.postechfastfood.infrastructure.web.api.controllers;

import br.com.fiap.postechfastfood.domain.enums.TipoStatusPedidoEnum;
import br.com.fiap.postechfastfood.domain.models.PedidoModel;
import br.com.fiap.postechfastfood.domain.models.ProdutoPedidoModel;
import br.com.fiap.postechfastfood.domain.ports.in.PedidoServicePort;
import br.com.fiap.postechfastfood.domain.services.PedidoService;
import br.com.fiap.postechfastfood.infrastructure.persistence.jpa.entities.ProdutoPedidoEntity;
import br.com.fiap.postechfastfood.infrastructure.persistence.jpa.mappers.PedidosMapper;
import br.com.fiap.postechfastfood.infrastructure.persistence.jpa.mappers.ProdutoMapper;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.PedidoRequestDto;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.PedidosResponseDto;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.ProdutoPedidoRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

    private final PedidoService pedidoService;
    private final PedidoServicePort pedidoServicePort;

    public PedidosController(PedidoService pedidoService, PedidoServicePort pedidoServicePort) {
        this.pedidoService = pedidoService;
        this.pedidoServicePort = pedidoServicePort;
    }

    @PostMapping
    public ResponseEntity<PedidosResponseDto> cadastrar(@RequestBody PedidoRequestDto pedidoRequestDto) {
        //PedidosResponseDto pedido = pedidoService.cadastrar(pedidoRequestDto);

        PedidoModel pedido = pedidoServicePort.cadastrar(toModel(pedidoRequestDto));
        PedidosResponseDto pedidoResponse = new PedidosResponseDto(pedido);
        return ResponseEntity.created(URI.create("/api/pedidos/" + pedidoResponse.cdPedido())).body(pedidoResponse);
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
    public ResponseEntity<List<PedidosResponseDto>> buscarPorStatus(@RequestParam TipoStatusPedidoEnum status) {
        var pedidos = pedidoService.buscarPorStatus(status);
        if (pedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pedidos);
    }

    private PedidoModel toModel(PedidoRequestDto req) {
        PedidoModel model = new PedidoModel();
        model.setCdPedido(req.cdPedido());
        model.setNrPedido(req.nrPedido());
        model.setcdDocCliente(req.cdDocCliente());
        model.setTxStatus(req.txStatus());
        model.setCdDocFuncionario(req.cdDocFuncionario());
        model.setDhCriacaoPedido(req.dhCriacaoPedido());
        model.setDhUltAtualizacao(req.dhUltAtualizacao());
        model.setLsProdutoPedido(toModelList(req.lsProdutoPedido()));
        return model;
    }

    private List<ProdutoPedidoModel> toModelList(List<ProdutoPedidoRequestDto> req){
        List<ProdutoPedidoModel> lsModel = new ArrayList<>();
        req.forEach(e -> {
                    ProdutoPedidoModel model = new ProdutoPedidoModel();
                    model.setProdutoModel(e.cdProduto());
                    model.setVlQuantidadeProduto(e.vlQuantidadeProduto());
                    lsModel.add(model);
                });
        return lsModel;
    }
    private static List<ProdutoPedidoModel> toModelList(List<ProdutoPedidoEntity> entity){
        List<ProdutoPedidoModel> lsModel = new ArrayList<>();
        entity.forEach(e -> {
            ProdutoPedidoModel model = new ProdutoPedidoModel();
            model.setProdutoModel(ProdutoMapper.toModel(e.getProduto()));
            model.setPedidoModel(PedidosMapper.toModel(e.getPedido()));
            model.setVlQuantidadeProduto(e.getVlQuantidadeProduto());
            lsModel.add(model);
        });
        return lsModel;
    }
}