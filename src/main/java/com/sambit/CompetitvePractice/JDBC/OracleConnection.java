package com.sambit.CompetitvePractice.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 07/09/2022 - 10:45 AM
 */

//Need to add Ojdbc6.jar in the project(By Project Structure -> Libraries -> + -> Java -> ojdbc6.jar)
public class OracleConnection {
	public Connection getConnection(String userName, String password) {
		Connection con;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", userName, password);
			System.out.println("Database Connection Established!");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Connection Failed");
			throw new RuntimeException(e);
		}
		return con;
	}
}
