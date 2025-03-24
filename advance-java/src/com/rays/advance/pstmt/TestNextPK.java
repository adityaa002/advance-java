package com.rays.advance.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestNextPK {
	public static void main(String[] args) throws Exception {
		int pk = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("select *  from marksheet");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
		}
		System.out.println(pk + 1); // we write +1 to get next primary key

	}
}
