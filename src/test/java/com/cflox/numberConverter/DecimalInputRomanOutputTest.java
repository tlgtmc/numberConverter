package com.cflox.numberConverter;

import com.cflox.numberConverter.domain.ApiResponse;
import com.cflox.numberConverter.domain.dto.NumberConverterRequestDto;
import com.cflox.numberConverter.enums.InputNumberType;
import com.cflox.numberConverter.enums.OutputNumberType;
import com.cflox.numberConverter.exception.InvalidInputException;
import com.cflox.numberConverter.exception.NumberOutOfRangeException;
import com.cflox.numberConverter.service.INumberConverterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author tatmaca
 */

@SpringBootTest
public class DecimalInputRomanOutputTest {


    @Autowired
    private INumberConverterService numberConverterService;

    NumberConverterRequestDto requestDto = null;

    @BeforeEach
    @DisplayName("Create Request Dto")
    void createEmployee() {
        requestDto = new NumberConverterRequestDto();
        requestDto.setInputNumberType(InputNumberType.DECIMAL);
        requestDto.setOutputNumberType(OutputNumberType.ROMAN);
        requestDto.setNumber("10");
    }

    @Test
    public void whenInputIsValidDecimal_thenConvertToRoman() {

        String expectedRomanValue = "X";

        ApiResponse apiResponse = this.numberConverterService.convertToRoman(requestDto);
        Assertions.assertEquals(apiResponse.getHttpStatus(), HttpStatus.OK);

        Assertions.assertEquals(apiResponse.getValue(), expectedRomanValue);
    }

    @Test
    public void whenInputIsNotValidDecimal_thenThrowException() {

        String invalidValue = "10.10";
        requestDto.setNumber(invalidValue);

        Exception exception = assertThrows(InvalidInputException.class, () -> {
            this.numberConverterService.convertToRoman(requestDto);
        });

        String expectedMessage = String.format("%s is not a valid decimal, please do not use fraction.", invalidValue);
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void whenInputValueIsNotInRange_thenThrowException() {

        String invalidValue = "4000";
        requestDto.setNumber(invalidValue);

        Exception exception = assertThrows(NumberOutOfRangeException.class, () -> {
            this.numberConverterService.convertToRoman(requestDto);
        });

        String expectedMessage = String.format("Given number is out of range (1 - 3999): %s", invalidValue);
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(actualMessage, expectedMessage);
    }
}