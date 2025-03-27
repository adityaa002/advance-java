package com.rays.advance.marksheet;

public class TestMarksheet {
	public static void main(String[] args) throws Exception {
		// testAdd();
		// testUpdate();
		// testDelete();
		testFindbyPk();

	}

	public static void testAdd() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setId(33);
		bean.setRollno(133);
		bean.setName("david");
		bean.setPhysics(67);
		bean.setChemistry(55);
		bean.setMaths(90);

		MarksheetModel model = new MarksheetModel();
		model.add(bean);
	}

	public static void testUpdate() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setRollno(333);
		bean.setName("Aditya");
		bean.setPhysics(78);
		bean.setChemistry(0);
		bean.setMaths(0);
		bean.setId(33);

		MarksheetModel model = new MarksheetModel();
		model.update(bean);

	}

	public static void testDelete() throws Exception {
		MarksheetModel model = new MarksheetModel();
		model.delete(33);
	}

	public static void testFindbyPk() throws Exception {
		MarksheetModel model = new MarksheetModel();
		model.findByPk(10);
	}
}
