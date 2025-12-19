package com.revature.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.library.model.Patron;

public interface PatronRepository extends JpaRepository<Patron, Long> {}