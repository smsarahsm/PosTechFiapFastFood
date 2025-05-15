package br.com.fiap.postechfastfood.infrastructure.web.api.controllers;

import br.com.fiap.postechfastfood.domain.services.ComandaService;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.ComandaResponseDto;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
public class ComandaController {
    private final ComandaService comandaService;

    public ComandaController(ComandaService comandaService) {
        this.comandaService = comandaService;
    }


    @GetMapping("/v1/comanda/{cdComanda")
    
    public ComandaResponseDto toResponse(ComandaResponseDto dto) {
        return new ComandaResponseDto(dto.cdPedido(), dto.stPedido());
    }
}
