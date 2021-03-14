package com.cflox.numberConverter.advice;

import com.cflox.numberConverter.domain.ApiResponse;
import com.cflox.numberConverter.exception.InvalidInputException;
import com.cflox.numberConverter.exception.NumberOutOfRangeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This class is contains advices for Exceptions
 *
 * @author tatmaca
 */

@ControllerAdvice
public class ExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(NumberOutOfRangeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ApiResponse numberOutOfRangeException(NumberOutOfRangeException ex) {
        return new ApiResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
    }

    @ResponseBody
    @ExceptionHandler(InvalidInputException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ApiResponse invalidInputException(InvalidInputException ex) {
        return new ApiResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
    }

    @ResponseBody
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ApiResponse messageNotReadableException(HttpMessageNotReadableException ex) {
        return new ApiResponse(ex.getMostSpecificCause().getLocalizedMessage(), HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
    }
}
