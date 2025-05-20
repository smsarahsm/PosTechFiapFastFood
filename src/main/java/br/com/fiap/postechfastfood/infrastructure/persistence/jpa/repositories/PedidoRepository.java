package br.com.fiap.postechfastfood.infrastructure.persistence.jpa.repositories;

import br.com.fiap.postechfastfood.domain.enums.TipoProdutoStatusEnum;
import br.com.fiap.postechfastfood.domain.models.PedidoModel;
import br.com.fiap.postechfastfood.domain.ports.PedidoRepositoryPort;
import br.com.fiap.postechfastfood.infrastructure.persistence.jpa.entities.PedidoEntity;
import br.com.fiap.postechfastfood.infrastructure.persistence.jpa.mappers.PedidoMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class PedidoRepository implements PedidoRepositoryPort {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public PedidoModel cadastrarPedido(PedidoModel pedidoModel) {
        PedidoEntity pedidoEntity = PedidoMapper.toEntity(pedidoModel);
        em.merge(pedidoEntity);
        return PedidoMapper.toModel(pedidoEntity);
    }

    // @Override
    @Transactional
    public Optional<PedidoModel> buscarPedidoPorId(UUID cdPedido) {
        PedidoEntity pedidoEntity = em.find(PedidoEntity.class, cdPedido);
        return Optional.ofNullable(pedidoEntity).map(PedidoMapper::toModel);
    }

    @Override
    public List<PedidoModel> listarTodosPedidos() {
        var jpql = "FROM PedidosEntity";
        List<PedidoEntity> pedidos = em.createQuery(jpql, PedidoEntity.class).getResultList();
        return pedidos.stream().map(PedidoMapper::toModel).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void removerPedido(UUID cdPedido) {
        em.remove(em.getReference(PedidoEntity.class, cdPedido));
    }

//    @Override
//    @Transactional
//    public PedidosModel atualizarStatusPedido(UUID cdPedido, TipoProdutoStatusEnum status) {
//        // Busca a entidade pelo ID
//        PedidosEntity pedidosEntity = em.find(PedidosEntity.class, cdPedido);
//        if (pedidosEntity == null) {
//            throw new IllegalArgumentException("Pedido não encontrado");
//        }
//
//        // Atualiza apenas o campo de status
//        pedidosEntity.setTxStatus(status);
//        pedidosEntity.setDhUltAtualizacao(LocalDateTime.now());
//
//        // Salva as alterações no banco de dados
//        em.merge(pedidosEntity);
//
//        // Retorna o modelo atualizado
//        return PedidosMapper.toModel(pedidosEntity);
//    }

    @jakarta.transaction.Transactional
    public PedidoModel atualizarStatusPedido(UUID cdPedido, TipoProdutoStatusEnum status) {
        PedidoEntity pedidoEntity = em.find(PedidoEntity.class, cdPedido);
        if (pedidoEntity == null) {
            throw new IllegalArgumentException("Pedido não encontrado");
        }

        pedidoEntity.setTxStatus(status);
        pedidoEntity.setDhUltAtualizacao(LocalDateTime.now());
        em.merge(pedidoEntity);

        return PedidoMapper.toModel(pedidoEntity);
    }

    @Override
    public List<PedidoModel> buscarPedidosPorStatus(TipoProdutoStatusEnum status) {
        var jpql = "FROM PedidosEntity p WHERE p.txStatus = :status";
        List<PedidoEntity> pedidos = em.createQuery(jpql, PedidoEntity.class)
                .setParameter("status", status)
                .getResultList();
        return pedidos.stream().map(PedidoMapper::toModel).collect(Collectors.toList());
    }
}