package com.javalec.base;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.javalec.dao.DaoManage;
import com.javalec.dao.DaoShop;
import com.javalec.util.GradientBack;
import com.javalec.util.RoundedButton;

import com.javalec.util.GradientBack;
import com.javalec.util.RoundedButton;

public class LogIn extends GradientBack {
	public static String kiosk_id ;
	private JTextField tfShopNo;
	private JTextField tfManagerNo;
	public static String myBranch;
	public static int shopcode;
	

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
		lblLogo.setBounds(75, 114, 200, 200);
		add(lblLogo);

		JLabel lblStoreNo = new JLabel("키오스크ID : ");
		lblStoreNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblStoreNo.setBounds(59, 364, 82, 15);
		add(lblStoreNo);

		JLabel lblManagerId = new JLabel("키오스크PW : ");
		lblManagerId.setHorizontalAlignment(SwingConstants.CENTER);
		lblManagerId.setBounds(59, 395, 82, 15);
		add(lblManagerId);
		
		RoundedButton btnLogin = new RoundedButton();
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.setIcon(new ImageIcon(LogIn.class.getResource("/com/javalec/image/btn_login.png")));
		btnLogin.setBounds(75, 486, 200, 55);
		add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				loginAction();
				loginAction2();
			}
		});
		
	}

//	public void loginAction(){
//		int id = Integer.parseInt(tfShopNo.getText());
//		String pw = tfManagerNo.getText();
//		
//		DaoManage daoManage = new DaoManage(id, pw);
//		if(daoManage.loginAction() == 1) {
//			DaoShop daoShop = new DaoShop(id);
//			myBranch = daoShop.getMyBranch();	// 매장이름 받아옴 (myBranch)
//			shopcode = id;
//			setVisible(false);
//			Frame.frame.getContentPane().add(new Ad());
//		} else {
//			JOptionPane.showMessageDialog(null, "매장코드와 관리자ID를 확인해주세요.");
//			setVisible(true);
//		}
//	}
	
	
	public void loginAction2() {
		DaoManage daoManage = new DaoManage(tfShopNo.getText().trim(), tfManagerNo.getText().trim());
		int checkLogin = daoManage.loginAction2();
		
		if(checkLogin == 1) {
			kiosk_id = tfShopNo.getText().trim();
			int shopcode = daoManage.getShopcode();
			this.shopcode = shopcode;
			DaoShop daoShop = new DaoShop(shopcode);
			myBranch = daoShop.getMyBranch();
			setVisible(false);
			Frame.frame.getContentPane().add(new Ad());
		} else {
			JOptionPane.showMessageDialog(null, "매장코드와 관리자ID를 확인해주세요.");
			setVisible(true);
		}
	}
	
	
}