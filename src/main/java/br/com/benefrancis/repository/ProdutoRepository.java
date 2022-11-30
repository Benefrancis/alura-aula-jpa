package br.com.benefrancis.repository;

import br.com.benefrancis.model.entity.Categoria;
import br.com.benefrancis.model.entity.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoRepository {

    EntityManager entityManager;

    public ProdutoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Produto save(Produto produto) {
        this.entityManager.persist(produto);
        return produto;
    }

    public List<Produto> findAll() {
        String jpql = "SELECT p FROM Produto p";
        return entityManager.createQuery(jpql).getResultList();
    }

    public Produto findById(Long id) {
        return entityManager.find(Produto.class, id);
    }

    public List<Produto> findByName(String name) {
        String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
        return entityManager.createQuery(jpql, Produto.class)
                .setParameter("nome", name)
                .getResultList();
    }

    public List<Produto> findByNameOfCategoria(String name) {
        String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome";
        return entityManager.createQuery(jpql, Produto.class)
                .setParameter("nome", name)
                .getResultList();
    }


    public BigDecimal findPriceOfProductByProductId(Long id) {
        String jpql = "SELECT p.preco FROM Produto p WHERE p.id = :id";
        return entityManager.createQuery(jpql, BigDecimal.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public void update(Produto produto) {
        this.entityManager.merge(produto);
    }

    public void delete(Produto produto) {
        produto = entityManager.merge(produto);
        this.entityManager.remove(produto);
    }

    public List<Produto> findByCategoria(Categoria categoria) {
        String jpql = "SELECT p FROM Produto p WHERE p.categoria = :categoria";
        return entityManager.createQuery(jpql, Produto.class)
                .setParameter("categoria", categoria)
                .getResultList();
    }
}
