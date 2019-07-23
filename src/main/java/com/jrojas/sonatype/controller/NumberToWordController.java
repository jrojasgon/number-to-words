package com.jrojas.sonatype.controller;

import com.jrojas.sonatype.utils.NumberToWordUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.jrojas.sonatype.constants.NumberToWordConstants.*;


/**
 * The controller to expose a method that convert an {@code int} value to its UK English words
 */
@RestController
public class NumberToWordController {

    /**
     * @param value the value to convert
     * @return {code @ResultResponse} with the words representing the number or the error message and a flag to indicate if there is an error
     */
    @RequestMapping(value = "/convertToWord/{value}", method = RequestMethod.GET)
    public ResultResponse convertToWord(@PathVariable String value) {

        if (StringUtils.isEmpty(value)) return new ResultResponse(EMPTY_VALUE, true);

        // only signed 32 bit integer are allowed
        try {
            return new ResultResponse(NumberToWordUtils.convertNumberToWords(Integer.parseInt(value)));
        } catch (NumberFormatException e) {
            return new ResultResponse(RANGE_ERROR, true);
        }

    }
}
