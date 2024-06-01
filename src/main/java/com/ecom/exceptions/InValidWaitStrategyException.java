package com.ecom.exceptions;

/**
 * Exception thrown when an invalid wait strategy is provided.
 *
 * <p>This exception is a subclass of {@link FrameworkExceptions} and is thrown
 * when an invalid wait strategy is provided as input. It indicates that the specified
 * wait strategy is not supported or recognized.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * throw new InValidWaitStrategyException("Invalid wait strategy: " + strategy);
 * }
 * </pre>
 */
public class InValidWaitStrategyException extends FrameworkExceptions {

    /**
     * Constructs a new invalid wait strategy exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public InValidWaitStrategyException(String message) {
        super(message);
    }

    /**
     * Constructs a new invalid wait strategy exception with the specified detail message and cause.
     *
     * @param message the detail message.
     * @param cause the cause.
     */
    public InValidWaitStrategyException(String message, Throwable cause) {
        super(message, cause);
    }
}