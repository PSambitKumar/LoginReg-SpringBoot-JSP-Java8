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
}
