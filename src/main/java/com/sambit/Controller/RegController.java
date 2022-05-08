package com.sambit.Controller;

import com.sambit.Bean.*;
import com.sambit.Entity.Image;
import com.sambit.Entity.PersonalData;
import com.sambit.Entity.Postal;
import com.sambit.Entity.Reg;
import com.sambit.Repository.PostalRepository;
import com.sambit.Service.RegService;
import com.sambit.Utils.ANSIColors;
import com.sambit.Utils.CommonFileUpload;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.util.Comparator.comparingDouble;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

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
    public String saveImageData(@RequestParam("imageData")MultipartFile imageData, Image image, RedirectAttributes redirectAttributes, Model model) throws IOException {
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

//    @GetMapping("secure/postalHo.htm")
//    public String postalHo(){
//        System.out.println(ANSIColors.ansiRed + "Entering Into Postal Ho Method" + ANSIColors.ansiReset);
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        MediUser mediUser = (MediUser) authentication.getPrincipal();
//        User user = userService.findByUsername(mediUser.getUsername());
//        System.out.println(ANSIColors.ansiRed + "User : " + ANSIColors.ansiReset + user);
//        try {
//            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\sambit.pradhan\\Documents\\a1.xlsx");
//            System.out.println(ANSIColors.ansiRed + "File Input Stream : " + ANSIColors.ansiReset + fileInputStream);
//            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
//            System.out.println(ANSIColors.ansiRed + "XSSFWorkbook : " + ANSIColors.ansiReset + xssfWorkbook);
//            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
//            System.out.println(ANSIColors.ansiRed + "XSSFSheet : " + ANSIColors.ansiReset +  xssfSheet );
//            Iterator<Row> rowIterator = xssfSheet.iterator();
//            int rowNumber = 0;
////            System.out.println(ANSIColors.ansiGreen + "Row Iterator : " + ANSIColors.ansiReset + rowIterator.toString());
//            while (rowIterator.hasNext()){
//                System.out.println(ANSIColors.ansiRed + "Row Iterator Has Next : " + ANSIColors.ansiReset + rowIterator.hasNext());
//                Row row = rowIterator.next();
//                if (rowNumber == 0 || rowNumber == 1) {
//                    rowNumber++;
//                    continue;
//                }
////                System.out.println(ANSIColors.ansiGreen + "Row : " + ANSIColors.ansiReset + row.toString());
//                Iterator<Cell> cellIterator = row.cellIterator();
////                System.out.println(ANSIColors.ansiGreen + "Cell Iterator : " + ANSIColors.ansiReset + cellIterator.toString());
//                while (cellIterator.hasNext()){
//                    System.out.println(ANSIColors.ansiRed + "Cell Iterator Has Next : " + ANSIColors.ansiReset + cellIterator.hasNext());
//                    Cell cell = cellIterator.next();
////                    System.out.println(ANSIColors.ansiGreen + "Cell : " + ANSIColors.ansiReset + cell.toString());
//                    switch (cell.getCellType()) {
//                        case Cell.CELL_TYPE_NUMERIC:
//                            System.out.print(cell.getNumericCellValue() + "\t");
//                            break;
//                        case Cell.CELL_TYPE_STRING:
//                            System.out.print(cell.getStringCellValue() + "\t");
//                            break;
//                    }
//                }
//                System.out.println("");
//            }
//            fileInputStream.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }


//    @GetMapping("secure/postalHo.htm")
//    public String postalHo(){
//        System.out.println(ANSIColors.ansiRed + "Entering Into Postal Ho Method" + ANSIColors.ansiReset);
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        MediUser mediUser = (MediUser) authentication.getPrincipal();
//        User user = userService.findByUsername(mediUser.getUsername());
//        List<PostalHoHelper> postalHoHelpersList = new ArrayList<>();
//        try {
//            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\sambit.pradhan\\Documents\\a2.xlsx");
//            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
//            XSSFSheet sheet = workbook.getSheetAt(0);
//            Row row = sheet.getRow(4);   //Starting from 4th Row
////            System.out.println("Row : " + row);
//            int lastRowIndex = sheet.getLastRowNum() + 1;
//            System.out.println("Last row index :" + lastRowIndex);
//            int totalNoOfCols = row.getLastCellNum() - 1;
//            System.out.println("Total columns :" + totalNoOfCols);
//            DataFormatter df = new DataFormatter();
//
////            Coulmn Wise
////            for (int i = 1; i <= totalNoOfCols ; i++) {
////                for (int j = 4; j < lastRowIndex; j++) {
////                    row = sheet.getRow(j);
////                    Cell c = row.getCell(i);
////                    String cellData = df.formatCellValue(c);
////                    System.out.println(cellData);
////                    arrayExcelData[i-1][j] = cellData;
////                }
////                System.out.println("-----------");
////            }
//
//            for (int i = 5; i< lastRowIndex; i++){
//                PostalHoHelper postalHoHelper = new PostalHoHelper();
//                for (int j = 1; j < totalNoOfCols; j++){
//                    row = sheet.getRow(i);
//                    if (j == 2){
//
//                        Cell cell = row.getCell(j);
//                        String cellData = df.formatCellValue(cell);
//                        postalHoHelper.setOfcName(cellData);
//                        System.out.print(cellData + "|\t");
//                    }
//                    else if (j == 10){
//                        Cell cell = row.getCell(j);
//                        String cellData = df.formatCellValue(cell);
//                        System.out.println(cellData);
//                        postalHoHelper.setOfcPincode(cellData);
//                    }
//                    postalHoHelpersList.add(postalHoHelper);
//                }
//            }
//            System.out.println(postalHoHelpersList);
//            HashSet<PostalHoHelper> hashSet = new HashSet(postalHoHelpersList);
//            System.out.println(hashSet);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }



    //    For Rading Data of a Excel File
//    @GetMapping("readExcelFile")
//    public String postal(){
//        System.out.println(ANSIColors.ansiRed + "Entering Into Postal Ho Method" + ANSIColors.ansiReset);
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        MediUser mediUser = (MediUser) authentication.getPrincipal();
//        User user = userService.findByUsername(mediUser.getUsername());
//        List<PostalBean> postalBeanArrayList = new ArrayList<>();
//        try {
//            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\sambit.pradhan\\Documents\\a2.xlsx");
//            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
//            XSSFSheet sheet = workbook.getSheetAt(0);
//            Row row = sheet.getRow(4);   //Starting from 4th Row
//            System.out.println("Row : " + row);
//            int lastRowIndex = sheet.getLastRowNum() + 1;
//            System.out.println("Last row index :" + lastRowIndex);
//            int totalNoOfCols = row.getLastCellNum() - 1;
//            System.out.println("Total columns :" + totalNoOfCols);
//            DataFormatter df = new DataFormatter();
//            PostalBean postalBean;
//            int count = 1;
//
//            for (int i = 5; i< lastRowIndex; i++){
//                postalBean = new PostalBean();
//                for (int j = 1; j < totalNoOfCols; j++){
//                    row = sheet.getRow(i);
//                    if (j == 2){
//                        Cell cell = row.getCell(j);
//                        String cellData = df.formatCellValue(cell).trim();
//                        if (postalBeanArrayList.size() == 0){
//                            System.out.println("Inside");
//                            postalBean.getOfcId(count);
//                        }
//                        else if(postalBeanArrayList.size() > 1){
//                            for (PostalBean bean : postalBeanArrayList) {
//                                if (bean.getOfcName() == cellData){
//                                    postalBean.setOfcId(count);
//                                }
//                                else {
//                                    count += 1;
//                                    postalBean.setOfcId(count);
//                                }
//                            }
//                        }
//                        postalBean.setOfcName(cellData);
//                        System.out.print(cellData + "|\t");
//                    }
//                    else if (j == 10){
//                        Cell cell = row.getCell(j);
//                        String cellData = df.formatCellValue(cell).trim();
//                        System.out.println(cellData);
//                        postalBean.setOfcPincode(cellData);
//                        postalBean.setStatus("Active");
//                        postalBean.setCreatedOn(new Date());
//                    }
//                }
//                postalBeanArrayList.add(postalBean);
//            }
//
////            Printing Each Object of PostalBeanList
//            for (PostalBean postalBean1 : postalBeanArrayList) {
//                System.out.println(postalBean1);
//            }
//
//            System.out.println(postalBeanArrayList.size());
//            System.out.println(postalBeanArrayList);
//
//            List<PostalBean> postalBeanArrayList1 = new ArrayList<>();
//
//            for (int i = 1 ; i <= postalBeanArrayList.size(); i++){
//                for (int j = 2; j <= postalBeanArrayList.size(); j++){
//                    if (postalBeanArrayList.get(i).getOfcName() != postalBeanArrayList.get(j).getOfcName()){
//                        postalBeanArrayList.remove(j);
////                        postalBeanArrayList1.add(postalBeanArrayList.get(j));
//                    }
//                }
//            }
//            System.out.println("Unique Data List : " + postalBeanArrayList1);
//
//            for (PostalBean postalBean : postalBeanArrayList) {
//                if (postalBeanArrayList1.size() == 0){
//                    postalBeanArrayList1.add(postalBean);
//                    System.out.println(postalBeanArrayList1);
//                }
//                else {
//                    System.out.println("Inside Else Method.");
//                    for (PostalBean bean : postalBeanArrayList1) {
//                        if (bean.getOfcName() != postalBean.getOfcName()){
//                            System.out.println("Unique Data : " + postalBean.getOfcName());
//                            postalBeanArrayList1.add(postalBean);
//                        }
//                    }
//                }
//            }
//            System.out.println("Unique List : " + postalBeanArrayList1);
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }

//    //    For Rading Data of a Excel File // Working Perfect
//    @GetMapping("readExcelFile")
//    public String postal(){
//        System.out.println(ANSIColors.ansiRed + "Entering Into Postal Ho Method" + ANSIColors.ansiReset);
////        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
////        MediUser mediUser = (MediUser) authentication.getPrincipal();
////        User user = userService.findByUsername(mediUser.getUsername());
//        List<PostalBean> postalBeanArrayList = new ArrayList<>();
//        try {
//            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\sambit.pradhan\\Documents\\a1.xlsx");
//            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
//            XSSFSheet sheet = workbook.getSheetAt(0);
//            Row row = sheet.getRow(4);   //Starting from 4th Row
////            System.out.println("Row : " + row);
//            int lastRowIndex = sheet.getLastRowNum() + 1;
//            System.out.println("Last row index :" + lastRowIndex);
//            int totalNoOfCols = row.getLastCellNum() - 1;
//            System.out.println("Total columns :" + totalNoOfCols);
//            DataFormatter df = new DataFormatter();
//            PostalBean postalBean;
//            int count = 0;
//            String oficeName = null;
//
//            for (int i = 5; i< lastRowIndex; i++){
//                postalBean = new PostalBean();
//                for (int j = 1; j < totalNoOfCols; j++){
//                    row = sheet.getRow(i);
//                    if (j == 2){
//                        Cell cell = row.getCell(j);
//                        String cellData = df.formatCellValue(cell).trim();
//                        if (cellData != oficeName){
//                            oficeName = cellData;
//                            count += 1;
//                        }
//                        postalBean.setOfcName(cellData);
//                        postalBean.setOfcId(count);
//                        System.out.print(cellData + "|\t");
//                    }
//                    else if (j == 10){
//                        Cell cell = row.getCell(j);
//                        String cellData = df.formatCellValue(cell).trim();
//                        System.out.println(cellData);
//                        postalBean.setOfcPincode(cellData);
//                        postalBean.setStatus("Active");
//                        postalBean.setCreatedOn(new Date());
//                    }
//                }
//                postalBeanArrayList.add(postalBean);
//            }
//
////            Printing Each Object of PostalBeanList
//            for (PostalBean postalBean1 : postalBeanArrayList) {
//                System.out.println(postalBean1);
//            }
//
//            System.out.println(postalBeanArrayList.size());
//            System.out.println(postalBeanArrayList);
//
//            List<PostalBean> unique = postalBeanArrayList.stream()
//                    .collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparingInt(PostalBean::getOfcId))), ArrayList::new));
//
//            System.out.println("Unique Data : " + unique);
//            for (PostalBean bean : unique) {
//                System.out.println(bean);
//            }
//            System.out.println("Size : " + unique.size());
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }



    //    For Rading Data of a Excel File // Working Perfect
    @GetMapping("readExcelFile")
    public String postal(){
        System.out.println(ANSIColors.ansiRed + "Entering Into Postal Ho Method" + ANSIColors.ansiReset);
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        MediUser mediUser = (MediUser) authentication.getPrincipal();
//        User user = userService.findByUsername(mediUser.getUsername());
        List<Postal> postalList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\sambit.pradhan\\Documents\\a1.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(4);   //Starting from 4th Row
            int lastRowIndex = sheet.getLastRowNum() + 1;
            int totalNoOfCols = row.getLastCellNum() - 1;
            DataFormatter df = new DataFormatter();
            Postal postal;
            int count = 0;
            String oficeName = null;

            for (int i = 5; i< lastRowIndex; i++){
                postal = new Postal();
                for (int j = 1; j < totalNoOfCols; j++){
                    row = sheet.getRow(i);
                    if (j == 2){
                        Cell cell = row.getCell(j);
                        String cellData = df.formatCellValue(cell).trim();
                        if (cellData != oficeName){
                            oficeName = cellData;
                            count += 1;
                        }
                        postal.setOfcName(cellData);
                        postal.setOfcId(count);
                    }
                    else if (j == 10){
                        Cell cell = row.getCell(j);
                        String cellData = df.formatCellValue(cell).trim();
                        postal.setOfcPincode(cellData);
                        postal.setStatus("Active");
                        postal.setCreatedOn(new Date());
                    }
                }
                postalList.add(postal);
            }

            for (Postal postal1 : postalList) {
                System.out.println(postal1);
            }

            List<Postal> uniquePostal = postalList.stream()
                    .collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparingDouble(Postal::getOfcId))), ArrayList::new));

            System.out.println("Unique Data Size : " + uniquePostal.size());
            for (Postal postal2 : uniquePostal) {
                System.out.println(postal2);
            }
            List<Postal> updatedDataPostalList = regService.saveAllPostal(postalList);
            if (updatedDataPostalList.size() == postalList.size()){
                System.out.println(ANSIColors.ansiGreen + "Data Updated to Database Successfully.");
            }
            else {
                System.out.println("Data Failed to Update to The Database!");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
