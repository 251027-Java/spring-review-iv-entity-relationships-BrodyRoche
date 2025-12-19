package com.revature.library.controller;

import com.revature.library.model.Book;
import com.revature.library.service.BookService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable Long id) {
        Optional<Book> book = bookService.findById(id);
        return book.map(value -> ResponseEntity.ok(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) {
        Book savedBook = bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @PutMapping("/{id}/checkout")
        public ResponseEntity<Book> checkoutBook(@PathVariable Long id) {
            Book book = bookService.checkoutBook(id);
            return ResponseEntity.ok(book);
        }

    @PutMapping("/{id}/return")
    public ResponseEntity<Book> returnBook(@PathVariable Long id) {
        Book book = bookService.returnBook(id);
        return ResponseEntity.ok(book);
    }
}
