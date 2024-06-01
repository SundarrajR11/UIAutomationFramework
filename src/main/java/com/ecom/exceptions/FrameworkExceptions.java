package com.ecom.exceptions;

/**
 * Custom runtime exception class for framework-specific exceptions.
 *
 * <p>This class extends the {@link RuntimeException} class to provide custom
 * exceptions specific to the framework. It allows throwing exceptions with a
 * descriptive message and optionally wrapping another throwable.</p>
 *
 */
public class FrameworkExceptions extends RuntimeException {

    /**
     * Constructs a new framework exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public FrameworkExceptions(String message) {
        super(message);
    }

    /**
     * Constructs a new framework exception with the specified detail message and cause.
     *
     * @param message the detail message.
     * @param cause the cause.
     */
    public FrameworkExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}