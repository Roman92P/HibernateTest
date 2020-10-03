//package pl.coderslab.model;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name="publishers")
//public class Publisher2 {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//    private String name;
//
////    public Publisher(long id, String name) {
////        this.id = id;
////        this.name = name;
////    }
//
//    @OneToMany(mappedBy = "publisher")
//
//    public Publisher2() {
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return "Publisher{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }
//}
