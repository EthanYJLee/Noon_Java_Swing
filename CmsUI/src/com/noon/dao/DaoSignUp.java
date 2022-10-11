package com.noon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JPanel;

import com.noon.util.DBConnect;

public class DaoSignUp extends JPanel {
	private String tfEmployeeNo;
	private String tfName;
	private String tfID;
	private String pfPassword;
	private String pfPasswordCheck;
	private String tfStoreNo;


	public DaoSignUp(String tfID) {
		super();
		this.tfID = tfID;
	}
	
	public DaoSignUp(String tfID, String pfPassword) {
		this.tfID = tfID;
		this.pfPassword = pfPassword;
	}
	
	
	public DaoSignUp(String tfEmployeeNo, String tfName, String tfID, String pfPassword, String pfPasswordCheck,
			String tfStoreNo) {
		super();
		this.tfEmployeeNo = tfEmployeeNo;
		this.tfName = tfName;
		this.tfID = tfID;
		this.pfPassword = pfPassword;
		this.pfPasswordCheck = pfPasswordCheck;
		this.tfStoreNo = tfStoreNo;
	}





	// 1번 메소드
		public String loginAction() {
			String whereStatement = "select count(id and password) from guest where id = '" + tfID + "' and password = '" + pfPassword + "'";
			int i = 0;
			String loginId = "";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver"); 
				Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
						DBConnect.pw_mysql); 
				Statement stmt_mysql = conn_mysql.createStatement(); 

				ResultSet rs = stmt_mysql.executeQuery(whereStatement);
				
				while(rs.next()) {
					i = rs.getInt(1);
					if(i == 1) {
						loginId = tfID;
					}
				}
				
				
				conn_mysql.close();
				
				
			} catch (Exception e) {
				e.printStackTrace(); 
			}
			return loginId;
		}
		
		// 2번 메소드
		public boolean overlapCheck() {
			String whereStatement = "select count(id) from guest where id = '" + tfID + "'";
			boolean result = false;
			int i = 0;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver"); 
				Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
						DBConnect.pw_mysql); 
				Statement stmt_mysql = conn_mysql.createStatement(); 

				ResultSet rs = stmt_mysql.executeQuery(whereStatement);
				
				if(rs.next()) {
					i = rs.getInt(1);
				}
				
				
				if( i == 0) {
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
		
		// 3번 메소드
		public boolean makeAccount() {
			boolean result = false;
			PreparedStatement ps = null;
			int i = 0;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver"); 
				Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
						DBConnect.pw_mysql); 
				String query = "insert into guest (id,password,address,name,phone,email,init_date) ";
				String query1 = "values (?,?,?,?,?,?,now())";

				ps = conn_mysql.prepareStatement(query + query1);
				ps.setString(1, tfEmployeeNo);
				ps.setString(2, tfName);
				ps.setString(3, tfID);
				ps.setString(4, pfPassword);
				ps.setString(5, pfPasswordCheck);
				ps.setString(6, tfStoreNo);
				i = ps.executeUpdate(); 

				conn_mysql.close();
				
				if(i == 1) {
					result = true;
				}

			} catch (Exception e) {
				e.printStackTrace(); 
			}
			
			
			return result;
		}

}
