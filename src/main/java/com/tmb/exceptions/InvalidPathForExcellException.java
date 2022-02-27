package com.tmb.exceptions;

public class InvalidPathForExcellException extends InvalidPathForFilesException{

    public InvalidPathForExcellException(String message) {
        super(message);
    }

    public InvalidPathForExcellException(String message, Throwable cause) {
        super(message, cause);
    }
}
