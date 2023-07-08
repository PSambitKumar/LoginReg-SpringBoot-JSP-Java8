package com.sambit.Controller;

import com.sambit.CompetitvePractice.Algorithms.Sorting;
import com.sambit.Repository.DistrictRepository;
import com.sambit.Repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 27/09/2022 - 5:51 PM
 */

@Controller
public class MainController {

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private DistrictRepository districtRepository;

	@ResponseBody
	@GetMapping(value = "/sortIntegerArray")
	public int[] printSortArray(){
		int[] unSortArray = {5, 4, 3, 2, 1, 0, 9, 8, 7, 6};
		int n = unSortArray.length;
		return Sorting.sort(unSortArray, n);
	}

	@ResponseBody
	@GetMapping(value = "/getDistrictList")
	public ResponseEntity<?> getDistrictList() {
		System.out.println("Inside getDistrictList Method of MainController.");
		List<Map<String, String>> districtMapList = new ArrayList<>();
		List<String> districtList = new ArrayList<>();
		try {
			List<String> stateCodeList = Arrays.asList("35","28","18","10","21","07","30");
			List<Object[]> stateList = stateRepository.getDistrictByStateCode(stateCodeList);
			stateList.forEach(state -> {
				Map<String, String> districtMap = new LinkedHashMap<>();
				districtMap.put("stateCode", state[0].toString());
				districtMap.put("stateName", state[1].toString());
				districtMap.put("districtCode", state[2].toString());
				districtMap.put("districtName", state[3].toString());
				districtMapList.add(districtMap);
			});
			System.out.println(districtMapList);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ResponseEntity.ok().body(districtList);
	}
}
