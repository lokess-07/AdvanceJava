package in.com.rays.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Marksheet_model {
	public void add(Marksheet_Bean Bean) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = null;
		String name = "root";
		String pass = "root";
		String url = "jdbc:mysql://localhost:3306/company";
		
		conn = DriverManager.getConnection(url, pass, name);
		PreparedStatement ps = conn.prepareStatement("insert into marksheet values (?,?,?,?,?,?)");
		ps.setInt(1, Bean.getId());
		ps.setString(2, Bean.getName());
		ps.setInt(3, Bean.getRoll_no());
		ps.setInt(4, Bean.getPhysics());
		ps.setInt(5, Bean.getChemistry());
		ps.setInt(6, Bean.getMaths());
		int i = ps.executeUpdate();
		System.out.println("data inserted"+i);
	}
	
	public void update(Marksheet_Bean bean)throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		String name = "root";
		String pass = "root";
		String url = "jdbc:mysql://localhost:3306/company";
		conn = DriverManager.getConnection(url,pass,name);
		PreparedStatement ps = conn.prepareStatement("update marksheet set name = ? where id = ?");
		ps.setString(1,bean.getName());
		ps.setInt(2, bean.getId());
		int i = ps.executeUpdate();
		System.out.println("data updated "+i);
	}
	
	public void delete(int id) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = null;
		String name = "root";
		String pass = "root";
		String url = "jdbc:mysql://localhost:3306/company";
		
		conn = DriverManager.getConnection(url, pass, name);
		PreparedStatement ps = conn.prepareStatement("delete from marksheet where id = ? "); 
		ps.setInt(1, id);
		int i = ps.executeUpdate();
		System.out.println("data deleted "+i);
	}


}
