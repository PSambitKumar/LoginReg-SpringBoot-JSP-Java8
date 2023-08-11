package com.sambit.CompetitvePractice.HackerRank.RestAPI;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 12/10/2022 - 3:11 PM
 */
public class NumberOfDrawnMatches {
	public static int numberOfDrawnMatches(int year) throws JSONException {
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject("https://jsonmock.hackerrank.com/api/football_matches?year="+year + "&page=" +2, String.class);
		JSONObject jsonObject = new JSONObject(response);
		System.out.println("Response: " + response);
		return Integer.parseInt( jsonObject.get("total").toString());
	}

	public static void main(String[] args) throws JSONException {
		System.out.println(numberOfDrawnMatches(2011));
	}
}
