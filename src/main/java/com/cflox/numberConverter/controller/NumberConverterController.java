package com.cflox.numberConverter.controller;

import com.cflox.numberConverter.domain.ApiResponse;
import com.cflox.numberConverter.domain.dto.NumberConverterRequestDto;
import com.cflox.numberConverter.service.INumberConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tatmaca
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/convert/to")
public class NumberConverterController {

    private final INumberConverterService numberConverterService;

    @GetMapping("/roman")
    public ApiResponse convertToRoman(@RequestBody NumberConverterRequestDto numberConverterRequestDto) {
        return numberConverterService.convertToRoman(numberConverterRequestDto);
    }
}
