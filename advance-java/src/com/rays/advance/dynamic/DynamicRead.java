package com.rays.advance.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DynamicRead {

	public static void main(String[] args) throws Exception {

		// testRead1();
		// testRead2();
		// testRead3(16, null, 0);

		EmployeeBean bean = new EmployeeBean();
		bean.setId(29);
		bean.setName(null);
		bean.setSalary(29);

		// testRead4(bean);
		testRead5(bean);
	}

	public static void testRead1() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("Select * from emp");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.println("\t" + rs.getInt(3));
		}

	}

	public static void testRead2() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		// String sql = "select * from emp where id = 20";
		// String sql = "select name , id , salary from emp where salary = 67000";
		String sql = "select name , id , salary from emp where name = 'Aditya'";
		// String sql = "select name , id , salary from emp where salary = 67000";

		System.out.println("Your Query : " + sql);

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			System.out.print(rs.getString(1));
			System.out.print("\t" + rs.getInt(2));
			System.out.println("\t" + rs.getInt(3));
		}

	}

	public static void testRead3(int id, String name, int salary) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		String sql = "select name , id , salary  from emp";

		if (id > 0) {
			sql += " where id = " + id;
		}
		if (name != null) {
			sql += " where name = " + name;
		}
		if (salary > 0) {
			sql += "where salary = " + salary;
		}

		System.out.println("Your Query :" + sql);
		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			System.out.print(rs.getString(1));
			System.out.print("\t" + rs.getInt(2));
			System.out.println("\t" + rs.getInt(3));
		}

	}

	public static void testRead4(EmployeeBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		String sql = "select name , salary ,id from emp";
		if (bean != null) {
			if (bean.getId() > 0) {
				sql += " where id = " + bean.getId();

			}
			if (bean.getName() != null) {
				sql += " where name = '" + bean.getName() + "'";
			}
			if (bean.getSalary() > 0) {
				sql += " where salary = " + bean.getSalary();
			}
		}

		System.out.println("Your Query : " + sql);
		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getString(1));
			System.out.print("\t" + rs.getInt(2));
			System.out.println("\t" + rs.getInt(3));
		}

	}

	public static void testRead5(EmployeeBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		StringBuffer sql = new StringBuffer("select * from emp where 1=1");

		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}

			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name =  '" + bean.getName() + "'");
			}
			if (bean.getSalary() > 0) {
				sql.append(" and salary = " + bean.getSalary());
			}
		}

		System.out.println("Your Query : " + sql);
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.println("\t" + rs.getInt(3));
		}

	}

}
