package com.cflox.numberConverter.converter.impl;

import com.cflox.numberConverter.converter.IRomanConverter;
import com.cflox.numberConverter.domain.RomanNumber;
import com.cflox.numberConverter.exception.InvalidInputException;
import com.cflox.numberConverter.exception.NumberOutOfRangeException;
import org.springframework.stereotype.Component;

/**
 * {@code IntegerToRomanConverterImpl} implements {@code IRomanConverter}
 * Converts incoming Integer number to Roman Number representation
 *
 * @author tatmaca
 */

@Component()
public class IntegerToRomanConverterImpl implements IRomanConverter {

    /**
     * {@code convert} converts Integer to Roman Number representation
     *
     * @param number : value to be converted
     * @return : Roman representation of given Integer number
     * @throws NumberOutOfRangeException if input is out of range (1, 3999)
     */
    @Override
    public String convert(int number) {

        if (number > 0 && number <= 3999)
            return RomanNumber.from(number);

        throw new NumberOutOfRangeException(number);
    }
}
