package com.noon.component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.border.LineBorder;

public class Menu extends JPanel {

	
	public Menu(ImageIcon icon) {
		setBackground(Color.WHITE);
		setBorder(new LineBorder(Color.DARK_GRAY));
		setLayout(null);
		
		JLabel lblMenuImage = new JLabel();
		lblMenuImage.setBackground(new Color(253, 255, 248));
		lblMenuImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuImage.setBounds(0, 0, 90, 90);
		add(lblMenuImage);
		
		
		lblMenuImage.setIcon(icon);
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillRoundRect(0,0, getWidth(), getHeight(), 10, 10);
        
        super.paintComponent(g); 
    }

}
