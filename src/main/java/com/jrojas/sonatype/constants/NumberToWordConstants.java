package com.jrojas.sonatype.constants;

/**
 * Class to define the constants values
 */
public final class NumberToWordConstants {

    private NumberToWordConstants() {
    }

    public static final String EMPTY_VALUE = "Empty values are not allowed";
    public static final String RANGE_ERROR = "No floating point numbers, only integers : Value must be between -2 147 483 648 and 2 147 483 647";
    public static final String SPACE = " ";
    public static final String NEGATIVE_PREFIX = "Negative ";
    public static final String AND = "and ";

    public static final String BILLION = " billion ";
    public static final String MILLION = " million ";
    public static final String THOUSAND = " thousand ";
    public static final String HUNDRED = " hundred ";

    public static final int ONE_BILLION =1_000_000_000;
    public static final int ONE_MILLION =1_000_000;
    public static final int ONE_THOUSAND =1_000;
    public static final int ONE_HUNDRED =100;
}
