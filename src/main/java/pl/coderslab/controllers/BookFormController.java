package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import java.util.List;

@Controller
public class BookFormController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    public BookFormController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @ModelAttribute("publishers")
    public List<Publisher> getPublishers() {
        return publisherDao.findAll();
    }

    @GetMapping("/book/add")
    public String showForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("allAuthors", authorDao.findAll());
        return "/book/form";
    }

    @PostMapping("/book/add")
    public String saveForm(Book book) {
        bookDao.save(book);
        return "redirect:/book/list";
    }

    @GetMapping("/book/edit/{id}")
    public String showEditForm(Model model, @PathVariable int id) {
        model.addAttribute("allAuthors", authorDao.findAll());
        model.addAttribute("book", bookDao.findByIdWithAuthors(id));
        return "/book/form";
    }

    @RequestMapping(name = "/book/edit", method = RequestMethod.POST)
    public String saveEditForm(@ModelAttribute("book") Book book) {
        bookDao.update(book);
        return "redirect:/book/list";
    }

    @GetMapping("/book/list")
    public String showList(Model model) {
        model.addAttribute("books", bookDao.findAll());
        return "/book/list";
    }

    @GetMapping("/book/remove/confirm/{id}")
    public String confirmRemove(@PathVariable int id, Model model) {
        model.addAttribute("id", id);
        return "/book/confirm";
    }

    @GetMapping("/book/remove/{id}")
    public String remove(@PathVariable int id) {
        bookDao.delete(bookDao.findById(id));
        return "redirect:/book/list";
    }
}
