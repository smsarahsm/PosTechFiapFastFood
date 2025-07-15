package br.com.fiap.postechfasfood.apis.requests;



import java.util.UUID;

import br.com.fiap.postechfasfood.entities.ProdutoVO;
import br.com.fiap.postechfasfood.gateways.ProdutoGateway;
import br.com.fiap.postechfasfood.interfaces.ProdutoRepositoryInterface;
import br.com.fiap.postechfasfood.types.TipoCategoriaProdutoEnum;
import br.com.fiap.postechfasfood.usecases.ProdutoUseCase;

public record ProdutoWebHandlerRequest(
    String nmProduto,
    String dsDescricao,
    double vlPreco,
    TipoCategoriaProdutoEnum tpCategoria
    ) {

    public ProdutoWebHandlerRequest(ProdutoVO produto) {
        this(produto.getNmProduto(),
             produto.getDsDescricao(),
             produto.getVlPreco(),
             produto.getTpCategoria());
    }

    public ProdutoVO toProdutoVO() {
        return new ProdutoVO.Builder()
                .setNmProduto(nmProduto)
                .setDsDescricao(dsDescricao)
                .setVlPreco(vlPreco)
                .setTpCategoria(tpCategoria)
                .build();
    }

    public void atualizarProduto(ProdutoRepositoryInterface produtoRepository, UUID cdProduto, ProdutoWebHandlerRequest produtoWebHandlerRequest) {
    final ProdutoGateway produtoGateway = new ProdutoGateway(produtoRepository);
    ProdutoUseCase produtoUseCase = new ProdutoUseCase(produtoGateway);
    produtoUseCase.atualizar(cdProduto, produtoWebHandlerRequest);
    }
}
