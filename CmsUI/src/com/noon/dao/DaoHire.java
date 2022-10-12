package com.noon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.noon.dto.DtoStaff;
import com.noon.main.Login;
import com.noon.util.DBConnect;

public class DaoHire {
	private String id;
	
	public DaoHire(String id) {
		this.id = id;
	}
	
	public int insertHire() {
		int i = 0;
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			String query = "insert into hire (shop_shopcode,staff_id,manager_id,registerdate) ";
			String query1 = "values (?,?,?,curdate())";

			ps = conn_mysql.prepareStatement(query + query1);
			ps.setInt(1, getShopcode());
			ps.setString(2, id);
			ps.setString(3, Login.id);

			i = ps.executeUpdate();

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int getShopcode() {
		int shopcode = 0;
		String whereStatement = "select shop_shopcode from manage where manager_id = '" + Login.id + "'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			if(rs.next()) { // true값일때만 가져온다
				shopcode = rs.getInt(1);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return shopcode;
	}
}
