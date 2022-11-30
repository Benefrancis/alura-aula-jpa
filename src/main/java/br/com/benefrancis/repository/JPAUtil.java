package br.com.benefrancis.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("alura_aula_loja");
    public static EntityManager getEntityManager(){
        return FACTORY.createEntityManager();
    }
}
