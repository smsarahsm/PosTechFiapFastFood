package br.com.fiap.postechfasfood.interfaces;

import java.util.List;

import br.com.fiap.postechfasfood.entities.PessoaVO;

public interface PessoaGatewayInterface {
    PessoaVO inserirPessoaNaBase(PessoaVO pessoaVO);
    PessoaVO buscarPessoaPorCpf(String cpf);
    List<PessoaVO> listarTodasPessoas();
    void removerPessoa(String cdDocPessoa);
}


