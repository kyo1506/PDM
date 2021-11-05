package pdm.ads.fateczs.interfaceapp.model.dao;

import pdm.ads.fateczs.interfaceapp.connection.ConnectionFactory;
import pdm.ads.fateczs.interfaceapp.model.bean.UserAuth;
import pdm.ads.fateczs.interfaceapp.model.bean.UserAuth_;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserAuthDAO {
    public List<UserAuth> listAll()  {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            CriteriaQuery<UserAuth> criteriaQueryList = entityManager.getCriteriaBuilder().createQuery(UserAuth.class);
            Root<UserAuth> userAuthRootList = criteriaQueryList.from(UserAuth.class);
            return entityManager.createQuery(criteriaQueryList).getResultList();
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }finally {
            entityManager.close();
        }
    }
    public UserAuth getByName(String name){
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            CriteriaQuery<UserAuth> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(UserAuth.class);
            Root<UserAuth> userAuthRoot = criteriaQuery.from(UserAuth.class);
            CriteriaBuilder.In<String> inClause = entityManager.getCriteriaBuilder().in(userAuthRoot.get(UserAuth_.username));
            inClause.value(name);
            criteriaQuery.select(userAuthRoot).where(inClause);
            return entityManager.createQuery(criteriaQuery).getSingleResult();
        }catch (NoResultException ex){
            return null;
        }finally {
            entityManager.close();
        }
    }
    public UserAuth getById(Long id) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            CriteriaQuery<UserAuth> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(UserAuth.class);
            Root<UserAuth> userAuthRoot = criteriaQuery.from(UserAuth.class);
            CriteriaBuilder.In<Long> inClause = entityManager.getCriteriaBuilder().in(userAuthRoot.get(UserAuth_.id));
            inClause.value(id);
            criteriaQuery.select(userAuthRoot).where(inClause);
            return entityManager.createQuery(criteriaQuery).getSingleResult();
        }catch (NoResultException ex){
            return null;
        }finally {
            entityManager.close();
        }
    }
    public UserAuth getById(Long id, EntityManager entityManager) {
        try {
            CriteriaQuery<UserAuth> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(UserAuth.class);
            Root<UserAuth> userAuthRoot = criteriaQuery.from(UserAuth.class);
            CriteriaBuilder.In<Long> inClause = entityManager.getCriteriaBuilder().in(userAuthRoot.get(UserAuth_.id));
            inClause.value(id);
            criteriaQuery.select(userAuthRoot).where(inClause);
            return entityManager.createQuery(criteriaQuery).getSingleResult();
        }catch (NoResultException ex){
            return null;
        }
    }
    public void insertUser (UserAuth userAuth) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(userAuth);
            entityManager.getTransaction().commit();
        }
        catch(Exception ex)
        {
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }
    public void updateUser (UserAuth userAuth) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(userAuth);
            entityManager.getTransaction().commit();
        }
        catch(Exception ex)
        {
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }
    public void deleteById (Long id) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        UserAuth userAuth = getById(id, entityManager);
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(userAuth);
            entityManager.getTransaction().commit();
        }
        catch(Exception ex)
        {
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }
}
