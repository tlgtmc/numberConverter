package com.cflox.numberConverter.enums;

import lombok.Data;

/**
 * @author tatmaca
 */

public enum NumberType {
    BINARY("BinaryConverter"),
    DECIMAL("DecimalConverter");

    private String beanName;

    NumberType(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
