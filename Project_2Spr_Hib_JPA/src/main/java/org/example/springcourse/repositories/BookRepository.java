package org.example.springcourse.repositories;

import org.example.springcourse.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByTitleStartingWith(String startingWith);
}
