package com.exam.data;

import java.util.Comparator;
import java.util.Optional;

public class DateObject implements Comparable<DateObject> {
    public static final int JAN = 1, FEB = 2, MAR = 3, APR = 4, MAY = 5, JUN = 6,
            JUL = 7, AUG = 8, SEP = 9, OCT = 10, NOV = 11, DEC = 12;

    public static final int MAX_YEAR = 2999, MIN_YEAR = 1901;
    public static final int MAX_MONTH = 12, MIN_MONTH = 1;
    public static final int NORMAL_YEARS_DAYS = 365;
    private int day;
    private int month;
    private int year;
    private int leapYears;

    public DateObject(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.leapYears = 0;
    }

    public DateObject() {
    }

    public void addDay() {
        if (this.getNumberOfDaysThisMonth() == this.getDay()) {
            this.setDay(1);
            addMonth();
        } else {
            this.setDay(this.getDay() + 1);
        }
    }

    public void addMonth() {
        if (this.getMonth() == DateObject.MAX_MONTH) {
            this.setMonth(1);
            addYear();
        } else {
            this.setMonth(this.getMonth() + 1);
        }
    }

    public void addYear() {
        this.setYear(this.getYear() + 1);
        if (this.isLeapYear()) {
            this.setLeapYears(this.getLeapYears() + 1);
        }
    }

    public int getNumberOfDaysThisMonth() {
        if (this.getMonth() == FEB) {
            if (isLeapYear()) {
                return 29;
            } else {
                return 28;
            }
        } else if (this.getMonth() == APR || this.getMonth() == JUN
                || this.getMonth() == SEP || this.getMonth() == NOV) {
            return 30;
        } else {
            return 31;
        }
    }

    public boolean isLeapYear() {
        return (this.getYear() % 100 == 0) ? (this.getYear() % 400 == 0) : (this.getYear() % 4 == 0);
    }

    @Override
    public boolean equals(Object o) {
        return Optional.ofNullable(o)
                .filter(obj -> obj instanceof DateObject)
                .map(obj -> (DateObject) o)
                .map(this::compareTo)
                .filter(i -> i == 0).isPresent();
    }

    @Override
    public int compareTo(DateObject other) {
        return Comparator.comparing(DateObject::getYear)
                .thenComparing(DateObject::getMonth)
                .thenComparing(DateObject::getDay).compare(this, other);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setLeapYears(int leapYears) {
        this.leapYears = leapYears;
    }

    public int getLeapYears() {
        return leapYears;
    }
}
