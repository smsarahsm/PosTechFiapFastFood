package br.com.fiap.postechfastfood.domain.ports.in;


import br.com.fiap.postechfastfood.domain.enums.TipoCategoriaProdutoEnum;
import br.com.fiap.postechfastfood.domain.models.ProdutoModel;

import java.util.List;
import java.util.UUID;

public interface ProdutoServicePort {

    ProdutoModel cadastrar(ProdutoModel produto);
    ProdutoModel atualizar(UUID cdProduto, ProdutoModel produto);
    void deletar(UUID cdProduto);
    List<ProdutoModel> buscar();
    List<ProdutoModel> buscar(TipoCategoriaProdutoEnum tpCategoria);
}
