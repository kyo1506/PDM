package pdm.ads.fateczs.interfaceapp.model.dao;

import pdm.ads.fateczs.interfaceapp.connection.ConnectionFactory;
import pdm.ads.fateczs.interfaceapp.model.bean.Livro;
import pdm.ads.fateczs.interfaceapp.model.bean.Livro_;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class LivroDAO {

    private static EntityManager entityManager = ConnectionFactory.getEntityManager();

    public List<Livro> listAll() {
        CriteriaQuery<Livro> criteriaQueryList = entityManager.getCriteriaBuilder().createQuery(Livro.class);
        Root<Livro> livroRootList = criteriaQueryList.from(Livro.class);

        return entityManager.createQuery(criteriaQueryList).getResultList();
    }

    public Livro getById(Long id) {
        CriteriaQuery<Livro> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Livro.class);
        Root<Livro> livroRoot = criteriaQuery.from(Livro.class);
        CriteriaBuilder.In<Long> inClause = entityManager.getCriteriaBuilder().in(livroRoot.get(Livro_.id));
        inClause.value(id);
        criteriaQuery.select(livroRoot).where(inClause);

        try {
            return entityManager.createQuery(criteriaQuery).getSingleResult();
        }catch (NoResultException ex){
            return null;
        }
    }

    public void insertOrUpdate (Livro livro) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(livro);
            entityManager.getTransaction().commit();
        }
        catch(Exception ex)
        {
            entityManager.getTransaction().rollback();
        }
    }

    public void deleteById (Long id) {
        Livro livro = getById(id);
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(livro);
            entityManager.getTransaction().commit();
        }
        catch(Exception ex)
        {
            entityManager.getTransaction().rollback();
        }
    }
}
