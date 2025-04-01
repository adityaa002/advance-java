package com.rays.advance.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class TestMetaData {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from emp");

		ResultSet rs = pstmt.executeQuery();

		ResultSetMetaData metadata = rs.getMetaData();

		System.out.println(metadata);

		System.out.println("Catalog name : " + metadata.getCatalogName(1));
		System.out.println("Table name : " + metadata.getColumnName(1));
		System.out.println("coloumn count : " + metadata.getColumnCount());

	}
}
