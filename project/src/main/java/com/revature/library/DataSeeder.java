package com.revature.library;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.revature.library.model.Book;
import com.revature.library.model.Loan;
import com.revature.library.model.Patron;
import com.revature.library.repository.BookRepository;
import com.revature.library.repository.LoanRepository;
import com.revature.library.repository.PatronRepository;

@Configuration
public class DataSeeder {
    @Bean
    CommandLineRunner seeder(BookRepository bookRepository, PatronRepository patronRepository, LoanRepository loanRepository) {
        return args -> {
            bookRepository.save(new Book("Clean Code", "Robert Martin", "1234567890"));
            bookRepository.save(new Book("The Pragmatic Programmer", "David Thomas", "0987654321"));
            bookRepository.save(new Book("Design Patterns", "Gang of Four", "1122334455"));
            bookRepository.save(new Book("Effective Java", "Joshua Bloch", "5544332211"));
            bookRepository.save(new Book("Spring in Action", "Craig Walls", "6677889900"));
            Book book = new Book("Java Concurrency in Practice", "Brian Goetz", "4433221100");
            bookRepository.save(book);

            patronRepository.save(new Patron("Brody Roche", "brodyroche@yahoo.com"));
            patronRepository.save(new Patron("Richard Hawkins", "richardhawkins@gmail.com"));
            Patron patron = new Patron("Alice Johnson", "alicejohnson@gmail.com");
            patronRepository.save(patron);

            loanRepository.save(new Loan(book, patron));
        };
    }
}
