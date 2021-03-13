package com.cflox.numberConverter.converter.impl;

import com.cflox.numberConverter.converter.IIntegerConverter;
import org.springframework.stereotype.Component;

/**
 * @author tatmaca
 */

@Component("DecimalConverter")
public class DecimalToIntegerConverterImpl implements IIntegerConverter {

    @Override
    public int convert(String number) {
        System.out.println("Converting Decimal...");
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Not a valid Decimal");
        }    }
}
