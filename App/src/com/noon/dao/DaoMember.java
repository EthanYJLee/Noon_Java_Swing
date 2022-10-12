package com.noon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.noon.dto.DtoMember;
import com.noon.util.DBConnect;


public class DaoMember {
	
	// Fields
	String id;
	String pw;
	String name;
	String phone;
	String initdate;
	String updatedate;
	String deletedate;

	// Constructor
	public DaoMember() {
		// TODO Auto-generated constructor stub
	}
	
	public DaoMember(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	public DaoMember(String id) {
		super();
		this.id = id;
	}

	public DaoMember(String id, String pw, String name, String phone) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
	}

	
	// Method
	// Table을 Click하였을 경우
	public int checkId() {
		
		int check = 0;
//		String loginId = null;
		
		String whereStatement = "select count(*) from member "; // 마지막 띄워주기
		String whereStatement2 = "where id = '" + id + "' and pw = '" + pw + "' and deletedate is null";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
	
			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);
	
			if (rs.next()) { // true값일때만 가져온다
				
				check = rs.getInt(1);
//				if(check == 1) {
//					loginId = id;
//				}
			}
	
			conn_mysql.close();
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
		
	}
	
	public int checkIdwithdraw() { // 탈퇴한지 확인해주는 메세지 보여줄때 사용해보기
		int check = 0;
		String whereStatement = "select count(*) from member "; // 마지막 띄워주기
		String whereStatement2 = "where id = '" + id + "' and pw = '" + pw + "' and deletedate is not null";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
	
			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);
	
			if (rs.next()) { // true값일때만 가져온다
				
				check = rs.getInt(1);

			}
	
			conn_mysql.close();
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check; 
	}
	
	public int checkIdOverlap() {
		int check = 0;
		String whereStatement = "select count(id) from member "; // 마지막 띄워주기
		String whereStatement2 = "where id = '" + id + "'";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
	
			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);
	
			if (rs.next()) { // true값일때만 가져온다
				
				check = rs.getInt(1);

			}
	
			conn_mysql.close();
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check; 
	}
	
	
	// 입력
	public int insertUserInfo() {
		PreparedStatement ps = null;
		int check = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			String query = "insert into member (id, pw, name, phone, initdate) "; // *** 마지막 한칸 뛰기 ***
			String query1 = "values (?,?,?,?,now())";
			
			ps = conn_mysql.prepareStatement(query + query1);
			ps.setString(1, id);
			ps.setString(2, pw);
			ps.setString(3, name);
			ps.setString(4, phone);
			
			check = ps.executeUpdate(); // 끝나면 int값이 날라옴 / -1은 에러 / (1인지 -1인지 확인)
			
			conn_mysql.close(); // 여러명이 쓴다는것을 생각해야함
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return check;

	}
	
	
	
	
	
	
	
} // End
