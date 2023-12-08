package in.co.rays.marksheet2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.util.JDBCDataSource;

public class Model { 
	public Bean findByid(int id) throws Exception {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection conn = null;
//		String name = "root";
//		String pass = "root";
//		String url = "jdbc:mysql://localhost:3306/company";
//		conn = DriverManager.getConnection(url,pass,name);
		Connection conn = JDBCDataSource.getConnection();
		
		PreparedStatement ps = conn.prepareStatement("select * from marksheet where id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		Bean bn = null;
		while(rs.next()) {
			bn = new Bean();
			bn.setId(rs.getInt(1));
			bn.setName(rs.getString(2));
			bn.setRoll_no(rs.getInt(3));
			bn.setPhysics(rs.getInt(4));
			bn.setChemistry(rs.getInt(5));
			bn.setMaths(rs.getInt(6));
		}
		return bn;
	}
	public List search() throws Exception {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection conn = null;
//		String name = "root";
//		String pass = "root";
//		String url = "jdbc:mysql://localhost:3306/company";
//		conn = DriverManager.getConnection(url,pass,name);
		Connection conn = JDBCDataSource.getConnection();
		
		PreparedStatement ps = conn.prepareStatement("select * from marksheet");
		ResultSet rs = ps.executeQuery();
		List list = new ArrayList();
		
		
		
		while(rs.next()) {
			Bean bn = new Bean();
			bn.setId(rs.getInt(1));
			bn.setName(rs.getString(2));
			bn.setRoll_no(rs.getInt(3));
			bn.setPhysics(rs.getInt(4));
			bn.setChemistry(rs.getInt(5));
			bn.setMaths(rs.getInt(6));
			list.add(bn);
		}
		return list;
		
}
	public Integer nextid() throws Exception {
		int nextid =0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		String name = "root";
		String pass = "root";
		String url = "jdbc:mysql://localhost:3306/company";
		conn = DriverManager.getConnection(url,pass,name);
		
		PreparedStatement ps = conn.prepareStatement("select max(id) from marksheet");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			nextid = rs.getInt(1);
			
		}
		return nextid+1;
		
}
	public void add1(Bean bn) throws Exception {
		int id = nextid();
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = null;
		String name = "root";
		String pass = "root";
		String url = "jdbc:mysql://localhost:3306/company";
		
		conn = DriverManager.getConnection(url, pass, name);
		PreparedStatement ps = conn.prepareStatement("insert into marksheet values (?,?,?,?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, bn.getName());
		ps.setInt(3, bn.getRoll_no());
		ps.setInt(4, bn.getPhysics());
		ps.setInt(5, bn.getChemistry());
		ps.setInt(6, bn.getMaths());
		int i = ps.executeUpdate();
		System.out.println("data inserted"+i);
	}
}