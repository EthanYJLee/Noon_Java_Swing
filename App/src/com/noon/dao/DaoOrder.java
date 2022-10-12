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
	
	public DaoOrder(String ordertime, int hotice, int quantity, int shot, int syrup, int size, int indiprice,
			String member_id, int set_setno, String set_menu_name, int shop_shopcode, String staff_id) {
		super();
		this.ordertime = ordertime;
		this.hotice = hotice;
		this.quantity = quantity;
		this.shot = shot;
		this.syrup = syrup;
		this.size = size;
		this.indiprice = indiprice;
		this.member_id = member_id;
		this.set_setno = set_setno;
		this.set_menu_name = set_menu_name;
		this.shop_shopcode = shop_shopcode;
		this.staff_id = staff_id;
	}


	// Method
	// 입력
	public int insertActionCart() {
		PreparedStatement ps = null;
		int check = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			String query = "insert into noon.order (ordertime, hotice, quantity, shot, syrup, size, indiprice, "; // *** 마지막 한칸 뛰기 ***
			String query2 = "member_id, set_setno, set_menu_name, shop_shopcode, staff_id) ";
			String query3 = "values (?,?,?,?,?,?,?,?,?,?,?,?)";
			
			ps = conn_mysql.prepareStatement(query + query2 + query3);
			ps.setString(1, ordertime);
			ps.setInt(2, hotice);
			ps.setInt(3, quantity);
			ps.setInt(4, shot);
			ps.setInt(5, syrup);
			ps.setInt(6, size);
			ps.setInt(7, indiprice);
			ps.setString(8, member_id);
			ps.setInt(9, set_setno);
			ps.setString(10, set_menu_name);
			ps.setInt(11, shop_shopcode);
			ps.setString(12, staff_id);
			
			check = ps.executeUpdate(); // 끝나면 int값이 날라옴 / -1은 에러 / (1인지 -1인지 확인)
			
			conn_mysql.close(); // 여러명이 쓴다는것을 생각해야함
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return check;

	}


} // End
