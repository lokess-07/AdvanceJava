package in.co.rays.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JDBCDataSource1 {

	private static JDBCDataSource1 jds = null;

	private ComboPooledDataSource ds = null;

	private JDBCDataSource1() {

		try {

			ds = new ComboPooledDataSource();

			ds.setDriverClass("com.mysql.cj.jdbc.Driver");

			ds.setJdbcUrl("jdbc:mysql://localhost:3306/company");

			ds.setUser("root");

			ds.setPassword("root");

			ds.setInitialPoolSize(5);

			ds.setAcquireIncrement(5);

			ds.setMaxPoolSize(50);

		} catch (PropertyVetoException e) {

			e.printStackTrace();
		}
	}

	public static JDBCDataSource1 getInstance() {

		if (jds == null) {

			jds = new JDBCDataSource1();

		}

		return jds;

	}

	public static Connection getConnection() {

		try {
			return getInstance().ds.getConnection();

		} catch (SQLException e) {
			return null;
		}
	}
}
