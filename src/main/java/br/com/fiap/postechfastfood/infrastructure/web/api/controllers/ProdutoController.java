package br.com.fiap.postechfastfood.infrastructure.web.api.controllers;

import br.com.fiap.postechfastfood.domain.models.ProdutoModel;
import br.com.fiap.postechfastfood.domain.ports.in.ProdutoServicePort;
import br.com.fiap.postechfastfood.infrastructure.commons.mappers.ProdutoMapper;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.ProdutoRequestDto;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.ProdutoResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@Tag(name="Produtos", description = "end-point para gerenciar os produtos")
public class ProdutoController {
    private final ProdutoServicePort produtoService;

    public ProdutoController(ProdutoServicePort produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/v1/produto")
    @Operation(summary = "Cadastra produtos", description = "Cadastra os produtos")
    public ResponseEntity<ProdutoResponseDto> cadastrarProduto(@RequestBody ProdutoRequestDto produtoRequestDto) {
        ProdutoResponseDto produtoResponseDto = ProdutoMapper.toResponse(produtoService.cadastrar(ProdutoMapper.requestToModel(produtoRequestDto)));
        return ResponseEntity.created(URI.create("/api/v1/produto/" + produtoResponseDto.cdProduto()))
                .body(produtoResponseDto);
    }

    @PutMapping("/v1/produto/{cdProduto}")
    @Operation(summary = "Atualiza produtos", description = "Atualiza produtos existentes")
    public ResponseEntity<ProdutoResponseDto> atualizarProduto(@PathVariable UUID cdProduto,
                                                               @RequestBody ProdutoRequestDto produtoRequestDto)
    {
        ProdutoResponseDto produtoResponseDto = ProdutoMapper.toResponse(produtoService.atualizar(cdProduto, ProdutoMapper.requestToModel(produtoRequestDto)));
        return ResponseEntity.ok(produtoResponseDto);
    }

    @DeleteMapping("/v1/produto/{cdProduto}")
    @Operation(summary = "Remove produtos", description = "Remove produtos existentes")
    public ResponseEntity<Void> deletarProduto(@PathVariable UUID cdProduto){
        produtoService.deletar(cdProduto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/v1/produto/{tpCategoria}")
    @Operation(summary = "Lista produtos", description = "Lista todos produtos existentes por categoria")
    public ResponseEntity<List<ProdutoResponseDto>> buscar(@PathVariable String tpCategoria) {
        List<ProdutoModel> produtoResponse = produtoService.buscar(tpCategoria);

        if (produtoResponse.isEmpty()) { return ResponseEntity.notFound().build(); }

        return ResponseEntity.ok(ProdutoMapper.modelToListResponse(produtoResponse));
    }

    @GetMapping("/v1/produto")
    @Operation(summary = "Lista produtos", description = "Lista todos produtos existentes")
    public ResponseEntity<List<ProdutoResponseDto>> buscar() {
        List<ProdutoModel> produtoResponse = produtoService.buscar();

        if (produtoResponse.isEmpty()) { return ResponseEntity.notFound().build(); }

        return ResponseEntity.ok(ProdutoMapper.modelToListResponse(produtoResponse));
    }
}

