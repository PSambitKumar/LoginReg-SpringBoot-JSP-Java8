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
}
