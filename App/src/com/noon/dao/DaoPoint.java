package com.noon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.noon.base.Panel01Login;
import com.noon.util.DBConnect;

public class DaoPoint {
	
	// Fields
	int pointno;
	String pointdate;
	int pointcash;
	String member_id;
	
	// Constructor
	public DaoPoint() {
		// TODO Auto-generated constructor stub
	}
	
	

	public DaoPoint(int pointcash, String member_id) {
		super();
		this.pointcash = pointcash;
		this.member_id = member_id;
	}


	// Method
	// 포인트 적립 입력
	public int insertPoint() {
		PreparedStatement ps = null;
		int check = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			String query = "insert into point (pointdate, pointcash, member_id, order_orderno, order_member_id, order_set_setno, order_set_menu_name, order_shop_shopcode, order_staff_id) "; // *** 마지막 한칸 뛰기 ***
			String query1 = "select curdate(),?,?,orderno,member_id,set_setno, set_menu_name, shop_shopcode, staff_id from noon.order";
			//insert into point (pointdate, pointcash, member_id, order_orderno, order_member_id, order_set_setno, order_set_menu_name, order_shop_shopcode, order_staff_id) 
			//select curdate(),10,'asd',orderno,member_id,set_setno, set_menu_name, shop_shopcode, staff_id from noon.order;
			
			ps = conn_mysql.prepareStatement(query + query1);
			ps.setInt(1, pointcash);
			ps.setString(2, member_id);
			
			check = ps.executeUpdate(); // 끝나면 int값이 날라옴 / -1은 에러 / (1인지 -1인지 확인)
			
			conn_mysql.close(); // 여러명이 쓴다는것을 생각해야함
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	
	// 포인트 정보 가져오기
	public int selectPoint() {
		int i = 0;
		
		String whereStatement = "select sum(pointcash) from point "; // 마지막 띄워주기
		String whereStatement2 = "where member_id = '" + Panel01Login.id + "'";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);
			
			if (rs.next()) { // true값일때만 가져온다
				i = rs.getInt(1);
			}
			conn_mysql.close();
			System.out.println(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	
	
} // End