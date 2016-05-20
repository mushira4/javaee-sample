package org.javaee.sample.model.daos;

import org.javaee.sample.views.beans.support.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author mushira4
 */
public class BookDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Book product) {
        entityManager.persist(product);
    }
}
