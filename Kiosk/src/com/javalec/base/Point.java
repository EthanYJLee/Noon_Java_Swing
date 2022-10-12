package com.javalec.base;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import com.javalec.util.EarnPoint;
import com.javalec.util.RoundedButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

	public class Point extends JPanel {
		JPanel panel = new JPanel();
		EarnPoint keypad = new EarnPoint();
		
		public Point() {
			setLayout(null);
			setBackground(new Color(244, 210, 201));
			
			panel.setLayout(null);
			panel.setBackground(new Color(255, 255, 255));
			panel.setBounds(0, 155, 350, 545);
			add(panel);
			keypad.panelKey.setBorder(new MatteBorder(10, 10, 10, 10, (Color) new Color(255, 255, 255)));
			keypad.panelDisplay.setBackground(new Color(244, 210, 201));
			keypad.panelDisplay.setSize(300, 47);
			keypad.panelKey.setSize(278, 312);
			keypad.panelKey.setLocation(10, 57);
			keypad.panelDisplay.setLocation(0, 0);
			keypad.panelDisplay.setFont(new Font("굴림", Font.PLAIN, 20));
			keypad.panelKey.setBackground(new Color(255, 255, 255));
			keypad.setBackground(new Color(255, 255, 255));
			
			keypad.setBounds(25,10,300,379);
			
			RoundedButton btnNewButton_1 = new RoundedButton("");
			btnNewButton_1.setBackground(new Color(255, 255, 255));
			btnNewButton_1.setIcon(new ImageIcon(Point.class.getResource("/com/javalec/image/Group 6922.png")));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					Frame.frame.getContentPane().add(new Complete());
				}
			});
			btnNewButton_1.setBounds(12, 399, 326, 65);
			panel.add(btnNewButton_1);
			
			RoundedButton btnNewButton_1_1 = new RoundedButton("");
			btnNewButton_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					Frame.frame.getContentPane().add(new Complete());
				}
			});
			btnNewButton_1_1.setBackground(new Color(255, 255, 255));
			btnNewButton_1_1.setIcon(new ImageIcon(Point.class.getResource("/com/javalec/image/Group 6921-1.png")));
			btnNewButton_1_1.setBounds(12, 470, 326, 65);
			panel.add(btnNewButton_1_1);
			
			panel.add(keypad);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setIcon(new ImageIcon(Point.class.getResource("/com/javalec/image/pointMessage.png")));
			lblNewLabel.setBounds(12, 85, 326, 60);
			add(lblNewLabel);
		}
	}

