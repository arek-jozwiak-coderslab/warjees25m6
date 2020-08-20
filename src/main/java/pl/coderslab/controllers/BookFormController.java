package pl.coderslab.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;
import pl.coderslab.repository.AuthorRepository;
import pl.coderslab.repository.CategoryRepository;
import pl.coderslab.repository.IBookRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BookFormController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;
    private final IBookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;
    private static final Logger logger = LoggerFactory.getLogger(BookFormController.class);


    @GetMapping("/book/tests")
    @ResponseBody
    public String testRepos() {

        /**
        Category one = categoryRepository.getOne(1l);
        List<Book> allByCategory = bookRepository.findAllByCategory(one);
        allByCategory.forEach(b -> logger.info("b: {}", b.getId()));

        List<Book> allByCategoryId = bookRepository.findAllByCategoryId(one.getId());
        allByCategoryId.forEach(b -> logger.info("b: {}", b.getId()));
        */

        Book firstByCat = bookRepository.findFirstByCat(1);
        logger.info("b {}", firstByCat.getTitle());

        List<Author> ar = authorRepository.getByEmailStart("ar");
        ar.forEach(a->logger.info("a email {}", a.getEmail()));

        return "";
    }

    @GetMapping("/book/test")
    @ResponseBody
    public String testRepo(Model model) {

        Author byId = authorDao.findById(1);
        List<Book> allByAuthorsContains = bookRepository.findAllByAuthorsContains(byId);
        allByAuthorsContains.forEach(book -> logger.info("book {}", book.getId()));
        return "/book/form";
    }

    public BookFormController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao, IBookRepository bookRepository, CategoryRepository categoryRepository, AuthorRepository authorRepository) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.authorRepository = authorRepository;
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
    public String saveForm(@Valid Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("allAuthors", authorDao.findAll());
            return "/book/form";
        }
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
    public String remove(@PathVariable int id, RedirectAttributes redirectAttributes) {
        bookDao.delete(bookDao.findById(id));
        redirectAttributes.addFlashAttribute("message", "Ok usunięto");
        return "redirect:/book/list";
    }
}
