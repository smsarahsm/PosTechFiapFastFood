package br.com.fiap.postechfasfood.interfaces;

import br.com.fiap.postechfasfood.entities.PessoaVO;

import java.util.List;

public interface PessoaRepositoryInterface {

    void criarPessoa(PessoaVO pessoa);
    PessoaVO buscarPessoaPorCpf(String cdDocPessoa);
    List<PessoaVO> listarTodasPessoas();
    void removerPessoa(String cdDocPessoa);
}
