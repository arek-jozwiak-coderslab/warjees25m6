package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.BookDao;
import pl.coderslab.model.Book;

@Controller
public class BookController {

    private final BookDao bookDao;

    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @GetMapping("/save-book")
    @ResponseBody
    public void saveBookAction() {
        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setAuthor("Brice Eckel");
        bookDao.saveBook(book);
        
    }
}
