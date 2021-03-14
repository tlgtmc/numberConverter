package com.cflox.numberConverter.service.impl;


import com.cflox.numberConverter.converter.input.IInputToIntegerConverter;
import com.cflox.numberConverter.converter.output.IIntegerToOutputConverter;
import com.cflox.numberConverter.domain.ApiResponse;
import com.cflox.numberConverter.domain.dto.NumberConverterRequestDto;
import com.cflox.numberConverter.enums.OutputNumberType;
import com.cflox.numberConverter.service.INumberConverterService;
import lombok.RequiredArgsConstructor;
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

    /**
     * {@code convertToRoman} method converts given request object value to the requested output type.
     * It has two steps, first convert input type to the integer.
     * Then, converts integer value to the requested output type.
     *
     * @param requestDto : NumberConverterRequestDto with value, inputNumberType and outputNumberType
     * @return : {@code ApiResponse} with converted value, status and statusCode
     */
    @Override
    public ApiResponse convertToRoman(NumberConverterRequestDto requestDto) {

        int integerValue = convertToInteger(requestDto);

        String outputValue = convertToOutputType(requestDto.getOutputNumberType(), integerValue);

        return new ApiResponse(outputValue, HttpStatus.OK, HttpStatus.OK.value());
    }

    /**
     * {@code convertToInteger} method determines the input type and get the specific bean from the ApplicationContext.
     * Then, converts input value to the integer representation
     *
     * @param requestDto : NumberConverterRequestDto with value, inputNumberType and outputNumberType
     * @return integer representation of given value
     */
    private int convertToInteger(NumberConverterRequestDto requestDto) {
        IInputToIntegerConverter inputConverterBean = (IInputToIntegerConverter) applicationContext.getBean(requestDto.getInputNumberType().getBeanName());
        return inputConverterBean.convert(requestDto.getNumber());
    }

    /**
     * {@code convertToOutputType} method determines the output type and get the specific bean from the ApplicationContext.
     * Then, converts integer value to the output type representation
     *
     * @param outputNumberType : Requested output type
     * @param integerValue : Value to be converted
     * @return : Final output value
     */
    private String convertToOutputType(OutputNumberType outputNumberType, int integerValue) {
        IIntegerToOutputConverter outputConverterBean = (IIntegerToOutputConverter) applicationContext.getBean(outputNumberType.getBeanName());
        return outputConverterBean.convert(integerValue);
    }
}
