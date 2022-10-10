package com.noon.form.manager;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ManagerForm5 extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	public ManagerForm5 jpanel5;

	/**
	 * Create the panel.
	 */
	public ManagerForm5() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("음료명");
		lblNewLabel.setBounds(80, 80, 61, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("가격");
		lblNewLabel_1.setBounds(80, 182, 61, 16);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("이미지추가");
		lblNewLabel_2.setBounds(518, 182, 61, 16);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("메뉴사진");
		lblNewLabel_3.setBounds(518, 99, 61, 16);
		add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(72, 108, 347, 26);
		add(textField);
		textField.setColumns(10);
		
		JButton btn6plus = new JButton("");
		btn6plus.setIcon(new ImageIcon("/Users/bagtaegwon/Downloads/Frame 8-4.png"));
		btn6plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jpanel5.add(new ManagerForm3());
				setVisible(false);
			
			}
		});
		btn6plus.setBounds(267, 323, 117, 29);
		add(btn6plus);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(72, 210, 347, 26);
		add(textField_1);

	}

}
