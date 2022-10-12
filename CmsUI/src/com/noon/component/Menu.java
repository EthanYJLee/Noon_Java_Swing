package com.noon.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Menu extends JPanel {

	private JLabel lblMenuImage;
	private JLabel lblMenuName;
	private int numOfOne;

	public int getNumOfOne() {
		return numOfOne;
	}

	public void setNumOfOne(int numOfOne) {
		this.numOfOne = numOfOne;
	}

	public JLabel getLblMenuImage() {
		return lblMenuImage;
	}

	public void setLblMenuImage(JLabel lblMenuImage) {
		this.lblMenuImage = lblMenuImage;
	}

	public JLabel getLblMenuName() {
		return lblMenuName;
	}

	public void setLblMenuName(JLabel lblMenuName) {
		this.lblMenuName = lblMenuName;
	}

	public Menu() {
		setBackground(Color.WHITE);
		setBorder(new LineBorder(Color.DARK_GRAY));
		setLayout(null);

		lblMenuImage = new JLabel();
		lblMenuImage.setBackground(new Color(253, 255, 248));
		lblMenuImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuImage.setBounds(10, 0, 90, 90);
		add(lblMenuImage);

		lblMenuName = new JLabel("Menu name");
		lblMenuName.setBounds(10, 90, 90, 20);
		add(lblMenuName);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);

		super.paintComponent(g);
	}
}
