package br.com.benefrancis.service;

import br.com.benefrancis.model.entity.Categoria;
import br.com.benefrancis.repository.CategoriaRepository;
import br.com.benefrancis.repository.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaService {

    static EntityManager entityManager;
    static CategoriaRepository repo;

    static {
        entityManager = JPAUtil.getEntityManager();
        repo = new CategoriaRepository(entityManager);
    }

    public static Categoria save(Categoria categoria) {
        entityManager.getTransaction().begin();
        Categoria ret = repo.save(categoria);
        entityManager.getTransaction().commit();
        return ret;
    }

    public static List<Categoria> findAll() {
        String jpql = "SELECT p FROM Categoria p";
        return entityManager.createQuery(jpql).getResultList();
    }

    public static Categoria findById(Long id) {
        return entityManager.find(Categoria.class, id);
    }

    public static List<Categoria> findByName(String name) {
        String jpql = "SELECT p FROM Categoria p WHERE p.nome = :nome";
        return entityManager.createQuery(jpql, Categoria.class)
                .setParameter("nome", name)
                .getResultList();
    }

}
