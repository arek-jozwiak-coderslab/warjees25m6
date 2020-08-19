package pl.coderslab.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
public class ValidationController {
    private static final Logger logger = LoggerFactory.getLogger(ValidationController.class);
    private final Validator validator;

    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping("/validate")
    @ResponseBody
    public String check(Model model) {
        Book book = new Book();
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        if (violations.isEmpty()) {
            logger.info("jest ok");
        } else {
            for (ConstraintViolation<Book> bookConstraintViolation : violations) {
                logger.info(bookConstraintViolation.getPropertyPath() +
                        " : " + bookConstraintViolation.getMessage());
            }
        }
        model.addAttribute("violations", violations);
        return "validate";

    }

}
