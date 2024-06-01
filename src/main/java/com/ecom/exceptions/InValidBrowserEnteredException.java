package com.ecom.exceptions;

/**
 * Exception thrown when an invalid browser name is provided.
 *
 * <p>This exception is a subclass of {@link FrameworkExceptions} and is thrown
 * when an invalid browser name is provided as input.It indicates that the specified
 *  * browser is not supported or recognized by the framework.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * throw new InValidBrowserEnteredException("Provided browser " + browserName + " is invalid,Retry with valid browser!");
 * }
 * </pre>
 */
public class InValidBrowserEnteredException extends FrameworkExceptions {

    /**
     * Constructs a new invalid browser entered exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public InValidBrowserEnteredException(String message) {
        super(message);
    }
}