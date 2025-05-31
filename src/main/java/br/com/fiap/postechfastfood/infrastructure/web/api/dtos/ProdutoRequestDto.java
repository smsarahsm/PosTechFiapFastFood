package br.com.fiap.postechfastfood.infrastructure.web.api.dtos;


import br.com.fiap.postechfastfood.domain.enums.TipoCategoriaProdutoEnum;
import br.com.fiap.postechfastfood.domain.models.ProdutoModel;

import java.util.UUID;


public record ProdutoRequestDto(UUID cdProduto,
                                String nmProduto,
                                String dsDescricao,
                                double vlPreco,
                                boolean snAtivo,
                                TipoCategoriaProdutoEnum tpCategoria) {
    public ProdutoRequestDto(ProdutoModel model){
       this(model.getCdProduto(), model.getNmProduto(), model.getDsDescricao(), model.getVlPreco(), model.getSnAtivo(),
               model.getTpCategoria());
    }
}

