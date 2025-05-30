package br.com.fiap.postechfastfood.domain.ports.out;

import br.com.fiap.postechfastfood.domain.enums.TipoCategoriaProdutoEnum;
import br.com.fiap.postechfastfood.domain.models.ProdutoModel;

import java.util.List;
import java.util.UUID;

public interface ProdutoRepositoryPort {
    ProdutoModel cadastrar(ProdutoModel produto);
    ProdutoModel atualizar(UUID cdProduto, ProdutoModel produto);
    void desativar(UUID cdProduto);
    void ativar(UUID cdProduto);
    List<ProdutoModel> buscar();
    List<ProdutoModel> buscar(TipoCategoriaProdutoEnum tpCategoria);
}
