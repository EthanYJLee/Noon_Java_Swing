package com.noon.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.noon.dto.DtoMenu;
import com.noon.util.DBConnect;

public class DaoMenu {
	
//    private final String url_mysql = DBConnect.url_mysql;
//    private final String id_mysql = DBConnect.id_mysql;
//    private final String pw_mysql = DBConnect.pw_mysql;

	// Fields
	String name;
	String category;
	int price;
	String filename;
	FileInputStream file;
	
	// Constructor
	public DaoMenu() {
		// TODO Auto-generated constructor stub
	}
	
	
	public DaoMenu(String category) {
		super();
		this.category = category;
	}
	
	public DaoMenu(String name, String category, int price, String filename, FileInputStream file) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.filename = filename;
		this.file = file;
	}


	// Method
	public ArrayList<DtoMenu> menuList() {

		ArrayList<DtoMenu> BeanList = new ArrayList<DtoMenu>();

		String whereStatement = "select s.menu_name, s.pricenow, s.photonow from setting s, menu m ";
		String whereStatement2 = "where m.name = s.menu_name and s.enddate is null ";
		String whereStatement3 = "and s.shop_shopcode = '1'";
//		String whereStatement3 = "and s.shop_shopcode = '" + Panel05Order01Shop.shopcode + "'";
		
		//select s.menu_name, s.pricenow, s.photonow from setting s, menu m 
		//where m.name = s.menu_name and s.enddate is null and s.shop_shopcode = 1;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2 + whereStatement3);

			int wkFilename = 0;
			while (rs.next()) { // true값일때만 가져온다

				String wkName = rs.getString(1);
				int wkPrice = rs.getInt(2);
//				String wkFilename = rs.getString(3);
//				
	           	// File
            	wkFilename=wkFilename+1;
            	File file = new File("./" + (wkFilename));
            	
            	FileOutputStream output = new FileOutputStream(file);
            	InputStream input = rs.getBinaryStream(3);
                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    output.write(buffer);
                }

                DtoMenu dtoMenu = new DtoMenu(wkName, wkPrice, wkFilename);
				BeanList.add(dtoMenu);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return BeanList;

	}
}
