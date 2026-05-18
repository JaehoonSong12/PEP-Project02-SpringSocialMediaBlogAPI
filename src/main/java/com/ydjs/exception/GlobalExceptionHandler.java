package com.ydjs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global exception handler for the REST API.
 * Intercepts custom exceptions thrown by the application and maps them to appropriate HTTP responses.
 * 
 * Architectural Pattern:
 * - Controller Advice (AOP) pattern for centralized exception handling across all controller endpoints.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles ClientValidationException and returns a 400 Bad Request response.
     * 
     * Implements specification:
     * - System Doc Section 1.3: Exception Handling (Client Error).
     *
     * @param ex the ClientValidationException thrown by the application
     * @return a ResponseEntity with an HTTP 400 status
     */
    @ExceptionHandler(ClientValidationException.class)
    public ResponseEntity<Void> handleClientValidationException(ClientValidationException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    /**
     * Handles DuplicateResourceException and returns a 409 Conflict response.
     * 
     * Implements specification:
     * - System Doc Section 1.3: Exception Handling (Conflict).
     *
     * @param ex the DuplicateResourceException thrown by the application
     * @return a ResponseEntity with an HTTP 409 status
     */
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<Void> handleDuplicateResourceException(DuplicateResourceException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    /**
     * Handles UnauthorizedException and returns a 401 Unauthorized response.
     * 
     * Implements specification:
     * - System Doc Section 1.3: Exception Handling (Unauthorized).
     *
     * @param ex the UnauthorizedException thrown by the application
     * @return a ResponseEntity with an HTTP 401 status
     */
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Void> handleUnauthorizedException(UnauthorizedException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
