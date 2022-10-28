package org.hnatiuk.springcourse.models;

import javax.validation.constraints.*;

public class Book {
    private int bookId;
    @NotEmpty(message = "title should not be empty")
    @Size(min = 3,max = 15, message = "Name should be between 2 and 15 characters")
    private String title;

    @NotEmpty(message = "autor should not be empty")
    @Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+", message = "Name, Surname")
    private String autor;

    @Min(value = 1600,message = "year should be greater than 1600")
    private int year;


    public Book(String title, String autor, int year) {
        this.title = title;
        this.autor = autor;
        this.year = year;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }



}
