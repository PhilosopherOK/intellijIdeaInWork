package org.hnatiuk.springcourse.models;

import jakarta.persistence.*;

import javax.validation.constraints.*;
@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "name")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 3,max = 15, message = "Name should be between 2 and 15 characters")
    private String name;

    @Column(name = "name")
    @Min(value = 0,message = "Age should be greater than 0")
    private int age;
//    @NotEmpty(message = "Email should not be empty")
//    @Email(message = "Email should be valid")
//    private String email;

//    @Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+, \\d{6}", message = "Your address should be in this format: Country, City, Postal Code(6 digits)")
//    private String address;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public int getId() {
        return id;
    }

    public Person() {
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


    public Person( String name, int age) {

        this.name = name;
        this.age = age;

    }
}
