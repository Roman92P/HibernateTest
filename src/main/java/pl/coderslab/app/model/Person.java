package pl.coderslab.app.model;

import javax.persistence.*;

//    Utwórz klasę Person zawierającą pola:
//
//    id
//    login
//    password
//    email
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String email;

    public Person(String login, String password, String email, PersonDetails personDetails) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.personDetails = personDetails;
    }

    public Person() {
    }

    @OneToOne
    @JoinColumn(name = "details_id",
            unique=true)
    private PersonDetails personDetails;

    public PersonDetails getPersonDetails() {
        return personDetails;
    }

    public void setPersonDetails(PersonDetails personDetails) {
        this.personDetails = personDetails;
    }

    public Long getId() {
        return this.id;
    }

    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
