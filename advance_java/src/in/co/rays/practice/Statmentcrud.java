package in.co.rays.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Statmentcrud {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=null;
		String name = "root";
		String pass = "root";
		String url = "jdbc:mysql://localhost:3306/company";
		conn = DriverManager.getConnection(url,pass,name);
		
		Statement  stmt=conn.createStatement();
		//int i = stmt.executeUpdate("insert into xyz values(22,33)");
		//int i = stmt.executeUpdate("delete from xyz where id = 22");
		//int i = stmt.executeUpdate("update xyz set age = 34 where id = 22");
		ResultSet rs = stmt.executeQuery("select * from marksheet");
		while(rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t"+rs.getString(2));
			System.out.print("\t"+rs.getInt(3));
			System.out.print("\t"+rs.getInt(4));
			System.out.print("\t"+rs.getInt(5));
			System.out.println("\t"+rs.getInt(6));
			
		}
	}
}
