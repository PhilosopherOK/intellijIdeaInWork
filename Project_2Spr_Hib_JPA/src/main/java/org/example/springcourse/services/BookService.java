package org.example.springcourse.services;

import org.example.springcourse.models.Book;
import org.example.springcourse.repositories.BookRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> findAll(int page, int books_per_page, boolean sorted) {
        if (sorted == true)
            return bookRepository.findAll(Sort.by("year"));
        if (page != 0 && books_per_page != 0)
            return bookRepository.findAll(PageRequest.of(page, books_per_page)).getContent();
        if (sorted == true && page != 0 && books_per_page != 0)
            return bookRepository.findAll(PageRequest.of(page, books_per_page, Sort.by("year"))).getContent();
        return bookRepository.findAll();
    }

    public Book findByOne(int id) {
        Optional<Book> findOneBook = bookRepository.findById(id);
        return findOneBook.orElse(null);
    }

    @Transactional
    public void save(Book newBook) {
        bookRepository.save(newBook);
    }

    @Transactional
    public void update(int id, Book updateBook) {
        updateBook.setId(id);
        bookRepository.save(updateBook);
    }

    @Transactional
    public void delete(int id) {
        bookRepository.deleteById(id);
    }

}
