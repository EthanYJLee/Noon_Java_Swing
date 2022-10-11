package com.noon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import com.noon.util.DBConnect;

public class DaoManager {
	private String id;
	private String pw;
	private String name;
	private int employeeno;
	
	
	
	
	public DaoManager(String id, String pw, String name, int employeeno) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.employeeno = employeeno;
	}




	public boolean insertManager() {
		boolean result = false;
		PreparedStatement ps = null;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); 
			String query = "insert into manager (id,pw,name,employeeno) ";
			String query1 = "values (?,?,?,?)";

			ps = conn_mysql.prepareStatement(query + query1);
			
			ps.setString(1,id);
			ps.setString(2, pw);
			ps.setString(3, name);
			ps.setInt(4, employeeno);
//			ps.setString(1,Panel1.id);
//			ps.setInt(2,Panel4.detail_no);
//			ps.setInt(3,Panel3.clickNo);
//			ps.setInt(4, price);
//			ps.setInt(5, amount);
			
			int i = ps.executeUpdate(); 
			
			if(i == 1) {
				result = true;
			}else {
				result = false;
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return result;
	}
}
