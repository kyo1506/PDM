package model.dao;

import connection.ConnectionFactory;
import model.bean.UserAuth;
import model.bean.UserAuth_;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserAuthDAO {

    private static EntityManager entityManager = ConnectionFactory.getEntityManager();

    public List<UserAuth> listAll() {
        CriteriaQuery<UserAuth> criteriaQueryList = entityManager.getCriteriaBuilder().createQuery(UserAuth.class);
        Root<UserAuth> userAuthRootList = criteriaQueryList.from(UserAuth.class);

        return entityManager.createQuery(criteriaQueryList).getResultList();
    }

    public UserAuth getByName(String name){
        CriteriaQuery<UserAuth> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(UserAuth.class);
        Root<UserAuth> userAuthRoot = criteriaQuery.from(UserAuth.class);
        CriteriaBuilder.In<String> inClause = entityManager.getCriteriaBuilder().in(userAuthRoot.get(UserAuth_.username));
        inClause.value(name);
        criteriaQuery.select(userAuthRoot).where(inClause);

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    public UserAuth getById(Long id) {
        CriteriaQuery<UserAuth> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(UserAuth.class);
        Root<UserAuth> userAuthRoot = criteriaQuery.from(UserAuth.class);
        CriteriaBuilder.In<Long> inClause = entityManager.getCriteriaBuilder().in(userAuthRoot.get(UserAuth_.id));
        inClause.value(id);
        criteriaQuery.select(userAuthRoot).where(inClause);

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    public void insertOrUpdate (UserAuth userAuth) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(userAuth);
            entityManager.getTransaction().commit();
        }
        catch(Exception ex)
        {
            entityManager.getTransaction().rollback();
        }
    }

    public void deleteById (Long id) {
        UserAuth userAuth = getById(id);

        try{
            entityManager.getTransaction().begin();
            entityManager.remove(userAuth);
            entityManager.getTransaction().commit();
        }
        catch(Exception ex)
        {
            entityManager.getTransaction().rollback();
        }
    }
}
