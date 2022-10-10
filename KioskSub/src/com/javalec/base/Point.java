package com.javalec.base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.javalec.util.Keypad;

	public class Point extends JPanel {
		JPanel panel = new JPanel();
		JPanel earnPoint = new JPanel();
		JPanel panelKeypad = new JPanel();
		JPanel panelDisplay = new JPanel();
		JLabel lblDisplay = new JLabel();
		
		public Point() {
			setLayout(new BorderLayout(0, 0));
			setBackground(new Color(244, 210, 201));
			
			setLayout(null);
			panel.setBackground(new Color(255, 255, 255));
			panel.setBounds(0, 155, 350, 545);
			add(panel);
			panel.setLayout(null);
			
			JButton btnNewButton_1 = new JButton("");
			btnNewButton_1.setIcon(new ImageIcon(Point.class.getResource("/com/javalec/image/Group 6877.png")));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton_1.setBounds(12, 417, 326, 50);
			panel.add(btnNewButton_1);
			
			JButton btnNewButton_1_1 = new JButton("");
			btnNewButton_1_1.setIcon(new ImageIcon(Point.class.getResource("/com/javalec/image/Group 6878.png")));
			btnNewButton_1_1.setBounds(12, 485, 326, 50);
			panel.add(btnNewButton_1_1);
			
			// --------------------------------------------------------------------
	        String[] digit = {"7","8","9","4","5","6","1","2","3","","0","clear"};
	        for (int i = 0; i < digit.length; i++) {
	        	panelKeypad.add(new JButton());
	        }
			panelDisplay.add(lblDisplay);
			
			earnPoint.setLocation(12, 10);
			earnPoint.setSize(326, 397);
			panel.add(earnPoint);
			
			earnPoint.setLayout(new BorderLayout());
			earnPoint.add(panelDisplay, BorderLayout.NORTH);
			earnPoint.add(panelKeypad, BorderLayout.CENTER);
			
		}
		
	}

