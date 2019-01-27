package com.exam.service;

import com.exam.data.DateObject;
import com.exam.util.DateCalculatorException;

import java.util.Arrays;
import java.util.Optional;

import static com.exam.util.Constants.*;

/**
 * Validates user input if it contains correct delimiter, number of values
 * and if the dates provided are within the confines of
 */
public class InputValidator {
    public DateObject parse(String userInput) throws DateCalculatorException {
        int[] validUserInput = validateUserInput(userInput);
        return Optional.of(new DateObject(validUserInput[DAY], validUserInput[MONTH], validUserInput[YEAR]))
                .filter(dateObject -> dateObject.getYear() <= DateObject.MAX_YEAR && dateObject.getYear() >= DateObject.MIN_YEAR)
                .filter(dateObject -> dateObject.getMonth() <= 12 && dateObject.getMonth() >= 1)
                .filter(dateObject -> dateObject.getDay() <= 31 && dateObject.getDay() >= 1)
                .filter(dateObject -> dateObject.getNumberOfDaysThisMonth() >= dateObject.getDay())
                .orElseThrow(() -> new DateCalculatorException(INVALID_DATE_RANGE));
    }

    private int[] validateUserInput(String userInput) throws DateCalculatorException {
        String[] valid = Optional.ofNullable(userInput)
                .filter(s -> s.length() > 0 && s.contains(DELIMITER) && s.split(DELIMITER).length == 3)
                .map(s -> s.split(DELIMITER)).orElseThrow(() -> new DateCalculatorException(INVALID_INPUT));
        try {
            return Arrays.stream(valid).mapToInt(Integer::parseInt).toArray();
        } catch (NumberFormatException nfe) {
            throw new DateCalculatorException(INVALID_INPUT);
        }
    }
}
