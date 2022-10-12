package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.util.DBConnect;

public class DaoPoint {
	String member_id;
	int order_no;
	
	
	
	
	
	public DaoPoint() {
		// TODO Auto-generated constructor stub
	}
	
	
	public DaoPoint(String member_id, int order_no) {
		super();
		this.member_id = member_id;
		this.order_no = order_no;
	}


	private void searchAction() {
		String whereStatement = "select m.number, p.pointno from member m, point p, order o ";
		String whereStatement2 = "where m.id = p.member_id and p.order_orderno = o.orderno";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(whereStatement);	// <=검색 시작
			
			while (rs.next()) {	// ResultSet \ .next = boolean (값이 없으면 false)
				
				
			}
			
			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


	


