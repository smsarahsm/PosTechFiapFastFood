package br.com.fiap.postechfastfood.infrastructure.persistence.jpa.mappers;

import br.com.fiap.postechfastfood.domain.models.ComandaModel;
import br.com.fiap.postechfastfood.infrastructure.persistence.jpa.entities.ComandaEntity;

public class ComandaMapper {

    public static ComandaEntity toEntity(ComandaModel model) {
        ComandaEntity e = new ComandaEntity();
        e.setCdPedido( model.getCdPedido() );
        e.setStPedido( model.getStPedido() );
        return e;
    }

    public static ComandaModel toModel(ComandaEntity entity) {
        ComandaModel m = new ComandaModel();
        m.setCdPedido( entity.getCdPedido() );
        m.setStPedido( entity.getStPedido() );
        return m;
    }
}


