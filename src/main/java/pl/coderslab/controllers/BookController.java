package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;

import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import java.util.Arrays;
import java.util.List;

@Controller
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @GetMapping("/save-book")
    @ResponseBody
    public void saveBookAction() {
        Book book = new Book();
        book.setTitle("Thinking in Java");

        Publisher publisher = new Publisher();
        publisher.setFirstName("arek");
        publisher.setLastName("jozwiak");
        publisherDao.save(publisher);
        book.setPublisher(publisher);

        bookDao.save(book);
    }
    @GetMapping("/save-authors")
    @ResponseBody
    public void saveBookWithAAction() {
        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setAuthors(Arrays.asList(authorDao.findById(1), authorDao.findById(2)));

        bookDao.save(book);
    }
}
