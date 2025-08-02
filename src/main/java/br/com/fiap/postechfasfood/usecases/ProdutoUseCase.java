package br.com.fiap.postechfasfood.usecases;


import br.com.fiap.postechfasfood.apis.requests.ProdutoWebHandlerRequest;
import br.com.fiap.postechfasfood.entities.ProdutoVO;
import br.com.fiap.postechfasfood.gateways.ProdutoGateway;
import br.com.fiap.postechfasfood.types.TipoCategoriaProdutoEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;


@Service
public class ProdutoUseCase {

    private final ProdutoGateway produtoGateway;

    public ProdutoUseCase(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    public ProdutoVO cadastrar(ProdutoWebHandlerRequest request) {
        ProdutoVO produto = request.toProdutoVO();
        produto.setCdProduto(UUID.randomUUID());
        produtoGateway.cadastrar(produto);
        return produto;
    }

    public void atualizar(UUID cdProduto, ProdutoWebHandlerRequest request) {
        ProdutoVO produto = request.toProdutoVO();
        produtoGateway.atualizar(cdProduto, produto);
    }

    public void desativar(UUID cdProduto) {
        produtoGateway.desativar(cdProduto);
    }

    public void ativar(UUID cdProduto) {
        produtoGateway.ativar(cdProduto);
    }

    public List<ProdutoVO> listar() {
        return new ArrayList<>(produtoGateway.listar());
    }

    public List<ProdutoVO> listarPorCategoria(TipoCategoriaProdutoEnum tpCategoria) {
        return new ArrayList<>(produtoGateway.listar(tpCategoria));
    }

    public ProdutoVO buscarPorCdProduto(UUID cdProduto) {
        return produtoGateway.buscarPorCdProduto(cdProduto);
    }
}

