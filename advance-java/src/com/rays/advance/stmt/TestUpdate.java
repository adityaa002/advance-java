package com.rays.advance.stmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestUpdate {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("update marksheet set id = 21 where name = 'Anjali'");

		System.out.println("Data updated successfully");
	}
}
