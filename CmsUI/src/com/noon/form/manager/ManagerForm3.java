package com.noon.form.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.noon.component.Menu;

public class ManagerForm3 extends JPanel {

	// 여기에 메뉴가 들어온다.
	List<Menu> menuList = new ArrayList<>();

	GridBagLayout grid = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();

	public ManagerForm3() {
		setBackground(Color.WHITE);
		setLayout(null);

		JButton btnMenuInsert = new JButton("메뉴 추가");
		btnMenuInsert.setBackground(Color.RED);
		btnMenuInsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				ManagerForm5 form5 = new ManagerForm5();
				form5.setVisible(true);
			}
		});
		btnMenuInsert.setBounds(610, 32, 123, 54);
		add(btnMenuInsert);

		JLabel lblNewLabel = new JLabel("메뉴 추가 / 수정 / 삭제");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 26));
		lblNewLabel.setBounds(37, 32, 265, 54);
		add(lblNewLabel);

		JPanel panel = new JPanel();
		JPanel mainpanel = new JPanel(new BorderLayout());
		panel.setBounds(37, 118, 700, 400);
		mainpanel.setBounds(37, 118, 700, 400);
		add(mainpanel);

		panel.setLayout(grid);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;

		JScrollPane scroller = new JScrollPane(panel);
		scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		grid.setConstraints(scroller, gbc);
		mainpanel.add(scroller);
		// menulist menu panel 추가시키기
		for (int i = 0; i < 40; i++) {
			menuList.add(new Menu(new ImageIcon(getClass().getResource("/com/noon/icon/1.png"))));
		}

		// girdbaglayout에 담기 
		for (int i = 0; i < menuList.size() / 7 + 1; i++) {
			for (int j = 0; j < 7; j++) {
				if (!(i == menuList.size() / 7 && j == menuList.size() % 7)) {
					make(menuList.get(i * 7 + j), j, i, 1, 1);
					menuList.get(i * 7 + j).setPreferredSize(new Dimension(90, 90));
					panel.add(menuList.get(i * 7 + j));
					menuList.get(i*7 + j).addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						setVisible(false);
						ManagerForm4 form4 = new ManagerForm4();
						form4.setVisible(true);
					}
				});
				} else {
					break;
				}
			}
		}

	}

	public void make(JComponent c, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		grid.setConstraints(c, gbc);
	}

	@Override
	protected void paintChildren(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setPaint(new Color(255, 255, 255, 100));
		super.paintChildren(g);
	}
}