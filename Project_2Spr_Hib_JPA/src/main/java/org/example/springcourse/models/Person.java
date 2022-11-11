package org.example.springcourse.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

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