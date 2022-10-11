package com.noon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.noon.dto.DtoStaff;
import com.noon.main.Login;
import com.noon.util.DBConnect;

public class DaoStaff {
	
	String conname;
	String condata;
	
	public DaoStaff() {
		
	}
	
	public DaoStaff(String conname, String condata) {
		this.conname = conname;
		this.condata = condata;
	}
	
	public ArrayList<DtoStaff> searchAction(){
		
		ArrayList<DtoStaff> dtoList = new ArrayList<DtoStaff>();

		String whereStatement = "select s.id , s.name, s.phone, count(c.completeno) from staff s , complete c, hire h where h.manager_id = '" + Login.id + "' and h.staff_id = s.id and h.staff_id = c.staff_id group by(h.staff_id)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
	
			ResultSet rs = stmt_mysql.executeQuery(whereStatement);
	
			while (rs.next()) { // true값일때만 가져온다
				
				String wkId = rs.getString(1); 
				String wkName = rs.getString(2);
				String wkPhone = rs.getString(3);
				int wkCount = rs.getInt(4);
			
				DtoStaff dto = new DtoStaff(wkId, wkName, wkPhone, wkCount);
				dtoList.add(dto);
			}
	
			conn_mysql.close();
	
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return dtoList;
	}
	
public ArrayList<DtoStaff> conditionList(){
		
		ArrayList<DtoStaff> dtoList = new ArrayList<>();
		
		String whereStatement = "select s.id , s.name, s.phone, count(c.completeno) "
				+ "from staff s , complete c, hire h "
				+ "where h.manager_id = '" + Login.id + "' "
				+ "and h.staff_id = s.id "
				+ "and h.staff_id = c.staff_id "
				+ "and s." + conname + " like '%"+condata +"%' "
				+ "group by(h.staff_id)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
	
			ResultSet rs = stmt_mysql.executeQuery(whereStatement);
	
			while (rs.next()) { // true값일때만 가져온다
				
				String wkId = rs.getString(1); 
				String wkName = rs.getString(2);
				String wkPhone = rs.getString(3);
				int wkCount = rs.getInt(4);
			
				DtoStaff dto = new DtoStaff(wkId, wkName, wkPhone, wkCount);
				dtoList.add(dto);
			}
	
			conn_mysql.close();
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;

	}
}
