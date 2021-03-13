package com.cflox.numberConverter.converter.impl;

import com.cflox.numberConverter.converter.IIntegerConverter;
import com.cflox.numberConverter.util.BeanNameUtil;
import org.springframework.stereotype.Component;

/**
 * @author tatmaca
 */

@Component(BeanNameUtil.BINARY)
public class BinaryToIntegerConverterImpl implements IIntegerConverter {

    @Override
    public int convert(String number) {
        System.out.println("Converting Binary...");
        try {
            return Integer.parseInt(number, 2);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Not a valid Binary");
        }
    }
}
