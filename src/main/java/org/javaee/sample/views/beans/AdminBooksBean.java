package org.javaee.sample.views.beans;

import org.javaee.sample.model.daos.AuthorDAO;
import org.javaee.sample.model.daos.BookDAO;
import org.javaee.sample.views.FacesMessageHelper;
import org.javaee.sample.views.beans.support.Author;
import org.javaee.sample.views.beans.support.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * JSF bean to manage Administrator actions.
 *
 * @author mushira4
 */
@Model
public class AdminBooksBean {

    private Logger logger = LoggerFactory.getLogger(AdminBooksBean.class);

    @Inject
    private FacesMessageHelper messageHelper;

    @Inject
    private BookDAO bookDAO;

    @Inject
    private AuthorDAO authorDAO;

    private Book product = new Book();

    private List<Integer> selectedAuthorsIds = new ArrayList<>();

    private List<Author> authors;

    @PostConstruct
    private void postConstruct(){
        this.authors = authorDAO.findAll();
    }

    public Book getProduct() {
        return product;
    }

    public void setSelectedAuthorsIds(List<Integer> selectedAuthorsIds) {
        this.selectedAuthorsIds = selectedAuthorsIds;
    }

    public List<Integer> getSelectedAuthorsIds() {
        return selectedAuthorsIds;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    @Transactional
    public String save(){
        logger.info("[BOOK] M=save, msg='Saving book.'");

        populateBookAuthor();
        bookDAO.save(product);

        logger.info("[BOOK] M=save, msg='Book saved.'");

        messageHelper.addMesage("Book Saved.");
        cleanObjects();
        return "/books/list?faces-redirect=true";
    }

    private void cleanObjects() {
        product = new Book();
        this.selectedAuthorsIds.clear();
    }

    private	void populateBookAuthor()	{
        selectedAuthorsIds.stream() // Begin stream
                .map((id)-> new Author(id)) // Map values from the list to a new object
                .forEach(product::add); // Executes the value mapped as parameter on add method
    }
}
