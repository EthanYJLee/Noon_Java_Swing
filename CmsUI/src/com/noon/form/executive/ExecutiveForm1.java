package com.noon.form.executive;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ExecutiveForm1 extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public ExecutiveForm1() {
		setLayout(null);
		setOpaque(false);
		JLabel lblNewLabel_1 = new JLabel("지점등록");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 40));
		lblNewLabel_1.setBounds(133, 51, 172, 50);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("지점번호");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(133, 140, 133, 61);
		add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(263, 149, 322, 45);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("지점명");
		lblNewLabel_1_1_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(135, 213, 133, 61);
		add(lblNewLabel_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(264, 222, 321, 45);
		add(textField_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("전화번호");
		lblNewLabel_1_1_2.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_1_2.setBounds(133, 288, 133, 61);
		add(lblNewLabel_1_1_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(263, 290, 322, 45);
		add(textField_2);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ImageIcon icon = new ImageIcon((ExecutiveForm1.class.getResource("/com/noon/icon/Frame 8.png")));
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(150, 44, Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(changeImg));
		lblNewLabel.setBounds(435, 392, 150, 44);
		add(lblNewLabel);

	}
}
