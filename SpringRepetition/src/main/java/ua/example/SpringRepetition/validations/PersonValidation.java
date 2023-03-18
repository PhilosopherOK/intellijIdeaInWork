package ua.example.SpringRepetition.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.example.SpringRepetition.models.Person;
import ua.example.SpringRepetition.service.PersonService;
@Component
public class PersonValidation implements Validator {

    private final PersonService personService;

    @Autowired
    public PersonValidation(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        if(personService.findByUserName(person.getUsername()).isPresent()){
            errors.rejectValue("username", "", "Person with this name been used, take any name");
        }
    }
}
