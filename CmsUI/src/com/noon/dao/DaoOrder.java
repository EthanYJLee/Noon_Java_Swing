package com.noon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.noon.dto.DtoOrder;
import com.noon.util.DBConnect;

public class DaoOrder {
	
	public HashMap<String,Integer> countOrderNum7Day() {
		
		HashMap<String,Integer> countMap = new HashMap<>();

		String whereStatement = "select count(orderno) , paytime from noon.order ";
		String whereStatement2 = "where paytime between date_add(curdate(),interval -7 day) and curdate() group by paytime";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); 
			Statement stmt_mysql = conn_mysql.createStatement(); 
			
			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			while (rs.next()) {
				countMap.put(rs.getString(2),rs.getInt(1));
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace(); // 개발 할 때는 이렇게, product를 만들 때는 경고문장을 넣어주면 된다.
		}
		return countMap;
	}
	
	public ArrayList<DtoOrder> searchAction(){
		ArrayList<DtoOrder> dto = new ArrayList<>();
		
		// 날짜, 메뉴이름 ,주문양 ,주문건수 , 처리건수 (날짜와 메뉴이름 별로 묶는다.)
		// select o.paydate , o.set_menu_name, sum(o.quantity) , count(o.orderno) ,count(c.completetime not null) 
		// from order o join complete c on o.orderno = c.order_orderno group by (o.paydate and o.set_menu_name);
		String whereStatement = "select o.paytime , o.set_menu_name, sum(o.quantity) , count(o.orderno) ,count(c.completetime) ";
		String whereStatement2 = "from noon.order o ,complete c where o.orderno = c.order_orderno and c.completetime is not null ";
		String whereStatement3 = "group by (o.set_menu_name)";
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); 
			Statement stmt_mysql = conn_mysql.createStatement(); 
			
			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2+whereStatement3);

			while (rs.next()) {
				dto.add(new DtoOrder(rs.getString(1) ,rs.getString(2),rs.getInt(3),rs.getInt(4), rs.getInt(5)));
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace(); // 개발 할 때는 이렇게, product를 만들 때는 경고문장을 넣어주면 된다.
		}
		return dto;
		
	}
}
