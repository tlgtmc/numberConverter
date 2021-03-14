package com.cflox.numberConverter.converter.impl;

import com.cflox.numberConverter.converter.IIntegerConverter;
import com.cflox.numberConverter.exception.InvalidInputException;
import com.cflox.numberConverter.util.BeanNameUtil;
import org.springframework.stereotype.Component;

/**
 * {@code DecimalToIntegerConverterImpl} implements {@code IIntegerConverter}
 * Converts incoming Decimal number to Integer value
 *
 * @author tatmaca
 */

@Component(BeanNameUtil.DECIMAL)
public class DecimalToIntegerConverterImpl implements IIntegerConverter {

    /**
     * {@code convert} converts decimal number to integer representation
     *
     * @param number : value to be converted
     * @return : Integer representation of given decimal number
     * @throws InvalidInputException if input is not a valid decimal
     */
    @Override
    public int convert(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(String.format("%s is not a valid decimal, please do not use fraction.", number));
        }
    }
}
