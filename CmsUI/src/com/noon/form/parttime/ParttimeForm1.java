package com.noon.form.parttime;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.event.AncestorEvent;

public class ParttimeForm1 extends JPanel {
	private JTable Inner_table; // 이너테이블 
	
	// -- Table Definition
	// 아우터 테이블
	private final DefaultTableModel Outer_Table = new DefaultTableModel(); //********  중요 ********

	/**
	 * Create the panel.
	 */
	public ParttimeForm1() {
		setLayout(null);
		setOpaque(false);
		JLabel lblNewLabel = new JLabel("2022.10.25");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setBounds(600, 46, 139, 39);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				tableInit();
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		scrollPane.setBounds(30, 100, 418, 321);
		add(scrollPane);
		
		Inner_table = new JTable();
		Inner_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Inner_table.setModel(Outer_Table);
		scrollPane.setViewportView(Inner_table);
		
		
		JLabel lblNewLabel_1 = new JLabel("미완료 건수 : ");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1.setBounds(30, 442, 195, 39);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("주문 리스트");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 40));
		lblNewLabel_1_1.setBounds(72, 38, 250, 39);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("주문번호 : 2022102500");
		lblNewLabel_1_2.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(465, 102, 196, 39);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("음료명    : 아메리카노");
		lblNewLabel_1_2_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_2_1.setBounds(464, 148, 250, 39);
		add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("주문수량 :  2");
		lblNewLabel_1_2_2.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_2_2.setBounds(464, 226, 195, 39);
		add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("주문시각 : ");
		lblNewLabel_1_2_3.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_2_3.setBounds(464, 274, 102, 39);
		add(lblNewLabel_1_2_3);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("추가사항 : ");
		lblNewLabel_1_2_4.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_2_4.setBounds(467, 314, 195, 39);
		add(lblNewLabel_1_2_4);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("               (ICE)");
		lblNewLabel_1_2_2_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_2_2_1.setBounds(472, 179, 195, 39);
		add(lblNewLabel_1_2_2_1);
		
		JLabel lblNewLabel_1_2_4_1 = new JLabel("22.10.25.");
		lblNewLabel_1_2_4_1.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel_1_2_4_1.setBounds(572, 275, 91, 39);
		add(lblNewLabel_1_2_4_1);
		
		JLabel lblNewLabel_1_2_4_1_1 = new JLabel("샷2, 시럽, 토핑");
		lblNewLabel_1_2_4_1_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_2_4_1_1.setBounds(576, 314, 155, 39);
		add(lblNewLabel_1_2_4_1_1);
		
		JLabel lblNewLabel_1_2_4_1_2 = new JLabel("10:15:23");
		lblNewLabel_1_2_4_1_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_1_2_4_1_2.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel_1_2_4_1_2.setBounds(662, 274, 91, 39);
		add(lblNewLabel_1_2_4_1_2);
		
		JLabel lblNewLabel_1_2_2_2 = new JLabel("12");
		lblNewLabel_1_2_2_2.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_2_2_2.setBounds(168, 443, 42, 39);
		add(lblNewLabel_1_2_2_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("완료 시각 : ");
		lblNewLabel_1_3.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(475, 443, 114, 39);
		add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_2_4_1_2_1 = new JLabel("10:18:27");
		lblNewLabel_1_2_4_1_2_1.setForeground(new Color(254, 20, 1));
		lblNewLabel_1_2_4_1_2_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_2_4_1_2_1.setBounds(590, 442, 91, 39);
		add(lblNewLabel_1_2_4_1_2_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(getClass().getResource("/com/noon/icon/완료버튼.png")));
		lblNewLabel_2.setBounds(653, 492, 115, 50);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(getClass().getResource("/com/noon/icon/선택버튼.png")));
		lblNewLabel_2_1.setBounds(337, 492, 115, 50);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setIcon(new ImageIcon(getClass().getResource("/com/noon/icon/취소버튼.png")));
		lblNewLabel_2_2.setBounds(207, 492, 115, 50);
		add(lblNewLabel_2_2);
		


	}
	
	// Init the table
			private void tableInit() {
				Outer_Table.addColumn("번호");
				Outer_Table.addColumn("주문번호 ");
				Outer_Table.addColumn("음료명");
				Outer_Table.addColumn("주문수량");
				Outer_Table.addColumn("주문시각");
				Outer_Table.addColumn("처리상태");

				Outer_Table.setColumnCount(6);

				// table에 있는 데이터 지우기
				int a = Outer_Table.getRowCount();
				for (int i = 0; i < a; i++) {
					Outer_Table.removeRow(0); // 열이 하나씩 당겨지기 때문에
				}

				Inner_table.setAutoResizeMode(Inner_table.AUTO_RESIZE_OFF);
				// 번호 column
				int vColIndex = 0;
				TableColumn col = Inner_table.getColumnModel().getColumn(vColIndex);
				int width = 50;
				col.setPreferredWidth(width);
				// 주문번호 column
				vColIndex = 1;
				col = Inner_table.getColumnModel().getColumn(vColIndex);
				width = 100;
				col.setPreferredWidth(width);
				// 음료명 column
				vColIndex = 2;
				col = Inner_table.getColumnModel().getColumn(vColIndex);
				width =180;
				col.setPreferredWidth(width);
				// 주문수량  column
				vColIndex = 3;
				col = Inner_table.getColumnModel().getColumn(vColIndex);
				width = 80;
				col.setPreferredWidth(width);
				// 주문시각 column
				vColIndex = 4;
				col = Inner_table.getColumnModel().getColumn(vColIndex);
				width = 150;
				col.setPreferredWidth(width);
				// 처리상태 column
				vColIndex = 5;
				col = Inner_table.getColumnModel().getColumn(vColIndex);
				width = 100;
				col.setPreferredWidth(width);
				
			}
}