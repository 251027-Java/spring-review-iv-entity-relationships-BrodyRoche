[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/5FIu1qim)
# Lab: Hibernate ORM - Entity Relationships

## Goal
Extend the Library system with related entities (Patron, Loan) and implement JPA relationships.

## Learning Objectives
- Create entity relationships (OneToMany, ManyToOne, ManyToMany)
- Use JPA annotations for relationship mapping
- Handle cascading operations
- Implement fetch strategies

## Pre-requisites
- Completed 2304-6-1, 2304-6-2, 2304-6-3

## Tasks

### Task 1: Create Patron Entity
Create `Patron.java` with fields:
- id: Long (auto-generated)
- name: String (required)
- email: String (unique)
- memberSince: LocalDate

### Task 2: Create Loan Entity
Create `Loan.java` to track book loans:
- id: Long
- book: Book (ManyToOne)
- patron: Patron (ManyToOne)
- loanDate: LocalDate
- dueDate: LocalDate
- returnDate: LocalDate (nullable)

**Starter code provided**: See `starter_code/Loan.java`

### Task 3: Update Book Entity
Add relationship to Loan:
```java
@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
private List<Loan> loans = new ArrayList<>();
```

### Task 4: Update Patron Entity
Add relationship to Loan:
```java
@OneToMany(mappedBy = "patron", cascade = CascadeType.ALL)
private List<Loan> loans = new ArrayList<>();
```

### Task 5: Create Loan Service
Implement `LoanService.java` with methods:
- `createLoan(Long bookId, Long patronId)`: Loan
- `returnLoan(Long loanId)`: Loan
- `getActiveLoans()`: List<Loan>
- `getLoansByPatron(Long patronId)`: List<Loan>

### Task 6: Create Loan Controller
Create REST endpoints:
- POST /api/loans (create loan)
- PUT /api/loans/{id}/return
- GET /api/loans/active
- GET /api/patrons/{id}/loans

## Deliverables
1. Patron and Loan entities with relationships
2. Updated Book entity with loans relationship
3. LoanService with business logic
4. LoanController with REST endpoints

## Verification
- [ ] Can create a new patron
- [ ] Can create a loan linking book and patron
- [ ] Can return a loan
- [ ] Can query loans by patron

## Starter Code
See `starter_code/` directory
