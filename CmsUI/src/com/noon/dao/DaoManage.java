package com.noon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.noon.util.DBConnect;

public class DaoManage {
	private int shopcode;
	private String manager_id;
	
	public DaoManage(int shopcode, String manager_id) {
		this.shopcode = shopcode;
		this.manager_id = manager_id;
	}
	

	public boolean insertManage() {
		boolean result = false;
		PreparedStatement ps = null;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); 
			String query = "insert into manage (startdate,shop_shopcode,manager_id) ";
			String query1 = "values (curdate(),?,?)";

			ps = conn_mysql.prepareStatement(query + query1);
			
			ps.setInt(1,shopcode);
			ps.setString(2, manager_id);
			
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
