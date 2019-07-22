package com.jrojas.sonatype.controller;

import com.jrojas.sonatype.utils.NumberToWordUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/*
 TODO
 */
@RestController
public class NumberToWordController {

    @RequestMapping(value = "/convertToWord/{value}", method = RequestMethod.GET)
    public String convertToWord(@PathVariable String value) {

        // TODO implement validations : value range
        try {
            Number number = NumberFormat.getInstance(Locale.UK).parse(value);
            return NumberToWordUtils.convertNumberToWord(number.intValue());
        } catch (ParseException e) {
            // TODO handle error message
            return "Error";
        }
    }
}
