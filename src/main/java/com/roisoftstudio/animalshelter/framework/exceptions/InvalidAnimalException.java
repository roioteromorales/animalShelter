package com.roisoftstudio.animalshelter.framework.exceptions;

public class InvalidAnimalException extends Exception {
    public InvalidAnimalException(String message) {
        super(message);
    }

    public InvalidAnimalException(String message, Throwable cause) {
        super(message, cause);
    }
}
