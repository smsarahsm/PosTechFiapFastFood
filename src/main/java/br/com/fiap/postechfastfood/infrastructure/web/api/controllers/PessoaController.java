package br.com.fiap.postechfastfood.infrastructure.web.api.controllers;

import br.com.fiap.postechfastfood.domain.models.PessoaModel;
import br.com.fiap.postechfastfood.domain.ports.in.PessoaServicePort;
import br.com.fiap.postechfastfood.domain.services.PessoaService;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.PessoaResponseDto;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.PessoaRestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Tag(name="Pessoas", description = "end-point para gerenciar os clientes e funcionarios")
public class PessoaController {

    private final PessoaServicePort pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping("/v1/pessoa")
    @Operation(summary = "Cadastra pessoas", description = "Cadastra os clientes e funcionarios")
    public ResponseEntity<?> cadastrarPessoa(@Valid @RequestBody PessoaRestDto pessoaRequestDto) {

        PessoaResponseDto pessoaResponseDto = toResponseDto(pessoaService.cadastrarPessoa(toModel(pessoaRequestDto)));
        return ResponseEntity.created(URI.create("/api/v1/pessoa/" + pessoaResponseDto.cdDocPessoa()))
                .body(pessoaResponseDto);
    }

    @GetMapping("/v1/pessoa/{cdDocPessoa}")
    @Operation(summary = "Busca pessoa", description = "Busca o cliente ou funcionario por documento")
    public ResponseEntity<PessoaResponseDto> buscarPorCdDocPessoa(@PathVariable String cdDocPessoa) {
        Optional<PessoaModel> pessoaEncontrada = pessoaService.buscarPorCdDocPessoa(cdDocPessoa);
        if (pessoaEncontrada.isPresent()) {
            PessoaResponseDto pessoaResponseDto = toResponseDto(pessoaEncontrada.get());
            return ResponseEntity.ok(pessoaResponseDto);
        }
        return ResponseEntity.notFound().build();
    }

    private PessoaModel toModel(PessoaRestDto dto) {
        return new PessoaModel(dto.cdDocPessoa(), dto.nmPessoa(), dto.tpPessoa(), dto.dsEmail());
    }

    public PessoaRestDto toRestRequestDto(PessoaModel model) {
        return new PessoaRestDto(model);
    }

    public PessoaResponseDto toResponseDto(PessoaModel model) {
        return new PessoaResponseDto(model);
    }
}
