package pl.coderslab.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Author;
import pl.coderslab.repo.AuthorDao;

@Controller
@RequestMapping(path = "/author",produces = "text/html;charset=UTF-8")
public class AuthorController {

    private AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
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
    @RequestMapping("/update")
    @ResponseBody
    public void updateAuthor(){
        Author author = new Author();
        author.setId((long) 20);
        author.setFirstName("Stefan");
        author.setLastName("jakis");
        authorDao.updateAuthor(author);
    }
    @RequestMapping("/del/{id}")
    @ResponseBody
    public void deleteAuthor(@PathVariable long id){
        Author authorById = authorDao.getAuthorById(id);
        authorDao.removeAuthor(authorById);
    }

}
