package com.cflox.numberConverter.domain;

import java.util.TreeMap;

/**
 * {@code RomanNumber} is RomanNumber representation class.
 *
 * <p>It includes the roman representation of specific numbers.
 * Each one stored in a TreeMap, because keys are stored by natural order.</p>
 *
 * @author tatmaca
 */

public class RomanNumber {

    private static final TreeMap<Integer, String> map = new TreeMap<>();

    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    private RomanNumber() {
    }

    /**
     * {@code from} method converts given integer value to the roman value
     *
     * @param number : value to be converted
     * @return : Roman representation of given number
     */
    public static final String from(int number) {
        int l =  map.floorKey(number);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + from(number-l);
    }
}
