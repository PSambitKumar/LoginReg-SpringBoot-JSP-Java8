package com.sambit.Controller;

import com.sambit.Utils.EnglishToOriya;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 13/04/2023 - 5:03 PM
 */
@RestController
@RequestMapping("/fun")
public class FunAPIController {

    @GetMapping("/englishToOriya")
    public String printEnglishToOriya(@RequestParam(value = "english") String english) {
        return EnglishToOriya.convertEnglishToOriya(english);
    }
}
