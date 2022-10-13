package com.noon.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.noon.main.Login;
import com.noon.util.DBConnect;

public class DaoEmployee {

	public String selectPhoto() {
		String whereStatement = "select id ,photo from " + Login.type + " where id = '" + Login.id + "'";
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
				if (input != null) {
					byte[] buffer = new byte[1024];
					int len = 0;
					while ((len = input.read(buffer)) != -1) {
						output.write(buffer, 0, len);
					}
					input.close();
					output.close();
				}else {
					return "./src/com/noon/icon/bigperson.png";
				}
			}
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return filepath;
	}

}
