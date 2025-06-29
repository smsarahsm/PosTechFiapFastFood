package br.com.fiap.postechfasfood.controllers;

import br.com.fiap.postechfasfood.adapters.PessoaWebHandlerAdapter;
import br.com.fiap.postechfasfood.apis.requests.PessoaWebHandlerRequest;
import br.com.fiap.postechfasfood.apis.responses.PessoaWebHandlerResponse;
import br.com.fiap.postechfasfood.gateways.PessoaGateway;
import br.com.fiap.postechfasfood.interfaces.DbConnection;
import br.com.fiap.postechfasfood.usecases.PessoaUseCase;

public class PessoaController {

    public PessoaWebHandlerResponse criarEstudante(DbConnection dbConnection, PessoaWebHandlerRequest request){
        final PessoaGateway pessoaGateway = new PessoaGateway(dbConnection);
        PessoaUseCase pessoaUseCase = new PessoaUseCase();
        var pessoaCriada = pessoaUseCase.criarPessoa(pessoaGateway, request);
        final PessoaWebHandlerAdapter pessoaWebHandlerAdapter = new PessoaWebHandlerAdapter();
        var response = pessoaWebHandlerAdapter.toResponseDto(pessoaCriada);
        return response;
    }

}
