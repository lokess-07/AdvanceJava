package in.co.rays.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedStatement1 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");
		PreparedStatement ps = conn.prepareStatement("insert into marksheet values (27,'arvind',786,44,33,22)");
				int i = ps.executeUpdate();
				System.out.println(i);
	}
}
