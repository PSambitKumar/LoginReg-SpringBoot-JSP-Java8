package com.sambit.CompetitvePractice.JDBC.Student;

import java.sql.Date;

public class Student {
    private int sid;
    private String sname;
    private Date sdob;
    private String stream;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Date getSdob() {
        return sdob;
    }

    public void setSdob(Date sdob) {
        this.sdob = sdob;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sdob=" + sdob +
                ", stream='" + stream + '\'' +
                '}';
    }
}
