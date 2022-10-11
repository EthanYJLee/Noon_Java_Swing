package com.noon.form.manager;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManagerForm4 extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public ManagerForm4() {
		setLayout(null);
		setOpaque(false);

		JLabel lblNewLabel = new JLabel("음료명");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(57, 70, 42, 32);
		add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(57, 100, 375, 45);
		add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("가격");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(57, 165, 42, 32);
		add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(57, 190, 375, 45);
		add(textField_1);

		JLabel lblNewLabel_1_1 = new JLabel("카테고리");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(57, 265, 88, 32);
		add(lblNewLabel_1_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(ManagerForm4.class.getResource("/com/noon/icon/biglogo.png")));
		lblNewLabel_2.setBorder(new BevelBorder(BevelBorder.RAISED));
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(498, 97, 200, 200);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 판매종료일을 nowdate()로 업데이트 하면 된다. 그럼 끝 
			}
		});
		ImageIcon icon1 = new ImageIcon((ManagerForm4.class.getResource("/com/noon/icon/delete.png")));
		Image img1 = icon1.getImage();
		Image changeImg1 = img1.getScaledInstance(118, 45, Image.SCALE_SMOOTH);
		lblNewLabel_3.setIcon(new ImageIcon(changeImg1));
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.setBounds(184, 430, 118, 45);
		add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 수정한 값을 다해서 넣으면 된다. 
			}
		});
		ImageIcon icon = new ImageIcon((ManagerForm4.class.getResource("/com/noon/icon/update.png")));
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(118, 45, Image.SCALE_SMOOTH);
		lblNewLabel_3_1.setIcon(new ImageIcon(changeImg));
		lblNewLabel_3_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3_1.setBounds(314, 430, 118, 45);
		add(lblNewLabel_3_1);

		JLabel lblNewLabel_4 = new JLabel("이미지 변경하기");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Font font2 = lblNewLabel_4.getFont();
        Map attributes2 = font2.getAttributes();
        attributes2.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        lblNewLabel_4.setFont(font2.deriveFont(attributes2));
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(542, 309, 118, 16);
		add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"coffee", "beverage", "tea"}));
		comboBox.setBounds(128, 261, 149, 45);
		add(comboBox);
	}
}
