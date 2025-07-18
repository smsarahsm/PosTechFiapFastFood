package br.com.fiap.postechfasfood.interfaces;

import br.com.fiap.postechfasfood.entities.ProdutoVO;
import br.com.fiap.postechfasfood.types.TipoCategoriaProdutoEnum;

import java.util.List;
import java.util.UUID;

public interface ProdutoRepositoryInterface {

    void cadastrar(ProdutoVO produto);
    void atualizar(UUID cdProduto, ProdutoVO produto);
    void desativar(UUID cdProduto);
    void ativar(UUID cdProduto);
    List<ProdutoVO> listar();
    List<ProdutoVO> listar(TipoCategoriaProdutoEnum tpCategoria);
    ProdutoVO buscarPorCdProduto(UUID cdProduto);
}
