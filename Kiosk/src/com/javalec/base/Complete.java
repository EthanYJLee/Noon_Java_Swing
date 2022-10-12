package com.javalec.base;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.javalec.util.GradientBack;
import com.javalec.util.RoundedButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class Complete extends GradientBack {

	public Complete() {
		setLayout(null);
		setBounds(0, 0, 350, 700);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Complete.class.getResource("/com/javalec/image/Rectangle 32.png")));
		lblNewLabel.setBounds(0, 466, 350, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(Complete.class.getResource("/com/javalec/image/billyesorno.png")));
		lblNewLabel_1.setBounds(0, 491, 350, 30);
		add(lblNewLabel_1);
		
		RoundedButton btnYes = new RoundedButton("");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Frame.frame.getContentPane().add(new Ad());
			}
		});
		btnYes.setIcon(new ImageIcon(Complete.class.getResource("/com/javalec/image/Group 6886.png")));
		btnYes.setBounds(100, 621, 150, 69);
		btnYes.setBackground(new Color(255, 0, 0, 0));
		add(btnYes);
		
		RoundedButton btnNo = new RoundedButton("");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Frame.frame.getContentPane().add(new Ad());
			}
		});
		btnNo.setIcon(new ImageIcon(Complete.class.getResource("/com/javalec/image/Group 6923.png")));
		btnNo.setBounds(10, 531, 328, 80);
		btnNo.setBackground(new Color(255, 0, 0, 0));
		add(btnNo);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(Complete.class.getResource("/com/javalec/image/Ellipse 2.png")));
		lblNewLabel_2.setBounds(75, 150, 200, 200);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon(Complete.class.getResource("/com/javalec/image/paymentComplete.png")));
		lblNewLabel_3.setBounds(12, 41, 326, 50);
		add(lblNewLabel_3);
		

	}
}
