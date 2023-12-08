package in.co.rays.Marksheet3;
import java.util.Iterator;
import java.util.List;
public class Test3 {
	public static void main(String[] args) throws Exception {
		testsearch();
	}
	private static void testsearch() throws Exception {
		Model3 md = new Model3();
		Bean3 bean = new Bean3();
		bean.setName("deepak");
		List list = md.search(bean,1,5);
		Iterator it = list.iterator();
		while(it.hasNext()) {
			bean =  (Bean3) it.next();
			System.out.print(bean.getId());
			System.out.print("\t"+bean.getName());
			System.out.print("\t"+bean.getRoll_no());
			System.out.print("\t"+bean.getPhysics());
			System.out.print("\t"+bean.getChemistry());
			System.out.println("\t"+bean.getMaths());
		}
	}
}