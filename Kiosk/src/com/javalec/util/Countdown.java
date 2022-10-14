//package com.javalec.util;
//
//import static java.util.concurrent.TimeUnit.SECONDS;
//
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//
//public class Countdown extends JLabel {
//	public Countdown() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public static void main(String[] args) {
//
//		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//
//		final Runnable runnable = new Runnable() {
//			int countdownStarter = 10;
//
//			public void run() {
//				for (int i = countdownStarter; i > 0; i--) {
//					JOptionPane.showMessageDialog(null, "선택이 없을 시" + i + "초 후에 메인으로 돌아갑니다.");
//
//					if (countdownStarter == 0) {
//						scheduler.shutdown();
//
//					}
//				}
//			}
//		};
//		scheduler.scheduleAtFixedRate(runnable, 3, 1, SECONDS);
//	}
//}
