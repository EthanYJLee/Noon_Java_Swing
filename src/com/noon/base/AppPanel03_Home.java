package com.noon.base;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class AppPanel03_Home extends JPanel {
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public AppPanel03_Home() {
		setLayout(null);
		add(getLblNewLabel());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("New label");
			lblNewLabel.setBounds(68, 245, 61, 16);
		}
		return lblNewLabel;
	}
}
