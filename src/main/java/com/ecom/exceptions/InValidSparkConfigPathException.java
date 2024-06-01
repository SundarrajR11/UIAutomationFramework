package com.ecom.exceptions;

/**
 * Exception thrown when an invalid Spark configuration path is provided.
 *
 * <p>This exception is a subclass of {@link FrameworkExceptions} and is thrown
 * when an invalid Spark configuration path is provided as input. It indicates that the specified
 * configuration path does not exist or is not accessible.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * throw new InValidSparkConfigPathException("Invalid Spark configuration path: " + path);
 * }
 * </pre>
 */
public final class InValidSparkConfigPathException extends FrameworkExceptions {

    /**
     * Constructs a new invalid Spark configuration path exception with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method).
     */
    public InValidSparkConfigPathException(String message) {
        super(message);
    }

    /**
     * Constructs a new invalid Spark configuration path exception with the specified detail message and cause.
     *
     * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method).
     * @param cause the cause (which is saved for later retrieval by the {@link #getCause()} method).
     */
    public InValidSparkConfigPathException(String message, Throwable cause) {
        super(message, cause);
    }
}