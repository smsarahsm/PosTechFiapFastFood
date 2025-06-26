package br.com.fiap.postechfastfood_old.infrastructure.web.api.dtos;

import br.com.fiap.postechfastfood_old.domain.models.PedidoModel;
import br.com.fiap.postechfastfood_old.domain.models.ProdutoModel;

public record ProdutoPedidoRequestDto(ProdutoRequestDto produtoRequestDto, PedidoRequestDto pedidoRequestDto, int vlQuantidadeProduto) {
    public ProdutoPedidoRequestDto(ProdutoModel produtoModel, PedidoModel pedidoModel, int vlQuantidadeProduto) {
        this(new ProdutoRequestDto(produtoModel), new PedidoRequestDto(pedidoModel), vlQuantidadeProduto);
    }
}
