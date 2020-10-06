package pl.coderslab.app;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.model.Author;
import pl.coderslab.app.model.Book;
import pl.coderslab.app.model.Publisher;
import pl.coderslab.repo.AuthorDao;
import pl.coderslab.repo.BookDao;
import pl.coderslab.repo.PublisherDao;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/book")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;
    private AuthorDao authorDao;
    private final BookDao bookDao;
    private final PublisherDao publisherDao;

    @RequestMapping("/publisher/{publisher}")
    @ResponseBody
    public String getBooksWithCertainPublisher(@PathVariable String publisher) {
        List<Book> booksCertainPublisher = bookService.getBooksCertainPublisher(publisher);
        booksCertainPublisher.stream()
                .forEach(b -> System.out.println(b.toString()));
        return "Liczba książek z takim wydawcą: " + booksCertainPublisher.size();
    }

    @RequestMapping("/withpublisher")
    @ResponseBody
    public String allBooksWithPublisher() {
        List<Book> booksWithPublishers = bookService.findBooksWithPublishers();
        booksWithPublishers.stream()
                .forEach(b -> System.out.println(b.toString()));
        return "Ilość książek z wydawcą: " + booksWithPublishers.size();
    }

    @RequestMapping("/rating/{rat}")
    @ResponseBody
    public String allBookRating(@PathVariable int rat) {
        List<Book> allByRating = bookService.findAllByRating(rat);
        allByRating.stream()
                .forEach(b -> System.out.println(b.toString()));
        return "Ilość książek" + allByRating.size();

    }

    @RequestMapping(value = "/all", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String allBooks() {
        List<Book> books = bookService.findAllBooks();
        books.stream()
                .forEach(b -> System.out.println(b.toString()));
        return "Ilość książek" + books.size();
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public String addBook() {
        authorDao.addAuthor(new Author("PierwszyAutor", "PierwszyAutor"));
        authorDao.addAuthor(new Author("DrugiAutor", "DrugiAutor"));
        Author authorById = authorDao.getAuthorById(1);
        Author authorById1 = authorDao.getAuthorById(2);

        Book book = new Book();
        book.setTitle("testKsiążka");
        book.setAuthorList(Arrays.asList(authorById, authorById1));
//        authorById.setBooks(Arrays.asList(book));
//        authorById1.setBooks(Arrays.asList(book));
        bookDao.saveBook(book);

//        authorById.setBooks(Arrays.asList(book));

        return "Id dodanej książki to:" + book.getId();
    }

    @RequestMapping(value = "/get")
    @ResponseBody
    public String getBook() {
        Book book = bookService.findById(1L);
        return "Id dodanej książki to:" + book.getId();
    }


    //    @RequestMapping(value = "/add", consumes = "application/sql;charset=UTF-8")
//    @RequestMapping(value = "/add", produces = "text/html;charset=UTF-8")
//    @ResponseBody
//    public String addBook() {
//        Book book = new Book();
//        book.setTitle("Thinking in Java");
//        book.setRating(5);
//        book.setDescription("Program bookś");
//        bookDao.saveBook(book);
//        return "Id dodanej książki to:"
//                + book.getId();
//    }
    @RequestMapping(value = "/{id}", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getBookById(@PathVariable long id) {
        Book bookById = bookDao.getBookById(id);
        return bookById.toString();
    }


    @RequestMapping("/update")
    @ResponseBody
    public void updateBook() {
        Book book = new Book();
        book.setId((long) 1);
        book.setTitle("Thinking in Java2");
        book.setRating(4);
//        book.setDescription("Advance program book");
        bookDao.updateBook(book);
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public void deleteBook(@PathVariable long id) {
        Book bookById = bookDao.getBookById(id);
        bookDao.removeBook(bookById);
    }

    @GetMapping("/addBook")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @PostMapping("/addBook")
    public String add(Book book) {
        bookDao.saveBook(book);
        return "redirect:/book";
    }

    @GetMapping("/deleteById/{id}")
    public String delete(@PathVariable Long id, Model model) {
//        Book bookById = bookDao.getBookById(id);
//        bookDao.removeBook(bookById);
        model.addAttribute("idForDelete", id);
        return "confirmRemoving";
    }

    @PostMapping("deleteById/confirmedRemoving")
    public  String confirmDeleteAction(@RequestParam String idForDelete, @RequestParam String delOrNot, HttpServletRequest request ){

         idForDelete = request.getParameter("idForDelete");
         delOrNot = request.getParameter("delOrNot");
        if(delOrNot.equals("1")){
            Book bookById = bookDao.getBookById(Long.parseLong(idForDelete));
            bookDao.removeBook(bookById);
        }
        return "redirect:/book";
    }

    @GetMapping("/editBook/{id}")
    public String editBookForm(@PathVariable Long id, Model model) {
        Book book = bookDao.findById(id);
        model.addAttribute("book", book);
        return "addBook";
    }

    @ModelAttribute("publishers")
    public List<Publisher> allPublishers() {
        return publisherDao.getAllPublishers();
    }

    @GetMapping
    public String allBooks(Model model) {
        List<Book> books = bookDao.findAll();
        model.addAttribute("books", books);
        return "books";
    }

    @ModelAttribute("authors")
    public List<Author>allauthors(){
        return this.authorDao.getAllAuthors();
    }
}

