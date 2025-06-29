package br.com.fiap.postechfasfood.usecases;

import br.com.fiap.postechfasfood.apis.requests.PessoaWebHandlerRequest;
import br.com.fiap.postechfasfood.entities.PessoaVO;
import br.com.fiap.postechfasfood.gateways.PessoaGateway;

public class PessoaUseCase {
    public void criarPessoa (PessoaGateway pessoaGateway, PessoaWebHandlerRequest request){
    //TODO: verificar se o estudante já existe
    var pessoa = new PessoaVO(
            request.cdDocPessoa(),
            request.nmPessoa(),
            request.tpPessoa(),
            request.dsEmail());
    var pessoaCriada = pessoaGateway.InserirPessoaNaBase(pessoa);
    System.out.println("ta ai a nossa nova pessoa: " + pessoaCriada.toString());
    }
}
