package com.sambit.Controller;

import com.sambit.Bean.ImageBean;
import com.sambit.Bean.LoginBean;
import com.sambit.Bean.PersonalDataBean;
import com.sambit.Bean.RegBean;
import com.sambit.Entity.PersonalData;
import com.sambit.Entity.Reg;
import com.sambit.Service.RegService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
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
    public String saveRegData(@ModelAttribute("regBean")RegBean regBean, Model model, RedirectAttributes redirect){
//        System.out.println(regBean);
        String result = "";
        try {
            result = regService.saveRegLoginData(regBean);
            System.out.println(result);
            model.addAttribute("loginBean", new LoginBean());
        }catch (Exception e){
            System.out.println(regBean.getUsername()+" Username Already Taken");
        }
        return "redirect:/Login";
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
//                personalDataBean = null;
                model.addAttribute("list", list);
            }
        }catch (Exception e){
            result = "Fail";
            e.printStackTrace();
        }
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
    @GetMapping("/NewReg")
    public String newReg(Model model){
        model.addAttribute("regBean", new RegBean());
        return "Registration1";
    }

    @ResponseBody
    @GetMapping("PrintDate")
    public String printDate() throws ParseException {
        Date date1 = new Date();
        String date = new SimpleDateFormat("dd-MMM-yyyy").format(date1);
        return date;
    }

//    @ResponseBody
//    @GetMapping("PrintDate1")
//    public Date printDate1() throws ParseException {
//        String dateString = new SimpleDateFormat("yyyy mm dd").format(new Date());
////        Date date=Date.valueOf(dateString);
////        Date date = new Date();
//        return date;
//    }

    @GetMapping("PrintDate2/{strDate}")
    public String datePrint(@PathVariable("strDate") String strDate){
        String newDate = "";
        System.out.println(strDate);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MMM/yyyy");
        SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MMM-yyyy");
        String[] dateString = strDate.split("-");

        for (int i = 0; i < dateString.length; i++){
            if (i == 1){
                String data = dateString[i];

                String monthString = "";
                switch (data) {
                    case "Jan":  newDate += "/01/";
                        break;
                    case "Feb":  newDate += "/02/";
                        break;
                    case "Mar":  newDate += "/03/";
                        break;
                    case "Apr":  newDate += "/04/";
                        break;
                    case "May":  newDate += "/05/";
                        break;
                    case "Jun":  newDate += "/06/";
                        break;
                    case "Jul":  newDate += "/07/";
                        break;
                    case "Aug":  newDate += "/08/";
                        break;
                    case "Sep":  newDate += "/09/";
                        break;
                    case "Oct": newDate += "/10/";
                        break;
                    case "Nov": newDate += "/11/";
                        break;
                    case "Dec": newDate += "/12/";
                        break;
                    default: monthString = "Invalid month";
                        break;
                }
            }
            else {
                String data = dateString[i];
                newDate = newDate + data;
            }
        }
        System.out.println(newDate);
        try {
            Date date = formatter.parse(newDate);
            System.out.println(date);
            System.out.println(formatter.format(date));
            System.out.println(formatter1.format(date));
            System.out.println(formatter2.format(date));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}