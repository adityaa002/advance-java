package com.rays.advance.transactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestWithoutTxn {
	public static void main(String[] args) {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
			Statement stmt = conn.createStatement();
			int i = stmt.executeUpdate("insert into marksheet values(39 , 139 ,'abc', 54,12,35) ");
			i = stmt.executeUpdate("insert into marksheet values(40 , 140 ,'def', 68,34,35) ");
			i = stmt.executeUpdate("insert into marksheet values(40 , 141 ,'ghi', 67,94,12) ");
			System.out.println("Data inserted success : " + i);

		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());

		}

	}

}
