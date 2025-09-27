package br.com.fiap.postechfasfood.apis.responses;

import br.com.fiap.postechfasfood.entities.ProdutoVO;
import java.util.UUID;

public record ProdutoWebHandlerResponse(
    String cdProduto,
    String nmProduto,
    String dsDescricao,
    double vlPreco,
    boolean snAtivo,
    String tpCategoria
) {
    public ProdutoWebHandlerResponse(ProdutoVO produto) {
        this(produto.getCdProduto(),
             produto.getNmProduto(),
             produto.getDsDescricao(),
             produto.getVlPreco(),
             produto.getSnAtivo(),
             produto.getTpCategoria().name());
    }
}
