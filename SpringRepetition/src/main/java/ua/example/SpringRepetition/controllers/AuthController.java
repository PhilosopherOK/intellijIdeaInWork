package ua.example.SpringRepetition.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.example.SpringRepetition.models.Person;
import ua.example.SpringRepetition.service.PersonService;
import ua.example.SpringRepetition.validations.PersonValidation;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final PersonService personService;
    private final PersonValidation personValidation;

    @Autowired
    public AuthController(PersonService personService, PersonValidation personValidation) {
        this.personService = personService;
        this.personValidation = personValidation;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person") Person person){
        return "/registration";
    }

    @PostMapping("/registration")
    public void singUp(@ModelAttribute("person") @Valid Person person,
                       BindingResult bindingResult){
        personValidation.validate(person, bindingResult);

        personService.save(person);
    }
}
