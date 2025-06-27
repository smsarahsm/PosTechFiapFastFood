package br.com.fiap.postechfasfood.interfaces;

import jakarta.persistence.Table;

import java.util.List;

public interface DbConnection {
    void CriarPessoa(String nomeTabela, List<String> parametros);
}
