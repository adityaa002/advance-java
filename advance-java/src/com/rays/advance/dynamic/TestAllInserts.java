package com.rays.advance.dynamic;

import java.beans.beancontext.BeanContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestAllInserts {
	public static void main(String[] args) throws Exception {

		MarksheetBean bean = new MarksheetBean();

		bean.setId(30);
		bean.setRollno(130);
		bean.setName("wanda");
		bean.setPhysics(45);
		bean.setChemistry(54);
		bean.setMaths(76);

		testInsert4(bean);
	}

	public static void testInsert1() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java","root", "root");
		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(24,124,'desmine', 34,67,54)");
		int i = pstmt.executeUpdate();

		System.out.println("data inserted--> " + i);

	}

	public static void testInsert2() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values( ? , ? , ? , ? , ? , ? )");
		pstmt.setInt(1, 26);
		pstmt.setInt(2, 126);
		pstmt.setString(3, "mark");
		pstmt.setInt(4, 45);
		pstmt.setInt(5,57 );
		pstmt.setInt(6, 87);

		int i = pstmt.executeUpdate();
		System.out.println("Data inserted using 2nd method--> " + i);

	}

	public static void testInsert3(int id, int rollno, String name, int physics, int chemistry, int maths)
			throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(? , ? , ? , ? , ? , ?)   ");
		pstmt.setInt(1, id);
		pstmt.setInt(2, rollno);
		pstmt.setString(3, name);
		pstmt.setInt(4, physics);
		pstmt.setInt(5, chemistry);
		pstmt.setInt(6, maths);

		int i = pstmt.executeUpdate();

		System.out.println("Data inserted using 3rd method");

	}

	public static void testInsert4(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java","root","root");

		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values (	? , ? , ? , ? , ? , ? )");

		pstmt.setInt(1, bean.getId());
		pstmt.setInt(2, bean.getRollno());
		pstmt.setString(3, bean.getName());
		pstmt.setInt(4, bean.getPhysics());
		pstmt.setInt(5, bean.getChemistry());
		pstmt.setInt(6, bean.getMaths());

		int i = pstmt.executeUpdate();
		System.out.println("Data inserted using 4th method " + i);

	}
}
