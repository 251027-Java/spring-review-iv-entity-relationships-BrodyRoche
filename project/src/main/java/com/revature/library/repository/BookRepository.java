package com.revature.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.library.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthorContaining(String author);
}
