package com.noon.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.noon.base.Panel01Login;
import com.noon.base.Panel05Order01Shop;
import com.noon.dto.DtoOrder;
import com.noon.util.DBConnect;

public class DaoOrder {

	// Fields
	int orderno;
	String ordertime;
	String paytime;
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

	public DaoOrder(String set_menu_name) {
		super();
		this.set_menu_name = set_menu_name;
	}

	public DaoOrder(int orderno) {
		super();
		this.orderno = orderno;
	}

	public DaoOrder(String forheretogo, String member_id) {
		super();
		this.forheretogo = forheretogo;
		this.member_id = member_id;
	}

	// Method
	// 입력
	public int insertActionCart() {
		PreparedStatement ps = null;
		int check = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String query = "insert into noon.order (ordertime, hotice, quantity, shot, syrup, size, indiprice, "; // ***
			String query2 = "member_id, set_setno, set_menu_name, shop_shopcode, staff_id) "; // 마지막
			String query3 = "values (concat(curdate(),' ',?),?,?,?,?,?,?,?,?,?,?,?)"; // 뛰기
			ps = conn_mysql.prepareStatement(query + query2 + query3); // ***
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

		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;

	}

	// 장바구니에 담은 리스트 불러오기
	public ArrayList<DtoOrder> menuList() {

		ArrayList<DtoOrder> BeanList = new ArrayList<DtoOrder>();

		String whereStatement = "select o.hotice, o.quantity, o.shot, o.syrup, o.size, o.indiprice, o.set_menu_name, s.photonow from setting s, noon.order o ";
		String whereStatement2 = "where s.setno = o.set_setno and o.paytime is null and o.member_id = '"
				+ Panel01Login.id + "' ";
		String whereStatement3 = "and s.shop_shopcode = '" + Panel05Order01Shop.shopcode + "'";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2 + whereStatement3);

			int wkFilename = 0;
			while (rs.next()) { // true값일때만 가져온다

				int wkHotice = rs.getInt(1);
				int wkQuantity = rs.getInt(2);
				int wkShot = rs.getInt(3);
				int wkSyrup = rs.getInt(4);
				int wkSize = rs.getInt(5);
				int wkPrice = rs.getInt(6);
				String wkMenuName = rs.getString(7);

				// File
				wkFilename = wkFilename + 1;
				File file = new File("./" + wkFilename);

				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(8);
				byte[] buffer = new byte[1024];
				while (input.read(buffer) > 0) {
					output.write(buffer);
				}

				DtoOrder dtoOrder = new DtoOrder(wkHotice, wkQuantity, wkShot, wkSyrup, wkSize, wkPrice, wkMenuName,
						wkFilename);
				BeanList.add(dtoOrder);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return BeanList;
	}

	// Table을 Click하였을 경우 해당 열의 orderno를 가져오기
	public int tableClick() {
		int i = 0;
		String whereStatement = "select orderno from noon.order "; // 마지막 띄워주기
		String whereStatement2 = "where set_menu_name = '" + set_menu_name + "' and member_id = '" + Panel01Login.id
				+ "' and paytime is null";

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

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;

	}

	// 장바구니 목록 삭제하기
	public boolean deleteAction() {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String query = "delete from noon.order where orderno = ? "; // *** 마지막 한칸 뛰기 ***

			ps = conn_mysql.prepareStatement(query);
			ps.setInt(1, orderno);

			ps.executeUpdate(); // 끝나면 int값이 날라오는구나 / -1은 에러 / 1인지 -1인지 확인

			conn_mysql.close(); // 여러명이 쓴다는것을 생각해야함

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	// 장바구니 전체 합계 구하기
	public int calcTotalCart() {

		int totalCart = 0;

		String whereStatement = "select o.quantity, o.shot, o.syrup, o.size, o.indiprice from setting s, noon.order o ";
		String whereStatement2 = "where s.setno = o.set_setno and o.paytime is null and o.member_id = '"
				+ Panel01Login.id + "' ";
		String whereStatement3 = "and s.shop_shopcode = '" + Panel05Order01Shop.shopcode + "'";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2 + whereStatement3);

			while (rs.next()) { // true값일때만 가져온다
				int i = 0;
				int wkQuantity = rs.getInt(1);
				int wkShot = rs.getInt(2);
				int wkSyrup = 0;
				if (rs.getInt(3) == 1 || rs.getInt(3) == 2) {
					wkSyrup = 500;
				}
				int wkSize = rs.getInt(4);
				int wkPrice = rs.getInt(5);
				i = (wkPrice + wkShot + wkSize + wkSyrup) * wkQuantity;
				totalCart = totalCart + i;
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalCart;
	}
	
	// 결제하기버튼 -> 오더테이블 업데이트
	public int updateAction() {
		PreparedStatement ps = null;
		int check = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			String query = "update noon.order set forheretogo = ?, paytime = now() "; // *** 마지막 한칸 뛰기 ***
			String query2 = "where member_id = '" + Panel01Login.id + "'";
			
			ps = conn_mysql.prepareStatement(query + query2);
			ps.setString(1, forheretogo);
						
			check = ps.executeUpdate(); // 끝나면 int값이 날라옴 / -1은 에러 / (1인지 -1인지 확인)
			
			conn_mysql.close(); // 여러명이 쓴다는것을 생각해야함
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return check;

	}
} // End
