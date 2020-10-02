package org.techniu.isbackend.service;

public class ExceptionMessage extends RuntimeException {
    public ExceptionMessage() {
        super();
    }
    public ExceptionMessage(String message) {
        super(message);
    }
}
