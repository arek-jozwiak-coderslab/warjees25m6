package pl.coderslab.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StrudentController {

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        Student student = new Student();
        student.setFirstName("arek");
        model.addAttribute("student", student);
        return "form/registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processForm(Student student) {
        System.out.println(student.getFirstName());
        return "form/success";
    }
}
