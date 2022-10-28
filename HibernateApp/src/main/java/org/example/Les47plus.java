package org.example;

import org.example.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Les47plus {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();

            //create HQL query
//            List<Person> listOfPer = session.createQuery("FROM Person where age > 30").getResultList();
//            for(Person person:listOfPer)
//                System.out.println(person);

            //create HQL hard query
//            List<Person> listOfPer = session.createQuery("FROM Person where name LIKE 'T%', age < 35 ").getResultList();
//            for(Person person:listOfPer)
//                System.out.println(person);

            // HQL updating
//            session.createQuery("update Person set name = 'Tommy' where age > 30 ").executeUpdate();

            // HQL delete
//            session.createQuery("delete FROM Person WHERE age < 30");

        }finally {
            sessionFactory.close();
        }
    }
}
