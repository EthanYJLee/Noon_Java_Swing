package com.noon.base;

import java.awt.Color;
import java.awt.ComponentOrientation;
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
import javax.swing.JLayeredPane;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JSplitPane;

public class Panel05Order03Menu extends JPanel {

	private JLabel lblNewLabel_01;
	private JLabel lblBtnTabOrder;
	private JLabel lblBtnTabMypage;
	private JLabel lblHomeIndicator;
	private JLabel lblBtnTabHome;
	private JLabel lblBtnTabGift;
	private JLabel lblBtnSidebar;
	private JLabel lblBtnBack;
	private JLabel lblProfilePhoto;
	private JLabel lblCategoryCoffee;
	private JLabel lblCategoryBeverage;
	private JLabel lblCategoryTea;
	private JLabel lblCategoryAllMenu;
	private JLabel lblBtnSelect;
	private JPanel panel;
	private JLayeredPane layeredPane_1;
	private JPanel pnMenu01_4;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_1_8;
	private JLabel lblNewLabel_1_1_7;
	private JPanel pnMenu02_3;
	private JLabel lblNewLabel_2_3;
	private JLabel lblNewLabel_1_2_3;
	private JLabel lblNewLabel_1_1_1_3;
	private JPanel pnMenu03_3;
	private JLabel lblNewLabel_3_3;
	private JLabel lblNewLabel_1_3_3;
	private JLabel lblNewLabel_1_1_2_3;
	private JPanel pnMenu04_3;
	private JLabel lblNewLabel_4_3;
	private JLabel lblNewLabel_1_4_3;
	private JLabel lblNewLabel_1_1_3_3;
	private JPanel pnMenu01_1_2;
	private JLabel lblNewLabel_5_2;
	private JLabel lblNewLabel_1_5_2;
	private JLabel lblNewLabel_1_1_4_2;
	private JPanel pnMenu02_1_2;
	private JLabel lblNewLabel_2_1_2;
	private JLabel lblNewLabel_1_2_1_2;
	private JLabel lblNewLabel_1_1_1_1_2;
	private JPanel pnMenu03_1_2;
	private JLabel lblNewLabel_3_1_2;
	private JLabel lblNewLabel_1_3_1_2;
	private JLabel lblNewLabel_1_1_2_1_2;
	private JPanel pnMenu04_1_1;
	private JLabel lblNewLabel_4_1_1;
	private JLabel lblNewLabel_1_4_1_1;
	private JLabel lblNewLabel_1_1_3_1_1;
	private JPanel pnMenu01_2_1;
	private JLabel lblNewLabel_6_1;
	private JLabel lblNewLabel_1_6_1;
	private JLabel lblNewLabel_1_1_5_1;
	private JPanel pnMenu01_3_1;
	private JLabel lblNewLabel_7_1;
	private JLabel lblNewLabel_1_7_1;
	private JLabel lblNewLabel_1_1_6_1;
	private JPanel pnMenu02_2_1;
	private JLabel lblNewLabel_2_2_1;
	private JLabel lblNewLabel_1_2_2_1;
	private JLabel lblNewLabel_1_1_1_2_1;
	private JPanel pnMenu03_2_1;
	private JLabel lblNewLabel_3_2_1;
	private JLabel lblNewLabel_1_3_2_1;
	private JLabel lblNewLabel_1_1_2_2_1;
	private JPanel pnMenu04_2_1;
	private JLabel lblNewLabel_4_2_1;
	private JLabel lblNewLabel_1_4_2_1;
	private JLabel lblNewLabel_1_1_3_2_1;
	private JPanel pnMenu01_1_1_1;
	private JLabel lblNewLabel_5_1_1;
	private JLabel lblNewLabel_1_5_1_1;
	private JLabel lblNewLabel_1_1_4_1_1;
	private JPanel pnMenu02_1_1_1;
	private JLabel lblNewLabel_2_1_1_1;
	private JLabel lblNewLabel_1_2_1_1_1;
	private JLabel lblNewLabel_1_1_1_1_1_1;
	private JPanel pnMenu03_1_1_1;
	private JLabel lblNewLabel_3_1_1_1;
	private JLabel lblNewLabel_1_3_1_1_1;
	private JLabel lblNewLabel_1_1_2_1_1_1;
	private JLabel btnBefore;
	private JLabel btnAfter;
	private JLabel lblTotalPrice;
	private JLabel lblBtnGoCart;
	private JLabel lblNewLabel;

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
	public Panel05Order03Menu() {
		setBounds(0, 0, 375, 812);
		setOpaque(true);
		setLayout(null);
		add(getLblBtnSidebar());
		add(getLblBtnBack());
		
		add(getLblNewLabel_01());
		add(getLblProfilePhoto());
		add(getLblCategoryCoffee());
		add(getLblCategoryBeverage());
		add(getLblCategoryTea());
		add(getLblCategoryAllMenu());
		add(getLblBtnTabHome());
		add(getLblBtnTabOrder());
		add(getLblBtnTabGift());
		add(getLblBtnTabMypage());
		add(getLblHomeIndicator());
		add(getLblBtnGoCart());
		add(getLblBtnSelect());
		add(getPanel());
		add(getLblTotalPrice());
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

	private JLabel getLblCategoryCoffee() {
		if (lblCategoryCoffee == null) {
			lblCategoryCoffee = new JLabel("");
			lblCategoryCoffee.setVerticalAlignment(SwingConstants.TOP);
			lblCategoryCoffee.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/category_coffee.png"));
			lblCategoryCoffee.setBounds(20, 78, 63, 81);
		}
		return lblCategoryCoffee;
	}
	private JLabel getLblCategoryBeverage() {
		if (lblCategoryBeverage == null) {
			lblCategoryBeverage = new JLabel("");
			lblCategoryBeverage.setVerticalAlignment(SwingConstants.TOP);
			lblCategoryBeverage.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/category_beverage.png"));
			lblCategoryBeverage.setBounds(111, 78, 63, 81);
		}
		return lblCategoryBeverage;
	}
	private JLabel getLblCategoryTea() {
		if (lblCategoryTea == null) {
			lblCategoryTea = new JLabel("");
			lblCategoryTea.setVerticalAlignment(SwingConstants.TOP);
			lblCategoryTea.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/category_tea.png"));
			lblCategoryTea.setBounds(202, 78, 63, 81);
		}
		return lblCategoryTea;
	}
	private JLabel getLblCategoryAllMenu() {
		if (lblCategoryAllMenu == null) {
			lblCategoryAllMenu = new JLabel("");
			lblCategoryAllMenu.setVerticalAlignment(SwingConstants.TOP);
			lblCategoryAllMenu.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/category_all_menu.png"));
			lblCategoryAllMenu.setBounds(292, 78, 63, 81);
		}
		return lblCategoryAllMenu;
	}
	private JLabel getLblBtnSelect() {
		if (lblBtnSelect == null) {
			lblBtnSelect = new JLabel("");
			lblBtnSelect.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					Main.frame.getContentPane().add(new Panel05Order04Option());
				}
			});
			lblBtnSelect.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_select.png"));
			lblBtnSelect.setBounds(15, 644, 284, 61);
		}
		return lblBtnSelect;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel() {
				
				// 판넬 모서리 둥글게 하기 ----------------------------------------------------------------------------------------
				@Override
				protected void paintComponent(Graphics g) {
					Graphics2D g2 = (Graphics2D) g;
					g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
					g2.fillRoundRect(0, 0, getWidth() , getHeight(), 50, 50); // round
					super.paintComponent(g); 
				}
			};
			panel.setOpaque(false);
			// --------------------------------------------------------------------------------------------------------------
			
			panel.setBounds(15, 164, 345, 448);
			panel.setLayout(null);
			panel.add(getLayeredPane_1());
			panel.add(getBtnBefore());
			panel.add(getLblNewLabel_1_11());
			panel.add(getLblNewLabel());
		}
		return panel;
	}
	private JLayeredPane getLayeredPane_1() {
		if (layeredPane_1 == null) {
			layeredPane_1 = new JLayeredPane();
			layeredPane_1.setBounds(15, 15, 316, 400);
			layeredPane_1.setLayout(new GridLayout(4, 4, 16, 6));
			layeredPane_1.add(getPnMenu01_4_1());
			layeredPane_1.add(getPnMenu02_3());
			layeredPane_1.add(getPnMenu03_3());
			layeredPane_1.add(getPnMenu04_3());
			layeredPane_1.add(getPnMenu01_1_2());
			layeredPane_1.add(getPnMenu02_1_2());
			layeredPane_1.add(getPnMenu03_1_2());
			layeredPane_1.add(getPnMenu04_1_1());
			layeredPane_1.add(getPnMenu01_2_1());
			layeredPane_1.add(getPnMenu01_3_1());
			layeredPane_1.add(getPnMenu02_2_1());
			layeredPane_1.add(getPnMenu03_2_1());
			layeredPane_1.add(getPnMenu04_2_1());
			layeredPane_1.add(getPnMenu01_1_1_1());
			layeredPane_1.add(getPnMenu02_1_1_1());
			layeredPane_1.add(getPnMenu03_1_1_1());
		}
		return layeredPane_1;
	}
	private JPanel getPnMenu01_4_1() {
		if (pnMenu01_4 == null) {
			pnMenu01_4 = new JPanel();
			pnMenu01_4.setLayout(null);
			pnMenu01_4.add(getLblNewLabel_8_1());
			pnMenu01_4.add(getLblNewLabel_1_8_1());
			pnMenu01_4.add(getLblNewLabel_1_1_7_1());
		}
		return pnMenu01_4;
	}
	private JLabel getLblNewLabel_8_1() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel("pic_select");
			lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_8.setBounds(0, 0, 67, 67);
		}
		return lblNewLabel_8;
	}
	private JLabel getLblNewLabel_1_8_1() {
		if (lblNewLabel_1_8 == null) {
			lblNewLabel_1_8 = new JLabel("name_select");
			lblNewLabel_1_8.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_8.setFont(new Font("SansSerif", Font.PLAIN, 9));
			lblNewLabel_1_8.setBounds(0, 70, 67, 11);
		}
		return lblNewLabel_1_8;
	}
	private JLabel getLblNewLabel_1_1_7_1() {
		if (lblNewLabel_1_1_7 == null) {
			lblNewLabel_1_1_7 = new JLabel("price_select");
			lblNewLabel_1_1_7.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_7.setFont(new Font("SansSerif", Font.BOLD, 10));
			lblNewLabel_1_1_7.setBounds(0, 82, 67, 11);
		}
		return lblNewLabel_1_1_7;
	}
	private JPanel getPnMenu02_3() {
		if (pnMenu02_3 == null) {
			pnMenu02_3 = new JPanel();
			pnMenu02_3.setLayout(null);
			pnMenu02_3.add(getLblNewLabel_2_3());
			pnMenu02_3.add(getLblNewLabel_1_2_3());
			pnMenu02_3.add(getLblNewLabel_1_1_1_3());
		}
		return pnMenu02_3;
	}
	private JLabel getLblNewLabel_2_3() {
		if (lblNewLabel_2_3 == null) {
			lblNewLabel_2_3 = new JLabel("pic_select");
			lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_3.setBounds(0, 0, 67, 67);
		}
		return lblNewLabel_2_3;
	}
	private JLabel getLblNewLabel_1_2_3() {
		if (lblNewLabel_1_2_3 == null) {
			lblNewLabel_1_2_3 = new JLabel("name_select");
			lblNewLabel_1_2_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_2_3.setFont(new Font("SansSerif", Font.PLAIN, 9));
			lblNewLabel_1_2_3.setBounds(0, 70, 67, 11);
		}
		return lblNewLabel_1_2_3;
	}
	private JLabel getLblNewLabel_1_1_1_3() {
		if (lblNewLabel_1_1_1_3 == null) {
			lblNewLabel_1_1_1_3 = new JLabel("price_select");
			lblNewLabel_1_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_1_3.setFont(new Font("SansSerif", Font.BOLD, 10));
			lblNewLabel_1_1_1_3.setBounds(0, 82, 67, 11);
		}
		return lblNewLabel_1_1_1_3;
	}
	private JPanel getPnMenu03_3() {
		if (pnMenu03_3 == null) {
			pnMenu03_3 = new JPanel();
			pnMenu03_3.setLayout(null);
			pnMenu03_3.add(getLblNewLabel_3_3());
			pnMenu03_3.add(getLblNewLabel_1_3_3());
			pnMenu03_3.add(getLblNewLabel_1_1_2_3());
		}
		return pnMenu03_3;
	}
	private JLabel getLblNewLabel_3_3() {
		if (lblNewLabel_3_3 == null) {
			lblNewLabel_3_3 = new JLabel("pic_select");
			lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3_3.setBounds(0, 0, 67, 67);
		}
		return lblNewLabel_3_3;
	}
	private JLabel getLblNewLabel_1_3_3() {
		if (lblNewLabel_1_3_3 == null) {
			lblNewLabel_1_3_3 = new JLabel("name_select");
			lblNewLabel_1_3_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_3_3.setFont(new Font("SansSerif", Font.PLAIN, 9));
			lblNewLabel_1_3_3.setBounds(0, 70, 67, 11);
		}
		return lblNewLabel_1_3_3;
	}
	private JLabel getLblNewLabel_1_1_2_3() {
		if (lblNewLabel_1_1_2_3 == null) {
			lblNewLabel_1_1_2_3 = new JLabel("price_select");
			lblNewLabel_1_1_2_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_2_3.setFont(new Font("SansSerif", Font.BOLD, 10));
			lblNewLabel_1_1_2_3.setBounds(0, 82, 67, 11);
		}
		return lblNewLabel_1_1_2_3;
	}
	private JPanel getPnMenu04_3() {
		if (pnMenu04_3 == null) {
			pnMenu04_3 = new JPanel();
			pnMenu04_3.setLayout(null);
			pnMenu04_3.add(getLblNewLabel_4_3());
			pnMenu04_3.add(getLblNewLabel_1_4_3());
			pnMenu04_3.add(getLblNewLabel_1_1_3_3());
		}
		return pnMenu04_3;
	}
	private JLabel getLblNewLabel_4_3() {
		if (lblNewLabel_4_3 == null) {
			lblNewLabel_4_3 = new JLabel("pic_select");
			lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4_3.setBounds(0, 0, 67, 67);
		}
		return lblNewLabel_4_3;
	}
	private JLabel getLblNewLabel_1_4_3() {
		if (lblNewLabel_1_4_3 == null) {
			lblNewLabel_1_4_3 = new JLabel("name_select");
			lblNewLabel_1_4_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_4_3.setFont(new Font("SansSerif", Font.PLAIN, 9));
			lblNewLabel_1_4_3.setBounds(0, 70, 67, 11);
		}
		return lblNewLabel_1_4_3;
	}
	private JLabel getLblNewLabel_1_1_3_3() {
		if (lblNewLabel_1_1_3_3 == null) {
			lblNewLabel_1_1_3_3 = new JLabel("price_select");
			lblNewLabel_1_1_3_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_3_3.setFont(new Font("SansSerif", Font.BOLD, 10));
			lblNewLabel_1_1_3_3.setBounds(0, 82, 67, 11);
		}
		return lblNewLabel_1_1_3_3;
	}
	private JPanel getPnMenu01_1_2() {
		if (pnMenu01_1_2 == null) {
			pnMenu01_1_2 = new JPanel();
			pnMenu01_1_2.setLayout(null);
			pnMenu01_1_2.add(getLblNewLabel_5_2());
			pnMenu01_1_2.add(getLblNewLabel_1_5_2());
			pnMenu01_1_2.add(getLblNewLabel_1_1_4_2());
		}
		return pnMenu01_1_2;
	}
	private JLabel getLblNewLabel_5_2() {
		if (lblNewLabel_5_2 == null) {
			lblNewLabel_5_2 = new JLabel("pic_select");
			lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_5_2.setBounds(0, 0, 67, 67);
		}
		return lblNewLabel_5_2;
	}
	private JLabel getLblNewLabel_1_5_2() {
		if (lblNewLabel_1_5_2 == null) {
			lblNewLabel_1_5_2 = new JLabel("name_select");
			lblNewLabel_1_5_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_5_2.setFont(new Font("SansSerif", Font.PLAIN, 9));
			lblNewLabel_1_5_2.setBounds(0, 70, 67, 11);
		}
		return lblNewLabel_1_5_2;
	}
	private JLabel getLblNewLabel_1_1_4_2() {
		if (lblNewLabel_1_1_4_2 == null) {
			lblNewLabel_1_1_4_2 = new JLabel("price_select");
			lblNewLabel_1_1_4_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_4_2.setFont(new Font("SansSerif", Font.BOLD, 10));
			lblNewLabel_1_1_4_2.setBounds(0, 82, 67, 11);
		}
		return lblNewLabel_1_1_4_2;
	}
	private JPanel getPnMenu02_1_2() {
		if (pnMenu02_1_2 == null) {
			pnMenu02_1_2 = new JPanel();
			pnMenu02_1_2.setLayout(null);
			pnMenu02_1_2.add(getLblNewLabel_2_1_2());
			pnMenu02_1_2.add(getLblNewLabel_1_2_1_2());
			pnMenu02_1_2.add(getLblNewLabel_1_1_1_1_2());
		}
		return pnMenu02_1_2;
	}
	private JLabel getLblNewLabel_2_1_2() {
		if (lblNewLabel_2_1_2 == null) {
			lblNewLabel_2_1_2 = new JLabel("pic_select");
			lblNewLabel_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_1_2.setBounds(0, 0, 67, 67);
		}
		return lblNewLabel_2_1_2;
	}
	private JLabel getLblNewLabel_1_2_1_2() {
		if (lblNewLabel_1_2_1_2 == null) {
			lblNewLabel_1_2_1_2 = new JLabel("name_select");
			lblNewLabel_1_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_2_1_2.setFont(new Font("SansSerif", Font.PLAIN, 9));
			lblNewLabel_1_2_1_2.setBounds(0, 70, 67, 11);
		}
		return lblNewLabel_1_2_1_2;
	}
	private JLabel getLblNewLabel_1_1_1_1_2() {
		if (lblNewLabel_1_1_1_1_2 == null) {
			lblNewLabel_1_1_1_1_2 = new JLabel("price_select");
			lblNewLabel_1_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_1_1_2.setFont(new Font("SansSerif", Font.BOLD, 10));
			lblNewLabel_1_1_1_1_2.setBounds(0, 82, 67, 11);
		}
		return lblNewLabel_1_1_1_1_2;
	}
	private JPanel getPnMenu03_1_2() {
		if (pnMenu03_1_2 == null) {
			pnMenu03_1_2 = new JPanel();
			pnMenu03_1_2.setLayout(null);
			pnMenu03_1_2.add(getLblNewLabel_3_1_2());
			pnMenu03_1_2.add(getLblNewLabel_1_3_1_2());
			pnMenu03_1_2.add(getLblNewLabel_1_1_2_1_2());
		}
		return pnMenu03_1_2;
	}
	private JLabel getLblNewLabel_3_1_2() {
		if (lblNewLabel_3_1_2 == null) {
			lblNewLabel_3_1_2 = new JLabel("pic_select");
			lblNewLabel_3_1_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3_1_2.setBounds(0, 0, 67, 67);
		}
		return lblNewLabel_3_1_2;
	}
	private JLabel getLblNewLabel_1_3_1_2() {
		if (lblNewLabel_1_3_1_2 == null) {
			lblNewLabel_1_3_1_2 = new JLabel("name_select");
			lblNewLabel_1_3_1_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_3_1_2.setFont(new Font("SansSerif", Font.PLAIN, 9));
			lblNewLabel_1_3_1_2.setBounds(0, 70, 67, 11);
		}
		return lblNewLabel_1_3_1_2;
	}
	private JLabel getLblNewLabel_1_1_2_1_2() {
		if (lblNewLabel_1_1_2_1_2 == null) {
			lblNewLabel_1_1_2_1_2 = new JLabel("price_select");
			lblNewLabel_1_1_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_2_1_2.setFont(new Font("SansSerif", Font.BOLD, 10));
			lblNewLabel_1_1_2_1_2.setBounds(0, 82, 67, 11);
		}
		return lblNewLabel_1_1_2_1_2;
	}
	private JPanel getPnMenu04_1_1() {
		if (pnMenu04_1_1 == null) {
			pnMenu04_1_1 = new JPanel();
			pnMenu04_1_1.setLayout(null);
			pnMenu04_1_1.add(getLblNewLabel_4_1_1());
			pnMenu04_1_1.add(getLblNewLabel_1_4_1_1());
			pnMenu04_1_1.add(getLblNewLabel_1_1_3_1_1());
		}
		return pnMenu04_1_1;
	}
	private JLabel getLblNewLabel_4_1_1() {
		if (lblNewLabel_4_1_1 == null) {
			lblNewLabel_4_1_1 = new JLabel("pic_select");
			lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4_1_1.setBounds(0, 0, 67, 67);
		}
		return lblNewLabel_4_1_1;
	}
	private JLabel getLblNewLabel_1_4_1_1() {
		if (lblNewLabel_1_4_1_1 == null) {
			lblNewLabel_1_4_1_1 = new JLabel("name_select");
			lblNewLabel_1_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_4_1_1.setFont(new Font("SansSerif", Font.PLAIN, 9));
			lblNewLabel_1_4_1_1.setBounds(0, 70, 67, 11);
		}
		return lblNewLabel_1_4_1_1;
	}
	private JLabel getLblNewLabel_1_1_3_1_1() {
		if (lblNewLabel_1_1_3_1_1 == null) {
			lblNewLabel_1_1_3_1_1 = new JLabel("price_select");
			lblNewLabel_1_1_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_3_1_1.setFont(new Font("SansSerif", Font.BOLD, 10));
			lblNewLabel_1_1_3_1_1.setBounds(0, 82, 67, 11);
		}
		return lblNewLabel_1_1_3_1_1;
	}
	private JPanel getPnMenu01_2_1() {
		if (pnMenu01_2_1 == null) {
			pnMenu01_2_1 = new JPanel();
			pnMenu01_2_1.setLayout(null);
			pnMenu01_2_1.add(getLblNewLabel_6_1());
			pnMenu01_2_1.add(getLblNewLabel_1_6_1());
			pnMenu01_2_1.add(getLblNewLabel_1_1_5_1());
		}
		return pnMenu01_2_1;
	}
	private JLabel getLblNewLabel_6_1() {
		if (lblNewLabel_6_1 == null) {
			lblNewLabel_6_1 = new JLabel("pic_select");
			lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_6_1.setBounds(0, 0, 67, 67);
		}
		return lblNewLabel_6_1;
	}
	private JLabel getLblNewLabel_1_6_1() {
		if (lblNewLabel_1_6_1 == null) {
			lblNewLabel_1_6_1 = new JLabel("name_select");
			lblNewLabel_1_6_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_6_1.setFont(new Font("SansSerif", Font.PLAIN, 9));
			lblNewLabel_1_6_1.setBounds(0, 70, 67, 11);
		}
		return lblNewLabel_1_6_1;
	}
	private JLabel getLblNewLabel_1_1_5_1() {
		if (lblNewLabel_1_1_5_1 == null) {
			lblNewLabel_1_1_5_1 = new JLabel("price_select");
			lblNewLabel_1_1_5_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_5_1.setFont(new Font("SansSerif", Font.BOLD, 10));
			lblNewLabel_1_1_5_1.setBounds(0, 82, 67, 11);
		}
		return lblNewLabel_1_1_5_1;
	}
	private JPanel getPnMenu01_3_1() {
		if (pnMenu01_3_1 == null) {
			pnMenu01_3_1 = new JPanel();
			pnMenu01_3_1.setLayout(null);
			pnMenu01_3_1.add(getLblNewLabel_7_1());
			pnMenu01_3_1.add(getLblNewLabel_1_7_1());
			pnMenu01_3_1.add(getLblNewLabel_1_1_6_1());
		}
		return pnMenu01_3_1;
	}
	private JLabel getLblNewLabel_7_1() {
		if (lblNewLabel_7_1 == null) {
			lblNewLabel_7_1 = new JLabel("pic_select");
			lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_7_1.setBounds(0, 0, 67, 67);
		}
		return lblNewLabel_7_1;
	}
	private JLabel getLblNewLabel_1_7_1() {
		if (lblNewLabel_1_7_1 == null) {
			lblNewLabel_1_7_1 = new JLabel("name_select");
			lblNewLabel_1_7_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_7_1.setFont(new Font("SansSerif", Font.PLAIN, 9));
			lblNewLabel_1_7_1.setBounds(0, 70, 67, 11);
		}
		return lblNewLabel_1_7_1;
	}
	private JLabel getLblNewLabel_1_1_6_1() {
		if (lblNewLabel_1_1_6_1 == null) {
			lblNewLabel_1_1_6_1 = new JLabel("price_select");
			lblNewLabel_1_1_6_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_6_1.setFont(new Font("SansSerif", Font.BOLD, 10));
			lblNewLabel_1_1_6_1.setBounds(0, 82, 67, 11);
		}
		return lblNewLabel_1_1_6_1;
	}
	private JPanel getPnMenu02_2_1() {
		if (pnMenu02_2_1 == null) {
			pnMenu02_2_1 = new JPanel();
			pnMenu02_2_1.setLayout(null);
			pnMenu02_2_1.add(getLblNewLabel_2_2_1());
			pnMenu02_2_1.add(getLblNewLabel_1_2_2_1());
			pnMenu02_2_1.add(getLblNewLabel_1_1_1_2_1());
		}
		return pnMenu02_2_1;
	}
	private JLabel getLblNewLabel_2_2_1() {
		if (lblNewLabel_2_2_1 == null) {
			lblNewLabel_2_2_1 = new JLabel("pic_select");
			lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_2_1.setBounds(0, 0, 67, 67);
		}
		return lblNewLabel_2_2_1;
	}
	private JLabel getLblNewLabel_1_2_2_1() {
		if (lblNewLabel_1_2_2_1 == null) {
			lblNewLabel_1_2_2_1 = new JLabel("name_select");
			lblNewLabel_1_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_2_2_1.setFont(new Font("SansSerif", Font.PLAIN, 9));
			lblNewLabel_1_2_2_1.setBounds(0, 70, 67, 11);
		}
		return lblNewLabel_1_2_2_1;
	}
	private JLabel getLblNewLabel_1_1_1_2_1() {
		if (lblNewLabel_1_1_1_2_1 == null) {
			lblNewLabel_1_1_1_2_1 = new JLabel("price_select");
			lblNewLabel_1_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_1_2_1.setFont(new Font("SansSerif", Font.BOLD, 10));
			lblNewLabel_1_1_1_2_1.setBounds(0, 82, 67, 11);
		}
		return lblNewLabel_1_1_1_2_1;
	}
	private JPanel getPnMenu03_2_1() {
		if (pnMenu03_2_1 == null) {
			pnMenu03_2_1 = new JPanel();
			pnMenu03_2_1.setLayout(null);
			pnMenu03_2_1.add(getLblNewLabel_3_2_1());
			pnMenu03_2_1.add(getLblNewLabel_1_3_2_1());
			pnMenu03_2_1.add(getLblNewLabel_1_1_2_2_1());
		}
		return pnMenu03_2_1;
	}
	private JLabel getLblNewLabel_3_2_1() {
		if (lblNewLabel_3_2_1 == null) {
			lblNewLabel_3_2_1 = new JLabel("pic_select");
			lblNewLabel_3_2_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3_2_1.setBounds(0, 0, 67, 67);
		}
		return lblNewLabel_3_2_1;
	}
	private JLabel getLblNewLabel_1_3_2_1() {
		if (lblNewLabel_1_3_2_1 == null) {
			lblNewLabel_1_3_2_1 = new JLabel("name_select");
			lblNewLabel_1_3_2_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_3_2_1.setFont(new Font("SansSerif", Font.PLAIN, 9));
			lblNewLabel_1_3_2_1.setBounds(0, 70, 67, 11);
		}
		return lblNewLabel_1_3_2_1;
	}
	private JLabel getLblNewLabel_1_1_2_2_1() {
		if (lblNewLabel_1_1_2_2_1 == null) {
			lblNewLabel_1_1_2_2_1 = new JLabel("price_select");
			lblNewLabel_1_1_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_2_2_1.setFont(new Font("SansSerif", Font.BOLD, 10));
			lblNewLabel_1_1_2_2_1.setBounds(0, 82, 67, 11);
		}
		return lblNewLabel_1_1_2_2_1;
	}
	private JPanel getPnMenu04_2_1() {
		if (pnMenu04_2_1 == null) {
			pnMenu04_2_1 = new JPanel();
			pnMenu04_2_1.setLayout(null);
			pnMenu04_2_1.add(getLblNewLabel_4_2_1());
			pnMenu04_2_1.add(getLblNewLabel_1_4_2_1());
			pnMenu04_2_1.add(getLblNewLabel_1_1_3_2_1());
		}
		return pnMenu04_2_1;
	}
	private JLabel getLblNewLabel_4_2_1() {
		if (lblNewLabel_4_2_1 == null) {
			lblNewLabel_4_2_1 = new JLabel("pic_select");
			lblNewLabel_4_2_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4_2_1.setBounds(0, 0, 67, 67);
		}
		return lblNewLabel_4_2_1;
	}
	private JLabel getLblNewLabel_1_4_2_1() {
		if (lblNewLabel_1_4_2_1 == null) {
			lblNewLabel_1_4_2_1 = new JLabel("name_select");
			lblNewLabel_1_4_2_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_4_2_1.setFont(new Font("SansSerif", Font.PLAIN, 9));
			lblNewLabel_1_4_2_1.setBounds(0, 70, 67, 11);
		}
		return lblNewLabel_1_4_2_1;
	}
	private JLabel getLblNewLabel_1_1_3_2_1() {
		if (lblNewLabel_1_1_3_2_1 == null) {
			lblNewLabel_1_1_3_2_1 = new JLabel("price_select");
			lblNewLabel_1_1_3_2_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_3_2_1.setFont(new Font("SansSerif", Font.BOLD, 10));
			lblNewLabel_1_1_3_2_1.setBounds(0, 82, 67, 11);
		}
		return lblNewLabel_1_1_3_2_1;
	}
	private JPanel getPnMenu01_1_1_1() {
		if (pnMenu01_1_1_1 == null) {
			pnMenu01_1_1_1 = new JPanel();
			pnMenu01_1_1_1.setLayout(null);
			pnMenu01_1_1_1.add(getLblNewLabel_5_1_1());
			pnMenu01_1_1_1.add(getLblNewLabel_1_5_1_1());
			pnMenu01_1_1_1.add(getLblNewLabel_1_1_4_1_1());
		}
		return pnMenu01_1_1_1;
	}
	private JLabel getLblNewLabel_5_1_1() {
		if (lblNewLabel_5_1_1 == null) {
			lblNewLabel_5_1_1 = new JLabel("pic_select");
			lblNewLabel_5_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_5_1_1.setBounds(0, 0, 67, 67);
		}
		return lblNewLabel_5_1_1;
	}
	private JLabel getLblNewLabel_1_5_1_1() {
		if (lblNewLabel_1_5_1_1 == null) {
			lblNewLabel_1_5_1_1 = new JLabel("name_select");
			lblNewLabel_1_5_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_5_1_1.setFont(new Font("SansSerif", Font.PLAIN, 9));
			lblNewLabel_1_5_1_1.setBounds(0, 70, 67, 11);
		}
		return lblNewLabel_1_5_1_1;
	}
	private JLabel getLblNewLabel_1_1_4_1_1() {
		if (lblNewLabel_1_1_4_1_1 == null) {
			lblNewLabel_1_1_4_1_1 = new JLabel("price_select");
			lblNewLabel_1_1_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_4_1_1.setFont(new Font("SansSerif", Font.BOLD, 10));
			lblNewLabel_1_1_4_1_1.setBounds(0, 82, 67, 11);
		}
		return lblNewLabel_1_1_4_1_1;
	}
	private JPanel getPnMenu02_1_1_1() {
		if (pnMenu02_1_1_1 == null) {
			pnMenu02_1_1_1 = new JPanel();
			pnMenu02_1_1_1.setLayout(null);
			pnMenu02_1_1_1.add(getLblNewLabel_2_1_1_1());
			pnMenu02_1_1_1.add(getLblNewLabel_1_2_1_1_1());
			pnMenu02_1_1_1.add(getLblNewLabel_1_1_1_1_1_1());
		}
		return pnMenu02_1_1_1;
	}
	private JLabel getLblNewLabel_2_1_1_1() {
		if (lblNewLabel_2_1_1_1 == null) {
			lblNewLabel_2_1_1_1 = new JLabel("pic_select");
			lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_1_1_1.setBounds(0, 0, 67, 67);
		}
		return lblNewLabel_2_1_1_1;
	}
	private JLabel getLblNewLabel_1_2_1_1_1() {
		if (lblNewLabel_1_2_1_1_1 == null) {
			lblNewLabel_1_2_1_1_1 = new JLabel("name_select");
			lblNewLabel_1_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_2_1_1_1.setFont(new Font("SansSerif", Font.PLAIN, 9));
			lblNewLabel_1_2_1_1_1.setBounds(0, 70, 67, 11);
		}
		return lblNewLabel_1_2_1_1_1;
	}
	private JLabel getLblNewLabel_1_1_1_1_1_1() {
		if (lblNewLabel_1_1_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1_1_1 = new JLabel("price_select");
			lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_1_1_1_1.setFont(new Font("SansSerif", Font.BOLD, 10));
			lblNewLabel_1_1_1_1_1_1.setBounds(0, 82, 67, 11);
		}
		return lblNewLabel_1_1_1_1_1_1;
	}
	private JPanel getPnMenu03_1_1_1() {
		if (pnMenu03_1_1_1 == null) {
			pnMenu03_1_1_1 = new JPanel();
			pnMenu03_1_1_1.setLayout(null);
			pnMenu03_1_1_1.add(getLblNewLabel_3_1_1_1());
			pnMenu03_1_1_1.add(getLblNewLabel_1_3_1_1_1());
			pnMenu03_1_1_1.add(getLblNewLabel_1_1_2_1_1_1());
		}
		return pnMenu03_1_1_1;
	}
	private JLabel getLblNewLabel_3_1_1_1() {
		if (lblNewLabel_3_1_1_1 == null) {
			lblNewLabel_3_1_1_1 = new JLabel("pic_select");
			lblNewLabel_3_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3_1_1_1.setBounds(0, 0, 67, 67);
		}
		return lblNewLabel_3_1_1_1;
	}
	private JLabel getLblNewLabel_1_3_1_1_1() {
		if (lblNewLabel_1_3_1_1_1 == null) {
			lblNewLabel_1_3_1_1_1 = new JLabel("name_select");
			lblNewLabel_1_3_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_3_1_1_1.setFont(new Font("SansSerif", Font.PLAIN, 9));
			lblNewLabel_1_3_1_1_1.setBounds(0, 70, 67, 11);
		}
		return lblNewLabel_1_3_1_1_1;
	}
	private JLabel getLblNewLabel_1_1_2_1_1_1() {
		if (lblNewLabel_1_1_2_1_1_1 == null) {
			lblNewLabel_1_1_2_1_1_1 = new JLabel("price_select");
			lblNewLabel_1_1_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_2_1_1_1.setFont(new Font("SansSerif", Font.BOLD, 10));
			lblNewLabel_1_1_2_1_1_1.setBounds(0, 82, 67, 11);
		}
		return lblNewLabel_1_1_2_1_1_1;
	}
	private JLabel getBtnBefore() {
		if (btnBefore == null) {
			btnBefore = new JLabel("");
			btnBefore.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_before.png"));
			btnBefore.setBounds(145, 418, 24, 25);
		}
		return btnBefore;
	}
	private JLabel getLblNewLabel_1_11() {
		if (btnAfter == null) {
			btnAfter = new JLabel("");
			btnAfter.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_after.png"));
			btnAfter.setBounds(179, 418, 24, 25);
		}
		return btnAfter;
	}
	private JLabel getLblTotalPrice() {
		if (lblTotalPrice == null) {
			lblTotalPrice = new JLabel("select \"Total : 24000원\"");
			lblTotalPrice.setFont(new Font("SansSerif", Font.BOLD, 16));
			lblTotalPrice.setHorizontalAlignment(SwingConstants.TRAILING);
			lblTotalPrice.setBounds(147, 618, 211, 19);
		}
		return lblTotalPrice;
	}
	private JLabel getLblBtnGoCart() {
		if (lblBtnGoCart == null) {
			lblBtnGoCart = new JLabel("GoCartBtn");
			lblBtnGoCart.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_go_cart2.png"));
			lblBtnGoCart.setBounds(299, 644, 61, 61);
		}
		return lblBtnGoCart;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("pn바탕색넣기");
			lblNewLabel.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/inner_panel_background_menu2.png"));
			lblNewLabel.setBounds(0, 0, 345, 448);
		}
		return lblNewLabel;
	}
} // End