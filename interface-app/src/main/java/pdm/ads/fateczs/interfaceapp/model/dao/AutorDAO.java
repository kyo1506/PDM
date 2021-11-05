package pdm.ads.fateczs.interfaceapp.model.dao;

import pdm.ads.fateczs.interfaceapp.connection.ConnectionFactory;
import pdm.ads.fateczs.interfaceapp.model.bean.Autor;
import pdm.ads.fateczs.interfaceapp.model.bean.Autor_;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AutorDAO {
    public List<Autor> listAll() {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            CriteriaQuery<Autor> criteriaQueryList = entityManager.getCriteriaBuilder().createQuery(Autor.class);
            Root<Autor> autorRootList = criteriaQueryList.from(Autor.class);
            return entityManager.createQuery(criteriaQueryList).getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }finally {
            entityManager.close();
        }
    }
    public Autor getById(Long id) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
        CriteriaQuery<Autor> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Autor.class);
        Root<Autor> autorRoot = criteriaQuery.from(Autor.class);
        CriteriaBuilder.In<Long> inClause = entityManager.getCriteriaBuilder().in(autorRoot.get(Autor_.id));
        inClause.value(id);
        criteriaQuery.select(autorRoot).where(inClause);
            return entityManager.createQuery(criteriaQuery).getSingleResult();
        }catch (NoResultException ex){
            ex.printStackTrace();
            return null;
        }finally {
            entityManager.close();
        }
    }
    public Autor getById(Long id, EntityManager entityManager) {
        try {
            CriteriaQuery<Autor> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Autor.class);
            Root<Autor> autorRoot = criteriaQuery.from(Autor.class);
            CriteriaBuilder.In<Long> inClause = entityManager.getCriteriaBuilder().in(autorRoot.get(Autor_.id));
            inClause.value(id);
            criteriaQuery.select(autorRoot).where(inClause);
            return entityManager.createQuery(criteriaQuery).getSingleResult();
        }catch (NoResultException ex){
            ex.printStackTrace();
            return null;
        }
    }
    public void insertAutor (Autor autor) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(autor);
            entityManager.getTransaction().commit();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }
    public void updateAutor (Autor autor) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(autor);
            entityManager.getTransaction().commit();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }
    public void deleteByID (Long id) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        Autor autor = getById(id, entityManager);
        if (autor != null){
            try{
                entityManager.getTransaction().begin();
                autor.getLivros().forEach(livro -> livro.getAutores().remove(autor));
                entityManager.remove(autor);
                entityManager.getTransaction().commit();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
                entityManager.getTransaction().rollback();
            }finally {
                entityManager.close();
            }
        }
    }
    public void removerLivro (Long autorId, Long livroId) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try{
            entityManager.getTransaction().begin();
            Query nativeQuery = entityManager.createNativeQuery("DELETE FROM livro_autores a WHERE a.autor_id = ? and a.livro_id = ?");
            nativeQuery.setParameter(1, autorId);
            nativeQuery.setParameter(2, livroId);
            nativeQuery.executeUpdate();
            entityManager.getTransaction().commit();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }
    public void adicionarLivro (Long autorId, Long livroId) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try{
            entityManager.getTransaction().begin();
            Query nativeQuery = entityManager.createNativeQuery("INSERT INTO livro_autores (autor_id, livro_id) VALUES (?, ?)");
            nativeQuery.setParameter(1, autorId);
            nativeQuery.setParameter(2, livroId);
            nativeQuery.executeUpdate();
            entityManager.getTransaction().commit();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }
}
