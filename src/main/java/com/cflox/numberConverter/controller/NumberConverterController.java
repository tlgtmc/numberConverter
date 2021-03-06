package com.cflox.numberConverter.controller;

import com.cflox.numberConverter.domain.ApiResponse;
import com.cflox.numberConverter.domain.dto.NumberConverterRequestDto;
import com.cflox.numberConverter.service.INumberConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * NumberConverterController is a RestController class with mapping {@code "/convert/to"}
 *
 * <p>This class includes only a GET method with path {@code "/roman"}.
 * This path converts incoming request to roman representation</p>
 *
 * @author tatmaca
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/convert/to")
public class NumberConverterController {

    private final INumberConverterService numberConverterService;

    /**
     * {@code convertToRoman} method converts requested number to Roman representation
     *
     * @param numberConverterRequestDto : Dto with value, inputNumberType and outputNumberType
     * @return ApiResponse : Custom model with following fields value, httpStatus and httpStatusCode
     *
     */
    @GetMapping("/roman")
    public ApiResponse convertToRoman(@Valid NumberConverterRequestDto numberConverterRequestDto) {
        return numberConverterService.convertToRoman(numberConverterRequestDto);
    }
}
