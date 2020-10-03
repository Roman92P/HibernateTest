package pl.coderslab.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Book;
import pl.coderslab.repo.BookDao;

@Controller
@RequestMapping("/book")
public class BookController {
    private final BookDao bookDao;
    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }
    @RequestMapping(value = "/add", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String addBook() {
        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setRating(5);
        book.setDescription("Program book");
        bookDao.saveBook(book);
        return "Id dodanej książki to:"
                + book.getId();
    }
    @RequestMapping(value = "/{id}", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getBookById(@PathVariable long id){
        Book bookById = bookDao.getBookById(id);
        return bookById.toString();
    }
    @RequestMapping("/update")
    @ResponseBody
    public void updateBook (){
        Book book = new Book();
        book.setId((long)1);
        book.setTitle("Thinking in Java2");
        book.setRating(4);
        book.setDescription("Advance program book");
        bookDao.updateBook(book);
    }
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public void deleteBook(@PathVariable long id){
        Book bookById = bookDao.getBookById(id);
        bookDao.removeBook(bookById);
    }

}

