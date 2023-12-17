
	package in.co.rays.user;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.ArrayList;
	import java.util.List;

	import in.co.rays.util.JDBCDataSource;

	public class UserModel{
		public void add1(UserBean bean) throws Exception {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn = null;
//			String name = "root";
//			String pass = "root";
//			String url = "jdbc:mysql://localhost:3306/company";
//			conn = DriverManager.getConnection(url,pass,name);
			Connection conn = JDBCDataSource.getConnection();
			
			PreparedStatement ps = conn.prepareStatement("insert into user values (?,?,?,?,?,?,?)");
			ps.setInt(1, bean.getId());
			ps.setString(2, bean.getFirstName());
			ps.setString(3, bean.getLastName());
			ps.setString(4, bean.getLoginId());
			ps.setString(5, bean.getPassword());
			ps.setDate(6, new java.sql.Date(bean.getDob().getTime()));
			ps.setString(7, bean.getAddress());
			
			int i = ps.executeUpdate();
			System.out.println("data inserted "+i);
		}
		
		public Integer nextpk() throws Exception {
			int nextpk =0;
			Connection conn = JDBCDataSource.getConnection();
			
			PreparedStatement ps = conn.prepareStatement("select max(id) from user");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				nextpk = rs.getInt(1);
				
			}
			return nextpk+1;	
	}
		
		public void add(UserBean bean) throws Exception {
			int pk = nextpk();
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into user values (?,?,?,?,?,?,?)");
			ps.setInt(1, pk);
			ps.setString(2, bean.getFirstName());
			ps.setString(3, bean.getLastName());
			ps.setString(4, bean.getLoginId());
			ps.setString(5,bean.getPassword());
			ps.setDate(6, new java.sql.Date (bean.getDob().getTime()));
			ps.setString(7, bean.getAddress());
			int i = ps.executeUpdate();
			System.out.println("data inserted "+i);
		}
		
		
		public  UserBean authonticate(String loginId,String password)throws Exception{
		  	  Connection conn=JDBCDataSource.getConnection();
		  	    PreparedStatement ps=conn.prepareStatement("select * from user where loginId = ? and password= ?");
		  	    ps.setString(1, loginId);
		  	    ps.setString(2, password);
		  	    ResultSet rs=ps.executeQuery();
		  	    UserBean bean=null;
		  	    while(rs.next()) {
		  	    	bean=new UserBean();
		  	    bean.setId(rs.getInt(1));
		  	    bean.setFirstName(rs.getString(2));
		  	    bean.setLastName(rs.getString(3));
		  	    bean.setAddress(rs.getString(7));
		  	    bean.setDob(rs.getDate(6));
		  	    }
		  	    return bean;
		}
		
		public List search() throws Exception {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from user");
			ResultSet rs = ps.executeQuery();
			List list = new ArrayList();
			
			while(rs.next()) {
				UserBean bn = new UserBean();
				bn.setId(rs.getInt(1));
				bn.setFirstName(rs.getString(2));
				bn.setLastName(rs.getString(3));
				bn.setLoginId(rs.getString(4));
				bn.setPassword(rs.getString(5));
				bn.setDob(rs.getDate(6));
				bn.setAddress(rs.getString(7));
				list.add(bn);
			}
			return list;
	}
		
		public void delete(int id ) throws Exception {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("delete from user where id = ?");
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			System.out.println("data deleted "+i);
			
		}
		public void update (UserBean bean) throws Exception {
			Connection conn = JDBCDataSource.getConnection();
			
			PreparedStatement ps = conn.prepareStatement("update user set loginId = ? where firstName = ?");
			ps.setString(1, bean.getLoginId());
			ps.setString(2, bean.getFirstName());
			int i = ps.executeUpdate();
			System.out.println("data updated "+i);
			
		}
		public UserBean forgetPassword(String password,String loginId) throws Exception {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("update user set password = ? where loginId=?");
			ps.setString(1,password);
			ps.setString(2, loginId);
			int i = ps.executeUpdate();
			UserBean bean = null;
			return bean;
			
		}
	}
