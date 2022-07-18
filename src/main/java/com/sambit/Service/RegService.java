package com.sambit.Service;

import com.sambit.Bean.ImageBean;
import com.sambit.Bean.LoginBean;
import com.sambit.Bean.PersonalDataBean;
import com.sambit.Bean.RegBean;
import com.sambit.Entity.*;

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


}
