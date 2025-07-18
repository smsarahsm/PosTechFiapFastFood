package br.com.fiap.postechfasfood.controllers;

import br.com.fiap.postechfasfood.adapters.PessoaWebHandlerAdapter;
import br.com.fiap.postechfasfood.apis.requests.PessoaWebHandlerRequest;
import br.com.fiap.postechfasfood.apis.responses.PessoaWebHandlerResponse;
import br.com.fiap.postechfasfood.interfaces.PessoaRepositoryInterface;
import br.com.fiap.postechfasfood.gateways.PessoaGateway;
import br.com.fiap.postechfasfood.usecases.PessoaUseCase;

public class PessoaController {

    public PessoaWebHandlerResponse criarPessoa(PessoaRepositoryInterface pessoaRepository, PessoaWebHandlerRequest request){
        final PessoaGateway pessoaGateway = new PessoaGateway(pessoaRepository);
        PessoaUseCase pessoaUseCase = new PessoaUseCase(pessoaGateway);
        var pessoaCriada = pessoaUseCase.criarPessoa(pessoaGateway, request);
        final PessoaWebHandlerAdapter pessoaWebHandlerAdapter = new PessoaWebHandlerAdapter();
        var response = pessoaWebHandlerAdapter.toResponseDto(pessoaCriada);
        return response;
    }

    public PessoaWebHandlerResponse buscarPessoaPorCpf(PessoaRepositoryInterface pessoaRepository, String cdDocPessoa) {
        final PessoaGateway pessoaGateway = new PessoaGateway(pessoaRepository);
        PessoaUseCase pessoaUseCase = new PessoaUseCase(pessoaGateway);
        var pessoa = pessoaUseCase.buscarPessoaPorCpf(cdDocPessoa);
        final PessoaWebHandlerAdapter pessoaWebHandlerAdapter = new PessoaWebHandlerAdapter();
        var response = pessoaWebHandlerAdapter.toResponseDto(pessoa);
        return response;
    }

}
