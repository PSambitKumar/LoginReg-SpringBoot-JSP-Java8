

package com.sambit.CompetitvePractice.HackerRank.ProjectEuler;

import java.util.Scanner;

/**
    *@Project : Registration
    *@Auther : Sambit Kumar Pradhan
    *@Created On : 21/10/2022 - 10:18 AM
*/
public class CountingSundays {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int y1 = in.nextInt();
			int m1 = in.nextInt();
			int d1 = in.nextInt();
			int y2 = in.nextInt();
			int m2 = in.nextInt();
			int d2 = in.nextInt();
			int count = 0;
			for (int i = y1; i <= y2; i++) {
				for (int j = 1; j <= 12; j++) {
					if (i == y1 && j < m1) {
						continue;
					}
					if (i == y2 && j > m2) {
						continue;
					}
					if (getDay(i, j, 1) == 0) {
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}

	public static int getDay(int year, int month, int day) {
		int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
		int[] daysInMonthLeap = {31,29,31,30,31,30,31,31,30,31,30,31};
		int days = 0;
		for (int i = 1900; i < year; i++) {
			if (isLeapYear(i)) {
				days += 366;
			} else {
				days += 365;
			}
		}
		if (isLeapYear(year)) {
			for (int i = 0; i < month - 1; i++) {
				days += daysInMonthLeap[i];
			}
		} else {
			for (int i = 0; i < month - 1; i++) {
				days += daysInMonth[i];
			}
		}
		days += day;
		return days % 7;
	}

	public static boolean isLeapYear(int year) {
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					return true;
				} else {
					return false;
				}
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

}