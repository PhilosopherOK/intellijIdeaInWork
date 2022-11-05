package org.hnatiuk.springcourse.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hnatiuk.springcourse.models.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {

    private final SessionFactory sessionFactory;

    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

@Transactional
    public List<Person> index() {
    Session session = sessionFactory.getCurrentSession();
        List<Person> personList = session.createQuery("SELECT p FROM Person p", Person.class).getResultList();
        return personList;
    }

    public Optional <Person> show(String email){
        return null;
    }

    public Person show(int id) {
        return null;
    }

    public void save(Person person) {

    }

    public void updating(int id, Person updatePerson) {
       }


    public void delete(int id) {

    }
}
