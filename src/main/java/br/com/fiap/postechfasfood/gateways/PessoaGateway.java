package br.com.fiap.postechfasfood.gateways;

import java.util.List;

import br.com.fiap.postechfasfood.interfaces.PessoaRepositoryInterface;
import org.springframework.stereotype.Service;

import br.com.fiap.postechfasfood.entities.PessoaVO;
import br.com.fiap.postechfasfood.interfaces.PessoaGatewayInterface;

@Service
public class PessoaGateway implements PessoaGatewayInterface {

    private final PessoaRepositoryInterface pessoaRepository;

    public PessoaGateway(PessoaRepositoryInterface pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public PessoaVO inserirPessoaNaBase(PessoaVO pessoaVO) {
        pessoaRepository.criarPessoa(pessoaVO);
        return pessoaVO;
    }

    @Override
    public PessoaVO buscarPessoaPorCpf(String cpf) {
        return pessoaRepository.buscarPessoaPorCpf(cpf);
    }

    @Override
    public List<PessoaVO> listarTodasPessoas() {
        return pessoaRepository.listarTodasPessoas();
    }

    @Override
    public void removerPessoa(String cdDocPessoa) {
        pessoaRepository.removerPessoa(cdDocPessoa);
    }
}