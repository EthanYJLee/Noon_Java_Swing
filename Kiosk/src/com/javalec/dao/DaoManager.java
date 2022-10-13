package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.util.DBConnect;

public class DaoManager {
			
			// Fields
			String id;
			String pw;
			String name;
			int employeeno;


			// Constructor
			public DaoManager() {
				// TODO Auto-generated constructor stub
			}
			
			public DaoManager(String id, String pw) {
				super();
				this.id = id;
				this.pw = pw;
			}

			public DaoManager(String id) {
				super();
				this.id = id;
			}
			
			public DaoManager(String id, String pw, String name, int employeeno) {
				super();
				this.id = id;
				this.pw = pw;
				this.name = name;
				this.employeeno = employeeno;
			}

			// Method
			// Table을 Click하였을 경우
			
			public int checkPw() {	// 키오스크 로그인 패스워드는 관리자 id임
				
				int check = 0;
				
				String whereStatement = "select count(*) from manager "; // 마지막 띄워주기
				String whereStatement2 = "where id = '" + id + "' and deletedate is null";
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
					Statement stmt_mysql = conn_mysql.createStatement();
			
					ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);
			
					if (rs.next()) { // true값일때만 가져온다
						
						check = rs.getInt(1);
//						if(check == 1) {
//							loginId = id;
//						}
					}
			
					conn_mysql.close();
			
				} catch (Exception e) {
					e.printStackTrace();
				}
				return check;
				
			}
			

		}
