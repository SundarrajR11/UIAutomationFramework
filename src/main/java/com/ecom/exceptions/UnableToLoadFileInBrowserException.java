package com.ecom.exceptions;

public class UnableToLoadFileInBrowserException extends FrameworkExceptions{
    public UnableToLoadFileInBrowserException(String message) {
        super(message);
    }
    public UnableToLoadFileInBrowserException(String message, Throwable cause) {
        super(message, cause);
    }
}
