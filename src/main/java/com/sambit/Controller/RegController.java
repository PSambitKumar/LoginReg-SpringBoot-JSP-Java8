package com.sambit.Controller;

import com.sambit.Bean.LoginBean;
import com.sambit.Bean.RegBean;
import com.sambit.Service.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegController {

    @Autowired
    RegService regService;

    @GetMapping("Registration")
    public String home(Model model){
        model.addAttribute("regBean", new RegBean());
        return "Registration";
    }
    @PostMapping("Registration")
    public String saveRegData(@ModelAttribute("regBean")RegBean regBean, Model model){
        try {
            regService.saveRegLoginData(regBean);
            model.addAttribute("loginBean", new LoginBean());
        }catch (Exception e){
            System.out.println(regBean.getUsername()+" Username Already Taken");
        }
        return "Login";
    }
    @GetMapping("Login")
    public String login(Model model){
        model.addAttribute("loginBean", new LoginBean());
        return "Login";
    }
    @PostMapping("Login")
    public String loginData(@ModelAttribute("loginBean")LoginBean loginBean){
        String UserPage = "";
        try {
            LoginBean lb = regService.checkLoginData(loginBean);
            if (lb != null)
                UserPage = "User";
        }catch (Exception e){
//            System.out.println("User Not Found, Try to Register!!");
            UserPage = "UserNotFound";
        }
        return UserPage;
    }
}