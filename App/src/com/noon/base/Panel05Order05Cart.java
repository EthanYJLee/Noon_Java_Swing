package com.noon.base;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.noon.dao.DaoOrder;
import com.noon.dto.DtoOrder;
import com.noon.style.Style;

public class Panel05Order05Cart extends JPanel {

	private JLabel lblNewLabel_01;
	private JLabel lblBtnTabOrder;
	private JLabel lblBtnTabMypage;
	private JLabel lblHomeIndicator;
	private JLabel lblBtnTabHome;
	private JLabel lblBtnTabGift;
	private JLabel lblBtnSidebar;
	private JLabel lblBtnBack;
	private JLabel lblProfilePhoto;
	private JLabel btnOrderMore;
	private JLabel btnUseCoupon;
	private JLabel lblBtnPutIn;

	// -- Table Definition
	private final DefaultTableModel OuterTable = new DefaultTableModel(); // ******* 테이블 세팅(1/2)
	private DefaultTableCellRenderer cellAlignCenter = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성/ 테이블가운데정렬에 필요

	private JScrollPane scrollPane;
	private JLabel lblCartTotal;
	private JTable InnerTable;

	// static
	public static int cartTotalPrice;

	private int clickedOrderno;

	// -- file 정리
	ArrayList<DtoOrder> beanList = null;
	private JLabel btnCancel;

	// 바탕화면 그라데이션
	// -------------------------------------------------------------------------------
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
	public Panel05Order05Cart() {

		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				tableInit(); // <--***************************************************
				makeTableDataCart(); // <--***************************************************
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
//				closingAction(); // <--***************************************************
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
		add(getBtnOrderMore());
		add(getBtnUseCoupon());
		add(getLblBtnPutIn());
		add(getScrollPane());
		add(getBtnCancel());
		add(getLblCartTotal());
	}

	// 상단바
	// =============================================================================================================
	private JLabel getLblBtnSidebar() {
		if (lblBtnSidebar == null) {
			lblBtnSidebar = new JLabel("");
			lblBtnSidebar.setHorizontalAlignment(SwingConstants.CENTER);
			lblBtnSidebar
					.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/icon_sidebar.png"));
			lblBtnSidebar.setBounds(13, 26, 36, 32);
		}
		return lblBtnSidebar;
	}

	private JLabel getLblBtnBack() {
		if (lblBtnBack == null) {
			lblBtnBack = new JLabel("");
			lblBtnBack.setHorizontalAlignment(SwingConstants.CENTER);
			lblBtnBack.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/icon_back.png"));
			lblBtnBack.setBounds(51, 26, 32, 32);
		}
		return lblBtnBack;
	}

	private JLabel getLblNewLabel_01() {
		if (lblNewLabel_01 == null) {
			lblNewLabel_01 = new JLabel("Cart");
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
			lblProfilePhoto
					.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/profile_photo.png"));
			lblProfilePhoto.setBounds(322, 26, 36, 36);
		}
		return lblProfilePhoto;
	}
	// ==================================================================================================================

	// Tabbar
	// ===========================================================================================================
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
			lblBtnTabHome.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/tabbar_home.png"));
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
			lblBtnTabOrder
					.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/tabbar_order.png"));
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
			lblBtnTabGift.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/tabbar_gift.png"));
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
			lblBtnTabMypage
					.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/tabbar_mypage.png"));
			lblBtnTabMypage.setBounds(281, 729, 94, 50);
		}
		return lblBtnTabMypage;
	}

	private JLabel getLblHomeIndicator() {
		if (lblHomeIndicator == null) {
			lblHomeIndicator = new JLabel("");
			lblHomeIndicator
					.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/homeindicator.png"));
			lblHomeIndicator.setBounds(1, 778, 375, 34);
		}
		return lblHomeIndicator;
	}
	// ==================================================================================================================

	private JLabel getBtnOrderMore() {
		if (btnOrderMore == null) {
			btnOrderMore = new JLabel("");
			btnOrderMore.setHorizontalAlignment(SwingConstants.CENTER);
			btnOrderMore.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					Main.frame.getContentPane().add(new Panel05Order03Menu());
				}

				@Override
				public void mousePressed(MouseEvent e) {
					btnOrderMore.setIcon(
							new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_order_more_C.png"));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					btnOrderMore.setIcon(
							new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_order_more.png"));
				}
			});
			btnOrderMore
					.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_order_more.png"));
			btnOrderMore.setBounds(15, 580, 167, 45);
		}
		return btnOrderMore;
	}

	private JLabel getBtnUseCoupon() {
		if (btnUseCoupon == null) {
			btnUseCoupon = new JLabel("");
			btnUseCoupon.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//
				}

				@Override
				public void mousePressed(MouseEvent e) {
					btnUseCoupon.setIcon(
							new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_use_coupon_C.png"));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					btnUseCoupon.setIcon(
							new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_use_coupon.png"));
				}
			});
			btnUseCoupon
					.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_use_coupon.png"));
			btnUseCoupon.setBounds(193, 580, 167, 45);
		}
		return btnUseCoupon;
	}

	private JLabel getLblBtnPutIn() {
		if (lblBtnPutIn == null) {
			lblBtnPutIn = new JLabel("");
			lblBtnPutIn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					Main.frame.getContentPane().add(new Panel05Order06Pay());
				}

				@Override
				public void mousePressed(MouseEvent e) {
					lblBtnPutIn.setIcon(
							new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_pay_C.png"));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					lblBtnPutIn
							.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_pay.png"));
				}
			});
			lblBtnPutIn.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_pay.png"));
			lblBtnPutIn.setBounds(15, 644, 345, 61);
		}
		return lblBtnPutIn;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(12, 110, 350, 400);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}

	private JLabel getLblCartTotal() {
		if (lblCartTotal == null) {
			lblCartTotal = new JLabel("");
			lblCartTotal.setHorizontalAlignment(SwingConstants.TRAILING);
			lblCartTotal.setFont(new Font("SansSerif", Font.PLAIN, 20));
			lblCartTotal.setBounds(209, 522, 149, 25);
		}
		return lblCartTotal;
	}

	private JTable getInnerTable() {
		if (InnerTable == null) {
			InnerTable = new JTable() { // <--****************
				public Class getColumnClass(int column) { // <--****************
					return (column == 0) ? Icon.class : Object.class; // <--****************
				}
			};
			InnerTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == 1) { // 좌측마우스 클릭 -> 1
						tableClick();
					}
				}
			});
			InnerTable.setBackground(new Color(253, 242, 238));
//			InnerTable.getTableHeader().setFont(new Font("San serif", Font.PLAIN, 16));
			InnerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			InnerTable.setRowHeight(80); // <--***************************************************
			InnerTable.setModel(OuterTable); // <--***************************************************

			cellAlignCenter.setHorizontalAlignment(JLabel.CENTER); // Center 정렬
			InnerTable.getTableHeader().setDefaultRenderer(cellAlignCenter); // Center 정렬
//			InnerTable.getColumn("상품명").setCellRenderer(cellAlignCenter); // 에러남 / 삭제예정

		}
		return InnerTable;
	}

	// Function

	// InitTable / 테이블 세팅 및 정리
	private void tableInit() {
		OuterTable.addColumn("사진"); // 1234
		OuterTable.addColumn("상품");
		OuterTable.addColumn("옵션");
		OuterTable.addColumn("단가");
		OuterTable.addColumn("추가");
		OuterTable.addColumn("수량");
		OuterTable.addColumn("합계");

		OuterTable.setColumnCount(7); // ***************

		int i = OuterTable.getRowCount();
		for (int j = 0; j < i; j++) {
			OuterTable.removeRow(0);
		}

		InnerTable.setAutoResizeMode(InnerTable.AUTO_RESIZE_OFF); // 리사이즈 못하게 정의

		int vColIndex = 0;
		TableColumn col = InnerTable.getColumnModel().getColumn(vColIndex); // 0번부터
		int width = 80;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = InnerTable.getColumnModel().getColumn(vColIndex);
		width = 55;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = InnerTable.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);

		vColIndex = 3;
		col = InnerTable.getColumnModel().getColumn(vColIndex);
		width = 35;
		col.setPreferredWidth(width);

		vColIndex = 4;
		col = InnerTable.getColumnModel().getColumn(vColIndex);
		width = 35;
		col.setPreferredWidth(width);

		vColIndex = 5;
		col = InnerTable.getColumnModel().getColumn(vColIndex);
		width = 30;
		col.setPreferredWidth(width);

		vColIndex = 6;
		col = InnerTable.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);
	}

	// Function
	// Cart 테이블 실행하기
	private void makeTableDataCart() {
		DaoOrder dbAction = new DaoOrder();
		beanList = dbAction.menuList();

		int listCount = beanList.size();
		String strMenuname;
		String strHotice;
		String strSize;
		int optionPrice;
		cartTotalPrice = 0;

		for (int index = 0; index < listCount; index++) {
			Style style = new Style();
			ImageIcon icon = style.imageSize80("./" + beanList.get(index).getFilename());
			// 옵션값 변환하기
			if (beanList.get(index).getHotice() == 0) {
				strHotice = "H";
			} else {
				strHotice = "I";
			}
			if (beanList.get(index).getSize() == 0) {
				strSize = "Tall";
			} else if (beanList.get(index).getSize() == 1) {
				strSize = "Regular";
			} else {
				strSize = "Grande";
			}
			// 시럽 가격 가져오기
			int tempSyrup = beanList.get(index).getSyrup();
			if (tempSyrup == 1 || tempSyrup == 2) {
				tempSyrup = 500;
			}
			// 상품정보 표현하기
			strMenuname = beanList.get(index).getSet_menu_name();
			// 옵션총합구하기
			optionPrice = beanList.get(index).getSize() + beanList.get(index).getShot() + tempSyrup;
			// 각 음료마다의 합계
			int cartPrice = (beanList.get(index).getIndiprice() + optionPrice) * beanList.get(index).getQuantity();
			// 배열로 쌓기
			Object[] tempData = { icon, strMenuname, strHotice + "/" + strSize, beanList.get(index).getIndiprice(),
					optionPrice, beanList.get(index).getQuantity(), cartPrice };
			// Row에 추가하기
			OuterTable.addRow(tempData);
			cartTotalPrice = cartTotalPrice + cartPrice;
		}
		lblCartTotal.setText("Total : " + Integer.toString(cartTotalPrice) + "원");
	}

	// 사진 삭제하기
	public void closingAction() {
//		int listCount = beanList.size();
		for (int index = 0; index < beanList.size(); index++) {
			File file = new File("./" + beanList.get(index).getFilename());
			file.delete();
		}
	}

	//
	private JLabel getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JLabel("");
			btnCancel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					deleteList();
					tableInit();
					makeTableDataCart();
				}

				@Override
				public void mousePressed(MouseEvent e) {
					btnCancel.setIcon(
							new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btnCancel_C.png"));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					btnCancel.setIcon(
							new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btnCancel.png"));
				}
			});
			btnCancel.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btnCancel.png"));
			btnCancel.setBounds(11, 510, 77, 47);
		}
		return btnCancel;
	}

	// 테이블클릭시 작동
	private void tableClick() {
		int i = InnerTable.getSelectedRow();
		String wkMenuname = (String) InnerTable.getValueAt(i, 1); // String type으로 바꿔준다
		DaoOrder daoOrder = new DaoOrder(wkMenuname);
		clickedOrderno = daoOrder.tableClick();
	}

	// 클릭한 테이블 리스트 삭제
	private void deleteList() {
		DaoOrder daoOrder = new DaoOrder(clickedOrderno);
		daoOrder.deleteAction();
	}
} // End