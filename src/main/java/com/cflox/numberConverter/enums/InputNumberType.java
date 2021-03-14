package com.cflox.numberConverter.enums;


import com.cflox.numberConverter.util.BeanNameUtil;

/**
 * Enum representation of supported input types.
 * Each declaration contains bean name, which is declared in BeanNameUtil class
 *
 * @author tatmaca
 */

public enum InputNumberType {
    BINARY(BeanNameUtil.BINARY),
    DECIMAL(BeanNameUtil.DECIMAL);

    private String beanName;

    InputNumberType(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
