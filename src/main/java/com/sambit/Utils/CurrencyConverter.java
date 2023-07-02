package com.sambit.Utils;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 08/11/2022 - 3:02 PM
 */
public class CurrencyConverter {

//	Input: "123456789", Output : "123,456,789"
	public static String indianCurrencyFormat(String rupees){
		String string = (new StringBuilder((new StringBuilder(rupees).reverse().toString())
			   .replaceAll("(.{3})", "$1,")).reverse().toString())
			   .replaceAll("^,|,$", "");
		System.out.println(string);
		return string;
	}

//	Input : "123456789", Output : "₹123,456,789.00"
	public static String currencyFormat(String rupees, String countryCode){
		NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("en", countryCode));
		String currency = format.format(Double.parseDouble(rupees));
		System.out.println(currency);
		return currency;
	}

	public static String currencyFormat(String rupees){
		NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
		String currency = format.format(Double.parseDouble(rupees));
		System.out.println(currency);
		return currency;
	}

	public static void main(String[] args) {
		indianCurrencyFormat("123456789");
		currencyFormat("123456789", "IN");
	}


}
