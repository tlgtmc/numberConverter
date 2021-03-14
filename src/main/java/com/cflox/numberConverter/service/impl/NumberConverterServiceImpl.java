package com.cflox.numberConverter.service.impl;

import com.cflox.numberConverter.converter.IIntegerConverter;
import com.cflox.numberConverter.converter.IRomanConverter;
import com.cflox.numberConverter.domain.ApiResponse;
import com.cflox.numberConverter.domain.dto.NumberConverterRequestDto;
import com.cflox.numberConverter.exception.NumberOutOfRangeException;
import com.cflox.numberConverter.service.INumberConverterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * Service layer of the NumberConverter application.
 * This class implements the INumberConverterService.
 *
 * @author tatmaca
 */

@RequiredArgsConstructor
@Service
public class NumberConverterServiceImpl implements INumberConverterService {

    private final ApplicationContext applicationContext;
    private final IRomanConverter romanConverter;

    /**
     * {@code convertToRoman} method converts given request object value to the roman value.
     * It determines which conversion type will be used with the help of ApplicationContext.
     * Pre-defined bean names used to get beans from ApplicationContext.
     * Bean's convert method is called and integer representation of given value stored in a value.
     * Last step is converting this integer value to the roman representation with RomanConverter bean.
     *
     * @param requestDto : NumberConverterRequestDto with value and type
     * @return : {@code ApiResponse} with converted value, status and statusCode
     */
    @Override
    public ApiResponse convertToRoman(NumberConverterRequestDto requestDto) {
        IIntegerConverter numberConverter = (IIntegerConverter) applicationContext.getBean(requestDto.getNumberType().getBeanName());
        int intValue = numberConverter.convert(requestDto.getNumber());

        return new ApiResponse(romanConverter.convert(intValue), HttpStatus.OK, HttpStatus.OK.value());
    }

}
