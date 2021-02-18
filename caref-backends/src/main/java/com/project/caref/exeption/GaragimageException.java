package com.project.caref.exeption;

public class GaragimageException extends RuntimeException {
    public GaragimageException(String message) { super(message); }

    public GaragimageException(String message, Throwable cause) {
        super(message, cause);
    }
}
