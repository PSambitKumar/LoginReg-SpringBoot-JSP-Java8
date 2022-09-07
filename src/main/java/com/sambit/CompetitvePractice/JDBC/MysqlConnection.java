package com.sambit.CompetitvePractice.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 07/09/2022 - 10:44 AM
 */

//Need to add Ojdbc6.jar in the project(By Project Structure -> Libraries -> + -> Java -> ojdbc6.jar)
public class MysqlConnection {
	public Connection getConnection(){
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring", "root", "");
			System.out.println("Database Connection Established!");
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("Connection Failed");
		}
		return connection;
	}
}
