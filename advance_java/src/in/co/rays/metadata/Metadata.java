package in.co.rays.metadata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Metadata {
	public static void main(String[] args) throws Exception {
		addMetaData();
	}
	
	public static void addMetaData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");
		PreparedStatement ps = conn.prepareStatement("select * from marksheet");
		ResultSet rs = ps.executeQuery();
		ResultSetMetaData rsmt = rs.getMetaData();
//		System.out.println("catelog name "+ rsmt.getCatalogName(1));
//		System.out.println("table name "+rsmt.getTableName(1));
		int columnCount = rsmt.getColumnCount();
		System.out.println("total column "+columnCount);
		for(int i=1;i<columnCount;i++) {
			System.out.println("Column :"+i);
			System.out.println("Lable :"+rsmt.getColumnLabel(i));
			System.out.println("Name :"+rsmt.getColumnName(i));
			System.out.println("Type :"+rsmt.getColumnTypeName(i));
			System.out.println("Size :"+rsmt.getColumnDisplaySize(i));
			System.out.println("precision :"+rsmt.getPrecision(i));
			System.out.println();
		}
	}
}