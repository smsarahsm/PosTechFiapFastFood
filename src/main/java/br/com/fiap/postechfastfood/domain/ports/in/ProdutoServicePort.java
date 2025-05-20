package br.com.fiap.postechfastfood.domain.ports.in;


import br.com.fiap.postechfastfood.domain.models.ProdutoModel;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.ProdutoRequestDto;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.ProdutoResponseDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProdutoServicePort {

    ProdutoResponseDto cadastrar(ProdutoRequestDto produto);
    ProdutoResponseDto atualizar(UUID cdProduto, ProdutoRequestDto produto);
    void deletar(UUID cdProduto);
    List<ProdutoModel> buscar();
    List<ProdutoModel> buscar(String tpCategoria);


    /*
    TODO:Será que não deveriamos utilizar dos models para expor as funções do nosso dominio?
         obrigando assim, os adaptadores a mapearem suas requests para nosso dominio? (eu acho que sim)
    ProdutoModel cadastrar(ProdutoModel produto);
    ProdutoModel atualizar(String cdProduto, ProdutoModel produto);
    ProdutoModel deletar(String cdProduto);
*/
}
