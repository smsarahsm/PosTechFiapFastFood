package br.com.fiap.postechfastfood.domain.ports.out;

import br.com.fiap.postechfastfood.domain.enums.TipoCategoriaProdutoEnum;
import br.com.fiap.postechfastfood.domain.models.ProdutoModel;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepositoryPort {
    ProdutoModel cadastrar(ProdutoModel produto);
    ProdutoModel atualizar(String cdProduto, ProdutoModel produto);
    void deletar(String cdProduto);
    Optional<List<ProdutoModel>> buscar();
    Optional<List<ProdutoModel>> buscar(TipoCategoriaProdutoEnum tpCategoria);
}
