package com.sambit.Controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sambit.Bean.*;
import com.sambit.Entity.*;
import com.sambit.Repository.PostalRepository;
import com.sambit.Repository.RegRepository;
import com.sambit.Service.RegService;
import com.sambit.Utils.*;
import com.sambit.Validation.AdharAlgorithm;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.DataInput;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

import static java.util.Comparator.comparingDouble;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

@Controller
public class RegController {

    @Autowired
    RegRepository regRepository;

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


//    Method to Type Cast String Date to Util.Date
    @GetMapping("PrintDate2/{strDate}")
    public String datePrint(@PathVariable("strDate") String strDate){
        String newDate = "";
        System.out.println(strDate);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MMM/yyyy");
        SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MMM-yyyy");
        SimpleDateFormat formatter3 = new SimpleDateFormat("MMM d, yyyy");
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
            System.out.println(formatter3.format(date));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/informationCheck/{folderName}")
    public String informationCheck(@PathVariable("folderName") String folderName){
        //Traversing to Success Page in WEB-INF/views
        return CommonFileUpload.createFolder(folderName);
    }

    @GetMapping(value = "/validateGepNIC/{GepNIC}")
    public String validateGepNIC(@PathVariable("GepNIC") String GepNIC){
        String copyGepNIC = GepNIC;
        if (copyGepNIC.length() != 15)
            System.out.println("GepNIC ID Must be 15 Characters!");
        else if (copyGepNIC.substring(0, 7).matches("^[a-zA-Z]*$") && copyGepNIC.substring(7, 14).matches("^[0-9]*$") && copyGepNIC.substring(14, 15).matches("^[a-zA-Z0-9]*$"))
            System.out.println("Validated GepNIC");
        else
            System.out.println("GepNIC ID Must First 7 Must be Alphabetic, Next 7 Must be Numbers, and Next 1 Must Be AlphaNumeric!");
        return null;
    }

    @GetMapping(value = "/imageUpload")
    public String imageUpload(Model model){
//        model.addAttribute("flashNumber", 88);
        return "imageUploadPage";
    }

    @PostMapping(value = "/saveImage")
    public String saveImageData(@RequestParam("imageData")MultipartFile imageData, Image image, RedirectAttributes redirectAttributes) throws IOException {
        System.out.println(imageData);
        String originalFileName = imageData.getOriginalFilename();
        System.out.println(originalFileName);
        String filePath = CommonFileUpload.singleFileUplaod(imageData, "images");
        System.out.println(filePath);
        image.setImageName(filePath);
        Image updateImage = regService.saveImage(image);
        if (updateImage != null){
            redirectAttributes.addFlashAttribute("flashMessage", "Image Uploaded To Database Successfully." + filePath);
        }
        else {
            redirectAttributes.addFlashAttribute("flashMessage", "Failed To Upload Image!");
        }
        return "redirect:/imageUpload";
    }

    @GetMapping("sendMail/{Gmail}")
    public String sendMail(@PathVariable(value = "Gmail")String gmail){
        System.out.println("Gmail : " + gmail);
//        for (int i = 0; i < 10; i++) {
//        }
        Mail.sendEmailTLS(gmail);

        return null;
    }

    @GetMapping("smsMobile")
    public String smsMobile(){
        SMSMobile.smsMobileReq();
        return "smsMobile";
    }

    @ResponseBody
    @GetMapping("adhaarValidation/{aadhar}")
    public String validateAadharNumber(@PathVariable(value = "aadhar", required = false)String aadharNumber){
        String result = null;
        Pattern aadharPattern = Pattern.compile("\\d{12}");
        boolean isValidAadhar = aadharPattern.matcher(aadharNumber).matches();
        if(isValidAadhar){
            isValidAadhar = AdharAlgorithm.validateAadhar(aadharNumber);
        }
        if (isValidAadhar == true){
            System.out.println(aadharNumber + ", This is a Valid Aadhar Number.");
            result = "Valid Aadhar";
        }else {
            result = "Invalid Aadhar";
        }
        return result;
    }

    @GetMapping("/daysCalculator")
    public String daysCalculator() throws ParseException {
        String date_string = "26-05-1997";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatter.parse(date_string);
        DaysBetweenDates.daysCountBetweenDates(date);
        return null;
    }

//    IFSC Code Check API Call
    @GetMapping("/checkIFSC")
    public String checkIFSC() throws JSONException {
        Gson gson = new Gson();
        String ifscCode ="SBIN0003942";
        RestTemplate restTemplate = new RestTemplate();
        String bankDetails = restTemplate.getForObject("https://ifsc.razorpay.com/"+ifscCode, String.class);

//        Method 1
        JSONObject jsonObject = new JSONObject(bankDetails);
        System.out.println("Bank Details Data : " + jsonObject);
        System.out.println(jsonObject.get("BANK"));

//        Method 2
//        Converting JSON String to ModeL Class
        BankDetailsBean bankDetailsBean = gson.fromJson(bankDetails, BankDetailsBean.class);
        System.out.println("Bank Details are : " + bankDetailsBean);
        System.out.println("String Data : " + bankDetails);

//        Object To Map Convertion
        ObjectMapper objectMapper =new ObjectMapper();
        Map<String, Object> map = objectMapper.convertValue(bankDetailsBean, Map.class);
        System.out.println("After Conversion of Map : " + map);
        System.out.println("Iterating and Printing Each Map Data------------->>");
        for (Map.Entry<String, Object> entry : map.entrySet())
            System.out.println("Key = " + entry.getKey() + " | Value = " + entry.getValue());

        return null;
    }

    @GetMapping(value = "/Issue")
    public String issue(){
        return "issue";
    }

//    Recieving Data from form using JSON Stringify
    @PostMapping(value = "/saveIssue")
    public String saveIssue(@RequestParam("jsonData") String jsonData) throws JSONException {
        System.out.println("Inside Save Issue Method.");
        System.out.println("Data : " + jsonData);
        JSONObject jsonObject = new JSONObject(jsonData);
        jsonObject.put("id", 0);
        System.out.println(jsonObject.get("id"));
        System.out.println(jsonObject);
        System.out.println(jsonObject.getString("issue"));
        return "issue";
    }


//    Java Subtract Days from Current Date
    @GetMapping(value = "getADate")
    public String getADate(){
        Date date = new Date();
        System.out.println("Date : " + date);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -5);
        Date newDate = calendar.getTime();
        System.out.println("New From Date : " + newDate);


//        Range Of Date
        Calendar calendar1 = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -45);
        Date fromDate = calendar.getTime();

        calendar.add(Calendar.DAY_OF_YEAR, 5);
        Date toDate = calendar.getTime();
        System.out.println("From Date : " + fromDate + ", To Date : " + toDate);
        return null;
    }

    @GetMapping("/userCodeGeneration")
    public String userCode(){
        int maxEmpId;
        try {
            maxEmpId = regRepository.maxSlno();
        }catch (Exception e){
            maxEmpId = 1;
        }
        System.out.println(maxEmpId);
        String userCode = UserCodeGeneration.UserCodeGenreationMethod(maxEmpId);
        System.out.println("UserCode: " + userCode);
        return null;
    }

    @GetMapping(value = "/objectClassTest")
    public String objectClassTest() throws JSONException, IOException {
        Gson gson = new Gson();
        Object[] allData = regRepository.findAll().toArray();
        for (Object allDatum : allData) {
            System.out.println("Single Object Data : " + allDatum);

//            Gson Data Convertion
            String gsonData = gson.toJson(allDatum);
            Reg reg2 = gson.fromJson(gsonData, Reg.class);
            System.out.println("Gson Data : " + gson);
            System.out.println("Registration Data2 : " + reg2);

//            JSONObject Data Convertion
            JSONObject jsonObject = new JSONObject(allDatum);
            System.out.println("JSON Data : " + jsonObject);
            System.out.println(jsonObject.getString("name"));

//            Object to Pojo Class TypeCasting
            Reg reg = (Reg)allDatum;
            System.out.println("Registration Data1 : " + reg);

//            Converting JSON Object to POJO/Entity/Model Class
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            Reg reg1 = objectMapper.convertValue(jsonObject, Reg.class);
            System.out.println("Registration Data : " + reg1);
        }
        return null;
    }



}
