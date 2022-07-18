package com.sambit.CompetitvePractice.JDBC.Student;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class IterratorExample {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter No. of Students?");
        int noOfStudents = scanner.nextInt();
        List<Student> studentList = new ArrayList<>(noOfStudents);

        for (int i = 0 ; i < noOfStudents; i++){
            System.out.println("Enter Student Name?");
            String sname = scanner.nextLine();
            System.out.println("Enter Student Date of Birth?");
            String sdob = scanner.nextLine();
            System.out.println("Enter Stream Name?");
            String stream = scanner.nextLine();

            Student student = new Student();
            student.setSid(1);
            student.setSname(sname);
            student.setSdob(Date.valueOf(sdob));
            student.setStream(stream);

            studentList.add(student);
        }

        System.out.println("<----Printing List of the Students---->");
        Iterator<Student> studentIterator = studentList.iterator();
        Student studentPrint = studentIterator.next();
        System.out.println(studentPrint);
        System.out.println(studentPrint.getStream());
    }
}
