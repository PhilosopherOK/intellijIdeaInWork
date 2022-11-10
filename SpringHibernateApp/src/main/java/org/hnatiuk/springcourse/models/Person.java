package org.hnatiuk.springcourse.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "name")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @NotEmpty(message = "Name should not be empty")
    @Size(min = 3,max = 15, message = "Name should be between 2 and 15 characters")
    @Column(name = "name")
    private String name;


    @Min(value = 0,message = "Age should be greater than 0")
    @Column(name = "name")
    private int age;

    @Column(name = "email")
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date_of_birth;

    @Column(name = "date_of_writen")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_of_writen;

    @Column(name = "Mood")
    @Enumerated(EnumType.ORDINAL)
    //@Enumerated(EnumType.STRING)
    private  Mood mood;

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Date getDate_of_writen() {
        return date_of_writen;
    }

    public void setDate_of_writen(Date date_of_writen) {
        this.date_of_writen = date_of_writen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
