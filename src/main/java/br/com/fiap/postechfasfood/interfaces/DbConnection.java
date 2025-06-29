package br.com.fiap.postechfasfood.interfaces;

import br.com.fiap.postechfasfood.gateways.entities.PessoaEntity;
import jakarta.persistence.Table;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DbConnection {
//    void CriarPessoa(String nomeTabela, List<String> parametros);
    void CriarPessoa(PessoaEntity pessoaEntity);
}
