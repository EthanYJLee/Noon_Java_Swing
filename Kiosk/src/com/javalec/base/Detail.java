package com.javalec.base;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.javalec.component.Menu;
import com.javalec.dao.DaoDetail;
import com.javalec.util.RoundedButton;

public class Detail extends JPanel {
	
	
	
	
	
	
	
	private int hotice;
	private int water;
	private int shot;
	private int syrup;
	private int quantity;

	public Detail() {
		setBackground(new Color(244, 210, 201));
		setSize(350, 700);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 155, 350, 545);
		panel.setBackground(new Color(255, 255, 255));
		add(panel);
		
		RoundedButton btnCancelAll = new RoundedButton("");
		btnCancelAll.setBounds(12, 399, 326, 65);
		btnCancelAll.setBackground(new Color(255, 255, 255));
		btnCancelAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.setLayout(null);
		btnCancelAll.setIcon(new ImageIcon(Detail.class.getResource("/com/javalec/image/Group 69181.png")));
		panel.add(btnCancelAll);
		
		RoundedButton btnAddToCart = new RoundedButton("");
		btnAddToCart.setBounds(12, 470, 326, 65);
		btnAddToCart.setBackground(new Color(255, 255, 255));
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertToOrder();
				setVisible(false);
				Frame.frame.getContentPane().add(new Cart());
			}
		});
		btnAddToCart.setIcon(new ImageIcon(Detail.class.getResource("/com/javalec/image/Group 69191.png")));
		panel.add(btnAddToCart);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 10, 326, 55);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Hot");
		btnNewButton.setBounds(75, 22, 95, 23);
		panel_1.add(btnNewButton);
		
		JButton btnIce = new JButton("Ice");
		btnIce.setBounds(182, 22, 95, 23);
		panel_1.add(btnIce);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 75, 326, 55);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnTall = new JButton("Tall");
		btnTall.setBounds(67, 22, 77, 23);
		panel_2.add(btnTall);
		
		JButton btnGrande = new JButton("Grande");
		btnGrande.setBounds(156, 22, 85, 23);
		panel_2.add(btnGrande);
		
		JButton btnVenti = new JButton("Venti");
		btnVenti.setBounds(253, 22, 61, 23);
		panel_2.add(btnVenti);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(12, 140, 326, 55);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton_5 = new JButton("기본");
		btnNewButton_5.setBounds(32, 22, 56, 23);
		panel_3.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("+1");
		btnNewButton_6.setBounds(100, 22, 56, 23);
		panel_3.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("+2");
		btnNewButton_7.setBounds(176, 22, 56, 23);
		panel_3.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("+3");
		btnNewButton_8.setBounds(258, 22, 56, 23);
		panel_3.add(btnNewButton_8);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(12, 205, 326, 55);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnNewButton_9 = new JButton("없음");
		btnNewButton_9.setBounds(55, 22, 64, 23);
		panel_4.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("헤이즐넛");
		btnNewButton_10.setBounds(131, 22, 90, 23);
		panel_4.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("바닐라");
		btnNewButton_11.setBounds(233, 22, 81, 23);
		panel_4.add(btnNewButton_11);
		
		
		RoundedButton btnBack = new RoundedButton("");
		btnBack.setBounds(12, 10, 33, 36);
		btnBack.setIcon(new ImageIcon(Detail.class.getResource("/com/javalec/image/Vector.png")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Frame.frame.getContentPane().add(new MenuMain());
			}
		});
		btnBack.setBackground(new Color(244, 210, 201));
		add(btnBack);
		
		Menu menu = new Menu();
		menu.setBounds(104, 10, 140, 140);
		String filePath = "./" + MenuMain.menuname;
		menu.getLblMenuImage().setIcon(new ImageIcon(filePath));
		menu.getLblMenuName().setText(MenuMain.menuname);
		add(menu);
		
	}
	
	public void insertToOrder() {
		DaoDetail dao = new DaoDetail(hotice,quantity,syrup,shot,water);
		dao.insertToOrder();
	}
}
