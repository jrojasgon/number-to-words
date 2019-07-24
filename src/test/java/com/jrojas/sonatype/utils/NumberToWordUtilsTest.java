package com.jrojas.sonatype.utils;

import org.junit.jupiter.api.Test;

import static com.jrojas.sonatype.utils.NumberToWordUtils.convertNumberToWords;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class to test the number to word conversion
 */
class NumberToWordUtilsTest {

    /**
     * Test the conversion for values from zero to nineteen
     */
    @Test
    void convertFromZeroToNineteen() {
        assertEquals("Zero", convertNumberToWords(0));
        assertEquals("One", convertNumberToWords(1));
        assertEquals("Thirteen", convertNumberToWords(13));
        assertEquals("Negative thirteen", convertNumberToWords(-13));
    }

    /**
     * Test the conversion for values from twenty to ninety
     */
    @Test
    void convertFromTwentyToNinety() {
        assertEquals("Twenty", convertNumberToWords(20));
        assertEquals("Twenty two", convertNumberToWords(22));
        assertEquals("Negative thirty two", convertNumberToWords(-32));
        assertEquals("Ninety nine", convertNumberToWords(99));
    }

    /**
     * Test the conversion for hundred values
     */
    @Test
    void convertHundreds() {
        assertEquals("Two hundred", convertNumberToWords(200));
        assertEquals("Two hundred and twenty two", convertNumberToWords(222));
        assertEquals("Negative three hundred and twenty seven", convertNumberToWords(-327));
        assertEquals("Nine hundred and ninety nine", convertNumberToWords(999));
    }

    /**
     * Test the conversion for thousand values
     */
    @Test
    void convertThousands() {
        assertEquals("Two thousand", convertNumberToWords(2000));
        assertEquals("Two thousand two hundred and twenty two", convertNumberToWords(2222));
        assertEquals("Negative three hundred and twenty seven thousand", convertNumberToWords(-327000));
        assertEquals("Nine hundred ninety nine thousand six hundred and fifty four", convertNumberToWords(999654));
    }

    /**
     * Test the conversion for million values
     */
    @Test
    void convertMillions() {
        assertEquals("Two million", convertNumberToWords(2000000));
        assertEquals("Two million two hundred twenty two thousand eight hundred and ninety", convertNumberToWords(2222890));
        assertEquals("Negative fifteen million nine hundred eighty thousand three hundred and forty five", convertNumberToWords(-15980345));
        assertEquals("Two hundred thirty four million nine hundred eighty seven thousand six hundred and fifty four", convertNumberToWords(234987654));
        assertEquals("Two hundred thirty four million five hundred sixty seven thousand one hundred and twenty three", convertNumberToWords(234567123));
    }

    /**
     * Test the conversion for billion values
     */
    @Test
    void convertBillions() {
        assertEquals("Two billion eleven million nine hundred eighty seven thousand six hundred and fifty four", convertNumberToWords(2011987654));
        assertEquals("One billion two hundred eleven million nine hundred eighty seven thousand six hundred and fifty four",
                convertNumberToWords(1211987654));
        assertEquals("Negative one billion nine hundred eleven million nine hundred eighty seven thousand six hundred and fifty four",
                convertNumberToWords(-1911987654));
    }

    /**
     * Test the conversion for {@code Integer.MAX_VALUE} and {@code Integer.MIN_VALUE} values
     */
    @Test
    void convertMinAndMax() {
        assertEquals("Two billion one hundred forty seven million four hundred eighty three thousand six hundred and forty seven",
                convertNumberToWords(Integer.MAX_VALUE));
        assertEquals("Negative two billion one hundred forty seven million four hundred eighty three thousand six hundred and forty eight",
                convertNumberToWords(Integer.MIN_VALUE));
    }

}