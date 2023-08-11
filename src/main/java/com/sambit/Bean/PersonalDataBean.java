package com.sambit.Bean;

public class PersonalDataBean {
    private int pid;
    private String name;
    private String panId;
    private String adharNo;

//    public PersonalDataBean(Integer id, String name, String panId, String adharNo) {
//        this.pid = id;
//        this.name = name;
//        this.panId = panId;
//        this.adharNo = adharNo;
//    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPanId() {
        return panId;
    }

    public void setPanId(String panId) {
        this.panId = panId;
    }

    public String getAdharNo() {
        return adharNo;
    }

    public void setAdharNo(String adharNo) {
        this.adharNo = adharNo;
    }

    @Override
    public String toString() {
        return "PersonalDataBean{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", panId='" + panId + '\'' +
                ", adharNo='" + adharNo + '\'' +
                '}';
    }
}
