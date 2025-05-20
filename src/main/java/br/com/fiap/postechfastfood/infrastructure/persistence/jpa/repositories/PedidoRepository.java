package br.com.fiap.postechfastfood.infrastructure.persistence.jpa.repositories;

import br.com.fiap.postechfastfood.domain.enums.TipoStatusPedidoEnum;
import br.com.fiap.postechfastfood.domain.models.PedidoModel;
import br.com.fiap.postechfastfood.domain.ports.out.PedidoRepositoryPort;
import br.com.fiap.postechfastfood.infrastructure.persistence.jpa.entities.PedidosEntity;
import br.com.fiap.postechfastfood.infrastructure.persistence.jpa.mappers.PedidosMapper;
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
        PedidosEntity pedidosEntity = PedidosMapper.toEntity(pedidoModel);
        em.merge(pedidosEntity);
        return PedidosMapper.toModel(pedidosEntity);
    }

    // @Override
    @Transactional
    public Optional<PedidoModel> buscarPedidoPorId(UUID cdPedido) {
        PedidosEntity pedidosEntity = em.find(PedidosEntity.class, cdPedido);
        return Optional.ofNullable(pedidosEntity).map(PedidosMapper::toModel);
    }

    @Override
    public List<PedidoModel> listarTodosPedidos() {
        var jpql = "FROM PedidosEntity";
        List<PedidosEntity> pedidos = em.createQuery(jpql, PedidosEntity.class).getResultList();
        return pedidos.stream().map(PedidosMapper::toModel).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void removerPedido(UUID cdPedido) {
        em.remove(em.getReference(PedidosEntity.class, cdPedido));
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
    public PedidoModel atualizarStatusPedido(UUID cdPedido, TipoStatusPedidoEnum status) {
        PedidosEntity pedidosEntity = em.find(PedidosEntity.class, cdPedido);
        if (pedidosEntity == null) {
            throw new IllegalArgumentException("Pedido não encontrado");
        }

        pedidosEntity.setTxStatus(status);
        pedidosEntity.setDhUltAtualizacao(LocalDateTime.now());
        em.merge(pedidosEntity);

        return PedidosMapper.toModel(pedidosEntity);
    }

    @Override
    public List<PedidoModel> buscarPedidosPorStatus(TipoStatusPedidoEnum status) {
        var jpql = "FROM PedidosEntity p WHERE p.txStatus = :status";
        List<PedidosEntity> pedidos = em.createQuery(jpql, PedidosEntity.class)
                .setParameter("status", status)
                .getResultList();
        return pedidos.stream().map(PedidosMapper::toModel).collect(Collectors.toList());
    }
}