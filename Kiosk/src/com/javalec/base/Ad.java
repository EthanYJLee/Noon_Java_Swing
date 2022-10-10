package com.javalec.base;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Ad extends JPanel {
	
	public Ad() {
		setLayout(null);
		setLocation(0, 0);
		setBounds(0, 0, 350, 700);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Frame.frame.getContentPane().add(new Welcome());
			}
		});
		
		JLabel lblNewLabel = new JLabel("광고 대기중입니다");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 267, 326, 15);
		add(lblNewLabel);
	}
}
