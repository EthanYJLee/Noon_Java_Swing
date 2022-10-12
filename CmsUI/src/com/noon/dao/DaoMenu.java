package com.noon.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import com.noon.component.Menu;
import com.noon.main.Login;
import com.noon.util.DBConnect;

public class DaoMenu {
	// 필요한 변수가 그러면, price , photo , menuname, category
	private String price;
	private FileInputStream input;
	private String menuname;
	private String category;

	public DaoMenu() {

	}

	public DaoMenu(String menuname) {
		this.menuname = menuname;
	}

	public DaoMenu(String price, FileInputStream input, String menuname, String category) {
		this.price = price;
		this.input = input;
		this.menuname = menuname;
		this.category = category;
	}

	public boolean addMenu() {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);

			String A = "insert into menu (name, price, category, photo)";
			String B = " values (?,?,?,?)";

			ps = conn_mysql.prepareStatement(A + B);
			ps.setString(1, menuname.trim());
			ps.setInt(2, Integer.parseInt(price.trim()));
			ps.setString(3, category.trim());
			ps.setBinaryStream(4, input);
			ps.executeUpdate();

			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean updateMenu() {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);

			String A = "update setting set enddate = curdate() ";
			String B = "where enddate is null and menu_name = ?";

			ps = conn_mysql.prepareStatement(A + B);
			ps.setString(1, menuname.trim());
			ps.executeUpdate();

			String C = "insert into setting (initdate ,menu_name ,shop_shopcode ,categorynow ,pricenow ,photonow)";
			String D = " values (curdate(),?,?,?,?,?)";

			ps = conn_mysql.prepareStatement(C + D);
			ps.setString(1, menuname.trim());
			ps.setInt(2, getShopcode());
			ps.setString(3, category.trim());
			ps.setInt(4, Integer.parseInt(price.trim()));
			ps.setBinaryStream(5, input);
			ps.executeUpdate();

			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean deleteMenu() {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			@SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();

			String A = "update setting set enddate = curdate() ";
			String B = "where enddate is null and menu_name = ?";

			ps = conn_mysql.prepareStatement(A + B);
			ps.setString(1, menuname.trim());
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

	public ArrayList<Menu> showMenu() {
		ArrayList<Menu> menuList = new ArrayList<>();
		;
		String whereStatement = "select menu_name , photonow from setting where shop_shopcode = " + getShopcode()
				+ " and enddate is null";

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
				int i = 0;
				File check = new File(filepath);
				while (check.exists()) {
					filepath += 1;
					check = new File(filepath);
					i++;
				}

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
				menu.getLblMenuImage().setIcon(new ImageIcon(filepath));
				menu.getLblMenuName().setText(wkName);
				menu.setNumOfOne(i);
				menuList.add(menu);
				

			}

			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menuList;
	}

}
