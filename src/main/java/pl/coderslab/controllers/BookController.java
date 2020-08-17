package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Book;
import pl.coderslab.service.BookService;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/save-book")
    @ResponseBody
    public void saveBookAction() {
        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setAuthor("Brice Eckel");
        bookService.saveBook(book);

    }
}
