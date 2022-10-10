package com.javalec.base;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.javalec.util.RoundedButton;
import javax.swing.JRadioButton;

public class Detail extends JPanel {

	public Detail() {
		setLayout(null);
		setBackground(new Color(244, 210, 201));
		setSize(350, 700);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 155, 350, 545);
		panel.setBackground(new Color(255, 255, 255));
		add(panel);
		panel.setLayout(null);
		
		RoundedButton btnCancelAll = new RoundedButton("");
		btnCancelAll.setBackground(new Color(255, 255, 255));
		btnCancelAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelAll.setIcon(new ImageIcon(Detail.class.getResource("/com/javalec/image/Group 69181.png")));
		btnCancelAll.setBounds(12, 399, 326, 65);
		panel.add(btnCancelAll);
		
		RoundedButton btnAddToCart = new RoundedButton("");
		btnAddToCart.setBackground(new Color(255, 255, 255));
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Frame.frame.getContentPane().add(new Cart());
			}
		});
		btnAddToCart.setIcon(new ImageIcon(Detail.class.getResource("/com/javalec/image/Group 69191.png")));
		btnAddToCart.setBounds(12, 470, 326, 65);
		panel.add(btnAddToCart);
		
		RoundedButton water1 = new RoundedButton();
		water1.setBackground(new Color(255, 255, 255));
		water1.setBounds(12, 115, 100, 40);
		panel.add(water1);
		water1.setIcon(new ImageIcon(Detail.class.getResource("/com/javalec/image/btn_size_tall.png")));
		RoundedButton water2 = new RoundedButton();
		water2.setBackground(new Color(255, 255, 255));
		water2.setBounds(124, 115, 100, 40);
		panel.add(water2);
		water2.setIcon(new ImageIcon(Detail.class.getResource("/com/javalec/image/btn_size_grande.png")));
		RoundedButton water3 = new RoundedButton();
		water3.setBackground(new Color(255, 255, 255));
		water3.setBounds(238, 115, 100, 40);
		panel.add(water3);
		water3.setIcon(new ImageIcon(Detail.class.getResource("/com/javalec/image/btn_size_regular.png")));
		
		RoundedButton shot0 = new RoundedButton();
		shot0.setBackground(new Color(255, 255, 255));
		shot0.setBounds(12, 184, 80, 60);
		panel.add(shot0);
		shot0.setIcon(new ImageIcon(Detail.class.getResource("/com/javalec/image/btn_shot_basic.png")));
		RoundedButton shot1 = new RoundedButton();
		shot1.setBackground(new Color(255, 255, 255));
		shot1.setBounds(95, 184, 80, 60);
		panel.add(shot1);
		shot1.setIcon(new ImageIcon(Detail.class.getResource("/com/javalec/image/btn_shot_plus1.png")));
		RoundedButton shot2 = new RoundedButton();
		shot2.setBackground(new Color(255, 255, 255));
		shot2.setBounds(176, 184, 80, 60);
		panel.add(shot2);
		shot2.setIcon(new ImageIcon(Detail.class.getResource("/com/javalec/image/btn_shot_plus2.png")));
		RoundedButton shot3 = new RoundedButton();
		shot3.setBackground(new Color(255, 255, 255));
		shot3.setBounds(258, 184, 80, 60);
		panel.add(shot3);
		shot3.setIcon(new ImageIcon(Detail.class.getResource("/com/javalec/image/btn_shot_plus3.png")));
		
 		
		RoundedButton noSyrup = new RoundedButton();
		noSyrup.setBackground(new Color(255, 255, 255));
		noSyrup.setBounds(12, 268, 105, 60);
		panel.add(noSyrup);
		noSyrup.setIcon(new ImageIcon(Detail.class.getResource("/com/javalec/image/btn_syrup_basic1.png")));
		RoundedButton hazelnutSyrup = new RoundedButton();
		hazelnutSyrup.setBackground(new Color(255, 255, 255));
		hazelnutSyrup.setBounds(122, 268, 105, 60);
		panel.add(hazelnutSyrup);
		hazelnutSyrup.setIcon(new ImageIcon(Detail.class.getResource("/com/javalec/image/btn_syrup_hazelnut.png")));
		RoundedButton vanillaSyrup = new RoundedButton();
		vanillaSyrup.setBackground(new Color(255, 255, 255));
		vanillaSyrup.setBounds(233, 268, 105, 60);
		panel.add(vanillaSyrup);
		vanillaSyrup.setIcon(new ImageIcon(Detail.class.getResource("/com/javalec/image/btn_syrup_vanila1.png")));
		
		
		RoundedButton hot = new RoundedButton();
		hot.setBackground(new Color(255, 255, 255));
		hot.setBounds(208, 24, 85, 45);
		panel.add(hot);
		hot.setIcon(new ImageIcon(Detail.class.getResource("/com/javalec/image/btn_hot1.png")));
		RoundedButton ice = new RoundedButton();
		ice.setBackground(new Color(255, 255, 255));
		ice.setBounds(50, 24, 85, 45);
		panel.add(ice);
		ice.setIcon(new ImageIcon(Detail.class.getResource("/com/javalec/image/btn_ice1.png")));
		
		JLabel lblNewLabel = new JLabel("물 양");
		lblNewLabel.setBounds(12, 94, 152, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("샷 추가");
		lblNewLabel_1.setBounds(12, 170, 152, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("시럽 추가");
		lblNewLabel_2.setBounds(12, 249, 152, 15);
		panel.add(lblNewLabel_2);
		
		RoundedButton btnBack = new RoundedButton("");
		btnBack.setIcon(new ImageIcon(Detail.class.getResource("/com/javalec/image/Vector.png")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Frame.frame.getContentPane().add(new MenuMain());
			}
		});
		btnBack.setBackground(new Color(244, 210, 201));
		btnBack.setBounds(12, 10, 33, 36);
		add(btnBack);
		
		
		

	}
}
