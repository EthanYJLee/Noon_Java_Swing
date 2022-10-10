package com.javalec.dao;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
	
	public ArrayList<DtoMenu> selectList(String concategory){
		
		ArrayList<DtoMenu> dtoList = new ArrayList<DtoMenu>();

		String whereStatement = "select name, price, photo from menu ";
		String whereStatement2 = "where category = " + concategory;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
	
			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);
	
			while (rs.next()) {
				
				String wkName = rs.getString(1); 
				int wkPrice = rs.getInt(2);
			
				DtoMenu dto = new DtoMenu(wkName, wkPrice);
				dtoList.add(dto);
			}
	
			conn_mysql.close();
	
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return dtoList;

	}
	



	
}
