package com.cflox.numberConverter.converter.impl;

import com.cflox.numberConverter.converter.IIntegerConverter;
import com.cflox.numberConverter.util.BeanNameUtil;
import org.springframework.stereotype.Component;

/**
 * @author tatmaca
 */

@Component(BeanNameUtil.DECIMAL)
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
