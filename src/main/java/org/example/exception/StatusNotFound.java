package org.example.exception;

public class StatusNotFound extends RuntimeException{
    public StatusNotFound(String message) {
        super(message);
    }
}
