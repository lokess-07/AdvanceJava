package in.co.rays.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;

public class Testprocedure {
	static Connection conn= null;
	public static void main(String[] args) throws Exception {

				Class.forName("com.mysql.cj.jdbc.Driver");

				 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");
				//empIn();
				empOut();
				//empInOut();

	}
	public static void empInOut() throws Exception {

				CallableStatement callStmt = conn.prepareCall("{CALL empInOut(?)}");
			
				callStmt.setInt(1, 1);
			
				callStmt.registerOutParameter(1, Types.INTEGER);

				callStmt.execute();

				System.out.println(callStmt.getInt(1));

	}
	public static void empOut() throws Exception {

				CallableStatement callStmt = conn.prepareCall("{CALL empOut(?)}");

				callStmt.registerOutParameter(1, Types.INTEGER);
				
				//callStmt.execute();
				ResultSet rs = callStmt.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getInt(1));
				}
				
				

				System.out.println(callStmt.getInt(1));	
	}
	public static void empIn() throws Exception {
		CallableStatement callStmt = conn.prepareCall("{CALL empIN(?)}");

		callStmt.setInt(1, 1);

		callStmt.execute();

		ResultSet rs = callStmt.getResultSet();

		while (rs.next()) {

			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getInt(3));
			
		}
	}
}