package com.noon.base;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.noon.dao.DaoMember;
import com.noon.dao.DaoPoint;
import com.noon.dto.DtoMember;

import java.awt.GridLayout;
import javax.swing.JButton;

public class Panel04MyPage extends JPanel {
	
	private JLabel lblNewLabel_01;
	private JButton lblBtnTabOrder;
	private JButton lblBtnTabMypage;
	private JLabel lblHomeIndicator;
	private JButton lblBtnTabHome;
	private JButton lblBtnTabGift;
	private JLabel lblBtnSidebar;
	private JLabel lblBtnBack;
	private JLabel lblProfilePhoto;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_5_1;
	private JLabel lblNewLabel_5_2;
	private JLabel lblName;
	private JLabel lblId;
	private JLabel lblPhone;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblPurchaceHistory;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblEdit;
	private JLabel lblNewLabel_9;
	private JLabel lblCouponNum;
	private JLabel lblNewLabel_5_2_1;
	private JLabel lblPoint;

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
	public Panel04MyPage() {
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
		add(getLblNewLabel_4());
		add(getLblNewLabel_5());
		add(getLblNewLabel_5_1());
		add(getLblNewLabel_5_2());
		add(getLblName());
		add(getLblId());
		add(getLblPhone());
		add(getPanel());
		add(getLblNewLabel_5_2_1());
		add(getLblPoint());
		
		selectInfo();
	}
	
	// 상단바 =============================================================================================================
	private JLabel getLblBtnSidebar() {
		if (lblBtnSidebar == null) {
			lblBtnSidebar = new JLabel("");
			lblBtnSidebar.setHorizontalAlignment(SwingConstants.CENTER);
			lblBtnSidebar.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/icon_sidebar.png"));
			lblBtnSidebar.setBounds(13, 26, 36, 32);
		}
		return lblBtnSidebar;
	}
	private JLabel getLblBtnBack() {
		if (lblBtnBack == null) {
			lblBtnBack = new JLabel("");
			lblBtnBack.setHorizontalAlignment(SwingConstants.CENTER);
			lblBtnBack.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/Appsrc/com/noon/app/icon_back.png"));
			lblBtnBack.setBounds(51, 26, 32, 32);
		}
		return lblBtnBack;
	}
	private JLabel getLblNewLabel_01() {
		if (lblNewLabel_01 == null) {
			lblNewLabel_01 = new JLabel("내 정보");
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
			lblProfilePhoto.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/profile_photo.png"));
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
			lblBtnTabHome.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/tabbar_home.png"));
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
			lblBtnTabOrder.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/tabbar_order.png"));
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
			lblBtnTabGift.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/tabbar_gift.png"));
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
			lblBtnTabMypage.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/tabbar_mypage.png"));
			lblBtnTabMypage.setBounds(281, 729, 94, 50);
		}
		return lblBtnTabMypage;
	}
	private JLabel getLblHomeIndicator() {
		if (lblHomeIndicator == null) {
			lblHomeIndicator = new JLabel("");
			lblHomeIndicator.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/homeindicator.png"));
			lblHomeIndicator.setBounds(1, 778, 375, 34);
		}
		return lblHomeIndicator;
	}
	// ==================================================================================================================
	
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/ProfilePhotoDefault.png"));
			lblNewLabel_4.setBounds(260, 97, 100, 100);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("이름 :");
			lblNewLabel_5.setForeground(new Color(60, 60, 60));
			lblNewLabel_5.setFont(new Font("SansSerif", Font.BOLD, 16));
			lblNewLabel_5.setBounds(15, 100, 38, 24);
		}
		return lblNewLabel_5;
	}
	private JLabel getLblNewLabel_5_1() {
		if (lblNewLabel_5_1 == null) {
			lblNewLabel_5_1 = new JLabel("ID :");
			lblNewLabel_5_1.setForeground(new Color(60, 60, 60));
			lblNewLabel_5_1.setFont(new Font("SansSerif", Font.BOLD, 16));
			lblNewLabel_5_1.setBounds(16, 137, 38, 24);
		}
		return lblNewLabel_5_1;
	}
	private JLabel getLblNewLabel_5_2() {
		if (lblNewLabel_5_2 == null) {
			lblNewLabel_5_2 = new JLabel("전화번호 :");
			lblNewLabel_5_2.setForeground(new Color(60, 60, 60));
			lblNewLabel_5_2.setFont(new Font("SansSerif", Font.BOLD, 16));
			lblNewLabel_5_2.setBounds(16, 179, 67, 24);
		}
		return lblNewLabel_5_2;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("");
			lblName.setForeground(new Color(60, 60, 60));
			lblName.setFont(new Font("SansSerif", Font.BOLD, 16));
			lblName.setBounds(58, 100, 132, 24);
		}
		return lblName;
	}
	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("");
			lblId.setForeground(new Color(60, 60, 60));
			lblId.setFont(new Font("SansSerif", Font.BOLD, 16));
			lblId.setBounds(50, 137, 132, 24);
		}
		return lblId;
	}
	private JLabel getLblPhone() {
		if (lblPhone == null) {
			lblPhone = new JLabel("");
			lblPhone.setForeground(new Color(60, 60, 60));
			lblPhone.setFont(new Font("SansSerif", Font.BOLD, 16));
			lblPhone.setBounds(87, 179, 132, 24);
		}
		return lblPhone;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(15, 285, 345, 385);
			panel.setLayout(new GridLayout(0, 1, 0, 12));
			panel.setBackground(new Color(255, 0, 0, 0)); // Panel 투명하게하기
			panel.add(getPanel_1());
			panel.add(getLblPurchaceHistory());
			panel.add(getLblNewLabel_3());
			panel.add(getLblNewLabel_6());
			panel.add(getLblNewLabel_7());
			panel.add(getLblEdit());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getLblNewLabel_9());
			panel_1.add(getLblCouponNum());
			panel_1.setBackground(new Color(255, 0, 0, 0)); // Panel 투명하게하기
		}
		return panel_1;
	}
	private JLabel getLblPurchaceHistory() {
		if (lblPurchaceHistory == null) {
			lblPurchaceHistory = new JLabel("");
			lblPurchaceHistory.setHorizontalAlignment(SwingConstants.CENTER);
			lblPurchaceHistory.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/mypage_history.png"));
		}
		return lblPurchaceHistory;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/mypage_notice.png"));
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("");
			lblNewLabel_6.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/mypage_write.png"));
			lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_6;
	}
	private JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("");
			lblNewLabel_7.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/mypage_favorite.png"));
			lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_7;
	}
	private JLabel getLblEdit() {
		if (lblEdit == null) {
			lblEdit = new JLabel("");
			lblEdit.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/mypage_edit.png"));
			lblEdit.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblEdit;
	}
	private JLabel getLblNewLabel_9() {
		if (lblNewLabel_9 == null) {
			lblNewLabel_9 = new JLabel("");
			lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_9.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/mypage_coupon1.png"));
			lblNewLabel_9.setBounds(0, 0, 345, 54);
		}
		return lblNewLabel_9;
	}
	private JLabel getLblCouponNum() {
		if (lblCouponNum == null) {
			lblCouponNum = new JLabel("10");
			lblCouponNum.setForeground(new Color(60, 60, 60));
			lblCouponNum.setFont(new Font("SansSerif", Font.BOLD, 20));
			lblCouponNum.setHorizontalAlignment(SwingConstants.TRAILING);
			lblCouponNum.setBounds(206, 5, 34, 42);
		}
		return lblCouponNum;
	}
	private JLabel getLblNewLabel_5_2_1() {
		if (lblNewLabel_5_2_1 == null) {
			lblNewLabel_5_2_1 = new JLabel("적립금 : ");
			lblNewLabel_5_2_1.setForeground(new Color(60, 60, 60));
			lblNewLabel_5_2_1.setFont(new Font("SansSerif", Font.BOLD, 16));
			lblNewLabel_5_2_1.setBounds(16, 221, 67, 24);
		}
		return lblNewLabel_5_2_1;
	}
	private JLabel getLblPoint() {
		if (lblPoint == null) {
			lblPoint = new JLabel("");
			lblPoint.setForeground(new Color(60, 60, 60));
			lblPoint.setFont(new Font("SansSerif", Font.BOLD, 16));
			lblPoint.setBounds(76, 221, 112, 24);
		}
		return lblPoint;
	}
	
	// Function
	
	private void selectInfo() {
		DaoMember daoMember = new DaoMember();
		daoMember.selectInfo();
		DtoMember dtoMember = daoMember.selectInfo();
		
		DaoPoint daoPoint = new DaoPoint();
	}
	
	
	
	

} // End