package br.com.fiap.postechfastfood.infrastructure.web.api.controllers;

import br.com.fiap.postechfastfood.domain.models.PessoaModel;
import br.com.fiap.postechfastfood.domain.ports.in.PessoaServicePort;
import br.com.fiap.postechfastfood.domain.services.PessoaService;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.PessoaResponseDto;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.PessoaRestDto;
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
public class PessoaController {

    private final PessoaServicePort pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping("/v1/pessoa")
    public ResponseEntity<?> cadastrarPessoa(@Valid @RequestBody PessoaRestDto pessoaRequestDto) {

        Optional<PessoaModel> pessoaEncontrada = pessoaService.buscarPorCdDocPessoa(pessoaRequestDto.cdDocPessoa());
        if (pessoaEncontrada.isPresent()) {
            Map<String,String> error = new HashMap<>();
            error.put("error", "Cliente já cadastrado com o CPF informado");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
        PessoaResponseDto pessoaResponseDto = toResponseDto(pessoaService.cadastrarPessoa(toModel(pessoaRequestDto)));
        return ResponseEntity.created(URI.create("/api/v1/pessoa/" + pessoaResponseDto.cdDocPessoa()))
                .body(pessoaResponseDto);
    }

    @GetMapping("/v1/pessoa/{cdDocPessoa}")
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
