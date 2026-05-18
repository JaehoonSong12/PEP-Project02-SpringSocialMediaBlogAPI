package com.ydjs.repository;

import com.ydjs.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Data Access Object (Repository) interface for the Message entity.
 * Extends JpaRepository to provide standard database operations automatically.
 * 
 * Architectural Pattern:
 * - Employs the Repository Pattern via Spring Data JPA to abstract and encapsulate data access.
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

    /**
     * Retrieves all messages posted by a specific user account.
     * 
     * Implements specification:
     * - System Doc Section 3.6: Retrieve Messages by Account ID.
     * 
     * @param postedBy The unique identifier of the account (accountId).
     * @return A List of Message objects posted by the given account. An empty list if none exist.
     */
    List<Message> findByPostedBy(Integer postedBy);
}
