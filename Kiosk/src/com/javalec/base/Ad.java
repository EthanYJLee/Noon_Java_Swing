package com.javalec.base;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class Ad extends JPanel {
	
	public Ad() {
		setLayout(null);
		setLocation(0, 0);
		setBounds(0, 0, 350, 700);
		setBackground(new Color(192, 192, 192));
		
		JLabel advertisement = new JLabel("광고");
		advertisement.setFont(new Font("굴림", Font.PLAIN, 38));
		advertisement.setBounds(130, 211, 76, 141);
		add(advertisement);
		
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
		
	}
}
