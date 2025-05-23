package br.com.fiap.postechfastfood.infrastructure.commons.mappers;

import br.com.fiap.postechfastfood.domain.models.PessoaModel;
import br.com.fiap.postechfastfood.infrastructure.persistence.jpa.entities.PessoaEntity;

public class PessoaMapper {

    public static PessoaEntity toEntity(PessoaModel model) {
        PessoaEntity e = new PessoaEntity();
        e.setCdDocPessoa( model.getCdDocPessoa() );
        e.setNmPessoa( model.getNmPessoa() );
        e.setTpPessoa( model.getTpPessoa() );
        e.setDsEmail( model.getDsEmail() );
        return e;
    }

    public static PessoaModel toModel(PessoaEntity entity) {
        PessoaModel m = new PessoaModel();
        m.setCdDocPessoa( entity.getCdDocPessoa() );
        m.setNmPessoa( entity.getNmPessoa() );
        m.setTpPessoa( entity.getTpPessoa() );
        m.setDsEmail( entity.getDsEmail() );
        return m;
    }
}

