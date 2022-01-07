package com.sambit.Service;

import com.sambit.Bean.LoginBean;
import com.sambit.Bean.RegBean;
import com.sambit.Entity.Login;
import com.sambit.Entity.Reg;
import com.sambit.Repository.LoginRepository;
import com.sambit.Repository.RegRepository;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegServiceImpl implements RegService{

    @Autowired
    RegRepository regRepository;
    @Autowired
    LoginRepository loginRepository;

    @Override
    public String saveRegLoginData(RegBean regBean) {
        String res = "";
        Reg reg = new Reg();
        reg.setUsername(regBean.getUsername());
        reg.setPassword(regBean.getPassword());
        reg.setName(regBean.getName());
        reg.setPhn(regBean.getPhn());
        reg.setEmail(regBean.getEmail());
        reg.setDept(regBean.getDept());
        reg.setDob(regBean.getDob());
        reg.setGender(regBean.getGender());
        Reg result = regRepository.save(reg);
        System.out.println("Data Added to Registration Table!!");

        Login login = new Login();
        login.setUsername(regBean.getUsername());
        login.setPassword(regBean.getPassword());
        Login result1 = loginRepository.save(login);
        System.out.println("Data Added to Login Table!!");
        res = "Success";
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
}
