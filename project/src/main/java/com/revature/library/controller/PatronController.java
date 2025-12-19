package com.revature.library.controller;

import com.revature.library.model.Patron;
import com.revature.library.service.PatronService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patrons")
public class PatronController {

    private final PatronService patronService;

    public PatronController(PatronService patronService) {
        this.patronService = patronService;
    }

    @GetMapping
    public List<Patron> getAllPatrons() {
        return patronService.getAllPatrons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patron> getById(@PathVariable Long id) {
        Optional<Patron> patron = patronService.findById(id);
        return patron.map(value -> ResponseEntity.ok(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Patron> addPatron(@Valid @RequestBody Patron patron) {
        Patron savedPatron = patronService.addPatron(patron);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPatron);
    }
}
