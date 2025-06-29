package br.com.fiap.postechfasfood.interfaces;

import br.com.fiap.postechfasfood.gateways.entities.PessoaEntity;

public interface DbConnection {
    void CriarPessoa(PessoaEntity pessoaEntity);

    PessoaEntity BuscarPessoaPorCpf(String cdDocPessoa);
}
