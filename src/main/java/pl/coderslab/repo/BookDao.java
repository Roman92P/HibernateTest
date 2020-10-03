package pl.coderslab.repo;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    EntityManager entityManager;

    public void saveBook(Book book) {
        entityManager.persist(book);
    }

    public void updateBook (Book book){
        entityManager.merge(book);
    }

    public Book getBookById(long id){
        return entityManager.find(Book.class, id);
    }

    public void removeBook(Book book){
        entityManager.remove(entityManager.contains(book) ?
                book : entityManager.merge(book));
    }

}
