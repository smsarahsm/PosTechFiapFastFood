package br.com.fiap.postechfastfood.infrastructure.commons.mappers;

import br.com.fiap.postechfastfood.domain.models.ProdutoModel;
import br.com.fiap.postechfastfood.infrastructure.persistence.jpa.entities.ProdutoEntity;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.ProdutoResponseDto;

import java.util.List;
import java.util.stream.Collectors;

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

    public static ProdutoResponseDto toResponse(ProdutoModel produtoModel) {
        return new ProdutoResponseDto(produtoModel);
    }

    public static List<ProdutoResponseDto> mapeiaModelParaDTO(List<ProdutoModel> produtosModel) {
        return produtosModel.stream().map(ProdutoMapper::toResponse).collect(Collectors.toList());
    }
}
