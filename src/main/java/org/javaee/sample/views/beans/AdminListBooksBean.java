package org.javaee.sample.views.beans;

import org.javaee.sample.model.daos.BookDAO;
import org.javaee.sample.views.beans.support.Book;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

/**
 * JSF bean to manage Administrator Books actions.
 *
 * @author mushira4
 */
@Model
public class AdminListBooksBean {

    @Inject
    private BookDAO bookDAO;

    private List<Book> books;

    @PostConstruct
    private void loadObjects(){
        this.books = bookDAO.list();
    }

    public List<Book> getBooks() {
        return books;
    }
}
