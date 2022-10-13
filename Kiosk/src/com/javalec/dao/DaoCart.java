package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.base.LogIn;
import com.javalec.dto.DtoOrder;
import com.javalec.util.DBConnect;

public class DaoCart {
	int orderno;
	
	public DaoCart() {
		// TODO Auto-generated constructor stub
	}

	public DaoCart(int orderno) {
		super();
		this.orderno = orderno;
	}

	// 카트에 담긴 상품 있는지 확인
	public int searchCartList() {
		PreparedStatement ps = null;
		int i = 0;
		DaoDetail daoDetail = new DaoDetail();
		int shopcode = daoDetail.shopShopCode();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			String query = "select count(*) from order ";
			String query2 = "where shop_shopcode = '" + shopcode + "' and paytime is null";

			ps = conn_mysql.prepareStatement(query + query2);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
}