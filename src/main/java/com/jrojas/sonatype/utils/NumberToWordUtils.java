package com.jrojas.sonatype.utils;

import com.jrojas.sonatype.constants.NumberToWordConstants;
import org.springframework.util.StringUtils;

import static com.jrojas.sonatype.constants.NumberToWordConstants.*;

/**
 * Utility class to handle the conversion from an {@code int} number to words in UK english
 * <p>
 *     The values are allowed between -2,147,483,648 and 2,147,483,647
 * </p>
 */
public final class NumberToWordUtils {

    private static final String[] ZERO_TO_NINETEEN;
    private static final String[] TWENTY_TO_NINETY;

    static {

        ZERO_TO_NINETEEN = new String[]{
                "Zero",
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine",
                "ten",
                "eleven",
                "twelve",
                "thirteen",
                "fourteen",
                "fifteen",
                "sixteen",
                "seventeen",
                "eighteen",
                "nineteen"
        };

        TWENTY_TO_NINETY = new String[]{"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    }

    private NumberToWordUtils() {
    }

    /**
     * Converts an {@code int} value to UK English word
     *
     * @param number the number to convert into words
     * @return the words representing the number
     */
    public static String convertNumberToWords(final int number) {

        if (number == 0) return ZERO_TO_NINETEEN[0];

        if (number < 0) {
            // special case for Integer.MIN_VALUE which cannot be contained as positive number
            if (Integer.MIN_VALUE == number) {
                final String numberToWords = handleConversion(Math.abs(Integer.MAX_VALUE)).trim();
                return NEGATIVE_PREFIX + numberToWords.replaceAll(ZERO_TO_NINETEEN[7]+ "$", ZERO_TO_NINETEEN[8]);
            }
            return NEGATIVE_PREFIX + handleConversion(Math.abs(number)).trim();
        }

        return StringUtils.capitalize(handleConversion(number).trim());
    }


    /**
     * Converts an {@code int} value to UK English word
     * This is a recursive method to handle the conversion of an {@code int} between -2,147,483,648 and 2,147,483,648
     *
     * @param numberToConvert the number to convert into words
     * @return the words representing the number
     */
    private static String handleConversion(final int numberToConvert) {

        String words = NumberToWordConstants.EMPTY;
        int number = numberToConvert;

        // start by billion
        if (number / ONE_BILLION > 0) {
            words += handleConversion(number / ONE_BILLION) + BILLION;
            number %= ONE_BILLION;
        }

        // continue with millions
        if (number / ONE_MILLION > 0) {
            words += handleConversion(number / ONE_MILLION) + MILLION;
            number %= ONE_MILLION;
        }

        // continue with thousands
        if (number / ONE_THOUSAND > 0) {
            words += handleConversion(number / ONE_THOUSAND) + THOUSAND;
            number %= ONE_THOUSAND;
        }

        // continue with hundreds
        if (number / ONE_HUNDRED > 0) {
            words += handleConversion(number / ONE_HUNDRED) + HUNDRED;
            number %= ONE_HUNDRED;
        }

        // finally handle the tens and small than tens numbers
        words = handleConversionOneToNinety(number, words);

        return words;
    }

    /**
     * Converts an {@code int} value from one to ninety to UK English word
     * @param number the number to convert
     * @param words the words to append to the new converted value
     * @return the words representing the number
     */
    private static String handleConversionOneToNinety(final int number, final String words) {
        String conversion = words;
        if (number > 0) {
            if (!conversion.isEmpty()) {
                conversion += AND;
            }
            if (number < 20) {
                conversion += ZERO_TO_NINETEEN[number];
            } else {
                conversion += TWENTY_TO_NINETY[number / 10];
                final int modulo = number % 10;
                if (modulo > 0) {
                    conversion += SEPARATOR + ZERO_TO_NINETEEN[modulo];
                }
            }
        }
        return conversion;
    }
}
