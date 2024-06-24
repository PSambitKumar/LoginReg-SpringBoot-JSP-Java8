package com.sambit.CompetitvePractice.Java8.Practice;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 12-Jun-2024 : 6:07 PM
 */

public class DateTimeExample {

    public static void main(String[] args) {
        DateAndTimeExmple();
        DateAndTimeManipulationExample();
        DateTimeFormatter();
        DurationPersiod();
    }

    public static void DateAndTimeExmple() {
        // Current date
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date: " + currentDate);

        // Current time
        LocalTime currentTime = LocalTime.now();
        System.out.println("Current Time: " + currentTime);

        // Current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current DateTime: " + currentDateTime);

        // Current date and time with time zone
        ZonedDateTime currentZonedDateTime = ZonedDateTime.now();
        System.out.println("Current ZonedDateTime: " + currentZonedDateTime);

        // Specific date
        LocalDate specificDate = LocalDate.of(2023, 6, 12);
        System.out.println("Specific Date: " + specificDate);

        // Specific time
        LocalTime specificTime = LocalTime.of(10, 30);
        System.out.println("Specific Time: " + specificTime);

        // Specific date and time
        LocalDateTime specificDateTime = LocalDateTime.of(2023, 6, 12, 10, 30);
        System.out.println("Specific DateTime: " + specificDateTime);

        // Specific date and time with time zone
        ZonedDateTime specificZonedDateTime = ZonedDateTime.of(2023, 6, 12, 10, 30, 0, 0, ZoneId.of("America/New_York"));
        System.out.println("Specific ZonedDateTime: " + specificZonedDateTime);
    }

    public static void DateAndTimeManipulationExample() {
        LocalDate date = LocalDate.now();
        LocalDateTime dateTime = LocalDateTime.now();

        // Define a formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Format date and datetime
        String formattedDate = date.format(DateTimeFormatter.ISO_DATE);
        String formattedDateTime = dateTime.format(formatter);
        System.out.println("Formatted Date: " + formattedDate);
        System.out.println("Formatted DateTime: " + formattedDateTime);

        // Parse date and datetime
        String dateString = "2023-06-12";
        String dateTimeString = "2023-06-12 10:30:00";

        try {
            LocalDate parsedDate = LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE);
            LocalDateTime parsedDateTime = LocalDateTime.parse(dateTimeString, formatter);
            System.out.println("Parsed Date: " + parsedDate);
            System.out.println("Parsed DateTime: " + parsedDateTime);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
    }

    public static void DateTimeFormatter() {
        LocalDate date = LocalDate.now();
        LocalDateTime dateTime = LocalDateTime.now();

        // Define a formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Format date and datetime
        String formattedDate = date.format(DateTimeFormatter.ISO_DATE);
        String formattedDateTime = dateTime.format(formatter);
        System.out.println("Formatted Date: " + formattedDate);
        System.out.println("Formatted DateTime: " + formattedDateTime);

        // Parse date and datetime
        String dateString = "2023-06-12";
        String dateTimeString = "2023-06-12 10:30:00";

        try {
            LocalDate parsedDate = LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE);
            LocalDateTime parsedDateTime = LocalDateTime.parse(dateTimeString, formatter);
            System.out.println("Parsed Date: " + parsedDate);
            System.out.println("Parsed DateTime: " + parsedDateTime);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
    }

    public static void DurationPersiod() {
        LocalTime time1 = LocalTime.of(10, 0);
        LocalTime time2 = LocalTime.of(12, 30);
        Duration duration = Duration.between(time1, time2);
        System.out.println("Duration: " + duration);

        LocalDate date1 = LocalDate.of(2023, 1, 1);
        LocalDate date2 = LocalDate.of(2023, 6, 12);
        Period period = Period.between(date1, date2);
        System.out.println("Period: " + period.getYears() + " years, " + period.getMonths() + " months, " + period.getDays() + " days");

        LocalDateTime dateTime1 = LocalDateTime.of(2023, 1, 1, 10, 0);
        LocalDateTime dateTime2 = LocalDateTime.of(2023, 6, 12, 12, 30);
        Duration duration2 = Duration.between(dateTime1, dateTime2);
        System.out.println("Duration: " + duration2.toHours() + " hours");
    }
}
