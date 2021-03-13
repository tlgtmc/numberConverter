package com.cflox.numberConverter.service.impl;

import com.cflox.numberConverter.converter.IIntegerConverter;
import com.cflox.numberConverter.converter.IRomanConverter;
import com.cflox.numberConverter.domain.ApiResponse;
import com.cflox.numberConverter.domain.dto.NumberConverterRequestDto;
import com.cflox.numberConverter.service.INumberConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * @author tatmaca
 */

@RequiredArgsConstructor
@Service
public class NumberConverterServiceImpl implements INumberConverterService {

    private final ApplicationContext applicationContext;
    private final IRomanConverter romanConverter;

    @Override
    public ApiResponse convertToRoman(NumberConverterRequestDto requestDto) {
        IIntegerConverter numberConverter = (IIntegerConverter) applicationContext.getBean(requestDto.getNumberType().getBeanName());
        int number = numberConverter.convert(requestDto.getNumber());

        String romanValue = romanConverter.convert(number);

        var apiResponse = new ApiResponse();
        apiResponse.setNumber(romanValue);
        apiResponse.setHttpStatus(HttpStatus.OK);

        return apiResponse;
    }
}
