package br.com.fiap.postechfastfood_old.infrastructure.persistence.jpa.repositories;

import br.com.fiap.postechfastfood_old.domain.enums.TipoCategoriaProdutoEnum;
import br.com.fiap.postechfastfood_old.domain.models.ProdutoModel;
import br.com.fiap.postechfastfood_old.domain.ports.out.ProdutoRepositoryPort;
import br.com.fiap.postechfastfood_old.infrastructure.persistence.jpa.entities.ProdutoEntity;
import br.com.fiap.postechfastfood_old.infrastructure.commons.mappers.ProdutoMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
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
    public void desativar(UUID cdProduto) {
        Optional<ProdutoEntity> produtoEntity = buscarPorCdProduto(cdProduto);
        if (produtoEntity.isPresent()) {
            ProdutoEntity entity = produtoEntity.get();
            entity.setSnAtivo(false);
            em.merge(entity);
        }
    }

    @Override
    @Transactional
    public void ativar(UUID cdProduto) {
        Optional<ProdutoEntity> produtoEntity = buscarPorCdProduto(cdProduto);
        if (produtoEntity.isPresent()) {
            ProdutoEntity entity = produtoEntity.get();
            entity.setSnAtivo(true);
            em.merge(entity);
        }
    }

    @Override
    public List<ProdutoModel> buscar() {
        var jpql = "FROM ProdutoEntity WHERE snAtivo = true";
        List<ProdutoEntity> produtosEntity = em.createQuery(jpql, ProdutoEntity.class)
                .getResultList();

        return produtosEntity.stream().map(ProdutoMapper::toModel).toList();
    }

    @Override
    public List<ProdutoModel> buscar(TipoCategoriaProdutoEnum tpCategoria) {
        var jpql = "FROM ProdutoEntity WHERE tpCategoria = :tpCategoria AND snAtivo = true";
        List<ProdutoEntity> produtosEntity = em.createQuery(jpql, ProdutoEntity.class)
                .setParameter("tpCategoria", tpCategoria)
                .getResultList();

        return produtosEntity.stream().map(ProdutoMapper::toModel).toList();
    }

    private Optional<ProdutoEntity> buscarPorCdProduto(UUID cdProduto) {
        return Optional.ofNullable(em.find(ProdutoEntity.class, cdProduto));
    }
}
