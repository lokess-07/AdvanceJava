package in.co.rays.marksheet;

import java.util.Iterator;

import in.co.rays.marksheet2.Bean;
import in.co.rays.marksheet2.Model;

public class Marksheet_Test {
	public static void main(String[] args) throws Exception  {
		delete();
		update();
		  add();
		
		
	}
	private static void add() throws Exception {

		Marksheet_Bean bean = new Marksheet_Bean();
			bean.setName("deepak");
			bean.setRoll_no(1122);
			bean.setPhysics(66);
			bean.setChemistry(76);
			bean.setMaths(55);
			
			Marksheet_model modal = new Marksheet_model();
			
			modal.add(bean);
		
	}
	private static void update() throws Exception {
		Marksheet_model md = new Marksheet_model();
		Marksheet_Bean bean = new Marksheet_Bean();
		bean.setName("Kaluwa");
		bean.setId(2);
		}
		
	private static void delete() throws Exception {
		Marksheet_model md = new Marksheet_model();
		 md.delete(2);
		
		
	}
}

