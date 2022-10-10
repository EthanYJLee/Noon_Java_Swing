package com.noon.form.executive;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ExecutiveForm1 extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public ExecutiveForm1() {
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("지점등록");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 40));
		lblNewLabel_1.setBounds(66, 73, 172, 50);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("지점번호");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(117, 161, 133, 61);
		add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(247, 179, 250, 30);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("지점명");
		lblNewLabel_1_1_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(119, 234, 133, 61);
		add(lblNewLabel_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(248, 252, 250, 30);
		add(textField_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("전화번호");
		lblNewLabel_1_1_2.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_1_2.setBounds(117, 309, 133, 61);
		add(lblNewLabel_1_1_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(248, 327, 250, 30);
		add(textField_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\heeya\\OneDrive\\바탕 화면\\noonProject\\icon\\등록하기 버튼.png"));
		lblNewLabel.setBounds(366, 438, 220, 50);
		add(lblNewLabel);

	}
}
