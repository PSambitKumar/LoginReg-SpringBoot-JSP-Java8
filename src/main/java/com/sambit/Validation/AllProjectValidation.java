package com.sambit.Validation;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 16/11/2022 - 4:26 PM
 */
public class AllProjectValidation {

	public boolean isPasswordValid(String password) {
//		^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$
// └─────┬────┘└───┬──┘└─────┬─────┘└─────┬─────┘ └───┬───┘
//       │         │         │            │           no _ or . at the end
//       │         │         │            │
//       │         │         │            allowed characters
//       │         │         │
//       │         │         no __ or _. or ._ or .. inside
//       │         │
//       │         no _ or . at the beginning
//       │
//		username is 8-20 characters long

		return password.matches("^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$");
	}

	public boolean isPhoneNumberValid(String phoneNumber) {
		return phoneNumber.matches("^[0-9]{10}$");
	}

	public boolean isEmailValid(String email) {
		return email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
	}

	public boolean isNameValid(String name) {
		return name.matches("^[a-zA-Z\\s]*$");
	}

	public boolean isAddressValid(String address) {
		return address.matches("^[a-zA-Z0-9\\s]*$");
	}

	public boolean isPincodeValid(String pincode) {
		return pincode.matches("^[0-9]{6}$");
	}

	public boolean isCityValid(String city) {
		return city.matches("^[a-zA-Z\\s]*$");
	}

	public boolean isStateValid(String state) {
		return state.matches("^[a-zA-Z\\s]*$");
	}

	public boolean isCountryValid(String country) {
		return country.matches("^[a-zA-Z\\s]*$");
	}

	public boolean isNumberValid(String number) {
		return number.matches("^[0-9]*$");
	}

	public boolean isDateValid(String date) {
		return date.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}$");
	}

	public boolean isAlphabetValid(String alphabet) {
		return alphabet.matches("^[a-zA-Z]*$");
	}
}
