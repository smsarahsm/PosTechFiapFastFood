package br.com.fiap.postechfastfood.domain.services;

import br.com.fiap.postechfastfood.domain.models.PessoaModel;
import br.com.fiap.postechfastfood.domain.ports.in.PessoaServicePort;
import br.com.fiap.postechfastfood.domain.ports.out.PessoaRepositoryPort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PessoaService implements PessoaServicePort {

    private final PessoaRepositoryPort pessoaRepository;

    public PessoaService(PessoaRepositoryPort pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public PessoaModel cadastrarPessoa(PessoaModel model) {
        return pessoaRepository.cadastrarPessoa(model);
    }

    public Optional<PessoaModel> buscarPorCdDocPessoa(String cdDocPessoa) {
        return pessoaRepository.buscarPorCdDocPessoa(cdDocPessoa);
    }

    public List<PessoaModel> listarTodasPessoas() {
        return new ArrayList<>(pessoaRepository.listarTodasPessoas());
    }

    public void removerPessoa(String cdDocPessoa) {
        pessoaRepository.removerPessoa(cdDocPessoa);
    }
}
