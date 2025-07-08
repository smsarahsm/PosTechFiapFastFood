package br.com.fiap.postechfasfood.interfaces;

import br.com.fiap.postechfasfood.gateways.entities.PessoaEntity;

public interface DbConnection {
    void CriarPessoa(PessoaEntity pessoaEntity);
    void criarPedido(PedidoEntity pedidoEntity);
}
