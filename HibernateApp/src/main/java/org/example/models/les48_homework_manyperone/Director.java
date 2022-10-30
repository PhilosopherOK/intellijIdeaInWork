package org.example.models.les48_homework_manyperone;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Director")
public class Director {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "whoIsDirector")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Movie> movieList;

    public Director() {
    }

    public Director(String name, int age) {
        this.name = name;
        this.age = age;
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

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public void addMovie(Movie movie){
        if(this.movieList == null)
            this.movieList = new ArrayList<>();


        this.movieList.add(movie);
        movie.setWhoIsDirector(this);
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", movieList=" + movieList +
                '}';
    }
}
