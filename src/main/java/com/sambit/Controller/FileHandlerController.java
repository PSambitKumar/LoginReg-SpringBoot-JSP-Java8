package com.sambit.Controller;

import org.springframework.stereotype.Controller;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 07/09/2022 - 11:15 AM
 */

@Controller
public class FileHandlerController {
	public String uploadFile() {
		return "File Uploaded";
	}
}
