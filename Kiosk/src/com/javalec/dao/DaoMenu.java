package com.javalec.dao;

import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import com.javalec.base.LogIn;
import com.javalec.component.Menu;
import com.javalec.dto.DtoMenu;
import com.javalec.util.DBConnect;

public class DaoMenu {
	String name;
	String category;
	int price;

	String concategory;

	public DaoMenu() {
		// TODO Auto-generated constructor stub
	}

	public DaoMenu(String name, String category, int price) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public DaoMenu(String conname) {
		super();
		this.concategory = conname;
	}
	
	
	public ArrayList<Menu> showMenu() {
		ArrayList<Menu> menuList = new ArrayList<>();
		
		String whereStatement = "select menu_name, photonow from setting where shop_shopcode in( " + LogIn.shopcode + ", 0) and enddate is null";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			while (rs.next()) {
				String wkName = rs.getString(1);
				// File
				String filepath = "./" + wkName;
				File file = new File(filepath);
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(2);
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = input.read(buffer)) != -1) {
					output.write(buffer, 0, len);
				}
				input.close();
				output.close();

				Menu menu = new Menu();
				ImageIcon icon = new ImageIcon(filepath);
				Image img = icon.getImage();
				Image changeImg = img.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
				menu.getLblMenuImage().setIcon(new ImageIcon(changeImg));
				menu.getLblMenuName().setText(wkName);
				menuList.add(menu);
				

			}

			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menuList;
	}

	public int getShopcode() {
		int shopcode = 0;
		String whereStatement = "select shop_shopcode from hire where staff_id = '" + LogIn.kiosk_id + "'";
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
