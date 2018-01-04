package db.dao;

import db.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class AuthorDao {

    public void save(Author author){
        EntityManager entityManager = GenericDao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(author);

        transaction.commit();
        entityManager.close();
    }

    public void remove(Author author){
        EntityManager entityManager = GenericDao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

//        entityManager.remove(author);
        entityManager.remove(entityManager.contains(author)? author : entityManager.merge(author));

        transaction.commit();
        entityManager.close();
    }

    public void update(Author author){
        EntityManager entityManager = GenericDao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();


        entityManager.merge(author);

        transaction.commit();
        entityManager.close();
    }

    public List<Author> getAll(){
        EntityManager entityManager = GenericDao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        List<Author> authors = entityManager.createQuery("from Author", Author.class).getResultList();

        transaction.commit();
        entityManager.close();

        return authors;
    }

}
