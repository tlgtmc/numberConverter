package com.cflox.numberConverter.controller;

import com.cflox.numberConverter.enums.InputNumberType;
import com.cflox.numberConverter.enums.OutputNumberType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ConfigController is a RestController class with mapping {@code "/config"}
 *
 * This class provides endpoints for UI to dynamically get the 'inputTypes' and 'outputTypes'.
 *
 * @author tatmaca
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/config")
public class ConfigController {

    /**
     * This method returns the defined input types.
     *
     * @return
     */
    @GetMapping("/inputTypes")
    public List<String> getInputTypes() {
        return Stream.of(InputNumberType.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }


    /**
     * This method returns the defined output types.
     *
     * @return
     */
    @GetMapping("/outputTypes")
    public List<String> getOutputTypes() {
        return Stream.of(OutputNumberType.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }
}
