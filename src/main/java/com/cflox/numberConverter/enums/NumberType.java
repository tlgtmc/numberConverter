package com.cflox.numberConverter.enums;


import com.cflox.numberConverter.util.BeanNameUtil;

/**
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
