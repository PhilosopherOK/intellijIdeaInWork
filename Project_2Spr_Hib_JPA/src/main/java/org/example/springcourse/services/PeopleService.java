package org.example.springcourse.services;


import org.example.springcourse.models.Book;
import org.example.springcourse.models.Person;
import org.example.springcourse.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Person findOne(int id) {
        Optional<Person> foundPerson = peopleRepository.findById(id);
        return foundPerson.orElse(null);
    }

    @Transactional
    public List<Book> checkToStitch(List<Book> list) {
        Date toDay = new Date();
        for (Book book : list) {
            long timeStitched = toDay.getTime() - book.getDate_of_takeBook().getTime();
            if (timeStitched > 51840000) {
                book.setStitched(true);
            }
        }
        return list;
    }

    @Transactional
    public List<Book> takeStitchedBooks(int id) {
        List<Book> listOfBooks = findOne(id).getBooks();
        checkToStitch(listOfBooks);
        for (Book book : listOfBooks) {
            if (!book.isStitched()) {
                listOfBooks.remove(book);
            }
        }
        return listOfBooks;
    }

    @Transactional
    public List<Book> takeBooksWithOutStitched(int id) {
        List<Book> listOfBooks = findOne(id).getBooks();
        checkToStitch(listOfBooks);
        for (Book book : listOfBooks) {
            if (book.isStitched()) {
                listOfBooks.remove(book);
            }
        }
        return listOfBooks;
    }

    @Transactional
    public void save(Person person) {
        peopleRepository.save(person);
    }

    @Transactional
    public void update(int id, Person updatePerson) {
        updatePerson.setId(id);
        peopleRepository.save(updatePerson);
    }

    @Transactional
    public void delete(int id) {
        peopleRepository.deleteById(id);
    }
}