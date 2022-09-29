package com.sambit.Controller;

import com.sambit.Entity.Reg;
import com.sambit.Service.RegService;
import org.json.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 29/09/2022 - 9:57 AM
 */
@RestController
@RequestMapping(value = "/api")
public class RestAPIController {

	@Autowired
	private RegService regService;

	@GetMapping(value = "/checkUserIsPresent")
	public Map<String, Object> checkUserIsPresent(@RequestParam(value = "userName") String userName){
		Map<String, Object> map = new HashMap<>();
		try {
			boolean isPresent = regService.checkUserIsPresentOrNot(userName);
			if(isPresent){
				map.put("status", HttpStatus.OK.value());
				map.put("message", "User is Present");
			}else {
				map.put("status", HttpStatus.NOT_FOUND.value());
				map.put("message", "User is Not Present");
			}
		} catch (Exception e) {
			map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
			map.put("message", "Something Went Wrong");
		}
		return map;
	}

	@PostMapping(value = "/registerUser")
	public Map<String, Object> registerUser(@RequestBody Reg reg){
		Map<String, Object> map = new HashMap<>();
		try {
			Reg saveReg = regService.saveReg(reg);
			if (saveReg != null && saveReg.getSlno() > 0) {
				map.put("status", HttpStatus.OK.value());
				map.put("message", "User Registered Successfully");
			} else {
				map.put("status", HttpStatus.NOT_FOUND.value());
				map.put("message", "User Registration Failed");
			}
		}catch (Exception e) {
			map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
			map.put("message", "Something Went Wrong");
		}
		return map;
	}

	@DeleteMapping(value = "/deleteUser")
	public Map<String, Object> deleteUser(@RequestParam(value = "slno") int slno){
		System.out.println("slno = " + slno);
		Map<String, Object> map = new HashMap<>();
		try {
			boolean isPresent = regService.checkRegIsPresentOrNotBySlNo(slno);
			if (isPresent) {
				boolean isDeleted = regService.deleteReg(slno);
				if (isDeleted) {
					map.put("status", HttpStatus.OK.value());
					map.put("message", "User Deleted Successfully");
				} else {
					map.put("status", HttpStatus.NOT_FOUND.value());
					map.put("message", "User Deletion Failed");
				}
			}else {
				map.put("status", HttpStatus.NOT_FOUND.value());
				map.put("message", "User is Not Present");
			}
		} catch (Exception e) {
			map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
			map.put("message", "Something Went Wrong");
			throw new RuntimeException(e);
		}
		return map;
	}

	@PutMapping(value = "/updateUser")
	public Map<String, Object> updateUser(@RequestBody Reg reg){
		Map<String, Object> map = new HashMap<>();
		try {
			boolean isPresent = regService.checkRegIsPresentOrNotBySlNo(reg.getSlno());
			if (isPresent) {
				Reg saveReg = regService.saveReg(reg);
				if (saveReg != null && saveReg.getSlno() > 0) {
					map.put("status", HttpStatus.OK.value());
					map.put("message", "User Updated Successfully");
				} else {
					map.put("status", HttpStatus.NOT_FOUND.value());
					map.put("message", "User Updation Failed");
				}
			}else {
				map.put("status", HttpStatus.NOT_FOUND.value());
				map.put("message", "User is Not Present");
			}
		} catch (Exception e) {
			map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
			map.put("message", "Something Went Wrong");
			throw new RuntimeException(e);
		}
		return map;
	}
}
