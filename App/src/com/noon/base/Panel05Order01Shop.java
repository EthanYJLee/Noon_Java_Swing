package com.noon.base;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.noon.dao.DaoComplete;
import com.noon.dao.DaoShop;
import com.noon.dto.DtoShop;

public class Panel05Order01Shop extends JPanel {

	private JLabel lblNewLabel_01;
	private JLabel lblNewLabel_02;
	private JLabel lblBtnSelect;
	private JLabel lblBtnTabOrder;
	private JLabel lblBtnTabMypage;
	private JLabel lblHomeIndicator;
	private JLabel lblBtnTabHome;
	private JLabel lblBtnTabGift;
	private JLabel lblBtnSidebar;
	private JLabel lblBtnBack;
	private JLabel lblProfilePhoto;
	private JPanel pnRight;
	private JLabel lblBtnShopSearch;
	private JTextField tfShopSearch;
	private JScrollPane spShopList;
	private JTable InnerTableShopList;
	private JLabel lblPn2Background;
	private JComboBox cbConditionQuery;
	private JLabel lblNewLabel_02_1;
	private JLabel lblLeftQuentity;
	private JLabel lblNewLabel;
	private JComboBox cbTimeMinute;
	private JComboBox cbTimeHour;
	private JLabel lblNewLabel_03_1;
	private JLabel lblOpenTime;
	private JLabel lblNewLabel_1;

	// static 선언부
	public static int shopcode = 0;
	public static String ordertime;
	//
	String openTime;
	String closeTime;
	int hourCheck = 0;
	int minuteCheck = 0;
	
	// static 선언부


	// -- Table Definition
	private final DefaultTableModel OuterTable = new DefaultTableModel(); // ******* 테이블 세팅(1/2)
	private DefaultTableCellRenderer cellAlignCenter = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성/ 테이블가운데정렬에 필요



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
	public Panel05Order01Shop() {

		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				tableInit(); // <--***************************************************
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});

		setBounds(0, 0, 375, 812);
		setOpaque(true);
		setLayout(null);

		add(getLblNewLabel_01());
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
		add(getLblNewLabel_02_1());
		add(getLblLeftQuentity());
		add(getCbTimeMinute());
		add(getCbTimeHour());
		add(getLblNewLabel_03_1());
		add(getLblOpenTime());
		add(getLblNewLabel_1_1());
		add(getLblNewLabel_1());
	}

	// 상단바
	// =============================================================================================================
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
			lblBtnBack.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/icon_back.png"));
			lblBtnBack.setBounds(51, 26, 32, 32);
		}
		return lblBtnBack;
	}

	private JLabel getLblNewLabel_01() {
		if (lblNewLabel_01 == null) {
			lblNewLabel_01 = new JLabel("Shop and Time");
			lblNewLabel_01.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_01.setForeground(new Color(176, 108, 89));
			lblNewLabel_01.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
			lblNewLabel_01.setBounds(84, 26, 215, 37);
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
			lblBtnTabOrder.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/tabbar_order.png"));
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
	// ==================================================================================================================

	private JLabel getLblNewLabel_02() {
		if (lblNewLabel_02 == null) {
			lblNewLabel_02 = new JLabel("매장을 선택해 주세요 !");
			lblNewLabel_02.setBounds(0, 14, 344, 22);
			lblNewLabel_02.setForeground(new Color(60, 59, 59));
			lblNewLabel_02.setFont(new Font("SansSerif", Font.BOLD, 18));
			lblNewLabel_02.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_02;
	}
	// ==================================================================================================================

	// Right Panel
	// ======================================================================================================
	private JPanel getPnRight() {
		if (pnRight == null) {
			pnRight = new JPanel();
			pnRight.setBackground(new Color(255, 0, 0, 0));
			pnRight.setOpaque(false);
			pnRight.setBackground(Color.WHITE);
			pnRight.setBounds(15, 91, 344, 319);
			pnRight.setLayout(null);
			pnRight.add(getLblNewLabel_02());
			pnRight.add(getCbConditionQuery());
			pnRight.add(getLblBtnShopSearch());
			pnRight.add(getTfShopSearch());
			pnRight.add(getSpShopList());
			pnRight.add(getLblPn2Background());
		}
		return pnRight;
	}

	private JComboBox getCbConditionQuery() {
		if (cbConditionQuery == null) {
			cbConditionQuery = new JComboBox();
			cbConditionQuery.setModel(new DefaultComboBoxModel(new String[] {"전체", "지점명", "도/광역시", "시/군/구", "동"}));
			cbConditionQuery.setForeground(new Color(176, 108, 90));
			cbConditionQuery.setBackground(new Color(255, 234, 234));
			cbConditionQuery.setBounds(10, 48, 128, 32);
		}
		return cbConditionQuery;
	}

	private JTextField getTfShopSearch() {
		if (tfShopSearch == null) {
			tfShopSearch = new JTextField();
			tfShopSearch.setBounds(137, 46, 152, 34);
			tfShopSearch.setColumns(10);
			tfShopSearch.setBackground(new Color(255, 242, 238));
		}
		return tfShopSearch;
	}

	private JLabel getLblBtnShopSearch() {
		if (lblBtnShopSearch == null) {
			lblBtnShopSearch = new JLabel("");
			lblBtnShopSearch.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					conditionQuery();
				}
			});
			lblBtnShopSearch.setHorizontalAlignment(SwingConstants.CENTER);
			lblBtnShopSearch.setBounds(291, 33, 45, 47);
			lblBtnShopSearch.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/iconSearch3.png"));
		}
		return lblBtnShopSearch;
	}

	private JScrollPane getSpShopList() {
		if (spShopList == null) {
			spShopList = new JScrollPane();
			spShopList.setBounds(9, 92, 326, 196);
			spShopList.setViewportView(getInnerTableShopList());
		}
		return spShopList;
	}

	private JTable getInnerTableShopList() {
		if (InnerTableShopList == null) {
			InnerTableShopList = new JTable();
			InnerTableShopList.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == 1) { // 좌측마우스 클릭 -> 1
						tableClick();
					}
				}
			});
			InnerTableShopList.setBackground(new Color(255, 242, 238));
			InnerTableShopList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			InnerTableShopList.setModel(OuterTable); // 테이블 세팅(2/2) **********
			cellAlignCenter.setHorizontalAlignment(JLabel.CENTER); // Center 정렬
			InnerTableShopList.getTableHeader().setDefaultRenderer(cellAlignCenter); // Center 정렬


		}
		return InnerTableShopList;
	}

	// ==================================================================================================================

	private JLabel getLblPn2Background() {
		if (lblPn2Background == null) {
			lblPn2Background = new JLabel("");
			lblPn2Background.setHorizontalAlignment(SwingConstants.CENTER);
			lblPn2Background.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/shopandtime_back1.png"));
			lblPn2Background.setBounds(0, 0, 344, 319);
		}
		return lblPn2Background;
	}
	private JLabel getLblNewLabel_02_1() {
		if (lblNewLabel_02_1 == null) {
			lblNewLabel_02_1 = new JLabel("가져갈 시간을 선택해주세요 !");
			lblNewLabel_02_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_02_1.setForeground(new Color(60, 60, 60));
			lblNewLabel_02_1.setFont(new Font("SansSerif", Font.BOLD, 18));
			lblNewLabel_02_1.setBounds(2, 443, 374, 22);
		}
		return lblNewLabel_02_1;
	}
	private JLabel getLblLeftQuentity() {
		if (lblLeftQuentity == null) {
			lblLeftQuentity = new JLabel("판매가능 잔수 : 0잔");
			lblLeftQuentity.setHorizontalAlignment(SwingConstants.CENTER);
			lblLeftQuentity.setForeground(new Color(176, 108, 89));
			lblLeftQuentity.setFont(new Font("SansSerif", Font.PLAIN, 16));
			lblLeftQuentity.setBounds(1, 550, 375, 16);
		}
		return lblLeftQuentity;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/shopandtime_back3.png"));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(15, 429, 344, 196);
		}
		return lblNewLabel;
	}
	private JComboBox getCbTimeMinute() {
		if (cbTimeMinute == null) {
			cbTimeMinute = new JComboBox();
			cbTimeMinute.setForeground(new Color(176, 108, 90));
			cbTimeMinute.setFont(new Font("SansSerif", Font.PLAIN, 16));
			cbTimeMinute.setModel(new DefaultComboBoxModel(
					new String[] {"0", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
			cbTimeMinute.setBackground(new Color(255, 234, 234));
			cbTimeMinute.setBounds(192, 477, 89, 27);
		}
		return cbTimeMinute;
	}
	private JComboBox getCbTimeHour() {
		if (cbTimeHour == null) {
			cbTimeHour = new JComboBox();
			cbTimeHour.setForeground(new Color(176, 108, 90));
			cbTimeHour.setFont(new Font("SansSerif", Font.PLAIN, 16));
			cbTimeHour.setModel(new DefaultComboBoxModel(new String[] { "시", "08", "09", "10", "11", "12", "13", "14",
					"15", "16", "17", "18", "19", "20", "21", "22" }));
			cbTimeHour.setBackground(new Color(255, 234, 234));
			cbTimeHour.setBounds(91, 477, 89, 27);
		}
		return cbTimeHour;
	}
	private JLabel getLblNewLabel_03_1() {
		if (lblNewLabel_03_1 == null) {
			lblNewLabel_03_1 = new JLabel(":");
			lblNewLabel_03_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_03_1.setForeground(new Color(176, 108, 89));
			lblNewLabel_03_1.setFont(new Font("SansSerif", Font.BOLD, 18));
			lblNewLabel_03_1.setBounds(175, 477, 20, 20);
		}
		return lblNewLabel_03_1;
	}
	private JLabel getLblOpenTime() {
		if (lblOpenTime == null) {
			lblOpenTime = new JLabel();
			lblOpenTime.setText("영업시간 : <dynamic> ~ <dynamic>");
			lblOpenTime.setHorizontalAlignment(SwingConstants.CENTER);
			lblOpenTime.setForeground(new Color(175, 107, 90));
			lblOpenTime.setFont(new Font("SansSerif", Font.BOLD, 16));
			lblOpenTime.setBounds(2, 516, 374, 22);
		}
		return lblOpenTime;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("선택시간으로부터 30분 이후에도 방문하지 않을 시 폐기됩니다.");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(14, 578, 345, 34);
		}
		return lblNewLabel_1;
	}
	
	private JLabel getLblBtnSelect() {
		if (lblBtnSelect == null) {
			lblBtnSelect = new JLabel("");
			lblBtnSelect.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ordertime = cbTimeHour.getSelectedItem().toString() + ":" + cbTimeMinute.getSelectedItem();
					System.out.println(ordertime);
					if (shopcode == 0) {
						JOptionPane.showMessageDialog(null, "지점을 선택해주세요.", "< 안 내 >", JOptionPane.ERROR_MESSAGE);
					}else if (ordertime.equals("시:0")){
						JOptionPane.showMessageDialog(null, "시간을 확인해주세요", "< 안 내 >", JOptionPane.INFORMATION_MESSAGE);
					}else {
						setVisible(false);
						Main.frame.getContentPane().add(new Panel05Order03Menu());
					}
				}

				@Override
				public void mousePressed(MouseEvent e) {
					lblBtnSelect
							.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_select_C.png"));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					lblBtnSelect
							.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_select.png"));
				}
			});
			lblBtnSelect.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_select.png"));
			lblBtnSelect.setBounds(15, 644, 345, 61);
		}
		return lblBtnSelect;
	}

	// Function

	// Init_Table / 테이블 세팅 및 정리
	private void tableInit() {
		OuterTable.addColumn("지점명"); // 1234
		OuterTable.addColumn("매장주소"); // 1234
		OuterTable.addColumn("전화번호");
		OuterTable.addColumn("오픈");
		OuterTable.addColumn("마감");

		OuterTable.setColumnCount(5); // ***************

		int i = OuterTable.getRowCount();
		for (int j = 0; j < i; j++) {
			OuterTable.removeRow(0);
		}

		InnerTableShopList.setAutoResizeMode(InnerTableShopList.AUTO_RESIZE_OFF); // 리사이즈 못하게 정의

		int vColIndex = 0;
		TableColumn col = InnerTableShopList.getColumnModel().getColumn(vColIndex); // 0번부터
		int width = 55;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = InnerTableShopList.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = InnerTableShopList.getColumnModel().getColumn(vColIndex);
		width = 90;
		col.setPreferredWidth(width);

		vColIndex = 3;
		col = InnerTableShopList.getColumnModel().getColumn(vColIndex);
		width = 40;
		col.setPreferredWidth(width);

		vColIndex = 4;
		col = InnerTableShopList.getColumnModel().getColumn(vColIndex);
		width = 40;
		col.setPreferredWidth(width);
	}

	// 검색조건
	private void conditionQuery() {
		int i = cbConditionQuery.getSelectedIndex();
		String conditionQueryColumn = "";
		switch (i) {
		case 0:
			conditionQueryColumn = "name";
			break;
		case 1:
			conditionQueryColumn = "province";
			break;
		case 2:
			conditionQueryColumn = "city";
			break;
		case 3:
			conditionQueryColumn = "town";
			break;
		default:
			break;
		}
		tableInit();
		conditionQueryAction(conditionQueryColumn);
	}

	// 검색조건과 검색명으로 검색실행 > DB에서 내용을 가져와서 테이블에 보여줌
	private void conditionQueryAction(String conditionQueryColumn) {

		DaoShop daoShop = new DaoShop(conditionQueryColumn, tfShopSearch.getText());
		ArrayList<DtoShop> dtoShopList = daoShop.conditionList();

		int listCount = dtoShopList.size();

		for (int index = 0; index < listCount; index++) {
			String[] qTxt = { dtoShopList.get(index).getName(),
					dtoShopList.get(index).getProvince() + dtoShopList.get(index).getCity()
							+ dtoShopList.get(index).getTown(),
					dtoShopList.get(index).getPhone(),
					dtoShopList.get(index).getOpentime().toString().replaceAll(":00:00", "시").replaceAll(":00", ""),
					dtoShopList.get(index).getClosetime().toString().replaceAll(":00:00", "시").replaceAll(":00", "") };
			OuterTable.addRow(qTxt);
		}
	}
	
	// 테이블클릭시 작동
	private void tableClick() {
		int i = InnerTableShopList.getSelectedRow();
		String wkName = (String) InnerTableShopList.getValueAt(i, 0); // String type으로 바꿔준다
		DaoShop daoShop = new DaoShop(wkName);

		shopcode = daoShop.tableClick();
		
		openTimeCheck(); // 운영시간 계산
		showLeftQuentity(); // 남은잔수 계산

	}
	
	// 남은잔 계산하기
	private void showLeftQuentity() {
		DaoComplete daoComplete = new DaoComplete();
		lblLeftQuentity.setText("판매가능 잔수 : " + daoComplete.selectQuantity() + "잔");
	}
	
	// 운영시간 가져오기
	private void openTimeCheck() {
		DaoShop daoShop = new DaoShop();
		daoShop.openTimeCheck();

		DtoShop dtoShop = daoShop.openTimeCheck();
		lblOpenTime.setText("영업시간 : " + dtoShop.getOpentime().toString() + " ~ " + dtoShop.getClosetime().toString());
	}
	
	
	
} // End