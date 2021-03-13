package com.cflox.numberConverter.converter.impl;

import com.cflox.numberConverter.converter.IRomanConverter;
import com.cflox.numberConverter.domain.RomanNumber;
import org.springframework.stereotype.Component;

/**
 * @author tatmaca
 */

@Component("IntegerConverter")
public class IntegerToRomanConverterImpl implements IRomanConverter {

    @Override
    public String convert(int number) {
        System.out.println("I will convert -> " + number);
        return RomanNumber.toRoman(number);
    }
}
