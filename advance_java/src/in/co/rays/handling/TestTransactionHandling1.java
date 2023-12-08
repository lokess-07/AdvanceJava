package in.co.rays.handling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestTransactionHandling1 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");

		conn.setAutoCommit(false);

		Statement stmt = conn.createStatement();
		int i = stmt.executeUpdate("insert into emp values (6,'deepak',1122)");
		i = stmt.executeUpdate("insert into emp values (6,'nikhil',1122)");
		//conn.commit();
		System.out.println("data inserted "+i);
	}
}
