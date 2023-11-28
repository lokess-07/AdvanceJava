package in.com.rays.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestAdd {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = null;
		String name = "root";
		String pass = "root";
		String url = "jdbc:mysql://localhost:3306/xyz";
		conn = DriverManager.getConnection(url, pass, name);

		Statement stmt = conn.createStatement();

		int j = stmt.executeUpdate("insert into xyz values(12,34),(12,65)");

		System.out.println("Data Inserted = " + j);
	}
	}

