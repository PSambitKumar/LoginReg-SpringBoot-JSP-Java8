package com.sambit.Utils;

import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator {
	public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
		if ((birthDate != null) && (currentDate != null)) {
			return Period.between(birthDate, currentDate).getYears();
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		LocalDate birthDate = LocalDate.of(1999, 10, 10);
		LocalDate currentDate = LocalDate.now();
		System.out.println("Age is: " + calculateAge(birthDate, currentDate));
	}

	public static int calculateAge(int birthYear, int currentYear) {
		return currentYear - birthYear;
	}

	public static int calculateAge(int birthYear) {
		return LocalDate.now().getYear() - birthYear;
	}

	public static int calculateAge(String birthYear) {
		return LocalDate.now().getYear() - Integer.parseInt(birthYear);
	}

	public static int calculateAge(String birthYear, String currentYear) {
		return Integer.parseInt(currentYear) - Integer.parseInt(birthYear);
	}

	public static int calculateAge(String birthYear, int currentYear) {
		return currentYear - Integer.parseInt(birthYear);
	}

	public static int calculateAge(int birthYear, String currentYear) {
		return Integer.parseInt(currentYear) - birthYear;
	}

	public static int calculateAge(LocalDate birthDate) {
		return Period.between(birthDate, LocalDate.now()).getYears();
	}

	public static int calculateAge(String birthDate) {
		return Period.between(LocalDate.parse(birthDate), LocalDate.now()).getYears();
	}

	public static int calculateAge(int birthDate) {
		return Period.between(LocalDate.of(birthDate, 1, 1), LocalDate.now()).getYears();
	}

	public static int calculateAge(String birthDate, LocalDate currentDate) {
		return Period.between(LocalDate.parse(birthDate), currentDate).getYears();
	}
}
