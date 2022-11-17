package com.sambit.Validation;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
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
}
