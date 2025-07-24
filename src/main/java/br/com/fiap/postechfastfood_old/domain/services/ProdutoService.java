package br.com.fiap.postechfastfood_old.domain.services;

import br.com.fiap.postechfastfood_old.domain.enums.TipoCategoriaProdutoEnum;
import br.com.fiap.postechfastfood_old.domain.models.ProdutoModel;
import br.com.fiap.postechfastfood_old.domain.ports.in.ProdutoServicePort;
import br.com.fiap.postechfastfood_old.domain.ports.out.ProdutoRepositoryPort;

import java.util.List;
import java.util.UUID;

public class ProdutoService implements ProdutoServicePort {

    private final ProdutoRepositoryPort produtoRepositoryPort;

    public ProdutoService(ProdutoRepositoryPort produtoRepositoryPort) {
        this.produtoRepositoryPort = produtoRepositoryPort;
    }

    @Override
    public ProdutoModel cadastrar(ProdutoModel produto) {
        produto.setCdProduto(UUID.randomUUID());
        return produtoRepositoryPort.cadastrar(produto);
    }

    @Override
    public ProdutoModel atualizar(UUID cdProduto, ProdutoModel produto) {
        produto.setCdProduto(cdProduto);
        return produtoRepositoryPort.atualizar(cdProduto, produto);
    }

    @Override
    public void desativar(UUID cdProduto) {
        produtoRepositoryPort.desativar(cdProduto);
    }

    @Override
    public void ativar(UUID cdProduto) {
        produtoRepositoryPort.ativar(cdProduto);
    }

    @Override
    public List<ProdutoModel> buscar() {
        return produtoRepositoryPort.buscar();
    }

    @Override
    public List<ProdutoModel> buscar(TipoCategoriaProdutoEnum tpCategoria) {
return produtoRepositoryPort.buscar(tpCategoria);
    }
}
