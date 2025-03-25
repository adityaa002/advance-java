package com.rays.advance.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestRead {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

	 PreparedStatement pstmt =   conn.prepareStatement("select  * from emp");
	 
	 ResultSet rs = pstmt.executeQuery();

	 while(rs.next()) {
		 System.out.print(rs.getInt(1));
		 System.out.print("\t"+ rs.getString(2));
		 System.out.println("\t"+ rs.getInt(3));
	 }
	}
}
