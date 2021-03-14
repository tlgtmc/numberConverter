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
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author tatmaca
 */

@SpringBootTest
public class BinaryInputRomanOutputTest {


    @Autowired
    private INumberConverterService numberConverterService;

    NumberConverterRequestDto requestDto = null;

    @BeforeEach
    @DisplayName("Create Request Dto")
    void createEmployee() {
        requestDto = new NumberConverterRequestDto();
        requestDto.setInputNumberType(InputNumberType.BINARY);
        requestDto.setOutputNumberType(OutputNumberType.ROMAN);
        requestDto.setNumber("1010");
    }

    @Test
    public void whenInputIsValidBinary_thenConvertToRoman() {

        String expectedRomanValue = "X";

        ApiResponse apiResponse = this.numberConverterService.convertToRoman(requestDto);
        Assertions.assertEquals(apiResponse.getHttpStatus(), HttpStatus.OK);

        Assertions.assertEquals(apiResponse.getValue(), expectedRomanValue);
    }

    @Test
    public void whenInputIsNotValidBinary_thenThrowException() {

        String invalidValue = "1020";
        requestDto.setNumber(invalidValue);

        Exception exception = assertThrows(InvalidInputException.class, () -> {
            this.numberConverterService.convertToRoman(requestDto);
        });

        String expectedMessage = String.format("%s is not a valid binary.", invalidValue);
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void whenInputValueIsNotInRange_thenThrowException() {

        String invalidValue = "0";
        requestDto.setNumber(invalidValue);

        Exception exception = assertThrows(NumberOutOfRangeException.class, () -> {
            this.numberConverterService.convertToRoman(requestDto);
        });

        String expectedMessage = String.format("Given number is out of range (1 - 3999): %s", invalidValue);
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(actualMessage, expectedMessage);
    }
}
