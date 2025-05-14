package br.com.fiap.postechfastfood.domain.services;

import br.com.fiap.postechfastfood.domain.enums.TipoCategoriaProdutoEnum;
import br.com.fiap.postechfastfood.domain.models.ProdutoModel;
import br.com.fiap.postechfastfood.domain.ports.in.ProdutoServicePort;
import br.com.fiap.postechfastfood.domain.ports.out.ProdutoRepositoryPort;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.ProdutoRequestDto;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.ProdutoResponseDto;

import java.util.List;
import java.util.UUID;

public class ProdutoService implements ProdutoServicePort {

    private final ProdutoRepositoryPort produtoRepository;
    public ProdutoService(ProdutoRepositoryPort produtoRepository){this.produtoRepository = produtoRepository;}

    @Override
    public ProdutoResponseDto cadastrar(ProdutoRequestDto produto) {
        ProdutoModel model = new ProdutoModel.Builder()
                .setCdProduto(UUID.randomUUID().toString())
                .setNmProduto(produto.nmProduto())
                .setDsDescricao(produto.dsDescricao())
                .setVlPreco(produto.vlPreco())
                .setTpCategoria(produto.tpCategoria()).build();
        ProdutoResponseDto response = toResponse(produtoRepository.cadastrar(model));
        return response;
    }

    @Override
    public ProdutoResponseDto atualizar(String cdProduto, ProdutoRequestDto produto) {
        ProdutoModel model = new ProdutoModel.Builder()
                .setCdProduto(cdProduto)
                .setNmProduto(produto.nmProduto())
                .setDsDescricao(produto.dsDescricao())
                .setVlPreco(produto.vlPreco())
                .setTpCategoria(produto.tpCategoria()).build();
        ProdutoResponseDto response = toResponse(produtoRepository.atualizar(cdProduto, model));
        return response;
    }

    @Override
    public void deletar(String cdProduto) {
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
        try{
            return TipoCategoriaProdutoEnum.valueOf(tpCategoria.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Categoria não existente");
        }
    }
}
