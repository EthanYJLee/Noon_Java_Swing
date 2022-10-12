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

import com.noon.dao.DaoShop;
import com.noon.dto.DtoShop;

public class Panel05Order01Shop2 extends JPanel {

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
	private JTextField tfShopSearch;
	private JScrollPane spShopList;
	private JTable InnerTableShopList;
	private JLabel lblNewLabel_07;
	private JLabel lblPn2Background;
	private JLabel lblNewLabel;
	private JComboBox cbConditionQuery;

	// static 선언자
	public static int shopcode = 0;

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
	public Panel05Order01Shop2() {

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
					Main.frame.getContentPane().add(new Panel05Order01Shop2());
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
			lblNewLabel_02.setForeground(new Color(176, 108, 89));
			lblNewLabel_02.setFont(new Font("SansSerif", Font.BOLD, 18));
			lblNewLabel_02.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_02.setBounds(1, 102, 374, 22);
		}
		return lblNewLabel_02;
	}

	// Left Panel
	// =======================================================================================================
	private JPanel getPnLeft() {
		if (pnLeft == null) {
			pnLeft = new JPanel();
			pnLeft.setBackground(new Color(255, 0, 0, 0));
			pnLeft.setBackground(Color.WHITE);
			pnLeft.setBounds(16, 148, 344, 233);
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
			lblNewLabel_03.setBounds(76, 46, 33, 16);
		}
		return lblNewLabel_03;
	}

	private JLabel getLblNewLabel_2_1_1() {
		if (lblNewLabel_04 == null) {
			lblNewLabel_04 = new JLabel("시/군/구");
			lblNewLabel_04.setForeground(new Color(176, 108, 89));
			lblNewLabel_04.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
			lblNewLabel_04.setBounds(76, 96, 50, 16);
		}
		return lblNewLabel_04;
	}

	private JLabel getLblNewLabel_05() {
		if (lblNewLabel_05 == null) {
			lblNewLabel_05 = new JLabel("동");
			lblNewLabel_05.setForeground(new Color(176, 108, 89));
			lblNewLabel_05.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
			lblNewLabel_05.setBounds(76, 146, 12, 16);
		}
		return lblNewLabel_05;
	}

	private JLabel getLblNewLabel_07() {
		if (lblNewLabel_07 == null) {
			lblNewLabel_07 = new JLabel("- 지역으로 검색하기 -");
			lblNewLabel_07.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_07.setForeground(new Color(176, 108, 89));
			lblNewLabel_07.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
			lblNewLabel_07.setBounds(0, 16, 344, 16);
		}
		return lblNewLabel_07;
	}

	private JLabel getLblNewLabel_06() {
		if (lblNewLabel_06 == null) {
			lblNewLabel_06 = new JLabel("지점명");
			lblNewLabel_06.setForeground(new Color(176, 108, 89));
			lblNewLabel_06.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
			lblNewLabel_06.setBounds(76, 191, 42, 16);
		}
		return lblNewLabel_06;
	}

	private JComboBox getCbAddrSiDo() {
		if (cbAddrSiDo == null) {
			cbAddrSiDo = new JComboBox();
			cbAddrSiDo.setModel(new DefaultComboBoxModel(new String[] { "선택", "서울시", "경기도", "강원도", "충청북도", "충청남도",
					"경상북도", "경상남도", "전라북도", "전라남도", "울산시", "여주시" }));
			cbAddrSiDo.setBounds(156, 40, 139, 32);
			cbAddrSiDo.setForeground(Color.decode("#B06C5A"));
			cbAddrSiDo.setBackground(Color.decode("#FFEAEA"));
		}
		return cbAddrSiDo;
	}

	private JComboBox getCbAddrSiGoonGoo() {
		if (cbAddrSiGoonGoo == null) {
			cbAddrSiGoonGoo = new JComboBox();
			cbAddrSiGoonGoo.setModel(new DefaultComboBoxModel(new String[] { "선택", "강북구", "강서구" }));
			cbAddrSiGoonGoo.setBounds(156, 84, 139, 44);
			cbAddrSiGoonGoo.setForeground(Color.decode("#B06C5A"));
			cbAddrSiGoonGoo.setBackground(Color.decode("#FFEAEA"));
		}
		return cbAddrSiGoonGoo;
	}

	private JComboBox getCbAddrDong() {
		if (cbAddrDong == null) {
			cbAddrDong = new JComboBox();
			cbAddrDong.setModel(new DefaultComboBoxModel(new String[] { "선택", "논현동" }));
			cbAddrDong.setBounds(156, 135, 139, 44);
			cbAddrDong.setForeground(Color.decode("#B06C5A"));
			cbAddrDong.setBackground(Color.decode("#FFEAEA"));
		}
		return cbAddrDong;
	}

	private JComboBox getCbAddrShopName() {
		if (cbAddrShopName == null) {
			cbAddrShopName = new JComboBox();
			cbAddrShopName.setModel(new DefaultComboBoxModel(new String[] { "선택" }));
			cbAddrShopName.setBounds(156, 179, 139, 44);
			cbAddrShopName.setForeground(Color.decode("#B06C5A"));
			cbAddrShopName.setBackground(Color.decode("#FFEAEA"));
		}
		return cbAddrShopName;
	}
	// ==================================================================================================================

	// Right Panel
	// ======================================================================================================
	private JPanel getPnRight() {
		if (pnRight == null) {
			pnRight = new JPanel();
			pnRight.setBackground(new Color(255, 0, 0, 0));
			pnLeft.setOpaque(false);
			pnRight.setOpaque(false);
			pnRight.setBackground(Color.WHITE);
			pnRight.setBounds(16, 395, 344, 223);
			pnRight.setLayout(null);
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
			cbConditionQuery.setBounds(9, 9, 128, 32);
		}
		return cbConditionQuery;
	}

	private JTextField getTfShopSearch() {
		if (tfShopSearch == null) {
			tfShopSearch = new JTextField();
			tfShopSearch.setBounds(136, 8, 152, 34);
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
			lblBtnShopSearch.setBounds(290, 0, 45, 47);
			lblBtnShopSearch.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/iconSearch3.png"));
		}
		return lblBtnShopSearch;
	}

	private JScrollPane getSpShopList() {
		if (spShopList == null) {
			spShopList = new JScrollPane();
			spShopList.setBounds(9, 46, 326, 166);
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

	private JLabel getLblBtnSelect() {
		if (lblBtnSelect == null) {
			lblBtnSelect = new JLabel("");
			lblBtnSelect.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (shopcode == 0) {
						JOptionPane.showMessageDialog(null, "지점을 선택해주세요.", "< 안 내 >", JOptionPane.ERROR_MESSAGE);
					} else {
						setVisible(false);
						Main.frame.getContentPane().add(new Panel05Order02Time());
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
	// ==================================================================================================================

	private JLabel getLblPn2Background() {
		if (lblPn2Background == null) {
			lblPn2Background = new JLabel("");
			lblPn2Background.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/pn2_back2.png"));
			lblPn2Background.setBounds(0, 0, 344, 223);
		}
		return lblPn2Background;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel
					.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/pn_shop_background2.png"));
			lblNewLabel.setBounds(0, 0, 344, 233);
		}
		return lblNewLabel;
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

	// 테이블클릭할때 작동 / 현 프로젝트에서는 클릭시 각각의 Tf에 해당 정보를 가져옴
	private void tableClick() {
		int i = InnerTableShopList.getSelectedRow();
		String wkName = (String) InnerTableShopList.getValueAt(i, 0); // String type으로 바꿔준다
		DaoShop daoShop = new DaoShop(wkName);

		shopcode = daoShop.tableClick();
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

} // End