package com.jrojas.sonatype.utils;

import static com.jrojas.sonatype.constants.NumberToWordConstants.*;
import static org.springframework.util.StringUtils.capitalize;

/**
 * Utility class to handle the conversion from an {@code int} number to words in UK english
 * <p>
 * The values are allowed between -2,147,483,648 and 2,147,483,647
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

        StringBuilder wordsBuilder = new StringBuilder();

        if (number < 0) {
            wordsBuilder.append(NEGATIVE_PREFIX);
            // special case for Integer.MIN_VALUE which cannot be contained as positive number
            if (Integer.MIN_VALUE == number) {
                final String numberToWords = handleConversion(Math.abs(Integer.MAX_VALUE)).trim();
                wordsBuilder.append(numberToWords.replaceAll(ZERO_TO_NINETEEN[7] + "$", ZERO_TO_NINETEEN[8]));
            } else {
                wordsBuilder.append(handleConversion(Math.abs(number)).trim());
            }
        } else {
            wordsBuilder.append(handleConversion(number).trim());
        }

        // in case there is a hundred value in the word followed by any other word, then add the word AND between
        // one hundred fifty five becomes one hundred and fifty five
        return capitalize(wordsBuilder.toString().replaceAll(REGEX_HUNDRED_AND, HUNDRED_AND));
    }


    /**
     * Converts an {@code int} value to UK English word
     * This is a recursive method to handle the conversion of an {@code int} between -2,147,483,648 and 2,147,483,648
     *
     * @param numberToConvert the number to convert into words
     * @return the words representing the number
     */
    private static String handleConversion(final int numberToConvert) {

        StringBuilder wordsBuilder = new StringBuilder();
        int number = numberToConvert;

        // the maximum and minimum permitted values are in the billion range :
        // if the number divided by one billion is greater than zero then get the word of the result of the division.
        // calculate the reminder of that division.
        // repeat the same steps dividing by one million, one thousand, and one hundred

        // start by billion
        if (number / ONE_BILLION > 0) {
            handleAppend(wordsBuilder, handleConversion(number / ONE_BILLION), BILLION);
            number %= ONE_BILLION;
        }

        // continue with millions
        if (number / ONE_MILLION > 0) {
            handleAppend(wordsBuilder, handleConversion(number / ONE_MILLION), MILLION);
            number %= ONE_MILLION;
        }

        // continue with thousands
        if (number / ONE_THOUSAND > 0) {
            handleAppend(wordsBuilder, handleConversion(number / ONE_THOUSAND), THOUSAND);
            number %= ONE_THOUSAND;
        }

        // continue with hundreds
        if (number / ONE_HUNDRED > 0) {
            handleAppend(wordsBuilder, handleConversion(number / ONE_HUNDRED), HUNDRED);
            number %= ONE_HUNDRED;
        }

        // finally handle the tens and small than tens numbers
        handleConversionOneToNinety(number, wordsBuilder);

        return wordsBuilder.toString();
    }

    /**
     * Converts an {@code int} value from one to ninety to UK English word
     *
     * @param number       the number to convert
     * @param wordsBuilder the words to append to the new converted value
     */
    private static void handleConversionOneToNinety(final int number, final StringBuilder wordsBuilder) {
        if (number > 0) {

            if (number < 20) {
                wordsBuilder.append(ZERO_TO_NINETEEN[number]);
            } else {
                wordsBuilder.append(TWENTY_TO_NINETY[number / 10]);
                final int modulo = number % 10;
                if (modulo > 0) {
                    wordsBuilder.append(SPACE);
                    wordsBuilder.append(ZERO_TO_NINETEEN[modulo]);
                }
            }
        }
    }


    /**
     * @param wordsBuilder the {@code StringBuilder} to manipulate
     * @param values the values to append to the {@param wordsBuilder}
     */
    private static void handleAppend(StringBuilder wordsBuilder, String... values) {
        for (String value : values) {
            wordsBuilder.append(value);
        }
    }
}


