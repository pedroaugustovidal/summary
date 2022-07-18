package com.sales.summary.domain.exceptions;

public class FileAlreadyCreatedException extends RuntimeException{

    public FileAlreadyCreatedException() {
        super("File already created. Nothing to do.");
    }

}
