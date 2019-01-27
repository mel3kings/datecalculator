package com.exam.service;

import com.exam.data.DateObject;

import static com.exam.util.Constants.*;

/**
 * Does the actual computation of dates
 */
public class DateCalculator {

    public int countNumberOfDays(DateObject from, DateObject to) {
        int numberOfDays = 0;
        DateObject copy = new DateObject(from.getDay(), from.getMonth(), from.getYear());
        while (copy.getDay() != to.getDay()) {
            numberOfDays++;
            copy.addDay();
        }
        while (copy.getMonth() != to.getMonth()) {
            numberOfDays += copy.getNumberOfDaysThisMonth();
            copy.addMonth();
        }
        while (copy.getYear() != to.getYear()) {
            numberOfDays += DateObject.NORMAL_YEARS_DAYS;
            copy.addYear();
        }
        numberOfDays += copy.getLeapYears();
        if (numberOfDays > 0) {
            numberOfDays = numberOfDays - 1;
        }
        return numberOfDays;
    }
}
