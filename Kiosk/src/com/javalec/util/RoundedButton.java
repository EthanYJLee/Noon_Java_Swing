package com.javalec.util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class RoundedButton extends JButton {

	public RoundedButton() {
		super();
		decorate();
	}

	public RoundedButton(String text) {
		super(text);
		decorate();
	}

	public RoundedButton(Action action) {
		super(action);
		decorate();
	}

	public RoundedButton(Icon icon) {
		super(icon);
		decorate();
	}

	public RoundedButton(String text, Icon icon) {
		super(text, icon);
		decorate();
	}

	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
	    int width = getWidth();
	    int height = getHeight();

	    Graphics2D graphics = (Graphics2D) g;

	    graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	    if (getModel().isArmed()) {
	        graphics.setColor(new Color(255,0,0,0));
	    } else if (getModel().isRollover()) {
	    	graphics.setColor(new Color(255,0,0,0));
	    } else {
	    	graphics.setColor(new Color(255,0,0,0));
	    }
	    graphics.fillRoundRect(0, 0, width, height, 15, 15);
	    super.paintComponent(g);
	}
}
