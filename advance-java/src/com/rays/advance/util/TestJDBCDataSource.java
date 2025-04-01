package com.rays.advance.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBCDataSource {
	public static void main(String[] args) throws SQLException {
		for (int i = 0; i < 50; i++) {
			System.out.println("Connection :-" + i);
			getConn();
		}
	}

	public static void getConn() throws SQLException {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select  * from marksheet where id = 4");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getInt(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.println("\t" + rs.getInt(6));
		}
		conn.close(); 
	}
}
