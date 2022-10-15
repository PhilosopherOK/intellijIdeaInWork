package org.hnatiuk.springcourse.DAO;

import org.hnatiuk.springcourse.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Tom", 24, "Tommy@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Bob", 21, "Bobby@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Mike", 28, "Mike@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Katy", 17, "Katy@gmail.com"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person ->
                person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void updating(int id, Person updatePerson) {
        Person personToBeUpdating = show(id);
        personToBeUpdating.setName(updatePerson.getName());
        personToBeUpdating.setAge(updatePerson.getAge());
        personToBeUpdating.setEmail(updatePerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
