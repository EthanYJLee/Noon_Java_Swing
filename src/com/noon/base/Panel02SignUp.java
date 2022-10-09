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

public class Panel02SignUp extends JPanel {
	
	private JTextField textField;
	private JLabel lblNewLabel;
	private JLabel lblBtnIDSearch;
	private JLabel lblLogo;
	private JTextField textField_1;
	private JLabel lblId;
	private JLabel lblNewLabel_2;
	private JLabel lblPassword;
	private JTextField textField_2;
	private JLabel lblPassword_1;
	private JTextField textField_3;
	private JLabel lblBtnSingup;
	private JTextField textField_4;
	private JLabel lblPassword_1_1;
	private JLabel lblNewLabel_1;

	
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
	public Panel02SignUp() {

		setBounds(0, 0, 375, 812);
		setOpaque(true);
		setLayout(null);
		
		add(getTextField());
		add(getLblNewLabel());
		add(getLblBtnIDSearch());
		add(getLblLogo());
		add(getTextField_1());
		add(getLblId());
		add(getLblNewLabel_2());
		add(getLblPassword());
		add(getTextField_2());
		add(getLblPassword_1());
		add(getTextField_3());
		add(getLblBtnSingup());
		add(getTextField_4());
		add(getLblPassword_1_1());
		add(getLblNewLabel_1());

	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBackground(new Color(176, 108, 89));
			textField.setBounds(140, 355, 116, 32);
		}
		return textField;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("이름");
			lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel.setForeground(new Color(176, 108, 89));
			lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
			lblNewLabel.setBounds(74, 359, 61, 25);
		}
		return lblNewLabel;
	}
	private JLabel getLblBtnIDSearch() {
		if (lblBtnIDSearch == null) {
			lblBtnIDSearch = new JLabel("Login 화면으로 돌아가기");
			lblBtnIDSearch.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					Main.frame.getContentPane().add(new Panel01Login());
				}
			});
			lblBtnIDSearch.setHorizontalAlignment(SwingConstants.CENTER);
			lblBtnIDSearch.setForeground(new Color(176, 108, 89));
			lblBtnIDSearch.setFont(new Font("SansSerif", Font.PLAIN, 14));
			lblBtnIDSearch.setBounds(115, 742, 144, 18);
		}
		return lblBtnIDSearch;
	}
	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/logo.png"));
			lblLogo.setBounds(101, 126, 172, 172);
		}
		return lblLogo;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBackground(new Color(176, 108, 89));
			textField_1.setBounds(140, 406, 143, 32);
		}
		return textField_1;
	}
	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID");
			lblId.setHorizontalAlignment(SwingConstants.TRAILING);
			lblId.setForeground(new Color(176, 108, 89));
			lblId.setFont(new Font("SansSerif", Font.PLAIN, 18));
			lblId.setBounds(74, 409, 61, 25);
		}
		return lblId;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("New label");
			lblNewLabel_2.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_ID_overlap.png"));
			lblNewLabel_2.setBounds(280, 410, 66, 25);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
			lblPassword.setForeground(new Color(176, 108, 89));
			lblPassword.setFont(new Font("SansSerif", Font.PLAIN, 18));
			lblPassword.setBounds(19, 461, 116, 25);
		}
		return lblPassword;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBackground(new Color(176, 108, 89));
			textField_2.setBounds(140, 458, 209, 32);
		}
		return textField_2;
	}
	private JLabel getLblPassword_1() {
		if (lblPassword_1 == null) {
			lblPassword_1 = new JLabel("Password확인");
			lblPassword_1.setHorizontalAlignment(SwingConstants.TRAILING);
			lblPassword_1.setForeground(new Color(176, 108, 89));
			lblPassword_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
			lblPassword_1.setBounds(19, 514, 116, 25);
		}
		return lblPassword_1;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBackground(new Color(176, 108, 89));
			textField_3.setBounds(140, 511, 209, 32);
		}
		return textField_3;
	}
	private JLabel getLblBtnSingup() {
		if (lblBtnSingup == null) {
			lblBtnSingup = new JLabel("");
			lblBtnSingup.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					Main.frame.getContentPane().add(new Panel03Home());
					}
				@Override
				public void mousePressed(MouseEvent e) {
					lblBtnSingup.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_signup2_C.png"));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblBtnSingup.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_signup2.png"));
				}
			});
			lblBtnSingup.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_signup2.png"));
			lblBtnSingup.setBounds(100, 662, 174, 49);
		}
		return lblBtnSingup;
	}
	private JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBackground(new Color(176, 108, 89));
			textField_4.setBounds(58, 563, 291, 32);
		}
		return textField_4;
	}
	private JLabel getLblPassword_1_1() {
		if (lblPassword_1_1 == null) {
			lblPassword_1_1 = new JLabel("주소");
			lblPassword_1_1.setForeground(new Color(176, 108, 89));
			lblPassword_1_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
			lblPassword_1_1.setBounds(19, 566, 32, 25);
		}
		return lblPassword_1_1;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("일치하지 않습니다.");
			lblNewLabel_1.setForeground(Color.RED);
			lblNewLabel_1.setBounds(143, 540, 203, 16);
		}
		return lblNewLabel_1;
	}
}
