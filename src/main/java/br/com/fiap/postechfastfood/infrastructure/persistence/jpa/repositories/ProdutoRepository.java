package br.com.fiap.postechfastfood.infrastructure.persistence.jpa.repositories;

import br.com.fiap.postechfastfood.domain.enums.TipoCategoriaProdutoEnum;
import br.com.fiap.postechfastfood.domain.models.ProdutoModel;
import br.com.fiap.postechfastfood.domain.ports.out.ProdutoRepositoryPort;
import br.com.fiap.postechfastfood.infrastructure.persistence.jpa.entities.PessoaEntity;
import br.com.fiap.postechfastfood.infrastructure.persistence.jpa.entities.ProdutoEntity;
import br.com.fiap.postechfastfood.infrastructure.persistence.jpa.mappers.ProdutoMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProdutoRepository implements ProdutoRepositoryPort {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public ProdutoModel cadastrar(ProdutoModel produto) {
        ProdutoEntity produtoEntity = ProdutoMapper.toEntity(produto);
        em.merge(produtoEntity);
        return ProdutoMapper.toModel(produtoEntity); //TODO: não podemos só retornar o obejeto que recebemos no método?
    }

    @Override
    @Transactional
    public ProdutoModel atualizar(String cdProduto, ProdutoModel produto) {
        ProdutoEntity produtoEntity = ProdutoMapper.toEntity(produto);
        em.merge(produtoEntity);
//        em.createQuery("UPDATE ProdutoEntity SET nmProduto= :nome, dsDescricao= :descricao, vlPreco= :preco, tpCategoria= :categoria WHERE cdProduto= :codigo")
//                .setParameter("nome", produtoEntity.getNmProduto())
//                .setParameter("descricao", produtoEntity.getDsDescricao())
//                .setParameter("preco", produtoEntity.getVlPreco())
//                .setParameter("categoria", produtoEntity.getTpCategoria())
//                .setParameter("codigo", cdProduto);
        return ProdutoMapper.toModel(produtoEntity);
    }

    @Override
    @Transactional
    public void deletar(String cdProduto) {
        em.remove(em.getReference(ProdutoEntity.class, cdProduto));
    }

    @Override
    public Optional<List<ProdutoModel>> buscar() {
        var jpql = "FROM ProdutoEntity";
        List<ProdutoEntity> produtosEntity = em.createQuery(jpql, ProdutoEntity.class)
                .getResultList();

        return Optional.of(produtosEntity.stream().map(ProdutoMapper::toModel).toList());
    }

    @Override
    public Optional<List<ProdutoModel>> buscar(TipoCategoriaProdutoEnum tpCategoria) {
        var jpql = "FROM ProdutoEntity WHERE tpCategoria = :tpCategoria";
        List<ProdutoEntity> produtosEntity = em.createQuery(jpql, ProdutoEntity.class)
                .setParameter("tpCategoria", tpCategoria)
                .getResultList();

        return Optional.of(produtosEntity.stream().map(ProdutoMapper::toModel).toList());
    }
}
