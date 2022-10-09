package com.noon.form.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ManagerForm4 extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public ManagerForm4() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("음료명");
		lblNewLabel.setBounds(58, 97, 61, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("가격");
		lblNewLabel_1.setBounds(58, 181, 61, 16);
		add(lblNewLabel_1);
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(151, 392, 117, 29);
		btnNewButton.setIcon(new ImageIcon("/Users/bagtaegwon/Downloads/Frame 8-3.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
			
			}
		});
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(349, 392, 117, 29);
		btnNewButton_1.setIcon(new ImageIcon("/Users/bagtaegwon/Downloads/Frame 9.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
			
			}
		});
		add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("대충 카페모카사진");
		lblNewLabel_2.setBounds(449, 136, 202, 169);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("이미지변경");
		lblNewLabel_1_1.setBounds(489, 299, 61, 16);
		add(lblNewLabel_1_1);
		
		JButton btnNewButton_2 = new JButton("뒤로");
		btnNewButton_2.setBounds(18, 18, 117, 29);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
			}
		});
		add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(58, 119, 248, 26);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(58, 209, 248, 26);
		add(textField_1);

	}
	}


