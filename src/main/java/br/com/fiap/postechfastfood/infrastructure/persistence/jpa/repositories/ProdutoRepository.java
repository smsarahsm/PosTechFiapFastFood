package br.com.fiap.postechfastfood.infrastructure.persistence.jpa.repositories;

import br.com.fiap.postechfastfood.domain.enums.TipoCategoriaProdutoEnum;
import br.com.fiap.postechfastfood.domain.models.ProdutoModel;
import br.com.fiap.postechfastfood.domain.ports.out.ProdutoRepositoryPort;
import br.com.fiap.postechfastfood.infrastructure.persistence.jpa.entities.ProdutoEntity;
import br.com.fiap.postechfastfood.infrastructure.commons.mappers.ProdutoMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ProdutoRepository implements ProdutoRepositoryPort {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public ProdutoModel cadastrar(ProdutoModel produto) {
        ProdutoEntity produtoEntity = ProdutoMapper.toEntity(produto);
        em.merge(produtoEntity);
        return ProdutoMapper.toModel(produtoEntity);
    }

    @Override
    @Transactional
    public ProdutoModel atualizar(UUID cdProduto, ProdutoModel produto) {
        ProdutoEntity produtoEntity = ProdutoMapper.toEntity(produto);
        em.merge(produtoEntity);
        return ProdutoMapper.toModel(produtoEntity);
    }

    @Override
    @Transactional
    public void deletar(UUID cdProduto) {
        em.remove(em.getReference(ProdutoEntity.class, cdProduto));
    }

    @Override
    public List<ProdutoModel> buscar() {
        var jpql = "FROM ProdutoEntity";
        List<ProdutoEntity> produtosEntity = em.createQuery(jpql, ProdutoEntity.class)
                .getResultList();

        return produtosEntity.stream().map(ProdutoMapper::toModel).toList();
    }

    @Override
    public List<ProdutoModel> buscar(TipoCategoriaProdutoEnum tpCategoria) {
        var jpql = "FROM ProdutoEntity WHERE tpCategoria = :tpCategoria";
        List<ProdutoEntity> produtosEntity = em.createQuery(jpql, ProdutoEntity.class)
                .setParameter("tpCategoria", tpCategoria)
                .getResultList();

        return produtosEntity.stream().map(ProdutoMapper::toModel).toList();
    }
}
