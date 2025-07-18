package br.com.fiap.postechfasfood.controllers;

import java.util.UUID;
import br.com.fiap.postechfasfood.adapters.ProdutoWebHandlerAdapter;
import br.com.fiap.postechfasfood.apis.requests.ProdutoWebHandlerRequest;
import br.com.fiap.postechfasfood.apis.responses.ProdutoWebHandlerResponse;
import br.com.fiap.postechfasfood.gateways.ProdutoGateway;
import br.com.fiap.postechfasfood.interfaces.ProdutoRepositoryInterface;
import br.com.fiap.postechfasfood.types.TipoCategoriaProdutoEnum;
import br.com.fiap.postechfasfood.usecases.ProdutoUseCase;
import java.util.List;
import java.util.ArrayList;

public class ProdutoController {

    public ProdutoWebHandlerResponse cadastrar
    (ProdutoRepositoryInterface produtoRepository, ProdutoWebHandlerRequest request) {
        final ProdutoGateway produtoGateway = new ProdutoGateway(produtoRepository);
        ProdutoUseCase produtoUseCase = new ProdutoUseCase(produtoGateway);
        var produtoCriado = produtoUseCase.cadastrar(request);
        final ProdutoWebHandlerAdapter produtoWebHandlerAdapter = new ProdutoWebHandlerAdapter();
        var response = produtoWebHandlerAdapter.toResponseDto(produtoCriado);
        return response;
    }
    public ProdutoWebHandlerResponse buscarProdutoPorCdProduto
    (ProdutoRepositoryInterface produtoRepository, UUID cdProduto) {
        final ProdutoGateway produtoGateway = new ProdutoGateway(produtoRepository);
        ProdutoUseCase produtoUseCase = new ProdutoUseCase(produtoGateway);
        var produto = produtoUseCase.buscarPorCdProduto(cdProduto);
        final ProdutoWebHandlerAdapter produtoWebHandlerAdapter = new ProdutoWebHandlerAdapter();
        var response = produtoWebHandlerAdapter.toResponseDto(produto);
        return response;
    }
    public ProdutoWebHandlerResponse atualizarProduto(
    ProdutoRepositoryInterface produtoRepository,
    UUID cdProduto,
    ProdutoWebHandlerRequest produtoWebHandlerRequest) {

    final ProdutoGateway produtoGateway = new ProdutoGateway(produtoRepository);
    ProdutoUseCase produtoUseCase = new ProdutoUseCase(produtoGateway);
    final ProdutoWebHandlerAdapter adapter = new ProdutoWebHandlerAdapter();

    produtoUseCase.atualizar(cdProduto, produtoWebHandlerRequest);
    var produtoAtualizado = produtoUseCase.buscarPorCdProduto(cdProduto);

    if (produtoAtualizado == null) return null;

    return adapter.toResponseDto(produtoAtualizado);
}

    public void desativarProduto(ProdutoRepositoryInterface produtoRepository, UUID cdProduto) {
        final ProdutoGateway produtoGateway = new ProdutoGateway(produtoRepository);
        ProdutoUseCase produtoUseCase = new ProdutoUseCase(produtoGateway);
        produtoUseCase.desativar(cdProduto);
    }

    public void ativarProduto(ProdutoRepositoryInterface produtoRepository, UUID cdProduto) {
        final ProdutoGateway produtoGateway = new ProdutoGateway(produtoRepository);
        ProdutoUseCase produtoUseCase = new ProdutoUseCase(produtoGateway);
        produtoUseCase.ativar(cdProduto);
    }

    public List<ProdutoWebHandlerResponse> listarProdutos(ProdutoRepositoryInterface produtoRepository) {
        final ProdutoGateway produtoGateway = new ProdutoGateway(produtoRepository);
        ProdutoUseCase produtoUseCase = new ProdutoUseCase(produtoGateway);
        var produtos = produtoUseCase.listar();
        final ProdutoWebHandlerAdapter produtoWebHandlerAdapter = new ProdutoWebHandlerAdapter();
        List<ProdutoWebHandlerResponse> responses = new ArrayList<>();
        for (var produto : produtos) {
            responses.add(produtoWebHandlerAdapter.toResponseDto(produto));
        }
        return responses;
    }
    public List<ProdutoWebHandlerResponse> listarProdutosPorCategoria(
        ProdutoRepositoryInterface produtoRepository,
        TipoCategoriaProdutoEnum tpCategoria
) {
    final ProdutoGateway produtoGateway = new ProdutoGateway(produtoRepository);
    ProdutoUseCase produtoUseCase = new ProdutoUseCase(produtoGateway);

    var produtos = produtoUseCase.listarPorCategoria(tpCategoria); 
    final ProdutoWebHandlerAdapter produtoWebHandlerAdapter = new ProdutoWebHandlerAdapter();
    List<ProdutoWebHandlerResponse> responses = new ArrayList<>();
    for (var produto : produtos) {
        responses.add(produtoWebHandlerAdapter.toResponseDto(produto));
    }
    return responses;
}

}
