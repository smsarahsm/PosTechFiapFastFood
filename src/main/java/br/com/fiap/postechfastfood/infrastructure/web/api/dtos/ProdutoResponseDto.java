package br.com.fiap.postechfastfood.infrastructure.web.api.dtos;

import br.com.fiap.postechfastfood.domain.enums.TipoCategoriaProdutoEnum;
import br.com.fiap.postechfastfood.domain.models.ProdutoModel;

public record ProdutoResponseDto(String cdProduto,
                                 String nmProduto,
                                 String dsDescricao,
                                 double vlPreco,
                                 TipoCategoriaProdutoEnum tpCategoria) {
    public ProdutoResponseDto(ProdutoModel model){
        this(model.getCdProduto(), model.getNmProduto(), model.getDsDescricao(), model.getVlPreco(), model.getTpCategoria());
    }
}
