package pl.coderslab.repo;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    EntityManager entityManager;

    public void addAuthor(Author author) {
        entityManager.persist(author);
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
