package com.sambit.CompetitvePractice.JDBC.Student;

import com.sambit.CompetitvePractice.JDBC.UtilJDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class DatabaseInsert {
    static Connection connection = UtilJDBC.databaseConnection();

    public static void main(String[] args) {

            System.out.println(connection);

            if (connection != null) {
                try {
                    Student student = new Student();
                    String sql = "INSERT INTO STUDENT(sname, sdob, stream) VALUES(?,?,?)";
                    student.setSname("Dillip");
                    student.setSdob(Date.valueOf("2015-03-31"));
                    student.setStream("CSA");

                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, student.getSname());
                    preparedStatement.setDate(2, student.getSdob());
                    preparedStatement.setString(3, student.getStream());

                    int update = preparedStatement.executeUpdate();

                    if (update > 0)
                        System.out.println("Data Inserted To Table Successfully");
                    else
                        System.out.println("Data Insertion Failed");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            else
                System.out.println("Database Connection Failed");
    }
}
