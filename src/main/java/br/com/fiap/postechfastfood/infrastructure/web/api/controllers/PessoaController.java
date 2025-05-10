package br.com.fiap.postechfastfood.infrastructure.web.api.controllers;

import br.com.fiap.postechfastfood.domain.services.PessoaService;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.PessoaRequestDto;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.PessoaResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping("/v1/pessoa")
    public ResponseEntity<PessoaResponseDto> cadastrarPessoa(@RequestBody PessoaRequestDto pessoaRequestDto) {
        PessoaResponseDto pessoaResponseDto = pessoaService.cadastrarPessoa(pessoaRequestDto);
        return ResponseEntity.created(URI.create("/api/v1/pessoa/" + pessoaResponseDto.cdDocPessoa()))
                .body(pessoaResponseDto);
    }

    @GetMapping("/v1/pessoa/{cdDocPessoa}")
    public ResponseEntity<PessoaResponseDto> buscarPorCdDocPessoa(@PathVariable String cdDocPessoa) {
        PessoaResponseDto pessoaResponseDto = pessoaService.buscarPorCdDocPessoa(cdDocPessoa);
        return ResponseEntity.ok(pessoaResponseDto);
    }

    private PessoaRequestDto toRequest(PessoaResponseDto dto) {
        return new PessoaRequestDto(dto.cdDocPessoa(), dto.nmPessoa(), dto.tpPessoa(), dto.dsEmail());
    }

    public PessoaResponseDto toResponse(PessoaRequestDto dto) {
        return new PessoaResponseDto(dto.cdDocPessoa(), dto.nmPessoa(), dto.tpPessoa(), dto.dsEmail());
    }
}
