package br.com.fiap.postechfasfood.interfaces;

import br.com.fiap.postechfasfood.entities.ProdutoVO;
import br.com.fiap.postechfasfood.types.TipoCategoriaProdutoEnum;

import java.util.List;
import java.util.UUID;

public interface ProdutoGatewayInterface {

    void cadastrar(ProdutoVO produto);
    void atualizar(String cdProduto, ProdutoVO produto);
    void desativar(String cdProduto);
    void ativar(String cdProduto);
    List<ProdutoVO> listar();
    List<ProdutoVO> listar(TipoCategoriaProdutoEnum tpCategoria);
    ProdutoVO buscarPorCdProduto(String cdProduto);
}
