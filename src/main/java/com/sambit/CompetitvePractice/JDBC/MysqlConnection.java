package com.sambit.CompetitvePractice.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 07/09/2022 - 10:44 AM
 */

public class MysqlConnection {
	public static Connection getConnection(String databseName, String userName, String password){
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+databseName, userName, password);
			System.out.println("Database Connection Established!");
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("Connection Failed");
		}
		return connection;
	}
}
