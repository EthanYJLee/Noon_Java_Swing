package com.noon.form.manager;

import java.awt.Cursor;
import java.awt.Font;
import java.util.Map;
import java.awt.font.TextAttribute;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class ManagerForm5 extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	public ManagerForm5 jpanel5;

	/**
	 * Create the panel.
	 */
	public ManagerForm5() {
		setLayout(null);
		setOpaque(false);
		
		JLabel lblNewLabel = new JLabel("음료명");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel.setBounds(72, 62, 100, 50);
		add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("이미지추가");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 12));
		Font font = lblNewLabel_2.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        lblNewLabel_2.setFont(font.deriveFont(attributes));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setBounds(590, 323, 74, 16);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("메뉴사진");
		lblNewLabel_3.setBorder(new BevelBorder(BevelBorder.RAISED));
		lblNewLabel_3.setBounds(518, 99, 200, 200);
		add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(72, 108, 375, 45);
		add(textField);
		textField.setColumns(10);
		
		JButton btn6plus = new JButton("");
		btn6plus.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 12));
		btn6plus.setIcon(new ImageIcon("C:\\Users\\heeya\\OneDrive\\바탕 화면\\noonProject\\icon\\추가하기.png"));
		btn6plus.setBounds(313, 436, 118, 45);
		add(btn6plus);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(72, 210, 375, 45);
		add(textField_1);
		
		JLabel lblNewLabel_1 = new JLabel("가격");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel_1.setBounds(72, 163, 100, 50);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("카테고리");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(72, 265, 100, 50);
		add(lblNewLabel_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"coffee", "beverage", "tea"}));
		comboBox.setBounds(172, 281, 149, 45);
		add(comboBox);

	}
}
