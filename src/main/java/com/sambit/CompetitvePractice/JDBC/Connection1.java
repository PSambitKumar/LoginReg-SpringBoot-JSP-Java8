package com.sambit.CompetitvePractice.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;


public class Connection1 {
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/spring","root","");
            System.out.println("Database Connection Successful " + con);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
