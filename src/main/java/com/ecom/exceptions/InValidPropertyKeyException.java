package com.ecom.exceptions;

/**
 * Exception thrown when an invalid property key is provided.
 *
 * <p>This exception is a subclass of {@link FrameworkExceptions} and is thrown
 * when an invalid property key is provided as input. It indicates that the specified
 * property key does not exist or is not recognized.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * throw new InValidPropertyKeyException("Property name "+key+" is not found. Please check the config.properties and/or Verify whether all the associated keys are correctly added in Econfig enum");
 * }
 * </pre>
 */
public class InValidPropertyKeyException extends FrameworkExceptions {

    /**
     * Constructs a new invalid property key exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public InValidPropertyKeyException(String message) {
        super(message);
    }

    /**
     * Constructs a new invalid property key exception with the specified detail message and cause.
     *
     * @param message the detail message.
     * @param cause the cause.
     */
    public InValidPropertyKeyException(String message, Throwable cause) {
        super(message, cause);
    }
}