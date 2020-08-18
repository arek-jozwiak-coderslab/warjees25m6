package pl.coderslab.person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonController {

    private final PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping("/person/add")
    public String showForm(Model model) {
        model.addAttribute("person", new Person());
        return "/person/form";
    }

    @PostMapping("/person/add")
    public String saveForm(Person person) {
        personDao.savePerson(person);
        return "/person/form";
    }
}
