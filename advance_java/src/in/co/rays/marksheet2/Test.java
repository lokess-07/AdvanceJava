package in.co.rays.marksheet2;

import java.util.Iterator;
import java.util.List;

import in.co.rays.marksheet.Marksheet_Bean;
import in.co.rays.marksheet.Marksheet_model;

public class Test {
	public static void main(String[] args) throws Exception  {
		//testbyid();
		testsearch1();
		  //testadd();
		
		
	}
	private static void testadd() throws Exception {

			Bean bean = new Bean();
			bean.setName("deepak");
			bean.setRoll_no(1122);
			bean.setPhysics(66);
			bean.setChemistry(76);
			bean.setMaths(55);
			
			Model modal = new Model();
			
			modal.add1(bean);
		
	}
	private static void testsearch1() throws Exception {
		Model md = new Model();
		List list = md.search();
		Iterator it = list.iterator();
		while(it.hasNext()) {
			Bean bn = (Bean) it.next();
			System.out.print(bn.getId());
			System.out.print("\t"+bn.getName());
			System.out.print("\t"+bn.getRoll_no());
			System.out.print("\t"+bn.getPhysics());
			System.out.print("\t"+bn.getChemistry());
			System.out.println("\t"+bn.getMaths());
		}
		
		
	}
	private static void testbyid() throws Exception {
		Model md = new Model();
		Bean bn = md.findByid(3);
		if (bn!=null)	{
			System.out.print(bn.getId());
			System.out.print("\t"+bn.getName());
			System.out.print("\t"+bn.getRoll_no());
			System.out.print("\t"+bn.getPhysics());
			System.out.print("\t"+bn.getChemistry());
			System.out.println("\t"+bn.getMaths());
		}
		else {
			System.out.println("id dos not exist.....!!!");
		}
		
	}
}
