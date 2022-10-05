package com.sambit.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 02/10/2022 - 12:42 PM
 */@Controller
public class LoginController {
	@GetMapping("/loginPage")
	public String login() {
		return "loginPage";
	}
 }
