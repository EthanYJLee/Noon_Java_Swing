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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Panel03Home extends JPanel {
	
	private JLabel lblNewLabel_01;
	private JButton lblBtnTabOrder;
	private JButton lblBtnTabMypage;
	private JLabel lblHomeIndicator;
	private JButton lblBtnTabHome;
	private JButton lblBtnTabGift;
	private JLabel lblBtnSidebar;
	private JLabel lblBtnBack;
	private JLabel lblProfilePhoto;
	private JLabel lblNewLabel;

	// 바탕화면 그라데이션 ---------------------------------------------------------------------------------------------
	@Override
	protected void paintChildren(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint g3 = new GradientPaint(0, 0, Color.decode("#F4D2C9"), 0, getHeight(), Color.decode("#FAF3E0"));
		g2.setPaint(g3);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
		super.paintChildren(g);
	}
	// ------------------------------------------------------------------------------------------------------------
	
	/**
	 * Create the panel.
	 */
	public Panel03Home() {
		// DefaultSetting ---------
		setBounds(0, 0, 375, 812);
		setOpaque(true);
		setLayout(null);
		add(getLblBtnSidebar());
		add(getLblBtnBack());
		add(getLblNewLabel_01());
		add(getLblProfilePhoto());
		add(getLblBtnTabHome());
		add(getLblBtnTabOrder());
		add(getLblBtnTabGift());
		add(getLblBtnTabMypage());
		add(getLblHomeIndicator());
		add(getLblNewLabel());
	}
	
	// 상단바 =============================================================================================================
	private JLabel getLblBtnSidebar() {
		if (lblBtnSidebar == null) {
			lblBtnSidebar = new JLabel("");
			lblBtnSidebar.setHorizontalAlignment(SwingConstants.CENTER);
			lblBtnSidebar.setIcon(new ImageIcon("./src/com/noon/app/icon_sidebar.png"));
			lblBtnSidebar.setBounds(13, 26, 36, 32);
		}
		return lblBtnSidebar;
	}
	private JLabel getLblBtnBack() {
		if (lblBtnBack == null) {
			lblBtnBack = new JLabel("");
			lblBtnBack.setHorizontalAlignment(SwingConstants.CENTER);
			lblBtnBack.setIcon(new ImageIcon("./src/com/noon/app/icon_back.png"));
			lblBtnBack.setBounds(51, 26, 32, 32);
		}
		return lblBtnBack;
	}
	private JLabel getLblNewLabel_01() {
		if (lblNewLabel_01 == null) {
			lblNewLabel_01 = new JLabel("Home");
			lblNewLabel_01.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_01.setForeground(new Color(176, 108, 89));
			lblNewLabel_01.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
			lblNewLabel_01.setBounds(131, 26, 115, 37);
		}
		return lblNewLabel_01;
	}
	private JLabel getLblProfilePhoto() {
		if (lblProfilePhoto == null) {
			lblProfilePhoto = new JLabel("");
			lblProfilePhoto.setHorizontalAlignment(SwingConstants.TRAILING);
			lblProfilePhoto.setIcon(new ImageIcon("./src/com/noon/app/profile_photo.png"));
			lblProfilePhoto.setBounds(322, 26, 36, 36);
		}
		return lblProfilePhoto;
	}
	// ==================================================================================================================

	// Tabbar ===========================================================================================================
	private JButton getLblBtnTabHome() {
		if (lblBtnTabHome == null) {
			lblBtnTabHome = new JButton("");
			lblBtnTabHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					Main.frame.getContentPane().add(new Panel03Home());
				}
			});
			lblBtnTabHome.setIcon(new ImageIcon("./src/com/noon/app/tabbar_home.png"));
			lblBtnTabHome.setBounds(1, 729, 94, 50);
		}
		return lblBtnTabHome;
	}
	private JButton getLblBtnTabOrder() {
		if (lblBtnTabOrder == null) {
			lblBtnTabOrder = new JButton("");
			lblBtnTabOrder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					Main.frame.getContentPane().add(new Panel05Order01Shop());
				}
			});
			lblBtnTabOrder.setIcon(new ImageIcon("./src/com/noon/app/tabbar_order.png"));
			lblBtnTabOrder.setBounds(94, 729, 94, 50);
		}
		return lblBtnTabOrder;
	}
	private JButton getLblBtnTabGift() {
		if (lblBtnTabGift == null) {
			lblBtnTabGift = new JButton("");
			lblBtnTabGift.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					Main.frame.getContentPane().add(new Panel06Gift());
				}
			});
			lblBtnTabGift.setIcon(new ImageIcon("./src/com/noon/app/tabbar_gift.png"));
			lblBtnTabGift.setBounds(187, 729, 94, 50);
		}
		return lblBtnTabGift;
	}
	private JButton getLblBtnTabMypage() {
		if (lblBtnTabMypage == null) {
			lblBtnTabMypage = new JButton("");
			lblBtnTabMypage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					Main.frame.getContentPane().add(new Panel04MyPage());
				}
			});
			lblBtnTabMypage.setIcon(new ImageIcon("./src/com/noon/app/tabbar_mypage.png"));
			lblBtnTabMypage.setBounds(281, 729, 94, 50);
		}
		return lblBtnTabMypage;
	}
	private JLabel getLblHomeIndicator() {
		if (lblHomeIndicator == null) {
			lblHomeIndicator = new JLabel("");
			lblHomeIndicator.setIcon(new ImageIcon("./src/com/noon/app/homeindicator.png"));
			lblHomeIndicator.setBounds(1, 778, 375, 34);
		}
		return lblHomeIndicator;
	}
	
	
	
	
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
			lblNewLabel.setIcon(new ImageIcon("./src/com/noon/app/home_base1.png"));
			lblNewLabel.setBounds(0, 87, 374, 642);
		}
		return lblNewLabel;
	}
} // End