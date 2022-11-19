package org.example.springcourse.services;


import org.example.springcourse.models.Book;
import org.example.springcourse.repositories.BooksRepository;
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

    private BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }


    public List<Book> findAll(int page, int books_per_page, boolean sorted) {
        if (sorted == true && page != 0 && books_per_page != 0)
            return booksRepository.findAll(PageRequest.of(page, books_per_page, Sort.by("year"))).getContent();
        if (sorted == true)
            return booksRepository.findAll(Sort.by("year"));
        if (page != 0 && books_per_page != 0)
            return booksRepository.findAll(PageRequest.of(page, books_per_page)).getContent();
        return booksRepository.findAll();
    }

    public Book findOne(int id) {
        Optional<Book> findBook = booksRepository.findById(id);
        return findBook.orElse(null);
    }

    public Book findByTitleStartingWith(String startingStr) {
        Optional<Book> findBook = booksRepository.findByTitleStartingWith(startingStr);
        return findBook.orElse(null);
    }

    @Transactional
    public void save(Book newBook) {
        booksRepository.save(newBook);
    }

    @Transactional
    public void update(int id, Book updateBook) {
        updateBook.setId(id);
        booksRepository.save(updateBook);
    }

    @Transactional
    public void delete(int id) {
        booksRepository.deleteById(id);
    }
}
