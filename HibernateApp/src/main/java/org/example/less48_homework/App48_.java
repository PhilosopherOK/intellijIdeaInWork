package org.example.less48_homework;

import org.example.models.les48_homework.Item;
import org.example.models.les48_homework.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App48_ {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            // take a value person and items of person
//            Person person = session.get(Person.class, 1);
//            System.out.println(person.getListOfItems());
//            System.out.println(person.getName());

//            Item item = session.get(Item.class,3);
//            System.out.println(item);
//            Person person = item.getWhoseItem();
//            System.out.println(person);

            // add new person + item from him
//            Person person = session.get(Person.class, 8);
//            Item item2 = session.get(Item.class, 12);
//            item2.setWhoseItem(person);
//            person.getListOfItems().add(item2);

            // delete person
//            Person person1 = session.get(Person.class, 8);
//            session.remove(person1);
            //del items
//            Person person1 = session.get(Person.class, 8);
//            List<Item> listRemov = person1.getListOfItems();
//            for(Item item: listRemov)
//                session.remove(item);
//
//            person1.getListOfItems().clear();
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }

    }
}
