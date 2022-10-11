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

import javax.swing.ImageIcon;

import com.noon.component.Menu;
import com.noon.util.DBConnect;

public class DaoMenu {
	// 필요한 변수가 그러면, price , photo , menuname, category
	private String price;
	private FileInputStream input;
	private String menuname;
	private String category;
	
	public DaoMenu() {
		
	}

	public DaoMenu(String price, FileInputStream input, String menuname, String category) {
		super();
		this.price = price;
		this.input = input;
		this.menuname = menuname;
		this.category = category;
	}

	public boolean addMenu() {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			@SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();

			String A = "insert into menu (name, price, category, photo";
			String B = ") values (?,?,?,?)";

			ps = conn_mysql.prepareStatement(A + B);
			ps.setString(1, menuname.trim());
			ps.setInt(2, Integer.parseInt(price.trim()));
			ps.setString(3, category.trim());
			ps.setBinaryStream(4, input);
			ps.executeUpdate();

			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public ArrayList<Menu> showMenu(){
		ArrayList<Menu> menuList = new ArrayList<>();
		
		String whereStatement = "select name , photo from menu";
		
		try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql,DBConnect.id_mysql,DBConnect.pw_mysql);
            Statement stmt_mysql = conn_mysql.createStatement();

            ResultSet rs = stmt_mysql.executeQuery(whereStatement);
            
            

            while(rs.next()){
            	String wkName = rs.getString(1);
            	// File
            	DBConnect.filename = DBConnect.filename + 1;
            	File file = new File(Integer.toString(DBConnect.filename));
            	FileOutputStream output = new FileOutputStream(file);
            	InputStream input = rs.getBinaryStream(2);
                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    output.write(buffer);
                }
            	            
                Menu menu = new Menu(new ImageIcon(Integer.toString( DBConnect.filename)), wkName);
                menuList.add(menu);
                file.delete();
            }
            
            conn_mysql.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
		return menuList;
	}

}
