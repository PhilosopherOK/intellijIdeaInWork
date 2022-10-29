package org.example.models.les48_homework;

import jakarta.persistence.*;

@Entity
@Table(name = "Movie")
public class Movie {

    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movie_id;

    @Column(name = "name")
    private String name;

    @Column(name = "year_of_production")
    private int year_of_production;

    @ManyToOne
    @JoinColumn(name = "director_id", referencedColumnName = "id")
    private Director whoIsDirector;

    public Movie() {
    }

    public Movie(String name, int year_of_production, Director whoIsDirector) {
        this.name = name;
        this.year_of_production = year_of_production;
        this.whoIsDirector = whoIsDirector;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int id) {
        this.movie_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear_of_production() {
        return year_of_production;
    }

    public void setYear_of_production(int year_of_production) {
        this.year_of_production = year_of_production;
    }

    public Director getWhoIsDirector() {
        return whoIsDirector;
    }

    public void setWhoIsDirector(Director WhoIsDirector) {
        this.whoIsDirector = whoIsDirector;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + movie_id +
                ", name='" + name + '\'' +
                ", year_of_production=" + year_of_production +
                ", whoIsDirector=" + whoIsDirector +
                '}';
    }
}
