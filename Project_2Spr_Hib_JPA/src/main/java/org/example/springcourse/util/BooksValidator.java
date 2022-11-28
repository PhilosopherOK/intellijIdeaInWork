package org.example.springcourse.util;

import org.example.springcourse.models.Book;
import org.example.springcourse.models.Person;
import org.example.springcourse.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BooksValidator implements Validator {

    private final BooksService booksService;

    @Autowired
    public BooksValidator(BooksService booksService) {
        this.booksService = booksService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Book.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Book book = (Book) target;

        if(booksService.findByTitleStartingWith(book.getTitle()) == null){
            errors.rejectValue("title", "kod oshibki", "this name not found");
        }


    }
}
