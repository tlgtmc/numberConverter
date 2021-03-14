package com.cflox.numberConverter.converter.impl;

import com.cflox.numberConverter.converter.IRomanConverter;
import com.cflox.numberConverter.domain.RomanNumber;
import com.cflox.numberConverter.exception.NumberOutOfRangeException;
import org.springframework.stereotype.Component;

/**
 * @author tatmaca
 */

@Component()
public class IntegerToRomanConverterImpl implements IRomanConverter {

    @Override
    public String convert(int number) {

        if (number > 0 && number <= 3999)
            return RomanNumber.from(number);

        throw new NumberOutOfRangeException(number);
    }
}
