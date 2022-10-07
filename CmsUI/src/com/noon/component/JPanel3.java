package com.noon.component;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JToggleButton;
import javax.swing.JScrollPane;

public class JPanel3 extends JPanel {
	private JButton btnNewButton;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public JPanel3() {
		setLayout(null);
		add(getBtnNewButton());
		add(getScrollPane());

	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.setIcon(new ImageIcon("/Users/bigdata/Downloads/메뉴 추갛가ㅣ.png"));
			btnNewButton.setBounds(597, 56, 117, 29);
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(73, 121, 630, 354);
		}
		return scrollPane;
	}
}
