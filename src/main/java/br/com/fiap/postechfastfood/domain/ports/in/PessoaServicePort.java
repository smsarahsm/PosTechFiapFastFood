package br.com.fiap.postechfastfood.domain.ports.in;

import br.com.fiap.postechfastfood.domain.models.PessoaModel;

import java.util.List;
import java.util.Optional;

public interface PessoaServicePort {

    PessoaModel cadastrarPessoa(PessoaModel model);
    Optional<PessoaModel> buscarPorCdDocPessoa(String cdDocPessoa);
    List<PessoaModel> listarTodasPessoas();
    void removerPessoa(String cdDocPessoa);
}
