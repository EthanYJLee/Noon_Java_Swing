
package com.noon.main;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;

import com.noon.component.Header;
import com.noon.component.SideBarExecutive;
import com.noon.dao.DaoEmployee;
import com.noon.dao.DaoHeader;
import com.noon.event.EventCategorySelected;
import com.noon.form.executive.ExecutiveForm1;
import com.noon.form.manager.ManagerEmpty;
import com.noon.form.parttime.ParttimeForm1;
import com.noon.swing.PanelBorder;

public class Executive extends javax.swing.JFrame {

	private Header header2;
	private JPanel mainPanel;
	private PanelBorder panelBorder2;
	private SideBarExecutive sideBar1;

	ExecutiveForm1 eform1;

	ParttimeForm1 pform1;

	public Executive() {
		initComponents();
		sideBar1.initMoving(this);
		sideBar1.addEventCategorySelected(new EventCategorySelected() {
			@Override
			public void selected(int index) {
				if (index == 2) {
					setManagerForm(new ExecutiveForm1());
				} else {
					setManagerForm(new ManagerEmpty());
				}

			}
		});
	}

	private void setManagerForm(JComponent com) {
		mainPanel.removeAll();
		mainPanel.add(com);
		mainPanel.repaint();
		mainPanel.revalidate();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {
		panelBorder2 = new com.noon.swing.PanelBorder();
		sideBar1 = new com.noon.component.SideBarExecutive();
		header2 = new com.noon.component.Header();
		mainPanel = new javax.swing.JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				GradientPaint g3 = new GradientPaint(0, 0, Color.decode("#ffffff"), 0, getHeight(),
						Color.decode("#FAF3E0"));
				g2.setPaint(g3);
				g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
				super.paintComponent(g);
			}
		};
		mainPanel.setOpaque(false);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setUndecorated(true);
		setLocationRelativeTo(null);

		panelBorder2.setBackground(new java.awt.Color(255, 255, 255));

		header2.setBackground(new java.awt.Color(255, 255, 255));
		header2.setForeground(new java.awt.Color(255, 255, 255));

		mainPanel.setBackground(new Color(255, 248, 229));
		mainPanel.setLayout(new java.awt.BorderLayout());

		setStatus();

		javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
		panelBorder2.setLayout(panelBorder2Layout);
		panelBorder2Layout.setHorizontalGroup(panelBorder2Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelBorder2Layout.createSequentialGroup()
						.addComponent(sideBar1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(header2, javax.swing.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
								.addGroup(panelBorder2Layout.createSequentialGroup().addGap(6, 6, 6)
										.addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addContainerGap()))));
		panelBorder2Layout
				.setVerticalGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(sideBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
						.addGroup(panelBorder2Layout.createSequentialGroup()
								.addComponent(header2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(panelBorder2,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(panelBorder2,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
		getContentPane().setLayout(layout);
	}

	public void setStatus() {
		DaoHeader dao = new DaoHeader();
		DaoEmployee dao2 = new DaoEmployee();
		header2.getLblName().setText(dao.getName());
		header2.getLblShopName().setText("본사");
		header2.getImageAvatar2().setIcon(new ImageIcon(dao2.selectPhoto()));
		header2.getImageAvatar2().repaint();
	}

}
