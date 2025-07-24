package br.com.fiap.postechfastfood_old.domain.ports.out;

import br.com.fiap.postechfastfood_old.domain.models.PessoaModel;

import java.util.List;
import java.util.Optional;

public interface PessoaRepositoryPort {

    PessoaModel cadastrarPessoa(PessoaModel pessoaModel);
    Optional<PessoaModel> buscarPorCdDocPessoa(String cdDocPessoa);
    List<PessoaModel> listarTodasPessoas();
    void removerPessoa(String cdDocPessoa);
}
