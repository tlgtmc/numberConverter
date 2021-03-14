package com.cflox.numberConverter.enums;


import com.cflox.numberConverter.util.BeanNameUtil;

/**
 * Enum representation of supported output type(s).
 * Each declaration contains bean name, which is declared in BeanNameUtil class
 *
 * @author tatmaca
 */

public enum OutputNumberType {
    ROMAN(BeanNameUtil.ROMAN);

    private String beanName;

    OutputNumberType(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
