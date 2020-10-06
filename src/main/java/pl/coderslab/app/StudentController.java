package pl.coderslab.app;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.app.model.Person;
import pl.coderslab.app.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/form")
    public String studentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "studentForm";
    }

    @ModelAttribute("programmingList")
    public List<String> programmingList() {
        List<String> programmingList = new ArrayList<String>();
        programmingList.add("java");
        programmingList.add("php");
        programmingList.add("python");
        programmingList.add("ruby");
        return programmingList;
    }
    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        List<String> hobbies = new ArrayList<String>();
        hobbies.add("java");
        hobbies.add("php");
        hobbies.add("python");
        hobbies.add("ruby");
        return hobbies;
    }
    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");

    }
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    @ResponseBody
    public String postStudent(@ModelAttribute Student student) {
        return student.toString();
    }
}

