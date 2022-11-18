package org.example.springcourse.repositories;

import org.example.springcourse.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {
public Optional<Book> findByTitleStartingWith(String startingTitle);
}
