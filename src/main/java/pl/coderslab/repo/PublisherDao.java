package pl.coderslab.repo;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PublisherDao {

    @PersistenceContext
    EntityManager entityManager;

    public void addPublisher(Publisher publisher){
        entityManager.persist(publisher);
    }
    public Publisher getPublisherById(long id){
        return entityManager.find(Publisher.class, id);
    }
    public void updatePublisher (Publisher publisher){
        entityManager.merge(publisher);
    }
    public void deletePublisher(Publisher publisher){
        entityManager.remove(entityManager.contains(publisher) ?
         publisher : entityManager.merge(publisher));
    }



}
