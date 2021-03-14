package com.cflox.numberConverter.exception;

/**
 * This {@code RuntimeException} throws when input is invalid
 *
 * @author tatmaca
 */

public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super(message);
    }
}