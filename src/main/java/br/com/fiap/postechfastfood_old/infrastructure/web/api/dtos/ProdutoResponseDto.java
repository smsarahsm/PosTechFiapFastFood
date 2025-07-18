package br.com.fiap.postechfastfood_old.infrastructure.web.api.dtos;

import br.com.fiap.postechfastfood_old.domain.enums.TipoCategoriaProdutoEnum;
import br.com.fiap.postechfastfood_old.domain.models.ProdutoModel;

import java.util.UUID;

public record ProdutoResponseDto(UUID cdProduto,
                                 String nmProduto,
                                 String dsDescricao,
                                 double vlPreco,
                                 boolean snAtivo,
                                 TipoCategoriaProdutoEnum tpCategoria) {
    public ProdutoResponseDto(ProdutoModel model){
        this(model.getCdProduto(), model.getNmProduto(), model.getDsDescricao(), model.getVlPreco(), model.getSnAtivo(),
                model.getTpCategoria());
    }
}
