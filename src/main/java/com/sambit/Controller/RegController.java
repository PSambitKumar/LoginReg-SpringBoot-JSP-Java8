package com.sambit.Controller;

import antlr.StringUtils;
import com.sambit.Bean.ImageBean;
import com.sambit.Bean.LoginBean;
import com.sambit.Bean.PersonalDataBean;
import com.sambit.Bean.RegBean;
import com.sambit.Entity.Image;
import com.sambit.Entity.PersonalData;
import com.sambit.Entity.Reg;
import com.sambit.Service.RegService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import java.io.IOException;
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
//        System.out.println(regBean);
        String result = "";
        try {
            result = regService.saveRegLoginData(regBean);
            System.out.println(result);
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
                modelAndView.addObject("personalDetailBean", new PersonalDataBean());
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
//    @PostMapping("ImageData")
//    public String saveImageData(ImageBean imageBean){
//        System.out.println(imageBean);
//        regService.saveImageData(imageBean);
//        return "Image";
//    }
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
    @GetMapping("/PersonalDetails")
    public String validateAdharAndPan(Model model){
        model.addAttribute("personalDataBean", new PersonalDataBean());
        return "ValidateAdharAndPan";
    }

//    @PostMapping("AddPersonalData")
//    public String addPersonalData(@ModelAttribute("persoalDataBean") PersonalDataBean personalDataBean){
//        System.out.println(personalDataBean);
//        return "Success";
//    }

    @PostMapping("AddPersonalData")
    public String addPersonalData(PersonalDataBean personalDataBean, Model model){
        //System.out.println(personalDataBean);
        String result = "";
        //result = regService.savePersonalDetails(personalDataBean);
        try {
            result = regService.savePersonalDetails(personalDataBean);
            if(result.equalsIgnoreCase("Success")){
                System.out.println("Data Added!!");
                List<PersonalData> list = regService.getAllPersonalDetails();
                model.addAttribute("list", list);
            }
        }catch (Exception e){
            result = "Fail";
            e.printStackTrace();
        }
//        return result;
        return "ViewPersonalDetails";
    }


    @GetMapping("ViewPersonalDetails")
    public String viewPersonalDetails(Model model){
        List<PersonalData> list = regService.getAllPersonalDetails();
        model.addAttribute("list", list);
//        System.out.println(list);
        return "ViewPersonalDetails";
    }

    @GetMapping("UploadImage")
    public ModelAndView uploadImage(){
        ModelAndView mav = new ModelAndView("UploadImage");
//        mav.addObject("uploadImage", new ImageBean());
        return mav;
    }

    @PostMapping("UploadImageData")
    String uploadImageData(ImageBean imageBean, @RequestParam("image") MultipartFile multipartFile)throws IOException {
        String fileName = multipartFile.getOriginalFilename();
        return "Success";
    }

    @GetMapping("Home")
    public String home(){
        return "Home";
    }

    @GetMapping("About")
    public String about(){
        return "About";
    }
}