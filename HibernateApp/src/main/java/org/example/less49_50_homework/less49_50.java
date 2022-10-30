package org.example.less49_50_homework;


import org.example.models.les48_homework_manyperone.Director;
import org.example.models.les48_homework_manyperone.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class less49_50 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class).addAnnotatedClass(Movie.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            //less 49
//            Director director = new Director("Steev5", 98);
//            Movie movie = new Movie("Captain of america 3", 2016);
//            director.addMovie(movie);
//            session.save(director);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }

    }
}
