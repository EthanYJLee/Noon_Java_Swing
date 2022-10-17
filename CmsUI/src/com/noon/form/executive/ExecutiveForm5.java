package com.noon.form.executive;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.noon.chart.ItemChartPie2;
import com.noon.chart.ModelChartLine;
import com.noon.chart.ModelChartPie;
import com.noon.chart.PanelChartLine;
import com.noon.chart.PanelChartPie;
import com.noon.dao.DaoOrder;
import com.noon.dto.DtoOrder2;

public class ExecutiveForm5 extends JPanel {
	
	// 2022.10.17
	
	PanelChartPie chartPie;
	PanelChartLine chartLine;
	JPanel panelTextPie;

	private final DefaultTableModel Outer_Table = new DefaultTableModel(); // ******** 중요 ********
	private JTable table_1; // 이너테이블

	public ExecutiveForm5() {
		setLayout(null);
		setOpaque(false);

		JPanel panelPieChart = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				GradientPaint g3 = new GradientPaint(getWidth(), 0, Color.decode("#FAF3E0"), 0, getHeight(),
						Color.decode("#F4D2C9"));
				g2.setPaint(g3);
				g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
				super.paintComponent(g);
			}
		};
		panelPieChart.setOpaque(false);
		panelPieChart.setBounds(10, 10, 368, 230);
		add(panelPieChart);

		JPanel panelLineChart = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				GradientPaint g3 = new GradientPaint(getWidth(), 0, Color.decode("#FAF3E0"), 0, getHeight(),
						Color.decode("#F4D2C9"));
				g2.setPaint(g3);
				g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
				super.paintComponent(g);
			}
		};
		panelLineChart.setOpaque(false);
		panelLineChart.setBounds(398, 10, 368, 230);

		add(panelLineChart);
		panelLineChart.setLayout(null);

		panelPieChart.setLayout(null);

		chartPie = new PanelChartPie();
		chartPie.setBounds(20, 29, 172, 172);
		panelPieChart.add(chartPie);

		panelTextPie = new JPanel();
		panelTextPie.setBounds(204, 29, 158, 172);
		panelTextPie.setOpaque(false);
		panelPieChart.add(panelTextPie);

		chartLine = new PanelChartLine();
		chartLine.setLocation(20, 29);
		chartLine.setSize(328, 172);
		panelLineChart.add(chartLine);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 250, 756, 280);
		add(scrollPane_1);

		table_1 = new JTable();
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setModel(Outer_Table); // 이너테이블과 아우터테이블 연결
		scrollPane_1.setViewportView(table_1);

		addChartPieItem();
		addChartLineItem();
		tableInit();
		searchAction();

	}

	private void addChartPieItem() {
		DaoOrder dao = new DaoOrder();
		HashMap<String, Integer> map = dao.countOrderNum7Day2();
		Set<String> mapSet = map.keySet();
		
		Color[] colorArr = new Color[7];
		colorArr[0] = new Color(217,215,241);
		colorArr[1] = new Color(255,253,222);
		colorArr[2] = new Color(231,251,190);
		colorArr[3] = new Color(255,203,203);
		colorArr[4] = new Color(255,219,164);
		colorArr[5] = new Color(255,233,174);
		colorArr[6] = new Color(193,239,255);
		int i = 0;
		
		for (String a : mapSet) {
			int num = map.get(a);
			ModelChartPie add = new ModelChartPie(a, num, colorArr[i]);
			ItemChartPie2 text = new ItemChartPie2(add);
			chartPie.addItem(add);
			panelTextPie.add(text);
			i++;
		}
	}

	private void addChartLineItem() {
		DaoOrder dao = new DaoOrder();
		HashMap<String, Integer> map = dao.countOrderNum7Day2();
		Set<String> mapSet = map.keySet();
		for (String a : mapSet) {
			int num = map.get(a);
			ModelChartLine add = new ModelChartLine(a, num);
			chartLine.addItem(add);
		}
	}

	private void tableInit() {
		// 테이블의 컬럼
		Outer_Table.addColumn("가게코드");
		Outer_Table.addColumn("매장명");
		Outer_Table.addColumn("날짜");
		Outer_Table.addColumn("메뉴이름");
		Outer_Table.addColumn("음료");
		Outer_Table.addColumn("주문건수");

		Outer_Table.setColumnCount(6);

		// table에 있는 데이터 지우기
		int a = Outer_Table.getRowCount();
		for (int i = 0; i < a; i++) {
			Outer_Table.removeRow(0); // 열이 하나씩 당겨지기 때문에
		}

		// 이너 테이블의 사이즈
		table_1.setAutoResizeMode(table_1.AUTO_RESIZE_OFF);

		// ID column
		int vColIndex = 0;
		TableColumn col = table_1.getColumnModel().getColumn(vColIndex);
		col.setPreferredWidth(75);

		vColIndex = 1;
		col = table_1.getColumnModel().getColumn(vColIndex);
		col.setPreferredWidth(125);

		vColIndex = 2;
		col = table_1.getColumnModel().getColumn(vColIndex);
		col.setPreferredWidth(150);

		vColIndex = 3;
		col = table_1.getColumnModel().getColumn(vColIndex);
		col.setPreferredWidth(150);
		
		vColIndex = 4;
		col = table_1.getColumnModel().getColumn(vColIndex);
		col.setPreferredWidth(125);
		
		vColIndex = 5;
		col = table_1.getColumnModel().getColumn(vColIndex);
		col.setPreferredWidth(125);


	}

	// DtoOrder2 사용
	private void searchAction() {
		DaoOrder dao = new DaoOrder();
		ArrayList<DtoOrder2> dtoList = dao.searchGroupByMenuAction2();
		
		for (DtoOrder2 a : dtoList) {
			String[] qTxt = {Integer.toString(a.getShopcode()), a.getName(), a.getDatepaytime() , a.getMenu_name() , Integer.toString(a.getQuantity()),Integer.toString(a.getCount())};
			Outer_Table.addRow(qTxt);
		}
	}
}
