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
import com.noon.dao.DaoSetting;
import com.noon.dto.DtoSetting;
import com.noon.style.Style;
import javax.swing.JButton;

public class Panel05Order03Menu extends JPanel {

	private JLabel lblNewLabel_01;
	private JButton lblBtnTabOrder;
	private JButton lblBtnTabMypage;
	private JLabel lblHomeIndicator;
	private JButton lblBtnTabHome;
	private JButton lblBtnTabGift;
	private JButton lblBtnSidebar;
	private JButton lblBtnBack;
	private JLabel lblProfilePhoto;
	private JLabel lblBtnSelect;
	private JLabel lblBtnGoCart;
	private JLabel lblCategoryAllMenu;
	private JLabel lblCategoryTea;
	private JLabel lblCategoryBeverage;
	private JLabel lblCategoryCoffee;
	private JScrollPane scrollPane;
	private JTable InnerTable;
	private JLabel lblCartTotal;
	private JLabel lblShopname;
	private JLabel lblNewLabel;
	private JLabel lblBeverage;
	private JLabel lblTea;
	private JLabel lblAll;

	public static String selectedMenu;
	public static String selectedCategory;
	public static int selectedPrice;
	public static int selectedSetno;
	public static int selectedPhoto;
	
	private String clickedCategory = "";

	// -- Table Definition
	private final DefaultTableModel OuterTable = new DefaultTableModel(); // ******* 테이블 세팅(1/2)
	private DefaultTableCellRenderer cellAlignCenter = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성/ 테이블가운데정렬에 필요

	// -- file 정리
	ArrayList<DtoSetting> beanList = null;


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
	public Panel05Order03Menu() {

		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				tableInit(); // <--***************************************************
				makeTableData(); // <--***************************************************
				cartPriceInit();
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
		add(getLblBtnGoCart());
		add(getLblBtnSidebar());
		add(getLblBtnBack());

		add(getLblNewLabel_01());
		add(getLblProfilePhoto());
		add(getLblBtnTabHome());
		add(getLblBtnTabOrder());
		add(getLblBtnTabGift());
		add(getLblHomeIndicator());
		add(getLblBtnTabMypage());
		add(getScrollPane());
		add(getLblBtnSelect());
		add(getLblCategoryAllMenu());
		add(getLblCategoryTea());
		add(getLblCategoryBeverage());
		add(getLblCategoryCoffee());
		add(getLblCartTotal());
		add(getLblShopname());
		add(getLblNewLabel());
		add(getLblBeverage());
		add(getLblTea());
		add(getLblAll());
	}

	// 상단바
	// =============================================================================================================
	private JButton getLblBtnSidebar() {
		if (lblBtnSidebar == null) {
			lblBtnSidebar = new JButton("");
			lblBtnSidebar.setHorizontalAlignment(SwingConstants.CENTER);
			lblBtnSidebar
					.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/icon_sidebar.png"));
			lblBtnSidebar.setBounds(13, 26, 36, 32);
		}
		return lblBtnSidebar;
	}

	private JButton getLblBtnBack() {
		if (lblBtnBack == null) {
			lblBtnBack = new JButton("");
			lblBtnBack.setHorizontalAlignment(SwingConstants.CENTER);
			lblBtnBack.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/icon_back.png"));
			lblBtnBack.setBounds(51, 26, 32, 32);
		}
		return lblBtnBack;
	}

	private JLabel getLblNewLabel_01() {
		if (lblNewLabel_01 == null) {
			lblNewLabel_01 = new JLabel("Menu");
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
			lblHomeIndicator
					.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/homeindicator.png"));
			lblHomeIndicator.setBounds(1, 778, 375, 34);
		}
		return lblHomeIndicator;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(12, 164, 350, 448);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
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
			InnerTable.setBackground(Color.decode("#F4F4F4"));
//			InnerTable.getTableHeader().setFont(new Font("San serif", Font.PLAIN, 16));
			InnerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			InnerTable.setRowHeight(120); // <--***************************************************
			InnerTable.setModel(OuterTable); // <--***************************************************

			cellAlignCenter.setHorizontalAlignment(JLabel.CENTER); // Center 정렬
			InnerTable.getTableHeader().setDefaultRenderer(cellAlignCenter); // Center 정렬
		}
		return InnerTable;
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

				@Override
				public void mousePressed(MouseEvent e) {
					lblBtnSelect.setIcon(
							new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_select_C.png"));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					lblBtnSelect.setIcon(
							new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_select2.png"));

				}
			});
			lblBtnSelect.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_select2.png"));

			lblBtnSelect.setBounds(13, 644, 345, 61);
		}
		return lblBtnSelect;
	}

	private JLabel getLblBtnGoCart() {
		if (lblBtnGoCart == null) {
			lblBtnGoCart = new JLabel("GoCartBtn");
			lblBtnGoCart.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					Main.frame.getContentPane().add(new Panel05Order05Cart());
				}

				@Override
				public void mousePressed(MouseEvent e) {
					lblBtnGoCart.setIcon(
							new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_go_cart3_C.png"));

				}

				@Override
				public void mouseReleased(MouseEvent e) {
					lblBtnGoCart.setIcon(
							new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_go_cart3.png"));
				}
			});
			lblBtnGoCart.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_go_cart3.png"));
			lblBtnGoCart.setBounds(14, 635, 80, 80);
		}
		return lblBtnGoCart;
	}

	private JLabel getLblCartTotal() {
		if (lblCartTotal == null) {
			lblCartTotal = new JLabel("");
			lblCartTotal.setHorizontalAlignment(SwingConstants.TRAILING);
			lblCartTotal.setFont(new Font("SansSerif", Font.PLAIN, 20));
			lblCartTotal.setBounds(209, 615, 149, 25);
		}
		return lblCartTotal;
	}

	private JLabel getLblCategoryCoffee() {
		if (lblCategoryCoffee == null) {
			lblCategoryCoffee = new JLabel("");
			lblCategoryCoffee.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					clickedCategory = "coffee";
					tableInit(); 
					makeTableDataCategory(); 
				}
				@Override
				public void mousePressed(MouseEvent e) {
					lblCategoryCoffee
					.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/category_coffee1_C.png"));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblCategoryCoffee
					.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/category_coffee1.png"));
				}
			});
			lblCategoryCoffee.setVerticalAlignment(SwingConstants.TOP);
			lblCategoryCoffee
					.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/category_coffee1.png"));
			lblCategoryCoffee.setBounds(23, 78, 63, 63);
		}
		return lblCategoryCoffee;
	}

	private JLabel getLblCategoryBeverage() {
		if (lblCategoryBeverage == null) {
			lblCategoryBeverage = new JLabel("");
			lblCategoryBeverage.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					clickedCategory = "beverage";
					tableInit(); 
					makeTableDataCategory(); 
				}
				@Override
				public void mousePressed(MouseEvent e) {
					lblCategoryBeverage.setIcon(
							new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/category_beverage1_C.png"));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblCategoryBeverage.setIcon(
							new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/category_beverage1.png"));
				}
			});
			lblCategoryBeverage.setVerticalAlignment(SwingConstants.TOP);
			lblCategoryBeverage.setIcon(
					new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/category_beverage1.png"));
			lblCategoryBeverage.setBounds(111, 78, 63, 63);
		}
		return lblCategoryBeverage;
	}

	private JLabel getLblCategoryTea() {
		if (lblCategoryTea == null) {
			lblCategoryTea = new JLabel("");
			lblCategoryTea.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					clickedCategory = "tea";
					tableInit(); 
					makeTableDataCategory(); 
				}
				@Override
				public void mousePressed(MouseEvent e) {
					lblCategoryTea
					.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/category_tea1_C.png"));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblCategoryTea
					.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/category_tea1.png"));
				}
			});
			lblCategoryTea.setVerticalAlignment(SwingConstants.TOP);
			lblCategoryTea
					.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/category_tea1.png"));
			lblCategoryTea.setBounds(202, 78, 63, 63);
		}
		return lblCategoryTea;
	}

	private JLabel getLblCategoryAllMenu() {
		if (lblCategoryAllMenu == null) {
			lblCategoryAllMenu = new JLabel("");
			lblCategoryAllMenu.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					clickedCategory = "";
					tableInit(); 
					makeTableData(); 
				}
				@Override
				public void mousePressed(MouseEvent e) {
					lblCategoryAllMenu.setIcon(
							new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/category_all_menu1_C.png"));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblCategoryAllMenu.setIcon(
							new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/category_all_menu1.png"));
				}
			});
			lblCategoryAllMenu.setVerticalAlignment(SwingConstants.TOP);
			lblCategoryAllMenu.setIcon(
					new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/category_all_menu1.png"));
			lblCategoryAllMenu.setBounds(292, 78, 63, 63);
		}
		return lblCategoryAllMenu;
	}
	
	private JLabel getLblShopname() {
		if (lblShopname == null) {
			lblShopname = new JLabel(Panel05Order01Shop.shopname);
			lblShopname.setFont(new Font("SansSerif", Font.PLAIN, 16));
			lblShopname.setBounds(14, 608, 149, 25);
		}
		return lblShopname;
	}

	// Function

	// InitTable / 테이블 세팅 및 정리
	private void tableInit() {
		OuterTable.addColumn("사진"); // 1234
		OuterTable.addColumn("상품명"); // 1234
		OuterTable.addColumn("단가");
		OuterTable.setColumnCount(3); // ***************

		int i = OuterTable.getRowCount();
		for (int j = 0; j < i; j++) {
			OuterTable.removeRow(0);
		}

		InnerTable.setAutoResizeMode(InnerTable.AUTO_RESIZE_OFF); // 리사이즈 못하게 정의

		int vColIndex = 0;
		TableColumn col = InnerTable.getColumnModel().getColumn(vColIndex); // 0번부터
		int width = 120;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = InnerTable.getColumnModel().getColumn(vColIndex);
		width = 110;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = InnerTable.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);

	}

	// 전체 테이블 가져오기
	private void makeTableData() {
		DaoSetting dbAction = new DaoSetting();
		beanList = dbAction.menuList();

		int listCount = beanList.size();

		for (int index = 0; index < listCount; index++) {
			Style style = new Style();
//			style.imageSize("./" + beanList.get(index).getFilename());
			ImageIcon icon = style.imageSize120("./" + beanList.get(index).getFilename());
			System.out.println("./" + beanList.get(index).getFilename());
			Object[] tempData = { icon, beanList.get(index).getMenu_name(), beanList.get(index).getPricenow() };
			OuterTable.addRow(tempData);
		}
	}
	
	// Category별 테이블 가져오기
	private void makeTableDataCategory() {
		DaoSetting dbAction = new DaoSetting();
		beanList = dbAction.menuListCategory(clickedCategory);
		
		int listCount = beanList.size();
		
		for (int index = 0; index < listCount; index++) {
			Style style = new Style();
//			style.imageSize("./" + beanList.get(index).getFilename());
			ImageIcon icon = style.imageSize120("./" + beanList.get(index).getFilename());
			System.out.println("./" + beanList.get(index).getFilename());
			Object[] tempData = { icon, beanList.get(index).getMenu_name(), beanList.get(index).getPricenow() };
			OuterTable.addRow(tempData);
		}
	}

	public void closingAction() {
//		int listCount = beanList.size();
		for (int index = 0; index < beanList.size(); index++) {
			File file = new File("./" + beanList.get(index).getFilename());
			file.delete();
		}
	}

	// 테이블클릭하면 해당메뉴 기억하기
	private void tableClick() {
		int i = InnerTable.getSelectedRow();
		selectedMenu = (String) InnerTable.getValueAt(i, 1); // String type으로 바꿔준다
		selectedPrice = (int) InnerTable.getValueAt(i, 2); // Int type으로 바꿔준다
		DaoSetting daoSetting = new DaoSetting();
		DtoSetting dtoSetting = daoSetting.tableClick();
		selectedSetno = dtoSetting.getSetno();
		selectedCategory = dtoSetting.getCategorynow();
		selectedPhoto = dtoSetting.getFilename();
		System.out.println(selectedCategory);
	}

	// 장바구니에 담긴 합계 DB에서 가져오기
	public void cartPriceInit() {
		DaoOrder daoOrder = new DaoOrder();
		lblCartTotal.setText("Total : " + Integer.toString(daoOrder.calcTotalCart()) + "원");
	}


	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Coffee");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(23, 140, 61, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblBeverage() {
		if (lblBeverage == null) {
			lblBeverage = new JLabel("Beverage");
			lblBeverage.setHorizontalAlignment(SwingConstants.CENTER);
			lblBeverage.setBounds(95, 140, 94, 16);
		}
		return lblBeverage;
	}
	private JLabel getLblTea() {
		if (lblTea == null) {
			lblTea = new JLabel("Tea");
			lblTea.setHorizontalAlignment(SwingConstants.CENTER);
			lblTea.setBounds(203, 140, 61, 16);
		}
		return lblTea;
	}
	private JLabel getLblAll() {
		if (lblAll == null) {
			lblAll = new JLabel("All");
			lblAll.setHorizontalAlignment(SwingConstants.CENTER);
			lblAll.setBounds(293, 140, 61, 16);
		}
		return lblAll;
	}
} // End