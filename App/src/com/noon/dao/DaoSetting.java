package com.noon.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.noon.base.Panel05Order01Shop;
import com.noon.base.Panel05Order03Menu;
import com.noon.util.DBConnect;

public class DaoSetting {

	// Fields
	int setno;
	String initdate;
	String enddate;
	int pricenow;
	String photonow;
	String menu_name;
	int shop_shopcode;
	
	// Constructor
	public DaoSetting() {
		// TODO Auto-generated constructor stub
	}

	//Method
	public ArrayList<DtoSetting> menuList() {

		ArrayList<DtoSetting> BeanList = new ArrayList<DtoSetting>();

		String whereStatement = "select s.setno, s.menu_name, m.category, s.pricenow, s.photonow from setting s, menu m ";
		String whereStatement2 = "where m.name = s.menu_name and s.enddate is null ";
		String whereStatement3 = "and s.shop_shopcode = '" + Panel05Order01Shop.shopcode +"'";

		// select s.menu_name, s.pricenow, s.photonow from setting s, menu m
		// where m.name = s.menu_name and s.enddate is null and s.shop_shopcode = 1;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2 + whereStatement3);

			int wkFilename = 0;
			while (rs.next()) { // true값일때만 가져온다

				int wkSetno = rs.getInt(1);
				String wkMenuName = rs.getString(2);
				String wkCategory = rs.getString(3);
				int wkPrice = rs.getInt(4);
				
				// File
				wkFilename = wkFilename + 1;
				File file = new File("./" + wkFilename);

				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(5);
				byte[] buffer = new byte[1024];
				while (input.read(buffer) > 0) {
					output.write(buffer);
				}

				DtoSetting dtoSetting = new DtoSetting(wkSetno, wkPrice, wkMenuName, wkFilename);
				BeanList.add(dtoSetting);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return BeanList;

	}
	
	public DtoSetting tableClick() {

		DtoSetting dtoSetting = null;
		String whereStatement = "select s.setno, m.category, s.photonow from setting s, menu m "; // 마지막 띄워주기
		String whereStatement2 = "where m.name = s.menu_name ";
		String whereStatement3 = "and name = '" + Panel05Order03Menu.selectedMenu + "'";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2 + whereStatement3);

			int wkFilename = 0;
			if (rs.next()) { // true값일때만 가져온다
				
				int wkSetno= rs.getInt(1);
				String wkCategory = rs.getString(2);
				
				// File
				wkFilename = wkFilename + 1;
				File file = new File("./" + wkFilename);

				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(3);
				byte[] buffer = new byte[1024];
				while (input.read(buffer) > 0) {
					output.write(buffer);
				}

				dtoSetting = new DtoSetting(wkSetno, wkFilename, wkCategory);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoSetting;

	}
	
	
} // End
