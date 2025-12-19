package com.revature.library.controller;

import com.revature.library.model.Loan;
import com.revature.library.service.LoanService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    public List<Loan> getActiveLoans() {
        return loanService.getActiveLoans();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Loan>> getLoansByPatron(@PathVariable Long id){
        List<Loan> loan = loanService.getLoansByPatron(id);
        return ResponseEntity.ok(loan);
    }

    @PutMapping("/{id}/return")
    public ResponseEntity<Loan> returnLoan(@PathVariable Long id){
        Loan loan = loanService.returnLoan(id);
        return ResponseEntity.ok(loan);
    }

    @PostMapping
    public ResponseEntity<Loan> creatLoan(@Valid @RequestBody Loan loan) {
        Loan savedLoan = loanService.createLoan(loan.getBook().getId(), loan.getPatron().getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLoan);
    }
}
