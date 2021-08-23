package model.dao;

import java.util.List;

import connection.ConnectionFactory;
import model.bean.Aluno;
import model.bean.Aluno_;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class AlunoDAO{

    private static EntityManager entityManager = ConnectionFactory.getEntityManager();

    public List<Aluno> list() {
        CriteriaQuery<Aluno> criteriaQueryList = entityManager.getCriteriaBuilder().createQuery(Aluno.class);
        Root<Aluno> alunoRootList = criteriaQueryList.from(Aluno.class);

        return entityManager.createQuery(criteriaQueryList).getResultList();
    }

    public Aluno getById(int id) {
        CriteriaQuery<Aluno> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Aluno.class);
        Root<Aluno> alunoRoot = criteriaQuery.from(Aluno.class);
        CriteriaBuilder.In<Integer> inClause = entityManager.getCriteriaBuilder().in(alunoRoot.get(Aluno_.id));
        inClause.value(id);
        criteriaQuery.select(alunoRoot).where(inClause);

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    public void insertOrUpdate (Aluno aluno) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(aluno);
            entityManager.getTransaction().commit();
        }
        catch(Exception ex)
        {
            entityManager.getTransaction().rollback();
        }
    }

    public void delete (int id) {
        Aluno aluno = getById(id);
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(aluno);
            entityManager.getTransaction().commit();
        }
        catch(Exception ex)
        {
            entityManager.getTransaction().rollback();
        }
    }
}
