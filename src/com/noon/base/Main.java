package com.noon.base;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class Main {

	public static JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
//		// 앱화면 세팅 --------------------------------------------------------------------------------
		frame.setUndecorated(true); // 1.프레임 창 없애기
//		frame.setShape(new RoundRectangle2D.Double(0, 0, 375, 812, 80, 80)); // 2.프레임 모서리에 라운드 주기
//		frame.setVisible(true); // 3.필수
//		// -----------------------------------------------------------------------------------------
		frame.setBackground(new Color(243, 209, 200));
//		frame.setBackground(Color.decode("#F4D2C9"));
		frame.setBounds(700, 150, 375, 812);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(false);
		frame.add(new Panel01Login());
		
		
	}

}
