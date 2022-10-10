package com.javalec.base;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.javalec.util.RoundedButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class MenuMain extends JPanel {
	JPanel panel = new JPanel();


	
	public MenuMain() {
		setLocation(0, 0);
		setLayout(null);
		setBackground(new Color(244, 210, 201));
		setSize(350, 700);
		
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 175, 350, 525);
		add(panel);
		panel.setLayout(null);
		
		RoundedButton btnChoose = new RoundedButton("");
		btnChoose.setBackground(new Color(255, 255, 255));
		btnChoose.setIcon(new ImageIcon(MenuMain.class.getResource("/com/javalec/image/Group 6909.png")));
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Frame.frame.getContentPane().add(new Detail());
			}
		});
		btnChoose.setBounds(12, 450, 326, 65);
		panel.add(btnChoose);
		
		RoundedButton btnToCart = new RoundedButton("");
		btnToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// if 장바구니 담긴 상품 없으면 showMessageDialog
				// else Cart로 이동
			}
		});
		btnToCart.setBackground(new Color(255, 255, 255));
		btnToCart.setIcon(new ImageIcon(MenuMain.class.getResource("/com/javalec/image/Group 6910.png")));
		btnToCart.setBounds(288, 390, 50, 50);
		panel.add(btnToCart);
		
		RoundedButton btnCoffee = new RoundedButton("");
		btnCoffee.setBackground(new Color(244, 210, 201));
		btnCoffee.setIcon(new ImageIcon(MenuMain.class.getResource("/com/javalec/image/Group 6917.png")));
		btnCoffee.setFont(new Font("굴림", Font.PLAIN, 8));
		btnCoffee.setBorderPainted(false);
		btnCoffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCoffee.setBounds(6, 61, 80, 80);
		add(btnCoffee);
		
		RoundedButton btnBeverage = new RoundedButton("");
		btnBeverage.setBackground(new Color(244, 210, 201));
		btnBeverage.setIcon(new ImageIcon(MenuMain.class.getResource("/com/javalec/image/Group 6918.png")));
		btnBeverage.setFont(new Font("굴림", Font.PLAIN, 8));
		btnBeverage.setBorderPainted(false);
		btnBeverage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnBeverage.setBounds(92, 61, 80, 80);
		add(btnBeverage);
		
		RoundedButton btnTea = new RoundedButton("");
		btnTea.setBackground(new Color(244, 210, 201));
		btnTea.setIcon(new ImageIcon(MenuMain.class.getResource("/com/javalec/image/Group 6919.png")));
		btnTea.setFont(new Font("굴림", Font.PLAIN, 8));
		btnTea.setBorderPainted(false);
		btnTea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchCategory();
				
			}
		});
		btnTea.setBounds(178, 61, 80, 80);
		add(btnTea);
		
		RoundedButton btnShowAll = new RoundedButton("");
		btnShowAll.setBackground(new Color(244, 210, 201));
		btnShowAll.setIcon(new ImageIcon(MenuMain.class.getResource("/com/javalec/image/Group 6920.png")));
		btnShowAll.setFont(new Font("굴림", Font.PLAIN, 8));
		btnShowAll.setBorderPainted(false);
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnShowAll.setBounds(264, 61, 80, 80);
		add(btnShowAll);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(MenuMain.class.getResource("/com/javalec/image/Coffee.png")));
		lblNewLabel.setBounds(6, 151, 80, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MenuMain.class.getResource("/com/javalec/image/Beverage.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(92, 151, 80, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MenuMain.class.getResource("/com/javalec/image/Tea.png")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(178, 151, 80, 15);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(MenuMain.class.getResource("/com/javalec/image/Menu.png")));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(264, 151, 80, 15);
		add(lblNewLabel_3);
		
		RoundedButton btnBack = new RoundedButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Frame.frame.getContentPane().add(new Welcome());
				
			}
		});
		btnBack.setBackground(new Color(244, 210, 201));
		btnBack.setIcon(new ImageIcon(MenuMain.class.getResource("/com/javalec/image/Vector.png")));
		btnBack.setBounds(12, 10, 33, 36);
		add(btnBack);
	}
	
	public void searchCategory() {
		 
	}
	
	
	public void showAllAction() {
		
	}
}
