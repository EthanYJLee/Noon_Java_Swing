package com.javalec.base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import com.javalec.component.Menu;
import com.javalec.dao.DaoCart;
import com.javalec.dao.DaoMenu;
import com.javalec.dto.DtoMenu;
import com.javalec.util.RoundedButton;

public class MenuMain extends JPanel {

	public static String menuname;

	String concategory = "";

	JPanel panel = new JPanel();

	List<Menu> menuList = new ArrayList<>();

	List<DtoMenu> specificList = new ArrayList<>();

	GridBagLayout gbl_subpanel = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();

	JPanel subpanel;

	public MenuMain() {
		setLocation(0, 0);
		setLayout(null);
		setBackground(new Color(244, 210, 201));
		setSize(350, 700);

		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 175, 350, 525);
		add(panel);
		panel.setLayout(null);

		RoundedButton btnChoose = new RoundedButton("");
		btnChoose.setBackground(new Color(255, 255, 255));
		btnChoose.setIcon(new ImageIcon(MenuMain.class.getResource("/com/javalec/image/Group 6909.png")));
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Frame.frame.getContentPane().add(new Detail());
			}
		});
		btnChoose.setBounds(12, 450, 326, 65);
		panel.add(btnChoose);

		RoundedButton btnToCart = new RoundedButton("");
		btnToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DaoCart daoCart = new DaoCart();
				if (daoCart.searchCartList() == 0) {
					JOptionPane.showMessageDialog(null, "선택한 상품이 없습니다.");
				} else {
					setVisible(false);
					Frame.frame.getContentPane().add(new Cart());
				}
			}
		});
		btnToCart.setBackground(new Color(255, 255, 255));
		btnToCart.setIcon(new ImageIcon(MenuMain.class.getResource("/com/javalec/image/Group 6910.png")));
		btnToCart.setBounds(288, 400, 50, 50);
		panel.add(btnToCart);

		subpanel = new JPanel();
		JPanel mainpanel = new JPanel(new BorderLayout());
		mainpanel.setBounds(0, 10, 350, 380);
		panel.add(mainpanel);
		mainpanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				makeGridMenuList();
			}
		});
		subpanel.setBounds(0, 10, 350, 380);

		subpanel.setLayout(gbl_subpanel);
		subpanel.setBackground(new Color(255, 248, 229));

		JScrollPane scroller = new JScrollPane(subpanel);
		scroller.setBorder(null);
		scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		mainpanel.add(scroller);

		RoundedButton btnCoffee = new RoundedButton("");
		btnCoffee.setBackground(new Color(244, 210, 201));
		btnCoffee.setIcon(new ImageIcon(MenuMain.class.getResource("/com/javalec/image/Group 6917.png")));
		btnCoffee.setFont(new Font("굴림", Font.PLAIN, 8));
		btnCoffee.setBorderPainted(false);
		btnCoffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				concategory = "= coffee";
				categorySearch();

			}
		});
		btnCoffee.setBounds(6, 61, 80, 80);
		add(btnCoffee);

		RoundedButton btnBeverage = new RoundedButton("");
		btnBeverage.setBackground(new Color(244, 210, 201));
		btnBeverage.setIcon(new ImageIcon(MenuMain.class.getResource("/com/javalec/image/Group 6918.png")));
		btnBeverage.setFont(new Font("굴림", Font.PLAIN, 8));
		btnBeverage.setBorderPainted(false);
		btnBeverage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				concategory = "= beverage";
				categorySearch();

			}
		});
		btnBeverage.setBounds(92, 61, 80, 80);
		add(btnBeverage);

		RoundedButton btnTea = new RoundedButton("");
		btnTea.setBackground(new Color(244, 210, 201));
		btnTea.setIcon(new ImageIcon(MenuMain.class.getResource("/com/javalec/image/Group 6919.png")));
		btnTea.setFont(new Font("굴림", Font.PLAIN, 8));
		btnTea.setBorderPainted(false);
		btnTea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				concategory = "= tea";
				categorySearch();

			}
		});
		btnTea.setBounds(178, 61, 80, 80);
		add(btnTea);

		RoundedButton btnShowAll = new RoundedButton("");
		btnShowAll.setBackground(new Color(244, 210, 201));
		btnShowAll.setIcon(new ImageIcon(MenuMain.class.getResource("/com/javalec/image/Group 6920.png")));
		btnShowAll.setFont(new Font("굴림", Font.PLAIN, 8));
		btnShowAll.setBorderPainted(false);
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				concategory = "is not null";
				categorySearch();

			}
		});
		btnShowAll.setBounds(264, 61, 80, 80);
		add(btnShowAll);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(MenuMain.class.getResource("/com/javalec/image/Coffee.png")));
		lblNewLabel.setBounds(6, 151, 80, 15);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MenuMain.class.getResource("/com/javalec/image/Beverage.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(92, 151, 80, 15);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MenuMain.class.getResource("/com/javalec/image/Tea.png")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(178, 151, 80, 15);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(MenuMain.class.getResource("/com/javalec/image/Menu.png")));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(264, 151, 80, 15);
		add(lblNewLabel_3);

		RoundedButton btnBack = new RoundedButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Frame.frame.getContentPane().add(new Welcome());

			}
		});
		btnBack.setBackground(new Color(244, 210, 201));
		btnBack.setIcon(new ImageIcon(MenuMain.class.getResource("/com/javalec/image/Vector.png")));
		btnBack.setBounds(12, 10, 33, 36);
		add(btnBack);
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbl_subpanel.setConstraints(scroller, gbc);

		makeGridMenuList();

		String a = LogIn.myBranch;
		JLabel lblMyBranch = new JLabel("카페 눈 " + a);
		lblMyBranch.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMyBranch.setBounds(173, 10, 165, 28);
		add(lblMyBranch);

	}

	public void make(JComponent c, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gbl_subpanel.setConstraints(c, gbc);
	}

	private void makeGridMenuList() {
		DaoMenu dao = new DaoMenu();
		menuList = dao.showMenu();
		for (int i = 0; i < menuList.size() / 2 + 1; i++) {
			for (int j = 0; j < 2; j++) {
				if (!(i == menuList.size() / 2 && j == menuList.size() % 2)) {
					make(menuList.get(i * 2 + j), j, i, 1, 1);
					menuList.get(i * 2 + j).setPreferredSize(new Dimension(120, 120));
					subpanel.add(menuList.get(i * 2 + j));
					menuList.get(i * 2 + j).addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							Menu menu = (Menu) e.getSource();
							menuname = menu.getLblMenuName().getText();
							setVisible(false);
							Frame.frame.getContentPane().add(new Detail());
						}
					});
				} else {
					break;
				}
			}
		}
	}

	private void categorySearch() {
//		DaoMenu daoMenu = new DaoMenu();
//		specificList = daoMenu.selectList(concategory);
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//

	}

	public void cartSearch() {

	}

}
