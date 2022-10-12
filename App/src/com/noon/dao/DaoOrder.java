package com.noon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.noon.util.DBConnect;

public class DaoOrder {

	// Fields
	int orderno;
	String ordertime;
	String refundtime;
	int hotice;
	int quantity;
	String forheretogo;
	int shot;
	int syrup;
	int size;
	int indiprice;
	int customerno;
	String member_id;
	int set_setno;
	String set_menu_name;
	int shop_shopcode;
	String staff_id;
	
	// Constructor
	public DaoOrder() {
		// TODO Auto-generated constructor stub
	}
	
	// Method
	// 입력
	public void insertActionInfo() {
		PreparedStatement ps = null;
//		int check = 0;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
//			Statement stmt_mysql = conn_mysql.createStatement();
//			
//			String query = "insert into userinfo (name, telno, address, email, relation) "; // *** 마지막 한칸 뛰기 ***
//			String query1 = "values (?,?,?,?,?)";
//			
//			ps = conn_mysql.prepareStatement(query + query1);
//			ps.setString(1, name);
//			ps.setString(2, telno);
//			ps.setString(3, address);
//			ps.setString(4, email);
//			ps.setString(5, relation);
//			
//			check = ps.executeUpdate(); // 끝나면 int값이 날라옴 / -1은 에러 / (1인지 -1인지 확인)
//			
//			conn_mysql.close(); // 여러명이 쓴다는것을 생각해야함
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return check;

	}


} // End
