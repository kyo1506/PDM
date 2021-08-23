package model.dao;

import connection.ConnectionFactory;
import model.bean.Estado;
import model.bean.Estado_;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EstadoDAO {

    private static EntityManager entityManager = ConnectionFactory.getEntityManager();

    public List<Estado> list() {
        CriteriaQuery<Estado> criteriaQueryList = entityManager.getCriteriaBuilder().createQuery(Estado.class);
        Root<Estado> estadoRootList = criteriaQueryList.from(Estado.class);

        return entityManager.createQuery(criteriaQueryList).getResultList();
    }

    public Estado getById(int id) {
        CriteriaQuery<Estado> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Estado.class);
        Root<Estado> estadoRoot = criteriaQuery.from(Estado.class);
        CriteriaBuilder.In<Integer> inClause = entityManager.getCriteriaBuilder().in(estadoRoot.get(Estado_.id));
        inClause.value(id);
        criteriaQuery.select(estadoRoot).where(inClause);

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    public void insertOrUpdate (Estado estado) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(estado);
            entityManager.getTransaction().commit();
        }
        catch(Exception ex)
        {
            entityManager.getTransaction().rollback();
        }
    }

    public void delete (int id) {
        Estado estado = getById(id);
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(estado);
            entityManager.getTransaction().commit();
        }
        catch(Exception ex)
        {
            entityManager.getTransaction().rollback();
        }
    }
}
