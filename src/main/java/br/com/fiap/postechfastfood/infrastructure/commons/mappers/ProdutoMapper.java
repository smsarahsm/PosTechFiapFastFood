package br.com.fiap.postechfastfood.infrastructure.commons.mappers;

import br.com.fiap.postechfastfood.domain.models.ProdutoModel;
import br.com.fiap.postechfastfood.infrastructure.persistence.jpa.entities.ProdutoEntity;

public class ProdutoMapper {

    public static ProdutoEntity toEntity(ProdutoModel model){
        ProdutoEntity e = new ProdutoEntity();
        e.setCdProduto(model.getCdProduto());
        e.setNmProduto(model.getNmProduto());
        e.setDsDescricao(model.getDsDescricao());
        e.setVlPreco(model.getVlPreco());
        e.setTpCategoria(model.getTpCategoria());
        return e;
    }

    public static ProdutoModel toModel(ProdutoEntity entity){
        ProdutoModel m = new ProdutoModel();
        m.setCdProduto(entity.getCdProduto());
        m.setNmProduto(entity.getNmProduto());
        m.setDsDescricao(entity.getDsDescricao());
        m.setVlPreco(entity.getVlPreco());
        m.setTpCategoria(entity.getTpCategoria());
        return m;
    }
}
