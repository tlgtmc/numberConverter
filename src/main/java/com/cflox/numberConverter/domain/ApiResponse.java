package com.cflox.numberConverter.domain;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * <h1>ApiResponse</h1>
 *
 * Response object of the application
 * consists the following fields:
 *
 * number,
 * httpStatus
 *
 * @author tatmaca
 */

@Data
public class ApiResponse {

    private String number;
    private HttpStatus httpStatus;

}
