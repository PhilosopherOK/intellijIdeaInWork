package org.example.springcourse.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 3,max = 15, message = "Name should be between 2 and 15 characters")
    @Column(name = "fullName")
    private String fullName;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date_of_birth;

    @OneToMany(mappedBy = "owner")
    private List<Book> books;

    public Person(String fullName, Date date_of_birth) {
        this.fullName = fullName;
        this.date_of_birth = date_of_birth;
    };

    public Person() {
    }


//    @Column(name = "date_of_writen")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date date_of_writen;

