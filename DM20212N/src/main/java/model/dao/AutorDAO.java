package model.dao;

import connection.ConnectionFactory;
import model.bean.Autor;
import model.bean.Autor_;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AutorDAO {

    private static EntityManager entityManager = ConnectionFactory.getEntityManager();

    public List<Autor> listAll() {
        CriteriaQuery<Autor> criteriaQueryList = entityManager.getCriteriaBuilder().createQuery(Autor.class);
        Root<Autor> autorRootList = criteriaQueryList.from(Autor.class);

        return entityManager.createQuery(criteriaQueryList).getResultList();
    }

    public Autor getById(Long id) {
        CriteriaQuery<Autor> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Autor.class);
        Root<Autor> autorRoot = criteriaQuery.from(Autor.class);
        CriteriaBuilder.In<Long> inClause = entityManager.getCriteriaBuilder().in(autorRoot.get(Autor_.id));
        inClause.value(id);
        criteriaQuery.select(autorRoot).where(inClause);

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    public void insertOrUpdate (Autor autor) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(autor);
            entityManager.getTransaction().commit();
        }
        catch(Exception ex)
        {
            entityManager.getTransaction().rollback();
        }
    }

    public void deleteByID (Long id) {
        Autor autor = getById(id);
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(autor);
            entityManager.getTransaction().commit();
        }
        catch(Exception ex)
        {
            entityManager.getTransaction().rollback();
        }
    }
}
