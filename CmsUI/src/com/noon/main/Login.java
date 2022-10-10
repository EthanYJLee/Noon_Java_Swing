package com.noon.main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Login {

	JFrame frame;
	private JPanel panel;
	private JPanel panel2;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField;
	private JPasswordField passwordField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private String type = "";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		initialize();
		frame.setBackground(new Color(0, 0, 0, 0));
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);

		panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(getBackground());
				g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
				super.paintComponent(g);
			}
		};
		panel.setBackground(new Color(255, 255, 255));

		panel.setOpaque(false);

		panel2 = new JPanel() {
			protected void paintChildren(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				GradientPaint g3 = new GradientPaint(0, 0, Color.decode("#F4D2C9"), 0, getHeight(),
						Color.decode("#FAF3E0"));
				g2.setPaint(g3);
				g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
				super.paintChildren(g);
			}
		};
		
		
		panel.add(panel2);

		javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panel);
		panelBorder2Layout.setHorizontalGroup(panelBorder2Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(panelBorder2Layout.createSequentialGroup().addContainerGap()
						.addComponent(panel2, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE).addContainerGap()));
		panelBorder2Layout.setVerticalGroup(panelBorder2Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(panelBorder2Layout.createSequentialGroup().addContainerGap()
						.addComponent(panel2, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE).addContainerGap()));
		panel2.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/com/noon/icon/biglogo.png")));
		lblNewLabel.setBounds(140, 38, 94, 120);
		panel2.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(65, 225, 30, 30);
		panel2.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("PW");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(65, 267, 30, 30);
		panel2.add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(107, 225, 200, 30);
		panel2.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(107, 267, 200, 30);
		panel2.add(passwordField);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("임원");
		rdbtnNewRadioButton.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					type = "executive";					
				}
			}
		});
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(35, 180, 97, 23);
		panel2.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("관리자");
		rdbtnNewRadioButton_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rdbtnNewRadioButton_1.isSelected()) {
					type = "manager";					
				}
			}
		});
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(144, 180, 97, 23);
		panel2.add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("아르바이트");
		rdbtnNewRadioButton_2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rdbtnNewRadioButton_2.isSelected()) {
					type = "parttime";					
				}
			}
		});
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(257, 180, 97, 23);
		panel2.add(rdbtnNewRadioButton_2);

		JButton btnNewButton = new JButton("로그인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (type.equals("manager")) {
					frame.setVisible(false);
					Manager main = new Manager();
					main.setVisible(true);
					main.setBackground(new Color(0, 0, 0, 0));
					main.setLocationRelativeTo(null);
				} else if (type.equals("executive")) {
					frame.setVisible(false);
					Executive main = new Executive();
					main.setVisible(true);
					main.setBackground(new Color(0, 0, 0, 0));
					main.setLocationRelativeTo(null);
				} else if (type.equals("parttime")) {
					frame.setVisible(false);
					Parttime main = new Parttime();
					main.setVisible(true);
					main.setBackground(new Color(0, 0, 0, 0));
					main.setLocationRelativeTo(null);
				}
			}
		});
		btnNewButton.setBounds(65, 323, 117, 30);
		panel2.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("회원가입");
		btnNewButton_1.setBounds(194, 324, 117, 30);
		panel2.add(btnNewButton_1);
		panel.setLayout(panelBorder2Layout);

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		frame.getContentPane().setLayout(groupLayout);

	}
}
