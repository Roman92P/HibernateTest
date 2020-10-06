package pl.coderslab.app.model;

import java.util.List;

//    String firstName;
//    String lastName;
//    String gender;
//    String country;
//    String notes;
//    boolean mailingList;
//    List programmingSkills;
//    List hobbies;
public class Student {
    private String firstName;
    private String lastName;
    private String gender;
    private String country;
    private String note;
    private boolean mailingList;
    private List<String> programmingList;
    private List<String> hobbies;


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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isMailingList() {
        return mailingList;
    }

    public void setMailingList(boolean mailingList) {
        this.mailingList = mailingList;
    }

    public List<String> getProgrammingList() {
        return programmingList;
    }

    public void setProgrammingList(List<String> programmingList) {
        this.programmingList = programmingList;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", country='" + country + '\'' +
                ", note='" + note + '\'' +
                ", mailingList=" + mailingList +
                ", programmingList=" + programmingList +
                ", hobbies=" + hobbies +
                '}';
    }
}
