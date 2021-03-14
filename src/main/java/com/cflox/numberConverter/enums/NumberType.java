package com.cflox.numberConverter.enums;


import com.cflox.numberConverter.util.BeanNameUtil;

/**
 * Enum representation of supported conversion types.
 * Each declaration contains bean name, which is declared in BeanNameUtil class
 *
 * @author tatmaca
 */

public enum NumberType {
    BINARY(BeanNameUtil.BINARY),
    DECIMAL(BeanNameUtil.DECIMAL);

    private String beanName;

    NumberType(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
