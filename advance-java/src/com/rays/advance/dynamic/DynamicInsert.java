package com.rays.advance.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DynamicInsert {
	public static void main(String[] args) throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setId(32);
		bean.setRollno(131);
		bean.setName("loki");
		bean.setPhysics(55);
		bean.setChemistry(64);
		bean.setMaths(88);

		insertValues(bean);
	}

	public static void insertValues(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values( ? , ? ,  ? , ? , ? , ? )");

		pstmt.setInt(1, bean.getId());
		pstmt.setInt(2, bean.getRollno());
		pstmt.setString(3, bean.getName());
		pstmt.setInt(4, bean.getPhysics());
		pstmt.setInt(5, bean.getChemistry());
		pstmt.setInt(6, bean.getMaths());

		int i = pstmt.executeUpdate();

		System.out.println("Data inserted into marksheet using Dynamic : " + i);
	}

}
