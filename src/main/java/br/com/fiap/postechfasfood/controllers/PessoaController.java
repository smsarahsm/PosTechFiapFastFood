package br.com.fiap.postechfasfood.controllers;

import br.com.fiap.postechfasfood.apis.requests.PessoaWebHandlerRequest;
import br.com.fiap.postechfasfood.gateways.PessoaGateway;
import br.com.fiap.postechfasfood.interfaces.DbConnection;
import br.com.fiap.postechfasfood.usecases.PessoaUseCase;

public class PessoaController {

    public void criarEstudante(DbConnection dbConnection, PessoaWebHandlerRequest request){
        final PessoaGateway pessoaGateway = new PessoaGateway(dbConnection);
        PessoaUseCase pessoaUseCase = new PessoaUseCase();
        pessoaUseCase.criarPessoa(pessoaGateway, request);
    }

}
