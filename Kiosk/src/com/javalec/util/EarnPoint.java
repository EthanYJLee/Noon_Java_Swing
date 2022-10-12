package com.javalec.util;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;

public class EarnPoint extends JPanel implements ActionListener {
	public JTextField panelDisplay = new JTextField();
	public JPanel panelKey = new JPanel();

	public static void main(String[] args) {
		new EarnPoint();
	}

	public EarnPoint() {
//		setLayout(new BorderLayout());
		setLayout(null);
//		add(panelDisplay, BorderLayout.NORTH);
		add(panelDisplay);
//		add(panelKey, BorderLayout.CENTER);
		add(panelKey);
		JButton[] bt = new JButton[12];

		panelKey.setLayout(new GridLayout(4, 3, 10, 10));
		bt[0] = new JButton("7");
		bt[1] = new JButton("8");
		bt[2] = new JButton("9");
		bt[3] = new JButton("4");
		bt[4] = new JButton("5");
		bt[5] = new JButton("6");
		bt[6] = new JButton("1");
		bt[7] = new JButton("2");
		bt[8] = new JButton("3");
		bt[9] = new JButton("Clear");
		bt[10] = new JButton("0");
		bt[11] = new JButton("지우기");

		for (int i = 0; i <= 11; i++) {
			panelKey.add(bt[i]);
			bt[i].setBorderPainted(true);
			bt[i].setOpaque(true);
			bt[i].addActionListener(this);
			

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("지우기")) {
			int a = panelDisplay.getText().length();
			String b = panelDisplay.getText().substring(0, a - 1);
			panelDisplay.setText(b);
		} else if (actionCommand.equals("Clear")){
			String c = panelDisplay.getText().substring(0, 0);
			panelDisplay.setText(c);
		} else {
			panelDisplay.setText(panelDisplay.getText() + actionCommand);
		}
		if (panelDisplay.getText().length() > 11) {
			JOptionPane.showMessageDialog(panelDisplay, "번호 자릿수를 확인해주십시오.");
		}
	}

}
