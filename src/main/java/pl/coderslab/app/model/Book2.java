//package pl.coderslab.app.model;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "books2")
//public class Book2 {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String description;
//    private int rating;
//    private String title;
//
//    public Book2(Long id, String description, int rating, String title) {
//        this.id = id;
//        this.description = description;
//        this.rating = rating;
//        this.title = title;
//    }
//
//    public Book2() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public int getRating() {
//        return rating;
//    }
//
//    public void setRating(int rating) {
//        this.rating = rating;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    @Override
//    public String toString() {
//        return "Book{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", rating=" + rating +
//                ", description='" + description + '\'' +
//                '}';
//    }
//}
