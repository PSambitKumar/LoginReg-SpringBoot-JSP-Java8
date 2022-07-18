package com.sambit.CompetitvePractice.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilJDBC {
    public static Connection connection;

    public static Connection databaseConnection(){
        if (connection == null){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/sambit_db","root","");
                System.out.println("Database Connection Successful " + connection);
            }catch(SQLException | ClassNotFoundException e){
                e.printStackTrace();
                System.out.println("Connection Failed");
            }
        }
        return connection;
    }
}
