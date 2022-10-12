package com.javalec.base;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.javalec.component.Menu;
import com.javalec.dao.DaoDetail;
import com.javalec.util.RoundedButton;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.SpinnerNumberModel;

public class Detail extends JPanel implements ActionListener {

	public JTextField tf1 = new JTextField();
	public JTextField tf2 = new JTextField();
	public JTextField tf3 = new JTextField();
	public JTextField tf4 = new JTextField();

	private int hotice;
	private int size;
	private int shot;
	private int syrup;
	private int quantity;
	private JTextField tfTotalP;

	public Detail() {
		setBackground(new Color(244, 210, 201));
		setSize(350, 700);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 155, 350, 545);
		panel.setBackground(new Color(255, 255, 255));
		add(panel);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 30, 1));
		spinner.setBounds(265, 310, 73, 22);
		panel.add(spinner);
		quantity = (Integer)spinner.getValue();
		
		RoundedButton btnCancelAll = new RoundedButton("");
		btnCancelAll.setBounds(12, 399, 326, 65);
		btnCancelAll.setBackground(new Color(255, 255, 255));
		btnCancelAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf1.setText(null);
				tf2.setText(null);
				tf3.setText(null);
				tf4.setText(null);
				spinner.setValue(((SpinnerNumberModel) spinner.getModel()).getMinimum());

			}
		});
		panel.setLayout(null);
		btnCancelAll.setIcon(new ImageIcon(Detail.class.getResource("/com/javalec/image/Group 69181.png")));
		panel.add(btnCancelAll);

		RoundedButton btnAddToCart = new RoundedButton("");
		btnAddToCart.setBounds(12, 470, 326, 65);
		btnAddToCart.setBackground(new Color(255, 255, 255));
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tf1.getText().isBlank()||tf2.getText().isBlank()||tf3.getText().isBlank()||tf4.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "옵션을 모두 선택해주십시오.");
				} else {
				insertToOrder();
				setVisible(false);
				Frame.frame.getContentPane().add(new Cart());
				}
			}
		});
		btnAddToCart.setIcon(new ImageIcon(Detail.class.getResource("/com/javalec/image/Group 69191.png")));
		panel.add(btnAddToCart);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 10, 326, 65);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JButton btnHot = new JButton("Hot");
		btnHot.setBounds(50, 10, 95, 35);
		btnHot.addActionListener(this);
		panel_1.add(btnHot);

		JButton btnIce = new JButton("Ice");
		btnIce.setBounds(180, 10, 95, 35);
		btnIce.addActionListener(this);
		panel_1.add(btnIce);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 85, 326, 65);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JButton btnTall = new JButton("Tall");
		btnTall.setBounds(67, 7, 77, 23);
		btnTall.addActionListener(this);
		panel_2.add(btnTall);

		JButton btnGrande = new JButton("Grande");
		btnGrande.setBounds(156, 7, 85, 23);
		btnGrande.addActionListener(this);
		panel_2.add(btnGrande);

		JButton btnVenti = new JButton("Venti");
		btnVenti.setBounds(253, 7, 61, 23);
		btnVenti.addActionListener(this);
		panel_2.add(btnVenti);
		
		JLabel lblNewLabel = new JLabel("+500");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(156, 40, 85, 15);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("+1000");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(253, 40, 61, 15);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("사이즈");
		lblNewLabel_6_1.setBounds(0, 0, 52, 23);
		panel_2.add(lblNewLabel_6_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(12, 160, 326, 65);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JButton btnNewButton_5 = new JButton("기본");
		btnNewButton_5.setBounds(68, 7, 60, 28);
		btnNewButton_5.addActionListener(this);
		panel_3.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("+1");
		btnNewButton_6.setBounds(140, 7, 50, 28);
		btnNewButton_6.addActionListener(this);
		panel_3.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("+2");
		btnNewButton_7.setBounds(202, 7, 50, 28);
		btnNewButton_7.addActionListener(this);
		panel_3.add(btnNewButton_7);

		JButton btnNewButton_8 = new JButton("+3");
		btnNewButton_8.setBounds(264, 7, 50, 28);
		btnNewButton_8.addActionListener(this);
		panel_3.add(btnNewButton_8);
		
		JLabel lblNewLabel_2 = new JLabel("+500");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(140, 40, 50, 15);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("+1000");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(202, 40, 50, 15);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("+1500");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(264, 40, 50, 15);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("샷 추가");
		lblNewLabel_6.setBounds(0, 0, 52, 23);
		panel_3.add(lblNewLabel_6);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(12, 235, 326, 65);
		panel.add(panel_4);
		panel_4.setLayout(null);

		JButton btnNewButton_9 = new JButton("없음");
		btnNewButton_9.setBounds(65, 10, 70, 28);
		btnNewButton_9.addActionListener(this);
		panel_4.add(btnNewButton_9);

		JButton btnNewButton_10 = new JButton("헤이즐넛");
		btnNewButton_10.setBounds(147, 10, 80, 28);
		btnNewButton_10.addActionListener(this);
		panel_4.add(btnNewButton_10);

		JButton btnNewButton_11 = new JButton("바닐라");
		btnNewButton_11.setBounds(239, 10, 75, 28);
		btnNewButton_11.addActionListener(this);
		panel_4.add(btnNewButton_11);
		
		JLabel lblNewLabel_2_1 = new JLabel("+500");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(147, 44, 80, 15);
		panel_4.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("+500");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setBounds(239, 44, 75, 15);
		panel_4.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_6_2 = new JLabel("시럽 추가");
		lblNewLabel_6_2.setBounds(0, 0, 52, 23);
		panel_4.add(lblNewLabel_6_2);

		tf1.setEditable(false);
		tf1.setBounds(12, 342, 73, 21);
		panel.add(tf1);
		tf1.setColumns(10);

		tf2.setEditable(false);
		tf2.setColumns(10);
		tf2.setBounds(97, 342, 73, 21);
		panel.add(tf2);

		tf3.setEditable(false);
		tf3.setColumns(10);
		tf3.setBounds(182, 342, 73, 21);
		panel.add(tf3);

		tf4.setEditable(false);
		tf4.setColumns(10);
		tf4.setBounds(265, 342, 73, 21);
		panel.add(tf4);
		
		
		
		tfTotalP = new JTextField();
		tfTotalP.setEditable(false);
		tfTotalP.setBounds(232, 373, 106, 21);
		panel.add(tfTotalP);
		tfTotalP.setColumns(10);
		
		
		
		
		
		
		
		
		
		
		
		JLabel lblNewLabel_5 = new JLabel("합계 금액 : ");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(151, 373, 73, 21);
		panel.add(lblNewLabel_5);

		RoundedButton btnBack = new RoundedButton("");
		btnBack.setBounds(12, 10, 33, 36);
		btnBack.setIcon(new ImageIcon(Detail.class.getResource("/com/javalec/image/Vector.png")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Frame.frame.getContentPane().add(new MenuMain());
			}
		});
		btnBack.setBackground(new Color(244, 210, 201));
		add(btnBack);

		Menu menu = new Menu();
		menu.getLblMenuName().setBounds(10, 120, 120, 20);
		menu.setBounds(104, 10, 140, 140);
		String filePath = "./" + MenuMain.menuname;
		menu.getLblMenuImage().setIcon(new ImageIcon(filePath));
		menu.getLblMenuName().setText(MenuMain.menuname);
		add(menu);
	}

	public void insertToOrder() {
		DaoDetail dao = new DaoDetail(hotice, quantity, syrup, shot, size);
		dao.insertToOrder();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		
		if (actionCommand.equals("Hot") || actionCommand.equals("Ice")) {
			tf1.setText(actionCommand);
		}
			if (tf1.getText() == "Hot") {
				hotice = 0;
			} else {
				hotice = 1;
			}
		
		
		if (actionCommand.equals("Tall") || actionCommand.equals("Grande") || actionCommand.equals("Venti")) {
			tf2.setText(actionCommand);
		}
			if (tf2.getText() == "Tall") {
				size = 0;
			} else if (tf2.getText() == "Grande") {
				size = 500;
			} else if (tf3.getText() == "Venti")
				size = 1000;
		

		if (actionCommand.equals("기본") || actionCommand.equals("+1") || actionCommand.equals("+2")
				|| actionCommand.equals("+3")) {
			tf3.setText(actionCommand);
		}
			if (tf3.getText() == "기본") {
				shot = 0;
			} else if (tf3.getText() == "+1") {
				shot = 500;
			} else if (tf3.getText() == "+2") {
				shot = 1000;
			} else if (tf3.getText() == "+3") {
				shot = 1500;
		}
		if (actionCommand.equals("없음") || actionCommand.equals("헤이즐넛") || actionCommand.equals("바닐라")) {
			tf4.setText(actionCommand);
		}
			if (tf4.getText() == "없음") {
				syrup = 0;
			} else if (tf4.getText() == "헤이즐넛") {
				syrup = 500;
			} else if (tf4.getText() == "바닐라") {
				syrup = 500;
			}
	}
	
	public void getPrice() {
		DaoDetail daoDetail = new DaoDetail(syrup, shot, size);
		int optionAddedP = daoDetail.indiPrice();
		int totalP = optionAddedP * quantity;
		tfTotalP.setText(Integer.toString(totalP));
	}
	
}
