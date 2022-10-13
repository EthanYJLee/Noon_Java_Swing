package com.noon.form.parttime;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.noon.dao.DaoOrder;
import com.noon.dto.DtoOrder;

public class ParttimeForm1 extends JPanel {
	private JTable Inner_table; // 이너테이블

	// -- Table Definition
	// 아우터 테이블
	private final DefaultTableModel Outer_Table = new DefaultTableModel(); // ******** 중요 ********
	private JTextField tforderno;
	private JTextField tfcoffename;
	private JTextField tfquantity;
	private JTextField textField_3;
	private JTextField tfordertime;
	private JTextField tfendtime;
	private JTextField tfnoclear;

	public int orderno;

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
				searchAction();

			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		scrollPane.setBounds(30, 100, 418, 321);
		add(scrollPane);

		Inner_table = new JTable();
		Inner_table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableClick();
				NoClearList();

			}
		});
		Inner_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Inner_table.setModel(Outer_Table);
		scrollPane.setViewportView(Inner_table);

		JLabel lblNoclear = new JLabel("미완료 건수 : ");
		lblNoclear.setFont(new Font("굴림", Font.BOLD, 20));
		lblNoclear.setBounds(30, 442, 121, 39);
		add(lblNoclear);

		JLabel lblNewLabel_1_1 = new JLabel("주문 리스트");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 40));
		lblNewLabel_1_1.setBounds(72, 38, 250, 39);
		add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("주문번호 : ");
		lblNewLabel_1_2.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(465, 102, 101, 39);
		add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_2_1 = new JLabel("음료명   :");
		lblNewLabel_1_2_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_2_1.setBounds(464, 148, 80, 39);
		add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_2_2 = new JLabel("주문수량 :");
		lblNewLabel_1_2_2.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_2_2.setBounds(464, 226, 80, 39);
		add(lblNewLabel_1_2_2);

		JLabel lblNewLabel_1_2_3 = new JLabel("주문시각 : ");
		lblNewLabel_1_2_3.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_2_3.setBounds(464, 274, 102, 39);
		add(lblNewLabel_1_2_3);

		JLabel lblNewLabel_1_2_4 = new JLabel("추가사항 : ");
		lblNewLabel_1_2_4.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_2_4.setBounds(467, 314, 91, 39);
		add(lblNewLabel_1_2_4);

		JLabel lblNewLabel_1_3 = new JLabel("완료 시각 : ");
		lblNewLabel_1_3.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(475, 443, 114, 39);
		add(lblNewLabel_1_3);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateAction();
				searchAction();

			}
		});
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

		tforderno = new JTextField();
		tforderno.setBounds(554, 100, 195, 37);
		add(tforderno);
		tforderno.setColumns(10);

		tfcoffename = new JTextField();
		tfcoffename.setColumns(10);
		tfcoffename.setBounds(556, 150, 195, 37);
		add(tfcoffename);

		tfquantity = new JTextField();
		tfquantity.setColumns(10);
		tfquantity.setBounds(556, 226, 195, 37);
		add(tfquantity);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(561, 314, 195, 37);
		add(textField_3);

		tfordertime = new JTextField();
		tfordertime.setColumns(10);
		tfordertime.setBounds(554, 274, 195, 37);
		add(tfordertime);

		tfendtime = new JTextField();
		tfendtime.setColumns(10);
		tfendtime.setBounds(573, 442, 195, 37);
		add(tfendtime);

		tfnoclear = new JTextField();
		tfnoclear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NoClearList();
			}
		});
		tfnoclear.setColumns(10);
		tfnoclear.setBounds(139, 446, 195, 37);
		add(tfnoclear);

	}

	// Init the table
	private void tableInit() {
		Outer_Table.addColumn("주문번호");
		Outer_Table.addColumn("음료명");
		Outer_Table.addColumn("주문수량");
		Outer_Table.addColumn("주문시각");
		Outer_Table.addColumn("접수시간");
		Outer_Table.addColumn("처리시간");

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
		int width = 25;
		col.setPreferredWidth(width);
		// 주문번호 column
		vColIndex = 1;
		col = Inner_table.getColumnModel().getColumn(vColIndex);
		width = 90;
		col.setPreferredWidth(width);
		// 음료명 column
		vColIndex = 2;
		col = Inner_table.getColumnModel().getColumn(vColIndex);
		width = 90;
		col.setPreferredWidth(width);
		// 주문수량 column
		vColIndex = 3;
		col = Inner_table.getColumnModel().getColumn(vColIndex);
		width = 90;
		col.setPreferredWidth(width);
		// 주문시각 column
		vColIndex = 4;
		col = Inner_table.getColumnModel().getColumn(vColIndex);
		width = 95;
		col.setPreferredWidth(width);
		// 처리상태 column
		vColIndex = 5;
		col = Inner_table.getColumnModel().getColumn(vColIndex);
		width = 95;
		col.setPreferredWidth(width);

	}
	// 주문번호 음료명 주문수량 주문시간 접수시간 처리시간
	private void searchAction() {
		// outer table에 추가할 열을 가져온다.dtoOrder로 가져온다.
		DaoOrder dao = new DaoOrder();
		ArrayList<DtoOrder> dto = dao.searchAction();
		
		for(DtoOrder a : dto) {
			String[] qTxt = {Integer.toString(a.getOrderno()) , a.getMenu_name() , Integer.toString(a.getQuantity()), a.getOrdertime() , a.getAccepttime() , a.getCompletetime()};
			Outer_Table.addRow(qTxt);
		}
		
	}

	private void tableClick() {

		int selectRow = Inner_table.getSelectedRow();
		String wkSequence = (String) Inner_table.getValueAt(selectRow, 0);
		orderno = Integer.parseInt(wkSequence);
		DaoOrder dao = new DaoOrder(orderno);
		DtoOrder dto = dao.tableClick();

		tforderno.setText(Integer.toString(dto.getOrderno()));
		tfcoffename.setText(dto.getName());
		tfquantity.setText(Integer.toString(dto.getQuantity()));
		tfordertime.setText(dto.getOrdertime());
		tfendtime.setText(dto.getCompletetime());

	}

	public void updateAction() {
		int selectRow = Inner_table.getSelectedRow();
		String wkSequence = (String) Inner_table.getValueAt(selectRow, 0);
		DaoOrder dao = new DaoOrder(Integer.parseInt(wkSequence));
		dao.updateAction();
		tableInit();
//		sum = searchAction();
//		textField.setText(Integer.toString(sum));
	}

	private void NoClearList() {

		int selectRow = Inner_table.getSelectedRow();
		String wkSequence = (String) Inner_table.getValueAt(selectRow, 0);
		orderno = Integer.parseInt(wkSequence);
		DaoOrder dao = new DaoOrder(orderno);
		DtoOrder dto = dao.tableClick();
//		tfnoclear.getText(Integer.parseInt(wkSequence));
		// count한 값을 전부 tfnoclear에 넣어주면 끝나는데?

	}

}
