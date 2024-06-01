package com.ecom.exceptions;

/**
 * Exception thrown when unable to load a file in the browser.
 *
 * <p>This exception is a subclass of {@link FrameworkExceptions} and is thrown
 * when there is an issue loading a file in the browser. It indicates that the specified
 * file could not be loaded due to various reasons such as file not found, permission
 * issues, or network problems.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * throw new UnableToLoadFileInBrowserException("Please verify the url is null free or invalid path and/or verify whether browser supports desktop action",cause);
 * }
 * </pre>
 */
public class UnableToLoadFileInBrowserException extends FrameworkExceptions {

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public UnableToLoadFileInBrowserException(String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified detail message and cause.
     *
     * @param message the detail message.
     * @param cause the cause.
     */
    public UnableToLoadFileInBrowserException(String message, Throwable cause) {
        super(message, cause);
    }
}
