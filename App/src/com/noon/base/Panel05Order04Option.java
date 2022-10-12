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
import javax.swing.SwingConstants;

public class Panel05Order04Option extends JPanel {
	
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
	private JLabel lblBtnSizeTall;
	private JLabel lblBtnSizeRegular;
	private JLabel lblBtnSizeGrande;
	private JLabel lblPn2Background;
	private JLabel lblBtnSyrupHazelnut_1;


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
	public Panel05Order04Option() {
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
			lblBtnTabHome.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					Main.frame.getContentPane().add(new Panel03Home());
				}
			});
			lblBtnTabHome.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/tabbar_home.png"));
			lblBtnTabHome.setBounds(1, 729, 94, 50);
		}
		return lblBtnTabHome;
	}
	private JLabel getLblBtnTabOrder() {
		if (lblBtnTabOrder == null) {
			lblBtnTabOrder = new JLabel("");
			lblBtnTabOrder.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					Main.frame.getContentPane().add(new Panel05Order01Shop());
				}
			});
			lblBtnTabOrder.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/tabbar_order.png"));
			lblBtnTabOrder.setBounds(95, 729, 94, 50);
		}
		return lblBtnTabOrder;
	}
	private JLabel getLblBtnTabGift() {
		if (lblBtnTabGift == null) {
			lblBtnTabGift = new JLabel("");
			lblBtnTabGift.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					Main.frame.getContentPane().add(new Panel06Gift());
				}
			});
			lblBtnTabGift.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/tabbar_gift.png"));
			lblBtnTabGift.setBounds(187, 729, 94, 50);
		}
		return lblBtnTabGift;
	}
	private JLabel getLblBtnTabMypage() {
		if (lblBtnTabMypage == null) {
			lblBtnTabMypage = new JLabel("");
			lblBtnTabMypage.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					Main.frame.getContentPane().add(new Panel04MyPage());
				}
			});
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
	// ==================================================================================================================

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
			pnCategoryCoffee = new JPanel();
			pnCategoryCoffee.setBackground(new Color(255, 0, 0, 0));
			pnCategoryCoffee.setBounds(20, 244, 335, 277);
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
			pnCategoryCoffee.add(getLblBtnSyrupHazelnut_1());
			pnCategoryCoffee.add(getLblpn1Background());

			//
			pnCategoryCoffee.setVisible(true);
			
		}
		return pnCategoryCoffee;
	}
	private JLabel getLblBtnHot() {
		if (lblBtnHot == null) {
			lblBtnHot = new JLabel("");
			lblBtnHot.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_hot1.png"));
			lblBtnHot.setBounds(87, 20, 77, 32);
		}
		return lblBtnHot;
	}
	private JLabel getLblBtnIce() {
		if (lblBtnIce == null) {
			lblBtnIce = new JLabel("");
			lblBtnIce.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_ice1.png"));
			lblBtnIce.setBounds(232, 20, 77, 32);
		}
		return lblBtnIce;
	}
	private JLabel getLblBtnWaterLittle() {
		if (lblBtnWaterLittle == null) {
			lblBtnWaterLittle = new JLabel("");
			lblBtnWaterLittle.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_size_tall.png"));
			lblBtnWaterLittle.setBounds(87, 86, 45, 31);
		}
		return lblBtnWaterLittle;
	}
	private JLabel getLblBtnWaterDefault() {
		if (lblBtnWaterDefault == null) {
			lblBtnWaterDefault = new JLabel("");
			lblBtnWaterDefault.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_size_regular_.png"));
			lblBtnWaterDefault.setBounds(146, 86, 78, 43);
		}
		return lblBtnWaterDefault;
	}
	private JLabel getLblBtnWaterMore() {
		if (lblBtnWaterMore == null) {
			lblBtnWaterMore = new JLabel("");
			lblBtnWaterMore.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_size_grande_.png"));
			lblBtnWaterMore.setBounds(237, 86, 72, 43);
		}
		return lblBtnWaterMore;
	}
	private JLabel getLblBtnShot0() {
		if (lblBtnShot0 == null) {
			lblBtnShot0 = new JLabel("");
			lblBtnShot0.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_shot_basic.png"));
			lblBtnShot0.setBounds(87, 151, 45, 31);
		}
		return lblBtnShot0;
	}
	private JLabel getLblBtnShot1() {
		if (lblBtnShot1 == null) {
			lblBtnShot1 = new JLabel("");
			lblBtnShot1.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_shot_plus1_.png"));
			lblBtnShot1.setBounds(146, 151, 45, 43);
		}
		return lblBtnShot1;
	}
	private JLabel getLblBtnShot2() {
		if (lblBtnShot2 == null) {
			lblBtnShot2 = new JLabel("");
			lblBtnShot2.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_shot_plus2_.png"));
			lblBtnShot2.setBounds(205, 151, 45, 43);
		}
		return lblBtnShot2;
	}
	private JLabel getLblBtnShot3() {
		if (lblBtnShot3 == null) {
			lblBtnShot3 = new JLabel("");
			lblBtnShot3.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_shot_plus3__.png"));
			lblBtnShot3.setBounds(264, 151, 45, 43);
		}
		return lblBtnShot3;
	}
	private JLabel getLblBtnSyrupNot() {
		if (lblBtnSyrupNot == null) {
			lblBtnSyrupNot = new JLabel("");
			lblBtnSyrupNot.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_syrup_basic1.png"));
			lblBtnSyrupNot.setBounds(87, 216, 45, 31);
		}
		return lblBtnSyrupNot;
	}
	private JLabel getLblBtnSyrupHazelnut() {
		if (lblBtnSyrupHazelnut == null) {
			lblBtnSyrupHazelnut = new JLabel("");
			lblBtnSyrupHazelnut.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_syrup_hazelnut2.png"));
			lblBtnSyrupHazelnut.setBounds(151, 216, 76, 43);
		}
		return lblBtnSyrupHazelnut;
	}
	
	// =============================
	
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					lblNewLabel_4.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_option_cancel_all_C.png"));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblNewLabel_4.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_option_cancel_all.png"));
				}
			});
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
			lblBtnMinus.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
				@Override
				public void mousePressed(MouseEvent e) {
					lblBtnMinus.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_round_minus_C.png"));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblBtnMinus.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_round_minus.png"));
				}
			});
			lblBtnMinus.setHorizontalAlignment(SwingConstants.CENTER);
			lblBtnMinus.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_round_minus.png"));
			lblBtnMinus.setBounds(189, 576, 53, 53);
		}
		return lblBtnMinus;
	}
	private JLabel getLblBtnPlus() {
		if (lblBtnPlus == null) {
			lblBtnPlus = new JLabel("");
			lblBtnPlus.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
				@Override
				public void mousePressed(MouseEvent e) {
					lblBtnPlus.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_round_plus_C.png"));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblBtnPlus.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_round_plus.png"));
				}
			});
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
					Main.frame.getContentPane().add(new Panel05Order05Cart());
				}
				@Override
				public void mousePressed(MouseEvent e) {
					lblBtnPutIn.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_put_in_C.png"));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblBtnPutIn.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_put_in.png"));
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
			lblpn1Background.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/pn_option_category_coffee.png"));
			lblpn1Background.setBounds(0, 0, 335, 277);
		}
		return lblpn1Background;
	}
	private JPanel getPnCategoryTeaBeverage() {
		if (pnCategoryTeaBeverage == null) {
			pnCategoryTeaBeverage = new JPanel();
			pnCategoryTeaBeverage.setBackground(new Color(255, 0, 0, 0));
			pnCategoryTeaBeverage.setBounds(20, 244, 335, 277);
			pnCategoryTeaBeverage.setLayout(null);
			pnCategoryTeaBeverage.add(getLblBtnHotPn2());
			pnCategoryTeaBeverage.add(getLblBtnIcePn2());
			pnCategoryTeaBeverage.add(getLblBtnSizeTall());
			pnCategoryTeaBeverage.add(getLblBtnSizeRegular());
			pnCategoryTeaBeverage.add(getLblBtnSizeGrande());
			pnCategoryTeaBeverage.add(getLabel_1_1());
			//
//			pnCategoryTeaBeverage.setVisible(true);
		}
		return pnCategoryTeaBeverage;
	}
	
	private JLabel getLblBtnHotPn2() {
		if (lblBtnHotPn2 == null) {
			lblBtnHotPn2 = new JLabel("");
			lblBtnHotPn2.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_hot1.png"));
			lblBtnHotPn2.setBounds(87, 55, 77, 32);
		}
		return lblBtnHotPn2;
	}
	private JLabel getLblBtnIcePn2() {
		if (lblBtnIcePn2 == null) {
			lblBtnIcePn2 = new JLabel("");
			lblBtnIcePn2.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_ice1.png"));
			lblBtnIcePn2.setBounds(232, 55, 77, 32);
		}
		return lblBtnIcePn2;
	}
	private JLabel getLblBtnSizeTall() {
		if (lblBtnSizeTall == null) {
			lblBtnSizeTall = new JLabel("");
			lblBtnSizeTall.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_size_tall.png"));
			lblBtnSizeTall.setBounds(87, 189, 45, 31);
		}
		return lblBtnSizeTall;
	}
	private JLabel getLblBtnSizeRegular() {
		if (lblBtnSizeRegular == null) {
			lblBtnSizeRegular = new JLabel("");
			lblBtnSizeRegular.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_size_regular_.png"));
			lblBtnSizeRegular.setBounds(146, 189, 78, 43);
		}
		return lblBtnSizeRegular;
	}
	private JLabel getLblBtnSizeGrande() {
		if (lblBtnSizeGrande == null) {
			lblBtnSizeGrande = new JLabel("");
			lblBtnSizeGrande.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_size_grande_.png"));
			lblBtnSizeGrande.setBounds(237, 189, 72, 43);
		}
		return lblBtnSizeGrande;
	}
	private JLabel getLabel_1_1() {
		if (lblPn2Background == null) {
			lblPn2Background = new JLabel("");
			lblPn2Background.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/pn_option_category_tea&beverage.png"));
			lblPn2Background.setBounds(0, 0, 335, 277);
		}
		return lblPn2Background;
	}
	private JLabel getLblBtnSyrupHazelnut_1() {
		if (lblBtnSyrupHazelnut_1 == null) {
			lblBtnSyrupHazelnut_1 = new JLabel("");
			lblBtnSyrupHazelnut_1.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_syrup_vanila2.png"));
			lblBtnSyrupHazelnut_1.setBounds(245, 216, 63, 43);
		}
		return lblBtnSyrupHazelnut_1;
	}
} // End