package in.co.rays.handling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestTransactionHandling2 {
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		//for not allowing duplicate entry 
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");
		conn.setAutoCommit(false);
		Statement stmt = conn.createStatement();
		int i = stmt.executeUpdate("insert into emp values (6,'deepak',1122)");
		i = stmt.executeUpdate("insert into emp values (6,'nikhil',1122)");
		i = stmt.executeUpdate("insert into emp values (7,'vinay',1122)");
		System.out.println("data inserted "+i);
		}
		
		catch(Exception e) {
			conn.rollback();
		
		}
	}
}
