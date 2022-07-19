package com.sales.summary.domain.exceptions;

public class ErrorLineProcessingException extends RuntimeException {

    private static final String message = "Error on line processing.";

    public ErrorLineProcessingException() {
        super(message);
    }

}
