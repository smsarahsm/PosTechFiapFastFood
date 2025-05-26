package br.com.fiap.postechfastfood.domain.services;

import br.com.fiap.postechfastfood.domain.enums.TipoCategoriaProdutoEnum;
import br.com.fiap.postechfastfood.domain.models.ProdutoModel;
import br.com.fiap.postechfastfood.domain.ports.in.ProdutoServicePort;
import br.com.fiap.postechfastfood.domain.ports.out.ProdutoRepositoryPort;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.ProdutoResponseDto;

import java.util.List;
import java.util.UUID;

public class ProdutoService implements ProdutoServicePort {

    private final ProdutoRepositoryPort produtoRepository;

    public ProdutoService(ProdutoRepositoryPort produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoModel cadastrar(ProdutoModel produto) {
        produto.setCdProduto(UUID.randomUUID());
        return produtoRepository.cadastrar(produto);
    }

    @Override
    public ProdutoModel atualizar(UUID cdProduto, ProdutoModel produto) {
        produto.setCdProduto(cdProduto);
        return produtoRepository.atualizar(cdProduto, produto);
    }

    @Override
    public void deletar(UUID cdProduto) {
        produtoRepository.deletar(cdProduto);
    }

    @Override
    public List<ProdutoModel> buscar() {
        return produtoRepository.buscar();
    }

    @Override
    public List<ProdutoModel> buscar(String tpCategoria) {
        var enumTpCategoria = converteTipoProdutoCategortiaEnum(tpCategoria);

        return produtoRepository.buscar(enumTpCategoria);
    }

    private ProdutoResponseDto toResponse(ProdutoModel produtoModel) {
        return new ProdutoResponseDto(produtoModel);
    }

    private TipoCategoriaProdutoEnum converteTipoProdutoCategortiaEnum(String tpCategoria) {
        try {
            return TipoCategoriaProdutoEnum.valueOf(tpCategoria.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Categoria não existente");
        }
    }
}
