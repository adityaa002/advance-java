package com.rays.advance.transactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestWithTxn {
	public static void main(String[] args) throws Exception {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			int i = stmt.executeUpdate("insert into marksheet values(41 ,141, 'ghi',85,32,12 )");
			i = stmt.executeUpdate("insert into marksheet values(42 ,142, 'jkl',64,75,56 )");
			i = stmt.executeUpdate("insert into marksheet values(43 ,143, 'mno',85,12,3 )");
			conn.commit();
			System.out.println("Data inserted using transactions : " + i);

		} catch (Exception e) {
			conn.rollback();
			System.out.println("Exception  : " + e.getMessage());

		} finally {
			conn.close();
		}

	}

}
