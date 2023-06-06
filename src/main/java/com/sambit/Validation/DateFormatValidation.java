package com.sambit.Validation;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 06/06/2023 - 3:36 PM
 */
public class DateFormatValidation {

    public static boolean dateValidation(String date) {
        return date != null && !date.isEmpty() && date.matches("\\d{2}-\\d{2}-\\d{4}");
    }
}
