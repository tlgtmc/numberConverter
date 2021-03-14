package com.cflox.numberConverter.converter.impl;

import com.cflox.numberConverter.converter.IIntegerConverter;
import com.cflox.numberConverter.exception.InvalidInputException;
import com.cflox.numberConverter.util.BeanNameUtil;
import org.springframework.stereotype.Component;

/**
 * @author tatmaca
 */

@Component(BeanNameUtil.DECIMAL)
public class DecimalToIntegerConverterImpl implements IIntegerConverter {

    @Override
    public int convert(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(String.format("%s is not a valid decimal, please do not use fraction.", number));
        }
    }
}
