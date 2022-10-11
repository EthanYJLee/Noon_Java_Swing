package com.noon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.noon.dto.DtoShop;
import com.noon.util.DBConnect;

public class DaoShop {

	// fields
	int shopcode;
	String name;
	String province;
	String city;
	String town;
	String village;
	String phone;
	String opentime;
	String closetime;
	String conname;
	String condata;
	
	// Constructor
	public DaoShop() {
		// TODO Auto-generated constructor stub
	}
	
	public DaoShop(String conname, String condata) {
		super();
		this.conname = conname;
		this.condata = condata;
	}

	public DaoShop(String name) {
		super();
		this.name = name;
	}

	// Method
	// 조건 검색 결과를 Table로
	public ArrayList<DtoShop> conditionList(){
		
		ArrayList<DtoShop> dtoShopList = new ArrayList<DtoShop>();
		
		String whereStatement = "select name, province, city, town, phone, opentime, closetime from shop ";
		String whereStatement2 = "where " + conname + " like '%" + condata + "%'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
	
			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);
	
			while (rs.next()) { // true값일때만 가져온다
				
				String wkName = rs.getString(1);
				String wkProvince = rs.getString(2);
				String wkCity = rs.getString(3);
				String wkTown = rs.getString(4);
				String wkPhone = rs.getString(5);
				String wkOpenTime = rs.getString(6);
				String wkCloseTime = rs.getString(7);
			
				DtoShop dtoShop = new DtoShop(wkName, wkProvince, wkCity, wkTown, wkPhone, wkOpenTime, wkCloseTime);
				dtoShopList.add(dtoShop);
			}
	
			conn_mysql.close();
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoShopList;

	}
	
	// Table을 Click하였을 경우
		public int tableClick() {
			
			int i = 0;
			String whereStatement = "select shopcode from shop "; // 마지막 띄워주기
			String whereStatement2 = "where name = '" + name + "'";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();
		
				ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);
		
				if (rs.next()) { // true값일때만 가져온다
					i = rs.getInt(1);
				}
		
				conn_mysql.close();
		
			} catch (Exception e) {
				e.printStackTrace();
			}
			return i;
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	

} // End
