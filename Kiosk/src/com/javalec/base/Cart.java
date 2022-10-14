package com.javalec.base;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.DaoCart;
//import com.javalec.util.Countdown;
import com.javalec.util.DBConnect;
import com.javalec.util.RoundedButton;
import java.awt.event.MouseMotionAdapter;

public class Cart extends JPanel {
	private JScrollPane scrollPane;
	JPanel panel = new JPanel();

	private final DefaultTableModel Outer_Table = new DefaultTableModel(); // ******* 테이블준비하기(1/2) 바깥모양임
	private JTable Inner_Table;
	private JTextField tfTotalPrice;
	private JTextField tfDelete;
	private JTextField tfSum;

	public Cart() {
//		addMouseMotionListener(new MouseMotionAdapter() {
//			@Override
//			public void mouseMoved(MouseEvent e) {
//			}
//		});
//		addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				Countdown cd = new Countdown();
//				add(cd);
//				
//				if(e.MOUSE_ENTERED > 1) {
//					remove(cd);
//				
//				}
//			
//			}
//		});
			
				
			
			
	
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				tableInit();
				searchAction();
				getSum();

			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});

		setLayout(null);

		setBackground(new Color(244, 210, 201));
		setSize(350, 700);

		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 155, 350, 545);
		add(panel);
		panel.add(getScrollPane());
		panel.setLayout(null);

		RoundedButton btnOrderMore = new RoundedButton("");
		btnOrderMore.setBackground(new Color(255, 255, 255));
		btnOrderMore.setIcon(new ImageIcon(Cart.class.getResource("/com/javalec/image/Group 69201.png")));
		btnOrderMore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Frame.frame.getContentPane().add(new MenuMain());
			}
		});
		btnOrderMore.setBounds(12, 395, 326, 65);
		panel.add(btnOrderMore);

		RoundedButton btnPay = new RoundedButton("");
		btnPay.setBackground(new Color(255, 255, 255));
		btnPay.setIcon(new ImageIcon(Cart.class.getResource("/com/javalec/image/Group 6921.png")));
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateAction();
				insertToCompleteAction();
				tableInit();
				setVisible(false);
				Frame.frame.getContentPane().add(new Point());
			}
		});
		btnPay.setBounds(12, 470, 326, 65);
		panel.add(btnPay);

		JLabel lblNewLabel = new JLabel("총 금액 : ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(127, 355, 69, 30);
		panel.add(lblNewLabel);

		JButton btnNewButton = new JButton("선택 취소");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteAction();
				tableInit(); // 삭제 후 데이터가 남으면 안되므로 초기화
				searchAction();
				getSum();
			}
		});
		btnNewButton.setBounds(243, 286, 95, 23);
		panel.add(btnNewButton);

		tfDelete = new JTextField();
		tfDelete.setEditable(false);
		tfDelete.setBounds(12, 286, 219, 23);
		panel.add(tfDelete);
		tfDelete.setColumns(10);

		tfSum = new JTextField();
		tfSum.setEditable(false);
		tfSum.setBounds(208, 360, 130, 21);
		panel.add(tfSum);
		tfSum.setColumns(10);

		RoundedButton btnBack = new RoundedButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Frame.frame.getContentPane().add(new Detail());
			}
		});
		btnBack.setIcon(new ImageIcon(Cart.class.getResource("/com/javalec/image/Vector.png")));
		btnBack.setBackground(new Color(244, 210, 201));
		btnBack.setBounds(12, 10, 33, 36);
		add(btnBack);

		String a = LogIn.myBranch;
		JLabel lblMyBranch = new JLabel("카페 눈 " + a);
		lblMyBranch.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMyBranch.setBounds(173, 10, 165, 28);
		add(lblMyBranch);

		
		
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBackground(new Color(244, 210, 201));
			scrollPane.setOpaque(false);
			scrollPane.setBounds(12, 10, 326, 266);
			scrollPane.setViewportView(getInner_Table());
			scrollPane.getViewport().setBackground(getBackground());
		}
		return scrollPane;
	}

	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
			Inner_Table.setForeground(new Color(244, 210, 201));
			Inner_Table.setOpaque(true);
			Inner_Table.setFont(new Font("굴림", Font.PLAIN, 12));
			Inner_Table.getTableHeader().setFont(new Font("굴림", Font.PLAIN, 15));
			Inner_Table.getTableHeader().setBackground(Color.white);
			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setModel(Outer_Table);
			Inner_Table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == 1) { // e: left click
						tableClick();
					}
				}
			});

		}
		return Inner_Table;
	}

	public void tableClick() {
		int i = Inner_Table.getSelectedRow(); // 클릭한 줄이 몇 번째인지 알려줌
		String wkSequence = (String) Inner_Table.getValueAt(i, 0); // returns the cell value at row and column

		String whereStatement = "select set_menu_name from noon.order ";
		String whereStatement2 = "where orderno = ";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2 + wkSequence); // <= select구문 완성, 검색
																									// 시작

			if (rs.next()) {
				tfDelete.setText(rs.getString(1));
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void tableInit() {
		Outer_Table.addColumn("");
		Outer_Table.addColumn("음료명");
		Outer_Table.addColumn("가격");
		Outer_Table.addColumn("수량");
		Outer_Table.addColumn("합계액");
		Outer_Table.setColumnCount(5);

		int i = Outer_Table.getRowCount();
		for (int j = 0; j < i; j++) {
			Outer_Table.removeRow(0);
		}

		Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);

		int vColIndex = 0;
		TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
		Inner_Table.getColumn("").setWidth(0);
		Inner_Table.getColumn("").setMinWidth(0);
		Inner_Table.getColumn("").setMaxWidth(0);

		vColIndex = 1;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		int width = 90;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 46;
		col.setPreferredWidth(width);

		vColIndex = 3;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 90;
		col.setPreferredWidth(width);

		vColIndex = 4;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 99;
		col.setPreferredWidth(width);

	}

	public void searchAction() {
		String whereStatement = "select orderno, set_menu_name, indiprice, quantity from noon.order ";
		String whereStatement2 = "where staff_id = '" + LogIn.kiosk_id + "' and paytime is null";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2); // <=검색 시작

			while (rs.next()) {
				int p = rs.getInt(3);
				int q = rs.getInt(4);
				String[] qTxt = { Integer.toString(rs.getInt(1)), rs.getString(2), Integer.toString(rs.getInt(3)),
						Integer.toString(rs.getInt(4)), Integer.toString(p * q) };
				Outer_Table.addRow(qTxt);
			}

			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void deleteAction() {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String query = "delete from noon.order where orderno = ? ";

			ps = conn_mysql.prepareStatement(query);
			ps.setString(1, (String) Inner_Table.getValueAt(Inner_Table.getSelectedRow(), 0));

			ps.executeUpdate();

			conn_mysql.close();

			JOptionPane.showMessageDialog(null, "선택하신 상품이 삭제되었습니다.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getSum() {
		int sum = 0;
		for (int i = 0; i < Outer_Table.getRowCount(); i++) {
			sum = sum + Integer.parseInt(Outer_Table.getValueAt(i, 4).toString());
		}

		tfSum.setText(Integer.toString(sum));
	}

	public void updateAction() {
		PreparedStatement ps = null;
		int check = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String query = "update noon.order set paytime = now() ";
			String query2 = "where paytime is null and staff_id = '" + LogIn.kiosk_id + "'";

			ps = conn_mysql.prepareStatement(query + query2);

			check = ps.executeUpdate();
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void insertToCompleteAction() {
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			String query = "insert into complete (staff_id, shop_shopcode ,order_orderno, order_member_id, order_set_setno, order_set_menu_name,\n"
					+ "order_shop_shopcode,order_staff_id) \n"
					+ "select 'none', shop_shopcode ,orderno, member_id, set_setno ,set_menu_name, shop_shopcode ,staff_id from noon.order \n"
					+ "where shop_shopcode = ? and staff_id = ? and paytime is not null and ordertime is not null and refundtime is null and "
					+ "complete_completeno is null";

			ps = conn_mysql.prepareStatement(query);
			
			ps.setInt(1,LogIn.shopcode);
			ps.setString(2,LogIn.kiosk_id);

			ps.executeUpdate();

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
