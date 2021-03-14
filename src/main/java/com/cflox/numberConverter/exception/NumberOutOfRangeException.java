package com.cflox.numberConverter.exception;

/**
 * This {@code RuntimeException} throws when input is out of range
 *
 * @author tatmaca
 */

public class NumberOutOfRangeException extends RuntimeException {
    public NumberOutOfRangeException(int num) {
        super(String.format("Given number is out of range (1 - 3999): %s", num));
    }
}