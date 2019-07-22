package com.jrojas.sonatype.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberToWordUtilsTest {

    @Test
    void convertFromZeroToNineteen() {
        assertEquals("Zero", NumberToWordUtils.convertNumberToWord(0));
        assertEquals("One", NumberToWordUtils.convertNumberToWord(1));
        assertEquals("Thirteen", NumberToWordUtils.convertNumberToWord(13));
        assertEquals("Negative thirteen", NumberToWordUtils.convertNumberToWord(-13));
    }

    @Test
    void convertFromTwentyToNinety() {
        assertEquals("Twenty", NumberToWordUtils.convertNumberToWord(20));
        assertEquals("Twenty two", NumberToWordUtils.convertNumberToWord(22));
        assertEquals("Negative thirty two", NumberToWordUtils.convertNumberToWord(-32));
        assertEquals("Ninety nine", NumberToWordUtils.convertNumberToWord(99));
    }
}