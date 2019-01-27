package com.exam.service;

import com.exam.data.DateObject;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.*;

public class DateCalculatorTest extends DateCalculator {

    private int builtInValidator(DateObject firstDate, DateObject secondDate) {
        final LocalDate date1 = LocalDate.of(firstDate.getYear(), firstDate.getMonth(), firstDate.getDay());
        final LocalDate date2 = LocalDate.of(secondDate.getYear(), secondDate.getMonth(), secondDate.getDay());
        final long days = ChronoUnit.DAYS.between(date1, date2);
        return days > 0 ? (int) days - 1 : (int) days;
    }

    @Test
    public void countNumberOfDaysLeapYear() {
        DateObject leapYear1 = new DateObject(12, 12, 1999);
        DateObject leapYear2 = new DateObject(12, 12, 2000);
        assertEquals(builtInValidator(leapYear1, leapYear2), countNumberOfDays(leapYear1, leapYear2));

        DateObject leapYear3 = new DateObject(12, 12, 2000);
        DateObject leapYear4 = new DateObject(12, 12, 2001);
        assertEquals(builtInValidator(leapYear3, leapYear4), countNumberOfDays(leapYear3, leapYear4));
    }

    @Test
    public void countNumberOfDaysNormalYear() {
        DateObject firstDate = new DateObject(12, 12, 2001);
        DateObject secondDate = new DateObject(12, 12, 2002);
        assertEquals(builtInValidator(firstDate, secondDate), countNumberOfDays(firstDate, secondDate));
    }

    @Test
    public void countNumberOfDaysEquals() {
        DateObject firstDate = new DateObject(12, 12, 2000);
        DateObject secondDate = new DateObject(12, 12, 2000);
        assertEquals(builtInValidator(firstDate, secondDate), countNumberOfDays(firstDate, secondDate));
    }

    @Test
    public void testNumberOfDaysCountWithPartialTest() {
        DateObject firstDate = new DateObject(02, 12, 2000);
        DateObject secondDate = new DateObject(22, 12, 2000);
        assertEquals(builtInValidator(firstDate, secondDate), countNumberOfDays(firstDate, secondDate));

        DateObject compareDate = new DateObject(02, 12, 2000);
        DateObject compareDate2 = new DateObject(03, 12, 2000);
        assertEquals(builtInValidator(compareDate, compareDate2), countNumberOfDays(compareDate, compareDate2));
    }

    @Test
    public void testNumberOfDaysCountNextMonth() {
        DateObject firstDate = new DateObject(31, 01, 2000);
        DateObject secondDate = new DateObject(01, 02, 2000);
        assertEquals(builtInValidator(firstDate, secondDate), countNumberOfDays(firstDate, secondDate));
    }

    @Test
    public void testNumberOfYears() {
        DateObject firstDate = new DateObject(03, 01, 1983);
        DateObject secondDate = new DateObject(03, 01, 1989);
        assertEquals(builtInValidator(firstDate, secondDate), countNumberOfDays(firstDate, secondDate));
    }

    @Test
    public void testSimpleMonth() {
        DateObject firstDate = new DateObject(03, 8, 1989);
        DateObject secondDate = new DateObject(03, 9, 1989);
        assertEquals(builtInValidator(firstDate, secondDate), countNumberOfDays(firstDate, secondDate));

        DateObject first = new DateObject(03, 1, 1989);
        DateObject second = new DateObject(03, 12, 1989);
        assertEquals(builtInValidator(first, second), countNumberOfDays(first, second));
    }

    @Test
    public void testWholeDateWithYears() {
        DateObject firstDate = new DateObject(03, 2, 1987);
        DateObject secondDate = new DateObject(03, 2, 1989);
        assertEquals(builtInValidator(firstDate, secondDate), countNumberOfDays(firstDate, secondDate));

        DateObject first = new DateObject(03, 2, 1989);
        DateObject second = new DateObject(03, 8, 1989);
        assertEquals(builtInValidator(first, second), countNumberOfDays(first, second));
    }

    @Test
    public void testWholeDateWithLeapYears() {
        DateObject firstDate = new DateObject(03, 8, 1983);
        DateObject secondDate = new DateObject(03, 1, 1989);


        assertEquals(builtInValidator(firstDate, secondDate), countNumberOfDays(firstDate, secondDate));
    }

    @Test
    public void testDateComparison() {
        DateObject obj = new DateObject(1, 1, 2012);
        DateObject obj2 = new DateObject(1, 1, 2013);
        assert (obj2.compareTo(obj) > 0);

        DateObject obj3 = new DateObject(1, 1, 2012);
        DateObject obj4 = new DateObject(1, 2, 2012);
        assert (obj3.compareTo(obj4) < 0);


        DateObject obj5 = new DateObject(31, 1, 2012);
        DateObject obj6 = new DateObject(1, 1, 2012);
        assert (obj5.compareTo(obj6) > 0);

        DateObject obj7 = new DateObject(31, 1, 2012);
        DateObject obj8 = new DateObject(31, 1, 2012);
        assert (obj7.compareTo(obj8) == 0);
    }

    @Test
    public void testBusinessProvidedDates() {
        DateObject obj1 = new DateObject(02, 06, 1983);
        DateObject obj2 = new DateObject(22, 06, 1983);
        assertEquals(countNumberOfDays(obj1, obj2), 19);

        DateObject obj3 = new DateObject(04, 07, 1984);
        DateObject obj4 = new DateObject(25, 12, 1984);
        assertEquals(countNumberOfDays(obj3, obj4), 173);

        DateObject obj5 = new DateObject(03, 01, 1989);
        DateObject obj6 = new DateObject(03, 8, 1983);
        assertEquals(countNumberOfDays(obj6, obj5), 1979);
    }

    @Test
    public void testLeapYears() {
        DateObject dto = new DateObject();
        dto.setYear(1992);
        assertTrue(dto.isLeapYear());
        dto.setYear(2000);
        assertTrue(dto.isLeapYear());
        dto.setYear(1988);
        assertTrue(dto.isLeapYear());
        dto.setYear(1600);
        assertTrue(dto.isLeapYear());
        dto.setYear(2016);
        assertTrue(dto.isLeapYear());

        dto.setYear(1900);
        assertFalse(dto.isLeapYear());
        dto.setYear(1700);
        assertFalse(dto.isLeapYear());
        dto.setYear(1987);
        assertFalse(dto.isLeapYear());
        dto.setYear(1989);
        assertFalse(dto.isLeapYear());
    }
}
