package com.noon.base;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Panel05Order01Shop extends JPanel {
	
	private JLabel lblNewLabel_01;
	private JLabel lblNewLabel_02;
	private JPanel pnLeft;
	private JLabel lblNewLabel_03;
	private JLabel lblNewLabel_04;
	private JLabel lblNewLabel_05;
	private JLabel lblNewLabel_06;
	private JLabel lblBtnSelect;
	private JLabel lblBtnTabOrder;
	private JLabel lblBtnTabMypage;
	private JLabel lblHomeIndicator;
	private JLabel lblBtnTabHome;
	private JLabel lblBtnTabGift;
	private JLabel lblBtnSidebar;
	private JLabel lblBtnBack;
	private JLabel lblProfilePhoto;
	private JComboBox cbAddrSiDo;
	private JComboBox cbAddrSiGoonGoo;
	private JComboBox cbAddrDong;
	private JComboBox cbAddrShopName;
	private JPanel pnRight;
	private JLabel lblBtnShopSearch;
	private JLabel lblNewLabel_08;
	private JTextField tfShopSearch;
	private JScrollPane spShopList;
	private JTable Inner_Table_ShopList;
	private JLabel lblNewLabel_07;
	private JLabel lblPn2Background;
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
	public Panel05Order01Shop() {
		setBounds(0, 0, 375, 812);
		setOpaque(true);
		setLayout(null);
		
		add(getLblNewLabel_01());
		add(getLblNewLabel_02());
		add(getPnLeft());
		add(getPnRight());
		add(getLblHomeIndicator());
		add(getLblBtnSelect());
		add(getLblBtnTabHome());
		add(getLblBtnTabOrder());
		add(getLblBtnTabGift());
		add(getLblBtnTabMypage());
		add(getLblBtnSidebar());
		add(getLblBtnBack());
		add(getLblProfilePhoto());
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
			lblNewLabel_01 = new JLabel("매장 선택");
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

	private JLabel getLblNewLabel_02() {
		if (lblNewLabel_02 == null) {
			lblNewLabel_02 = new JLabel("방문하실 매장을 선택해 주세요 !");
			lblNewLabel_02.setForeground(new Color(176, 108, 89));
			lblNewLabel_02.setFont(new Font("SansSerif", Font.BOLD, 18));
			lblNewLabel_02.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_02.setBounds(1, 226, 374, 22);
		}
		return lblNewLabel_02;
	}

	// Left Panel =======================================================================================================
	private JPanel getPnLeft() {
		if (pnLeft == null) {
			pnLeft = new JPanel() {
				
			// 판넬 모서리 둥글게 하기 ----------------------------------------------------------------------------------------
				@Override
				protected void paintComponent(Graphics g) {
					Graphics2D g2 = (Graphics2D) g;
					g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
					g2.fillRoundRect(0, 0, getWidth() , getHeight(), 30, 30); // paint background
					super.paintComponent(g); 
				}
			};
			pnLeft.setOpaque(false);
			// -----------------------------------------------------------------------------------------------------------
			
			pnLeft.setBackground(Color.WHITE);
			pnLeft.setBounds(13, 287, 170, 223);
			pnLeft.setLayout(null);
			pnLeft.add(getLblNewLabel_2_1());
			pnLeft.add(getLblNewLabel_2_1_1());
			pnLeft.add(getLblNewLabel_05());
			pnLeft.add(getLblNewLabel_06());
			pnLeft.add(getCbAddrSiDo());
			pnLeft.add(getCbAddrSiGoonGoo());
			pnLeft.add(getCbAddrDong());
			pnLeft.add(getCbAddrShopName());
			pnLeft.add(getLblNewLabel_07());
			pnLeft.add(getLblNewLabel());
		}
		return pnLeft;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_03 == null) {
			lblNewLabel_03 = new JLabel("시/도");
			lblNewLabel_03.setForeground(new Color(176, 108, 89));
			lblNewLabel_03.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
			lblNewLabel_03.setBounds(6, 44, 33, 16);
		}
		return lblNewLabel_03;
	}
	private JLabel getLblNewLabel_2_1_1() {
		if (lblNewLabel_04 == null) {
			lblNewLabel_04 = new JLabel("시/군/구");
			lblNewLabel_04.setForeground(new Color(176, 108, 89));
			lblNewLabel_04.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
			lblNewLabel_04.setBounds(6, 94, 50, 16);
		}
		return lblNewLabel_04;
	}
	private JLabel getLblNewLabel_05() {
		if (lblNewLabel_05 == null) {
			lblNewLabel_05 = new JLabel("동");
			lblNewLabel_05.setForeground(new Color(176, 108, 89));
			lblNewLabel_05.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
			lblNewLabel_05.setBounds(6, 144, 12, 16);
		}
		return lblNewLabel_05;
	}
	private JLabel getLblNewLabel_07() {
		if (lblNewLabel_07 == null) {
			lblNewLabel_07 = new JLabel("지역으로 검색하기");
			lblNewLabel_07.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel_07.setForeground(new Color(176, 108, 89));
			lblNewLabel_07.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
			lblNewLabel_07.setBounds(55, 14, 106, 16);
		}
		return lblNewLabel_07;
	}
	private JLabel getLblNewLabel_06() {
		if (lblNewLabel_06 == null) {
			lblNewLabel_06 = new JLabel("지점명");
			lblNewLabel_06.setForeground(new Color(176, 108, 89));
			lblNewLabel_06.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
			lblNewLabel_06.setBounds(6, 189, 42, 16);
		}
		return lblNewLabel_06;
	}
	private JComboBox getCbAddrSiDo() {
		if (cbAddrSiDo == null) {
			cbAddrSiDo = new JComboBox();
			cbAddrSiDo.setModel(new DefaultComboBoxModel(new String[] {"선택", "서울시", "경기도", "강원도", "충청북도", "충청남도", "경상북도", "경상남도", "전라북도", "전라남도", "울산시", "여주시"}));
			cbAddrSiDo.setBounds(55, 38, 113, 32);
			cbAddrSiDo.setForeground(Color.decode("#B06C5A"));
			cbAddrSiDo.setBackground(Color.decode("#FFEAEA"));
		}
		return cbAddrSiDo;
	}
	private JComboBox getCbAddrSiGoonGoo() {
		if (cbAddrSiGoonGoo == null) {
			cbAddrSiGoonGoo = new JComboBox();
			cbAddrSiGoonGoo.setModel(new DefaultComboBoxModel(new String[] {"선택", "강북구", "강서구"}));
			cbAddrSiGoonGoo.setBounds(55, 82, 113, 44);
			cbAddrSiGoonGoo.setForeground(Color.decode("#B06C5A"));
			cbAddrSiGoonGoo.setBackground(Color.decode("#FFEAEA"));
		}
		return cbAddrSiGoonGoo;
	}
	private JComboBox getCbAddrDong() {
		if (cbAddrDong == null) {
			cbAddrDong = new JComboBox();
			cbAddrDong.setModel(new DefaultComboBoxModel(new String[] {"선택", "논현동"}));
			cbAddrDong.setBounds(55, 133, 113, 44);
			cbAddrDong.setForeground(Color.decode("#B06C5A"));
			cbAddrDong.setBackground(Color.decode("#FFEAEA"));
		}
		return cbAddrDong;
	}
	private JComboBox getCbAddrShopName() {
		if (cbAddrShopName == null) {
			cbAddrShopName = new JComboBox();
			cbAddrShopName.setModel(new DefaultComboBoxModel(new String[] {"선택"}));
			cbAddrShopName.setBounds(55, 177, 113, 44);
			cbAddrShopName.setForeground(Color.decode("#B06C5A"));
			cbAddrShopName.setBackground(Color.decode("#FFEAEA"));
		}
		return cbAddrShopName;
	}
	// ==================================================================================================================

	// Right Panel ======================================================================================================
	private JPanel getPnRight() {
		if (pnRight == null) {
			pnRight = new JPanel()  {
				
			// 판넬 모서리 둥글게 하기 ----------------------------------------------------------------------------------------
				@Override
				protected void paintComponent(Graphics g) {
					Graphics2D g2 = (Graphics2D) g;
					g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
					g2.setColor(getBackground()); 							  // paint background
					g2.fillRoundRect(0, 0, getWidth() , getHeight(), 30, 30); // paint background
					super.paintComponent(g); 
				}
			};
			pnLeft.setOpaque(false);
			pnRight.setOpaque(false);
			pnRight.setBackground(Color.WHITE);
			pnRight.setBounds(193, 287, 170, 223);
			pnRight.setLayout(null);
			pnRight.add(getLblBtnShopSearch());
			pnRight.add(getLblNewLabel_08());
			pnRight.add(getTfShopSearch());
			pnRight.add(getSpShopList());
			pnRight.add(getLblPn2Background());
		}
		return pnRight;
	}
	private JLabel getLblNewLabel_08() {
		if (lblNewLabel_08 == null) {
			lblNewLabel_08 = new JLabel("매장명으로 검색하기");
			lblNewLabel_08.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel_08.setBounds(47, 14, 112, 16);
			lblNewLabel_08.setForeground(new Color(172, 108, 89));
			lblNewLabel_08.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		}
		return lblNewLabel_08;
	}
	private JTextField getTfShopSearch() {
		if (tfShopSearch == null) {
			tfShopSearch = new JTextField();
			tfShopSearch.setBounds(7, 38, 156, 34);
			tfShopSearch.setColumns(10);
			tfShopSearch.setBackground(new Color(255, 242, 238));
		}
		return tfShopSearch;
	}
	private JLabel getLblBtnShopSearch() {
		if (lblBtnShopSearch == null) {
			lblBtnShopSearch = new JLabel("");
			lblBtnShopSearch.setBounds(136, 43, 28, 28);
			lblBtnShopSearch.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/icon_search.png"));
		}
		return lblBtnShopSearch;
	}
	private JScrollPane getSpShopList() {
		if (spShopList == null) {
			spShopList = new JScrollPane();
			spShopList.setBounds(9, 76, 151, 135);
			spShopList.setViewportView(getInner_Table_ShopList());
		}
		return spShopList;
	}
	private JTable getInner_Table_ShopList() {
		if (Inner_Table_ShopList == null) {
			Inner_Table_ShopList = new JTable();
			Inner_Table_ShopList.setBackground(new Color(255, 242, 238));
		}
		return Inner_Table_ShopList;
	}
	private JLabel getLblBtnSelect() {
		if (lblBtnSelect == null) {
			lblBtnSelect = new JLabel("");
			lblBtnSelect.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					Main.frame.getContentPane().add(new Panel05Order02Time());
				}
			});
			lblBtnSelect.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_select.png"));
			lblBtnSelect.setBounds(15, 644, 345, 61);
		}
		return lblBtnSelect;
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
	
	
	private JLabel getLblPn2Background() {
		if (lblPn2Background == null) {
			lblPn2Background = new JLabel("");
			lblPn2Background.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/pn_shop_background.png"));
			lblPn2Background.setBounds(0, 0, 170, 223);
		}
		return lblPn2Background;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/pn_shop_background.png"));
			lblNewLabel.setBounds(0, 0, 170, 223);
		}
		return lblNewLabel;
	}
} // End