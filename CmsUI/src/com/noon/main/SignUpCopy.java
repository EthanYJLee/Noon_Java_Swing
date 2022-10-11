package com.noon.main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//import com.javalec.base.Main;
//import com.javalec.base.Panel1;
//import com.javalec.dao.DaoLogin;
import com.noon.dao.DaoSignUp;

import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class SignUpCopy extends JFrame {

	private JPanel contentPane;
	private JTextField tfEmployeeNo;
	private JTextField tfName;
	private JTextField tfID;
	private JPasswordField pfPassword;
	private JPasswordField pfPasswordCheck;
	private JTextField tfStoreNo;
	
	
	public SignUpCopy() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 349, 618);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SignUpCopy.class.getResource("/com/noon/icon/frame_up.png")));
		lblNewLabel.setBounds(-6, 0, 367, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(SignUpCopy.class.getResource("/com/noon/icon/frame_down.png")));
		lblNewLabel_1.setBounds(-6, 569, 367, 49);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblEmployeeNo = new JLabel("사원번호");
		lblEmployeeNo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblEmployeeNo.setBounds(25, 114, 61, 16);
		contentPane.add(lblEmployeeNo);
		
		tfEmployeeNo = new JTextField();
		tfEmployeeNo.setBounds(25, 131, 220, 35);
		contentPane.add(tfEmployeeNo);
		tfEmployeeNo.setColumns(10);
		
		// 가입하기 버튼(label)
		JLabel lblSignUp = new JLabel("");
		
		lblSignUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 마우스를 클릭하면 로그인창을 보여줘 
				setVisible(false);
				Login login = new Login();
				login.frame.setVisible(true);
			}
		});
		
		
		
		
		lblSignUp.setIcon(new ImageIcon(SignUpCopy.class.getResource("/com/noon/icon/signin.png")));
		lblSignUp.setBounds(25, 56, 22, 44);
		contentPane.add(lblSignUp);
		
		
		
		// 이미지 줄이기 메소드
		ImageIcon icon = new ImageIcon((SignUpCopy.class.getResource("/com/noon/icon/signin.png")));
		lblSignUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(101, 44, Image.SCALE_SMOOTH);
		lblSignUp.setIcon(new ImageIcon(changeImg));
		lblSignUp.setBounds(124, 502, 101, 44);
		contentPane.add(lblSignUp);
		
		JLabel lblNewLabel_3 = new JLabel("");
		ImageIcon icon1 = new ImageIcon((SignUpCopy.class.getResource("/com/noon/icon/certify.png")));
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Image img1 = icon1.getImage();
		Image changeImg1 = img1.getScaledInstance(61, 30, Image.SCALE_SMOOTH);
		lblNewLabel_3.setIcon(new ImageIcon(changeImg1));
		lblNewLabel_3.setBounds(263, 131, 61, 30);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblEmployeeNo_1 = new JLabel("이름");
		lblEmployeeNo_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblEmployeeNo_1.setBounds(25, 175, 61, 16);
		contentPane.add(lblEmployeeNo_1);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(25, 192, 299, 35);
		contentPane.add(tfName);
		
		JLabel lblEmployeeNo_1_1 = new JLabel("ID");
		lblEmployeeNo_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblEmployeeNo_1_1.setBounds(25, 239, 61, 16);
		contentPane.add(lblEmployeeNo_1_1);
		
		tfID = new JTextField();
		tfID.setColumns(10);
		tfID.setBounds(25, 256, 299, 35);
		contentPane.add(tfID);
		
		JLabel lblNewLabel_4 = new JLabel("이미 존재하거나, 탈퇴한 아이디 입니다.");
		lblNewLabel_4.setForeground(new Color(255, 52, 32));
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(25, 286, 299, 21);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblEmployeeNo_1_1_1 = new JLabel("PW");
		lblEmployeeNo_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblEmployeeNo_1_1_1.setBounds(25, 312, 61, 16);
		contentPane.add(lblEmployeeNo_1_1_1);
		
		JLabel lblEmployeeNo_1_1_2 = new JLabel("PW 확인");
		lblEmployeeNo_1_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblEmployeeNo_1_1_2.setBounds(25, 365, 61, 16);
		contentPane.add(lblEmployeeNo_1_1_2);
		
		pfPassword = new JPasswordField();
		pfPassword.setBounds(25, 329, 299, 35);
		contentPane.add(pfPassword);
		
		pfPasswordCheck = new JPasswordField();
		pfPasswordCheck.setBounds(25, 383, 299, 35);
		contentPane.add(pfPasswordCheck);
		
		JLabel lblNewLabel_4_1 = new JLabel("비밀번호가 일치하지 않습니다.");
		lblNewLabel_4_1.setForeground(new Color(255, 52, 32));
		lblNewLabel_4_1.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_4_1.setBounds(25, 414, 299, 21);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblEmployeeNo_2 = new JLabel("가게번호");
		lblEmployeeNo_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblEmployeeNo_2.setBounds(25, 438, 61, 16);
		contentPane.add(lblEmployeeNo_2);
		
		tfStoreNo = new JTextField();
		tfStoreNo.setColumns(10);
		tfStoreNo.setBounds(25, 455, 220, 35);
		contentPane.add(tfStoreNo);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3_1.setIcon(new ImageIcon(changeImg1));
		lblNewLabel_3_1.setBounds(263, 455, 61, 30);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblBack = new JLabel("");
		lblBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Login login = new Login();
				login.frame.setVisible(true);
			}
		});
		lblBack.setIcon(new ImageIcon(SignUpCopy.class.getResource("/com/noon/icon/icon_back.png")));
		lblBack.setBounds(25, 56, 22, 44);
		contentPane.add(lblBack);
		
	}
	
	private void makeAccount() {
		DaoSignUp dao = new DaoSignUp(tfEmployeeNo.getText().trim(),tfName.getText().trim(),
				tfID.getText().trim(),pfPassword.getText().trim(),
				pfPasswordCheck.getText().trim(),tfStoreNo.getText().trim());
		boolean result = dao.makeAccount();
		if(result) {
			setVisible(false);
//			Main.frame.getContentPane().add(new Panel1());
//			Login.frame.getContentPane().add(new Login());
		}
	}
}

/*
 * 이미지 줄이는 방법
 * ImageIcon icon = new ImageIcon((SignUp.class.getResource("/com/noon/icon/signin.png")));
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(101, 44, Image.SCALE_SMOOTH);
		lblNewLabel_2.setIcon(new ImageIcon(changeImg));
*/