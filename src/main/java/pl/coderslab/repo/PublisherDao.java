package pl.coderslab.repo;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PublisherDao {

    @PersistenceContext
    EntityManager entityManager;

    public List<Publisher> getAllPublishers(){
        Query query = entityManager.createQuery("Select b From Publisher b");
        return query.getResultList();
    }

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

    public void save(Publisher publisher) {
        if (publisher.getId() == null) {
            entityManager.persist(publisher);
        } else {
            entityManager.merge(publisher);
        }
    }
}
