package com.javalec.base;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import com.javalec.util.DBConnect;
import com.javalec.util.EarnPoint;
import com.javalec.util.RoundedButton;

public class Point extends JPanel {
	JPanel panel = new JPanel();
	EarnPoint keypad = new EarnPoint();
	JTextField panelDisplay = new JTextField();

	public Point() {
		setLayout(null);
		setBackground(new Color(244, 210, 201));

		panel.setLayout(null);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 155, 350, 545);
		add(panel);
		keypad.panelKey.setBorder(new MatteBorder(10, 10, 10, 10, (Color) new Color(255, 255, 255)));
		keypad.panelDisplay.setBackground(new Color(244, 210, 201));
		keypad.panelDisplay.setSize(300, 47);
		keypad.panelKey.setSize(278, 312);
		keypad.panelKey.setLocation(10, 57);
		keypad.panelDisplay.setLocation(0, 0);
		keypad.panelDisplay.setFont(new Font("굴림", Font.PLAIN, 20));
		keypad.panelKey.setBackground(new Color(255, 255, 255));
		keypad.panelDisplay.setEditable(false);
		keypad.setBackground(new Color(255, 255, 255));

		keypad.setBounds(25, 10, 300, 379);

		RoundedButton btnInsertNum = new RoundedButton("");
		btnInsertNum.setBackground(new Color(255, 255, 255));
		btnInsertNum.setIcon(new ImageIcon(Point.class.getResource("/com/javalec/image/Group 6922.png")));
		btnInsertNum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertNumber();
			}
		});
		btnInsertNum.setBounds(12, 399, 326, 65);
		panel.add(btnInsertNum);

		RoundedButton btnNewButton_1_1 = new RoundedButton("");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Frame.frame.getContentPane().add(new Complete());
			}
		});
		btnNewButton_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1.setIcon(new ImageIcon(Point.class.getResource("/com/javalec/image/Group 6921-1.png")));
		btnNewButton_1_1.setBounds(12, 470, 326, 65);
		panel.add(btnNewButton_1_1);

		panel.add(keypad);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Point.class.getResource("/com/javalec/image/pointMessage.png")));
		lblNewLabel.setBounds(12, 85, 326, 60);
		add(lblNewLabel);

		String a = LogIn.myBranch;
		JLabel lblMyBranch = new JLabel("카페 눈 " + a);
		lblMyBranch.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMyBranch.setBounds(173, 10, 165, 28);
		add(lblMyBranch);
	}

	public void insertNumber() {
		// 입력항목 Check
		int i_chk = insertFieldCheck();
		if (i_chk == 0) {
			String checkMember = searchMember();
			if (checkMember != "") {
				updateCompleteAction(checkMember);
				int getPoint = insertAction();
				if (getPoint == 1) {
					JOptionPane.showMessageDialog(null, panelDisplay.getText() + "번으로 포인트가 적립되었습니다.");
					setVisible(false);
					Frame.frame.getContentPane().add(new Complete());
				} else if (getPoint == 1) {
					JOptionPane.showMessageDialog(null, panelDisplay.getText() + "번호를 확인해주십시오.");
					panelDisplay.requestFocus();
				}
			} else {
				JOptionPane.showMessageDialog(null, "등록되지 않은 번호입니다.");
			}
	}
}

	public int insertFieldCheck() {
		int i = 0;
		if (panelDisplay.getText().trim().length() != 11) {
			i++;
		}
		return i;
	}

	public void updateCompleteAction(String checkMember) {
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			String query = "update complete (order_member_id) ";
			String query2 = "value (?) ";
			String query3 = "where shop_shopcode = ? and staff_id = ? and paytime is not null and ordertime is not null and refundtime is null and complete_completeno is not null";

			ps = conn_mysql.prepareStatement(query);

			ps.setString(1, checkMember);
			ps.setString(2, LogIn.kiosk_id);

			ps.executeUpdate();

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private String searchMember() {
		PreparedStatement ps = null;
		String member = "";
		String whereStatement = "select id from member ";
		String whereStatement2 = "where phone = ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			ps = conn_mysql.prepareStatement(whereStatement + whereStatement2);
			ps.setString(1, panelDisplay.getText().trim());

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2); // <=검색 시작

			while (rs.next()) {
				member = rs.getString(1);
			}

			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}

	private int insertAction() {
		PreparedStatement ps = null;
		int check = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String query = "insert into point (pointdate, pointcash) ";
			String query1 = "values (now, order.indiprice*order.quantity) ";
			String query2 = "where point.member_id = guest and point.order_orderno = order.orderno ";
			String query3 = "and member.phone = ?";
			ps = conn_mysql.prepareStatement(query + query1 + query2 + query3);

			ps.setString(1, panelDisplay.getText().trim());

			check = ps.executeUpdate();

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

}
