package br.com.fiap.postechfasfood.interfaces;

import br.com.fiap.postechfasfood.entities.PessoaVO;

public interface PessoaGatewayInterface {
    PessoaVO InserirPessoaNaBase(PessoaVO pessoaVO);
    PessoaVO buscarPessoaPorCpf(String cpf);
}
