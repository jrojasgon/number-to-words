package com.jrojas.sonatype.utils;

import org.junit.jupiter.api.Test;

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
        assertEquals("Zero", NumberToWordUtils.convertNumberToWords(0));
        assertEquals("One", NumberToWordUtils.convertNumberToWords(1));
        assertEquals("Thirteen", NumberToWordUtils.convertNumberToWords(13));
        assertEquals("Negative thirteen", NumberToWordUtils.convertNumberToWords(-13));
    }

    /**
     * Test the conversion for values from twenty to ninety
     */
    @Test
    void convertFromTwentyToNinety() {
        assertEquals("Twenty", NumberToWordUtils.convertNumberToWords(20));
        assertEquals("Twenty-two", NumberToWordUtils.convertNumberToWords(22));
        assertEquals("Negative thirty-two", NumberToWordUtils.convertNumberToWords(-32));
        assertEquals("Ninety-nine", NumberToWordUtils.convertNumberToWords(99));
    }

    /**
     * Test the conversion for hundred values
     */
    @Test
    void convertHundreds() {
        assertEquals("Two hundred", NumberToWordUtils.convertNumberToWords(200));
        assertEquals("Two hundred and twenty-two", NumberToWordUtils.convertNumberToWords(222));
        assertEquals("Negative three hundred and twenty-seven", NumberToWordUtils.convertNumberToWords(-327));
        assertEquals("Nine hundred and ninety-nine", NumberToWordUtils.convertNumberToWords(999));
    }

    /**
     * Test the conversion for thousand values
     */
    @Test
    void convertThousands() {
        assertEquals("Two thousand", NumberToWordUtils.convertNumberToWords(2000));
        assertEquals("Two thousand two hundred and twenty-two", NumberToWordUtils.convertNumberToWords(2222));
        assertEquals("Negative three hundred and twenty-seven thousand", NumberToWordUtils.convertNumberToWords(-327000));
        assertEquals("Nine hundred and ninety-nine thousand six hundred and fifty-four", NumberToWordUtils.convertNumberToWords(999654));
    }

    /**
     * Test the conversion for million values
     */
    @Test
    void convertMillions() {
        assertEquals("Two million", NumberToWordUtils.convertNumberToWords(2000000));
        assertEquals("Two million two hundred and twenty-two thousand eight hundred and ninety", NumberToWordUtils.convertNumberToWords(2222890));
        assertEquals("Negative fifteen million nine hundred and eighty thousand three hundred and forty-five", NumberToWordUtils.convertNumberToWords(-15980345));
        assertEquals("Two hundred and thirty-four million nine hundred and eighty-seven thousand six hundred and fifty-four", NumberToWordUtils.convertNumberToWords(234987654));
    }

    /**
     * Test the conversion for billion values
     */
    @Test
    void convertBillions() {
        assertEquals("Two billion eleven million nine hundred and eighty-seven thousand six hundred and fifty-four", NumberToWordUtils.convertNumberToWords(2011987654));
        assertEquals("One billion two hundred and eleven million nine hundred and eighty-seven thousand six hundred and fifty-four",
                NumberToWordUtils.convertNumberToWords(1211987654));
        assertEquals("Negative one billion nine hundred and eleven million nine hundred and eighty-seven thousand six hundred and fifty-four",
                NumberToWordUtils.convertNumberToWords(-1911987654));
    }

    /**
     * Test the conversion for {@code Integer.MAX_VALUE} and {@code Integer.MIN_VALUE} values
     */
    @Test
    void convertMinAndMax() {
        assertEquals("Two billion one hundred and forty-seven million four hundred and eighty-three thousand six hundred and forty-seven",
                NumberToWordUtils.convertNumberToWords(Integer.MAX_VALUE));
        assertEquals("Negative two billion one hundred and forty-seven million four hundred and eighty-three thousand six hundred and forty-eight",
                NumberToWordUtils.convertNumberToWords(Integer.MIN_VALUE));
    }

}