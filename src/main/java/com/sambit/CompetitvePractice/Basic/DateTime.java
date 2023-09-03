package com.sambit.CompetitvePractice.Basic;

import java.util.*;

class DateTime {

    static void convertTime(String time)
    {
        String format;

        String[] arr = time.split(":");

        int hh = Integer.parseInt(arr[0]);

        if (hh > 12) {
            hh = hh - 12;
            format = "PM";
        }
        else if (hh == 0) {
            hh = 12;
            format = "AM";
        }
        else if (hh == 12)
            format = "PM";
        else
            format = "AM";

        String hour = String.format("%02d", hh);
        String minute = arr[1];
        String second = arr[2];

        System.out.print("Time in 12-hour format is : ");
        System.out.print(hour + ":" + minute + ":" + second
                + " " + format);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println(
                "Enter the time in 24-hour format : ");

        String time = sc.nextLine();

        convertTime(time);
    }
}
