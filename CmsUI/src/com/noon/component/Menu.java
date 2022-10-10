package com.noon.component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Menu extends JPanel {

	
	public Menu(ImageIcon icon) {
		setLayout(null);
		
		JLabel lblMenuImage = new JLabel();
		lblMenuImage.setBackground(new Color(253, 255, 248));
		lblMenuImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuImage.setBounds(0, 0, 90, 90);
		add(lblMenuImage);
		
		
		lblMenuImage.setIcon(icon);
	}

}
