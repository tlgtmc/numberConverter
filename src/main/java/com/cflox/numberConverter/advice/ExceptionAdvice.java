package com.cflox.numberConverter.advice;

import com.cflox.numberConverter.domain.ApiResponse;
import com.cflox.numberConverter.exception.NumberOutOfRangeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author tatmaca
 */

@ControllerAdvice
public class ExceptionAdvice {
    @ResponseBody
    @ExceptionHandler(NumberOutOfRangeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ApiResponse numberOutOfRangeException(NumberOutOfRangeException ex) {
        var apiResponse = new ApiResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
        return apiResponse;
    }

}
