package com.sambit.CompetitvePractice.CollectionFramework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


class EmployeeRecords{
    String firstName;
    String lastName;
    Integer mobNo;
    String emailId;
    Integer empCode;
    public EmployeeRecords(String firstName, String lastName, Integer mobNo, String emailId, Integer empCode) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobNo = mobNo;
        this.emailId = emailId;
        this.empCode = empCode;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Integer getMobNo() {
        return mobNo;
    }
    public void setMobNo(Integer mobNo) {
        this.mobNo = mobNo;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public Integer getEmpCode() {
        return empCode;
    }
    public void setEmpCode(Integer empCode) {
        this.empCode = empCode;
    }
    @Override
    public String toString() {
        return "Assessment.EmployeeRecords [firstName=" + firstName + ", lastName=" + lastName + ", mobNo=" + mobNo + ", emailId="
                + emailId + ", empCode=" + empCode + "]";
    }

}

public class MapExample {

    public static void main(String[] args) {
        //Assessment.EmployeeRecords er=new Assessment.EmployeeRecords("aishwarya","panda",811476875,"aishwarya@gmail.com",23451);
        Map<Integer,List<EmployeeRecords>> m=new HashMap<Integer,List<EmployeeRecords>>();
        m.put(1,Arrays.asList(new EmployeeRecords("nitish","parida",811476875,"nitish@gmail.com",1)));
        m.put(2,Arrays.asList(new EmployeeRecords("suman","nanda",65476875,"suman@gmail.com",2)));
        m.put(3,Arrays.asList(new EmployeeRecords("dilip","suna",987654321,"dilip@gmail.com",3)));
        m.put(4,Arrays.asList(new EmployeeRecords("aish","panda",898765432,"aish@gmail.com",4)));

        for(Entry<Integer,List<EmployeeRecords>> e:m.entrySet()) {
            System.out.println(e);
        }

    }

}

