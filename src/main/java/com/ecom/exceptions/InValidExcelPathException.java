package com.ecom.exceptions;

public class InValidExcelPathException extends  FrameworkExceptions{
    public InValidExcelPathException(String message){
        super(message);
    }
    public InValidExcelPathException(String message,Throwable cause){
        super(message,cause);
    }
}
