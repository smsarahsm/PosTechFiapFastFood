package br.com.fiap.postechfastfood.domain.ports.out;

import br.com.fiap.postechfastfood.domain.enums.TipoCategoriaProdutoEnum;
import br.com.fiap.postechfastfood.domain.models.ProdutoModel;

import java.util.List;

public interface ProdutoRepositoryPort {
    ProdutoModel cadastrar(ProdutoModel produto);
    ProdutoModel atualizar(String cdProduto, ProdutoModel produto);
    void deletar(String cdProduto);
    List<ProdutoModel> buscar();
    List<ProdutoModel> buscar(TipoCategoriaProdutoEnum tpCategoria);
}
