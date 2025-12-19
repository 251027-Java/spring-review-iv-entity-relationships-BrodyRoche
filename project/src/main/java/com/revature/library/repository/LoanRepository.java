package com.revature.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.library.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {}