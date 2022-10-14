package com.noon.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.noon.dto.DtoStaff;
import com.noon.main.Login;
import com.noon.util.DBConnect;

public class DaoStaff {

	private String id;
	private String pw;
	private String name;
	private String phone;
	private String debitno;
	private FileInputStream file;

	String conname;
	String condata;

	public DaoStaff() {

	}

	public DaoStaff(String id) {
		this.id = id;
	}

	public DaoStaff(String conname, String condata) {
		this.conname = conname;
		this.condata = condata;
	}

	public DaoStaff(String pw, String phone, FileInputStream file) {
		super();
		this.pw = pw;
		this.phone = phone;
		this.file = file;
	}
	
	public DaoStaff(String id, String pw, String phone, FileInputStream file) {
		super();
		this.id = id;
		this.pw = pw;
		this.phone = phone;
		this.file = file;
	}
	
	public DaoStaff(String id, String name, String phone, String debitno, FileInputStream file) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.debitno = debitno;
		this.file = file;
	}
	

	public ArrayList<DtoStaff> searchAction() {

		ArrayList<DtoStaff> dtoList = new ArrayList<DtoStaff>();

		String whereStatement = "select s.id , s.name , s.phone from staff s, hire h where s.id = h.staff_id and h.manager_id = '"
				+ Login.id + "' and s.id not like '%kiosk%'";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			Statement stmt_mysql2 = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			while (rs.next()) { // true값일때만 가져온다

				String wkId = rs.getString(1);
				String wkName = rs.getString(2);
				String wkPhone = rs.getString(3);
				int wkCount = 0;

				String whereStatement2 = "select count(completeno) from complete where staff_id = '" + wkId
						+ "' group by staff_id";

				ResultSet rs2 = stmt_mysql2.executeQuery(whereStatement2);

				if (rs2.next()) {
					wkCount = rs2.getInt(1);
				}

				DtoStaff dto = new DtoStaff(wkId, wkName, wkPhone, wkCount);
				dtoList.add(dto);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	

	public ArrayList<DtoStaff> conditionList() {

		ArrayList<DtoStaff> dtoList = new ArrayList<>();

		String whereStatement = "select s.id , s.name , s.phone from staff s, hire h where s.id = h.staff_id and h.manager_id = '"
				+ Login.id + "' " + "and s." + conname + " like '%" + condata + "%' ";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			Statement stmt_mysql2 = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			while (rs.next()) { // true값일때만 가져온다

				String wkId = rs.getString(1);
				String wkName = rs.getString(2);
				String wkPhone = rs.getString(3);
				int wkCount = 0;

				String whereStatement2 = "select count(completeno) from complete where staff_id = '" + wkId
						+ "' group by staff_id";

				ResultSet rs2 = stmt_mysql2.executeQuery(whereStatement2);

				if (rs2.next()) {
					wkCount = rs2.getInt(1);
				}

				DtoStaff dto = new DtoStaff(wkId, wkName, wkPhone, wkCount);
				dtoList.add(dto);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;

	}

	// 비밀번호는 초기값으로 1234가 자동으로 들어간다.
	public int insertStaff() {
		int i = 0;
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			String query = "insert into staff (id,pw,name,phone,debitno,photo) ";
			String query1 = "values (?,'1234',?,?,?,?)";

			ps = conn_mysql.prepareStatement(query + query1);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, phone);
			ps.setString(4, debitno);
			ps.setBinaryStream(5, file);

			i = ps.executeUpdate();

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public int updateStaff() {
		int i = 0;
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);

			String query = "update staff set pw = ? , phone = ? ,photo = ? where id = ?";

			ps = conn_mysql.prepareStatement(query);
			ps.setString(1, pw);
			ps.setString(2, phone);
			ps.setBinaryStream(3, file);
			ps.setString(4, Login.id);

			i = ps.executeUpdate();

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public boolean updateStaff2() {
		int i = 0;
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);

			String query = "update staff set pw = ? , phone = ? ,photo = ? where id = ?";

			ps = conn_mysql.prepareStatement(query);
			ps.setString(1, pw);
			ps.setString(2, phone);
			ps.setBinaryStream(3, file);
			ps.setString(4, Login.id);

			ps.executeUpdate();

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean checkId() {
		String whereStatement = "select count(id) from staff where id = '" + id + "'";
		boolean result = false;
		int i = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			if (rs.next()) {
				i = rs.getInt(1);
			}

			if (i == 0) {
				result = true;
			} else {
				result = false;
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	// daoEployee에 해서 header에서 이걸 바꾸는 걸 넣어야 된다.
	public String selectPhoto() {
		String whereStatement = "select photo from " + Login.type + " where id = '" + Login.id + "'";
		boolean result = false;
		String filepath = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			if (rs.next()) {
				String wkId = rs.getString(1);
				filepath = "./" + wkId;

				int i = 0;

				File check = new File(filepath);
				while (check.exists()) {
					filepath += 1;
					check = new File(filepath);
					i++;
				}

				File file = new File(filepath);
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(2);
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = input.read(buffer)) != -1) {
					output.write(buffer, 0, len);
				}
				input.close();
				output.close();
			}
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return filepath;
	}

	public DtoStaff setTfImage() {
		String whereStatement = "select id, pw, phone, photo from staff where id = '" + Login.id + "'";
		boolean result = false;
		String filepath;
		DtoStaff dto = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			if (rs.next()) {
				String wkId = rs.getString(1);
				String wkPw = rs.getString(2);
				String wkPhone = rs.getString(3);
				filepath = "./" + wkId;

				int i = 0;

				File check = new File(filepath);
				while (check.exists()) {
					filepath += 1;
					check = new File(filepath);
					i++;
				}

				File file = new File(filepath);
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(4);
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = input.read(buffer)) != -1) {
					output.write(buffer, 0, len);
				}
				input.close();
				output.close();
				
				dto = new DtoStaff(filepath,wkId,wkPw,wkPhone);
			}
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}

}
