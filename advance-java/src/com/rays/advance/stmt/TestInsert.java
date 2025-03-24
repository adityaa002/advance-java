package com.rays.advance.stmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
	
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
		
		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("insert into marksheet values(21,121,'Adiiii',45,36,12)");
		
		System.out.println("data inserted-"+i);
		
		
		/*
		 * int j =
		 * stmt.executeUpdate("insert into marksheet values(2,102,'Ashwin',65,99,65)");
		 * int k =
		 * stmt.executeUpdate("insert into marksheet values(3,103,'Abhi',48,12,78)");
		 * int l =
		 * stmt.executeUpdate("insert into marksheet values(4,104,'Arun',32,45,68)");
		 * int m =
		 * stmt.executeUpdate("insert into marksheet values(5,105,'Priya',78,82,90)");
		 * int n =
		 * stmt.executeUpdate("insert into marksheet values(6,106,'Ravi',65,72,80)");
		 * int o =
		 * stmt.executeUpdate("insert into marksheet values(7,107,'Neha',55,60,58)");
		 * int p =
		 * stmt.executeUpdate("insert into marksheet values(8,108,'Amit',85,88,92)");
		 * int q =
		 * stmt.executeUpdate("insert into marksheet values(9,109,'Sneha',47,50,55)");
		 * int r =
		 * stmt.executeUpdate("insert into marksheet values(10,110,'Vikas',90,85,88)");
		 * int s =
		 * stmt.executeUpdate("insert into marksheet values(11,111,'Anjali',40,45,50)");
		 * int t =
		 * stmt.executeUpdate("insert into marksheet values(12,112,'Suresh',72,75,70)");
		 * int u =
		 * stmt.executeUpdate("insert into marksheet values(34,134,'Rahul',78,80,85)");
		 * int v =
		 * stmt.executeUpdate("insert into marksheet values(35,135,'Sneha',65,70,72)");
		 * int w =
		 * stmt.executeUpdate("insert into marksheet values(36,136,'Amit',50,55,60)");
		 * int x =
		 * stmt.executeUpdate("insert into marksheet values(37,137,'Pooja',85,88,90)");
		 * int y =
		 * stmt.executeUpdate("insert into marksheet values(38,138,'Kunal',92,95,98)");
		 * int z =
		 * stmt.executeUpdate("insert into marksheet values(39,139,'Neha',60,65,70)");
		 * int a =
		 * stmt.executeUpdate("insert into marksheet values(40,140,'Manoj',40,42,45)");
		 * int b =
		 * stmt.executeUpdate("insert into marksheet values(41,141,'Priya',75,78,80)");
		 * int c =
		 * stmt.executeUpdate("insert into marksheet values(42,142,'Rakesh',55,58,60)");
		 * int d =
		 * stmt.executeUpdate("insert into marksheet values(43,143,'Anjali',88,90,92)");
		 */
	}
}
