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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.noon.dao.DaoMember;
import javax.swing.JPasswordField;

public class Panel01Login extends JPanel {
	
	private JLabel lblLogo;
	private JLabel lblNewLabel;
	private JTextField tfId;
	private JLabel lblNewLabel2;
	private JLabel lblBtnLogin;
	private JLabel lblBtnSignup;
	private JLabel lblBtnIDSearch;
	private JLabel lblBtnPasswordSearch;
	
	// 선언부
	public static String id = null;
	private JPasswordField pfPw;
	
	
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
		add(getTfId());
		add(getLblNewLabel2());
		add(getLblBtnLogin());
		add(getLblBtnSignup());
		add(getLblBtnIDSearch());
		add(getLblBtnPasswordSearch());
		add(getPfPw());

	}

	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setIcon(new ImageIcon("./src/com/noon/app/logo.png"));
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
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setBackground(new Color(176, 108, 89));
			tfId.setBounds(141, 359, 146, 36);
			tfId.setColumns(10);
		}
		return tfId;
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
	private JLabel getLblBtnLogin() {
		if (lblBtnLogin == null) {
			lblBtnLogin = new JLabel("");
			lblBtnLogin.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					loginAction();
				}
				@Override
				public void mousePressed(MouseEvent e) {
					lblBtnLogin.setIcon(new ImageIcon("./src/com/noon/app/btn_login_C.png"));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblBtnLogin.setIcon(new ImageIcon("./src/com/noon/app/btn_login.png"));
				}
			});
			lblBtnLogin.setIcon(new ImageIcon("./src/com/noon/app/btn_login.png"));
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
				@Override
				public void mousePressed(MouseEvent e) {
					lblBtnSignup.setIcon(new ImageIcon("./src/com/noon/app/btn_signup_C.png"));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblBtnSignup.setIcon(new ImageIcon("./src/com/noon/app/btn_signup.png"));
				}
			});
			lblBtnSignup.setIcon(new ImageIcon("./src/com/noon/app/btn_signup.png"));
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
	
	// Function
	
	private void loginAction(){
		
		char[] pw = pfPw.getPassword();
		String pw1String = new String(pw); // char[] -> String 변환
		pw1String = pw1String.replaceAll(" ", "");
		
		DaoMember daoMember = new DaoMember(tfId.getText().trim(), pw1String.trim());
		if(daoMember.checkId() == 1) {
			id = tfId.getText().trim();
			setVisible(false);
			Main.frame.getContentPane().add(new Panel03Home());
		}else {
			JOptionPane.showMessageDialog(null, "정보를 확인해주세요.", "로그인 안내", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	private JPasswordField getPfPw() {
		if (pfPw == null) {
			pfPw = new JPasswordField();
			pfPw.setBackground(new Color(176, 107, 89));
			pfPw.setBounds(141, 418, 203, 36);
		}
		return pfPw;
	}
} // End
