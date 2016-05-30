package org.javaee.sample.model.daos;

import org.javaee.sample.views.beans.support.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author mushira4
 */
public class AuthorDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Author> findAll(){
        return entityManager.createQuery("select a from Author a", Author.class).getResultList();
    }

}
