package com.javalec.base;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.javalec.util.ImagePanel;
import java.awt.Toolkit;
import java.awt.Color;

public class Ad extends JPanel {
	private ImagePanel pnMiddle = new ImagePanel(Toolkit.getDefaultToolkit().getImage(Ad.class.getResource("/com/javalec/image/Group 6927.png")));
	
     
	
	public Ad() {
		setLayout(null);
		setLocation(0, 0);
		setBounds(0, 0, 350, 700);
		pnMiddle.setBackground(new Color(255, 255, 255));
		
		pnMiddle.setBounds(0, 0, 350, 700);
		pnMiddle.setLayout(null);
		add(pnMiddle);

		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Frame.frame.getContentPane().add(new Welcome());
			}
		});
		
		
	}
}
