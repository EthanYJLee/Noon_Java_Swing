package com.noon.form.executive;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.noon.dao.DaoShop;
import com.noon.dao.DaoShopup;
import com.noon.main.Login;

public class ExecutiveForm1 extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JLabel lblCheckShopcode;

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
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				checkShopcode();
			}
		});
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
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				checkTf();
			}
		});
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ImageIcon icon = new ImageIcon((ExecutiveForm1.class.getResource("/com/noon/icon/Frame 8.png")));
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(150, 44, Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(changeImg));
		lblNewLabel.setBounds(435, 392, 150, 44);
		add(lblNewLabel);

		lblCheckShopcode = new JLabel("");
		lblCheckShopcode.setBounds(263, 193, 321, 25);
		add(lblCheckShopcode);

	}

	private void insertShop() {

		DaoShopup dao = new DaoShopup(Integer.parseInt(textField.getText().trim()), textField_1.getText().trim(),
				textField_2.getText().trim());
		dao.insertShop();

	}

	private void insertShopregi() {

		int num = Integer.parseInt(textField.getText().trim());
		DaoShopup dao = new DaoShopup(num, Login.id);
		dao.insertShopregi();
	}

	private void clearColumn() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
	}

	private void checkTf() {
		String empty = "";
		int i = 0;
		try {
			if (textField_2.getText().trim().length() != 0) {
				int check = Integer.parseInt(textField_2.getText().trim());
			}

			if (textField_2.getText().trim().length() == 0) {
				empty = "전화번호";
				i++;
			} else if (textField_1.getText().trim().length() == 0) {
				empty = "지점명";
				i++;
			} else if (textField.getText().trim().length() == 0) {
				empty = "지점번호";
				i++;
			}
			

			if (i == 0) {
				JOptionPane.showConfirmDialog(null, "등록완료되었습니다.");
				insertShop();
				insertShopregi();
				clearColumn();
			} else {
				JOptionPane.showConfirmDialog(null, empty + "를 입력해주세요.");
				return;
			}

		} catch (NumberFormatException e) {
			textField_2.setText("");
			JOptionPane.showConfirmDialog(null, "숫자만 입력해주세요.");
		}
	}

	private boolean checkShopcode() {
		boolean result;
		try {
			DaoShop dao = new DaoShop(Integer.parseInt(textField.getText().trim()));
			result = dao.checkShopcode();
			if (result) {
				lblCheckShopcode.setText("생성 가능한 가게번호입니다.");
				lblCheckShopcode.setForeground(new Color(0, 0, 255));
			} else {
				lblCheckShopcode.setText("이미 존재하거나 폐점한 가게입니다.");
				lblCheckShopcode.setForeground(new Color(255, 0, 0));
			}
		} catch (NumberFormatException e) {
			if(textField.getText().trim().length() == 0) {
				return false;
			}else {
				JOptionPane.showConfirmDialog(null, "숫자만 입력해주세요.");
				textField.setText("");
				return false;
			}
			
			
		}
		return result;

	}
}
