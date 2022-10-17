package com.noon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import com.noon.dto.DtoOrder;
import com.noon.dto.DtoOrder2;
import com.noon.main.Login;
import com.noon.util.DBConnect;

public class DaoOrder {
	int customerno;
	// 대기번호
	int orderno;
	// 주문번ㅎ호
	int quantity;
	// ㅈ 주문개수
	int completeno;
	String name;
//	// 메뉴 이
	String ordertime;
//	// 주문시간
	String completetime;

	int order_orderno;

	public DaoOrder() {
		// TODO Auto-generated constructor stub
	}

	public HashMap<String, Integer> countOrderNum7Day() {

		HashMap<String, Integer> countMap = new HashMap<>();

		String whereStatement = "select count(orderno) , date(paytime) from noon.order ";
		String whereStatement2 = "where date(paytime) between date_add(curdate(),interval -7 day) and curdate() group by date(paytime)";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			while (rs.next()) {
				countMap.put(rs.getString(2), rs.getInt(1));
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace(); // 개발 할 때는 이렇게, product를 만들 때는 경고문장을 넣어주면 된다. 내가한거 아닌데 왜 있지
		}
		return countMap;
	}
	
	// 임원 전체가게 현황 / 전체가게의 날짜별(7일간) 총매출
	// 2022.10.17
	public HashMap<String, Integer> countOrderNum7Day2() {
		
		HashMap<String, Integer> countMap = new HashMap<>();
		
		String whereStatement = "select sum((indiprice+size+shot+syrup*500)*quantity) , date(paytime) from noon.order ";
		String whereStatement2 = "where date(paytime) between date_add(curdate(),interval -7 day) and curdate() group by date(paytime)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);
			
			while (rs.next()) {
				countMap.put(rs.getString(2), rs.getInt(1));
			}
			
			conn_mysql.close();
			
		} catch (Exception e) {
			e.printStackTrace(); // 개발 할 때는 이렇게, product를 만들 때는 경고문장을 넣어주면 된다. 내가한거 아닌데 왜 있지
		}
		return countMap;
	}

	public DaoOrder(int orderno) {
		super();
		this.orderno = orderno;
	}

	public ArrayList<DtoOrder> searchAction2() {
		ArrayList<DtoOrder> DtoOrder = new ArrayList<>();

		String whereStatement = "select orderno, customerno, quantity,name,ordertime,completetime "
				+ "from menu as m, noon.order as o, setting as s,complete as c ";

		String whereStatement2 = "where o.set_setno = s.setno and  o.set_menu_name = m.name  and o.orderno = c.order_orderno";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			while (rs.next()) {
				DtoOrder.add(new DtoOrder(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6)));

				// 이거 바꾸니까 테이블 화면이 바뀌더라.

			}
			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace(); // 개발 할 때는 이렇게, product를 만들 때는 경고문장을 넣어주면 된다.

		}
		return DtoOrder;
	}

	// 주문번호 음료명 주문수량 주문시각 처리상태 가져오기
	public ArrayList<DtoOrder> searchAction() {
		ArrayList<DtoOrder> orderList = new ArrayList<>();
		// select orderno , menu_name , quantity, paytime (추가 주문 사항) syrup , shot , size
		// , forheretogo , hotice
		// 이거 두개는 버튼을 누르면 동작해야 되는 부분이다. accepttime ,completetime
		// select o.orderno , o.menu_name, o.quantity, o.paytime

		String whereStatement = "select o.orderno, o.set_menu_name, o.quantity, o.paytime , c.accepttime , c.completetime from noon.order o , complete c "
				+ "where o.orderno = c.order_orderno and o.shop_shopcode = " + getShopcode()
				+ " and c.completetime is null and o.paytime is not null and o.refundtime is null";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			while (rs.next()) {

				orderList.add(new DtoOrder(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						rs.getString(5), rs.getString(6)));

			}
			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return orderList;
	}

	//
	public DtoOrder tableClick() {
		DtoOrder dto = null;

		String whereStatement = "select orderno, set_menu_name , quantity, hotice ,forheretogo ,shot ,syrup , size "
				+ "from noon.order where orderno = " + orderno; // 마지막 띄워주기

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			if (rs.next()) { // true값일때만 가져온다
				int wKorderno = rs.getInt(1);
				String wKmenuname = rs.getString(2);
				int wKquantity = rs.getInt(3);
				int wKhotice = rs.getInt(4);
				String wkforheretogo = rs.getString(5);
				int wKshot = rs.getInt(6);
				int wKsyrup = rs.getInt(7);
				int wKsize = rs.getInt(8);

				System.out.println(wKmenuname);
				dto = new DtoOrder(wKorderno, wKmenuname, wKquantity, wKhotice, wkforheretogo, wKshot, wKsyrup, wKsize);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace(); // 개발 할 때는 이렇게, product를 만들 때는 경고문장을 넣어주면 된다.
		}
		return dto;

	}

	public int updateOrder() {
		PreparedStatement ps = null;
		int i = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // .
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			String query = "update noon.order set refundtime = now() where orderno = ? ";

			ps = conn_mysql.prepareStatement(query);
			ps.setInt(1, orderno);

			i = ps.executeUpdate();

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace(); // 개발 할 때는 이렇게, product를 만들 때는 경고문장을 넣어주면 된다.
		}
		return i;
	}

	public int updateCompleteAcceptTime() {
		PreparedStatement ps = null;
		int i = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // .
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			String query = "update complete set accepttime = now() , staff_id = ? where order_orderno = ? and accepttime is null";

			ps = conn_mysql.prepareStatement(query);
			ps.setString(1, Login.id);
			ps.setInt(2, orderno);

			i = ps.executeUpdate();

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace(); // 개발 할 때는 이렇게, product를 만들 때는 경고문장을 넣어주면 된다.
		}
		return i;
	}

	public int updateCompleteCompleteTime() {
		PreparedStatement ps = null;
		int i = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // .
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			String query = "update complete set completetime = now() where order_orderno = ? and staff_id = ? and accepttime is not null and completetime is null";

			ps = conn_mysql.prepareStatement(query);
			ps.setInt(1, orderno);
			ps.setString(1, Login.id);

			i = ps.executeUpdate();

			conn_mysql.close();

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "다른사람이 주문 받은 건입니다."); // 개발 할 때는 이렇게, product를 만들 때는 경고문장을 넣어주면 된다.
		}
		return i;
	}

	public int updateOrderCompleteNo() {
		PreparedStatement ps = null;
		int i = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // .
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			String query = "update noon.order set complete_completeno = ? where orderno = ? ";

			ps = conn_mysql.prepareStatement(query);
			ps.setInt(1, findCompleteno());
			ps.setInt(2, orderno);

			i = ps.executeUpdate();

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace(); // 개발 할 때는 이렇게, product를 만들 때는 경고문장을 넣어주면 된다.
		}
		return i;
	}

	public int findCompleteno() {
		String whereStatement = "select completeno from complete where order_orderno = " + orderno;
		int num = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			if (rs.next()) { // true값일때만 가져온다
				num = rs.getInt(1);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace(); // 개발 할 때는 이렇게, product를 만들 때는 경고문장을 넣어주면 된다.

		}
		return num;
	}

	public int updateAction() {
		PreparedStatement ps = null;
		int i = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // .
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			String query = "update complete set completetime = now() where order_orderno = ?  ";
			// 여기 ? 가 없으면 오류가 나오더라... 왜인지는 모른다...
			ps = conn_mysql.prepareStatement(query);
			ps.setInt(1, orderno);

			i = ps.executeUpdate();

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace(); // 개발 할 때는 이렇게, product를 만들 때는 경고문장을 넣어주면 된다.
			JOptionPane.showConfirmDialog(null, "이미 처리된 건수 입니다");
		}
		return i;
	}

	public int countNotCompleteOrder() {
		String whereStatement = "select count(*) from complete c , noon.order o where c.order_orderno = o.orderno and c.completetime is null and  c.order_shop_shopcode = "
				+ getShopcode() + " and o.refundtime is null";
		int num = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			if (rs.next()) { // true값일때만 가져온다
				num = rs.getInt(1);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace(); // 개발 할 때는 이렇게, product를 만들 때는 경고문장을 넣어주면 된다.

		}
		return num;
	}

	public DtoOrder NoClearList() {
		DtoOrder dto = null;
		// select completetime from complete

		String whereStatement = "select count(completetime = null) from complete ";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			if (rs.next()) { // true값일때만 가져온다
				int completetime = rs.getInt(1);
//				int wkStock = rs.getInt(4);;
				dto = new DtoOrder(Integer.toString(completetime));
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace(); // 개발 할 때는 이렇게, product를 만들 때는 경고문장을 넣어주면 된다.
			JOptionPane.showConfirmDialog(null, "잘못된입력");
		}
		return dto;

	}

	public int getShopcode() {
		int shopcode = 0;
		String whereStatement = "select shop_shopcode from hire where staff_id = '" + Login.id + "'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			if (rs.next()) { // true값일때만 가져온다
				shopcode = rs.getInt(1);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return shopcode;
	}
//	"update complete set completetime = now() where order_orderno  and completetime is null";

//	Outer_Table.addColumn("날짜");
//	Outer_Table.addColumn("메뉴이름");
//	Outer_Table.addColumn("음료");
//	Outer_Table.addColumn("주문건수");

	public int getManagerShopCode() {
		int shopcode = 0;
		String whereStatement = "select shop_shopcode from manage where manager_id = '" + Login.id + "'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			if (rs.next()) { // true값일때만 가져온다
				shopcode = rs.getInt(1);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return shopcode;
	}

	public ArrayList<DtoOrder> searchGroupByMenuAction() {
		ArrayList<DtoOrder> menuOrderList = new ArrayList<>();
		String whereStatement = "select date(paytime), set_menu_name , sum(quantity) , count(*) from noon.order\n"
				+ "where date(paytime) between date_add(curdate(),interval -7 day) and curdate() and shop_shopcode = "
				+ getManagerShopCode() + " group by set_menu_name, date(paytime) order by date(paytime) desc";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			while (rs.next()) {

				menuOrderList.add(new DtoOrder(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));

			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return menuOrderList;
	}

	// 임원 전체 가게 현황 / DtoOrder2 사용
	// 2022.10.17
	public ArrayList<DtoOrder2> searchGroupByMenuAction2() {
		ArrayList<DtoOrder2> menuOrderList = new ArrayList<>();
		String whereStatement = "select s.shopcode, s.name, date(o.paytime), o.set_menu_name , sum(o.quantity) , count(o.orderno) from noon.order o, shop s ";
		String whereStatement2 = "where date(o.paytime) between date_add(curdate(),interval -7 day) and curdate() and s.shopcode = o.shop_shopcode ";
		String whereStatement3 = "group by s.shopcode, o.set_menu_name, date(o.paytime) order by s.shopcode asc, date(paytime) desc;";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2 + whereStatement3);

			while (rs.next()) {

				menuOrderList.add(new DtoOrder2(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getInt(5), rs.getInt(6)));

			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return menuOrderList;
	}

}
