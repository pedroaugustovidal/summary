package com.sales.summary.domain.exceptions;

public class SalesWrongFormatException extends RuntimeException {

    private static final String message = "Sales is not possible to build!";

    public SalesWrongFormatException() {
        super(message);
    }

}
