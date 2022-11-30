package br.com.benefrancis.service;

import br.com.benefrancis.model.entity.Categoria;
import br.com.benefrancis.model.entity.Produto;
import br.com.benefrancis.repository.JPAUtil;
import br.com.benefrancis.repository.ProdutoRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoService {

    static EntityManager entityManager;
    static ProdutoRepository repo;

    static {
        entityManager = JPAUtil.getEntityManager();
        repo = new ProdutoRepository(entityManager);
    }

    public static Produto findById(Long id) {
        return repo.findById(id);
    }

    public static List<Produto> findByCategoria(Categoria categoria) {
        return repo.findByCategoria(categoria);
    }

    public Produto save(Produto produto) {
        entityManager.getTransaction().begin();
        Produto ret = repo.save(produto);
        entityManager.getTransaction().commit();
        return ret;
    }

    public static List<Produto> findAll() {
        String jpql = "SELECT p FROM Produto p";
        return entityManager.createQuery(jpql).getResultList();
    }

}
