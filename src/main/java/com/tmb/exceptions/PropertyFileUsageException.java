package com.tmb.exceptions;

public class PropertyFileUsageException extends InvalidPathForFilesException{

    public PropertyFileUsageException(String message) {
        super(message);
    }

    public PropertyFileUsageException(String message, Throwable cause) {
        super(message, cause);
    }
}
