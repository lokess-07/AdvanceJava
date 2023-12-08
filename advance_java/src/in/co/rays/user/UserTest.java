package in.co.rays.user;
import java.text.SimpleDateFormat;

public class UserTest {
	public static void main(String[] args) throws Exception {
		add();
		//delete();
		//update();
	}
	private static void update() throws Exception {
		UserModel model =new  UserModel();
		UserBean bean = new UserBean();
		bean.setFirstName("ravi");
		bean.setPassword("1133");
		model.update(bean); 
		
	}
	private static void delete() throws Exception {
		UserModel model =new  UserModel();
		model.delete(11);
		
		
	}
	private static void add() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserBean ub = new UserBean();
		ub.setId(15);
		ub.setFirstName("Himanshku");
		ub.setLastName("Jain");
		ub.setLoginId("himanshujain@.com");
		ub.setPassword("1144");
		ub.setDob(sdf.parse("1992-1-19"));
		ub.setAddress("indore");
		UserModel um = new UserModel();
		um.add(ub);
		
		
	}
}
