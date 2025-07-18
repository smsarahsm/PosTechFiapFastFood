package br.com.fiap.postechfastfood_old.infrastructure.web.api.controllers;

import br.com.fiap.postechfastfood_old.domain.enums.TipoCategoriaProdutoEnum;
import br.com.fiap.postechfastfood_old.domain.models.ProdutoModel;
import br.com.fiap.postechfastfood_old.domain.ports.in.ProdutoServicePort;
import br.com.fiap.postechfastfood_old.infrastructure.commons.mappers.ProdutoMapper;
import br.com.fiap.postechfastfood_old.infrastructure.web.api.dtos.ProdutoRequestDto;
import br.com.fiap.postechfastfood_old.infrastructure.web.api.dtos.ProdutoResponseDto;
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
    private final ProdutoServicePort produtoServicePort;

    public ProdutoController(ProdutoServicePort produtoServicePort) {
        this.produtoServicePort = produtoServicePort;
    }

    @PostMapping("/v1/produto")
    @Operation(summary = "Cadastra produtos", description = "Cadastra os produtos")
    public ResponseEntity<ProdutoResponseDto> cadastrarProduto(@RequestBody ProdutoRequestDto produtoRequestDto) {
        ProdutoResponseDto produtoResponseDto = ProdutoMapper.toResponse(produtoServicePort.cadastrar(ProdutoMapper.requestToModel(produtoRequestDto)));
        return ResponseEntity.created(URI.create("/api/v1/produto/" + produtoResponseDto.cdProduto()))
                .body(produtoResponseDto);
    }

    @PutMapping("/v1/produto/{cdProduto}")
    @Operation(summary = "Atualiza produtos", description = "Atualiza produtos existentes")
    public ResponseEntity<ProdutoResponseDto> atualizarProduto(@PathVariable UUID cdProduto,
                                                               @RequestBody ProdutoRequestDto produtoRequestDto)
    {
        ProdutoResponseDto produtoResponseDto = ProdutoMapper.toResponse(produtoServicePort.atualizar(cdProduto, ProdutoMapper.requestToModel(produtoRequestDto)));
        return ResponseEntity.ok(produtoResponseDto);
    }

    @PatchMapping("/v1/produto/{cdProduto}/desativar")
    @Operation(summary = "Desativa produtos", description = "Desativa produtos existentes")
    public ResponseEntity<Void> desativarProduto(@PathVariable UUID cdProduto){
        produtoServicePort.desativar(cdProduto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/v1/produto/{cdProduto}/ativar")
    @Operation(summary = "Ativa produtos", description = "Ativa produtos existentes")
    public ResponseEntity<Void> ativarProduto(@PathVariable UUID cdProduto){
        produtoServicePort.ativar(cdProduto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/v1/produtos/categoria")
    @Operation(summary = "Lista produtos", description = "Lista todos produtos existentes por categoria")
    public ResponseEntity<List<ProdutoResponseDto>> buscar(@RequestParam TipoCategoriaProdutoEnum tipo) {
        List<ProdutoModel> produtoResponse = produtoServicePort.buscar(tipo);

        if (produtoResponse.isEmpty()) { return ResponseEntity.notFound().build(); }

        return ResponseEntity.ok(ProdutoMapper.modelToListResponse(produtoResponse));
    }

    @GetMapping("/v1/produtos")
    @Operation(summary = "Lista produtos", description = "Lista todos produtos existentes")
    public ResponseEntity<List<ProdutoResponseDto>> buscar() {
        List<ProdutoModel> produtoResponse = produtoServicePort.buscar();

        if (produtoResponse.isEmpty()) { return ResponseEntity.notFound().build(); }

        return ResponseEntity.ok(ProdutoMapper.modelToListResponse(produtoResponse));
    }
}

