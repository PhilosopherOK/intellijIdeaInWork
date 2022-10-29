package org.example.less48_homework;


import org.example.models.les48_homework.Director;
import org.example.models.les48_homework.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Homework_48less {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class).addAnnotatedClass(Movie.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            //1 take a director and his films
//            Director director = session.get(Director.class,1);
//            System.out.println(director.getName());
//            List<Movie>List1 = director.getMovieList();
//            for(Movie movie : List1)
//                System.out.println(movie.getName());


            //2 take a movie and his director
//            Movie movie = session.get(Movie.class,1);
//            System.out.println(movie.getName());
//            System.out.println(movie.getWhoIsDirector().getName());

            //3 add any movie for any director
//            Director director = session.get(Director.class, 1);
//            Movie movie = new Movie("New elephant", 2021, director);
//            director.getMovieList().add(movie);
//            session.save(director);
//            session.save(movie);

            //4 create new director and new movie and add one per one
//            Director director = new Director("Azerian Illin", 38);
//            Movie movie = new Movie("zakon i poriadok", 1998, director);
//            director.setMovieList(new ArrayList<>(Collections.singletonList(movie)));
//            session.save(director);
//            session.save(movie);

            //5 chenge director in any movie
            Director director = session.get(Director.class, 5);
            Movie movie = session.get(Movie.class,1);
            movie.getWhoIsDirector().getMovieList().remove(movie);

            movie.setWhoIsDirector(director);
            director.getMovieList().add(movie);



            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}

