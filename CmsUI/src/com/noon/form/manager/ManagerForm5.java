package com.noon.form.manager;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.noon.dao.DaoMenu;
import com.noon.dao.DaoSetting;

public class ManagerForm5 extends JPanel {
	private JTextField tfMenuName;
	private JTextField tfPrice;
	private JLabel lblMenuImage;
	private JComboBox cbCategory;

	public ManagerForm5 jpanel5;

	private String filepath = "";

	/**
	 * Create the panel.
	 */
	public ManagerForm5() {
		setLayout(null);
		setOpaque(false);

		JLabel lblNewLabel = new JLabel("음료명");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel.setBounds(72, 62, 100, 50);
		add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("이미지추가");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FilePath();
			}
		});
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 12));
		Font font = lblNewLabel_2.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		lblNewLabel_2.setFont(font.deriveFont(attributes));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setBounds(590, 323, 74, 16);
		add(lblNewLabel_2);

		lblMenuImage = new JLabel("");
		lblMenuImage.setBorder(new BevelBorder(BevelBorder.RAISED));
		lblMenuImage.setBounds(518, 99, 200, 200);
		add(lblMenuImage);

		tfMenuName = new JTextField();
		tfMenuName.setBounds(72, 108, 375, 45);
		add(tfMenuName);
		tfMenuName.setColumns(10);

		JButton btn6plus = new JButton("");
		btn6plus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn6plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addMenu();
				// menu table에 입력된 값이 추가되고, set에 initdate는 now() , pricenow , photonow,
				// menuname은 추가한 menu의 name과 shopcode는 추가한 관리자의 shopcode를 추가한다.
				// 필요한 변수가 그러면, price , photo , menuname, category
			}
		});
		btn6plus.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 12));
		btn6plus.setIcon(new ImageIcon(getClass().getResource("/com/noon/icon/등록하기 버튼.png")));
		btn6plus.setBounds(313, 436, 118, 45);
		add(btn6plus);

		tfPrice = new JTextField();
		tfPrice.setColumns(10);
		tfPrice.setBounds(72, 210, 375, 45);
		add(tfPrice);

		JLabel lblNewLabel_1 = new JLabel("가격");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel_1.setBounds(72, 163, 100, 50);
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("카테고리");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(72, 265, 100, 50);
		add(lblNewLabel_1_1);

		cbCategory = new JComboBox();
		cbCategory.setModel(new DefaultComboBoxModel(new String[] { "coffee", "beverage", "tea" }));
		cbCategory.setBounds(172, 281, 149, 45);
		add(cbCategory);

	}

	private void addMenu() {
		FileInputStream input = null;
		FileInputStream input2 = null;
		File file = null;
		File file2 = null;
		if (checkFilepath()) {
			file = new File(filepath);
			file2 = new File(filepath);
		} else {
			return;
		}
		
		if (checkTF()) {
			try {
				input = new FileInputStream(file);
				input2 = new FileInputStream(file2);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			DaoMenu dao = new DaoMenu(tfPrice.getText().trim(), input, tfMenuName.getText().trim(),
					(String) cbCategory.getSelectedItem());
			dao.addMenu();
			DaoSetting dao2 = new DaoSetting(Integer.parseInt(tfPrice.getText().trim()),
					(String) cbCategory.getSelectedItem(), input2, tfMenuName.getText().trim());
			dao2.addSetting();
			JOptionPane.showConfirmDialog(null, "메뉴가 등록되셨습니다.");
			clearTF();
		}
	}

	private void clearTF() {
		tfPrice.setText("");
		tfMenuName.setText("");
		cbCategory.setSelectedItem(cbCategory);
		;
		lblMenuImage.setIcon(null);
	}

	private void FilePath() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, PNG, BMP", "jpg", "png", "bmp");
		chooser.setFileFilter(filter);

		int ret = chooser.showOpenDialog(null);
		if (ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다!", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		filepath = chooser.getSelectedFile().getPath();
		lblMenuImage.setIcon(new ImageIcon(filepath));
		lblMenuImage.setHorizontalAlignment(SwingConstants.CENTER);
	}

	private boolean checkFilepath() {
		if (filepath.equals("")) {
			JOptionPane.showConfirmDialog(null, "메뉴 사진 선택해 주세요");
			return false;
		} else {
			return true;
		}
	}

	private boolean checkTF() {
		String error = "";
		int i = 0;
		if (tfPrice.getText().trim().length() != 0) {
			try {
				int check = Integer.parseInt(tfPrice.getText().trim());
			} catch (NumberFormatException e) {
				JOptionPane.showConfirmDialog(null, "가격에는 숫자만 입력해주세요");
				tfPrice.setText(" ");
				return false;
			}
		} else {
			error = "가격";
			i++;
		}

		if (tfMenuName.getText().trim().length() == 0) {
			error = "메뉴이름";
			i++;
		}

		if (i == 0) {
			return true;
		} else {
			JOptionPane.showConfirmDialog(null, error + "을 입력해주세요");
			return false;
		}
	}
}
