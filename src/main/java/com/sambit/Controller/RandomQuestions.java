package com.sambit.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 04/09/2022 - 12:24 AM
 */

//Question Location : C:\Users\sambit.pradhan\Downloads\Programs\hibernateinsert\Registration\src\main\resources\static\RandomQuestions\Project question class 9.pdf

@Controller
public class RandomQuestions {

	@GetMapping(value = "/question1")
	public String calculatePercentage() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Mark of First Subject?");
		int mark1 = scanner.nextInt();

		System.out.println("Enter Mark of Second Subject?");
		int mark2 = scanner.nextInt();

		System.out.println("Enter Mark of Third Subject?");
		int mark3 = scanner.nextInt();

		System.out.println("Enter Mark of Fourth Subject?");
		int mark4 = scanner.nextInt();


		int totalMark = mark1 + mark2 + mark3 + mark4;
		System.out.println("Total Mark of all Subject is " + totalMark);

		float percentage = (totalMark * 100) / 400;
		System.out.println("Percentage is " + percentage);

		if (percentage >= 70) {
			System.out.println("Grade A");
		} else if (percentage >= 40 && percentage < 69) {
			System.out.println("Grade B");
		} else if (percentage < 40) {
			System.out.println("Grade C");
		} else {
			System.out.println("Fail");
		}
		return null;
	}

	@GetMapping(value = "/question2")
	public String calculateSimpleInterest(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Principle Amount?");
		int principleAmount = scanner.nextInt();

		System.out.println("Enter Rate of Interest?");
		int rateOfInterest = scanner.nextInt();

		System.out.println("Enter Time Period?");
		int timePeriod = scanner.nextInt();

		int simpleIntrest = (principleAmount * rateOfInterest * timePeriod) / 100;
		System.out.println("Simple Interest is " + simpleIntrest);
		return null;
	}

	@GetMapping(value = "/question3")
	public String calculateAreaAndPerimeterOfCircle(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Radius of Circle?");
		int radius = scanner.nextInt();

		double area = 3.14 * radius * radius;
		System.out.println("Area of Circle is " + area);

		double perimeter = 2 * 3.14 * radius;
		System.out.println("Perimeter of Circle is " + perimeter);
		return null;
	}

	@GetMapping(value = "/question4")
	public String calculateNetSalaryOfAnEmployee(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Basic Salary of Employee?");
		int basicSalary = scanner.nextInt();

		int da = (basicSalary * 30) / 100;
		System.out.println("DA of Employee is " + da);

		int ta = (basicSalary * 15) / 100;
		System.out.println("House Rent Allowance of Employee is " + ta);

		int pf = (basicSalary * 12) / 100;
		System.out.println("Provident Fund of Employee is " + pf);

		int gs = basicSalary + da + ta;
		System.out.println("Gross Salary of Employee is " + gs);

		int netSalary = basicSalary + da + ta - pf;
		System.out.println("Net Salary of Employee is " + netSalary);
		return null;
	}

	@GetMapping(value = "/question5")
	public String calculateSquareRootAndCubeAndUnitDigit(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Number?");
		int number = scanner.nextInt();

		double squreRoot = Math.sqrt(number);
		System.out.println("Square Root of Number is " + squreRoot);

		double cube = Math.pow(number, 3);
		System.out.println("Cube of Number is " + cube);

		int unitDigit = number % 10;
		System.out.println("Unit Digit of Number is " + unitDigit);
		return null;
	}

	@GetMapping(value = "/question6")
	public String calculatePlaceValue(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter First Number?");
		int N = scanner.nextInt();

		System.out.println("Enter Second Number?");
		int M = scanner.nextInt();

		int total = 1, value = 0, rem = 0;
		while (true) {
			rem = N % 10;
			N = N / 10;

			if (rem == M) {
				value = total * rem;
				break;
			}
			total = total * 10;
		}
		System.out.println("Place Value of Number is " + value);
		return null;
	}

	@GetMapping(value = "/question7")
	public String printAgeCategory(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Age?");
		int age = scanner.nextInt();

		if (age >= 1 && age <= 12) {
			System.out.println("Child");
		} else if (age >= 13 && age <= 17) {
			System.out.println("Teen");
		} else if (age >= 17) {
			System.out.println("Adult");
		} else {
			System.out.println("Invalid Age");
		}
		return null;
	}

	@GetMapping(value = "/question8")
	public String displayPersonDetails(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Name?");
		String name = scanner.nextLine();

		System.out.println("Enter Designation?");
		String deg = scanner.nextLine();

		System.out.println("Enter Salary?");
		int salary = scanner.nextInt();

		System.out.println("Enter Gender?");
		char gender = scanner.next().charAt(0);

		System.out.println("Year of Service?");
		int yos = scanner.nextInt();

		System.out.println("Name of the Employee is " + name);
		System.out.println("Designation of the Employee is " + deg);
		System.out.println("Salary of the Employee is " + salary);
		if (gender == 'm' || gender == 'M'){
			System.out.println("Gender of the Employee is Male.");
		} else if (gender == 'f' || gender == 'F') {
			System.out.println("Gender of the Employee is Female");
		}
		System.out.println("Year of Service of the Employee is " + yos);

		return null;
	}

//	WAP to initialize three variables and display the highest and the lowest value with proper message.

	@GetMapping(value = "question9")
	public String calculateHighestAndLowest(){
		System.out.println("Enter First Number?");
		Scanner scanner = new Scanner(System.in);
		int firstNumber = scanner.nextInt();

		System.out.println("Enter Second Number?");
		int secondNumber = scanner.nextInt();

		System.out.println("Enter Third Number?");
		int thirdNumber = scanner.nextInt();

		if (firstNumber > secondNumber && firstNumber > thirdNumber) {
			System.out.println("First Number is Highest");
		} else if (secondNumber > firstNumber && secondNumber > thirdNumber) {
			System.out.println("Second Number is Highest");
		} else if (thirdNumber > firstNumber && thirdNumber > secondNumber) {
			System.out.println("Third Number is Highest");
		} else {
			System.out.println("All Numbers are Equal");
		}
		return null;
	}

	@GetMapping("/question10")
	public String displayResult(){
		System.out.println("Enter Value of r?");
		Scanner scanner = new Scanner(System.in);
		int r = scanner.nextInt();

		System.out.println("Enter Value of a?");
		int a = scanner.nextInt();

		System.out.println("Enter Value of x?");
		int x = scanner.nextInt();

		double y = Math.pow(Math.PI * r, 2) / (2 * a + x);
		System.out.println("y = " + y);
		return null;
	}

//	WAP to take the aggregate percentage mark of a student and display the grade on following basis

//	Percentage mark Grade
//	Between 90 and 100 A
//	Between 80 and 89 B
//	Between 60 and 79 C
//	Between 30 and 59 D

	@GetMapping(value = "/question11")
	public String calculateGrade(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Marks?");
		int marks = scanner.nextInt();

		if (marks >= 90 && marks <= 100) {
			System.out.println("Grade A");
		} else if (marks >= 80 && marks <= 89) {
			System.out.println("Grade B");
		} else if (marks >= 60 && marks <= 79) {
			System.out.println("Grade C");
		} else if (marks >= 30 && marks <= 59) {
			System.out.println("Grade D");
		} else {
			System.out.println("Invalid Marks");
		}
		return null;
	}

//	WAP to take the age of a person. Display a category on following basis.

//	Age Group Category
//	Below 4 Infant
//	Between 4 and 12 Child
//	Between 13 and 17 Teenager
//	Above 17 Adult

	@GetMapping(value = "/question12")
	public String calculateAgeGroup(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Age?");
		int age = scanner.nextInt();

		if (age < 4) {
			System.out.println("Infant");
		} else if (age >= 4 && age <= 12) {
			System.out.println("Child");
		} else if (age >= 13 && age <= 17) {
			System.out.println("Teenager");
		} else if (age >= 18) {
			System.out.println("Adult");
		} else {
			System.out.println("Invalid Age");
		}
		return null;
	}

//3. WAP to take a month number between 1 and 12 from user. Display a season using Switch Case on
//	following basis.

//	Month Number Season
//2 Spring
//3, 4, 5 Summer
//6, 7, 8 Rainy
//9 Autumn
//10 Dew
//11, 12 and 1 Winter

	@GetMapping(value = "/question13")
	public String displaySeason(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Month Number?");
		int monthNumber = scanner.nextInt();

		if (monthNumber == 2) {
			System.out.println("Spring");
		} else if (monthNumber == 3 || monthNumber == 4 || monthNumber == 5) {
			System.out.println("Summer");
		} else if (monthNumber == 6 || monthNumber == 7 || monthNumber == 8) {
			System.out.println("Rainy");
		} else if (monthNumber == 9) {
			System.out.println("Autumn");
		} else if (monthNumber == 10) {
			System.out.println("Dew");
		} else if (monthNumber == 11 || monthNumber == 12 || monthNumber == 1) {
			System.out.println("Winter");
		} else {
			System.out.println("Invalid Month Number");
		}
		return null;
	}

//	WAP to take a character from user. Display whether its an Upper Case alphabet or Lower Case alphabet
//	or a digit or a symbol.

	@GetMapping(value = "/question14")
	public String displayCharacterType(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Character?");
		char character = scanner.next().charAt(0);

		if (character >= 'A' && character <= 'Z') {
			System.out.println("Upper Case Alphabet");
		} else if (character >= 'a' && character <= 'z') {
			System.out.println("Lower Case Alphabet");
		} else if (character >= '0' && character <= '9') {
			System.out.println("Digit");
		} else {
			System.out.println("Symbol");
		}
		return null;
	}

//	WAP to take a character from user. Using Nested If, check whether its an alphabet or not. If alphabet,
//	display whether it’s a vowel or consonant.

	@GetMapping(value = "/question15")
	public String displayVowelOrConsonant(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Character?");
		char character = scanner.next().charAt(0);

		if (character >= 'A' && character <= 'Z' || character >= 'a' && character <= 'z') {
			if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u' || character == 'A' || character == 'E' || character == 'I' || character == 'O' || character == 'U') {
				System.out.println("Vowel");
			} else {
				System.out.println("Consonant");
			}
		} else {
			System.out.println("Not an Alphabet");
		}
		return null;
	}

//	WAP to take the gender of a person as M or F for male and female respectively. Also take the age of the
//	person.Display whether the person is legally eligible to marry or not where legal age of marriage is 21 for
//	male and 18 for female.

	@GetMapping("/question16")
	public String checkEligibleForMarriage(){
		System.out.println("Enter Gender?");
		Scanner scanner = new Scanner(System.in);
		char gender  = scanner.nextLine().charAt(0);

		System.out.println("Enter Age?");
		int age = scanner.nextInt();

		if ((gender == 'm' || gender == 'M') && age >= 21){
			System.out.println("You are Eligible For Marriage");
		}else if ((gender == 'f' || gender == 'F') && age >= 18){
			System.out.println("You are Eligible For Marriage");
		}else
			System.out.println("You are Not Eligible For Marriage");
		return null;
	}

//	WAP to take the total amount of purchase made by a customer. Calculate the amount of discount and the
//	final amount to be paid by the customer after deducting discount on following basis.
//
//	Total Purchase Amount Discount
//	Below 3,000 5% on the purchase amount
//	Between 3,000 and 6,000 10% on the purchase amount
//	Between 6001 and 10,000 15% on the purchase amount
//	Above 10,000 20% on the purchase amount

	@GetMapping("/question17")
	public String calculateDiscount(){
		System.out.println("Enter Total Purchase Amount?");
		Scanner scanner = new Scanner(System.in);
		int totalPurchaseAmount = scanner.nextInt();

		if (totalPurchaseAmount < 3000){
			System.out.println("Discount is 5% on the purchase amount");
		}else if (totalPurchaseAmount >= 3000 && totalPurchaseAmount <= 6000){
			System.out.println("Discount is 10% on the purchase amount");
		}else if (totalPurchaseAmount >= 6001 && totalPurchaseAmount <= 10000){
			System.out.println("Discount is 15% on the purchase amount");
		}else if (totalPurchaseAmount > 10000){
			System.out.println("Discount is 20% on the purchase amount");
		}else {
			System.out.println("Invalid Total Purchase Amount");
		}
		return null;
	}

//	WAP to take name and monthly salary of a person as input. Calculate and display the income tax amount
//	along with the name of that person on the following basis. (Note: Income Tax is calculated on the annual
//	income of a person)
//	Annual Income Tax rate
//	Up to 3,00,000 0% (nil)
//	Next 2,00,000 5% on the amount that is exceeding 3,00,000
//	Next 5,00,000 10% on the amount that is exceeding 5,00,000 + 10,000
//	Above 10,00,000 20% on the amount that is exceeding 10,00,000 + 60,000

	@GetMapping("/question18")
	public String calculateIncomeTax(){
		System.out.println("Enter Name?");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();

		System.out.println("Enter Monthly Salary?");
		int monthlySalary = scanner.nextInt();

		int annualSalary = monthlySalary * 12;

		if (annualSalary <= 300000){
			System.out.println("Income Tax is 0% (nil)");
		}else if (annualSalary > 300000 && annualSalary <= 500000){
			System.out.println("Income Tax is 5% on the amount that is exceeding 3,00,000");
		}else if (annualSalary > 500000 && annualSalary <= 1000000){
			System.out.println("Income Tax is 10% on the amount that is exceeding 5,00,000 + 10,000");
		}else if (annualSalary > 1000000){
			System.out.println("Income Tax is 20% on the amount that is exceeding 10,00,000 + 60,000");
		}else {
			System.out.println("Invalid Annual Salary");
		}
		return null;
	}






}
