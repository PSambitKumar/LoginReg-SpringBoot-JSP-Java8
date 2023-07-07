package com.sambit.Controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 11/11/2022 - 5:00 PM
 */
@Controller
public class TestController {

	@GetMapping("/getHospitalBySno")
	public String getHospitalBySno() {
		JSONObject jsonObject = new JSONObject();
		RestTemplate restTemplate = new RestTemplate();
		String response, requestURL = "http://localhost:8299/mobileApi/getHospitalBySNO";
		try {
			jsonObject.put("userId", 1914);
			jsonObject.put("stateCode", "21");
			jsonObject.put("districtCode", "17");

			response = restTemplate.postForObject(requestURL, jsonObject.toString(), String.class);
			System.out.println("Response : " + response);
		} catch (JSONException e) {
			throw new RuntimeException(e);
		}
		return response;
	}

}
