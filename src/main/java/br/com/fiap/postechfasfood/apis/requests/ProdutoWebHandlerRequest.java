package br.com.fiap.postechfasfood.apis.requests;



import java.util.UUID;

import br.com.fiap.postechfasfood.entities.ProdutoVO;
import br.com.fiap.postechfasfood.gateways.ProdutoGateway;
import br.com.fiap.postechfasfood.interfaces.ProdutoRepositoryInterface;
import br.com.fiap.postechfasfood.types.TipoCategoriaProdutoEnum;
import br.com.fiap.postechfasfood.usecases.ProdutoUseCase;

public record ProdutoWebHandlerRequest(
    UUID cdProduto,
    String nmProduto,
    String dsDescricao,
    double vlPreco,
    boolean snAtivo,
    TipoCategoriaProdutoEnum tpCategoria
    ) {

    public ProdutoWebHandlerRequest(ProdutoVO produto) {
        this(produto.getCdProduto(),
             produto.getNmProduto(),
             produto.getDsDescricao(),
             produto.getVlPreco(),
             produto.getSnAtivo(),
             produto.getTpCategoria());
    }

    public ProdutoVO toProdutoVO() {
        return new ProdutoVO(
            this.cdProduto,
            this.nmProduto,
            this.dsDescricao,
            this.vlPreco,
            this.snAtivo,
            this.tpCategoria
        );
    }

    public void atualizarProduto(ProdutoRepositoryInterface produtoRepository, UUID cdProduto, ProdutoWebHandlerRequest produtoWebHandlerRequest) {
    final ProdutoGateway produtoGateway = new ProdutoGateway(produtoRepository);
    ProdutoUseCase produtoUseCase = new ProdutoUseCase(produtoGateway);
    produtoUseCase.atualizar(cdProduto, produtoWebHandlerRequest);
    }
}
