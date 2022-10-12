package com.noon.base;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.noon.dao.DaoMember;

public class Panel02SignUp extends JPanel {

	private JTextField tfName;
	private JLabel lblNewLabel;
	private JLabel lblBtnToLoginPage;
	private JLabel lblLogo;
	private JTextField tfId;
	private JLabel lblId;
	private JLabel lblNewLabel_2;
	private JLabel lblPassword;
	private JLabel lblPassword_1;
	private JLabel lblBtnSingup;
	private JTextField tfPhone;
	private JLabel lbl123;
	private JLabel lblCheckPw2;
	private JPasswordField pfPw1;
	private JPasswordField pfPw2;
	private JLabel lblCheckPw1;

	// 바탕화면 그라데이션
	// -------------------------------------------------------------------------------
	@Override
	protected void paintChildren(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint g3 = new GradientPaint(0, 0, Color.decode("#F4D2C9"), 0, getHeight(), Color.decode("#FAF3E0"));
		g2.setPaint(g3);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
		super.paintChildren(g);
	}
	// ----------------------------------------------------------------------------------------------

	/**
	 * Create the panel.
	 */
	public Panel02SignUp() {

		setBounds(0, 0, 375, 812);
		setOpaque(true);
		setLayout(null);

		add(getTfName());
		add(getLblNewLabel());
		add(getLblNewLabel_2());
		add(getLblPassword());
		add(getLblPassword_1());
		add(getLbl123());
		add(getLblId());
		add(getLblLogo());
		add(getTfId());
		add(getPfPw1());
		add(getLblCheckPw1());
		add(getPfPw2());
		add(getLblCheckPw2());
		add(getTfPhone());
		add(getLblBtnSingup());
		add(getLblBtnToLoginPage());

	}

	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setColumns(10);
			tfName.setBackground(new Color(176, 108, 89));
			tfName.setBounds(140, 355, 116, 32);
		}
		return tfName;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("이름");
			lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel.setForeground(new Color(176, 108, 89));
			lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
			lblNewLabel.setBounds(74, 359, 61, 25);
		}
		return lblNewLabel;
	}

	private JLabel getLblBtnToLoginPage() {
		if (lblBtnToLoginPage == null) {
			lblBtnToLoginPage = new JLabel("Login 화면으로 돌아가기");
			lblBtnToLoginPage.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					Main.frame.getContentPane().add(new Panel01Login());
				}
			});
			lblBtnToLoginPage.setHorizontalAlignment(SwingConstants.CENTER);
			lblBtnToLoginPage.setForeground(new Color(176, 108, 89));
			lblBtnToLoginPage.setFont(new Font("SansSerif", Font.PLAIN, 14));
			lblBtnToLoginPage.setBounds(115, 742, 144, 18);
		}
		return lblBtnToLoginPage;
	}

	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/logo.png"));
			lblLogo.setBounds(101, 126, 172, 172);
		}
		return lblLogo;
	}

	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setColumns(10);
			tfId.setBackground(new Color(176, 108, 89));
			tfId.setBounds(140, 406, 143, 32);
		}
		return tfId;
	}

	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID");
			lblId.setHorizontalAlignment(SwingConstants.TRAILING);
			lblId.setForeground(new Color(176, 108, 89));
			lblId.setFont(new Font("SansSerif", Font.PLAIN, 18));
			lblId.setBounds(74, 409, 61, 25);
		}
		return lblId;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("New label");
			lblNewLabel_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					checkIdOverlap();
				}
			});
			lblNewLabel_2.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_ID_overlap.png"));
			lblNewLabel_2.setBounds(280, 410, 66, 25);
		}
		return lblNewLabel_2;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
			lblPassword.setForeground(new Color(176, 108, 89));
			lblPassword.setFont(new Font("SansSerif", Font.PLAIN, 18));
			lblPassword.setBounds(19, 461, 116, 25);
		}
		return lblPassword;
	}

	private JLabel getLblPassword_1() {
		if (lblPassword_1 == null) {
			lblPassword_1 = new JLabel("Password확인");
			lblPassword_1.setHorizontalAlignment(SwingConstants.TRAILING);
			lblPassword_1.setForeground(new Color(176, 108, 89));
			lblPassword_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
			lblPassword_1.setBounds(19, 514, 116, 25);
		}
		return lblPassword_1;
	}

	private JLabel getLblBtnSingup() {
		if (lblBtnSingup == null) {
			lblBtnSingup = new JLabel("");
			lblBtnSingup.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int i_chk = insertFieldCheck();
					if (i_chk == 0) {
						signUpAction();
					}
				}

				@Override
				public void mousePressed(MouseEvent e) {
					lblBtnSingup.setIcon(
							new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_signup2_C.png"));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					lblBtnSingup
							.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_signup2.png"));
				}
			});
			lblBtnSingup.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_signup2.png"));
			lblBtnSingup.setBounds(100, 662, 174, 49);
		}
		return lblBtnSingup;
	}

	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setColumns(10);
			tfPhone.setBackground(new Color(176, 108, 89));
			tfPhone.setBounds(140, 563, 209, 32);
		}
		return tfPhone;
	}

	private JLabel getLbl123() {
		if (lbl123 == null) {
			lbl123 = new JLabel("전화번호");
			lbl123.setHorizontalAlignment(SwingConstants.TRAILING);
			lbl123.setForeground(new Color(176, 108, 89));
			lbl123.setFont(new Font("SansSerif", Font.PLAIN, 18));
			lbl123.setBounds(69, 565, 66, 25);
		}
		return lbl123;
	}

	private JLabel getLblCheckPw1() {
		if (lblCheckPw1 == null) {
			lblCheckPw1 = new JLabel("");
			lblCheckPw1.setForeground(Color.RED);
			lblCheckPw1.setBounds(143, 487, 203, 16);
		}
		return lblCheckPw1;
	}

	private JLabel getLblCheckPw2() {
		if (lblCheckPw2 == null) {
			lblCheckPw2 = new JLabel("");
			lblCheckPw2.setForeground(Color.RED);
			lblCheckPw2.setBounds(143, 540, 203, 16);
		}
		return lblCheckPw2;
	}

	// Function
	private void checkIdOverlap() {
		DaoMember daoMember = new DaoMember(tfId.getText().trim());
		if (daoMember.checkIdOverlap() == 0) {
			JOptionPane.showMessageDialog(null, "사용가능한 ID입니다.", "중복확인 안내", JOptionPane.INFORMATION_MESSAGE);
			pfPw1.requestFocus();
		} else {
			JOptionPane.showMessageDialog(null, "사용할 수 없는 ID입니다.", "중복확인 안내", JOptionPane.INFORMATION_MESSAGE);
			tfId.requestFocus();
			tfId.setText("");
		}
	}

	private JPasswordField getPfPw1() {
		if (pfPw1 == null) {
			pfPw1 = new JPasswordField();
			pfPw1.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					checkPw1();
				}
			});
			pfPw1.setBackground(new Color(176, 107, 89));
			pfPw1.setBounds(140, 458, 209, 32);
		}
		return pfPw1;
	}

	private JPasswordField getPfPw2() {
		if (pfPw2 == null) {
			pfPw2 = new JPasswordField();
			pfPw2.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					checkPw2();
				}
			});
			pfPw2.setBackground(new Color(176, 107, 89));
			pfPw2.setBounds(140, 511, 209, 32);
		}
		return pfPw2;
	}

	// 사용자의 패스워드가 DB에 있는지 확인할때 사용
	private void checkPw1() {
		char[] pw1 = pfPw1.getPassword();
		String pw1String = new String(pw1); // char[] -> String 변환
		pw1String = pw1String.replaceAll(" ", "");

		if (pw1String.length() >= 4 && pw1String.length() <= 10) {
			lblCheckPw1.setText("사용가능한 Password입니다.");
			lblCheckPw1.setForeground(Color.BLUE);
		} else if (pw1String.length() == 0) {
			lblCheckPw1.setText("Password를 입력해주세요.");
			lblCheckPw1.setForeground(Color.BLACK);
		} else {
			lblCheckPw1.setText("4~8자리 Password만 가능합니다.");
			lblCheckPw1.setForeground(Color.RED);
		}
	}

	// 암호 확인
	private void checkPw2() {
		char[] pw1 = pfPw1.getPassword();
		String pw1String = new String(pw1); // char[] -> String 변환
		pw1String = pw1String.replaceAll(" ", "");

		char[] pw2 = pfPw2.getPassword();
		String pw2String = new String(pw2); // char[] -> String 변환
		pw2String = pw2String.replaceAll(" ", "");

		if (pw1String.equals(pw2String)) {
			lblCheckPw2.setText("일치합니다.");
			lblCheckPw2.setForeground(Color.BLUE);
		} else if (pw2String.length() == 0) {
			lblCheckPw2.setText("");
			lblCheckPw2.setForeground(Color.BLACK);
		} else {
			lblCheckPw2.setText("일치하지 않습니다.");
			lblCheckPw2.setForeground(Color.RED);
		}
	}

	// 입력항목 Check
	private int insertFieldCheck() {
		int i = 0;
		String message = "";

		if (tfPhone.getText().trim().length() == 0) {
			i++;
			message = "전화번호를 ";
			tfPhone.requestFocus();
		}

		// 비밀번호 char -> String 변환
		char[] pw1 = pfPw1.getPassword();
		String pw1String = new String(pw1); // char[] -> String 변환
		pw1String = pw1String.replaceAll(" ", "");

		char[] pw2 = pfPw2.getPassword();
		String pw2String = new String(pw2); // char[] -> String 변환
		pw2String = pw2String.replaceAll(" ", "");
		// ------------------------

		if (pw2String.trim().length() == 0) {
			i++;
			message = "비밀번호를 ";
			pfPw2.requestFocus();
		}

		if (pw1String.trim().length() == 0) {
			i++;
			message = "비밀번호를";
			pfPw1.requestFocus();
		}

		if (tfId.getText().trim().length() == 0) {
			i++;
			message = "ID를 ";
			tfId.requestFocus();
		}

		if (tfName.getText().trim().length() == 0) {
			i++;
			message = "이름을 ";
			tfName.requestFocus(); // *** 위치에 커서가 깜빡거게함
		}

		if (i > 0) {
			JOptionPane.showMessageDialog(null, message + "확인하세요!");
		}
		return i;
	}

	// User SignUp Action
	private void signUpAction() {
		int check = 0;
		//
		char[] pw1 = pfPw1.getPassword();
		String pw1String = new String(pw1); // char[] -> String 변환
		pw1String = pw1String.replaceAll(" ", "");
		char[] pw2 = pfPw2.getPassword();
		String pw2String = new String(pw2); // char[] -> String 변환
		pw2String = pw2String.replaceAll(" ", "");
		//
		if (pw1String.equals(pw2String)) {
			DaoMember daoMember = new DaoMember(tfId.getText(), pw1String, tfName.getText(), tfPhone.getText());
			// 사진은 추후에 추가하기

			check = daoMember.insertUserInfo();
			if (check == 1) {
				JOptionPane.showMessageDialog(null, tfName.getText() + "님의 정보가 입력 되었습니다!");
				setVisible(false);
				Main.frame.getContentPane().add(new Panel03Home());
			}
		} else {
			JOptionPane.showMessageDialog(null, "입력하신 정보를 확인해주세요.");
		}
	}
	
	
	
	// >>>추가해야할 사항<<<
	// 아이디에 영어+숫자만
	// 암호에 영어+숫자만
	// 전화번호에 숫자만 / 안내문구로 '-'빼고 입력요청하기

} // End
