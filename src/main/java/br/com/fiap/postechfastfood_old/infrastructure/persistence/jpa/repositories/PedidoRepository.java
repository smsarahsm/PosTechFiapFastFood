package br.com.fiap.postechfastfood_old.infrastructure.persistence.jpa.repositories;

import br.com.fiap.postechfastfood_old.domain.enums.TipoStatusPedidoEnum;
import br.com.fiap.postechfastfood_old.domain.models.PedidoModel;
import br.com.fiap.postechfastfood_old.domain.models.ProdutosPedidoModel;
import br.com.fiap.postechfastfood_old.domain.ports.out.PedidoRepositoryPort;
import br.com.fiap.postechfastfood_old.infrastructure.commons.mappers.PedidoMapper;
import br.com.fiap.postechfastfood_old.infrastructure.commons.mappers.ProdutosPedidoMapper;
import br.com.fiap.postechfastfood_old.infrastructure.persistence.jpa.entities.PedidoEntity;
import br.com.fiap.postechfastfood_old.infrastructure.persistence.jpa.entities.ProdutosPedidoEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class PedidoRepository implements PedidoRepositoryPort {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public PedidoModel cadastrarPedido(PedidoModel pedidoModel) {
        PedidoEntity pedidoEntity = PedidoMapper.modelToEntity(pedidoModel);
        em.merge(pedidoEntity);
        return PedidoMapper.entityToModel(pedidoEntity);
    }

    @Override
    public List<PedidoModel> listarTodosPedidos() {
        var jpql = "FROM PedidoEntity";
        List<PedidoEntity> pedidos = em.createQuery(jpql, PedidoEntity.class).getResultList();
        return pedidos.stream().map(PedidoMapper::entityToModel).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void removerPedido(UUID cdPedido) {
        em.remove(em.getReference(PedidoEntity.class, cdPedido));
    }

    @Transactional
    public PedidoModel atualizarStatusPedido(UUID cdPedido, TipoStatusPedidoEnum status) {
        PedidoEntity pedidoEntity = em.find(PedidoEntity.class, cdPedido);
        if (pedidoEntity == null) {
            throw new IllegalArgumentException("Pedido não encontrado");
        }

        pedidoEntity.setTxStatus(status);
        pedidoEntity.setDhUltAtualizacao(LocalDateTime.now());
        em.merge(pedidoEntity);

        return PedidoMapper.entityToModel(pedidoEntity);
    }

    @Override
    public List<PedidoModel> buscarPedidosPorStatus(TipoStatusPedidoEnum status) {
        var jpql = "FROM PedidoEntity p WHERE p.txStatus = :status";
        List<PedidoEntity> pedidos = em.createQuery(jpql, PedidoEntity.class)
                .setParameter("status", status)
                .getResultList();
        return pedidos.stream().map(PedidoMapper::entityToModel).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ProdutosPedidoModel cadastrarProdutosPedido(ProdutosPedidoModel produtosPedidoModel) {
        ProdutosPedidoEntity entity = ProdutosPedidoMapper.modelToEntity(produtosPedidoModel);
        em.merge(entity);
        return ProdutosPedidoMapper.entityToModel(entity);
    }

    public int buscarUltimoNumeroPedido() {
        var jpql = "SELECT MAX(p.nrPedido) FROM PedidoEntity p";
        Integer max = em.createQuery(jpql, Integer.class).getSingleResult();
        return max == null ? 0 : max;
    }
}