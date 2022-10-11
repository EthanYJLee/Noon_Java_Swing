package com.noon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.noon.main.Login;
import com.noon.util.DBConnect;

public class DaoHeader {

	// 1번 메소드 header에 가게이름 , 이름 , 사진 바꾸기
	// manager 테이블에서 id를 일단 가져온다.
	public String getName() {
		String name = "";
		String whereStatement = "select name from " + Login.type + " where id = '" + Login.id + "'";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			if (rs.next()) {
				name = rs.getString(1);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}

	// 매니저 id로 지정된 가게 이름을 가져온다.
	public String getManagerShopName() {
		String shopName = null;
		String whereStatement = "select s.name from shop s , manage m where m.manager_id = '" + Login.id
				+ "' and m.shop_shopcode = s.shopcode";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			if (rs.next()) {
				shopName = rs.getString(1);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return shopName;
	}
	
	// 아르바이트 id로 된 매장 이름을 가져온다. 
	public String getParttimeShopName() {
		String shopName = null;
		String whereStatement = "select s.name from shop s , hire h where h.staff_id = '" + Login.id
				+ "' and h.shop_shopcode = s.shopcode";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			if (rs.next()) {
				shopName = rs.getString(1);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return shopName;
	}
	
}
