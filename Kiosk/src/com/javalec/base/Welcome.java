package com.javalec.base;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import com.javalec.util.GradientBack;
import com.javalec.util.RoundedButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Welcome extends GradientBack {

	public static String forHereToGo = null;
	int countCoffee;

	public Welcome() {
		setLayout(null);
		setVisible(true);
		setBackground(new Color(244, 210, 201));
		setBounds(0, 0, 350, 700);

		JLabel label = new JLabel("오늘 준비된 커피가 " + countCoffee + " 잔 남았습니다.");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(12, 84, 326, 36);
		add(label);

		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon(Welcome.class.getResource("/com/javalec/image/Group 6888 (2) (1).png")));
		lblLogo.setBounds(69, 165, 200, 200);
		add(lblLogo);

		RoundedButton btnForHere = new RoundedButton("");
		btnForHere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				forHereToGo = "forhere";
				setVisible(false);
				Frame.frame.getContentPane().add(new MenuMain());
			}
		});
		btnForHere.setBackground(new Color(244, 210, 201));
		btnForHere.setIcon(new ImageIcon(Welcome.class.getResource("/com/javalec/image/Group 6902.png")));
		btnForHere.setBounds(43, 449, 125, 70);
		add(btnForHere);

		RoundedButton btnToGo = new RoundedButton("");
		btnToGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				forHereToGo = "togo";
				setVisible(false);
				Frame.frame.getContentPane().add(new MenuMain());
			}
		});
		btnToGo.setBackground(new Color(244, 210, 201));
		btnToGo.setIcon(new ImageIcon(Welcome.class.getResource("/com/javalec/image/Group 6903.png")));
		btnToGo.setBounds(173, 449, 125, 70);
		add(btnToGo);
		
		String a = LogIn.myBranch;
		JLabel lblMyBranch = new JLabel("카페 눈 " + a);
		lblMyBranch.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMyBranch.setBounds(173, 10, 165, 28);
		add(lblMyBranch);
		
		
		


	}

}
