package br.com.fiap.postechfasfood.gateways;

import br.com.fiap.postechfasfood.entities.PessoaVO;
import br.com.fiap.postechfasfood.gateways.entities.PessoaEntity;
import br.com.fiap.postechfasfood.interfaces.DbConnection;
import br.com.fiap.postechfasfood.interfaces.PessoaGatewayInterface;

public class PessoaGateway implements PessoaGatewayInterface {

    private final DbConnection dbConnection;

    public PessoaGateway(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    //TODO:sei que ta errado, mas ainda não sei fazer certo... melhorar...

    @Override
    public PessoaVO InserirPessoaNaBase(PessoaVO pessoaVO) {
        //TODO: implementar insert SQL na base
        PessoaEntity pessoaEntity = toEntity(pessoaVO);
        dbConnection.CriarPessoa(pessoaEntity);
        return toVo(pessoaEntity);
    }

    private PessoaEntity toEntity(PessoaVO pessoaVO) {
        PessoaEntity e = new PessoaEntity();
        e.setNmPessoa(pessoaVO.getNmPessoa());
        e.setCdDocPessoa(pessoaVO.getCdDocPessoa());
        e.setTpPessoa(pessoaVO.getTpPessoa());
        e.setDsEmail(pessoaVO.getDsEmail());
        return e;
    }

    private PessoaVO toVo(PessoaEntity pessoaEntity) {
        PessoaVO p = new PessoaVO();
        p.setNmPessoa(pessoaEntity.getNmPessoa());
        p.setCdDocPessoa(pessoaEntity.getCdDocPessoa());
        p.setTpPessoa(pessoaEntity.getTpPessoa());
        p.setDsEmail(pessoaEntity.getDsEmail());
        return p;
    }
}
