package com.cflox.numberConverter.exception;

/**
 * @author tatmaca
 */

public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super(message);
    }
}