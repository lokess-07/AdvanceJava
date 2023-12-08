package in.co.rays.Preparedststement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;




public class ReadData {
public static void main(String[] args)throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");

	Connection conn = null;
	String name = "root";
	String pass = "root";
	String url = "jdbc:mysql://localhost:3306/xyz";
	conn = DriverManager.getConnection(url, pass, name);
	PreparedStatement ps = conn.prepareStatement("delete from xyz where id = 12");
	int i = ps.executeUpdate();
	System.out.println(i);
}
}
