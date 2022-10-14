package com.javalec.base;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Ad extends JPanel {
	
	public Ad() {
		setLayout(null);
		setLocation(0, 0);
		setBounds(0, 0, 350, 700);
		setBackground(new Color(192, 192, 192));
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Frame.frame.getContentPane().add(new Welcome());
			}
		});
		
		String a = LogIn.myBranch;
		JLabel lblMyBranch = new JLabel("카페 눈 " + a);
		lblMyBranch.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMyBranch.setBounds(173, 10, 165, 28);
		add(lblMyBranch);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Ad.class.getResource("/com/javalec/image/Ad1.jpg")));
		lblNewLabel.setBounds(0, 0, 350, 700);
		add(lblNewLabel);
		
	}
}
