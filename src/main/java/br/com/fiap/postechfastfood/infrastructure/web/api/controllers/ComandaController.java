package br.com.fiap.postechfastfood.infrastructure.web.api.controllers;

import br.com.fiap.postechfastfood.domain.services.ComandaService;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.ComandaResponseDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
public class ComandaController {
    private final ComandaService comandaService;

    public ComandaController(ComandaService comandaService) {
        this.comandaService = comandaService;
    }


    @GetMapping("/v1/comanda/{nrPedido}")
    public ResponseEntity<ComandaResponseDto> buscarPorNrPedido(@PathVariable String nrPedido) {
        ComandaResponseDto comandaResponseDto = comandaService.buscarPorNrPedido(nrPedido);
        if (comandaResponseDto != null) {
            return ResponseEntity.ok(comandaResponseDto);
        }
        return ResponseEntity.notFound().build();
    }
}

