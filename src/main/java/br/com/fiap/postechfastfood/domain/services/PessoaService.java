package br.com.fiap.postechfastfood.domain.services;

import br.com.fiap.postechfastfood.domain.models.PessoaModel;
import br.com.fiap.postechfastfood.domain.ports.out.PessoaRepositoryPort;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.PessoaRequestDto;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.PessoaResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class PessoaService {

    private final PessoaRepositoryPort pessoaRepository;

    public PessoaService(PessoaRepositoryPort pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public PessoaResponseDto cadastrarPessoa(PessoaRequestDto pessoaRequestDto) {
        PessoaModel pessoaModel = new PessoaModel.Builder()
                .setCdDocPessoa(pessoaRequestDto.cdDocPessoa())
                .setNmPessoa(pessoaRequestDto.nmPessoa())
                .setTpPessoa(pessoaRequestDto.tpPessoa())
                .setDsEmail(pessoaRequestDto.dsEmail())
                .build();
        PessoaModel pessoaSalva = pessoaRepository.cadastrarPessoa(pessoaModel);
        return toResponse(pessoaSalva);
    }

    public PessoaResponseDto buscarPorCdDocPessoa(String cdDocPessoa) {
        PessoaModel pessoaModel = pessoaRepository.buscarPorCdDocPessoa(cdDocPessoa).orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada"));
        return toResponse(pessoaModel);
    }

    public List<PessoaResponseDto> listarTodasPessoas() {
        return pessoaRepository.listarTodasPessoas().stream().map(this::toResponse).collect(Collectors.toList());
    }

    public void removerPessoa(String cdDocPessoa) {
        pessoaRepository.removerPessoa(cdDocPessoa);
    }

    private PessoaResponseDto toResponse(PessoaModel pessoaModel) {
        return new PessoaResponseDto(pessoaModel);
    }
}
