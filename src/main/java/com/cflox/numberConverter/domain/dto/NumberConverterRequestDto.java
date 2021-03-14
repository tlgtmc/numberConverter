package com.cflox.numberConverter.domain.dto;

import com.cflox.numberConverter.enums.InputNumberType;
import com.cflox.numberConverter.enums.OutputNumberType;
import lombok.Data;

import javax.validation.Valid;

/**
 * {@code NumberConverterRequestDto} is request Dto to call the endpoint
 *
 * It has two fields
 * - number to be converted
 * - numberType type of the given number
 *
 * @author tatmaca
 */

@Data
public class NumberConverterRequestDto {

    private String number;

    @Valid
    private InputNumberType inputNumberType;

    @Valid
    private OutputNumberType outputNumberType;
}
