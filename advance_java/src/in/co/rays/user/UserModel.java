package in.co.rays.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import in.co.rays.util.JDBCDataSource;

public class UserModel {
	public void add(UserBean bean) throws Exception {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection conn = null;
//		String name = "root";
//		String pass = "root";
//		String url = "jdbc:mysql://localhost:3306/company";
//		conn = DriverManager.getConnection(url,pass,name);
		Connection conn = JDBCDataSource.getConnection();
		
		PreparedStatement ps = conn.prepareStatement("insert into user values (?,?,?,?,?,?,?)");
		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getFirstName());
		ps.setString(3, bean.getLastName());
		ps.setString(4, bean.getLoginId());
		ps.setString(5, bean.getPassword());
		ps.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(7, bean.getAddress()
				);
		int i = ps.executeUpdate();
		System.out.println("data inserted "+i);
	}
	public void delete(int id ) throws Exception {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("delete from user where id = ?");
		ps.setInt(1, id);
		int i = ps.executeUpdate();
		System.out.println("data deleted "+i);
		
	}
	public void update (UserBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		String name = "root";
		String pass = "root";
		String url = "jdbc:mysql://localhost:3306/company";
		conn = DriverManager.getConnection(url,pass,name);
		
		PreparedStatement ps = conn.prepareStatement("update user set password = ? where firstName = ?");
		ps.setString(1, bean.getPassword());
		ps.setString(2, bean.getFirstName());
		int i = ps.executeUpdate();
		System.out.println("data updated "+i);
		
	}
	
}
