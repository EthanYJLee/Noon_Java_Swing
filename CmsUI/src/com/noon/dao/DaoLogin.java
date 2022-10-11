package com.noon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.noon.main.Login;
import com.noon.util.DBConnect;

public class DaoLogin {
	public String id;
	public String pw;

	public DaoLogin(String id) {
		super();
		this.id = id;
	}

	public DaoLogin(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	public int loginAction() {
		int i = 2;
		if (Login.type.equals("")) {
			JOptionPane.showConfirmDialog(null, "너 위에꺼 선택해");
		} else {

			String whereStatement = "select count(id and pw) from " + Login.type + " where id = '" + id + "' and pw = '"
					+ pw + "'";
			String loginId = "";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
						DBConnect.pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();

				ResultSet rs = stmt_mysql.executeQuery(whereStatement);

				while (rs.next()) {
					i = rs.getInt(1);
				}

				conn_mysql.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return i;
	}

//    public DaoManagerLogin(String id, String password, String address, String name, String phone, String email) {
//		super();
//		this.id = id;
//		this.password = password;
//		this.address = address;
//		this.name = name;
//		this.phone = phone;
//		this.email = email;
//	}

}
