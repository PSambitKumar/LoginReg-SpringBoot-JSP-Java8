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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
}
