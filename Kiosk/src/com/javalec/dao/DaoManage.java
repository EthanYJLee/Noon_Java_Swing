package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.util.DBConnect;

public class DaoManage {
	int manageno;
	
	int shopcode;
	int employeeno;
	
	public DaoManage() {
		// TODO Auto-generated constructor stub
	}

	public DaoManage(int shopcode, int manageno) {
		super();
		this.shopcode = shopcode;
		this.manageno = manageno;
		
	}

	public DaoManage(int manageno, int shopcode, int employeeno) {
		super();
		this.manageno = manageno;
		this.shopcode = shopcode;
		this.employeeno = employeeno;
	}
	
	public int loginAction() {
		String whereStatement = "select count(shopcode) from shop where shopcode = " + shopcode;
		String whereStatement2 = "select count(shop_shopcode) from manage where shop_shopcode = " + shopcode;
					
		int result = 0;
		int i = 0;
		int j = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); 
			Statement stmt_mysql = conn_mysql.createStatement(); 

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);
			
			if(rs.next()) {
				i = rs.getInt(1);
			}
			
			rs = stmt_mysql.executeQuery(whereStatement2);
			
			if(rs.next()) {
				j = rs.getInt(1);
			}
			
			
			if( i == 1 && j == 0) {
				result = 0;
			}else if ( i == 1){
				result = 1;
			}else {
				result = -1;
			}
			

			conn_mysql.close();
			
			
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return result;
		
	}

}
