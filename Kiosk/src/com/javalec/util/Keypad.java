package com.javalec.util;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Keypad extends JPanel {

	public void Keypad() {
//		JPanel keypad = new JPanel();
//		keypad.setLayout(new GridLayout(4, 3));
//		keypad.setBackground(Color.gray);
//		JButton blank = new JButton("");
//		JButton zero = new JButton("0");
//		JButton one = new JButton("1");
//		JButton two = new JButton("2");
//		JButton three = new JButton("3");
//		JButton four = new JButton("4");
//		JButton five = new JButton("5");
//		JButton six = new JButton("6");
//		JButton seven = new JButton("7");
//		JButton eight = new JButton("8");
//		JButton nine = new JButton("9");
//		JButton clear = new JButton("clear");
//		keypad.add(seven);
//		keypad.add(eight);
//		keypad.add(nine);
//		keypad.add(four);
//		keypad.add(five);
//		keypad.add(six);
//		keypad.add(one);
//		keypad.add(three);
//		keypad.add(blank);
//		keypad.add(zero);
//		keypad.add(clear);

		final JPanel keypad = new JPanel();
        keypad.setLayout(new GridLayout(4,3));
        final String[] digit = {"7","8","9","4","5","6","1","2","3","","0","clear"};
        for (int i = 0; i < digit.length; i++) {
        	keypad.add(new JButton(digit[i]));
        }
		
	}
}