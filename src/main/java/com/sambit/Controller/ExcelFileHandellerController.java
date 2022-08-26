package com.sambit.Controller;

import com.sambit.Entity.Package;
import com.sambit.Entity.Postal;
import com.sambit.Entity.PostalPo;
import com.sambit.Entity.Procedure;
import com.sambit.Repository.PackageRepository;
import com.sambit.Repository.ProcedureRepository;
import com.sambit.Service.RegService;
import com.sambit.Utils.ANSIColors;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.FileInputStream;
import java.util.*;

import static java.util.Comparator.comparingDouble;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

@Controller
public class ExcelFileHandellerController {

    @Autowired
    private RegService regService;
    @Autowired
    private PackageRepository packageRepository;
    @Autowired
    private ProcedureRepository procedureRepository;


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
//    public String postal1(){
//        System.out.println(ANSIColors.ansiRed + "Entering Into Postal Ho Method" + ANSIColors.ansiReset);
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        MediUser mediUser = (MediUser) authentication.getPrincipal();
//        User user = userService.findByUsername(mediUser.getUsername());
//        List<PostalBean> postalBeanArrayList = new ArrayList<>();
//        try {
//            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\sambit.pradhan\\Documents\\a3.xlsx");
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
//
//            for (int i = 5; i< lastRowIndex; i++){
//                postalBean = new PostalBean();
//                for (int j = 1; j < totalNoOfCols; j++){
//                    row = sheet.getRow(i);
//                    if (j == 2){
//                        Cell cell = row.getCell(j);
//                        String cellData = df.formatCellValue(cell).trim();
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
//
//            List<PostalBean> newList = new ArrayList<>();
//
//
//            for (PostalBean bean : postalBeanArrayList) {
//                String ofcName = bean.getOfcName();
//                if(newList.isEmpty()) {
//                    newList.add(bean);
//                } else {
//                    int count = 0;
//                    for (PostalBean newBean : newList) {
//                        if (ofcName.equals(newBean.getOfcName())) {
//                            count++;
//                            break;
//                        }
//                    }
//                    if(count <= 0)
//                        newList.add(bean);
//                }
//            }
//            System.out.println("Unique Data : " + newList.size());
//            for (PostalBean bean : newList) {
//                System.out.println(bean);
//            }
//            System.out.println(postalBeanArrayList);





//            List<PostalBean> postalBeanArrayList1 = new ArrayList<>();

//            for (int i = 1 ; i <= postalBeanArrayList.size(); i++){
//                for (int j = 2; j <= postalBeanArrayList.size(); j++){
//                    if (postalBeanArrayList.get(i).getOfcName() != postalBeanArrayList.get(j).getOfcName()){
//                        postalBeanArrayList.remove(j);
////                        postalBeanArrayList1.add(postalBeanArrayList.get(j));
//                    }
//                }
//            }
//            System.out.println("Unique Data List : " + postalBeanArrayList1);

//            for (PostalBean postalBean1 : postalBeanArrayList) {
//                if (postalBeanArrayList1.size() == 0){
//                    postalBeanArrayList1.add(postalBean1);
//                    System.out.println(postalBeanArrayList1);
//                }
//                else {
//                    System.out.println("Inside Else Method.");
//                    for (PostalBean bean : postalBeanArrayList1) {
//                        if (bean.getOfcName() != postalBean1.getOfcName()){
//                            System.out.println("Unique Data : " + postalBean1.getOfcName());
//                            postalBeanArrayList1.add(postalBean1);
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
//    @GetMapping("readExcelFile")
//    public String postal(){
//        System.out.println(ANSIColors.ansiRed + "Entering Into Postal Ho Method" + ANSIColors.ansiReset);
////        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
////        MediUser mediUser = (MediUser) authentication.getPrincipal();
////        User user = userService.findByUsername(mediUser.getUsername());
//        List<Postal> postalList = new ArrayList<>();
//        try {
//            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\sambit.pradhan\\Documents\\a1.xlsx");
//            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
//            XSSFSheet sheet = workbook.getSheetAt(0);
//            Row row = sheet.getRow(4);   //Starting from 4th Row
//            int lastRowIndex = sheet.getLastRowNum() + 1;
//            int totalNoOfCols = row.getLastCellNum() - 1;
//            DataFormatter df = new DataFormatter();
//            Postal postal;
//            int count = 0;
//            String oficeName = null;
//
//            for (int i = 5; i< lastRowIndex; i++){
//                postal = new Postal();
//                for (int j = 1; j < totalNoOfCols; j++){
//                    row = sheet.getRow(i);
//                    if (j == 2){
//                        Cell cell = row.getCell(j);
//                        String cellData = df.formatCellValue(cell).trim();
//                        if (cellData != oficeName){
//                            oficeName = cellData;
//                            count += 1;
//                        }
//                        postal.setOfcName(cellData);
//                        postal.setOfcId(count);
//                    }
//                    else if (j == 10){
//                        Cell cell = row.getCell(j);
//                        String cellData = df.formatCellValue(cell).trim();
//                        postal.setOfcPincode(cellData);
//                        postal.setStatus("Active");
//                        postal.setCreatedOn(new Date());
//                    }
//                }
//                postalList.add(postal);
//            }
//
//            for (Postal postal1 : postalList) {
//                System.out.println(postal1);
//            }
//
//            List<Postal> uniquePostal = postalList.stream()
//                    .collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparingDouble(Postal::getOfcId))), ArrayList::new));
//
//            System.out.println("Unique Data Size : " + uniquePostal.size());
//            for (Postal postal2 : uniquePostal) {
//                System.out.println(postal2);
//            }
//            List<Postal> updatedDataPostalList = regService.saveAllPostal(postalList);
//            if (updatedDataPostalList.size() == postalList.size()){
//                System.out.println(ANSIColors.ansiGreen + "Data Updated to Database Successfully.");
//            }
//            else {
//                System.out.println("Data Failed to Update to The Database!");
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }



    //    Final
    @GetMapping("postalHoMaster")
    public String postal(){
        System.out.println(ANSIColors.ansiRed + "Entering Into Postal Ho Method" + ANSIColors.ansiReset);
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
            Long count = 0L;
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

//            Removing Duplicate From List
            List<Postal> uniquePostal = postalList.stream()
                    .collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparingDouble(Postal::getOfcId))), ArrayList::new));

//            Setting Null Value to the ID
            for (Postal postal1 : uniquePostal) {
                postal1.setOfcId(null);
                System.out.println(postal1);
            }

            System.out.println("Unique Data Size : " + uniquePostal.size());
            for (Postal postal1 : uniquePostal) {
                System.out.println(postal1);
            }

            regService.saveAllPostal(uniquePostal);

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }



    //        PostalPo Data Insertion Against PostalHo(ForeignKey)
    @GetMapping("postalPoMaster")
    public String postalPo(){
        System.out.println(ANSIColors.ansiRed + "Entering Into Postal Po Method" + ANSIColors.ansiReset);
        List<PostalPo> postalPoList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\sambit.pradhan\\Documents\\a1.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(4);   //Starting from 4th Row
            int lastRowIndex = sheet.getLastRowNum() + 1;
            int totalNoOfCols = row.getLastCellNum() - 1;
            DataFormatter df = new DataFormatter();
            PostalPo postalPo;

            for (int i = 5; i< lastRowIndex; i++){
                postalPo = new PostalPo();
                for (int j = 1; j < totalNoOfCols; j++){
                    row = sheet.getRow(i);
                    String checkNullData = df.formatCellValue(row.getCell(4)).trim();
                    if (checkNullData != null && checkNullData != ""){
                        if (j == 4){
                            Cell cell = row.getCell(j);
                            String cellData = df.formatCellValue(cell).trim();
                            System.out.print(cellData + "|\t");
                            postalPo.setSoName(cellData);
                        }
                        else if (j == 2){
                            Cell cell = row.getCell(j);
                            String cellData = df.formatCellValue(cell).trim();
                            Postal postal = regService.findPostalHoByOfcName(cellData);
                            if (postal != null){
                                System.out.println("Data Found.");
                                postalPo.setHoId(postal);
                            }
                        }
                        else if (j == 10){
                            Cell cell = row.getCell(j);
                            String cellData = df.formatCellValue(cell).trim();
                            System.out.println(cellData);
                            postalPo.setSoPincode(cellData);
                            postalPo.setStatus("Active");
                            postalPo.setCreatedOn(new Date());
                        }
                    }
                    else {
                        postalPo = null;
                    }
                }
                postalPoList.add(postalPo);
            }

            System.out.println("Size of PostalHoList : " + postalPoList.size());

            for (PostalPo postalPo1 : postalPoList) {
                System.out.println(postalPo1);
            }

            System.out.println("Size Before Removing Null : " + postalPoList.size());
            postalPoList.removeAll(Collections.singleton(null));
            System.out.println("Size After Removing Null : " + postalPoList.size());

            regService.saveAllPostalPo(postalPoList);

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }





//    For Package Insertion
    @GetMapping("/packageInsert")
    public String packageInsert(){
        System.out.println("Inside Package Insert.");
        List<Package> packageList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\sambit.pradhan\\Downloads\\sheet2.xls");
            HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(2);
            int lastRowIndex = sheet.getLastRowNum() + 1;
            int totalNoOfCols = row.getLastCellNum();
            System.out.println("Last Row Index : " + lastRowIndex + ", Total No Of Columns : " + totalNoOfCols);
            DataFormatter df = new DataFormatter();
            for (int i = 1; i< lastRowIndex; i++) {
                Package package1 = new Package();
                for (int j = 0; j < totalNoOfCols; j++) {
                    row = sheet.getRow(i);
                    if (j == 0) {
                        System.out.println("NSIDE ++0");
                        Cell cell = row.getCell(j);
                        String cellData = df.formatCellValue(cell).trim();
                        System.out.println("Package Category Code : " + cellData);
                        package1.setCategoryCode(cellData);
                    } else if (j == 1) {
                        System.out.println("NSIDE--1");
                        Cell cell = row.getCell(j);
                        String cellData = df.formatCellValue(cell).trim();
                        System.out.println("Package Name : " + cellData);
                        package1.setPackageName(cellData);
                    } else if (j == 2) {
                        System.out.println("NSIDE===2");
                        Cell cell = row.getCell(j);
                        String cellData = df.formatCellValue(cell).trim();
                        System.out.println("Package ID : " + cellData);
                        package1.setPackId(cellData);
                    }
                }
                packageList.add(package1);
            }
            for (Package aPackage : packageList) {
                System.out.println(aPackage);
            }
            packageRepository.saveAll(packageList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


//    For Procedure Insertion
@GetMapping("/procedureInsert")
public String procedureInsert(){
    System.out.println("Inside Procedure Insert.");
    List<Procedure> procedureList = new ArrayList<>();
    try {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\sambit.pradhan\\Downloads\\sheet1.xls");
        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
        HSSFSheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(2);
        int lastRowIndex = sheet.getLastRowNum() + 1;
        int totalNoOfCols = row.getLastCellNum();
        System.out.println("Last Row Index : " + lastRowIndex + ", Total No Of Columns : " + totalNoOfCols);
        DataFormatter df = new DataFormatter();
        for (int i = 1; i< lastRowIndex; i++) {
            Procedure procedure = new Procedure();
            for (int j = 0; j < totalNoOfCols; j++) {
                row = sheet.getRow(i);
                if (j == 0) {
                    System.out.println("NSIDE ++0");
                    Cell cell = row.getCell(j);
                    String cellData = df.formatCellValue(cell).trim();
                    System.out.println("Procedure Id : " + cellData);
                    procedure.setId(Integer.parseInt(cellData));
                } else if (j == 1) {
                    System.out.println("NSIDE--1");
                    Cell cell = row.getCell(j);
                    String cellData = df.formatCellValue(cell).trim();
                    System.out.println("Procedure Name : " + cellData);
                    procedure.setProcedures(cellData);
                } else if (j == 2) {
                    System.out.println("NSIDE==2");
                    Cell cell = row.getCell(j);
                    String cellData = df.formatCellValue(cell).trim();
                    System.out.println("Procedure Category ID : " + cellData);
                    procedure.setPackageCategoryCode(cellData);
                }
            }
            procedureList.add(procedure);
        }
        for (Procedure procedure : procedureList) {
            System.out.println(procedure);
        }
        procedureRepository.saveAll(procedureList);
    }catch (Exception e){
        e.printStackTrace();
    }
    return null;
}
}
