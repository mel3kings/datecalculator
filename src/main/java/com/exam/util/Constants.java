package com.exam.util;

import com.exam.data.DateObject;

public abstract class Constants {
    public static final String DELIMITER = "/";

    public static final int YEAR = 2;
    public static final int MONTH = 1;
    public static final int DAY = 0;

    public static final String INVALID_INPUT = "Input contains values other than the allowed date values/delimiter " +
            "or it contains more than possible number of values";
    public static final String INVALID_DATE_RANGE =
            "Input contains date range, please select from 01/01/" + DateObject.MIN_YEAR +
                    " to 01/01/" + DateObject.MAX_YEAR;
}
