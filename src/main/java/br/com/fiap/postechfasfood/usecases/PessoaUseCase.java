package br.com.fiap.postechfasfood.usecases;

import br.com.fiap.postechfasfood.apis.requests.PessoaWebHandlerRequest;
import br.com.fiap.postechfasfood.entities.PessoaVO;
import br.com.fiap.postechfasfood.gateways.PessoaGateway;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fiap.postechfasfood.apis.exceptions.CpfCadastradoException;

@Service
public class PessoaUseCase {

    private final PessoaGateway pessoaGateway;

    public PessoaUseCase(PessoaGateway pessoaGateway) {
        this.pessoaGateway = pessoaGateway;
    }
     public PessoaVO criarPessoa(PessoaGateway pessoaGateway, PessoaWebHandlerRequest request) {
        // Verifica se já existe uma pessoa com o mesmo CPF
        PessoaVO pessoaExistente = pessoaGateway.buscarPessoaPorCpf(request.cdDocPessoa());
        if (pessoaExistente != null) {
            throw new CpfCadastradoException("Cliente já cadastrado com o CPF informado");
        }

        var pessoa = new PessoaVO(
                request.cdDocPessoa(),
                request.nmPessoa(),
                request.tpPessoa(),
                request.dsEmail());
        var pessoaCriada = pessoaGateway.inserirPessoaNaBase(pessoa);
        return pessoaCriada;
    }

    public PessoaVO buscarPessoaPorCpf(String cdDocPessoa) {
        return pessoaGateway.buscarPessoaPorCpf(cdDocPessoa);
    }

    public List<PessoaVO> listarTodasPessoas() {
        return new ArrayList<>(pessoaGateway.listarTodasPessoas());
    }

    public void removerPessoa(String cdDocPessoa) {
        pessoaGateway.removerPessoa(cdDocPessoa);
    }
}