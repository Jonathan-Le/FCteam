package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlHelper {
	Connection ct = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	String url = "jdbc:mysql://127.0.0.1:3306/PetCharity?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	String user = "root";
	String passwd = "password";
	String driver = "com.mysql.jdbc.Driver";
	
	
	public SqlHelper() {
		try {
			Class.forName(driver);
			try {
				ct = DriverManager.getConnection(url, user, passwd);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public ResultSet query(String sql, String paras[]) {
		try {
			ps = ct.prepareStatement(sql);
			
			for(int i = 0; i < paras.length; i++) {
				ps.setString(i+1, paras[i]);
			}
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public void Close() {
		
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(ct != null) ct.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
