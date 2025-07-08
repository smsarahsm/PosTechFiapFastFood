package br.com.fiap.postechfasfood.externals;

import br.com.fiap.postechfasfood.gateways.entities.PessoaEntity;
import br.com.fiap.postechfasfood.interfaces.DbConnection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DbConnectionMariaDBImp implements DbConnection {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void CriarPessoa(PessoaEntity pessoaEntity) {
        em.merge(pessoaEntity);
    }

    @Override
    @Transactional
    public PessoaEntity BuscarPessoaPorCpf(String cdDocPessoa) {
    return em.createQuery(
            "SELECT p FROM PessoaEntity p WHERE p.cdDocPessoa = :cpf", PessoaEntity.class)
            .setParameter("cpf", cdDocPessoa)
            .getResultStream()
            .findFirst()
            .orElse(null);
}
}
