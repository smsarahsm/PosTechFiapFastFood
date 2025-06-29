package br.com.fiap.postechfasfood.usecases;

import br.com.fiap.postechfasfood.apis.requests.PessoaWebHandlerRequest;
import br.com.fiap.postechfasfood.entities.PessoaVO;
import br.com.fiap.postechfasfood.gateways.PessoaGateway;

import org.springframework.stereotype.Service;

import br.com.fiap.postechfasfood.apis.exceptions.CpfCadastradoException;

@Service
public class PessoaUseCase {
     public PessoaVO criarPessoa(PessoaGateway pessoaGateway, PessoaWebHandlerRequest request) {
        // Verifica se já existe uma pessoa com o mesmo CPF
        PessoaVO pessoaExistente = pessoaGateway.buscarPessoaPorCpf(request.cdDocPessoa());
        if (pessoaExistente != null) {
            throw new CpfCadastradoException("CPF já cadastrado: " + request.cdDocPessoa());
        }

        var pessoa = new PessoaVO(
                request.cdDocPessoa(),
                request.nmPessoa(),
                request.tpPessoa(),
                request.dsEmail());
        var pessoaCriada = pessoaGateway.InserirPessoaNaBase(pessoa);
        return pessoaCriada;
    }
}