package com.noon.form.manager;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.noon.swing.ImageAvatar;

public class ManagerForm2 extends JPanel {
    private JLabel lblNewLabel_1;
    private ImageAvatar imageAvatar;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;

    /**
     * Create the panel.
     */
    public ManagerForm2() {
    	setBackground(new Color(250, 223, 187));
    	setForeground(new Color(253, 235, 171));
        setOpaque(false);
        setLayout(null);
        add(getImageAvatar());
        
        JLabel lblNewLabel = new JLabel("알바 등록");
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 28));
        lblNewLabel.setBounds(44, 30, 132, 60);
        add(lblNewLabel);
        
        textField = new JTextField();
        textField.setBackground(new Color(255, 255, 255));
        textField.setBounds(118, 106, 300, 41);
        add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("ID");
        lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2.setBounds(45, 108, 61, 30);
        add(lblNewLabel_2);
        
        JLabel lblNewLabel_2_1 = new JLabel("이름");
        lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        lblNewLabel_2_1.setBounds(45, 177, 61, 30);
        add(lblNewLabel_2_1);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(118, 175, 300, 41);
        add(textField_1);
        
        JLabel lblNewLabel_2_1_1 = new JLabel("전화번호");
        lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        lblNewLabel_2_1_1.setBounds(21, 246, 85, 30);
        add(lblNewLabel_2_1_1);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(118, 244, 300, 41);
        add(textField_2);
        
        JLabel lblNewLabel_2_1_1_1 = new JLabel("계좌번호");
        lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        lblNewLabel_2_1_1_1.setBounds(21, 313, 85, 30);
        add(lblNewLabel_2_1_1_1);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(118, 311, 300, 41);
        add(textField_3);
        
        JLabel lblNewLabel_3 = new JLabel("");
        ImageIcon icon = new ImageIcon((ManagerForm2.class.getResource("/com/noon/icon/register.png")));
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(150, 40, Image.SCALE_SMOOTH);
		lblNewLabel_3.setIcon(new ImageIcon(changeImg));
        lblNewLabel_3.setBounds(268, 430, 150, 40);
        add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("이미지 변경하기");
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
    
    
    
     private ImageAvatar getImageAvatar() {
        if (imageAvatar == null) {
            imageAvatar = new ImageAvatar();
            imageAvatar.setIcon(new ImageIcon(getClass().getResource("/com/noon/icon/bigperson.png")));
            imageAvatar.setBounds(476, 87, 256, 256);
        }
        return imageAvatar;
    }
    
    @Override
    protected void paintChildren (Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(new Color(255,255,255,100));

        super.paintChildren(g);
    }
}
