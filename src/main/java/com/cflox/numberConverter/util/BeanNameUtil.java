package com.cflox.numberConverter.util;

/**
 * This class holds the bean names of supported conversion types.
 * These types must be used in their {@code IIntegerConverter }implementations
 * and {@code NumberType}
 *
 * @author tatmaca
 */

public class BeanNameUtil {


    // Input type bean names
    public static final String BINARY   = "BinaryToIntegerConverterBean";
    public static final String DECIMAL  = "DecimalToIntegerConverterBean";

    // Output type bean names
    public static final String ROMAN    = "IntegerToRomanConverterBean";
}
