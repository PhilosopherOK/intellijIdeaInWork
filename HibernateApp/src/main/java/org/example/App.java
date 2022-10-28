package org.example;

import org.example.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

//            Person person = session.get(Person.class, 1);
//            System.out.println(person.getName());
//            System.out.println(person.getAge());


            Person person = new Person("Bobby", 23);
            Person person1 = new Person("Tommyy", 31);
            Person person2 = new Person("Katty", 24);
            session.save(person);
            session.save(person1);
            session.save(person2);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();

        }


    }
}
