package model.dao;

import java.util.List;

import connection.ConnectionFactory;
import model.bean.Pessoa;
import model.bean.Pessoa_;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class PessoaDAO {

    private static EntityManager entityManager = ConnectionFactory.getEntityManager();

    public List<Pessoa> list() {
        CriteriaQuery<Pessoa> criteriaQueryList = entityManager.getCriteriaBuilder().createQuery(Pessoa.class);
        Root<Pessoa> pessoaRootList = criteriaQueryList.from(Pessoa.class);

        return entityManager.createQuery(criteriaQueryList).getResultList();
    }

    public Pessoa getById(Long id) {
        CriteriaQuery<Pessoa> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Pessoa.class);
        Root<Pessoa> pessoaRoot = criteriaQuery.from(Pessoa.class);
        CriteriaBuilder.In<Long> inClause = entityManager.getCriteriaBuilder().in(pessoaRoot.get(Pessoa_.id));
        inClause.value(id);
        criteriaQuery.select(pessoaRoot).where(inClause);

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    public void insertOrUpdate (Pessoa pessoa) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(pessoa);
            entityManager.getTransaction().commit();
        }
        catch(Exception ex)
        {
            entityManager.getTransaction().rollback();
        }
    }

    public void delete (Long id) {
        Pessoa pessoa = getById(id);
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(pessoa);
            entityManager.getTransaction().commit();
        }
        catch(Exception ex)
        {
            entityManager.getTransaction().rollback();
        }
    }
}
