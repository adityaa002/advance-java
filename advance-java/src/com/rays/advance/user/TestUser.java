package com.rays.advance.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import com.rays.advance.marksheet.MarksheetBean;

public class TestUser {

	public static void main(String[] args) throws Exception {

		// testAdd();
		// testUpdate();
		// testDelete();
		// testFindByPk();
		// testFindBylogin();
		// testSearch();
		testAuth();
	}

	public static void testAdd() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		UserBean bean = new UserBean();
		bean.setFirstName("ashwin");
		bean.setLastName("dubey");
		bean.setLoginId("ashhwin@998");
		bean.setPassword("win665");
		bean.setDob(sdf.parse("15/02/2001"));
		bean.setAddress("Sehore");

		UserModel model = new UserModel();
		model.add(bean);

	}

	public static void testUpdate() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		UserBean bean = new UserBean();
		bean.setFirstName("shreyy");
		bean.setLastName("tiwari");
		bean.setLoginId("shreytiwari001@");
		bean.setPassword("shrey1234");
		bean.setDob(sdf.parse("31/09/2003"));
		bean.setId(5);

		UserModel model = new UserModel();
		model.upate(bean);
	}

	public static void testDelete() throws Exception {
		UserModel model = new UserModel();
		model.delete(4);
	}

	public static void testFindByPk() throws Exception {
		UserModel model = new UserModel();
		model.findPk(5);
	}

	public static void testFindBylogin() throws Exception {
		UserModel model = new UserModel();
		model.findByLogin("adityaa002");
	}

	public static void testSearch() throws Exception {
		UserBean bean = new UserBean();

		UserModel model = new UserModel();

		List list = model.search(bean, 1, 2);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			bean = (UserBean) it.next();
			System.out.print(bean.getId());

		}

	}

	public static void testAuth() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = model.authenticate("adityaa002", "adi123");

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLogin());
			System.out.print("\t" + bean.getPassword());
			System.out.println("\t" + bean.getDob());
		} else {
			System.out.println("Invalid credentials!! Enter valid ");
		}

	}
}
