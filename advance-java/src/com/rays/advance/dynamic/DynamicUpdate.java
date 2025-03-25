package com.rays.advance.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DynamicUpdate {

	public static void main(String[] args) throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setId(32);
		bean.setRollno(132);
		bean.setName("carl");
		bean.setPhysics(45);
		bean.setChemistry(77);
		bean.setMaths(12);
		UpdateValues(bean);
	}

	public static void UpdateValues(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement(
				"update marksheet set rollno = ? , name = ? , physics = ? , chemistry = ? , maths = ? where id = ?");

		pstmt.setInt(1, bean.getRollno());
		pstmt.setString(2, bean.getName());
		pstmt.setInt(3, bean.getPhysics());
		pstmt.setInt(4, bean.getChemistry());
		pstmt.setInt(5, bean.getMaths());
		pstmt.setInt(6, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println("Data updated successfully : " + i);
	}

}
