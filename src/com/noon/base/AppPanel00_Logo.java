package com.noon.base;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class AppPanel00_Logo extends JPanel {
	private JLabel lblLogo;

	// 바탕화면 그라데이션 -------------------------------------------------------------------------------
	@Override
	protected void paintChildren(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint g3 = new GradientPaint(0, 0, Color.decode("#F4D2C9"), 0, getHeight(), Color.decode("#FAF3E0"));
		g2.setPaint(g3);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
		super.paintChildren(g);
	}
	// ----------------------------------------------------------------------------------------------
	
	/**
	 * Create the panel.
	 */
	public AppPanel00_Logo() {
		setBounds(0, 0, 375, 812);
		setOpaque(true);
		setLayout(null);
		add(getLblLogo());
		
	}

	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/logo.png"));
			lblLogo.setBounds(87, 208, 200, 200);
		}
		return lblLogo;
	}
	
	
} // End