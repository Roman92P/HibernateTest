package pl.coderslab.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.model.Publisher;
import pl.coderslab.repo.PublisherDao;

import java.util.List;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

    private PublisherDao publisherDao;

    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @RequestMapping(path = "/add", produces ="text/html;charset=UTF-8" )
    @ResponseBody
    public void addAuthor() {
        Publisher publisher = new Publisher();
        publisher.setName("Helion");
        publisherDao.addPublisher(publisher);
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public String getAuthorByid(@PathVariable long id){
        Publisher publisherById = publisherDao.getPublisherById(id);
        return  publisherById.toString();
    }
    @RequestMapping("/update")
    @ResponseBody
    public void updateAuthor(){
        Publisher publisher = new Publisher();
        publisher.setName("Helion2");
        publisher.setId((long) 1);
        publisherDao.updatePublisher(publisher);
    }
    @RequestMapping("/del/{id}")
    @ResponseBody
    public void deleteAuthor(@PathVariable long id){
        Publisher publisherById = publisherDao.getPublisherById(id);
        publisherDao.deletePublisher(publisherById);
    }

    public String getAllPublishers(){
        List<Publisher> allPublishers = publisherDao.getAllPublishers();
        allPublishers.stream()
                .forEach(p-> System.out.println(p.toString()));
        return "Ilość wydawców " +allPublishers.size();
    }

//    Utwórz kontroler PublisherController, utwórz w nim akcje, które pozwolą:
//
//    wyświetlić listę wszystkich wydawców
//    dodać wydawcę
//    usunąć wydawcę
//    edytować wydawcę
//
//    Dla akcji dodawania oraz edycji utwórz formularz.
//    Utwórz linki nawigacyjne umożliwiające przechodzenie
//    między akcjami - bez konieczności znania adresów URL.

    @RequestMapping
    public String showAllPublishers(){
        return "publishers";
    }
    @ModelAttribute("publishers")
    public List<Publisher> publishersList(){
       return publisherDao.getAllPublishers();
    }

    @RequestMapping("/addPublisherForm")
    public String addPublisherForm(Model model){
        model.addAttribute("publisher", new Publisher());
        return "addPublisher";
    }

    @PostMapping("/addPublisherFromForm")
    public String addNewPublisher(Publisher publisher){
        publisherDao.save(publisher);
        return "redirect:/publisher";
    }

    @RequestMapping("/deletePublisherFromForm/{id}")
    public String deletePublisherFormForm(@PathVariable long id){
        Publisher publisherById = publisherDao.getPublisherById(id);
        publisherDao.deletePublisher(publisherById);
        return "redirect:/publisher";
    }
    @RequestMapping("/editPublisherFromForm/{id}")
    public String editPublisher(@PathVariable long id, Model model){
        Publisher publisherById = publisherDao.getPublisherById(id);
        model.addAttribute("publisher", publisherById);
        return "addPublisher";
    }


}
