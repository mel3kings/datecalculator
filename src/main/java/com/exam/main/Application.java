package com.exam.main;

import com.exam.data.DateObject;
import com.exam.service.DateCalculator;
import com.exam.service.InputValidator;
import com.exam.util.DateCalculatorException;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    private static final Scanner scanner = new Scanner(System.in);
    private static InputValidator validator = new InputValidator();
    private static DateCalculator calculator = new DateCalculator();

    public static void main(String[] args) {
        ArrayList<DateObject> list = new ArrayList<>();
        try {
            System.out.println("Enter First Date: (example: 01/01/2012)");
            list.add(validator.parse(scanner.nextLine()));
            System.out.println("Enter Second Date:");
            list.add(validator.parse(scanner.nextLine()));
            list.sort(DateObject::compareTo);
            System.out.println("Result : " + calculator.countNumberOfDays(list.get(0), list.get(1)) + " days");
        } catch (DateCalculatorException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Please try again");
            list.clear();
        }
    }
}
