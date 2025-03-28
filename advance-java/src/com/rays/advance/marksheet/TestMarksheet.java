package com.rays.advance.marksheet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestMarksheet {

	public static void main(String[] args) throws Exception {
		// testPk();
		// testAdd();
		// testUpdate();
		// testDelete();
		// testFindByPk();
		testSearch();
	}

	public static void testPk() throws Exception {
		MarksheetModel model = new MarksheetModel();
		model.nextPk();
	}

	public static void testAdd() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setId(44);
		bean.setRollNo(145);
		bean.setName("pqr");
		bean.setPhysics(00);
		bean.setChemistry(00);
		bean.setMaths(00);
		MarksheetModel model = new MarksheetModel();
		model.add(bean);
	}

	public static void testUpdate() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setName("rst");
		bean.setId(45);
		bean.setRollNo(145);
		bean.setPhysics(45);
		bean.setChemistry(35);
		bean.setMaths(78);

		MarksheetModel model = new MarksheetModel();
		model.update(bean);
	}

	public static void testDelete() throws Exception {
		MarksheetModel model = new MarksheetModel();
		model.delete(46);
	}

	public static void testFindByPk() throws Exception {
		MarksheetModel model = new MarksheetModel();
		model.findByPk(10);
	}

	public static void testSearch() throws Exception {
		MarksheetBean bean = new MarksheetBean();

		MarksheetModel model = new MarksheetModel();
		List list = model.search(bean, 2, 5);
		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (MarksheetBean) it.next();
			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());
		}
	}
}
