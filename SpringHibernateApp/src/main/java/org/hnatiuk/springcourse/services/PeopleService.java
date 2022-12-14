package org.hnatiuk.springcourse.services;


import org.hnatiuk.springcourse.models.Mood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.hnatiuk.springcourse.models.Person;
import org.hnatiuk.springcourse.repositories.PeopleRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll(){
        return peopleRepository.findAll();
    }

    public Person findOne(int id){
        Optional<Person> foundPerson = peopleRepository.findById(id);
        return foundPerson.orElse(null);
    }

    public void save(Person person){
        person.setDate_of_writen(new Date());
        person.setMood(Mood.HAPPY);
        //person.setMood(Mood.HAPPY);
        peopleRepository.save(person);
    }

    public void update(int id,Person updatePerson){
        updatePerson.setId(id);
        peopleRepository.save(updatePerson);
    }

    public void delete(int id){
        peopleRepository.deleteById(id);
    }
}
