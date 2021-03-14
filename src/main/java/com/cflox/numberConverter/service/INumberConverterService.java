package com.cflox.numberConverter.service;

import com.cflox.numberConverter.domain.ApiResponse;
import com.cflox.numberConverter.domain.dto.NumberConverterRequestDto;

/**
 * Service layer interface
 *
 * @author tatmaca
 */

public interface INumberConverterService {

    ApiResponse convertToRoman(NumberConverterRequestDto requestDto);
}
