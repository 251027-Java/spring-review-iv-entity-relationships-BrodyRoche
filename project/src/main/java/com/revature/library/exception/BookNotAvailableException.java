package com.revature.library.exception;

public class BookNotAvailableException extends RuntimeException {

    public BookNotAvailableException() { super(); }

    public BookNotAvailableException(String message) { super(message); }

    public BookNotAvailableException(String message, Throwable cause) { super(message, cause); }
}