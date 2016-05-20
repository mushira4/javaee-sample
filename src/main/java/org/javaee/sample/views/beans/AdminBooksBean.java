package org.javaee.sample.views.beans;

import org.javaee.sample.model.daos.BookDAO;
import org.javaee.sample.views.beans.support.Book;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * JSF bean to manage Administrator actions.
 *
 * @author mushira4
 */
@Model
public class AdminBooksBean {

    private Book product = new Book();

    @Inject
    private BookDAO bookDAO;

    public Book getProduct() {
        return product;
    }

    @Transactional
    public void save(){
        System.out.println("We need to save the book");
        System.out.println(product);
        bookDAO.save(product);
    }
}
