package com.noon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.noon.util.DBConnect;

public class DaoShopup {
	int shopcode;
	String name;
	String phone;
	int shopregisterno;
	int shop_shopcode;
	String registerdate;
	String executive_id;

	public DaoShopup(int shopcode, String name, String phone) {
		super();
		this.shopcode = shopcode;
		this.name = name;
		this.phone = phone;
	}

	public DaoShopup(int shop_shopcode, String executive_id) {
		super();
		this.shop_shopcode = shop_shopcode;
		this.executive_id = executive_id;
	}

	public boolean insertShop() {
		boolean result = false;
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			String query = "insert into shop (shopcode,name,phone) ";
			String query1 = "values (?,?,?)";

			ps = conn_mysql.prepareStatement(query + query1);

			ps.setInt(1, shopcode);
			ps.setString(2, name);
			ps.setString(3, phone);
//			ps.setString(1,Panel1.id);
//			ps.setInt(2,Panel4.detail_no);
//			ps.setInt(3,Panel3.clickNo);
//			ps.setInt(4, price);
//			ps.setInt(5, amount);

			int i = ps.executeUpdate();

			if (i == 1) {
				result = true;
			} else {
				result = false;
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean insertShopregi() {
		boolean result = false;
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			String query = "insert into shopregister(shop_shopcode,executive_id,registerdate) ";
			String query1 = "values (?,?,curdate())";

			ps = conn_mysql.prepareStatement(query + query1);

			ps.setInt(1, shop_shopcode);
			ps.setString(2, executive_id);

			int i = ps.executeUpdate();

			if (i == 1) {
				result = true;
			} else {
				result = false;
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
