package com.cflox.numberConverter.domain.dto;

import com.cflox.numberConverter.enums.NumberType;
import lombok.Data;

import javax.validation.Valid;

/**
 * @author tatmaca
 */

@Data
public class NumberConverterRequestDto {

    private String number;

    @Valid
    private NumberType numberType;
}
