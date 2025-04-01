package com.rays.advance.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JDBCDataSource {

	private static JDBCDataSource jds = null;

	private static ComboPooledDataSource cpds = null;

	private JDBCDataSource() {
		try {

			cpds = new ComboPooledDataSource();
			cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
			cpds.setJdbcUrl("jdbc:mysql://localhost:3306/advance_java");
			cpds.setUser("root");
			cpds.setPassword("root");
			cpds.setInitialPoolSize(5);
			cpds.setAcquireIncrement(5);
			cpds.setMaxPoolSize(30);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static JDBCDataSource getInstance() {

		if (jds == null) {
			jds = new JDBCDataSource();

		}
		return jds;
	}

	public static Connection getConnection() {
		try {
			return getInstance().cpds.getConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (conn == null) {
				conn.close();
			}

			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
