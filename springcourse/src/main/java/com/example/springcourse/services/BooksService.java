package com.example.springcourse.services;


import com.example.springcourse.models.Book;
import com.example.springcourse.models.Person;
import com.example.springcourse.repositories.BooksRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BooksService {

    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }


    public List<Book> findAll(String page, String books_per_page, boolean sorted) {
        if (sorted && page != null && books_per_page != null) {
            int page1 = Integer.parseInt(page);
            int books_per_page1 = Integer.parseInt(books_per_page);
            return booksRepository.findAll(PageRequest.of(page1, books_per_page1, Sort.by("year"))).getContent();
        }
        if (sorted) {
            return booksRepository.findAll(Sort.by("year"));
        }
        if (page != null && books_per_page != null) {
            int page1 = Integer.parseInt(page);
            int books_per_page1 = Integer.parseInt(books_per_page);
            return booksRepository.findAll(PageRequest.of(page1, books_per_page1)).getContent();
        }
        return booksRepository.findAll();
    }

    public List<Book> findAll() {
        return booksRepository.findAll();
    }

    public Book findOne(int id) {
        Optional<Book> findBook = booksRepository.findById(id);
        return findBook.orElse(null);
    }

    public List <Book> findByTitleStartingWith(String startingStr) {
        return booksRepository.findByTitleStartingWith(startingStr);
    }

    @Transactional
    public void save(Book newBook) {
        booksRepository.save(newBook);
    }

    @Transactional
    public void update(int id, Book updateBook) {
        Book bookToBeUpdated = booksRepository.findById(id).get();

        updateBook.setId(id);
        updateBook.setOwner(bookToBeUpdated.getOwner());
        booksRepository.save(updateBook);
    }

    @Transactional
    public void delete(int id) {
        booksRepository.deleteById(id);
    }

    @Transactional
    public void addHostByBookId(int id, Person person) {
        Book bookWithOwner = findOne(id);
        bookWithOwner.setDate_of_takeBook(new Date());
        bookWithOwner.setOwner(person);
        booksRepository.save(bookWithOwner);
    }

    @Transactional
    public void deleteHostByBookId(int id) {
        Book bookWithOutHost = findOne(id);
        bookWithOutHost.setDate_of_takeBook(null);
        bookWithOutHost.setOwner(null);
        booksRepository.save(bookWithOutHost);
    }
}
