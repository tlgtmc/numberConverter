package com.cflox.numberConverter.domain.dto;

import com.cflox.numberConverter.enums.InputNumberType;
import com.cflox.numberConverter.enums.OutputNumberType;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * {@code NumberConverterRequestDto} is request Dto to call the endpoint
 *
 * It has two fields
 * - number to be converted
 * - inputNumberType type of the given number
 * - outputNumberType type of requested output
 *
 * @author tatmaca
 */

@Data
public class NumberConverterRequestDto {

    @NotNull
    private String number;

    @NotNull
    private InputNumberType inputNumberType;

    @NotNull
    private OutputNumberType outputNumberType;
}
