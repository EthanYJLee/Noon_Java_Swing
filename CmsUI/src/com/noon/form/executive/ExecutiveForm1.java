package com.noon.form.executive;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

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
		lblNewLabel_1_1_1.setBounds(118, 238, 133, 61);
		add(lblNewLabel_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(247, 256, 250, 30);
		add(textField_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("전화번호");
		lblNewLabel_1_1_2.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_1_2.setBounds(121, 323, 133, 61);
		add(lblNewLabel_1_1_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(247, 341, 250, 30);
		add(textField_2);
		
		JButton btnNewButton = new JButton("등록하기");
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 15));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(346, 440, 91, 50);
		add(btnNewButton);

	}
}
