package br.com.fiap.postechfastfood.infrastructure.persistence.jpa.mappers;

import br.com.fiap.postechfastfood.domain.models.ComandaModel;
import br.com.fiap.postechfastfood.infrastructure.persistence.jpa.entities.ComandaEntity;


public class ComandaMapper {

    public static ComandaEntity toEntity(ComandaModel model) {
        ComandaEntity e = new ComandaEntity();
        e.setCdPedido(model.getCdPedido());
        e.setCdDocFuncionario(model.getCdDocFuncionario());
        e.setTxStatus(model.getTxStatus());
        e.setNrPedido(model.getNrPedido());
        e.setDhCriacaoPedido(model.getDhCriacaoPedido());
        e.setDhUltAtualizacao(model.getDhUltAtualizacao());
        return e;
    }

    public static ComandaModel toModel(ComandaEntity entity) {
        ComandaModel m = new ComandaModel();
        m.setCdPedido( entity.getCdPedido());
        m.setCdDocFuncionario( entity.getCdDocFuncionario());
        m.setTxStatus(entity.getTxStatus());
        m.setNrPedido( entity.getNrPedido());
        m.setDhCriacaoPedido( entity.getDhCriacaoPedido() );
        m.setDhUltAtualizacao( entity.getDhUltAtualizacao() );;
        return m;
    }
}


