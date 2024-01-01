package com.sambit.Service;

import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sambit.Bean.ImageBean;
import com.sambit.Bean.LoginBean;
import com.sambit.Bean.PersonalDataBean;
import com.sambit.Bean.RegBean;
import com.sambit.Entity.*;
import com.sambit.Entity.Image;
import com.sambit.Repository.*;
import com.sambit.Utils.UserCodeGeneration;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

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

    public Map<String, Object> getSlipData(Map<String, Object> request) {
        Map<String, Object> response = null;
        try {
            StoredProcedureQuery storedProcedureQuery = this.entityManager.createStoredProcedureQuery(ProcedureUtils.GENERATE_SLIP)
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
}
