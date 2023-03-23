package ua.example.springcourse.SpringSecurity.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.example.springcourse.SpringSecurity.models.Person;
import ua.example.springcourse.SpringSecurity.service.PersonService;
import ua.example.springcourse.SpringSecurity.validations.PersonValidation;

import javax.validation.Valid;

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
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person") Person person){
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String singUp(@ModelAttribute("person") @Valid Person person,
                       BindingResult bindingResult){
        personValidation.validate(person, bindingResult);
        if(bindingResult.hasErrors()){
            return "/auth/registration";
        }
        personService.register(person);

        return "redirect:/auth/login";
    }
}
