package com.cflox.numberConverter.converter.input.impl;

import com.cflox.numberConverter.converter.input.IInputToIntegerConverter;
import com.cflox.numberConverter.exception.InvalidInputException;
import com.cflox.numberConverter.util.BeanNameUtil;
import org.springframework.stereotype.Component;

/**
 * {@code BinaryToIntegerConverterImpl} implements {@code IIntegerConverter}
 * Converts incoming Binary number to Integer value
 *
 * @author tatmaca
 */

@Component(BeanNameUtil.BINARY)
public class BinaryToIntegerConverterImpl implements IInputToIntegerConverter {

    /**
     * {@code convert} converts binary number to integer representation
     *
     * @param number : value to be converted
     * @return : Integer representation of given binary number
     * @throws InvalidInputException if input is not a valid binary
     */
    @Override
    public int convert(String number) {
        try {
            return Integer.parseInt(number, 2);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(String.format("%s is not a valid binary.", number));
        }
    }
}
