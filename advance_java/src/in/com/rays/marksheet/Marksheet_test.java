package in.com.rays.marksheet;

public class Marksheet_test {
	public static void main(String[] args) throws Exception {
//		testadd();
//		testDelete();
		testUpdate();
	}
		
		private static void testDelete() throws Exception {
			Marksheet_model modal2 = new Marksheet_model();
			modal2.delete(1);
		
	}

	private static void testadd() throws Exception {
		Marksheet_Bean bean = new Marksheet_Bean();
		bean.setId(22);
		bean.setName("deepak");
		bean.setRoll_no(1122);
		bean.setPhysics(66);
		bean.setChemistry(76);
		bean.setMaths(55);
		
		Marksheet_model modal = new Marksheet_model();
		
		modal.add(bean);
		
	}
	private static void testUpdate() throws Exception {
		Marksheet_Bean bean = new Marksheet_Bean();
		bean.setName("om");
		bean.setId(3);
		
		Marksheet_model modal = new Marksheet_model();
		
		modal.update(bean);

	}
}
