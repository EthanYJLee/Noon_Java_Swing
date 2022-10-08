package com.noon.base;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AppPanel05_Order04Option extends JPanel {
	
	private AppPanel05_Order05Cart appPanel05_Order05Cart = new AppPanel05_Order05Cart();
	
	private JLabel lblNewLabel_01;
	private JLabel lblBtnTabOrder;
	private JLabel lblBtnTabMypage;
	private JLabel lblHomeIndicator;
	private JLabel lblBtnTabHome;
	private JLabel lblBtnTabGift;
	private JLabel lblBtnSidebar;
	private JLabel lblBtnBack;
	private JLabel lblProfilePhoto;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblBtnHot;
	private JLabel lblBtnIce;
	private JLabel lblBtnWaterLittle;
	private JLabel lblBtnWaterDefault;
	private JLabel lblBtnWaterMore;
	private JLabel lblBtnShot0;
	private JLabel lblBtnShot1;
	private JLabel lblBtnShot2;
	private JLabel lblBtnShot3;
	private JLabel lblBtnSyrupNot;
	private JLabel lblBtnSyrupHazelnut;
	private JLabel lblBtnSyrupVanila;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblBtnMinus;
	private JLabel lblBtnPlus;
	private JLabel lblOrderQuentity;
	private JLabel lblBtnPutIn;
	private JPanel pnCategoryCoffee;
	private JLabel lblpn1Background;
	private JPanel pnCategoryTeaBeverage;
	private JLabel lblBtnHotPn2;
	private JLabel lblBtnIcePn2;
	private JLabel lblBtnWaterLittlePn2;
	private JLabel lblBtnWaterDefaultPn2;
	private JLabel lblBtnWaterMorePn2;
	private JLabel label;
	private JLabel lblPn2Background;


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
	public AppPanel05_Order04Option() {
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
		add(getLblNewLabel_1());
		add(getLblNewLabel_4());
		add(getLblNewLabel_5());
		add(getLblBtnMinus());
		add(getLblBtnPlus());
		add(getLblOrderQuentity());
		add(getLblBtnPutIn());
		add(getPnCategoryCoffee());
		add(getPnCategoryTeaBeverage());
	}
	
	// 상단바 =============================================================================================================
	private JLabel getLblBtnSidebar() {
		if (lblBtnSidebar == null) {
			lblBtnSidebar = new JLabel("");
			lblBtnSidebar.setHorizontalAlignment(SwingConstants.CENTER);
			lblBtnSidebar.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/icon_sidebar.png"));
			lblBtnSidebar.setBounds(13, 26, 36, 32);
		}
		return lblBtnSidebar;
	}
	private JLabel getLblBtnBack() {
		if (lblBtnBack == null) {
			lblBtnBack = new JLabel("");
			lblBtnBack.setHorizontalAlignment(SwingConstants.CENTER);
			lblBtnBack.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/icon_back.png"));
			lblBtnBack.setBounds(51, 26, 32, 32);
		}
		return lblBtnBack;
	}
	private JLabel getLblNewLabel_01() {
		if (lblNewLabel_01 == null) {
			lblNewLabel_01 = new JLabel("옵션 선택");
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
			lblProfilePhoto.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/profile_photo.png"));
			lblProfilePhoto.setBounds(322, 26, 36, 36);
		}
		return lblProfilePhoto;
	}
	// ==================================================================================================================

	// Tabbar ===========================================================================================================
	private JLabel getLblBtnTabHome() {
		if (lblBtnTabHome == null) {
			lblBtnTabHome = new JLabel("");
			lblBtnTabHome.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/tabbar_home.png"));
			lblBtnTabHome.setBounds(1, 729, 94, 50);
		}
		return lblBtnTabHome;
	}
	private JLabel getLblBtnTabOrder() {
		if (lblBtnTabOrder == null) {
			lblBtnTabOrder = new JLabel("");
			lblBtnTabOrder.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/tabbar_order.png"));
			lblBtnTabOrder.setBounds(95, 729, 94, 50);
		}
		return lblBtnTabOrder;
	}
	private JLabel getLblBtnTabGift() {
		if (lblBtnTabGift == null) {
			lblBtnTabGift = new JLabel("");
			lblBtnTabGift.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/tabbar_gift.png"));
			lblBtnTabGift.setBounds(187, 729, 94, 50);
		}
		return lblBtnTabGift;
	}
	private JLabel getLblBtnTabMypage() {
		if (lblBtnTabMypage == null) {
			lblBtnTabMypage = new JLabel("");
			lblBtnTabMypage.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/tabbar_mypage.png"));
			lblBtnTabMypage.setBounds(281, 729, 94, 50);
		}
		return lblBtnTabMypage;
	}
	private JLabel getLblHomeIndicator() {
		if (lblHomeIndicator == null) {
			lblHomeIndicator = new JLabel("");
			lblHomeIndicator.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/homeindicator.png"));
			lblHomeIndicator.setBounds(1, 778, 375, 34);
		}
		return lblHomeIndicator;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("상품명select");
			lblNewLabel.setForeground(new Color(176, 108, 89));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
			lblNewLabel.setBounds(1, 178, 374, 32);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("상품사진select");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(138, 74, 100, 100);
		}
		return lblNewLabel_1;
	}
	
	// =================================================
	private JPanel getPnCategoryCoffee() {
		if (pnCategoryCoffee == null) {
			pnCategoryCoffee = new JPanel() {
				
			// 판넬 모서리 둥글게 하기 ----------------------------------------------------------------------------------------
				@Override
				protected void paintComponent(Graphics g) {
					Graphics2D g2 = (Graphics2D) g;
					g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
					g2.setColor(getBackground()); 							  // paint background
					g2.fillRoundRect(0, 0, getWidth() , getHeight(), 40, 40); // paint background
//					g2.setColor(getForeground());													  // paint border
//					g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcs.width, arcs.height); // paint border
					super.paintComponent(g); 
				}
			};
			pnCategoryCoffee.setOpaque(false);
			// -----------------------------------------------------------------------------------------------------------
			
			pnCategoryCoffee.setBounds(20, 215, 335, 334);
			pnCategoryCoffee.setLayout(null);
			pnCategoryCoffee.add(getLblBtnHot());
			pnCategoryCoffee.add(getLblBtnIce());
			pnCategoryCoffee.add(getLblBtnWaterLittle());
			pnCategoryCoffee.add(getLblBtnWaterDefault());
			pnCategoryCoffee.add(getLblBtnWaterMore());
			pnCategoryCoffee.add(getLblBtnShot0());
			pnCategoryCoffee.add(getLblBtnShot1());
			pnCategoryCoffee.add(getLblBtnShot2());
			pnCategoryCoffee.add(getLblBtnShot3());
			pnCategoryCoffee.add(getLblBtnSyrupNot());
			pnCategoryCoffee.add(getLblBtnSyrupHazelnut());
			pnCategoryCoffee.add(getLblBtnSyrupVanila());
			pnCategoryCoffee.add(getLblpn1Background());
			pnCategoryCoffee.add(getLabel());

			//
			pnCategoryCoffee.setVisible(false);
			
		}
		return pnCategoryCoffee;
	}
	private JLabel getLblBtnHot() {
		if (lblBtnHot == null) {
			lblBtnHot = new JLabel("");
			lblBtnHot.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_hot.png"));
			lblBtnHot.setBounds(58, 21, 77, 32);
		}
		return lblBtnHot;
	}
	private JLabel getLblBtnIce() {
		if (lblBtnIce == null) {
			lblBtnIce = new JLabel("");
			lblBtnIce.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_ice.png"));
			lblBtnIce.setBounds(209, 21, 77, 32);
		}
		return lblBtnIce;
	}
	private JLabel getLblBtnWaterLittle() {
		if (lblBtnWaterLittle == null) {
			lblBtnWaterLittle = new JLabel("");
			lblBtnWaterLittle.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_water_little.png"));
			lblBtnWaterLittle.setBounds(16, 94, 86, 31);
		}
		return lblBtnWaterLittle;
	}
	private JLabel getLblBtnWaterDefault() {
		if (lblBtnWaterDefault == null) {
			lblBtnWaterDefault = new JLabel("");
			lblBtnWaterDefault.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_water_default.png"));
			lblBtnWaterDefault.setBounds(126, 94, 86, 31);
		}
		return lblBtnWaterDefault;
	}
	private JLabel getLblBtnWaterMore() {
		if (lblBtnWaterMore == null) {
			lblBtnWaterMore = new JLabel("");
			lblBtnWaterMore.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_water_more.png"));
			lblBtnWaterMore.setBounds(235, 94, 86, 31);
		}
		return lblBtnWaterMore;
	}
	private JLabel getLblBtnShot0() {
		if (lblBtnShot0 == null) {
			lblBtnShot0 = new JLabel("");
			lblBtnShot0.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_shot_plus0.png"));
			lblBtnShot0.setBounds(16, 171, 66, 54);
		}
		return lblBtnShot0;
	}
	private JLabel getLblBtnShot1() {
		if (lblBtnShot1 == null) {
			lblBtnShot1 = new JLabel("");
			lblBtnShot1.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_shot_plus1.png"));
			lblBtnShot1.setBounds(95, 171, 66, 54);
		}
		return lblBtnShot1;
	}
	private JLabel getLblBtnShot2() {
		if (lblBtnShot2 == null) {
			lblBtnShot2 = new JLabel("");
			lblBtnShot2.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_shot_plus2.png"));
			lblBtnShot2.setBounds(175, 171, 66, 54);
		}
		return lblBtnShot2;
	}
	private JLabel getLblBtnShot3() {
		if (lblBtnShot3 == null) {
			lblBtnShot3 = new JLabel("");
			lblBtnShot3.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_shot_plus3.png"));
			lblBtnShot3.setBounds(255, 171, 66, 54);
		}
		return lblBtnShot3;
	}
	private JLabel getLblBtnSyrupNot() {
		if (lblBtnSyrupNot == null) {
			lblBtnSyrupNot = new JLabel("");
			lblBtnSyrupNot.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_syrup_not.png"));
			lblBtnSyrupNot.setBounds(16, 263, 96, 54);
		}
		return lblBtnSyrupNot;
	}
	private JLabel getLblBtnSyrupHazelnut() {
		if (lblBtnSyrupHazelnut == null) {
			lblBtnSyrupHazelnut = new JLabel("");
			lblBtnSyrupHazelnut.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_syrup_hazelnut.png"));
			lblBtnSyrupHazelnut.setBounds(121, 263, 96, 54);
		}
		return lblBtnSyrupHazelnut;
	}
	private JLabel getLblBtnSyrupVanila() {
		if (lblBtnSyrupVanila == null) {
			lblBtnSyrupVanila = new JLabel("");
			lblBtnSyrupVanila.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_syrup_vanila.png"));
			lblBtnSyrupVanila.setBounds(225, 263, 96, 54);
		}
		return lblBtnSyrupVanila;
	}
	
	// =============================
	
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_option_cancel_all.png"));
			lblNewLabel_4.setBounds(15, 580, 166, 45);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("");
			lblNewLabel_5.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_round_base.png"));
			lblNewLabel_5.setBounds(193, 580, 167, 45);
		}
		return lblNewLabel_5;
	}
	private JLabel getLblBtnMinus() {
		if (lblBtnMinus == null) {
			lblBtnMinus = new JLabel("");
			lblBtnMinus.setHorizontalAlignment(SwingConstants.CENTER);
			lblBtnMinus.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_round_minus.png"));
			lblBtnMinus.setBounds(189, 576, 53, 53);
		}
		return lblBtnMinus;
	}
	private JLabel getLblBtnPlus() {
		if (lblBtnPlus == null) {
			lblBtnPlus = new JLabel("");
			lblBtnPlus.setHorizontalAlignment(SwingConstants.CENTER);
			lblBtnPlus.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_round_plus.png"));
			lblBtnPlus.setBounds(311, 576, 53, 53);
		}
		return lblBtnPlus;
	}
	private JLabel getLblOrderQuentity() {
		if (lblOrderQuentity == null) {
			lblOrderQuentity = new JLabel("갯수");
			lblOrderQuentity.setForeground(new Color(176, 108, 89));
			lblOrderQuentity.setFont(new Font("SansSerif", Font.PLAIN, 18));
			lblOrderQuentity.setHorizontalAlignment(SwingConstants.CENTER);
			lblOrderQuentity.setBounds(244, 580, 66, 45);
		}
		return lblOrderQuentity;
	}
	private JLabel getLblBtnPutIn() {
		if (lblBtnPutIn == null) {
			lblBtnPutIn = new JLabel("");
			lblBtnPutIn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					AppMain.frame.getContentPane().add(appPanel05_Order05Cart);
				}
			});
			lblBtnPutIn.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_put_in.png"));
			lblBtnPutIn.setBounds(15, 644, 345, 61);
		}
		return lblBtnPutIn;
	}
	private JLabel getLblpn1Background() {
		if (lblpn1Background == null) {
			lblpn1Background = new JLabel("");
			lblpn1Background.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/pn_category_coffee_background.png"));
			lblpn1Background.setBounds(0, 0, 335, 334);
		}
		return lblpn1Background;
	}
	private JPanel getPnCategoryTeaBeverage() {
		if (pnCategoryTeaBeverage == null) {
			
			pnCategoryTeaBeverage = new JPanel() {
				
			// 판넬 모서리 둥글게 하기 ----------------------------------------------------------------------------------------
				@Override
				protected void paintComponent(Graphics g) {
					Graphics2D g2 = (Graphics2D) g;
					g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
					g2.setColor(getBackground()); 							  // paint background
					g2.fillRoundRect(0, 0, getWidth() , getHeight(), 40, 40); // paint background
//					g2.setColor(getForeground());													  // paint border
//					g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcs.width, arcs.height); // paint border
					super.paintComponent(g); 
				}
			};
			pnCategoryTeaBeverage.setOpaque(false);
			// -----------------------------------------------------------------------------------------------------------
			
			pnCategoryTeaBeverage.setBounds(20, 215, 335, 188);
			pnCategoryTeaBeverage.setLayout(null);
			pnCategoryTeaBeverage.add(getLblBtnHotPn2());
			pnCategoryTeaBeverage.add(getLblBtnIcePn2());
			pnCategoryTeaBeverage.add(getLblBtnWaterLittlePn2());
			pnCategoryTeaBeverage.add(getLblBtnWaterDefaultPn2());
			pnCategoryTeaBeverage.add(getLblBtnWaterMorePn2());
			pnCategoryTeaBeverage.add(getLabel_1_1());
			//
			pnCategoryTeaBeverage.setVisible(true);
		}
		return pnCategoryTeaBeverage;
	}
	
	private JLabel getLblBtnHotPn2() {
		if (lblBtnHotPn2 == null) {
			lblBtnHotPn2 = new JLabel("");
			lblBtnHotPn2.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_hot.png"));
			lblBtnHotPn2.setBounds(58, 39, 77, 32);
		}
		return lblBtnHotPn2;
	}
	private JLabel getLblBtnIcePn2() {
		if (lblBtnIcePn2 == null) {
			lblBtnIcePn2 = new JLabel("");
			lblBtnIcePn2.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_ice.png"));
			lblBtnIcePn2.setBounds(209, 39, 77, 32);
		}
		return lblBtnIcePn2;
	}
	private JLabel getLblBtnWaterLittlePn2() {
		if (lblBtnWaterLittlePn2 == null) {
			lblBtnWaterLittlePn2 = new JLabel("");
			lblBtnWaterLittlePn2.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_water_little.png"));
			lblBtnWaterLittlePn2.setBounds(16, 112, 86, 31);
		}
		return lblBtnWaterLittlePn2;
	}
	private JLabel getLblBtnWaterDefaultPn2() {
		if (lblBtnWaterDefaultPn2 == null) {
			lblBtnWaterDefaultPn2 = new JLabel("");
			lblBtnWaterDefaultPn2.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_water_default.png"));
			lblBtnWaterDefaultPn2.setBounds(126, 112, 86, 31);
		}
		return lblBtnWaterDefaultPn2;
	}
	private JLabel getLblBtnWaterMorePn2() {
		if (lblBtnWaterMorePn2 == null) {
			lblBtnWaterMorePn2 = new JLabel("");
			lblBtnWaterMorePn2.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_water_more.png"));
			lblBtnWaterMorePn2.setBounds(235, 112, 86, 31);
		}
		return lblBtnWaterMorePn2;
	}
	
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("New label");
			label.setBounds(0, 0, 335, 188);
		}
		return label;
	}
	private JLabel getLabel_1_1() {
		if (lblPn2Background == null) {
			lblPn2Background = new JLabel("");
			lblPn2Background.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/pn_category_tea&beverage_background.png"));
			lblPn2Background.setBounds(0, 0, 335, 188);
		}
		return lblPn2Background;
	}
} // End