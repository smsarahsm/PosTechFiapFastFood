package br.com.fiap.postechfastfood.infrastructure.web.api.controllers;

import br.com.fiap.postechfastfood.domain.models.ProdutoModel;
import br.com.fiap.postechfastfood.domain.ports.in.ProdutoServicePort;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.ProdutoRequestDto;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.ProdutoResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProdutoController {
    private final ProdutoServicePort produtoService;

    public ProdutoController(ProdutoServicePort produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/v1/produto")
    public ResponseEntity<ProdutoResponseDto> cadastrarProduto(@RequestBody ProdutoRequestDto produtoRequestDto) {
        ProdutoResponseDto produtoResponseDto = produtoService.cadastrar(produtoRequestDto);
        return ResponseEntity.created(URI.create("/api/v1/produto/" + produtoResponseDto.cdProduto()))
                .body(produtoResponseDto);
    }

    @PutMapping("/v1/produto/{cdProduto}")
    public ResponseEntity<ProdutoResponseDto> atualizarProduto(@PathVariable String cdProduto,
                                                               @RequestBody ProdutoRequestDto produtoRequestDto)
    {
        ProdutoResponseDto produtoResponseDto = produtoService.atualizar(cdProduto, produtoRequestDto);
        return ResponseEntity.ok(produtoResponseDto);
    }

    @DeleteMapping("/v1/produto/{cdProduto}")
    public ResponseEntity<Void> deletarProduto(@PathVariable String cdProduto){
        produtoService.deletar(cdProduto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/v1/produto/{tpCategoria}")
    public ResponseEntity<List<ProdutoResponseDto>> buscar(@PathVariable String tpCategoria) {
        List<ProdutoModel> produtoResponse = produtoService.buscar(tpCategoria);

        if (produtoResponse.isEmpty()) { return ResponseEntity.notFound().build(); }

        var produtoResponseDto = mapeiaModelParaDTO(produtoResponse);
        return ResponseEntity.ok(produtoResponseDto);
    }

    @GetMapping("/v1/produto")
    public ResponseEntity<List<ProdutoResponseDto>> buscar() {
        List<ProdutoModel> produtoResponse = produtoService.buscar();

        if (produtoResponse.isEmpty()) { return ResponseEntity.notFound().build(); }

        var produtoResponseDto = mapeiaModelParaDTO(produtoResponse);
        return ResponseEntity.ok(produtoResponseDto);
    }

    private ProdutoResponseDto toResponse(ProdutoModel produtoModel) {
        return new ProdutoResponseDto(produtoModel);
    }

    private List<ProdutoResponseDto> mapeiaModelParaDTO(List<ProdutoModel> produtosModel) {
        return produtosModel.stream().map(this::toResponse).collect(Collectors.toList());
    }
}

