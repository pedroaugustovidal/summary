package com.sales.summary.domain.exceptions;

public class CustomerWrongFormatException extends RuntimeException {

    private static final String message = "Customer is not possible to build!";

    public CustomerWrongFormatException() {
        super(message);
    }

}
