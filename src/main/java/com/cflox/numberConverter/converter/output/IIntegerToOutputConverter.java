package com.cflox.numberConverter.converter.output;

/**
 * This interface is being used by classes that converts Integer to specified output representations
 *
 * @author tatmaca
 */

public interface IIntegerToOutputConverter {
    String convert(int number);
}
