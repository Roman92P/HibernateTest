package pl.coderslab.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Publisher;
import pl.coderslab.repo.PublisherDao;

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

}
