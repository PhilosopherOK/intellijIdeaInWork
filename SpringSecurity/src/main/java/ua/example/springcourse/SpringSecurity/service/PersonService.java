package ua.example.springcourse.SpringSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.example.springcourse.SpringSecurity.models.Person;
import ua.example.springcourse.SpringSecurity.repositories.PeopleRepository;

import java.util.Optional;

@Service
public class PersonService {
    private final PeopleRepository peopleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PersonService(PeopleRepository peopleRepository, PasswordEncoder passwordEncoder) {
        this.peopleRepository = peopleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(Person person){
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setRole("ROLE_USER");
        peopleRepository.save(person);
    }

    public Optional<Person> findByUserName(String userName){
        Optional<Person> person = peopleRepository.findByUsername(userName);
        return person;
    }
}
