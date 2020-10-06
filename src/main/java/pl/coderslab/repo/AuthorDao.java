package pl.coderslab.repo;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    EntityManager entityManager;

    public List<Author> getAllAuthors(){
        Query query = entityManager.createQuery("Select k From Author k");
        return query.getResultList();
    }

    public void addAuthor(Author author) {
        if(Long.valueOf(author.getId())==null){
            entityManager.persist(author);
        }else {
            entityManager.merge(author);
        }
    }

    public void updateAuthor (Author author){
        entityManager.merge(author);
    }

    public Author getAuthorById(long id){
        return entityManager.find(Author.class, id);
    }

    public void removeAuthor(Author author){
        entityManager.remove(entityManager.contains(author) ?
                author : entityManager.merge(author));
    }

}
