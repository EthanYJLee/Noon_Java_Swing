package com.noon.form.executive;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import com.noon.dao.DaoManage;
import com.noon.dao.DaoShopup;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		
		
		textField_2 = new JFormattedTextField(new NumberFormatter());
		textField_2.setColumns(10);
		textField_2.setBounds(263, 290, 322, 45);
		textField_2.addKeyListener(new KeyAdapter() {
			public void KeyTyped(KeyEvent ke) {
				if(((JFormattedTextField)ke.getSource()).getText().length() > 3)
					ke.consume();
			}
		});
		add(textField_2);
	
		
//		JFormattedTextField textField_2= new JFormattedTextField(new NumberFormatter());
//		textField_2.setColumns(10);
//		textField_2.setBounds(263, 290, 322, 45);
//		
//		textField_2.addKeyListener(new KeyAdapter() {
//			public void KeyTyped(KeyEvent ke) {
//				if(((JFormattedTextField)ke.getSource()).getText().length() > 11)
//					ke.consume();
//			}
//		});
//		add(textField_2);
//		
		
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textField_2.getText().length() == 10 && textField_1.getText().trim().length() != 0) {
				insertShop();
				insertShopregi();
				JOptionPane.showConfirmDialog(null, "지점 등록 완료");
				}else {
					JOptionPane.showConfirmDialog(null, "등록 양식이 틀렸습니다");
					clearColumn();
//					setVisible(false);
				}
				
				
			}
		});
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ImageIcon icon = new ImageIcon((ExecutiveForm1.class.getResource("/com/noon/icon/Frame 8.png")));
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(150, 44, Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(changeImg));
		lblNewLabel.setBounds(435, 392, 150, 44);
		add(lblNewLabel);

	}
	private void insertShop() { 
		
			DaoShopup dao = new DaoShopup(Integer.parseInt(textField.getText().trim()), textField_1.getText().trim(),textField_2.getText().trim());
			dao.insertShop();

	}
	private void insertShopregi(){
		
		int num = Integer.parseInt(textField.getText().trim());
		String ko = "mong";
		DaoShopup dao = new DaoShopup(num,ko);
		dao.insertShopregi();
	}
	private void clearColumn() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");

	}
	
}
