package org.example.springcourse.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "title will not be not empty")
    @Size(min = 2, max = 15, message = "please take a title before 2 and 15 letter")
    @Column(name = "title")
    private String title;

    @NotEmpty(message = "author will not be not empty")
    @Size(min = 2, max = 15, message = "please take a author before 2 and 15 letter")
    @Column(name = "author")
    private String author;

    @Min(value = 1900, message = "year mush be after 1900")
    @Column(name = "year")
    private int year;

    @ManyToOne()
    @JoinColumn(name = "owner", referencedColumnName = "id")
    private Person owner;


    //    @Column(name = "date_of_writen")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date date_of_writen;
    @Column(name = "taken_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date takeAt;


    @Transient
    private boolean expired;


    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public Date getTakeAt() {
        return takeAt;
    }

    public void setTakeAt(Date takeAt) {
        this.takeAt = takeAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }



    public boolean getExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }
}
