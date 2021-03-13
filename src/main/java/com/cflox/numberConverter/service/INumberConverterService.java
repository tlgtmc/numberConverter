package com.cflox.numberConverter.service;

import com.cflox.numberConverter.domain.ApiResponse;
import com.cflox.numberConverter.domain.dto.NumberConverterRequestDto;
import org.springframework.stereotype.Service;

/**
 * @author tatmaca
 */

public interface INumberConverterService {

    ApiResponse convertToRoman(NumberConverterRequestDto requestDto);
}
