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
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;



import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AppPanel05_Order05Cart extends JPanel {
	
	private AppPanel05_Order06Pay appPanel05_Order06Pay = new AppPanel05_Order06Pay();
	
	private JLabel lblNewLabel_01;
	private JLabel lblBtnTabOrder;
	private JLabel lblBtnTabMypage;
	private JLabel lblHomeIndicator;
	private JLabel lblBtnTabHome;
	private JLabel lblBtnTabGift;
	private JLabel lblBtnSidebar;
	private JLabel lblBtnBack;
	private JLabel lblProfilePhoto;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblBtnPutIn;
	
	// -- Table Definition
	private final DefaultTableModel Outer_Table = new DefaultTableModel(); // ******* 테이블 세팅(1/2)
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JLabel lblselect;
	private JLabel lblNewLabel_1;
	private JTable Inner_Table;
	
	
	


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
	public AppPanel05_Order05Cart() {
		
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				tableInit();
//				searchAction();
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});

		
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
		add(getLblHomeIndicator());
		add(getLblBtnTabMypage());
		add(getLblNewLabel_4());
		add(getLblNewLabel_5());
		add(getLblBtnPutIn());
		add(getScrollPane());
		add(getLblNewLabel());
		add(getLblselect());
		add(getLblNewLabel_1());
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
			lblNewLabel_01 = new JLabel("장바구니");
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
			lblNewLabel_5.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_use_coupon.png"));
			lblNewLabel_5.setBounds(193, 580, 167, 45);
		}
		return lblNewLabel_5;
	}
	private JLabel getLblBtnPutIn() {
		if (lblBtnPutIn == null) {
			lblBtnPutIn = new JLabel("");
			lblBtnPutIn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					AppMain.frame.getContentPane().add(appPanel05_Order06Pay);
				}
			});
			lblBtnPutIn.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_pay.png"));
			lblBtnPutIn.setBounds(15, 644, 345, 61);
		}
		return lblBtnPutIn;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 159, 335, 341);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Total :");
			lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
			lblNewLabel.setBounds(169, 512, 66, 25);
		}
		return lblNewLabel;
	}
	private JLabel getLblselect() {
		if (lblselect == null) {
			lblselect = new JLabel("금액select");
			lblselect.setHorizontalAlignment(SwingConstants.TRAILING);
			lblselect.setFont(new Font("SansSerif", Font.PLAIN, 20));
			lblselect.setBounds(233, 512, 100, 25);
		}
		return lblselect;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("원");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 20));
			lblNewLabel_1.setBounds(337, 512, 17, 25);
		}
		return lblNewLabel_1;
	}
	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
			Inner_Table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			Inner_Table.setModel(Outer_Table); // 								테이블 세팅(2/2) **********
		}
		return Inner_Table;
	}
	
	// Function
	
	// Init_Table / 테이블 세팅 및 정리
	private void tableInit() {
		Outer_Table.addColumn("상품명"); // 1234
		Outer_Table.addColumn("단가");
		Outer_Table.addColumn("수량");
		Outer_Table.addColumn("합계");
	
		Outer_Table.setColumnCount(4); // 		***************
	
		int i = Outer_Table.getRowCount();
		for (int j = 0; j < i; j++) {
			Outer_Table.removeRow(0);
		}
	
		Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF); // 리사이즈 못하게 정의
	
		int vColIndex = 0;
		TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex); // 0번부터
		int width = 150;
		col.setPreferredWidth(width);
	
		vColIndex = 1;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);
	
		vColIndex = 2;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);
	
		vColIndex = 3;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);
	
	}

	// DB to Table / DB search > select
//	private void searchAction() {
//		Dao dao = new Dao();
//		dao.selectList();
//		ArrayList<Dto> dtoList = dao.selectList(); // 		DB > Read(select)
//		
//		int listCount = dtoList.size();
//		
//		for(int index=0; index < listCount; index++) {
//			String temp = Integer.toString(dtoList.get(index).getSeqno());
//			String[] qTxt = {temp, dtoList.get(index).getName(), dtoList.get(index).getTelno(), dtoList.get(index).getRelation()};
//			Outer_Table.addRow(qTxt);
//			
//		}	
//	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} // End