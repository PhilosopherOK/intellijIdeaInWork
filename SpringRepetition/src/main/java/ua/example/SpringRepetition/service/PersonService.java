package ua.example.SpringRepetition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.example.SpringRepetition.models.Person;
import ua.example.SpringRepetition.repositories.PeopleRepository;

import java.util.Optional;

@Service
public class PersonService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public void save(Person person){
        peopleRepository.save(person);
    }

    public Optional<Person> findByUserName(String userName){
        Optional<Person> person = peopleRepository.findByUsername(userName);
        return person;
    }
}
