package com.rays.advance.testBundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestResourceBundleApp {
	public static void main(String[] args) {
		// ResourceBundle rb = ResourceBundle.getBundle("com.rays.advance.bundle.app",
		// new Locale("en"));

		// ResourceBundle rb = ResourceBundle.getBundle("com.rays.advance.bundle.app",
		// new Locale("hi"));
		ResourceBundle rb = ResourceBundle.getBundle("com.rays.advance.bundle.app", new Locale("sp"));
		System.out.println(rb.getString("greeting"));

	}
}
