package com.revature.library.service;

import com.revature.library.exception.BookNotFoundException;
import com.revature.library.exception.LoanNotFoundException;
import com.revature.library.exception.PatronNotFoundException;
import com.revature.library.model.Book;
import com.revature.library.model.Loan;
import com.revature.library.model.Patron;
import com.revature.library.repository.BookRepository;
import com.revature.library.repository.LoanRepository;
import com.revature.library.repository.PatronRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final PatronRepository patronRepository;

    public LoanService(LoanRepository loanRepository, BookRepository bookRepository, PatronRepository patronRepository) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
        this.patronRepository = patronRepository;
    }

    public List<Loan> getActiveLoans() {
        return loanRepository.findAll().stream().toList();
    }

    public List<Loan> getLoansByPatron(Long patronId){
        return loanRepository.findAll().stream().filter(loan -> loan.getPatron().getId().equals(patronId)).toList();
    }

    public Loan createLoan(Long bookId, Long patronId){
        Optional<Book> book = bookRepository.findById(bookId);
        if(book.isEmpty()){
            throw new BookNotFoundException("Book with ID " + bookId + " not found.");
        }
        Optional<Patron> patron = patronRepository.findById(patronId);
        if(patron.isEmpty()){
            throw new PatronNotFoundException("Patron with ID " + patronId + " not found.");
        }
        return loanRepository.save(new Loan(book.get(), patron.get()));
    }

    public Loan returnLoan(Long loanId){
        Optional<Loan> optionalLoan = loanRepository.findById(loanId);
        if(optionalLoan.isPresent()){
            Loan loan = optionalLoan.get();
            loan.setReturnDate(java.time.LocalDate.now());
            return loanRepository.save(loan);
        } else {
            throw new LoanNotFoundException("Loan with ID " + loanId + " not found.");
        }
    } 
}
