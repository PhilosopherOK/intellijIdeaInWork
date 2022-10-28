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

            //Check object in BD
//            Person person = session.get(Person.class, 1);
//            System.out.println(person.getName());
//            System.out.println(person.getAge());

            // Add object in BD
//            Person person = new Person("Bobby", 23);
//            Person person1 = new Person("Tommyy", 31);
//            Person person2 = new Person("Katty", 24);
//            session.save(person);
//            session.save(person1);
//            session.save(person2);


            //update object in BD
//            Person person = session.get(Person.class, 2);
//            person.setName("new name");


            // Delete object in BD
//            Person person = session.get(Person.class, 3);
//            session.delete(person);




            session.getTransaction().commit();

            // if we need to ckeck what id take a new person, we needed to check it after commit->
//            System.out.println(person.getId());

        } finally {
            sessionFactory.close();

        }


    }
}
