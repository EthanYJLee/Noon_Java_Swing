package com.noon.base;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;

public class AppMain {

	public static JFrame frame;
	
//	private AppPanel00_Logo appPanel00_Logo = new AppPanel00_Logo();
	public AppPanel03_Home appPanel03_Home = new AppPanel03_Home();
	public AppPanel05_Order01Shop appPanel05_Order01Shop = new AppPanel05_Order01Shop();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain window = new AppMain();
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
	public AppMain() {
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
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
//		frame.add(appPanel03_Home);
		frame.add(appPanel05_Order01Shop);
//		frame.add(appPanel00_Logo);
		
	}
	
} // End

