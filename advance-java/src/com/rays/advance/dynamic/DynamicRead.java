package com.rays.advance.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DynamicRead {
	public static void main(String[] args) throws Exception {

		EmployeeBean bean = new EmployeeBean();
		bean.setId(0);
		bean.setName("Aditya");
		bean.setSalary(0);

		// testRead1();
		// testRead2();
		// testRead3(20, null, 0);
		testRead4(bean);

	}

	public static void testRead1() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("Select * from emp where id = 12");
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.println("\t" + rs.getString(3));
		}

	}

	public static void testRead2() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
		// String sql = "select * from emp where id = 13";
		String sql = "select * from emp where name = 'Aditya'";
		// String sql = "select * from emp where salary = 56000;

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.println("\t" + rs.getInt(3));
		}
	}

	public static void testRead3(int id, String name, int salary) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		String sql = "select * from emp";
		if (id > 0) {
			sql += " where id = " + id;
		}

		if (name != null) {
			sql += " where name = " + name;
		}

		if (salary > 0) {
			sql += " where salary = " + salary;
		}

		System.out.println("sql query :- " + sql);

		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.println("\t" + rs.getInt(3));
		}

	}

	public static void testRead4(EmployeeBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		String sql = "select * from emp";
		if (bean != null) {
			if (bean.getId() > 0) {
				sql += " where id = " + bean.getId();
			}
			if (bean.getName() != null) {
				sql += " where name = '" + bean.getName() + "'";  // inverted comma doubt 
			}
			if (bean.getSalary() > 0) {
				sql += " where salary = " + bean.getSalary();
			}

			System.out.println("Query : " + sql);
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.print(rs.getInt(1));
				System.out.print("\t" + rs.getString(2));
				System.out.println("\t" + rs.getInt(3));

			}
		}
	}
	
	
	public static void testRead5(EmployeeBean bean) {
		
	}

}
