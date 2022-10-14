package com.noon.form.parttime;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;

public class ParttimeForm1 extends JPanel {
	private JTable Inner_table; // 이너테이블

	// -- Table Definition
	// 아우터 테이블
	private final DefaultTableModel Outer_Table = new DefaultTableModel(); // ******** 중요 ********
	private JTextField tfOrderno;
	private JTextField tfMenuname;
	private JTextField tfQuantity;
	private JTextField tfForHereToGO;

	public int orderno;
	private JTextField tfHotIce;
	private JTextField tfOption;
	JLabel lblNotClear;
	private JTextField tfOption2;
	private JTextField tfOption3;

	/**
	 * Create the panel.
	 */
	public ParttimeForm1() {
		setLayout(null);
		setOpaque(false);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				tableInit();
				searchAction();
				countNotCompleteOrder();
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		scrollPane.setBounds(6, 99, 418, 321);
		add(scrollPane);

		Inner_table = new JTable();
		Inner_table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableClick();
			}
		});
		Inner_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Inner_table.setModel(Outer_Table);
		scrollPane.setViewportView(Inner_table);

		lblNotClear = new JLabel("");
		lblNotClear.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNotClear.setFont(new Font("굴림", Font.BOLD, 20));
		lblNotClear.setBounds(236, 443, 188, 39);
		add(lblNotClear);

		JLabel lblTitle = new JLabel("주문 리스트");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 40));
		lblTitle.setBounds(6, 36, 250, 39);
		add(lblTitle);

		JLabel lblOrderno = new JLabel("주문번호 ");
		lblOrderno.setFont(new Font("굴림", Font.BOLD, 20));
		lblOrderno.setBounds(451, 64, 101, 39);
		add(lblOrderno);

		JLabel lblMenuname = new JLabel("음료명   ");
		lblMenuname.setFont(new Font("굴림", Font.BOLD, 20));
		lblMenuname.setBounds(451, 114, 80, 39);
		add(lblMenuname);

		JLabel lblQuantity = new JLabel("주문수량 ");
		lblQuantity.setFont(new Font("굴림", Font.BOLD, 20));
		lblQuantity.setBounds(451, 164, 80, 39);
		add(lblQuantity);

		JLabel lblForHereToGo = new JLabel("포장여부");
		lblForHereToGo.setFont(new Font("굴림", Font.BOLD, 20));
		lblForHereToGo.setBounds(451, 214, 102, 39);
		add(lblForHereToGo);

		JLabel lblOption = new JLabel("추가사항 ");
		lblOption.setFont(new Font("굴림", Font.BOLD, 20));
		lblOption.setBounds(451, 314, 91, 39);
		add(lblOption);

		JButton lblComplete = new JButton("");
		lblComplete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateCompleteCompleteTime();
			}
		});
		lblComplete.setIcon(new ImageIcon(getClass().getResource("/com/noon/icon/완료버튼.png")));
		lblComplete.setBounds(635, 519, 115, 50);
		add(lblComplete);

		JButton lblSelect = new JButton("");
		lblSelect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateCompleteAcceptTime();
			}
		});
		lblSelect.setIcon(new ImageIcon(getClass().getResource("/com/noon/icon/선택버튼.png")));
		lblSelect.setBounds(309, 519, 115, 50);
		add(lblSelect);

		JButton lblCancel = new JButton("");
		lblCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateOrder();
			}
		});
		lblCancel.setIcon(new ImageIcon(getClass().getResource("/com/noon/icon/취소버튼.png")));
		lblCancel.setBounds(179, 519, 115, 50);
		add(lblCancel);

		tfOrderno = new JTextField();
		tfOrderno.setEditable(false);
		tfOrderno.setBounds(555, 64, 195, 37);
		add(tfOrderno);
		tfOrderno.setColumns(10);

		tfMenuname = new JTextField();
		tfMenuname.setEditable(false);
		tfMenuname.setColumns(10);
		tfMenuname.setBounds(555, 114, 195, 37);
		add(tfMenuname);

		tfQuantity = new JTextField();
		tfQuantity.setEditable(false);
		tfQuantity.setColumns(10);
		tfQuantity.setBounds(555, 164, 195, 37);
		add(tfQuantity);

		tfForHereToGO = new JTextField();
		tfForHereToGO.setEditable(false);
		tfForHereToGO.setColumns(10);
		tfForHereToGO.setBounds(555, 214, 195, 37);
		add(tfForHereToGO);

		JLabel lblHotIce = new JLabel("hotice");
		lblHotIce.setFont(new Font("Dialog", Font.BOLD, 20));
		lblHotIce.setBounds(450, 264, 102, 39);
		add(lblHotIce);

		tfHotIce = new JTextField();
		tfHotIce.setEditable(false);
		tfHotIce.setColumns(10);
		tfHotIce.setBounds(557, 264, 195, 37);
		add(tfHotIce);

		tfOption = new JTextField(3);
		tfOption.setEditable(false);
		tfOption.setColumns(10);
		tfOption.setBounds(451, 348, 301, 37);
		add(tfOption);

		tfOption2 = new JTextField(10);
		tfOption2.setEditable(false);
		tfOption2.setBounds(451, 397, 301, 37);
		add(tfOption2);

		tfOption3 = new JTextField(10);
		tfOption3.setEditable(false);
		tfOption3.setBounds(451, 445, 301, 37);
		add(tfOption3);

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

		for (DtoOrder a : dto) {
			String[] qTxt = { Integer.toString(a.getOrderno()), a.getMenu_name(), Integer.toString(a.getQuantity()),
					a.getPaytime(), a.getAccepttime(), a.getCompletetime() };
			Outer_Table.addRow(qTxt);
		}

	}

	private void tableClick() {

		int selectRow = Inner_table.getSelectedRow();
		String wkSequence = (String) Inner_table.getValueAt(selectRow, 0);
		orderno = Integer.parseInt(wkSequence);
		DaoOrder dao = new DaoOrder(orderno);
		DtoOrder dto = dao.tableClick();

		tfOrderno.setText(Integer.toString(dto.getOrderno()));
		tfMenuname.setText(dto.getMenu_name());
		tfQuantity.setText(Integer.toString(dto.getQuantity()));
		tfHotIce.setText(dto.getHotice());
		tfForHereToGO.setText(dto.getForheretogo());

		String option = "";

		option = "샷 : " + dto.getShot() + "\n";
		tfOption.setText(option);
		option = "시럽 : " + dto.getSyrup() + "\n";
		tfOption2.setText(option);
		option = "사이즈 : " + dto.getSize();
		tfOption3.setText(option);
	}

	private void updateOrder() {
		int selectRow = Inner_table.getSelectedRow();
		String wkSequence = (String) Inner_table.getValueAt(selectRow, 0);
		orderno = Integer.parseInt(wkSequence);
		DaoOrder dao = new DaoOrder(orderno);
		int i = dao.updateOrder();

		if (i == 1) {
			JOptionPane.showConfirmDialog(null, "주문이 취소되었습니다.");
		} else {
			JOptionPane.showConfirmDialog(null, "주문이 취소되지 않았습니다.");
		}
		tableInit();
		searchAction();
		countNotCompleteOrder();
	}

	private void updateCompleteAcceptTime() {
		int selectRow = Inner_table.getSelectedRow();
		String wkSequence = (String) Inner_table.getValueAt(selectRow, 0);
		orderno = Integer.parseInt(wkSequence);
		DaoOrder dao = new DaoOrder(orderno);
		int i = dao.updateCompleteAcceptTime();

		if (i == 1) {
			JOptionPane.showConfirmDialog(null, "주문이 선택되었습니다.");
		} else {
			JOptionPane.showConfirmDialog(null, "주문이 선택되지 않았습니다.");
		}
		tableInit();
		searchAction();
		countNotCompleteOrder();

	}

	private void updateCompleteCompleteTime() {
		int selectRow = Inner_table.getSelectedRow();
		String wkSequence = (String) Inner_table.getValueAt(selectRow, 0);
		orderno = Integer.parseInt(wkSequence);
		DaoOrder dao = new DaoOrder(orderno);
		int i = dao.updateCompleteCompleteTime();

		if (i == 1) {
			i = dao.updateOrderCompleteNo();
			if (i == 1) {
				JOptionPane.showConfirmDialog(null, "주문이 완료되었습니다.");
			}else {
				JOptionPane.showConfirmDialog(null, "주문이 완료되지 않았습니다.");
			}
		} else {
			JOptionPane.showConfirmDialog(null, "주문이 완료되지 않았습니다.");
		}
		tableInit();
		searchAction();
		countNotCompleteOrder();
		clearTF();
	}

	private void countNotCompleteOrder() {
		DaoOrder dao = new DaoOrder();
		int num = dao.countNotCompleteOrder();

		lblNotClear.setText("미완료 건수 : " + num + "건");
	}

	private void clearTF() {
		tfForHereToGO.setText("");
		tfHotIce.setText("");
		tfMenuname.setText("");
		tfOption.setText("");
		tfOption2.setText("");
		tfOption3.setText("");
		tfOrderno.setText("");
		tfQuantity.setText("");
	}

}
