package com.ecom.exceptions;

/**
 * Exception thrown when an invalid Excel file path is provided.
 *
 * <p>This exception is a subclass of {@link FrameworkExceptions} and is thrown
 * when an invalid Excel file path is provided as input. It indicates that the specified
 *  * file path does not exist or is not accessible..</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * throw new InValidExcelPathException("Please the check the path of excel file. "+ FrameConstants.getExcelPath(),cause);
 * }
 * </pre>
 */
public class InValidExcelPathException extends FrameworkExceptions {

    /**
     * Constructs a new invalid Excel path exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public InValidExcelPathException(String message) {
        super(message);
    }

    /**
     * Constructs a new invalid Excel path exception with the specified detail message and cause.
     *
     * @param message the detail message.
     * @param cause the cause.
     */
    public InValidExcelPathException(String message, Throwable cause) {
        super(message, cause);
    }
}
