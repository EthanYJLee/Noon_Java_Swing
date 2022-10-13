package com.javalec.base;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;

import com.javalec.component.Menu;
import com.javalec.dao.DaoDetail;
import com.javalec.dto.DtoOrder;
import com.javalec.util.RoundedButton;

public class Detail extends JPanel {

	public JTextField tf1 = new JTextField();
	public JTextField tf2 = new JTextField();
	public JTextField tf3 = new JTextField();
	public JTextField tf4 = new JTextField();
	JPanel panel = new JPanel();
	JTextField tfTotalP = new JTextField();

	private int hotice;
	private int size;
	private int shot;
	private int syrup;
	private int quantity;

	public Detail() {
		
		setBackground(new Color(244, 210, 201));
		setSize(350, 700);
		setLayout(null);

		panel.setBounds(0, 155, 350, 545);
		panel.setBackground(new Color(255, 255, 255));
		add(panel);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 30, 1));
		spinner.setBounds(265, 310, 73, 22);
		panel.add(spinner);
		quantity = (Integer) spinner.getValue();
		spinner.addChangeListener(new ChangeListener(){
			public void stateChanged(javax.swing.event.ChangeEvent ce){
				quantity = (Integer) spinner.getValue();
				getPrice();
			};
		});

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
				if (tf1.getText().isBlank() || tf2.getText().isBlank() || tf3.getText().isBlank()
						|| tf4.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "옵션을 모두 선택해주십시오.");
				} else {
					if (tf4.getText() == "없음") {
						syrup = 0;
					}
					if (tf4.getText() == "헤이즐넛") {
						syrup = 1;
					}
					if (tf4.getText() == "바닐라") {
						syrup = 2;
					}
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

		JButton btn1 = new JButton("Hot");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf1.setText(e.getActionCommand());
				hotice = 0;
			}
		});
		btn1.setBounds(50, 10, 95, 35);
		panel_1.add(btn1);

		JButton btn2 = new JButton("Ice");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf1.setText(e.getActionCommand());
				hotice = 1;
			}
		});
		btn2.setBounds(180, 10, 95, 35);
		panel_1.add(btn2);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 85, 326, 65);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JButton btn3 = new JButton("Tall");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf2.setText(e.getActionCommand());
				size = 0;
				getPrice();
			}
		});
		btn3.setBounds(72, 7, 77, 23);
		panel_2.add(btn3);

		JButton btn4 = new JButton("Grande");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf2.setText(e.getActionCommand());
				size = 500;
				getPrice();
			}
		});
		btn4.setBounds(160, 7, 85, 23);
		panel_2.add(btn4);

		JButton btn5 = new JButton("Venti");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf2.setText(e.getActionCommand());
				size = 1000;
				getPrice();
			}
		});
		btn5.setBounds(253, 7, 61, 23);
		panel_2.add(btn5);

		JLabel lblNewLabel = new JLabel("+500");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(160, 40, 85, 15);
		panel_2.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("+1000");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(253, 40, 61, 15);
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_6_1 = new JLabel("사이즈");
		lblNewLabel_6_1.setBounds(0, 0, 60, 23);
		panel_2.add(lblNewLabel_6_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(12, 160, 326, 65);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JButton btn6 = new JButton("기본");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf3.setText(e.getActionCommand());
				shot = 0;
				getPrice();
			}
		});
		btn6.setBounds(68, 7, 60, 28);
		panel_3.add(btn6);

		JButton btn7 = new JButton("+1");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf3.setText(e.getActionCommand());
				shot = 500;
				getPrice();
			}
		});
		btn7.setBounds(140, 7, 50, 28);
		panel_3.add(btn7);

		JButton btn8 = new JButton("+2");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf3.setText(e.getActionCommand());
				shot = 1000;
				getPrice();
			}
		});
		btn8.setBounds(202, 7, 50, 28);
		panel_3.add(btn8);

		JButton btn9 = new JButton("+3");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf3.setText(e.getActionCommand());
				shot = 1500;
				getPrice();
			}
		});
		btn9.setBounds(264, 7, 50, 28);
		panel_3.add(btn9);

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
		lblNewLabel_6.setBounds(0, 0, 60, 23);
		panel_3.add(lblNewLabel_6);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(12, 235, 326, 65);
		panel.add(panel_4);
		panel_4.setLayout(null);

		JButton btn10 = new JButton("없음");
		btn10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf4.setText(e.getActionCommand());
				shot = 0;
				getPrice();
			}
		});
		btn10.setBounds(75, 10, 70, 28);
		panel_4.add(btn10);

		JButton btn11 = new JButton("헤이즐넛");
		btn11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf4.setText(e.getActionCommand());
				shot = 500;
				getPrice();
			}
		});
		btn11.setBounds(152, 10, 80, 28);
		panel_4.add(btn11);

		JButton btn12 = new JButton("바닐라");
		btn12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf4.setText(e.getActionCommand());
				shot = 500;
				getPrice();
			}
		});
		btn12.setBounds(239, 10, 75, 28);
		panel_4.add(btn12);

		JLabel lblNewLabel_2_1 = new JLabel("+500");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(152, 44, 80, 15);
		panel_4.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("+500");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setBounds(239, 44, 75, 15);
		panel_4.add(lblNewLabel_2_2);

		JLabel lblNewLabel_6_2 = new JLabel("시럽 추가");
		lblNewLabel_6_2.setBounds(0, 0, 60, 23);
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

		JLabel lblNewLabel_5 = new JLabel("합계 금액 : ");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(151, 373, 73, 21);
		panel.add(lblNewLabel_5);

		JLabel lblSelectedDetail = new JLabel("선택하신 옵션 : ");
		lblSelectedDetail.setBounds(12, 310, 137, 22);
		panel.add(lblSelectedDetail);

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

		String a = LogIn.myBranch;
		JLabel lblMyBranch = new JLabel("카페 눈 " + a);
		lblMyBranch.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMyBranch.setBounds(173, 10, 165, 28);
		add(lblMyBranch);

		tfTotalP.setEditable(false);
		tfTotalP.setBounds(232, 373, 106, 21);
		panel.add(tfTotalP);
	}
	

	public void insertToOrder() {
		DaoDetail dao = new DaoDetail(hotice, quantity, shot, syrup, size);
		dao.insertToOrder();
	}

	public void getPrice() {
		DaoDetail daoDetail = new DaoDetail(syrup, shot, size);
		int totalP = daoDetail.indiPrice() * quantity;
		tfTotalP.setText(Integer.toString(totalP));
	}
}
