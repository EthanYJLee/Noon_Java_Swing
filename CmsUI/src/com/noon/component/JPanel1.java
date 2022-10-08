package com.noon.component;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;

public class JPanel1 extends JPanel {
	private JLabel lblNewLabel;
	private JComboBox comboBox;
	private JTextPane textPane;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JButton btnNewButton_1;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public JPanel1() {
		setLayout(null);
		add(getLblNewLabel());
		add(getComboBox());
		add(getTextPane());
		add(getBtnNewButton());
		add(getScrollPane());
		add(getBtnNewButton_1());

	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("알바 급여 관리");
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
			lblNewLabel.setBounds(28, 46, 123, 16);
		}
		return lblNewLabel;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"이름", "전화번호"}));
			comboBox.setBounds(227, 41, 118, 27);
		}
		return comboBox;
	}
	private JTextPane getTextPane() {
		if (textPane == null) {
			textPane = new JTextPane();
			textPane.setBounds(350, 46, 252, 16);
		}
		return textPane;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.setIcon(new ImageIcon("/Users/bigdata/Downloads/검색검색하기.png"));
			btnNewButton.setBounds(620, 38, 111, 24);
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(38, 74, 693, 354);
			scrollPane.setColumnHeaderView(getTable());
		}
		return scrollPane;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("");
			btnNewButton_1.setIcon(new ImageIcon("/Users/bigdata/Downloads/Frame 7 (1).png"));
			btnNewButton_1.setBounds(614, 440, 117, 29);
		}
		return btnNewButton_1;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return table;
	}
}
