package org.javaee.sample.model.daos;

import org.javaee.sample.views.beans.support.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

/**
 * DAO for books.
 *
 * @author mushira4
 */
public class BookDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Book product) {
        entityManager.persist(product);
    }

    public List<Book> list(){
        return entityManager.createQuery("select distinct(b) from Book b join fetch b.authors", Book.class).getResultList();
    }
}
