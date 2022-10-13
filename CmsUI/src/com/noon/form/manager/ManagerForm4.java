package com.noon.form.manager;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.noon.dao.DaoMenu;
import com.noon.dao.DaoSetting;
import com.noon.dto.DtoSetting;

public class ManagerForm4 extends JPanel {
	private JTextField tfMenuname;
	private JTextField tfPrice;
	private JComboBox cbCategory;
	private JLabel lblPhoto;
	private JLabel lblChangePhoto;

	private String filepath ="";

	/**
	 * Create the panel.
	 */
	public ManagerForm4() {
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				setTf();
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		setLayout(null);
		setOpaque(false);

		JLabel lblMenuname = new JLabel("메뉴명");
		lblMenuname.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblMenuname.setBounds(57, 70, 42, 32);
		add(lblMenuname);

		tfMenuname = new JTextField();
		tfMenuname.setEditable(false);
		tfMenuname.setBounds(57, 100, 375, 45);
		add(tfMenuname);
		tfMenuname.setColumns(10);

		JLabel lblPrice = new JLabel("가격");
		lblPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblPrice.setBounds(57, 165, 42, 32);
		add(lblPrice);

		tfPrice = new JTextField();
		tfPrice.setColumns(10);
		tfPrice.setBounds(57, 190, 375, 45);
		add(tfPrice);

		JLabel lblCategory = new JLabel("카테고리");
		lblCategory.setHorizontalAlignment(SwingConstants.LEFT);
		lblCategory.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblCategory.setBounds(57, 265, 88, 32);
		add(lblCategory);

		lblPhoto = new JLabel("");
		lblPhoto.setBorder(new BevelBorder(BevelBorder.RAISED));
		lblPhoto.setBackground(new Color(255, 255, 255));
		lblPhoto.setBounds(498, 97, 200, 200);
		add(lblPhoto);

		JLabel lblDelete = new JLabel("");
		lblDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deleteMenu();
			}
		});
		ImageIcon icon1 = new ImageIcon((ManagerForm4.class.getResource("/com/noon/icon/delete.png")));
		Image img1 = icon1.getImage();
		Image changeImg1 = img1.getScaledInstance(118, 45, Image.SCALE_SMOOTH);
		lblDelete.setIcon(new ImageIcon(changeImg1));
		lblDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblDelete.setBounds(184, 430, 118, 45);
		add(lblDelete);

		JLabel lblUpdate = new JLabel("");
		lblUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateMenu();
			}
		});
		ImageIcon icon = new ImageIcon((ManagerForm4.class.getResource("/com/noon/icon/update.png")));
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(118, 45, Image.SCALE_SMOOTH);
		lblUpdate.setIcon(new ImageIcon(changeImg));
		lblUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblUpdate.setBounds(314, 430, 118, 45);
		add(lblUpdate);

		JLabel lblChangePhoto = new JLabel("이미지 변경하기");
		lblChangePhoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FilePath();
			}
		});
		lblChangePhoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangePhoto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Font font2 = lblChangePhoto.getFont();
		Map attributes2 = font2.getAttributes();
		attributes2.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		lblChangePhoto.setFont(font2.deriveFont(attributes2));
		lblChangePhoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangePhoto.setBounds(542, 309, 118, 16);
		add(lblChangePhoto);

		cbCategory = new JComboBox();
		cbCategory.setModel(new DefaultComboBoxModel(new String[] { "coffee", "beverage", "tea" }));
		cbCategory.setBounds(128, 261, 149, 45);
		add(cbCategory);
	}

	private void setTf() {
		DaoSetting dao = new DaoSetting();
		DtoSetting dto = dao.setTf();

		tfPrice.setText(Integer.toString(dto.getPricenow()));
		tfMenuname.setText(dto.getMenu_name());
		cbCategory.setName(dto.getCategorynow());
		String filePath2 = "./" + dto.getMenu_name();

		for (int i = 1; i <= ManagerForm3.numOfOne; i++) {
			filePath2 += 1;
		}

		lblPhoto.setIcon(new ImageIcon(filePath2));
		lblPhoto.setHorizontalAlignment(SwingConstants.CENTER);
	}

	private void deleteMenu() {
		DaoMenu dao = new DaoMenu(tfMenuname.getText().trim());
		dao.deleteMenu();
	}

	private void updateMenu() {
		FileInputStream input = null;
		if (filepath.equals("")) {
			filepath = "./" + tfMenuname.getText().trim();
			for (int i = 1; i <= ManagerForm3.numOfOne; i++) {
				filepath += 1;
			}
			
		} 
		File file = new File(filepath);
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DaoMenu dao = new DaoMenu(tfPrice.getText().trim(), input, tfMenuname.getText().trim(),
				(String) cbCategory.getSelectedItem());
		dao.updateMenu();
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
		lblPhoto.setIcon(new ImageIcon(filepath));
		lblPhoto.setHorizontalAlignment(SwingConstants.CENTER);
	}
}
