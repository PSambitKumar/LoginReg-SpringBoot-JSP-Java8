

package com.sambit.CompetitvePractice.HackerRank.ProjectEuler;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

/**
    *@Project : Registration
    *@Auther : Sambit Kumar Pradhan
    *@Created On : 26/10/2022 - 1:11 PM
*/public class AmicableNumbers {

//	All 4 Test Cases Are Passed
	protected static long firstSum, secondSum, finalSum;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int queries = scan.nextInt();

		HashMap<Integer, Long> amicableSummations = new HashMap<Integer, Long>();
		for (int index = 1; index < 100000; index++) {
			firstSum = findSumOfDivisors(index);
			if (index == firstSum) { continue; }
			secondSum = findSumOfDivisors(firstSum);

			//checks for amicable intance again and adds sums if instance exists.
			if (index != firstSum && index == secondSum) {
				finalSum += index;
				amicableSummations.put(index, finalSum);
			} else { amicableSummations.put(index, finalSum); }
		}
		while (queries-- > 0) {
			int numberInput = scan.nextInt();
			System.out.println(amicableSummations.get(numberInput));
		}
	}

	protected static long findSumOfDivisors(final long inputNumber) {
		long sumOfDivisors = 1;
		for (long divisor = 2; divisor <= Math.sqrt(inputNumber); divisor++) {
			if (inputNumber % divisor == 0) {
				sumOfDivisors += divisor;
				long division = inputNumber / divisor;
				if (division != divisor) { sumOfDivisors += division; }
			}
		}
		return sumOfDivisors;
	}



//	3 Test Case Passed
	public static void main1(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			int n = in.nextInt();
			int sum = 0;
			for (int i = 2; i < n; i++) {
				int d1 = getDivisorSum(i);
				int d2 = getDivisorSum(d1);
				if (d2 == i && i != d1) {
					sum += i;
				}
			}
			System.out.println(sum);
		}
	}

	public static int getDivisorSum(int n) {
		int sum = 1;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				if (i == (n / i)) {
					sum += i;
				} else {
					sum += (i + n / i);
				}
			}
		}
		return sum;
	}


//	2 Test Case Passed
	public static void main2(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			int n = in.nextInt();
			int sum = 0;
			for (int i = 1; i < n; i++) {
				int sum1 = 0;
				int sum2 = 0;
				for (int j = 1; j < i; j++) {
					if (i % j == 0) {
						sum1 += j;
					}
				}
				for (int j = 1; j < sum1; j++) {
					if (sum1 % j == 0) {
						sum2 += j;
					}
				}
				if (sum2 == i && sum1 != i) {
					sum += i;
				}
			}
			System.out.println(sum);
		}
	}

}
