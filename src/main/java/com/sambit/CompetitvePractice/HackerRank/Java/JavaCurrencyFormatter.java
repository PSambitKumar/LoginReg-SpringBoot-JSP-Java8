package com.sambit.CompetitvePractice.HackerRank.Java;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 14/10/2022 - 11:01 AM
 */
public class JavaCurrencyFormatter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double payment = scanner.nextDouble();
		scanner.close();

//		US: $12,324.13
//		India: Rs.12,324.13
//		China: ￥12,324.13
//		France: 12 324,13 €


//		Using Of ASCII Character
//		String us = String.format("US: $%,.2f", payment);
//		String india = String.format("India: Rs.%,.2f", payment);
//		String china = String.format("China: ￥%,.2f", payment);
//		String france = String.format("France: %,.2f €", payment);
//
//		System.out.println(us);
//		System.out.println(india);
//		System.out.println(china);
//		System.out.println(france);


//		Using Of ASCII Character
//		String us = String.format("US: $%,.2f", payment);
//		String india = String.format("India: Rs.%,.2f", payment);
//		String china = String.format("China: ￥%,.2f", payment);
//		String france = String.format("France: %,.2f €", payment);
//
//		System.out.println(us);
//		System.out.println(india);
//		System.out.println(china);
//		System.out.println(france);


//		Using Of Unicode Character
//		String us = String.format("US: $%,.2f", payment);
//		String india = String.format("India: Rs.%,.2f", payment);
//		String china = String.format("China: \u00A5%,.2f", payment);
//		String france = String.format("France: %,.2f \u20AC", payment);
//
//		System.out.println(us);
//		System.out.println(india);
//		System.out.println(china);
//		System.out.println(france);


//		Using of Util.Currency
//		String us = java.util.Currency.getInstance(java.util.Locale.US).getSymbol();
//		String india = java.util.Currency.getInstance(java.util.Locale.forLanguageTag("en-IN")).getSymbol();
//		String india = java.util.Currency.getInstance(new java.util.Locale("en", "IN")).getSymbol();
//		String china = java.util.Currency.getInstance(java.util.Locale.CHINA).getSymbol();
//		String france = java.util.Currency.getInstance(java.util.Locale.FRANCE).getSymbol();

//		System.out.println("US: " + us + String.format("%,.2f", payment));
//		System.out.println("India: " + india + String.format("%,.2f", payment));
//		System.out.println("China: " + china + String.format("%,.2f", payment));
//		System.out.println("France: " + france + String.format("%,.2f", payment));


		NumberFormat nF1 = NumberFormat.getCurrencyInstance(Locale.US);
		Locale IND = new Locale("en","in");
		NumberFormat nF2 = NumberFormat.getCurrencyInstance(IND);
		NumberFormat nF3 = NumberFormat.getCurrencyInstance(Locale.CHINA);
		NumberFormat nF4 = NumberFormat.getCurrencyInstance(Locale.FRANCE);

		System.out.println("US: " + nF1.format(payment));
		System.out.println("India: " + nF2.format(payment));
		System.out.println("China: " + nF3.format(payment));
		System.out.println("France: " + nF4.format(payment));
	}
}
