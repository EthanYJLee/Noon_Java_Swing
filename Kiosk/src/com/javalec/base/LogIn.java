package com.javalec.base;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.javalec.util.GradientBack;
import com.javalec.util.RoundedButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class LogIn extends GradientBack {
	private JTextField tfShopNo;
	private JTextField tfManagerNo;
	private RoundedButton btnNewButton = new RoundedButton("");

	public LogIn() {
		setLayout(null);
		setLocation(0, 0);
		setBounds(0, 0, 350, 700);
		
		tfShopNo = new JTextField();
		tfShopNo.setBackground(new Color(176, 108, 90));
		tfShopNo.setBounds(153, 361, 130, 21);
		add(tfShopNo);
		tfShopNo.setColumns(10);
		
		tfManagerNo = new JTextField();
		tfManagerNo.setBackground(new Color(176, 108, 90));
		tfManagerNo.setColumns(10);
		tfManagerNo.setBounds(153, 392, 130, 21);
		add(tfManagerNo);
		
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon(Welcome.class.getResource("/com/javalec/image/Group 6888 (2) (1).png")));
		lblLogo.setBounds(72, 114, 200, 200);
		add(lblLogo);
		
		
		JLabel lblNewLabel = new JLabel("매장번호");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(59, 364, 82, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("관리자번호");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(59, 395, 82, 15);
		add(lblNewLabel_1);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				loginAction();
				setVisible(false);
				Frame.frame.getContentPane().add(new Ad());
			}
		});
		btnNewButton.setBackground(new Color(255,0,0,0));
		btnNewButton.setIcon(new ImageIcon(LogIn.class.getResource("/com/javalec/image/btn_login.png")));
		btnNewButton.setBounds(72, 461, 200, 100);
		add(btnNewButton);
	}
	
	private void loginAction() {

			String pw = tfManagerNo.getText();
			
			DaoMember daoMember = new DaoMember(tfShopNo.getText().trim());
			if(daoMember.checkId() == 1) {
				id = tfId.getText().trim();
				setVisible(false);
				Main.frame.getContentPane().add(new Panel03Home());
			}else {
				JOptionPane.showMessageDialog(null, "정보를 확인해주세요.", "로그인 안내", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		
		private JPasswordField getPfPw() {
			if (pfPw == null) {
				pfPw = new JPasswordField();
				pfPw.setBackground(new Color(176, 107, 89));
				pfPw.setBounds(141, 418, 203, 36);
			}
			return pfPw;
		}
	} // End

}}