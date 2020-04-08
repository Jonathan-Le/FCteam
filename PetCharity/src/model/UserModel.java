package model;

import java.sql.ResultSet;

import db.SqlHelper;

public class UserModel {
	
	public String CheckUser(String id, String pd) {
		String jobposition = "";
		SqlHelper sp = null;
		try {
			String sql = "select personnel_files.jobposition from login, personnel_files "
					+ "where login.empid = personnel_files.empid and login.empid = ? and login.emppassword=?";
			String paras[] = {id, pd};
			sp = new SqlHelper();
			ResultSet rs = sp.query(sql, paras);
			if(rs.next()) {
				jobposition = rs.getString(1);
				System.out.println(jobposition);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			sp.Close();
		}
		
		return jobposition;
	}
	
	
}
