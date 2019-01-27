package com.exam.service;

import com.exam.util.DateCalculatorException;
import org.junit.Test;

public class InputValidatorTest extends InputValidator {


    @Test(expected = DateCalculatorException.class)
    public void testWrongDate() throws Exception {
        parse("asd/12/12");
    }

    @Test(expected = DateCalculatorException.class)
    public void testInvalidDelimiter() throws Exception {
        parse("2012-12-12");
    }

    @Test(expected = DateCalculatorException.class)
    public void testMoreOverflowParameter() throws Exception {
        parse("2012-12-12-12");
    }


    @Test(expected = DateCalculatorException.class)
    public void testLessParamater() throws Exception {
        parse("2012//12");
    }

    @Test(expected = DateCalculatorException.class)
    public void testEmptyParameter() throws Exception {
        parse("");
    }

    @Test(expected = DateCalculatorException.class)
    public void testNullParameter() throws Exception {
        parse(null);
    }

    @Test(expected = DateCalculatorException.class)
    public void testNoDelimiterParameter() throws Exception {
        parse("20120101");
    }

    @Test
    public void testValidParamater() throws Exception {
        parse("01/01/2012");
    }

    @Test(expected = DateCalculatorException.class)
    public void testInvalidYearMax() throws Exception {
        parse("12/12/3000");
    }

    @Test(expected = DateCalculatorException.class)
    public void testInvalidYearMin() throws Exception {
        parse("12/12/1900");
    }

    @Test(expected = DateCalculatorException.class)
    public void testInvalidMonthMax() throws Exception {
        parse("12/13/2018");
    }

    @Test(expected = DateCalculatorException.class)
    public void testInvalidMonthMin() throws Exception {
        parse("12/00/2018");
    }

    @Test
    public void testValidMonths() throws Exception {
        parse("12/01/2018");
        parse("1/12/2018");
        parse("12/07/2018");
        parse("7/12/2018");
    }

    @Test
    public void testValidFebruaryLeapYear() throws Exception {
        parse("29/12/2000");
    }

    @Test(expected = DateCalculatorException.class)
    public void testInvalidFebruaryLeapYear() throws Exception {
        parse("29/02/1999");
    }
}
