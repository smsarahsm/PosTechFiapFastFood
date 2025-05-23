package br.com.fiap.postechfastfood.infrastructure.commons.mappers;

import br.com.fiap.postechfastfood.domain.models.ProdutosPedidoModel;
import br.com.fiap.postechfastfood.infrastructure.persistence.jpa.entities.ProdutosPedidoEntity;

public class ProdutosPedidoMapper {
    public static ProdutosPedidoEntity modelToEntity(ProdutosPedidoModel model) {
        ProdutosPedidoEntity entity = new ProdutosPedidoEntity();
        entity.setPedido(PedidoMapper.modelToEntity(model.getPedido()));
        entity.setProduto(ProdutoMapper.toEntity(model.getProduto()));
        entity.setVlQuantidadeProduto(model.getVlQuantidade());
        return entity;
    }

    public static ProdutosPedidoModel entityToModel(ProdutosPedidoEntity entity) {
        ProdutosPedidoModel model = new ProdutosPedidoModel();
        model.setPedido(PedidoMapper.entityToModel(entity.getPedido()));
        model.setProduto(ProdutoMapper.toModel(entity.getProduto()));
        model.setVlQuantidade(entity.getVlQuantidadeProduto());
        return model;
    }
}
