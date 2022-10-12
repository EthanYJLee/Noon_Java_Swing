package com.noon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.noon.base.Panel05Order01Shop;
import com.noon.util.DBConnect;

public class DaoComplete {

	// Fields
	int completeno;
	String completetime;
	String accepttime;
	
	
	// Constructor
	public DaoComplete() {
		// TODO Auto-generated constructor stub
	}
	
	
	// Method
	// 남은 잔수 계산하기
	public int selectQuantity() {

		int i = 0;
		String whereStatement = "select count(completetime) from complete ";
		String whereStatement2 = "where shop_shopcode = '" + Panel05Order01Shop.shopcode + "' ";
		String whereStatement3 = "and completetime between curdate() and now()"; // 오늘날짜 00:00:00 ~ 지금

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2 + whereStatement3);

			if (rs.next()) { // true값일때만 가져온다
				i = 1000 - rs.getInt(1);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;

	}
	
	
	
} // End
