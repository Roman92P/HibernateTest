package pl.coderslab.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.model.Author;
import pl.coderslab.repo.AuthorDao;

import java.util.List;

@Controller
@RequestMapping(path = "/author",produces = "text/html;charset=UTF-8")
public class AuthorController {

    private AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @RequestMapping("/all")
    @ResponseBody
    public String allAuthors(){
        List<Author> allAuthors = authorDao.getAllAuthors();
        allAuthors.stream()
                .forEach(b-> System.out.println(b.toString()));
        return "Ilość autorów "+ allAuthors.size();
    }

    @RequestMapping(path = "/add", produces ="text/html;charset=UTF-8" )
    @ResponseBody
    public void addAuthor() {
        Author author = new Author();
        author.setFirstName("Stefan");
        author.setLastName("Zeromski");
        authorDao.addAuthor(author);
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public String getAuthorByid(@PathVariable long id){
        Author authorById = authorDao.getAuthorById(id);
        return  authorById.toString();
    }
//    @RequestMapping("/update")
//    @ResponseBody
//    public void updateAuthor(){
//        Author author = new Author();
//        author.setId((long) 20);
//        author.setFirstName("Stefan");
//        author.setLastName("jakis");
//        authorDao.updateAuthor(author);
//    }
    @RequestMapping("/del/{id}")
    public String deleteAuthor(@PathVariable long id){
        Author authorById = authorDao.getAuthorById(id);
        authorDao.removeAuthor(authorById);
        return "redirect:/author";
    }

    @RequestMapping
    public String showAllBooks(){
        return"authors";
    }

    @ModelAttribute("authorsList")
    public List<Author> authorsList(){
        return authorDao.getAllAuthors();
    }

    @RequestMapping("/addNewAuthor")
    public String addNewAuthorForm(Model model){
        model.addAttribute("author", new Author());
        return "addAuthor";
    }

    @PostMapping("/addNewAuthorFromForm")
    public String addAuthorFromForm(Author author){
        authorDao.addAuthor(author);
        return "redirect:/author";
    }

    @RequestMapping("/update/{id}")
    public String updateAuthorFromForm(@PathVariable long id, Model model){
        Author authorById = authorDao.getAuthorById(id);
        model.addAttribute("author", authorById);
        return "addAuthor";
    }
}
