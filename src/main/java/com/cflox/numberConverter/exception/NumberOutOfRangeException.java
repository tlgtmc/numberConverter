package com.cflox.numberConverter.exception;

/**
 * @author tatmaca
 */

public class NumberOutOfRangeException extends RuntimeException {
    public NumberOutOfRangeException(int num) {
        super(String.format("Given number is out of range (1 - 3999): %s", num));
    }
}