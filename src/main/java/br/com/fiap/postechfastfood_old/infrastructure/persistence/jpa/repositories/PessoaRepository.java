package br.com.fiap.postechfastfood_old.infrastructure.persistence.jpa.repositories;

import br.com.fiap.postechfastfood_old.domain.models.PessoaModel;
import br.com.fiap.postechfastfood_old.domain.ports.out.PessoaRepositoryPort;
import br.com.fiap.postechfastfood_old.infrastructure.persistence.jpa.entities.PessoaEntity;
import br.com.fiap.postechfastfood_old.infrastructure.commons.mappers.PessoaMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PessoaRepository implements PessoaRepositoryPort {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public PessoaModel cadastrarPessoa(PessoaModel pessoaModel) {
        PessoaEntity pessoaEntity = PessoaMapper.toEntity(pessoaModel);
//        em.persist(pessoaEntity); // Deve ser utilizado quando a informação da chave primária não for enviada. Caso contrário, utilize o em.merge()
        em.merge(pessoaEntity);
        return PessoaMapper.toModel(pessoaEntity);
    }

    @Override
    public Optional<PessoaModel> buscarPorCdDocPessoa(String cdDocPessoa) {
        PessoaEntity pessoaEntity = em.find(PessoaEntity.class, cdDocPessoa);
        return Optional.ofNullable(pessoaEntity).map(PessoaMapper::toModel);
    }

    @Override
    public List<PessoaModel> listarTodasPessoas() {
        var jpql = "FROM PessoaEntity";
        List<PessoaEntity> pessoas = em.createQuery(jpql, PessoaEntity.class).getResultList();
        return pessoas.stream().map(PessoaMapper::toModel).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void removerPessoa(String cdDocPessoa) {
        em.remove(em.getReference(PessoaEntity.class, cdDocPessoa));
    }
}
