package pl.coderslab.app;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.app.model.Book;
import pl.coderslab.app.model.Publisher;
import pl.coderslab.repo.BookDao;
import pl.coderslab.repo.PublisherDao;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@AllArgsConstructor
@Service

public class BookService {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;

    public Book addBook() {
        Book book = new Book();
        book.setTitle("Thinking in Java ");
        Publisher publisher = new Publisher();
        publisher.setName("publisher");
        publisherDao.save(publisher);
        book.setPublisher(publisher);
        Book persistedBook = bookDao.saveBook(book);
        return book;
    }
    public Book findById(long id) {
        return bookDao.findById(id);
    }

    public List<Book> findAllBooks() {
        return bookDao.findAll();
    }

    public List<Book> findAllByRating(int rat) {
        return bookDao.getRatingList(rat);
    }

    public List<Book> findBooksWithPublishers() {
        return bookDao.getAllWithPublisher();
    }

    public List<Book> getBooksCertainPublisher(String publisher) {
        return bookDao.getAllWithCertainPublisher(publisher);
    }
}
