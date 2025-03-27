package com.rays.advance.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestAllInserts {
	public static void main(String[] args) throws Exception {

		// testInsert1();
		// testInsert2();
		/// testInsert3(28, "kartik ", 78000);
		EmployeeBean bean = new EmployeeBean();
		bean.setId(29);
		bean.setName("Aditya");
		bean.setSalary(45000);
		
		 testInsert4(bean);
	}

	public static void testInsert1() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("insert into emp values(25 ,'apurv', 55000) ");

		int i = pstmt.executeUpdate();

		System.out.println("Data inserted : " + i);

	}

	public static void testInsert2() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		String sql = "insert into emp values( ? , ? , ? )";

		System.out.println("Your query : " + sql);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, 27);
		pstmt.setString(2, "kunal");
		pstmt.setInt(3, 90500);
		int i = pstmt.executeUpdate();

		System.out.println("data inserted : " + i);

	}

	public static void testInsert3(int id, String name, int salary) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into emp values(? , ? , ?)");
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setInt(3, salary);

		int i = pstmt.executeUpdate();

		System.out.println("Data Inserted : " + i);

	}

	public static void testInsert4(EmployeeBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into emp values(? , ? , ?)");

		pstmt.setInt(1, bean.getId());
		pstmt.setString(2, bean.getName());
		pstmt.setInt(3, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println("Data inserted : " + i);
	}

}
