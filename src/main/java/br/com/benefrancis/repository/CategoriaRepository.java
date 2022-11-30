package br.com.benefrancis.repository;

import br.com.benefrancis.model.entity.Categoria;

import javax.persistence.EntityManager;

public class CategoriaRepository {

    EntityManager entityManager;

    public CategoriaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Categoria save(Categoria categoria) {
        this.entityManager.persist(categoria);
        return categoria;
    }

    public void update(Categoria categoria) {
        this.entityManager.merge(categoria);
    }

    public void delete(Categoria categoria) {
        categoria = entityManager.merge(categoria);
        this.entityManager.remove(categoria);
    }

}
