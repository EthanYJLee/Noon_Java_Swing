package com.noon.base;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Panel01Login extends JPanel {
	
	private JLabel lblLogo;
	private JLabel lblNewLabel;
	private JTextField tfID;
	private JLabel lblNewLabel2;
	private JTextField tfPassword;
	private JLabel lblBtnLogin;
	private JLabel lblBtnSignup;
	private JLabel lblBtnIDSearch;
	private JLabel lblBtnPasswordSearch;
	
	
	// 바탕화면 그라데이션 -------------------------------------------------------------------------------
		@Override
		protected void paintChildren(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			GradientPaint g3 = new GradientPaint(0, 0, Color.decode("#F4D2C9"), 0, getHeight(), Color.decode("#FAF3E0"));
			g2.setPaint(g3);
			g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
			super.paintChildren(g);
		}
		// ----------------------------------------------------------------------------------------------

	/**
	 * Create the panel.
	 */
	public Panel01Login() {
		setBounds(0, 0, 375, 812);
		setOpaque(true);
		setLayout(null);
		
		
		add(getLblLogo());
		add(getLblNewLabel());
		add(getTfID());
		add(getLblNewLabel2());
		add(getTfPassword());
		add(getLblBtnLogin());
		add(getLblBtnSignup());
		add(getLblBtnIDSearch());
		add(getLblBtnPasswordSearch());

	}

	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/logo.png"));
			lblLogo.setBounds(101, 126, 172, 172);
		}
		return lblLogo;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("ID");
			lblNewLabel.setForeground(new Color(176, 108, 89));
			lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
			lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel.setBounds(68, 364, 61, 25);
		}
		return lblNewLabel;
	}
	private JTextField getTfID() {
		if (tfID == null) {
			tfID = new JTextField();
			tfID.setBackground(new Color(176, 108, 89));
			tfID.setBounds(141, 359, 146, 36);
			tfID.setColumns(10);
		}
		return tfID;
	}
	private JLabel getLblNewLabel2() {
		if (lblNewLabel2 == null) {
			lblNewLabel2 = new JLabel("Password");
			lblNewLabel2.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel2.setForeground(new Color(176, 108, 89));
			lblNewLabel2.setFont(new Font("SansSerif", Font.BOLD, 20));
			lblNewLabel2.setBounds(6, 423, 123, 25);
		}
		return lblNewLabel2;
	}
	private JTextField getTfPassword() {
		if (tfPassword == null) {
			tfPassword = new JTextField();
			tfPassword.setColumns(10);
			tfPassword.setBackground(new Color(176, 108, 89));
			tfPassword.setBounds(141, 418, 203, 36);
		}
		return tfPassword;
	}
	private JLabel getLblBtnLogin() {
		if (lblBtnLogin == null) {
			lblBtnLogin = new JLabel("");
			lblBtnLogin.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					Main.frame.getContentPane().add(new Panel05Order01Shop());
				}
			});
			lblBtnLogin.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_login.png"));
			lblBtnLogin.setBounds(100, 522, 174, 49);
		}
		return lblBtnLogin;
	}
	private JLabel getLblBtnSignup() {
		if (lblBtnSignup == null) {
			lblBtnSignup = new JLabel("");
			lblBtnSignup.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					Main.frame.getContentPane().add(new Panel02SignUp());
				}
			});
			lblBtnSignup.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_signup.png"));
			lblBtnSignup.setBounds(101, 595, 174, 49);
		}
		return lblBtnSignup;
	}
	private JLabel getLblBtnIDSearch() {
		if (lblBtnIDSearch == null) {
			lblBtnIDSearch = new JLabel("ID 찾기");
			lblBtnIDSearch.setForeground(new Color(176, 108, 89));
			lblBtnIDSearch.setFont(new Font("SansSerif", Font.PLAIN, 14));
			lblBtnIDSearch.setHorizontalAlignment(SwingConstants.CENTER);
			lblBtnIDSearch.setBounds(86, 710, 61, 16);
		}
		return lblBtnIDSearch;
	}
	private JLabel getLblBtnPasswordSearch() {
		if (lblBtnPasswordSearch == null) {
			lblBtnPasswordSearch = new JLabel("Password 찾기");
			lblBtnPasswordSearch.setHorizontalAlignment(SwingConstants.CENTER);
			lblBtnPasswordSearch.setForeground(new Color(176, 108, 89));
			lblBtnPasswordSearch.setFont(new Font("SansSerif", Font.PLAIN, 14));
			lblBtnPasswordSearch.setBounds(194, 710, 93, 16);
		}
		return lblBtnPasswordSearch;
	}
}
