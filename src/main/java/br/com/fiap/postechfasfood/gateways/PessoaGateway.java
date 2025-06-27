package br.com.fiap.postechfasfood.gateways;

import br.com.fiap.postechfasfood.entities.PessoaVO;
import br.com.fiap.postechfasfood.interfaces.DbConnection;
import br.com.fiap.postechfasfood.interfaces.PessoaGatewayInterface;

public class PessoaGateway implements PessoaGatewayInterface {

    private final DbConnection dbConnection;
    private final String nomeTabela = "tb_pessoas";

    public PessoaGateway (DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public void InserirPessoaNaBase(PessoaVO pessoaVO) {
        //TODO: implementar insert SQL na base
    }
}
