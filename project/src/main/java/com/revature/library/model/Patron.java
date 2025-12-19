package com.revature.library.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "patrons")
public class Patron {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String email;

    @Column
    private LocalDate memberSince;

    @OneToMany(mappedBy = "patron", cascade = CascadeType.ALL)
    private List<Loan> loans = new ArrayList<>();

    public Patron() {}

    public Patron(String name, String email) {
        this.name = name;
        this.email = email;
        this.memberSince = LocalDate.now();
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public LocalDate getMemberSince() { return memberSince; }

    public void setMemberSince(LocalDate memberSince) { this.memberSince = memberSince; }
}