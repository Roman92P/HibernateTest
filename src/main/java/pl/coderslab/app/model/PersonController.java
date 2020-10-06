package pl.coderslab.app.model;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.repo.PersonDao;
import pl.coderslab.repo.PersonDetailsDao;

import javax.persistence.PersistenceContext;

@Controller
@AllArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonDetailsDao personDetailsDao;
    private final PersonDao personDao;

    @RequestMapping("/add")
    @ResponseBody
    public void addPerson(){
        PersonDetails personDetails = new PersonDetails("Imię", "Nazwisko", 2,"Ulica", "Wrocław");
        personDetailsDao.savePersonDetails(personDetails);
        Person person = new Person("loginUsera", "1234", "a@a.com.pl", personDetails);
        personDao.savePerson(person);
    }

    @RequestMapping(value = "/form")
    public  String personForm(Model model){
        Person person = new Person();
        model.addAttribute("person", person);
        return "personForm";
    }
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    @ResponseBody
    public String postPerson(@ModelAttribute Person person) {
        personDao.save(person);
        return person.toString();
    }


}
