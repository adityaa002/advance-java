package com.rays.advance.testBundle;

import java.util.ResourceBundle;

public class TestResourceBundleTest {

	public static void main(String[] args) {

		ResourceBundle rb = ResourceBundle.getBundle("com.rays.advance.bundle.system");
		System.out.println(rb.getString("driver"));
		System.out.println(rb.getString("url"));
		System.out.println(rb.getString("username"));
		System.out.println(rb.getString("password"));
		System.out.println(rb.getString("initialpoolsize"));
		System.out.println(rb.getString("maxpoolsize"));
		System.out.println(rb.getString("acquireincrement"));

	}
}
