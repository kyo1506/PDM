package pdm.ads.fateczs.interfaceapp.model.dao;

import pdm.ads.fateczs.interfaceapp.connection.ConnectionFactory;
import pdm.ads.fateczs.interfaceapp.model.bean.Livro;
import pdm.ads.fateczs.interfaceapp.model.bean.Livro_;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class LivroDAO {
    public List<Livro> listAll() {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            CriteriaQuery<Livro> criteriaQueryList = entityManager.getCriteriaBuilder().createQuery(Livro.class);
            Root<Livro> livroRootList = criteriaQueryList.from(Livro.class);
            return entityManager.createQuery(criteriaQueryList).getResultList();
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }finally {
            entityManager.close();
        }
    }

    public Livro getById(Long id) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            CriteriaQuery<Livro> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Livro.class);
            Root<Livro> livroRoot = criteriaQuery.from(Livro.class);
            CriteriaBuilder.In<Long> inClause = entityManager.getCriteriaBuilder().in(livroRoot.get(Livro_.id));
            inClause.value(id);
            criteriaQuery.select(livroRoot).where(inClause);
            return entityManager.createQuery(criteriaQuery).getSingleResult();
        } catch (NoResultException ex){
            return null;
        }finally {
            entityManager.close();
        }
    }

    public Livro getById(Long id, EntityManager entityManager) {
        try {
            CriteriaQuery<Livro> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Livro.class);
            Root<Livro> livroRoot = criteriaQuery.from(Livro.class);
            CriteriaBuilder.In<Long> inClause = entityManager.getCriteriaBuilder().in(livroRoot.get(Livro_.id));
            inClause.value(id);
            criteriaQuery.select(livroRoot).where(inClause);
            return entityManager.createQuery(criteriaQuery).getSingleResult();
        } catch (NoResultException ex){
            return null;
        }
    }

    public void insertLivro (Livro livro) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(livro);
            entityManager.getTransaction().commit();
        }
        catch(Exception ex)
        {
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }

    public void updateLivro (Livro livro) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(livro);
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
        Livro livro = getById(id, entityManager);
        try{
            entityManager.getTransaction().begin();
            livro.getAutores().forEach(autor -> autor.getLivros().remove(livro));
            entityManager.remove(livro);
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

    public void removeAutor (Long livroId, Long autorId) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try{
            entityManager.getTransaction().begin();
            Query nativeQuery = entityManager.createNativeQuery("DELETE FROM livro_autores a WHERE a.livro_id = ? and a.autor_id = ?");
            nativeQuery.setParameter(1, livroId);
            nativeQuery.setParameter(2, autorId);
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

    public void adicionarAutor (Long livroId, Long autorId) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try{
            entityManager.getTransaction().begin();
            Query nativeQuery = entityManager.createNativeQuery("INSERT INTO livro_autores (livro_id, autor_id) VALUES (?, ?)");
            nativeQuery.setParameter(1, livroId);
            nativeQuery.setParameter(2, autorId);
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
