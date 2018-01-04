package db.dao;

import db.entity.Book;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class BookDao {

    public void save(Book book){
        EntityManager entityManager = GenericDao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(book);

        transaction.commit();
        entityManager.close();
    }

    public void remove(Book book){
        EntityManager entityManager = GenericDao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.remove(entityManager.contains(book)? book : entityManager.merge(book));

        transaction.commit();
        entityManager.close();
    }

    public void update(Book book){
        EntityManager entityManager = GenericDao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.merge(book);

        transaction.commit();
        entityManager.close();
    }

    public List<Book> getAll(){
        EntityManager entityManager = GenericDao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        List<Book> books = entityManager.createQuery("from Book", Book.class).getResultList();

        transaction.commit();
        entityManager.close();

        return books;
    }

    public List<Book> getByName(String name){
        EntityManager entityManager = GenericDao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        List<Book> books = findWithName(name);
        System.out.println(books);

        transaction.commit();
        entityManager.close();

        return books;
    }

    public List findWithName(String name) {
        EntityManager entityManager = GenericDao.getEntityManager();
        List <Book> books =entityManager.createQuery(
                "SELECT b FROM Book b WHERE b.bookName LIKE :custName")
                .setParameter("custName", "%"+name+"%")
                .getResultList();
        return books;
    }

}
