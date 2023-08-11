package com.sambit.Validation;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 06/06/2023 - 3:36 PM
 */
public class DateFormatValidation {
    public static boolean dateValidation(String date) {
        return date != null && !date.isEmpty() && date.matches("\\d{2}-\\d{2}-\\d{4}");
    }

    public static boolean dateValidation(String date, String format) {
        return date != null && !date.isEmpty() && date.matches(format);
    }

    public static boolean dateValidation(String date, String format, String delimiter) {
        return date != null && !date.isEmpty() && date.matches(format.replace("-", delimiter));
    }

    public static boolean dateValidation(String date, String format, String delimiter, String delimiter2) {
        return date != null && !date.isEmpty() && date.matches(format.replace("-", delimiter).replace("-", delimiter2));
    }

    public static void main(String[] args) {
        System.out.println(dateValidation("06-06-2023"));
    }


}
