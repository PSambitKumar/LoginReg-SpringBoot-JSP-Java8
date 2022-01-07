package com.sambit.Controller;

import com.sambit.Bean.LoginBean;
import com.sambit.Bean.RegBean;
import com.sambit.Entity.Reg;
import com.sambit.Service.RegService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RegController {

    final RegService regService;
    public RegController(RegService regService) {
        this.regService = regService;
    }

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
    public ModelAndView loginData(@ModelAttribute("loginBean")LoginBean loginBean){
        String UserPage = "";
        ModelAndView modelAndView = null;
        try {
            LoginBean lb = regService.checkLoginData(loginBean);
            if (lb != null) {
                UserPage = "User";
                modelAndView = new ModelAndView(UserPage);
                List<Reg> list = regService.getAllDataofUser(loginBean);
                modelAndView.addObject("list", list);
            }
            else {
                UserPage = "UserNotFound";
                modelAndView = new ModelAndView(UserPage);
            }
        }catch (Exception e){
            UserPage = "UserNotFound";
            modelAndView = new ModelAndView(UserPage);
        }
        return modelAndView;
    }
    @GetMapping ("slno")
    public String get() {
        List<Reg> list = regService.getDataOfUser(1);
        System.out.println(list);

        return "Hello";
    }

    @GetMapping("phn")
    public String getList(){
        String phn = "7008095918";
        List<Reg> list = regService.getDataOfUserByPhn(phn);
        System.out.println(list);
        return "Hello";
    }

    @ResponseBody
    @GetMapping("/getData")
    public List<Reg> getData(){
        System.out.println("Hello Mr. Sambit.");
        List<Reg> list = regService.getDataofUserByUamePassandName("sambit", "sambit16", "Sambit Kumar Pradhan");
        System.out.println(list);
    return list;
    }

    @RequestMapping("/View")
    public ModelAndView getDetail(){
        ModelAndView mav = new ModelAndView("View");
        return mav;
    }
}

