package com.jrojas.sonatype.utils;

import org.springframework.util.StringUtils;

import static org.apache.logging.log4j.util.Strings.EMPTY;

/**
 * TODO
 */
public final class NumberToWordUtils {

    private static final String NEGATIVE = "Negative";
    private static final String SPACE = " ";
    private static final String[] ZERO_TO_NINETEEN;
    private static final String[] TWENTY_TO_NINETY;

    static {
        ZERO_TO_NINETEEN = new String[]{
                "zero",
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

    public static String convertNumberToWord(int number) {

        if (number == 0) {
            return StringUtils.capitalize(ZERO_TO_NINETEEN[0]);
        }

        boolean isNegative = number < 0;

        String conversion = isNegative ? NEGATIVE + SPACE : EMPTY;

        int unsignedNumber = Math.abs(number);

        if (unsignedNumber < 20) {
            conversion += handleAppend(conversion, ZERO_TO_NINETEEN[unsignedNumber]);
        }

        if (unsignedNumber > 19 && unsignedNumber < 100) {
            conversion = handleTens(conversion, unsignedNumber);
        }

        // TODO


        return StringUtils.capitalize(conversion);
    }

    private static String handleTens(String conversion, int unsignedNumber) {

        final int division = unsignedNumber / 10;

        final int modulo = unsignedNumber % 10;

        if(modulo == 0) {
            conversion += handleAppend(conversion, TWENTY_TO_NINETY[division]);
        } else {
            conversion += handleAppend(conversion, TWENTY_TO_NINETY[division], ZERO_TO_NINETEEN[modulo]);
        }
        return conversion;
    }

    private static String handleAppend(String conversion, String... values) {
        return conversion.join(SPACE, values);
    }
}
