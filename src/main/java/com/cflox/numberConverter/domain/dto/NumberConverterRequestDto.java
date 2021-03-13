package com.cflox.numberConverter.domain.dto;

import com.cflox.numberConverter.enums.NumberType;
import lombok.Data;

/**
 * @author tatmaca
 */

@Data
public class NumberConverterRequestDto {

    private String number;
    private NumberType numberType;
}
