package com.ydjs.repository;

import com.ydjs.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Data Access Object (Repository) interface for the Account entity.
 * Extends JpaRepository to provide standard database operations automatically.
 * 
 * Architectural Pattern:
 * - Employs the Repository Pattern via Spring Data JPA to separate persistence logic from business logic.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    /**
     * Retrieves an account from the database based on the provided username.
     * 
     * Implements specification:
     * - System Doc Section 2.1 (Helper): Ensures a duplicate username is detected during registration.
     * - System Doc Section 2.2: Used to retrieve account for login verification.
     * 
     * @param username The username of the account to retrieve.
     * @return An Optional containing the Account object if found, or an empty Optional if it does not exist.
     */
    Optional<Account> findByUsername(String username);
}
