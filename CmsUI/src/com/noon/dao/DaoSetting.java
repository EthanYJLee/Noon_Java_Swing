package com.noon.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.noon.dto.DtoSetting;
import com.noon.form.manager.ManagerForm3;
import com.noon.main.Login;
import com.noon.util.DBConnect;

public class DaoSetting {
	private String menuname;
	private InputStream input;
	private int price;
	private String category;


	public DaoSetting() {
		// TODO Auto-generated constructor stub
	}
	
	public DaoSetting(int price, String category, InputStream input, String menuname) {
		super();
		this.price = price;
		this.category = category;
		this.input = input;
		this.menuname = menuname;
	}
	
	public DtoSetting setTf() {
		DtoSetting dto = null;

		String whereStatement = "select pricenow,categorynow , menu_name from setting where menu_name = '"
				+ ManagerForm3.menuname + "' and shop_shopcode = " + getShopcode() + " and enddate is null";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			if (rs.next()) { // true값일때만 가져온다
				int pricenow = rs.getInt(1);
				String categorynow = rs.getString(2);
				String menuname = rs.getString(3);

				dto = new DtoSetting(menuname, categorynow, pricenow);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public boolean addSetting() {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);

			String A = "insert into setting (initdate ,menu_name ,shop_shopcode ,categorynow ,pricenow ,photonow";
			String B = ") values (curdate(),?,?,?,?,?)";

			ps = conn_mysql.prepareStatement(A + B);
			ps.setString(1, menuname.trim());
			ps.setInt(2, getShopcode());
			ps.setString(3, category.trim());
			ps.setInt(4, price);
			ps.setBinaryStream(5, input);
			ps.executeUpdate();

			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public int getShopcode() {
		int shopcode = 0;
		String whereStatement = "select shop_shopcode from manage where manager_id = '" + Login.id + "'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			if (rs.next()) { // true값일때만 가져온다
				shopcode = rs.getInt(1);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return shopcode;
	}
}
