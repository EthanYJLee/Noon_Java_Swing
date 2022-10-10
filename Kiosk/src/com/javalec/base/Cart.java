package com.javalec.base;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.util.RoundedButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Cart extends JPanel {
	private JScrollPane scrollPane;
	JPanel panel = new JPanel();

	private final DefaultTableModel Outer_Table = new DefaultTableModel(); // ******* 테이블준비하기(1/2) 바깥모양임
	private JTable Inner_Table;
	private JTextField tfTotalPrice;

	
	
	public Cart() {
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				tableInit();
				searchAction();
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

		
		RoundedButton btnCancel = new RoundedButton("");
		btnCancel.setBackground(new Color(255, 255, 255));
		btnCancel.setIcon(new ImageIcon(Cart.class.getResource("/com/javalec/image/Group 6924.png")));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteAction();
			}
		});
		btnCancel.setBounds(243, 286, 95, 59);
		panel.add(btnCancel);
		
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
				setVisible(false);
				Frame.frame.getContentPane().add(new Point());
			}
		});
		btnPay.setBounds(12, 470, 326, 65);
		panel.add(btnPay);
		
		tfTotalPrice = new JTextField();
		tfTotalPrice.setBounds(208, 355, 130, 30);
		panel.add(tfTotalPrice);
		tfTotalPrice.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("총 금액 : ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(127, 355, 69, 30);
		panel.add(lblNewLabel);
		
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

	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 10, 326, 266);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}

	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
			Inner_Table.setFont(new Font("굴림", Font.PLAIN, 20));
			Inner_Table.getTableHeader().setFont(new Font("굴림", Font.PLAIN, 15));
			Inner_Table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == 1) {
						tableClick();
					}
				}
			});
			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setModel(Outer_Table);

		}
		return Inner_Table;
	}
	
	public void tableClick() {
		
	}
	public void tableInit() {
		Outer_Table.addColumn("음료명");
		Outer_Table.addColumn("가격");
		Outer_Table.addColumn("수량");
		Outer_Table.addColumn("합계액");
		Outer_Table.setColumnCount(4);
		
		int i = Outer_Table.getRowCount();
		for (int j = 0; j < i; j++) {
			Outer_Table.removeRow(0);
		}
		
		Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);

		int vColIndex = 0;
		TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
		int width = 100;
		col.setPreferredWidth(width);
		
		

		vColIndex = 1;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 90;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 46;
		col.setPreferredWidth(width);

		vColIndex = 3;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 90;
		col.setPreferredWidth(width);
		
		
	}
	
	public void searchAction() {
		
	}
	
	public void deleteAction() {
		
	}
}
