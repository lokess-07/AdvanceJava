package in.co.rays.Marksheet3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.marksheet2.Bean;

public class Model3 {
	public List search(Bean3 bean,int pageno,int pagesize) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		String name = "root";
		String pass = "root";
		String url = "jdbc:mysql://localhost:3306/company";
		conn = DriverManager.getConnection(url,pass,name);
		StringBuffer sql = new StringBuffer("select * from marksheet where 1=1 ");
		if(bean!=null) {
			if(bean.getName()!=null && bean.getName().length()>0);{
			sql.append(" and name like '"+bean.getName()+"%'");
		}
		if(bean.getRoll_no()>0) {
			sql.append(" and roll_no = "+bean.getRoll_no()+" ");
		}
		}
		if(pagesize>0) {
			pageno=(pageno-1)*pagesize;
			sql.append(" limit "+pageno+","+pagesize);
		}
		System.out.println(sql);
		
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		List list = new ArrayList();
		
		while(rs.next()) {
			 bean = new Bean3();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRoll_no(rs.getInt(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			list.add(bean);
		}
		return list;

}
}