
package com.noon.main;

import javax.swing.JComponent;
import javax.swing.JPanel;

import com.noon.component.Header;
import com.noon.component.SideBar;
import com.noon.event.EventCategorySelected;
import com.noon.form.executive.ExecutiveForm1;
import com.noon.form.manager.ManagerEmpty;
import com.noon.form.manager.ManagerForm1;
import com.noon.form.manager.ManagerForm2;
import com.noon.form.manager.ManagerForm3;
import com.noon.form.parttime.ParttimeForm1;
import com.noon.swing.PanelBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Manager extends javax.swing.JFrame {

	ManagerForm1 mform1;
	ManagerForm2 mform2;
	ManagerForm3 mform3;

	ExecutiveForm1 eform1;

	ParttimeForm1 pform1;

	public Manager() {
		initComponents();
		sideBar1.initMoving(this);
		sideBar1.addEventCategorySelected(new EventCategorySelected() {
			@Override
			public void selected(int index) {
				if (index == 0 || index == 1) {
					setManagerForm(new ManagerForm1());
				} else if (index == 2) {
					setManagerForm(new ManagerForm2());
				} else if (index == 5) {
					setManagerForm(new ManagerForm3());
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
		sideBar1 = new com.noon.component.SideBar();
		header2 = new com.noon.component.Header();
		mainPanel = new javax.swing.JPanel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setUndecorated(true);
		setLocationRelativeTo(null);

		panelBorder2.setBackground(new java.awt.Color(255, 255, 255));

		header2.setBackground(new java.awt.Color(255, 255, 255));
		header2.setForeground(new java.awt.Color(255, 255, 255));

		mainPanel.setBackground(new java.awt.Color(255, 255, 255));
		mainPanel.setOpaque(false);
		mainPanel.setLayout(new java.awt.BorderLayout());

		javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
		panelBorder2Layout.setHorizontalGroup(
			panelBorder2Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(panelBorder2Layout.createSequentialGroup()
					.addComponent(sideBar1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(panelBorder2Layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(panelBorder2Layout.createSequentialGroup()
							.addGap(0)
							.addComponent(header2, GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE))
						.addGroup(panelBorder2Layout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
							.addGap(6))))
		);
		panelBorder2Layout.setVerticalGroup(
			panelBorder2Layout.createParallelGroup(Alignment.LEADING)
				.addComponent(sideBar1, GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
				.addGroup(panelBorder2Layout.createSequentialGroup()
					.addComponent(header2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelBorder2.setLayout(panelBorder2Layout);

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

	private Header header2;
	private JPanel mainPanel;
	private PanelBorder panelBorder2;
	private SideBar sideBar1;
}
