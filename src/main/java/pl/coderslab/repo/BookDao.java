package pl.coderslab.repo;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    EntityManager entityManager;

    public List<Book> getAllWithCertainPublisher(String publisher){
        Query query = entityManager.createQuery
                ("SELECT b FROM Book b JOIN b.publisher where b.publisher.name = :name");
        query.setParameter("name", publisher);
         return query.getResultList();
    }

    public List<Book> getAllWithPublisher(){
        Query query = entityManager.createQuery("Select b From Book b Where b.publisher.id is not null ");
        return query.getResultList();
    }

    public List<Book> getRatingList(int rating){
        Query query = entityManager.createQuery("Select b From Book b Where b.rating >:rating");
        query.setParameter("rating", rating);
        return query.getResultList();

    }

    public List<Book> findAll(){
        Query query = entityManager.createQuery("Select t FROM  Book t");
        return query.getResultList();
    }

    public Book saveBook(Book book) {
        if (book.getId() == null) {
            entityManager.persist(book);
        } else {
            entityManager.merge(book);
        }
        return book;
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

    public Book findById(long id) {
        Book book = entityManager.find(Book.class, id);
        return book;
    }
}
