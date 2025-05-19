package br.com.fiap.postechfastfood.infrastructure.persistence.jpa.repositories;



import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import br.com.fiap.postechfastfood.infrastructure.persistence.jpa.mappers.ComandaMapper;
import br.com.fiap.postechfastfood.infrastructure.persistence.jpa.entities.ComandaEntity;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;

import br.com.fiap.postechfastfood.domain.models.ComandaModel;
import br.com.fiap.postechfastfood.domain.ports.out.ComandaRepositoryPort;
import jakarta.persistence.PersistenceContext;

@Repository
public class ComandaRepository implements ComandaRepositoryPort {



    @PersistenceContext
    private EntityManager em;

    

    public Optional<ComandaModel> buscarPorNrPedido(int nrPedido) {
        ComandaEntity comandaEntity = em.find(ComandaEntity.class, nrPedido);
        return Optional.ofNullable(comandaEntity).map(ComandaMapper::toModel);
    }
    
        @Override
        public Optional<ComandaModel> buscarPedido(ComandaModel comandaModel) {
            ComandaEntity comandaEntity = em.find(ComandaEntity.class, comandaModel.getNrPedido());
            return Optional.ofNullable(comandaEntity).map(ComandaMapper::toModel);
        }
    
    

    @Override
    public List<ComandaModel> listarTodosPedidos() {
        var jpql = "FROM ComandaEntity";
        List<ComandaEntity> comanda = em.createQuery(jpql, ComandaEntity.class).getResultList();
        return comanda.stream().map(ComandaMapper::toModel).collect(Collectors.toList());
    }

    @Override
    public Optional<ComandaModel> buscarPorCdPedido(String cdPedido) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorCdPedido'");
    }

    

   






}
