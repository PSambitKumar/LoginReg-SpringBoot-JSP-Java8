package com.sambit.Controller;

import com.sambit.CompetitvePractice.Algorithms.Sorting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 27/09/2022 - 5:51 PM
 */

@Controller
public class MainController {

	@ResponseBody
	@GetMapping(value = "/sortIntegerArray")
	public String printSortArray(){
		int[] unSortArray = {5, 4, 3, 2, 1, 0, 9, 8, 7, 6};
		int n = unSortArray.length;
		Sorting.sort(unSortArray, n);
		return "Sorting";
	}
}
