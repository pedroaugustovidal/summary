package com.sales.summary.domain.exceptions;

public class SalesmanWrongFormatException extends RuntimeException {

    private static final String message = "Salesman is not possible to build!";

    public SalesmanWrongFormatException() {
        super(message);
    }

}
