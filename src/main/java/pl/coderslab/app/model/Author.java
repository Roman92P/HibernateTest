package pl.coderslab.app.model;

import lombok.AllArgsConstructor;
import pl.coderslab.converters.AuthorConverter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//    Ustal nazwę tabeli bazy danych dla tej encji na authors.
//    Encja ma zawierać następujące pola:
//
//    id
//    firstName
//    lastName
@AllArgsConstructor
@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String firstName;
    private String lastName;

    public Author(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author() {
    }

    @ManyToMany
            (mappedBy = "authorList")
    List<Book>books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
