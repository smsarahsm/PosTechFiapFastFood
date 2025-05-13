package br.com.fiap.postechfastfood.domain.services;

import br.com.fiap.postechfastfood.domain.models.ComandaModel;
import br.com.fiap.postechfastfood.domain.ports.out.ComandaRepositoryPort;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.ComandaResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class ComandaService {

    private final ComandaRepositoryPort comandaRepository;

    public ComandaService(ComandaRepositoryPort comandaRepository) {
        this.comandaRepository = comandaRepository;
    }


    public ComandaResponseDto buscarPorCdPedido(String cdPedido) {
        ComandaModel comandaModel = comandaRepository.buscarPorCdPedido(cdPedido).orElseThrow(() -> new IllegalArgumentException("Comanda não encontrada"));
        return toResponse(comandaModel);
    }

    public List<ComandaResponseDto> listarTodosPedidos() {
        return comandaRepository.listarTodosPedidos().stream().map(this::toResponse).collect(Collectors.toList());
    }


    private ComandaResponseDto toResponse(ComandaModel comandaModel) {
        return new ComandaResponseDto(comandaModel);
    }
}
