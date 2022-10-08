package com.noon.component;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class JPanel2 extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblId;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton;
	private JLabel lblNewLabel_3_1;
	private JTextField textField_3;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_4;

	/**
	 * Create the panel.
	 */
	public JPanel2() {
		setLayout(null);
		add(getLblNewLabel());
		add(getLblId());
		add(getLblNewLabel_2());
		add(getLblNewLabel_3());
		add(getTextField());
		add(getTextField_1());
		add(getTextField_2());
		add(getBtnNewButton());
		add(getLblNewLabel_3_1());
		add(getTextField_3());
		add(getLblNewLabel_1());
		add(getLblNewLabel_4());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("알바 등록");
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 19));
			lblNewLabel.setBounds(58, 48, 83, 53);
		}
		return lblNewLabel;
	}
	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID");
			lblId.setFont(new Font("Arial", Font.BOLD, 13));
			lblId.setBounds(73, 160, 61, 16);
		}
		return lblId;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("이름");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
			lblNewLabel_2.setBounds(73, 212, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("전화 번호");
			lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
			lblNewLabel_3.setBounds(73, 270, 61, 16);
		}
		return lblNewLabel_3;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(156, 154, 272, 26);
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(156, 206, 272, 26);
		}
		return textField_1;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(156, 264, 272, 26);
		}
		return textField_2;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.setIcon(new ImageIcon("/Users/bigdata/Downloads/Frame 7.png"));
			btnNewButton.setBounds(280, 448, 116, 36);
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel_3_1() {
		if (lblNewLabel_3_1 == null) {
			lblNewLabel_3_1 = new JLabel("계좌 번호");
			lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 13));
			lblNewLabel_3_1.setBounds(73, 325, 61, 16);
		}
		return lblNewLabel_3_1;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(156, 319, 272, 26);
		}
		return textField_3;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("New label");
			lblNewLabel_1.setIcon(new ImageIcon("/Users/bigdata/Downloads/free-icon-person-5393061.png"));
			lblNewLabel_1.setBounds(477, 91, 259, 256);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("프로필 사진 등록하기");
			lblNewLabel_4.setBounds(549, 370, 116, 16);
		}
		return lblNewLabel_4;
	}
}
