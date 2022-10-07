package com.noon.component;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PartTimer extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PartTimer() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("2022.10.25");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setBounds(600, 46, 139, 39);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 100, 418, 321);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("미완료 건수 : ");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1.setBounds(30, 443, 195, 39);
		add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("취소");
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 18));
		btnNewButton.setBounds(198, 492, 91, 50);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("선택");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 18));
		btnNewButton_1.setBounds(331, 492, 91, 50);
		add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("주문 리스트");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 40));
		lblNewLabel_1_1.setBounds(72, 38, 250, 39);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("주문번호 : 2022102500");
		lblNewLabel_1_2.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(465, 102, 196, 39);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("음료명    : 아메리카노");
		lblNewLabel_1_2_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_2_1.setBounds(464, 148, 250, 39);
		add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("주문수량 :  2");
		lblNewLabel_1_2_2.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_2_2.setBounds(464, 226, 195, 39);
		add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("주문시각 : ");
		lblNewLabel_1_2_3.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_2_3.setBounds(464, 274, 102, 39);
		add(lblNewLabel_1_2_3);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("추가사항 : ");
		lblNewLabel_1_2_4.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_2_4.setBounds(467, 314, 195, 39);
		add(lblNewLabel_1_2_4);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("               (ICE)");
		lblNewLabel_1_2_2_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_2_2_1.setBounds(472, 179, 195, 39);
		add(lblNewLabel_1_2_2_1);
		
		JLabel lblNewLabel_1_2_4_1 = new JLabel("22.10.25.");
		lblNewLabel_1_2_4_1.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel_1_2_4_1.setBounds(572, 275, 91, 39);
		add(lblNewLabel_1_2_4_1);
		
		JLabel lblNewLabel_1_2_4_1_1 = new JLabel("샷2, 시럽, 토핑");
		lblNewLabel_1_2_4_1_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_2_4_1_1.setBounds(576, 314, 155, 39);
		add(lblNewLabel_1_2_4_1_1);
		
		JLabel lblNewLabel_1_2_4_1_2 = new JLabel("10:15:23");
		lblNewLabel_1_2_4_1_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_1_2_4_1_2.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel_1_2_4_1_2.setBounds(662, 274, 91, 39);
		add(lblNewLabel_1_2_4_1_2);
		
		JLabel lblNewLabel_1_2_2_2 = new JLabel("12");
		lblNewLabel_1_2_2_2.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_2_2_2.setBounds(168, 443, 42, 39);
		add(lblNewLabel_1_2_2_2);
		
		JButton btnNewButton_1_1 = new JButton("완료");
		btnNewButton_1_1.setFont(new Font("굴림", Font.BOLD, 18));
		btnNewButton_1_1.setBounds(611, 492, 91, 50);
		add(btnNewButton_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("완료 시각 : ");
		lblNewLabel_1_3.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(475, 443, 114, 39);
		add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_2_4_1_2_1 = new JLabel("10:18:27");
		lblNewLabel_1_2_4_1_2_1.setForeground(new Color(254, 20, 1));
		lblNewLabel_1_2_4_1_2_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_2_4_1_2_1.setBounds(590, 442, 91, 39);
		add(lblNewLabel_1_2_4_1_2_1);

	}
}
