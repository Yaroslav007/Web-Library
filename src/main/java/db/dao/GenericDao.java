package db.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDao {
    protected static EntityManagerFactory factory;

    public static void openFactory(){
       factory = Persistence.createEntityManagerFactory("x");

    }

    public static  void closeFactory(){
       factory.close();
    }
    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }

}
