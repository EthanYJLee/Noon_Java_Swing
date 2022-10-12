package com.noon.form.parttime;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.noon.component.Header;
import com.noon.dao.DaoHeader;
import com.noon.dao.DaoHire;
import com.noon.dao.DaoStaff;
import com.noon.main.Login;
import com.noon.swing.ImageAvatar;

public class ParttimeForm2 extends JPanel {
    private JLabel lblNewLabel_1;
    private ImageAvatar imageAvatar;
    private JTextField tfId;
    private JTextField tfPW;
    private JTextField tfPhone;
    private JTextField textField_3;
    private Header header2;
    
    private String filepath;

    /**
     * Create the panel.
     */
    public ParttimeForm2() {
    	setBackground(new Color(250, 243, 224));
    	setForeground(new Color(250, 243, 224));
        setOpaque(false);
        setLayout(null);
        add(getImageAvatar());
        
        JLabel lblNewLabel = new JLabel("정보 수정");
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 28));
        lblNewLabel.setBounds(44, 30, 132, 60);
        add(lblNewLabel);
        
        tfId = new JTextField();
        tfId.setForeground(new Color(0, 0, 0));
        tfId.setBackground(new Color(250, 243, 224));
        tfId.setColumns(10);
        tfId.setBounds(118, 106, 300, 41);
        tfId.setText(Login.id);
        add(tfId);
        
        
        JLabel lblNewLabel_2 = new JLabel("ID");
        lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2.setBounds(45, 108, 61, 30);
        add(lblNewLabel_2);
        
        JLabel lblNewLabel_2_1 = new JLabel("PW");
        lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        lblNewLabel_2_1.setBounds(45, 177, 61, 30);
        add(lblNewLabel_2_1);
        
        tfPW = new JTextField();
        tfPW.setColumns(10);
        tfPW.setBounds(118, 175, 300, 41);
        add(tfPW);
        
        JLabel lblNewLabel_2_1_1 = new JLabel("전화번호");
        lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        lblNewLabel_2_1_1.setBounds(21, 246, 85, 30);
        add(lblNewLabel_2_1_1);
        
        tfPhone = new JTextField();
        tfPhone.setColumns(10);
        tfPhone.setBounds(118, 244, 300, 41);
        add(tfPhone);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateAction();
			}
		});
        
        
        ImageIcon icon = new ImageIcon((ParttimeForm2.class.getResource("/com/noon/icon/update.png")));
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(150, 40, Image.SCALE_SMOOTH);
		lblNewLabel_3.setIcon(new ImageIcon(changeImg));
        lblNewLabel_3.setBounds(268, 430, 150, 40);
        add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("이미지 변경하기");
        lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FilePath();
			}
		});
        
        // 커서 클릭모양으로 바꾸기
        lblNewLabel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Font font = lblNewLabel_4.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        lblNewLabel_4.setFont(font.deriveFont(attributes));
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setBounds(550, 355, 113, 16);
        add(lblNewLabel_4);
    }
    
    
    // 정보수정 메소드
    private void updateAction() {
    	FileInputStream input = null;
		File file = new File(filepath);
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// DaoStaff 의 updateStaff();
		DaoStaff dao = new DaoStaff(tfPW.getText().trim(), tfPhone.getText().trim(),input);
		int num = dao.updateStaff();
		JOptionPane.showMessageDialog(null, "정보수정이 완료되었습니다.");
    }
    
    
    
     private ImageAvatar getImageAvatar() {
        if (imageAvatar == null) {
            imageAvatar = new ImageAvatar();
            imageAvatar.setIcon(new ImageIcon(getClass().getResource("/com/noon/icon/bigperson.png")));
            imageAvatar.setBounds(476, 87, 256, 256);
        }
        return imageAvatar;
    }
     
 	private void FilePath() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG", "PNG", "BMP", "jpg", "png", "bmp");
		chooser.setFileFilter(filter);

		int ret = chooser.showOpenDialog(null);
		if (ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다!", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		filepath = chooser.getSelectedFile().getPath();

		imageAvatar.setIcon(new ImageIcon(filepath));
		imageAvatar.repaint();
	}
    
    @Override
    protected void paintChildren (Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(new Color(255,255,255,100));

        super.paintChildren(g);
    }
    
    public void setStatus() {
		DaoHeader dao = new DaoHeader();
		tfId.setText(dao.getName()); 
		
	}
}
