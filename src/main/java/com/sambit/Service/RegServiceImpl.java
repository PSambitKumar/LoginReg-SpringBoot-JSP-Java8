package com.sambit.Service;

import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.*;
import com.sambit.Bean.ImageBean;
import com.sambit.Bean.LoginBean;
import com.sambit.Bean.PersonalDataBean;
import com.sambit.Bean.RegBean;
import com.sambit.CustomException.CustomException;
import com.sambit.Entity.*;
import com.sambit.Entity.Image;
import com.sambit.Repository.*;
import com.sambit.Utils.UserCodeGeneration;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegServiceImpl implements RegService{

    @Autowired
    RegRepository regRepository;

    @Autowired
    PostalPoRepository postalPoRepository;
    @Autowired
    LoginRepository loginRepository;
    @Autowired
    PersonalDataRepository personalDataRepository;
    @Autowired
    ImageRepository imageRepository;
    @Autowired
    private PostalRepository postalRepository;

    private Logger logger = LoggerFactory.getLogger(RegServiceImpl.class);

    @Override
    public String saveRegLoginData(RegBean regBean) {
        String res = null;
        int maxEmpId ;
        try {
            Reg reg = new Reg();
            reg.setUsername(regBean.getUsername());
            reg.setPassword(regBean.getPassword());
            reg.setName(regBean.getName());
            reg.setPhn(regBean.getPhn());
            reg.setEmail(regBean.getEmail());
            reg.setDept(regBean.getDept());
            reg.setDob(regBean.getDob());
            reg.setGender(regBean.getGender());
            try {
                maxEmpId = regRepository.maxSlno();
            }catch (Exception e){
                maxEmpId = 1;
            }
            System.out.println(maxEmpId);
            String userCode = UserCodeGeneration.UserCodeGenreationMethod(maxEmpId);
            System.out.println("UserCode: " + userCode);
            reg.setUserCode(userCode);
            Reg result = regRepository.save(reg);//It will save all data to an object of Reg ENTITY and print toString method
            System.out.println(result);
            System.out.println("Data Added to Registration Table!!");

            Login login = new Login();
            login.setUsername(regBean.getUsername());
            login.setPassword(regBean.getPassword());
            Login result1 = loginRepository.save(login);
            System.out.println("Data Added to Login Table!!");
            res = "Success";
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Data Doesn't Added to Database.");
        }
        return res;
    }

    @Override
    public LoginBean checkLoginData(LoginBean loginBean) {
        String username = loginBean.getUsername();
        String password = loginBean.getPassword();
        Login lb = loginRepository.findByUsernameAndPassword(username, password);
        LoginBean lb1 = new LoginBean();
        lb1.setUid(lb.getUid());
        lb1.setUsername(lb.getUsername());
        lb1.setPassword(lb.getPassword());
//        LoginBean lb = loginRepository.findByUsernameAndPassword(loginBean);
        return lb1;
    }

//    @Override
//    public RegBean getAllDataOfUser(LoginBean loginBean) {
//        String username = loginBean.getUsername();
//        String password = loginBean.getPassword();
//        Reg reg = regRepository.findAllByUsernameAndPassword(username, password);
//        RegBean rb = new RegBean();
//        rb.setSlno(reg.getSlno());
//        rb.setUsername(reg.getUsername());
//        rb.setPassword(reg.getPassword());
//        rb.setName(reg.getName());
//        rb.setEmail(reg.getEmail());
//        rb.setDept(reg.getDept());
//        rb.setGender(reg.getGender());
//        rb.setDob(reg.getDob());
//        return rb;
//    }

    @Override
    public List<Reg> getAllDataofUser(LoginBean loginBean) {
        String username = loginBean.getUsername();
        String password = loginBean.getPassword();
        List list = regRepository.findAllByUsernameAndPassword(username, password);

//        Send Data Batch Wise
//        int size = list.size();
//        int start = 0;
//        int end = 50;
//        while (start < size) {
//            System.out.println("start = " + start);
//            if (end > size) {
//                end = size;
//            }
//            List<Map<String, Object>> subList = list.subList(start, end);
//            System.out.println("subList = " + subList);
//            start = end;
//            end += 50;
//        }
        return list;
    }

    @Override
    public List<Reg> getDataOfUser(int slno) {
        return regRepository.findAllBySlno(slno);
    }

    @Override
    public List<Reg> getDataOfUserByPhn(String phn) {
        return  regRepository.findAllByPhn(phn);
    }

    @Override
    public List<Reg> getDataofUserByUamePassandName(String uname, String password, String name) {
        return regRepository.findAllByUsernameAndPasswordAndName(uname, password, name);
    }

    @Override
    public String savePersonalDetails(PersonalDataBean personalDataBean) {
        String result = "";
        try {
            PersonalData personalData = new PersonalData();
            personalData.setName(personalDataBean.getName());
            personalData.setPanId(personalDataBean.getPanId());
            personalData.setAdharNo(personalDataBean.getAdharNo());
            personalDataRepository.save(personalData);
            System.out.println("Data Added to Database!!");
            result = "Success";
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Data doesn't Added to Database!!");
            result = "Fail";
        }
        return result;
    }

    @Override
    public List<PersonalData> getAllPersonalDetails() {
        return personalDataRepository.findAll();
    }

    @Override
    public String saveImageData(ImageBean imageBean) {
        Image image1 = new Image();
        image1.setImageName(imageBean.getImageName());
        return "Image";
    }

    @Override
    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public List<Postal> saveAllPostal(List<Postal> postalList) {
        return postalRepository.saveAll(postalList);
    }
    @Override
    public Postal findPostalHoByOfcName(String ofcName) {
        return postalRepository.findPostalHoByOfcName(ofcName);
    }

    @Override
    public List<PostalPo> saveAllPostalPo(List<PostalPo> postalPoList) {
        return postalPoRepository.saveAll(postalPoList);
    }

    @Override
    public String recieveIntData(String x) {
        System.out.println(x);
        return null;
    }

    @Override
    public List<Reg> getAllRegList() {
        return regRepository.findAll();
    }

//    @Override
//    public List<String> findAllName() {
//        return regRepository.findAllName();
//    }

    @Override
    public void downloadCancelledPdf(HttpServletResponse httpServletResponse) {
        try {
            String imagePath = "C:\\RegistrationData\\images\\csm.jpg";
            Document myDoc = new Document(PageSize.A4);
            String fileName = "license_cancelled.pdf";
            PdfWriter writer = PdfWriter.getInstance(myDoc, httpServletResponse.getOutputStream());
            httpServletResponse.setContentType("application/pdf");
            httpServletResponse.addHeader("Content-Disposition", "attachment; filename=" + fileName);
            myDoc.open();

            com.itextpdf.text.Font f = new com.itextpdf.text.Font();
            com.itextpdf.text.Font myFont = new com.itextpdf.text.Font();
            myFont.setStyle(com.itextpdf.text.Font.BOLD);
            myFont.setSize(9);
            Paragraph p;

            myDoc.add(new Paragraph("\n\n"));

//	          Adding of Image
	 /*           Image image = Image.getInstance(imagePath);
	            image.scaleAbsoluteHeight(50);
	            image.scaleAbsoluteWidth(50);
	            image.setAlignment(Element.ALIGN_RIGHT);
	            myDoc.add(image);*/

//	          Adding of Header Part
	          /*  f.setSize(8);
	            f.setStyle(com.itextpdf.text.Font.ITALIC);
	            p = new Paragraph("Ph No. " + basicInformationLicenseeFinal.getAppliedBy().getMobile().trim() + ", Email: " + basicInformationLicenseeFinal.getAppliedBy().getEmail().trim(),f);
	            p.setAlignment(Element.ALIGN_RIGHT);
	            myDoc.add(p);*/

//	          Adding Space
            myDoc.add(new Paragraph("\n"));

//	          Adding Heading Paragraph
            f.setSize(10);
            f.setStyle(com.itextpdf.text.Font.ITALIC);
            // p = new Paragraph("CONTRACTOR DATABASE MANAGEMENT  OF ODISHA\n" + "OFFICE OF"+basicInformationLicenseFinal.getAuthId().getDesignationId().getDesignationName()+": "+basicInformationLicenseFinal.getCircleId().getCircleName() +"("+basicInformationLicenseFinal.getDeptId().getDeptName()+"\n",f);
            p = new Paragraph("GOVERNMENT OF ODISHA \n CONTRACTOR DATABASE MANAGEMENT SYSTEM \n" + "OFFICE OF \n",f);
            p.setAlignment(Element.ALIGN_CENTER);
            myDoc.add(p);

//	          Adding Space
            myDoc.add(new Paragraph("\n"));
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

//		          Adding Heading Paragraph
            f.setSize(10);
            f.setStyle(com.itextpdf.text.Font.ITALIC);
            // p = new Paragraph("CONTRACTOR DATABASE MANAGEMENT  OF ODISHA\n" + "OFFICE OF"+basicInformationLicenseFinal.getAuthId().getDesignationId().getDesignationName()+": "+basicInformationLicenseFinal.getCircleId().getCircleName() +"("+basicInformationLicenseFinal.getDeptId().getDeptName()+"\n",f);
            p = new Paragraph("CSF NO. : CSF NUMBER, "+"DATED  : Date\n",f);
            p.setAlignment(Element.ALIGN_CENTER);
            myDoc.add(p);

//		          Adding Space
            myDoc.add(new Paragraph("\n"));
            String licenseeNmae="Sambit Kumar Pradhan";
            String sonOrCeo=null;


                String gpNmae=null;
                String block=null;
                String distNmae=null;
                Integer pincodedt=null;
                String postname=null;

//      	          For Adding Body
                f.setSize(9);
                f.setStyle(com.itextpdf.text.Font.NORMAL);
    	          /*  p = new Paragraph("The "+basicInformationLicenseFinal.getClassId().getClassName()+" Contractor registration certificate issues vide this office registration No. " +
    	                   contractorCode+" in favour of "+ licenseeNmae+ " ,"+sonOrCeo+", At-:"+ gpNmae +", Post-:"+ postname +", " +
    	                   "Dist-: "+distNmae+", Odisha-: "+pincodedt+" is hearby Cancelled as per request of the Party.",f);
    	            */

                p = new Paragraph();
                p.add(new Chunk("              The  Contractor registration certificate issues vide this office  ", f));
                p.add(new Chunk(" registration No.  ", myFont));
                p.add(new Chunk( " in favour of ", f));
                p.add(new Chunk(licenseeNmae, myFont));
                p.add(new Chunk(" ,"+sonOrCeo+", At-:"+ gpNmae +", Post-:"+ postname +", " + "Dist-: "+distNmae+", Odisha-: "+pincodedt+" is hearby", f));
                p.add(new Chunk(" Cancelled", myFont));
                p.add(new Chunk(" as per request of the Party.", f));


                p.setAlignment(Element.ALIGN_JUSTIFIED);
                myDoc.add(p);

                myDoc.add(new Paragraph("\n\n"));




//	          Adding Signature Part
            f.setSize(9);
            f.setStyle(com.itextpdf.text.Font.NORMAL);
//            p = new Paragraph(
//                    basicInformationLicenseFinal.getAuthId().getDesignationId().getDesignationName()+"\n" +
//                            basicInformationLicenseFinal.getDeptId().getDeptName(),f);
            p.setAlignment(Element.ALIGN_RIGHT);
            myDoc.add(p);

            myDoc.add(new Paragraph("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"));

            f.setSize(9);
            f.setStyle(com.itextpdf.text.Font.NORMAL);
            p = new Paragraph("** This is system generated copy, does not required seal and signature.",f);
            p.setAlignment(Element.ALIGN_CENTER);
            myDoc.add(p);

            myDoc.close();

        }catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkUserIsPresentOrNot(String userName) {
        return regRepository.existsDistinctByUsername(userName);
    }

    @Override
    public Reg saveReg(Reg reg) {
        return regRepository.save(reg);
    }

    @Override
    public boolean deleteReg(int slNo) {
        Reg reg = regRepository.getById(slNo);
        regRepository.delete(reg);
        return !regRepository.existsById(slNo);
    }

    @Override
    public Reg getRegBySlNo(int slNo) {
        return regRepository.getById(slNo);
    }

    @Override
    public boolean checkRegIsPresentOrNotBySlNo(int slNo) {
        return regRepository.existsById(slNo);
    }

    @Override
    public List<Reg> getAllReg() {
        return regRepository.findAll();
    }

//    Excel File Generation From List of Data
    @Override
    public void generateRegistrationEXCELReport(HttpServletResponse response) {
        List<Reg> regList = regRepository.findAll();

        Workbook workbook=new XSSFWorkbook();
        Sheet sheet=workbook.createSheet("Registration Report");

        CellStyle headerCellStyle=workbook.createCellStyle();
        headerCellStyle.setFillBackgroundColor(IndexedColors.BLUE_GREY.getIndex());
        headerCellStyle.setFillPattern(FillPatternType.BIG_SPOTS);

        org.apache.poi.ss.usermodel.Font newFont=workbook.createFont();
        newFont.setBold(true);
        newFont.setColor(IndexedColors.WHITE.getIndex());
        newFont.setFontHeightInPoints((short)15);
        newFont.setItalic(true);

        headerCellStyle.setFont(newFont);
        Row headerRow=sheet.createRow(6);
        Row rows=sheet.createRow(0);
        Row rows1=sheet.createRow(2);

        Cell heading=rows.createCell(0);
        heading.setCellStyle(headerCellStyle);
        heading.setCellValue("Registration Report");


        Cell genCell=rows1.createCell(0);
        genCell.setCellStyle(headerCellStyle);
        genCell.setCellValue("Generated On:");
        rows1.createCell(1).setCellValue(new SimpleDateFormat("dd-MMM-yyyy").format(new Date()));

        String[] columns= {"Sl. No.","Name","Email","Mobile","Gender"};
        for(int i=0;i<columns.length;i++)
        {
            Cell cell=headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }
        int rowNum=7;
        int count=0;
        for(Reg reg:regList)
        {

            Row row=sheet.createRow(rowNum++);
            if(reg.getClass()!=null) {
                count=count+1;
                String s=String.valueOf(count);
                row.createCell(0).setCellValue(s.trim());

                if(reg.getSlno()!=0) {
                    row.createCell(1).setCellValue(reg.getName());
                }else {
                    row.createCell(1).setCellValue("-NA-");
                }

                if(reg.getEmail()!=null) {
                    row.createCell(2).setCellValue(reg.getEmail());
                }else {
                    row.createCell(2).setCellValue("-NA-");
                }

                if(reg.getPhn()!=null) {
                    row.createCell(3).setCellValue(reg.getPhn());
                }
                else {
                    row.createCell(3).setCellValue("-NA-");
                }

                if(reg.getGender() != null) {
                    row.createCell(4).setCellValue(reg.getGender());
                }
                else {
                    row.createCell(4).setCellValue("-NA-");
                }
            }
        }

        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        response.setContentType("application/vnd.ms-excel");

        String FILENAME = "RegistrationReport.xls";
        response.addHeader("Content-Disposition", "attachment; filename=" + FILENAME);
        try {
            workbook.write(response.getOutputStream());
            response.getOutputStream().flush();
            response.getOutputStream().close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        For Saving This File in Local
//        String path;
//        try {
//            String home = System.getProperty("user.home");
//            path = home + "/Desktop/" + fileName + ".xlsx";
//            System.out.println("Path: " + path);
//            File file = new File(path);
//            FileOutputStream fileOutputStream = new FileOutputStream(file);
//            workbook.write(fileOutputStream);
//            fileOutputStream.close();
//            workbook.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public void generateRegistrationPDFReport(HttpServletResponse response) throws DocumentException, IOException {
        Document myDoc=new Document(PageSize.A4);
        List<Reg> regList = regRepository.findAll();
        String fileName="RegistrationReport.pdf";
        PdfWriter writer=PdfWriter.getInstance(myDoc, response.getOutputStream());
        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "attachment; filename="+fileName);
        myDoc.open();

        PdfPTable imagetable=new PdfPTable(2);
        imagetable.setWidthPercentage(100);
        String filename="C:\\Users\\sambit.pradhan\\Pictures\\csm.jpg";
        com.itextpdf.text.Image image= com.itextpdf.text.Image.getInstance(filename);
        image.scaleAbsoluteHeight(400);
        image.scaleAbsoluteWidth(400);
        image.setAlignment(Element.ALIGN_LEFT);
        PdfPCell imagecell=new PdfPCell();
        imagecell.addElement(image);
        imagecell.setBorder(0);
        imagecell.setPaddingLeft(100f);
        imagetable.addCell(imagecell);

        PdfPCell textcell=new PdfPCell();
        com.itextpdf.text.Font  header = new com.itextpdf.text.Font();
        header.setColor(BaseColor.BLACK);
        header.setSize(30);
        textcell.setPaddingTop(25f);
        textcell.setPaddingLeft(0);
        textcell.addElement(new Paragraph("Sambit",header));


        com.itextpdf.text.Font  subheading = new com.itextpdf.text.Font();
        subheading.setColor(BaseColor.BLACK);
        subheading.setSize(18);
        textcell.addElement(new Paragraph("Registration Data",subheading));
        textcell.setPaddingLeft(5);
        textcell.setBorder(0);
        imagetable.addCell(textcell);
        myDoc.add(imagetable);

        myDoc.add(Chunk.NEWLINE);
        myDoc.add(new Paragraph("Registration Data Report"));

        com.itextpdf.text.Font  f = new com.itextpdf.text.Font();
        f.setStyle(com.itextpdf.text.Font.BOLD);
        f.setSize(15);
        Paragraph p=new Paragraph("Registration Data Report",f);
        p.setAlignment(Element.ALIGN_CENTER);

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(0);
        table.setWidthPercentage(100);

        PdfPCell cell1 = new PdfPCell(new Paragraph("Generated On:"));
        cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell1.setPaddingLeft(10);
        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell1);

        PdfPCell cell2 = new PdfPCell(new Paragraph(new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(new Date())));
        cell2.setPaddingLeft(10);
        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell2);

        table.addCell(new Paragraph(" "));
        table.addCell(new Paragraph(" "));

        PdfPCell cell3 = new PdfPCell(new Paragraph("Generated By:"));
        cell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell3.setPaddingLeft(10);
        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell3);


        PdfPCell cell4 = new PdfPCell(new Paragraph("Sambit"));
        cell4.setPaddingLeft(10);
        cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell4);

        table.addCell(new Paragraph(" "));
        table.addCell(new Paragraph(" "));


        table.addCell(new Paragraph(" "));
        table.addCell(new Paragraph(" "));

        myDoc.add(table);
        PdfPTable space = new PdfPTable(1);

        space.getDefaultCell().setFixedHeight(65);
        space.setWidthPercentage(100);
        space.getDefaultCell().setBorder(Rectangle.OUT_BOTTOM);
        space.getDefaultCell().setBorderColor(BaseColor.LIGHT_GRAY);
        PdfPCell spaceCell = new PdfPCell(new Paragraph(" "));
        space.addCell(spaceCell);
        myDoc.add(space);



        com.itextpdf.text.Font headingfont= FontFactory.getFont(FontFactory.COURIER, 8);
        headingfont.setStyle(com.itextpdf.text.Font.BOLD);
        headingfont.setSize(12);

        com.itextpdf.text.Font font=(com.itextpdf.text.Font) FontFactory.getFont(FontFactory.COURIER, 8);


        PdfPTable table1 = new PdfPTable(5);
        table1.setWidthPercentage(100);
        table1.setSpacingBefore(0);
        table1.setSpacingAfter(0);
        table1.setWidthPercentage(100);

        String[] columns = { "SlNo.", "Name", "Email", "Mobile","Gender"
        };
        for (String column : columns) {
            PdfPCell cell = new PdfPCell(new Paragraph(column, headingfont));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setPaddingLeft(10);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table1.addCell(cell);
        }
        int slNO=1;
        if(regList!=null) {
            for(Reg reg:regList) {
                PdfPCell cellRow1=new PdfPCell(new Paragraph(String.valueOf(slNO)));

                cellRow1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellRow1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table1.addCell(cellRow1);

                PdfPCell cellRow2 = new PdfPCell(new Paragraph(reg.getName()!=null?reg.getName():"-NA-",font));

                cellRow2.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellRow2.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table1.addCell(cellRow2);

                PdfPCell cellRow3 = new PdfPCell(new Paragraph(reg.getEmail()!=null?reg.getEmail().toString():"-NA-",font));
                cellRow3.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellRow3.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table1.addCell(cellRow3);

                PdfPCell cellRow4 = new PdfPCell(new Paragraph(reg.getPhn()!=null?reg.getPhn():"-NA-",font));
                cellRow4.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellRow4.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table1.addCell(cellRow4);

                PdfPCell cellRow5 = new PdfPCell(new Paragraph(reg.getGender() == null?reg.getGender():"-NA-",font));
                cellRow5.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellRow5.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table1.addCell(cellRow5);

                slNO++;
            }
        }
        myDoc.add(table1);

        com.itextpdf.text.Font footer=(com.itextpdf.text.Font) FontFactory.getFont(FontFactory.COURIER, 8);
        footer.setSize(15);
        footer.setStyle(com.itextpdf.text.Font.BOLD);

        PdfPTable signtable=new PdfPTable(1);
        PdfPCell newcell=new PdfPCell();
        newcell.addElement(new Paragraph("Auth Sign",footer));
        newcell.setVerticalAlignment(Element.ALIGN_RIGHT);
        newcell.setBorder(0);
        newcell.setPaddingTop(30f);
        newcell.setPaddingLeft(400f);
        signtable.addCell(newcell);
        signtable.setWidthPercentage(100);
        myDoc.add(signtable);

        myDoc.close();
    }

    @Override
    public boolean checkRegIsPresentOrNotByUserCode(String userCode) {
        return regRepository.existsDistinctByUserCode(userCode);
    }

    @Override
    public Reg getRegByUserCode(String userCode) {
        return regRepository.findByUserCode(userCode);
    }


//    For Study Purpose of Joining Table
//    public String study(){
//        List<Object[]> objects = hospitalInformationRepository.getHospitalInformationByDcId(userId);
//        System.out.println("objects::"+objects);
//        for (Object[] object : objects) {
//            JSONObject jsonObject1 = new JSONObject();
//            jsonObject1.put("hospitalCode", object[0]);
//            jsonObject1.put("hospitalName", object[1]);
//            jsonObject1.put("stateName", object[2]);
//            jsonObject1.put("districtName", object[3]);
//            jsonObject1.put("status", object[4]);
//            System.out.println("jsonObject1 : "+jsonObject1);
//            jsonArray1.put(jsonObject1);
//        }
//        System.out.println("JSON Array1::" + jsonArray1);
//    }

    @Override
    public void generatePDF(JSONArray reports, String header, HttpServletResponse httpServletResponse) {
        try {
            Document myDoc=new Document(PageSize.A4);
            String fileName="CPDApprovalClaimList.pdf";
            PdfWriter writer=PdfWriter.getInstance(myDoc, httpServletResponse.getOutputStream());
            httpServletResponse.setContentType("application/pdf");
            httpServletResponse.addHeader("Content-Disposition", "inline; filename="+fileName);
            myDoc.open();

            Paragraph p = new Paragraph("CPD Approval Claim List", FontFactory.getFont("Arial", 14, Font.BOLD));
            p.setAlignment(Element.ALIGN_CENTER);
            myDoc.add(p);
            myDoc.add(new Paragraph(" "));

            com.itextpdf.text.Font headingfont= FontFactory.getFont(String.valueOf(FontFactory.getFont("Arial")), 12);
            com.itextpdf.text.Font font= FontFactory.getFont(String.valueOf(FontFactory.getFont("Arial")), 10);

            PdfPTable table = new PdfPTable(7);
            table.setWidthPercentage(110);
            table.setSpacingBefore(0);
            table.setSpacingAfter(0);
            table.setHorizontalAlignment(Element.ALIGN_CENTER);

            String[] columns = new String[] { "Sl No", "Claim No", "URN", "Patient Name", "Invoice No", "Allotted Date", "Action to be Taken By"};

            for (int i = 0; i < columns.length; i++) {
                PdfPCell cell = new PdfPCell(new Paragraph(columns[i],headingfont));
                cell.setBackgroundColor(new BaseColor(1, 200, 1));
                cell.setPaddingLeft(4);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table.addCell(cell);
            }
            int slNO=1;

            for (int i = 0; i < reports.length(); i++) {
                JSONObject jsonObject = reports.getJSONObject(i);
                table.addCell(new Paragraph(String.valueOf(slNO),font));
                table.addCell(new Paragraph(jsonObject.getString("Claim No"),font));
                table.addCell(new Paragraph(jsonObject.getString("URN"),font));
                table.addCell(new Paragraph(jsonObject.getString("Patient Name"),font));
                table.addCell(new Paragraph(jsonObject.getString("Invoice No"),font));
                table.addCell(new Paragraph(jsonObject.getString("Allotted Date"),font));
                table.addCell(new Paragraph(jsonObject.getString("Action to be Taken By"),font));
                slNO++;
            }
            myDoc.add(table);
            myDoc.close();
        } catch (Exception e) {
            logger.error("Exception in generatePDF() method", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void generatePDF1(JSONArray reports, JSONArray header, HttpServletResponse httpServletResponse) throws JSONException {
        header = new JSONArray();
        header.put("report_id");
        header.put("report_name");
        header.put("report_value");

        reports = new JSONArray();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            JSONObject report = new JSONObject();
            report.put("report_id", "RPT" + (i + 1));
            report.put("report_name", "Report " + (i + 1));
            report.put("report_value", random.nextInt(100)); // Random value for report
            reports.put(report);
        }

        String[] columns = new String[header.length()];
        try {
            Document myDoc = new Document(PageSize.A4);
            String fileName = "BSKY Summery Report List.pdf";
            OutputStream outputStream = Files.newOutputStream(Paths.get("D:/BSKY Summery Report List.pdf"));
            PdfWriter writer = PdfWriter.getInstance(myDoc, httpServletResponse.getOutputStream());
            httpServletResponse.setContentType("application/pdf");
            httpServletResponse.setHeader("Content-Disposition", "attachment; filename=" + "\"" + fileName + "\"");
            myDoc.open();

            com.itextpdf.text.Image backgroundImage = com.itextpdf.text.Image.getInstance("E:\\My CSM Project\\BSKY Project\\TMS Web\\TMS Frontend\\src\\assets\\images\\fade-logo.png");
            backgroundImage.scaleToFit(500, 500);
            backgroundImage.setAbsolutePosition((myDoc.getPageSize().getWidth() - backgroundImage.getScaledWidth()) / 2,
                    (myDoc.getPageSize().getHeight() - backgroundImage.getScaledHeight()) / 2);

            PdfTemplate backgroundTemplate = writer.getDirectContent().createTemplate(
                    myDoc.getPageSize().getWidth(), myDoc.getPageSize().getHeight()
            );
            backgroundTemplate.addImage(backgroundImage);

            PdfContentByte canvas = writer.getDirectContentUnder();
            canvas.addTemplate(backgroundTemplate, 0, 0);

            Paragraph p = new Paragraph("BSKY Summery Report List", FontFactory.getFont("Segoe UI", 14, Font.BOLD));
            p.setAlignment(Element.ALIGN_CENTER);
            myDoc.add(p);
            myDoc.add(new Paragraph(" "));

            Font headingfont = FontFactory.getFont(String.valueOf(FontFactory.getFont("Segoe UI")), 12);
            Font font = FontFactory.getFont(String.valueOf(FontFactory.getFont("Segoe UI")), 10);

            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(110);
            table.setSpacingBefore(0);
            table.setSpacingAfter(0);
            table.setHorizontalAlignment(Element.ALIGN_CENTER);

            for (int i = 0; i < header.length(); i++) {
                columns[i] = header.getString(i);
            }

            for (String column : columns) {
                PdfPCell cell = new PdfPCell(new Paragraph(column, headingfont));
                cell.setPaddingLeft(4);
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table.addCell(cell);
            }
            int slNO = 1;

            for (int i = 0; i < reports.length(); i++) {
                JSONObject jsonObject = reports.getJSONObject(i);
                for (String column : columns) {
                    table.addCell(new Paragraph(jsonObject.getString(column), font));
                }
                slNO++;
            }
            myDoc.add(table);
            myDoc.close();
            outputStream.close();
        } catch (Exception e) {
            logger.error("Exception in generatePDF() method of CPDClaimProcessingServiceImpl" + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void generatePDF2(JSONArray reports, JSONArray header, HttpServletResponse httpServletResponse) throws JSONException {
        header = new JSONArray();
        header.put("SL#");
        header.put("Beneficiary Dist");
        header.put("Total Family treated Till Now");
        header.put("Total Beneficiary treated Till Now");
        header.put("Total Package Discharged Till Now");
        header.put("Amount of Discharge Till Now");

        JSONObject report1 = new JSONObject();
        report1.put("SL#", 1);
        report1.put("Beneficiary Dist", "Cuttack");
        report1.put("Total Family treated Till Now", 23123);
        report1.put("Total Beneficiary treated Till Now", 45345);
        report1.put("Total Package Discharged Till Now", 6786786);
        report1.put("Amount of Discharge Till Now", 78978);
        reports.put(report1);

        JSONObject report2 = new JSONObject();
        report2.put("SL#", 2);
        report2.put("Beneficiary Dist", "Khurdha");
        report2.put("Total Family treated Till Now", 12334);
        report2.put("Total Beneficiary treated Till Now", 6756756);
        report2.put("Total Package Discharged Till Now", 89789);
        report2.put("Amount of Discharge Till Now", 45646);
        reports.put(report2);

        Map<String, Object> map = new LinkedHashMap<>();
        map.put("header", header);
        map.put("report", reports);
        map.put("id", 1);
        map.put("heading", "BSKY – Transaction Summary From Starting to 31-April-2024 For All Scheme");

        List<Map<String, Object>> list = new ArrayList<>();
        list.add(map);

//        Report 2 Data
        JSONArray reports1 = new JSONArray();
        JSONArray header1 = new JSONArray();
        header1.put("SL#");
        header1.put("Beneficiary Dist");
        header1.put("Total Family treated Till Now");
        header1.put("Total Beneficiary treated Till Now");
        header1.put("Total Package Discharged Till Now");
        header1.put("Amount of Discharge Till Now");
        header1.put("Total No of Claim Submitted");
        header1.put("Amount of Claim Submitted");

        JSONObject report3 = new JSONObject();
        report3.put("SL#", 1);
        report3.put("Beneficiary Dist", "Cuttack");
        report3.put("Total Family treated Till Now", 23123);
        report3.put("Total Beneficiary treated Till Now", 45345);
        report3.put("Total Package Discharged Till Now", 6786786);
        report3.put("Amount of Discharge Till Now", 78978);
        report3.put("Total No of Claim Submitted", 78978);
        report3.put("Amount of Claim Submitted", 78978);
        reports1.put(report3);

        JSONObject report4 = new JSONObject();
        report4.put("SL#", 2);
        report4.put("Beneficiary Dist", "Khurdha");
        report4.put("Total Family treated Till Now", 12334);
        report4.put("Total Beneficiary treated Till Now", 6756756);
        report4.put("Total Package Discharged Till Now", 89789);
        report4.put("Amount of Discharge Till Now", 45646);
        report4.put("Total No of Claim Submitted", 45646);
        report4.put("Amount of Claim Submitted", 45646);
        reports1.put(report4);

        Map<String, Object> map1 = new LinkedHashMap<>();
        map1.put("header", header1);
        map1.put("report", reports1);
        map1.put("id", 2);
        map1.put("heading", "BSKY – Monthly Summary From  01-April-2024 to 31-April-2024 For All Scheme");
        list.add(map1);

//        Report 3 Data
        JSONArray header2 = new JSONArray();
        header2.put("SL#");
        header2.put("Speciality Name");
        header2.put("Total Discharge");
        header2.put("Discharge Amount");

        JSONArray reports2 = new JSONArray();

        JSONObject report5 = new JSONObject();
        report5.put("SL#", 1);
        report5.put("Speciality Name", "BM");
        report5.put("Total Discharge", 123123);
        report5.put("Discharge Amount", 23432);
        reports2.put(report5);

        JSONObject report6 = new JSONObject();
        report6.put("SL#", 2);
        report6.put("Speciality Name", "SN");
        report6.put("Total Discharge", 4525);
        report6.put("Discharge Amount", 523);
        reports2.put(report6);

        JSONObject report7 = new JSONObject();
        report7.put("SL#", 3);
        report7.put("Speciality Name", "FG");
        report7.put("Total Discharge", 45523);
        report7.put("Discharge Amount", 3455);
        reports2.put(report7);

        Map<String, Object> map2 = new LinkedHashMap<>();
        map2.put("header", header2);
        map2.put("report", reports2);
        map2.put("id", 4);
        map2.put("heading", "Top 10 Speciality used from 01-April-2024 to 31-April-2024 – For All Scheme");
        list.add(map2);

//Report 4 Data
        JSONArray header3 = new JSONArray();
        header3.put("SL#");
        header3.put("Hospital State");
        header3.put("Hospital District");
        header3.put("Total No of Discharge");
        header3.put("Discharge Amount");

        // Create the reports array
        JSONArray reports3 = new JSONArray();

        // Generate random data for 20 reports
        for (int i = 0; i < 20; i++) {
            JSONObject report = new JSONObject();
            report.put("SL#", i + 1); // Incrementing SL# starting from 1

            // Generating random Hospital State and District
            String[] states = {"Odisha", "Andhra Pradesh", "Tamil Nadu", "Karnataka"};
            String[] districts = {"Cuttack", "Khordha", "Puri", "Bhubaneswar"};
            Random random = new Random();
            String hospitalState = states[random.nextInt(states.length)];
            String hospitalDistrict = districts[random.nextInt(districts.length)];

            // Generating random Total No of Discharge and Discharge Amount
            int totalDischarge = random.nextInt(100000);
            int dischargeAmount = random.nextInt(10000);

            // Putting data into the JSON object
            report.put("Hospital State", hospitalState);
            report.put("Hospital District", hospitalDistrict);
            report.put("Total No of Discharge", totalDischarge);
            report.put("Discharge Amount", dischargeAmount);

            // Adding the report to the reports JSONArray
            reports3.put(report);
        }

        // Create the JSON object to hold the header and reports
        Map<String, Object> map3 = new LinkedHashMap<>();
        map3.put("header", header3);
        map3.put("report", reports3);
        map3.put("id", 3);
        map3.put("heading", "Top 20 Hospital Having highest Amount of Discharge from 01-April-2024 to 31-April-2024 – For All Scheme");

        list.add(map3);

        try {
            Document myDoc = new Document(PageSize.A4);
            String fileName = "BSKY Summery Report List.pdf";
            OutputStream outputStream = Files.newOutputStream(Paths.get("D:/BSKY Summery Report.pdf"));
            PdfWriter writer = PdfWriter.getInstance(myDoc, httpServletResponse.getOutputStream());
            httpServletResponse.setContentType("application/pdf");
            httpServletResponse.setHeader("Content-Disposition", "attachment; filename=" + "\"" + fileName + "\"");
            myDoc.open();

            com.itextpdf.text.Image backgroundImage = com.itextpdf.text.Image.getInstance("E:\\My CSM Project\\BSKY Project\\TMS Web\\TMS Frontend\\src\\assets\\images\\fade-logo.png");
            backgroundImage.scaleToFit(500, 500);
            backgroundImage.setAbsolutePosition((myDoc.getPageSize().getWidth() - backgroundImage.getScaledWidth()) / 2,
                    (myDoc.getPageSize().getHeight() - backgroundImage.getScaledHeight()) / 2);

            PdfTemplate backgroundTemplate = writer.getDirectContent().createTemplate(
                    myDoc.getPageSize().getWidth(), myDoc.getPageSize().getHeight()
            );
            backgroundTemplate.addImage(backgroundImage);

            PdfContentByte canvas = writer.getDirectContentUnder();
            canvas.addTemplate(backgroundTemplate, 0, 0);

            Paragraph p = new Paragraph("BSKY Summery Report", FontFactory.getFont("Segoe UI", 18, Font.BOLD, new BaseColor(0, 102, 0)));
            p.setAlignment(Element.ALIGN_CENTER);
            myDoc.add(p);

            Paragraph p1 = new Paragraph("Document Generated On: " + new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(new Date()), FontFactory.getFont("Segoe UI", 10, Font.NORMAL, BaseColor.BLACK));
            p1.setAlignment(Element.ALIGN_CENTER);
            myDoc.add(p1);

            myDoc.add(new Paragraph(" "));

            Font subjectfont = FontFactory.getFont(String.valueOf(FontFactory.getFont("Segoe UI")), 12, Font.BOLD);
            Font headingfont = FontFactory.getFont(String.valueOf(FontFactory.getFont("Segoe UI")), 10, Font.BOLD);
            Font font = FontFactory.getFont(String.valueOf(FontFactory.getFont("Segoe UI")), 10);

            for (Map<String, Object> mapData : list) {
                JSONArray headerData = (JSONArray) mapData.get("header");
                JSONArray reportData = (JSONArray) mapData.get("report");

                PdfPTable table = new PdfPTable(headerData.length());
                table.setWidthPercentage(110);
                table.setSpacingBefore(0);
                table.setSpacingAfter(0);
                table.setHorizontalAlignment(Element.ALIGN_CENTER);

                PdfPCell headerCell = new PdfPCell(new Paragraph((String) mapData.get("heading"), subjectfont));
                headerCell.setPadding(5);
                headerCell.setBackgroundColor((Integer) mapData.get("id") == 1
                                ? new BaseColor(198, 235, 198)
                                : ((Integer) mapData.get("id") == 2
                                ? new BaseColor(255, 204, 204)
                                : ((Integer) mapData.get("id") == 3
                                ? new BaseColor(193, 193, 240)
                                : new BaseColor(255, 255, 179))
                        )
                );
                headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                headerCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                headerCell.setColspan(headerData.length()); // Merge all columns
                table.addCell(headerCell);

                String[] columns = new String[headerData.length()];
                for (int i = 0; i < headerData.length(); i++) {
                    columns[i] = headerData.getString(i);
                }

                for (String column : columns) {
                    PdfPCell cell = new PdfPCell(new Paragraph(column, headingfont));
                    cell.setPaddingLeft(4);
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    table.addCell(cell);
                }

                int slNO = 1;

                for (int i = 0; i < reportData.length(); i++) {
                    JSONObject jsonObject = reportData.getJSONObject(i);
                    for (String column : columns) {
                        table.addCell(new Paragraph(jsonObject.getString(column), font));
                    }
                    slNO++;
                }
                myDoc.add(table);
                myDoc.add(new Paragraph(" "));
            }
            myDoc.close();
            outputStream.close();
        } catch (Exception e) {
            logger.error("Exception in generatePDF() method of CPDClaimProcessingServiceImpl" + e);
            throw new RuntimeException(e);
        }
    }

    public String generateHospitalTransactionPDF(List<Map<String, Object>> list) throws JSONException {
        list = new ArrayList<>();
//        For Table 1
        JSONArray header = new JSONArray();
        header.put("SL#");
        header.put("Activity");
        header.put("NFSA/SFSA");
        header.put("NABIN");

        JSONArray report = new JSONArray();

        JSONObject dataObject = new JSONObject();
        dataObject.put("SL#", 1);
        dataObject.put("Activity", "Total Family Treated");
        dataObject.put("NFSA/SFSA", 126737);
        dataObject.put("NABIN", 4564);
        report.put(dataObject);

        dataObject = new JSONObject();
        dataObject.put("SL#", 2);
        dataObject.put("Activity", "Total Patient Treated");
        dataObject.put("NFSA/SFSA", 126737);
        dataObject.put("NABIN", 4564);
        report.put(dataObject);

        dataObject = new JSONObject();
        dataObject.put("SL#", 3);
        dataObject.put("Activity", "Total Package Discharged");
        dataObject.put("NFSA/SFSA", 126737);
        dataObject.put("NABIN", 4564);
        report.put(dataObject);

        dataObject = new JSONObject();
        dataObject.put("SL#", 4);
        dataObject.put("Activity", "Amount of Discharge");
        dataObject.put("NFSA/SFSA", 126737);
        dataObject.put("NABIN", 4564);
        report.put(dataObject);

        Map<String, Object> map = new LinkedHashMap<>();
        map.put("header", header);
        map.put("report", report);
        map.put("id", 1);
        map.put("heading", "Outside Odisha Transaction Details from Starting to 31-April-2024 ");
        list.add(map);

//        For Table 2
        header = new JSONArray();
        header.put("SL#");
        header.put("Activity");
        header.put("NFSA/SFSA");
        header.put("NABIN");

        report = new JSONArray();

        dataObject = new JSONObject();
        dataObject.put("SL#", 1);
        dataObject.put("Activity", "Total Family Treated");
        dataObject.put("NFSA/SFSA", 126737);
        dataObject.put("NABIN", 4564);
        report.put(dataObject);

        dataObject = new JSONObject();
        dataObject.put("SL#", 2);
        dataObject.put("Activity", "Total Patient Treated");
        dataObject.put("NFSA/SFSA", 126737);
        dataObject.put("NABIN", 4564);
        report.put(dataObject);

        dataObject = new JSONObject();
        dataObject.put("SL#", 3);
        dataObject.put("Activity", "Total Package Discharged");
        dataObject.put("NFSA/SFSA", 126737);
        dataObject.put("NABIN", 4564);
        report.put(dataObject);

        dataObject = new JSONObject();
        dataObject.put("SL#", 4);
        dataObject.put("Activity", "Amount of Discharge");
        dataObject.put("NFSA/SFSA", 126737);
        dataObject.put("NABIN", 4564);
        report.put(dataObject);

        map = new LinkedHashMap<>();
        map.put("header", header);
        map.put("report", report);
        map.put("id", 2);
        map.put("heading", "Outside Odisha Transaction Details from 01-April-2024 to 31-April-2024");
        list.add(map);

//        For Table 3
        header = new JSONArray();
        header.put("SL#");
        header.put("Hospital State");
        header.put("Hospital District");
        header.put("Hospital Code");
        header.put("Hospital Name");
        header.put("Total No of Discharge");
        header.put("Total Amount of Discharge");
        header.put("Total No of Discharge1");
        header.put("Total Amount of Discharge1");

        String[] hospitalDataHeaders = new String[]
                {
                        "SL#",
                        "Hospital State",
                        "Hospital District",
                        "Hospital Code",
                        "Hospital Name",
                        "NFSA/SFSA",
                        "NABIN"
                };
        String[] hospitalDataSubHeaders = new String[]
                {
                        "SL#",
                        "Hospital State",
                        "Hospital District",
                        "Hospital Code",
                        "Hospital Name",
                        "Total No of Discharge",
                        "Total Amount of Discharge",
                        "Total No of Discharge",
                        "Total Amount of Discharge"
                };

        List<JSONArray> jsonArrayList = new ArrayList<>();
        JSONArray dataJSONArray = new JSONArray();
        dataObject = new JSONObject();
        dataObject.put("SL#", 1);
        dataObject.put("Hospital State", "Odisha");
        dataObject.put("Hospital District", "Khurdha");
        dataObject.put("Hospital Code", 21193472);
        dataObject.put("Hospital Name", "Sahoo Vikari Seva Sadan");
        dataObject.put("Hospital Name", "Sahoo Vikari Seva Sadan");
        dataObject.put("Total No of Discharge", 21312);
        dataObject.put("Total Amount of Discharge", 35345354);
        dataObject.put("Total No of Discharge1", 21312);
        dataObject.put("Total Amount of Discharge1", 35345354);
        dataJSONArray.put(dataObject);

        dataObject = new JSONObject();
        dataObject.put("SL#", 1);
        dataObject.put("Hospital State", "Odisha");
        dataObject.put("Hospital District", "Khurdha");
        dataObject.put("Hospital Code", 21193472);
        dataObject.put("Hospital Name", "Sahoo Vikari Seva Sadan");
        dataObject.put("Hospital Name", "Sahoo Vikari Seva Sadan");
        dataObject.put("Total No of Discharge", 5345);
        dataObject.put("Total Amount of Discharge", 34534)
        ;dataObject.put("Total No of Discharge1", 456);
        dataObject.put("Total Amount of Discharge1", 4563456);
        dataJSONArray.put(dataObject);
        jsonArrayList.add(dataJSONArray);

        dataJSONArray = new JSONArray();
        dataObject = new JSONObject();
        dataObject.put("SL#", 2);
        dataObject.put("Hospital State", "Odisha");
        dataObject.put("Hospital District", "Khurdha");
        dataObject.put("Hospital Code", 21193472);
        dataObject.put("Hospital Name", "Sahoo Vikari Seva Sadan");
        dataObject.put("Hospital Name", "Sahoo Vikari Seva Sadan");
        dataObject.put("Total No of Discharge", 4356);
        dataObject.put("Total Amount of Discharge", 3645465);
        dataObject.put("Total No of Discharge1", 4564);
        dataObject.put("Total Amount of Discharge1", 345635);
        dataJSONArray.put(dataObject);

        dataObject = new JSONObject();
        dataObject.put("SL#", 3);
        dataObject.put("Hospital State", "Odisha");
        dataObject.put("Hospital District", "Khurdha");
        dataObject.put("Hospital Code", 21193472);
        dataObject.put("Hospital Name", "Sahoo Vikari Seva Sadan");
        dataObject.put("Hospital Name", "Sahoo Vikari Seva Sadan");
        dataObject.put("Total No of Discharge", 9678);
        dataObject.put("Total Amount of Discharge", 456356)
        ;dataObject.put("Total No of Discharge1", 75467);
        dataObject.put("Total Amount of Discharge1", 6345634);
        dataJSONArray.put(dataObject);

        dataJSONArray = new JSONArray();
        dataObject = new JSONObject();
        dataObject.put("SL#", 1);
        dataObject.put("Hospital State", "Odisha");
        dataObject.put("Hospital District", "Khurdha");
        dataObject.put("Hospital Code", 21193472);
        dataObject.put("Hospital Name", "Sahoo Vikari Seva Sadan");
        dataObject.put("Hospital Name", "Sahoo Vikari Seva Sadan");
        dataObject.put("Total No of Discharge", 235423);
        dataObject.put("Total Amount of Discharge", 23542354);
        dataObject.put("Total No of Discharge1", 7568);
        dataObject.put("Total Amount of Discharge1", 235422);
        dataJSONArray.put(dataObject);

        dataObject = new JSONObject();
        dataObject.put("SL#", 4);
        dataObject.put("Hospital State", "Odisha");
        dataObject.put("Hospital District", "Khurdha");
        dataObject.put("Hospital Code", 21193472);
        dataObject.put("Hospital Name", "Sahoo Vikari Seva Sadan");
        dataObject.put("Hospital Name", "Sahoo Vikari Seva Sadan");
        dataObject.put("Total No of Discharge", 25423);
        dataObject.put("Total Amount of Discharge", 78567476)
        ;dataObject.put("Total No of Discharge1", 32542);
        dataObject.put("Total Amount of Discharge1", 745674);
        dataJSONArray.put(dataObject);
        jsonArrayList.add(dataJSONArray);

        map = new LinkedHashMap<>();
        map.put("header", header);
        map.put("hospitalDataHeaders", hospitalDataHeaders);
        map.put("hospitalDataSubHeaders", hospitalDataSubHeaders);
        map.put("report", jsonArrayList);
        map.put("id", 3);
        map.put("heading", "Outside Odisha – Hospital District Wise Discharge from 01-April-2024  to 31-April-2024  ");
        list.add(map);

        String filePath = "C:\\BSKY\\WhatsAppDoc\\BSKY Summary Report24.pdf";
        try {
            Document myDoc = new Document(PageSize.A4);
            OutputStream outputStream = Files.newOutputStream(Paths.get(filePath));
            PdfWriter writer = PdfWriter.getInstance(myDoc, outputStream);
            myDoc.open();

            com.itextpdf.text.Image backgroundImage = com.itextpdf.text.Image.getInstance("C:\\BSKY\\WhatsAppDoc\\Images\\fade-logo.png");
            backgroundImage.scaleToFit(400, 400);
            backgroundImage.setAbsolutePosition((myDoc.getPageSize().getWidth() - backgroundImage.getScaledWidth()) / 2,
                    (myDoc.getPageSize().getHeight() - backgroundImage.getScaledHeight()) / 2);

            com.itextpdf.text.Image backgroundImage1 = com.itextpdf.text.Image.getInstance("C:\\BSKY\\WhatsAppDoc\\Images\\top-pattern.png");
            backgroundImage1.scaleToFit(250, 250);
            backgroundImage1.setAbsolutePosition(0, myDoc.getPageSize().getHeight() - backgroundImage1.getScaledHeight());

            PdfTemplate backgroundTemplate = writer.getDirectContent().createTemplate(
                    myDoc.getPageSize().getWidth(), myDoc.getPageSize().getHeight()
            );

            backgroundTemplate.addImage(backgroundImage);
            backgroundTemplate.addImage(backgroundImage1);

            PdfContentByte canvas = writer.getDirectContentUnder();

            canvas.addTemplate(backgroundTemplate, 0, 0);

            Paragraph p = new Paragraph("BSKY SUMMARY REPORT", FontFactory.getFont("Segoe UI", 20, Font.BOLD, new BaseColor(0, 102, 0)));
            p.setAlignment(Element.ALIGN_CENTER);

            Paragraph p1 = new Paragraph("Document Generated On: " + new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(new Date()), FontFactory.getFont("Segoe UI", 10, Font.NORMAL, BaseColor.BLACK));
            p1.setAlignment(Element.ALIGN_CENTER);

            myDoc.add(p);
            myDoc.add(p1);
            myDoc.add(new Paragraph(" "));

            Font subjectfont = FontFactory.getFont(String.valueOf(FontFactory.getFont("Segoe UI")), 10, Font.BOLD);
            Font headingfont = FontFactory.getFont(String.valueOf(FontFactory.getFont("Segoe UI")), 10, Font.BOLD);
            Font footerFont = FontFactory.getFont(String.valueOf(FontFactory.getFont("Segoe UI")), 10, Font.BOLD);
            Font font = FontFactory.getFont(String.valueOf(FontFactory.getFont("Segoe UI")), 10);

            int reportSlNo = 1;
            for (Map<String, Object> mapData : list) {
                JSONArray headerData = (JSONArray) mapData.get("header");

                PdfPTable table = new PdfPTable(headerData.length());
                table.setWidthPercentage(110);
                table.setSpacingBefore(0);
                table.setSpacingAfter(0);
                table.setHorizontalAlignment(Element.ALIGN_CENTER);

                PdfPCell headerCell = new PdfPCell(new Paragraph((String) mapData.get("heading"), subjectfont));
                headerCell.setPadding(5);
                headerCell.setBackgroundColor((Integer) mapData.get("id") == 1
                                ? new BaseColor(198, 235, 198)
                                : ((Integer) mapData.get("id") == 2
                                ? new BaseColor(255, 204, 204)
                                : ((Integer) mapData.get("id") == 3
                                ? new BaseColor(153, 194, 255)
                                : new BaseColor(255, 194, 153))
                        )
                );
                headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                headerCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                headerCell.setColspan(headerData.length()); // Merge all columns
                table.addCell(headerCell);

                String[] columns = new String[headerData.length()];
                for (int i = 0; i < headerData.length(); i++) {
                    columns[i] = headerData.getString(i);
                }

                if ((Integer)mapData.get("id") != 3) {
                    float[] columnWidths = new float[columns.length];
                    for (int i = 0; i < columns.length; i++) {
                        columnWidths[i] = 2f;
                    }
                    columnWidths[0] = .5f;
                    table.setWidths(columnWidths);

                    for (String column : columns) {
                        PdfPCell cell = new PdfPCell(new Paragraph(column, headingfont));
                        cell.setPaddingLeft(4);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        table.addCell(cell);
                    }
                } else {
                    String[] hospitalDataHeadersData = (String[]) mapData.get("hospitalDataHeaders");
                    String[] hospitalDataSubHeadersData = (String[]) mapData.get("hospitalDataSubHeaders");

                    float[] columnWidths = new float[hospitalDataSubHeadersData.length];
                    for (int i = 0; i < hospitalDataSubHeadersData.length; i++) {
                        columnWidths[i] = 2f;
                    }
                    columnWidths[0] = 1f;
                    table.setWidths(columnWidths);

                    for (int i = 0; i < 5; i++) {
                        PdfPCell cell = new PdfPCell(new Paragraph(hospitalDataHeadersData[i], headingfont));
                        cell.setPaddingLeft(4);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setRowspan(2);
                        table.addCell(cell);
                    }

                    PdfPCell cell = new PdfPCell(new Paragraph("NFSA/SFSA", headingfont));
                    cell.setPaddingLeft(4);
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setColspan(2);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph("NABIN", headingfont));
                    cell.setPaddingLeft(4);
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setColspan(2);
                    table.addCell(cell);

                    for (int i = 5; i < hospitalDataSubHeadersData.length; i++) {
                        PdfPCell subCell = new PdfPCell(new Paragraph(hospitalDataSubHeadersData[i], headingfont));
                        subCell.setPaddingLeft(4);
                        subCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        table.addCell(subCell);
                    }
                }

                int slNO = 1;

                if ((Integer)mapData.get("id") != 3) {
                    if ((Integer)mapData.get("id") == 4 || (Integer)mapData.get("id") == 5) {
                        JSONArray reportData = (JSONArray) mapData.get("report");

                        for (int i = 0; i < reportData.length(); i++) {
                            JSONObject jsonObject = reportData.getJSONObject(i);
                            for (String column : columns) {
                                PdfPCell cell = new PdfPCell(new Paragraph(jsonObject.getString(column), font));
                                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                                cell.setPaddingLeft(4);
                                table.addCell(cell);
                            }
                            slNO++;
                        }

                        if (reportData.length() > 0) {
                            PdfPCell footerCell = new PdfPCell(new Paragraph("Total", headingfont));
                            footerCell.setPadding(5);
                            footerCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                            footerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            footerCell.setBackgroundColor(new BaseColor(235, 235, 235));
                            footerCell.setColspan(5);
                            table.addCell(footerCell);

                            for (int j = 5; j < columns.length; j++) {
                                int sum = 0;
                                for (int k = 0; k < reportData.length(); k++) {
                                    JSONObject jsonObject = reportData.getJSONObject(k);
                                    sum += jsonObject.getInt(columns[j]);
                                }

                                PdfPCell sumCell = new PdfPCell(new Paragraph(NumberFormat.getNumberInstance(Locale.US).format(sum), headingfont));
                                sumCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                                sumCell.setBackgroundColor(new BaseColor(235, 235, 235));
                                sumCell.setPaddingLeft(4);
                                table.addCell(sumCell);
                            }
                        }
                    } else {
                        JSONArray reportData = (JSONArray) mapData.get("report");

                        for (int i = 0; i < reportData.length(); i++) {
                            JSONObject jsonObject = reportData.getJSONObject(i);
                            for (String column : columns) {
                                PdfPCell cell = new PdfPCell(new Paragraph(jsonObject.getString(column), font));
                                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                                cell.setPaddingLeft(4);
                                table.addCell(cell);
                            }
                            slNO++;
                        }

                        if (reportData.length() > 0) {
                            PdfPCell footerCell = new PdfPCell(new Paragraph("Total", headingfont));
                            footerCell.setPadding(5);
                            footerCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                            footerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            footerCell.setBackgroundColor(new BaseColor(235, 235, 235));
                            footerCell.setColspan(2);
                            table.addCell(footerCell);

                            for (int j = 2; j < columns.length; j++) {
                                int sum = 0;
                                for (int k = 0; k < reportData.length(); k++) {
                                    JSONObject jsonObject = reportData.getJSONObject(k);
                                    sum += jsonObject.getInt(columns[j]);
                                }

                                PdfPCell sumCell = new PdfPCell(new Paragraph(NumberFormat.getNumberInstance(Locale.US).format(sum), headingfont));
                                sumCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                                sumCell.setBackgroundColor(new BaseColor(235, 235, 235));
                                sumCell.setPaddingLeft(4);
                                table.addCell(sumCell);
                            }
                        }
                    }
                } else {
                    List<JSONArray> jsonArrayList1 = (List<JSONArray>) mapData.get("report");
                    for(JSONArray reportData1 : jsonArrayList1) {
                        for (int i = 0; i < reportData1.length(); i++) {
                            JSONObject jsonObject = reportData1.getJSONObject(i);
                            for (String column : columns) {
                                PdfPCell cell = new PdfPCell(new Paragraph(jsonObject.getString(column), font));
                                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                                cell.setPaddingLeft(4);
                                table.addCell(cell);
                            }
                            slNO++;
                        }

                        if (reportData1.length() > 0) {
                            PdfPCell footerCell = new PdfPCell(new Paragraph("Total", headingfont));
                            footerCell.setPadding(5);
                            footerCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                            footerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            footerCell.setBackgroundColor(new BaseColor(235, 235, 235));
                            footerCell.setColspan(5);
                            table.addCell(footerCell);

                            for (int j = 5; j < columns.length; j++) {
                                int sum = 0;
                                for (int k = 0; k < reportData1.length(); k++) {
                                    JSONObject jsonObject = reportData1.getJSONObject(k);
                                    sum += jsonObject.getInt(columns[j]);
                                }

                                PdfPCell sumCell = new PdfPCell(new Paragraph(NumberFormat.getNumberInstance(Locale.US).format(sum), headingfont));
                                sumCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                                sumCell.setBackgroundColor(new BaseColor(235, 235, 235));
                                sumCell.setPaddingLeft(4);
                                table.addCell(sumCell);
                            }
                        }
                    }

                }

                myDoc.add(table);
                PdfContentByte cb = writer.getDirectContent();
                ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                        new Phrase("Page No: " + writer.getPageNumber(), FontFactory.getFont("Segoe UI", 8, Font.BOLD)),
                        (myDoc.right() - myDoc.left()) / 2 + myDoc.leftMargin(),
                        myDoc.bottom() - 10, 0
                );

                if (reportSlNo != list.size()) {
                    if ((Integer)mapData.get("id") != 1) {
                        myDoc.newPage();
                        myDoc.add(p);
                        myDoc.add(p1);
                        myDoc.add(new Paragraph(" "));
                        canvas.addTemplate(backgroundTemplate, 0, 0);

                        reportSlNo++;
                    } else {
                        myDoc.add(new Paragraph(" "));
                        reportSlNo++;
                    }
                }
            }
            myDoc.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePath;
    }

    public void generatePDF10() throws JSONException {
        List<Map<String, Object>> list = new ArrayList<>();
//        For Table 1
        JSONArray header = new JSONArray();
        header.put("SL#");
        header.put("Activity");
        header.put("NFSA/SFSA");
        header.put("NABIN");

        JSONArray report = new JSONArray();

        JSONObject dataObject = new JSONObject();
        dataObject.put("SL#", 1);
        dataObject.put("Activity", "Total Family Treated");
        dataObject.put("NFSA/SFSA", 126737);
        dataObject.put("NABIN", 4564);
        report.put(dataObject);

        dataObject = new JSONObject();
        dataObject.put("SL#", 2);
        dataObject.put("Activity", "Total Patient Treated");
        dataObject.put("NFSA/SFSA", 126737);
        dataObject.put("NABIN", 4564);
        report.put(dataObject);

        dataObject = new JSONObject();
        dataObject.put("SL#", 3);
        dataObject.put("Activity", "Total Package Discharged");
        dataObject.put("NFSA/SFSA", 126737);
        dataObject.put("NABIN", 4564);
        report.put(dataObject);

        dataObject = new JSONObject();
        dataObject.put("SL#", 4);
        dataObject.put("Activity", "Amount of Discharge");
        dataObject.put("NFSA/SFSA", 126737);
        dataObject.put("NABIN", 4564);
        report.put(dataObject);

        Map<String, Object> map = new LinkedHashMap<>();
        map.put("header", header);
        map.put("report", report);
        map.put("id", 1);
        map.put("heading", "Outside Odisha Transaction Details from Starting to 31-April-2024 ");
        list.add(map);

//        For Table 2
        header = new JSONArray();
        header.put("SL#");
        header.put("Activity");
        header.put("NFSA/SFSA");
        header.put("NABIN");

        report = new JSONArray();

        dataObject = new JSONObject();
        dataObject.put("SL#", 1);
        dataObject.put("Activity", "Total Family Treated");
        dataObject.put("NFSA/SFSA", 126737);
        dataObject.put("NABIN", 4564);
        report.put(dataObject);

        dataObject = new JSONObject();
        dataObject.put("SL#", 2);
        dataObject.put("Activity", "Total Patient Treated");
        dataObject.put("NFSA/SFSA", 126737);
        dataObject.put("NABIN", 4564);
        report.put(dataObject);

        dataObject = new JSONObject();
        dataObject.put("SL#", 3);
        dataObject.put("Activity", "Total Package Discharged");
        dataObject.put("NFSA/SFSA", 126737);
        dataObject.put("NABIN", 4564);
        report.put(dataObject);

        dataObject = new JSONObject();
        dataObject.put("SL#", 4);
        dataObject.put("Activity", "Amount of Discharge");
        dataObject.put("NFSA/SFSA", 126737);
        dataObject.put("NABIN", 4564);
        report.put(dataObject);

        map = new LinkedHashMap<>();
        map.put("header", header);
        map.put("report", report);
        map.put("id", 2);
        map.put("heading", "Outside Odisha Transaction Details from 01-April-2024 to 31-April-2024");
        list.add(map);

//        For Table 3
        header = new JSONArray();
        header.put("SL#");
        header.put("Hospital State");
        header.put("Hospital District");
        header.put("Hospital Code");
        header.put("Hospital Name");
        header.put("Total No of Discharge");
        header.put("Total Amount of Discharge");
        header.put("Total No of Discharge1");
        header.put("Total Amount of Discharge1");

        String[] hospitalDataHeaders = new String[]
                {
                        "SL#",
                        "Hospital State",
                        "Hospital District",
                        "Hospital Code",
                        "Hospital Name",
                        "NFSA/SFSA",
                        "NABIN"
                };
        String[] hospitalDataSubHeaders = new String[]
                {
                        "SL#",
                        "Hospital State",
                        "Hospital District",
                        "Hospital Code",
                        "Hospital Name",
                        "Total No of Discharge",
                        "Total Amount of Discharge",
                        "Total No of Discharge",
                        "Total Amount of Discharge"
                };

        List<JSONArray> jsonArrayList = new ArrayList<>();
        JSONArray dataJSONArray = new JSONArray();
        dataObject = new JSONObject();
        dataObject.put("SL#", 1);
        dataObject.put("Hospital State", "Odisha");
        dataObject.put("Hospital District", "Khurdha");
        dataObject.put("Hospital Code", 21193472);
        dataObject.put("Hospital Name", "Sahoo Vikari Seva Sadan");
        dataObject.put("Hospital Name", "Sahoo Vikari Seva Sadan");
        dataObject.put("Total No of Discharge", 21312);
        dataObject.put("Total Amount of Discharge", 35345354);
        dataObject.put("Total No of Discharge1", 21312);
        dataObject.put("Total Amount of Discharge1", 35345354);
        dataJSONArray.put(dataObject);

        dataObject = new JSONObject();
        dataObject.put("SL#", 1);
        dataObject.put("Hospital State", "Odisha");
        dataObject.put("Hospital District", "Khurdha");
        dataObject.put("Hospital Code", 21193472);
        dataObject.put("Hospital Name", "Sahoo Vikari Seva Sadan");
        dataObject.put("Hospital Name", "Sahoo Vikari Seva Sadan");
        dataObject.put("Total No of Discharge", 21312);
        dataObject.put("Total Amount of Discharge", 35345354)
        ;dataObject.put("Total No of Discharge1", 21312);
        dataObject.put("Total Amount of Discharge1", 35345354);
        dataJSONArray.put(dataObject);
        jsonArrayList.add(dataJSONArray);

        dataJSONArray = new JSONArray();
        dataObject = new JSONObject();
        dataObject.put("SL#", 2);
        dataObject.put("Hospital State", "Odisha");
        dataObject.put("Hospital District", "Khurdha");
        dataObject.put("Hospital Code", 21193472);
        dataObject.put("Hospital Name", "Sahoo Vikari Seva Sadan");
        dataObject.put("Hospital Name", "Sahoo Vikari Seva Sadan");
        dataObject.put("Total No of Discharge", 21312);
        dataObject.put("Total Amount of Discharge", 35345354);
        dataObject.put("Total No of Discharge1", 21312);
        dataObject.put("Total Amount of Discharge1", 35345354);
        dataJSONArray.put(dataObject);

        dataObject = new JSONObject();
        dataObject.put("SL#", 3);
        dataObject.put("Hospital State", "Odisha");
        dataObject.put("Hospital District", "Khurdha");
        dataObject.put("Hospital Code", 21193472);
        dataObject.put("Hospital Name", "Sahoo Vikari Seva Sadan");
        dataObject.put("Hospital Name", "Sahoo Vikari Seva Sadan");
        dataObject.put("Total No of Discharge", 21312);
        dataObject.put("Total Amount of Discharge", 35345354)
        ;dataObject.put("Total No of Discharge1", 21312);
        dataObject.put("Total Amount of Discharge1", 35345354);
        dataJSONArray.put(dataObject);

        dataJSONArray = new JSONArray();
        dataObject = new JSONObject();
        dataObject.put("SL#", 1);
        dataObject.put("Hospital State", "Odisha");
        dataObject.put("Hospital District", "Khurdha");
        dataObject.put("Hospital Code", 21193472);
        dataObject.put("Hospital Name", "Sahoo Vikari Seva Sadan");
        dataObject.put("Hospital Name", "Sahoo Vikari Seva Sadan");
        dataObject.put("Total No of Discharge", 21312);
        dataObject.put("Total Amount of Discharge", 35345354);
        dataObject.put("Total No of Discharge1", 21312);
        dataObject.put("Total Amount of Discharge1", 35345354);
        dataJSONArray.put(dataObject);

        dataObject = new JSONObject();
        dataObject.put("SL#", 4);
        dataObject.put("Hospital State", "Odisha");
        dataObject.put("Hospital District", "Khurdha");
        dataObject.put("Hospital Code", 21193472);
        dataObject.put("Hospital Name", "Sahoo Vikari Seva Sadan");
        dataObject.put("Hospital Name", "Sahoo Vikari Seva Sadan");
        dataObject.put("Total No of Discharge", 21312);
        dataObject.put("Total Amount of Discharge", 35345354)
        ;dataObject.put("Total No of Discharge1", 21312);
        dataObject.put("Total Amount of Discharge1", 35345354);
        dataJSONArray.put(dataObject);
        jsonArrayList.add(dataJSONArray);

        map = new LinkedHashMap<>();
        map.put("header", header);
        map.put("hospitalDataHeaders", hospitalDataHeaders);
        map.put("hospitalDataSubHeaders", hospitalDataSubHeaders);
        map.put("report", jsonArrayList);
        map.put("id", 3);
        map.put("heading", "Outside Odisha – Hospital District Wise Discharge from 01-April-2024  to 31-April-2024  ");
        list.add(map);


        String filePath = "C:\\BSKY\\WhatsAppDoc\\BSKY Summary Report24.pdf";
        try {
            Document myDoc = new Document(PageSize.A4);
            OutputStream outputStream = Files.newOutputStream(Paths.get(filePath));
            PdfWriter writer = PdfWriter.getInstance(myDoc, outputStream);
            myDoc.open();

            com.itextpdf.text.Image backgroundImage = com.itextpdf.text.Image.getInstance("C:\\BSKY\\WhatsAppDoc\\Images\\fade-logo.png");
            backgroundImage.scaleToFit(400, 400);
            backgroundImage.setAbsolutePosition((myDoc.getPageSize().getWidth() - backgroundImage.getScaledWidth()) / 2,
                    (myDoc.getPageSize().getHeight() - backgroundImage.getScaledHeight()) / 2);

            com.itextpdf.text.Image backgroundImage1 = com.itextpdf.text.Image.getInstance("C:\\BSKY\\WhatsAppDoc\\Images\\top-pattern.png");
            backgroundImage1.scaleToFit(250, 250);
            backgroundImage1.setAbsolutePosition(0, myDoc.getPageSize().getHeight() - backgroundImage1.getScaledHeight());

            PdfTemplate backgroundTemplate = writer.getDirectContent().createTemplate(
                    myDoc.getPageSize().getWidth(), myDoc.getPageSize().getHeight()
            );

            backgroundTemplate.addImage(backgroundImage);
            backgroundTemplate.addImage(backgroundImage1);

            PdfContentByte canvas = writer.getDirectContentUnder();

            canvas.addTemplate(backgroundTemplate, 0, 0);

            Paragraph p = new Paragraph("BSKY SUMMARY REPORT", FontFactory.getFont("Segoe UI", 20, Font.BOLD, new BaseColor(0, 102, 0)));
            p.setAlignment(Element.ALIGN_CENTER);

            Paragraph p1 = new Paragraph("Document Generated On: " + new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(new Date()), FontFactory.getFont("Segoe UI", 10, Font.NORMAL, BaseColor.BLACK));
            p1.setAlignment(Element.ALIGN_CENTER);

            myDoc.add(p);
            myDoc.add(p1);
            myDoc.add(new Paragraph(" "));

            Font subjectfont = FontFactory.getFont(String.valueOf(FontFactory.getFont("Segoe UI")), 10, Font.BOLD);
            Font headingfont = FontFactory.getFont(String.valueOf(FontFactory.getFont("Segoe UI")), 10, Font.BOLD);
            Font font = FontFactory.getFont(String.valueOf(FontFactory.getFont("Segoe UI")), 10);

            int reportSlNo = 1;
            for (Map<String, Object> mapData : list) {
                JSONArray headerData = (JSONArray) mapData.get("header");

                PdfPTable table = new PdfPTable(headerData.length());
                table.setWidthPercentage(110);
                table.setSpacingBefore(0);
                table.setSpacingAfter(0);
                table.setHorizontalAlignment(Element.ALIGN_CENTER);

                PdfPCell headerCell = new PdfPCell(new Paragraph((String) mapData.get("heading"), subjectfont));
                headerCell.setPadding(5);
                headerCell.setBackgroundColor((Integer) mapData.get("id") == 1
                                ? new BaseColor(198, 235, 198)
                                : ((Integer) mapData.get("id") == 2
                                ? new BaseColor(255, 204, 204)
                                : ((Integer) mapData.get("id") == 3
                                ? new BaseColor(153, 194, 255)
                                : new BaseColor(255, 194, 153))
                        )
                );
                headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                headerCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                headerCell.setColspan(headerData.length()); // Merge all columns
                table.addCell(headerCell);

                String[] columns = new String[headerData.length()];
                for (int i = 0; i < headerData.length(); i++) {
                    columns[i] = headerData.getString(i);
                }

                if ((Integer)mapData.get("id") != 3) {
                    for (String column : columns) {
                        PdfPCell cell = new PdfPCell(new Paragraph(column, headingfont));
                        cell.setPaddingLeft(4);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        table.addCell(cell);
                    }
                } else {
                   /*float[] columnWidths = {1, 2, 2, 2, 2, 2, 2, 2, 2};
                   table.setWidths(columnWidths);*/

                    String[] hospitalDataHeadersData = (String[]) mapData.get("hospitalDataHeaders");
                    String[] hospitalDataSubHeadersData = (String[]) mapData.get("hospitalDataSubHeaders");

                    float[] columnWidths = new float[hospitalDataSubHeadersData.length];
                    for (int i = 0; i < hospitalDataSubHeadersData.length; i++) {
                        columnWidths[i] = 2f; // Set a default width of 2 for each column
                    }
                    columnWidths[0] = 1f; // Adjust the width of the first column if needed
                    table.setWidths(columnWidths);

                    for (int i = 0; i < 5; i++) {
                        PdfPCell cell = new PdfPCell(new Paragraph(hospitalDataHeadersData[i], headingfont));
                        cell.setPaddingLeft(4);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setRowspan(2);
                        table.addCell(cell);
                    }

                    PdfPCell cell = new PdfPCell(new Paragraph("NFSA/SFSA", headingfont));
                    cell.setPaddingLeft(4);
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setColspan(2);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph("NABIN", headingfont));
                    cell.setPaddingLeft(4);
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setColspan(2);
                    table.addCell(cell);

                    for (int i = 5; i < hospitalDataSubHeadersData.length; i++) {
                        PdfPCell subCell = new PdfPCell(new Paragraph(hospitalDataSubHeadersData[i], headingfont));
                        subCell.setPaddingLeft(4);
                        subCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        table.addCell(subCell);
                    }
                }

                int slNO = 1;

                if ((Integer)mapData.get("id") != 3) {
                    JSONArray reportData = (JSONArray) mapData.get("report");

                    for (int i = 0; i < reportData.length(); i++) {
                        JSONObject jsonObject = reportData.getJSONObject(i);
                        for (String column : columns) {
                            PdfPCell cell = new PdfPCell(new Paragraph(jsonObject.getString(column), font));
                            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                            cell.setPaddingLeft(4);
                            table.addCell(cell);
                        }
                        slNO++;
                    }

                    if (reportData.length() > 0) {
                        PdfPCell footerCell = new PdfPCell(new Paragraph("Total", headingfont));
                        footerCell.setPadding(5);
                        footerCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        footerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        footerCell.setBackgroundColor(new BaseColor(204, 255, 221));
                        footerCell.setColspan(2);
                        table.addCell(footerCell);

                        for (int j = 2; j < columns.length; j++) {
                            int sum = 0;
                            for (int k = 0; k < reportData.length(); k++) {
                                JSONObject jsonObject = reportData.getJSONObject(k);
                                sum += jsonObject.getInt(columns[j]);
                            }

                            PdfPCell sumCell = new PdfPCell(new Paragraph(NumberFormat.getNumberInstance(Locale.US).format(sum), headingfont));
                            sumCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                            sumCell.setBackgroundColor(new BaseColor(204, 255, 221));
                            sumCell.setPaddingLeft(4);
                            table.addCell(sumCell);
                        }
                    }
                } else {
                    List<JSONArray> jsonArrayList1 = (List<JSONArray>) mapData.get("report");
                    for(JSONArray reportData1 : jsonArrayList1) {
                        for (int i = 0; i < reportData1.length(); i++) {
                            JSONObject jsonObject = reportData1.getJSONObject(i);
                            for (String column : columns) {
                                PdfPCell cell = new PdfPCell(new Paragraph(jsonObject.getString(column), font));
                                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                                cell.setPaddingLeft(4);
                                table.addCell(cell);
                            }
                            slNO++;
                        }

                        if (reportData1.length() > 0) {
                            PdfPCell footerCell = new PdfPCell(new Paragraph("Total", headingfont));
                            footerCell.setPadding(5);
                            footerCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                            footerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            footerCell.setBackgroundColor(new BaseColor(204, 255, 221));
                            footerCell.setColspan(5);
                            table.addCell(footerCell);

                            for (int j = 5; j < columns.length; j++) {
                                int sum = 0;
                                for (int k = 0; k < reportData1.length(); k++) {
                                    JSONObject jsonObject = reportData1.getJSONObject(k);
                                    sum += jsonObject.getInt(columns[j]);
                                }

                                PdfPCell sumCell = new PdfPCell(new Paragraph(NumberFormat.getNumberInstance(Locale.US).format(sum), headingfont));
                                sumCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                                sumCell.setBackgroundColor(new BaseColor(204, 255, 221));
                                sumCell.setPaddingLeft(4);
                                table.addCell(sumCell);
                            }
                        }
                    }

                }

                myDoc.add(table);
                PdfContentByte cb = writer.getDirectContent();
                ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                        new Phrase("Page No: " + writer.getPageNumber(), FontFactory.getFont("Segoe UI", 8, Font.BOLD)),
                        (myDoc.right() - myDoc.left()) / 2 + myDoc.leftMargin(),
                        myDoc.bottom() - 10, 0
                );

                if (reportSlNo != list.size()) {
                    if ((Integer)mapData.get("id") != 1) {
                        myDoc.newPage();
                        myDoc.add(p);
                        myDoc.add(p1);
                        myDoc.add(new Paragraph(" "));
                        canvas.addTemplate(backgroundTemplate, 0, 0);

                        reportSlNo++;
                    } else {
                        myDoc.add(new Paragraph(" "));
                        reportSlNo++;
                    }
                }
            }
            myDoc.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @PersistenceContext
    private EntityManager entityManager;

    public Map<String, Object> getSlipData(Map<String, Object> request) {
        Map<String, Object> response = null;
        try {
            StoredProcedureQuery storedProcedureQuery = this.entityManager.createStoredProcedureQuery("Procedure Name")
                    .registerStoredProcedureParameter("P_ACTION", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("P_TRANSACTIONID", Long.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("P_TXNPACKAGEDETAILID", Long.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("P_MSGOUT", void.class, ParameterMode.REF_CURSOR)
                    .registerStoredProcedureParameter("P_IMP", void.class, ParameterMode.REF_CURSOR)
                    .registerStoredProcedureParameter("P_HED", void.class, ParameterMode.REF_CURSOR)
                    .registerStoredProcedureParameter("P_PACKAGE", void.class, ParameterMode.REF_CURSOR);

            storedProcedureQuery.setParameter("P_ACTION", request.get("actionCode").toString());
            storedProcedureQuery.setParameter("P_TRANSACTIONID", request.get("transactionId") != null
                    ? Long.parseLong(request.get("transactionId").toString()) : null);
            storedProcedureQuery.setParameter("P_TXNPACKAGEDETAILID", request.get("txnPackageDetailId") != null
                    ? Long.parseLong(request.get("txnPackageDetailId").toString()) : null);

            storedProcedureQuery.execute();
            ResultSet pMsgOut = (ResultSet) storedProcedureQuery.getOutputParameterValue("P_MSGOUT");
            ResultSet pImp = (ResultSet) storedProcedureQuery.getOutputParameterValue("P_IMP");
            ResultSet pHed = (ResultSet) storedProcedureQuery.getOutputParameterValue("P_HED");
            ResultSet pPackage = (ResultSet) storedProcedureQuery.getOutputParameterValue("P_PACKAGE");

            switch (request.get("actionCode").toString()) {
                case "BS":
                    response = new LinkedHashMap<>();
                    List<Map<String, Object>> packageList = new ArrayList<>();
                    List<Map<String, Object>> hedList = new ArrayList<>();
                    List<Map<String, Object>> impList = new ArrayList<>();

                    while (pMsgOut.next()) {
                        response.put("medicalType", pMsgOut.getString(1));
                        response.put("memberName", pMsgOut.getString(2));
                        response.put("memberId", pMsgOut.getString(3));
                        response.put("memberRelationWithHead", pMsgOut.getString(4));
                        response.put("headMemberName", pMsgOut.getString(5));
                        response.put("verifiedMemberName", pMsgOut.getString(6));
                        response.put("verificationMode", pMsgOut.getString(7));
                        response.put("verifierRelationWithHead", pMsgOut.getString(8));
                        response.put("invoiceNo", pMsgOut.getString(9));
                        response.put("caseNo", pMsgOut.getString(10));
                        response.put("urn", pMsgOut.getString(11));
                        response.put("hospitalCode", pMsgOut.getString(12));
                        response.put("hospitalName", pMsgOut.getString(13));
                        response.put("hospitalAuthorityCode", pMsgOut.getString(14));
                        response.put("dateTime", pMsgOut.getString(15));
                        response.put("admissionDate", pMsgOut.getString(16));
                        response.put("totalBlocked", pMsgOut.getString(17));
                        response.put("insufficientAmount", pMsgOut.getString(18));
                        response.put("totalAmount", pMsgOut.getString(19));
                        response.put("availableBalance", pMsgOut.getString(20));
                        response.put("policyYear", pMsgOut.getString(21));
                    }

                    while (pPackage.next()) {
                        Map<String, Object> pPackageMap = new LinkedHashMap<>();
                        pPackageMap.put("procedureCode", pPackage.getString(1));
                        pPackageMap.put("packageHeaderName", pPackage.getString(2));
                        pPackageMap.put("packageSubCategoryName", pPackage.getString(3));
                        pPackageMap.put("procedureName", pPackage.getString(4));
                        pPackageMap.put("txnPackageDetailId", pPackage.getString(5));
                        pPackageMap.put("noOfDays", pPackage.getString(6));
                        pPackageMap.put("amountBlocked", pPackage.getString(7));
                        pPackageMap.put("wardName", pPackage.getString(8));
                        pPackageMap.put("totalPackageCost", pPackage.getString(9));
                        pPackageMap.put("packageCost", pPackage.getString(10));
                        pPackageMap.put("blockDate", pPackage.getString(11));
                        pPackageMap.put("blockingTransaction", pPackage.getString(12));
                        pPackageMap.put("preAuthStatus", pPackage.getString(13));

                        packageList.add(pPackageMap);
                    }

                    while (pImp.next()) {
                        Map<String, Object> pImpMap = new LinkedHashMap<>();
                        pImpMap.put("implantName", pImp.getString(1));
                        pImpMap.put("unit", pImp.getString(2));
                        pImpMap.put("unitCyclePrice", pImp.getString(3));
                        pImpMap.put("amount", pImp.getString(4));
                        pImpMap.put("txnPackageDetailId", pImp.getString(5));

                        impList.add(pImpMap);
                    }

                    while (pHed.next()) {
                        Map<String, Object> pHedMap = new LinkedHashMap<>();
                        pHedMap.put("hedName", pHed.getString(1));
                        pHedMap.put("preAuth", pHed.getString(2));
                        pHedMap.put("hedPricePerUnit", pHed.getString(3));
                        pHedMap.put("hedUnit", pHed.getString(4));
                        pHedMap.put("hedPrice", pHed.getString(5));
                        pHedMap.put("txnPackageDetailId", pHed.getString(6));

                        hedList.add(pHedMap);
                    }

//                    Method 1
/*                    packageList.forEach(packageMap -> {
                        List<Map<String, Object>> impList1 = new ArrayList<>();
                        List<Map<String, Object>> hedList1 = new ArrayList<>();

                        impList.forEach(impMap -> {
                            if (impMap.get("txnPackageDetailId").equals(packageMap.get("txnPackageDetailId")))
                                impList1.add(impMap);
                        });

                        hedList.forEach(hedMap -> {
                            if (hedMap.get("txnPackageDetailId").equals(packageMap.get("txnPackageDetailId")))
                                hedList1.add(hedMap);
                        });

                        packageMap.put("implantList", impList1);
                        packageMap.put("hedList", hedList1);
                    });*/

//                    Method 2
/*                    packageList.forEach(p -> {
                        p.put("implantData", impList.stream().filter(i -> i.get("txnPackageDetailId").equals(p.get("txnPackageDetailId"))));
                        p.put("hed", hedList.stream().filter(h -> h.get("txnPackageDetailId").equals(p.get("txnPackageDetailId"))));
                    });*/


//                    Method 3
                    packageList.stream().filter(p -> p.get("txnPackageDetailId").equals(impList.get(0).get("txnPackageDetailId")))
                            .forEach(p -> p.put("implantData", impList));

                    packageList.stream().filter(p -> p.get("txnPackageDetailId").equals(hedList.get(0).get("txnPackageDetailId")))
                            .forEach(p -> p.put("hed", hedList));

                    response.put("packageDetails", packageList);

//                    Method 3
//                    Map<Long, List<Map<String, Object>>> packageInfoGrouped =
//                            packageInfoList.stream().collect(Collectors.groupingBy(info -> (Long) info.get("txnPackageDetailId")));
//
//                    hedInfoList.forEach(hedInfo -> {
//                        packageInfoGrouped.getOrDefault(hedInfo.get("txnPackageDetailId"), Collections.emptyList())
//                                .forEach(packageInfo -> {
//                                    List<Map<String, Object>> hedList = (List<Map<String, Object>>) packageInfo.get("hedList");
//                                    if (hedList == null) {
//                                        hedList = new ArrayList<>();
//                                        packageInfo.put("hedList", hedList);
//                                    }
//                                    hedList.add(hedInfo);
//                                });
//                    });
//
//                    implantInfoList.forEach(implantInfo -> {
//                        packageInfoGrouped.getOrDefault(implantInfo.get("txnPackageDetailId"), Collections.emptyList())
//                                .forEach(packageInfo -> {
//                                    List<Map<String, Object>> implantList = (List<Map<String, Object>>) packageInfo.get("implantList");
//                                    if (implantList == null) {
//                                        implantList = new ArrayList<>();
//                                        packageInfo.put("implantList", implantList);
//                                    }
//                                    implantList.add(implantInfo);
//                                });
//                    });
//
//                    packageInfoList.forEach(packageInfo -> {
//                        List<Map<String, Object>> hedList = (List<Map<String, Object>>) packageInfo.get("hedList");
//                        List<Map<String, Object>> implantList = (List<Map<String, Object>>) packageInfo.get("implantList");
//
//                        packageInfo.put("totalHedAmount", hedList.stream().mapToLong(hed -> (long) hed.get("amount")).sum());
//                        packageInfo.put("totalImplantAmount", implantList.stream().mapToLong(implant -> (long) implant.get("amount")).sum());
//                    });
                    break;
                case "US":
                    while (pMsgOut.next()) {
                        response = new LinkedHashMap<>();
                        response.put("unBlockingTransaction", pMsgOut.getString(1));
                        response.put("unBlockingInvoiceNumber", pMsgOut.getString(2));
                        response.put("memberName", pMsgOut.getString(3));
                        response.put("memberRelation", pMsgOut.getString(4));
                        response.put("headMemberName", pMsgOut.getString(5));
                        response.put("unBlockVerifiedMemberName", pMsgOut.getString(6));
                        response.put("verifiedMemberRelation", pMsgOut.getString(7));
                        response.put("unBlockVerificationMode", pMsgOut.getString(8));
                        response.put("caseNo", pMsgOut.getString(9));
                        response.put("urn", pMsgOut.getString(10));
                        response.put("hospitalCode", pMsgOut.getString(11));
                        response.put("hospitalName", pMsgOut.getString(12));
                        response.put("hospitalAuthorityCode", pMsgOut.getString(13));
                        response.put("dateTime", pMsgOut.getString(14));
                        response.put("admissionDate", pMsgOut.getString(15));
                        response.put("procedureCode", pMsgOut.getString(16));
                        response.put("amountBlocked", pMsgOut.getString(17));
                        response.put("insufficientAmount", pMsgOut.getString(18));
                        response.put("availableBalance", pMsgOut.getString(19));
                        response.put("implantData", pMsgOut.getString(20));
                        response.put("wardName", pMsgOut.getString(21));
                        response.put("hed", pMsgOut.getString(22));
                        response.put("policyYear", pMsgOut.getString(23));
                    }
                    break;
                default:
                    throw new CustomException("Invalid Action Code!");
            }
            return response;
        } catch (Exception e) {
            logger.error("Exception Occurred in getSlipData method of SlipGenerationServiceImpl", e);
            throw new CustomException(e.getMessage());
        }
    }


    public Object getBlockedPackage(Map<String, Object> request) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yy");

            StoredProcedureQuery storedProcedureQuery = this.entityManager.createStoredProcedureQuery("PROCDURE_NAME")
                    .registerStoredProcedureParameter("P_ACTION", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("P_HOSPITALCODE", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("P_FROMDATE", java.util.Date.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("P_TODATE", java.util.Date.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("P_TRANSACTIONID", Long.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("P_SEARCHTYPE", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("P_MSGOUT", void.class, ParameterMode.REF_CURSOR)
                    .registerStoredProcedureParameter("P_VERIFY_CUR", void.class, ParameterMode.REF_CURSOR)
                    .registerStoredProcedureParameter("P_PAK_CUR", void.class, ParameterMode.REF_CURSOR)
                    .registerStoredProcedureParameter("P_IM_CUR", void.class, ParameterMode.REF_CURSOR)
                    .registerStoredProcedureParameter("P_HE_CUR", void.class, ParameterMode.REF_CURSOR)
                    .registerStoredProcedureParameter("P_ADMIN_CUR", void.class, ParameterMode.REF_CURSOR)
                    .registerStoredProcedureParameter("P_VITAL_CUR", void.class, ParameterMode.REF_CURSOR)
                    .registerStoredProcedureParameter("P_DIAGNOSIS_CUR", void.class, ParameterMode.REF_CURSOR)
                    .registerStoredProcedureParameter("P_ICDINFO_CUR", void.class, ParameterMode.REF_CURSOR)
                    .registerStoredProcedureParameter("P_SUBICDINFO_CUR", void.class, ParameterMode.REF_CURSOR);

            storedProcedureQuery.setParameter("P_ACTION", getStringParameter(request, "actionCode"));
            storedProcedureQuery.setParameter("P_HOSPITALCODE", getStringParameter(request, "hospitalCode"));
            storedProcedureQuery.setParameter("P_FROMDATE", getDateParameter(request, "fromDate", simpleDateFormat));
            storedProcedureQuery.setParameter("P_TODATE", getDateParameter(request, "toDate", simpleDateFormat));
            storedProcedureQuery.setParameter("P_TRANSACTIONID", getLongParameter(request, "transactionId"));
            storedProcedureQuery.setParameter("P_SEARCHTYPE", getStringParameter(request, "searchType"));

            storedProcedureQuery.execute();

            ResultSet resultSet = (ResultSet) storedProcedureQuery.getOutputParameterValue("P_MSGOUT");
            ResultSet verifierResultSet = (ResultSet) storedProcedureQuery.getOutputParameterValue("P_VERIFY_CUR");
            ResultSet packageResultSet = (ResultSet) storedProcedureQuery.getOutputParameterValue("P_PAK_CUR");
            ResultSet implantResultSet = (ResultSet) storedProcedureQuery.getOutputParameterValue("P_IM_CUR");
            ResultSet hedResultSet = (ResultSet) storedProcedureQuery.getOutputParameterValue("P_HE_CUR");
            ResultSet adminssionResultSet = (ResultSet) storedProcedureQuery.getOutputParameterValue("P_ADMIN_CUR");
            ResultSet vitalResultSet = (ResultSet) storedProcedureQuery.getOutputParameterValue("P_VITAL_CUR");
            ResultSet diagnosisResultSet = (ResultSet) storedProcedureQuery.getOutputParameterValue("P_DIAGNOSIS_CUR");
            ResultSet icdResultSet = (ResultSet) storedProcedureQuery.getOutputParameterValue("P_ICDINFO_CUR");
            ResultSet subIcdResultSet = (ResultSet) storedProcedureQuery.getOutputParameterValue("P_SUBICDINFO_CUR");

            Map<String, Object> response = new LinkedHashMap<>();

            switch (getStringParameter(request, "actionCode")) {
                case "A":
                    response.put("responseList", getResultList(resultSet));
                    break;
                case "B":
                    Map<String, Object> patientInfo = getResultMap(resultSet);
                    List<Map<String, Object>> verifierInfoList = getResultList(verifierResultSet);
                    List<Map<String, Object>> packageInfoList = getResultList(packageResultSet);
                    List<Map<String, Object>> implantInfoList = getResultList(implantResultSet);
                    List<Map<String, Object>> hedInfoList = getResultList(hedResultSet);
                    List<Map<String, Object>> diagnosisInfoList = getResultList(diagnosisResultSet);
                    List<Map<String, Object>> adminssionInfoList = getResultList(adminssionResultSet);
                    List<Map<String, Object>> vitalInfoList = getResultList(vitalResultSet);
                    List<Map<String, Object>> icdInfoList = getResultList(icdResultSet);
                    List<Map<String, Object>> subIcdInfoList = getResultList(subIcdResultSet);

                    response.put("patientInfo", patientInfo);
                    response.put("verifierInfoList", verifierInfoList);
                    response.put("packageInfoList", packageInfoList);
                    response.put("implantInfoList", implantInfoList);
                    response.put("hedInfoList", hedInfoList);
                    response.put("diagnosisInfoList", diagnosisInfoList);
                    response.put("admissionInfoList", adminssionInfoList);
                    response.put("vitalInfoList", vitalInfoList);
                    response.put("icdInfoList", icdInfoList);
                    response.put("subIcdInfoList", subIcdInfoList);

                    updatePackageInfoList(packageInfoList, hedInfoList, implantInfoList);
                    updateResponseWithGroupedInfo(response, subIcdInfoList, icdInfoList, diagnosisInfoList);
                    break;
                default:
                    throw new CustomException("Invalid Action Code!");
            }

            return response;
        } catch (Exception e) {
            logger.error("Exception Occurred in getBlockedPackageList method of PackageBlockingServiceImpl", e);
            throw new CustomException(e.getMessage());
        }
    }

    private String getStringParameter(Map<String, Object> request, String parameterName) {
        return request.containsKey(parameterName) ? request.get(parameterName).toString() : null;
    }

    private java.util.Date getDateParameter(Map<String, Object> request, String parameterName, SimpleDateFormat simpleDateFormat) throws ParseException {
        return request.containsKey(parameterName) ? simpleDateFormat.parse(request.get(parameterName).toString()) : null;
    }

    private Long getLongParameter(Map<String, Object> request, String parameterName) {
        return request.containsKey(parameterName) ? Long.parseLong(request.get(parameterName).toString()) : null;
    }

    private List<Map<String, Object>> getResultList(ResultSet resultSet) throws SQLException {
        List<Map<String, Object>> resultList = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, Object> result = new LinkedHashMap<>();
            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                result.put(resultSet.getMetaData().getColumnName(i), resultSet.getObject(i));
            }
            resultList.add(result);
        }
        return resultList;
    }

    private Map<String, Object> getResultMap(ResultSet resultSet) throws SQLException {
        Map<String, Object> resultMap = new LinkedHashMap<>();
        while (resultSet.next()) {
            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                resultMap.put(resultSet.getMetaData().getColumnName(i), resultSet.getObject(i));
            }
        }
        return resultMap;
    }

    private void updatePackageInfoList(List<Map<String, Object>> packageInfoList, List<Map<String, Object>> hedInfoList, List<Map<String, Object>> implantInfoList) {
        packageInfoList.forEach(packageInfo -> {
            List<Map<String, Object>> hedList = hedInfoList.stream()
                    .filter(hedInfo -> packageInfo.get("txnPackageDetailId").equals(hedInfo.get("txnPackageDetailId")))
                    .collect(Collectors.toList());

            List<Map<String, Object>> implantList = implantInfoList.stream()
                    .filter(implantInfo -> packageInfo.get("txnPackageDetailId").equals(implantInfo.get("txnPackageDetailId")))
                    .collect(Collectors.toList());

            packageInfo.put("hedList", hedList);
            packageInfo.put("implantList", implantList);
            packageInfo.put("totalHedAmount", hedList.stream().mapToLong(hed -> (long) hed.get("amount")).sum());
            packageInfo.put("totalImplantAmount", implantList.stream().mapToLong(implant -> (long) implant.get("amount")).sum());
        });
    }

    private void updateResponseWithGroupedInfo(Map<String, Object> response, List<Map<String, Object>> subIcdInfoList, List<Map<String, Object>> icdInfoList, List<Map<String, Object>> diagnosisInfoList) {
        Map<Long, List<Map<String, Object>>> subIcdInfoGrouped = subIcdInfoList.stream()
                .collect(Collectors.groupingBy(info -> (Long) info.get("icdInfoId")));

        icdInfoList.forEach(icdInfo -> icdInfo.put("subIcdList", subIcdInfoGrouped.getOrDefault(icdInfo.get("icdInfoId"), Collections.emptyList())));

        Map<Long, List<Map<String, Object>>> icdInfoGrouped = icdInfoList.stream()
                .collect(Collectors.groupingBy(info -> (Long) info.get("txnPackageDetailId")));

        diagnosisInfoList.forEach(diagnosisInfo -> diagnosisInfo.put("icdList",
                icdInfoGrouped.getOrDefault(diagnosisInfo.get("txnPackageDetailId"), Collections.emptyList()))
        );

        response.put("diagnosisInfoList", diagnosisInfoList);
    }

    public String sendHttpRequest1(String url, String request) {
        HttpURLConnection httpURLConnection = null;
        try {
            URL apiUrl = new URL(url);
            httpURLConnection = (HttpURLConnection) apiUrl.openConnection();

            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setDoOutput(true);

            try (OutputStream os = httpURLConnection.getOutputStream()) {
                os.write(request.getBytes());
                os.flush();
            }

            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        response.append(line);
                    }
                    return response.toString();
                }
            } else {
                throw new CustomException("Unable to send request. HTTP response code: " + responseCode);
            }
        } catch (Exception ex) {
            logger.error("Exception occurred in sendHttpRequest method", ex);
            throw new CustomException(ex.getMessage());
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }
}
