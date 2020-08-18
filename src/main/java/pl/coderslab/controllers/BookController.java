package pl.coderslab.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private static final Logger log = LoggerFactory.getLogger(BookController.class);

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
    public void saveBookWithAAction(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        book.setTitle("Thinking in Java");
        book.setAuthors(Arrays.asList(authorDao.findById(1), authorDao.findById(2)));

        bookDao.save(book);
    }

    @GetMapping("/test-publisher")
    @ResponseBody
    public void testPublisher() {
        Publisher byId = publisherDao.findById(1);
        List<Book> booksForPublisher = bookDao.getBooksForPublisher(byId);

        log.info("some info");

        booksForPublisher.forEach(b -> log.debug("book title: {}, rating {}", b.getTitle(), b.getRating()));

        List<Book> booksForPublisherId = bookDao.getBooksForPublisherId(1);
        booksForPublisherId.forEach(b -> System.out.println(b));
    }

    @GetMapping("/test-author")
    @ResponseBody
    public void testAuthor() {
        Author byId = authorDao.findById(1);
        List<Book> booksForAuthor = bookDao.getBooksForAuthor(byId);
        booksForAuthor.forEach(b -> log.debug("book id {} ", b.getId()));
    }
}
