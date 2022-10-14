package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.util.DBConnect;

public class DaoManage {
	int manageno;
	int shop_shopcode;
	String manager_id;
	
	String id;
	String pw;

	public DaoManage() {
		// TODO Auto-generated constructor stub
	}

	public DaoManage(int shop_shopcode, String manager_id) {
		super();
		this.shop_shopcode = shop_shopcode;
		this.manager_id = manager_id;
	}
	
	public DaoManage(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public int loginAction() {
		String whereStatement = "select count(*) from manage ";
		String whereStatement2 = "where shop_shopcode = '" + shop_shopcode + "' and manager_id = '" + manager_id + "'";
		int result = 0;
		int i = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			if (rs.next()) {
				i = rs.getInt(1);
				if (i == 1) {
					result = 1;
				} else {
					result = 0;
				}
			}
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int loginAction2() {
		String whereStatement = "select count(*) from staff ";
		String whereStatement2 = "where id = '" + id + "' and pw = '" + pw + "'";
		int result = 0;
		int i = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			if (rs.next()) {
				i = rs.getInt(1);
				if (i == 1) {
					result = 1;
				} else {
					result = 0;
				}
			}
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int getShopcode() {
		String whereStatement = "select shop_shopcode from hire ";
		String whereStatement2 = "where staff_id = '" + id + "'";
		int result = 0;
		int i = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			if (rs.next()) {
				i = rs.getInt(1);
				
			}
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
}
