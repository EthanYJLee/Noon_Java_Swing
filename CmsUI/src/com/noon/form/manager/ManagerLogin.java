package com.noon.form.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class ManagerLogin extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the panel.
	 */
	public ManagerLogin() {

			setLayout(null);
			
			JLabel lblNewLabel = new JLabel("사원번호");
			lblNewLabel.setBounds(68, 103, 61, 16);
			add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("이름");
			lblNewLabel_1.setBounds(68, 148, 61, 16);
			add(lblNewLabel_1);
			
			JLabel lblId = new JLabel("Id");
			lblId.setBounds(69, 202, 61, 16);
			add(lblId);
			
			JLabel lblPw = new JLabel("pw");
			lblPw.setBounds(66, 249, 61, 16);
			add(lblPw);
			
			JLabel lblPw_1 = new JLabel("pw확인");
			lblPw_1.setBounds(65, 296, 61, 16);
			add(lblPw_1);
			
			JLabel lblNewLabel_5 = new JLabel("가게코드");
			lblNewLabel_5.setBounds(62, 350, 61, 16);
			add(lblNewLabel_5);
			
			textField = new JTextField();
			textField.setBounds(68, 119, 244, 26);
			add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(66, 169, 244, 26);
			add(textField_1);
			
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(67, 221, 244, 26);
			add(textField_2);
			
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(65, 270, 244, 26);
			add(textField_3);
			
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(64, 319, 244, 26);
			add(textField_4);
			
			textField_5 = new JTextField();
			textField_5.setColumns(10);
			textField_5.setBounds(63, 373, 244, 26);
			add(textField_5);
			
			JButton btnNewButton = new JButton("");
			btnNewButton.setIcon(new ImageIcon("/Users/bagtaegwon/Downloads/basicOutline Button.png"));
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			btnNewButton.setBounds(319, 119, 95, 29);
			add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("");
			btnNewButton_1.setIcon(new ImageIcon("/Users/bagtaegwon/Downloads/basicOutline Button.png"));
			btnNewButton_1.setBounds(319, 371, 95, 29);
			add(btnNewButton_1);
			
			JButton btnNewButton_2 = new JButton("");
			btnNewButton_2.setIcon(new ImageIcon("/Users/bagtaegwon/Downloads/Frame 8.png"));
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					Main2.frame.getContentPane().add(new JPanel1());
					setVisible(false);
				}
			});
			btnNewButton_2.setBounds(245, 452, 117, 29);
			add(btnNewButton_2);

		
	}

}
