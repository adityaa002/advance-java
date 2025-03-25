package com.rays.advance.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DynamicDelete {
	public static void main(String[] args) throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setId(32);
		DeleteValues(bean);	
		}

	public static void DeleteValues(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("delete from marksheet where id = ?");
		pstmt.setInt(1, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println("Deleted Data : " + i);

	}

}
