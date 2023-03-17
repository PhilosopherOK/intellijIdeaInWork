package ua.example.SpringRepetition.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Controller;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    @NotNull(message = "mush be not empty")
    @Size(min = 3, max = 100, message = "must be not more than 100 letter")
    private String username;

    @Column(name = "year_of_birthday" )
    @NotNull(message = "mush be not empty")
    private int year_of_birthday;

    @Column (name = "password")
    @NotNull(message = "mush be not empty")
    private String password;

    public Person(){
    }

    public Person(String username, int year_of_birthday, String password) {
        this.username = username;
        this.year_of_birthday = year_of_birthday;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getYear_of_birthday() {
        return year_of_birthday;
    }

    public void setYear_of_birthday(int year_of_birthday) {
        this.year_of_birthday = year_of_birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", year_of_birthday=" + year_of_birthday +
                ", password=" + password +
                '}';
    }
}
