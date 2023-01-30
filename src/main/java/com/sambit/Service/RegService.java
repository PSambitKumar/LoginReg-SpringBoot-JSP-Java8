package com.sambit.Service;

import com.itextpdf.text.DocumentException;
import com.sambit.Bean.ImageBean;
import com.sambit.Bean.LoginBean;
import com.sambit.Bean.PersonalDataBean;
import com.sambit.Bean.RegBean;
import com.sambit.Entity.*;
import org.json.JSONArray;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface RegService {
    String saveRegLoginData(RegBean regBean);
    LoginBean checkLoginData(LoginBean loginBean);
    //RegBean getAllDataOfUser(LoginBean loginBean);
    List<Reg> getAllDataofUser(LoginBean loginBean);
    List<Reg> getDataOfUser(int slno);
    List<Reg> getDataOfUserByPhn(String phn);
    List<Reg> getDataofUserByUamePassandName(String uname, String password, String name);

    String savePersonalDetails(PersonalDataBean personalDataBean);
    List<PersonalData> getAllPersonalDetails();

    String saveImageData(ImageBean imageBean);

    Image saveImage(Image image);
    List<Postal> saveAllPostal(List<Postal> postalList);
    Postal findPostalHoByOfcName(String ofcName);
    List<PostalPo> saveAllPostalPo(List<PostalPo> postalPoList);
    String recieveIntData(String x);
//    List<String> findAllName();
    List<Reg> getAllRegList();
    void downloadCancelledPdf(HttpServletResponse httpServletResponse);

    boolean checkUserIsPresentOrNot(String userName);
    Reg saveReg(Reg reg);
    boolean deleteReg(int slNo);
    Reg getRegBySlNo(int slNo);
    boolean checkRegIsPresentOrNotBySlNo(int slNo);
    List<Reg> getAllReg();
    void generateRegistrationEXCELReport(HttpServletResponse httpServletResponse);
    void generateRegistrationPDFReport(HttpServletResponse httpServletResponse) throws DocumentException, IOException;
    boolean checkRegIsPresentOrNotByUserCode(String userCode);
     Reg getRegByUserCode(String userCode);
    void generatePDF(JSONArray reports, String header, HttpServletResponse httpServletResponse);
}
