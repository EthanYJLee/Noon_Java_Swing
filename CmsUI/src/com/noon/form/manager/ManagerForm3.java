package com.noon.form.manager;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

import com.noon.main.Main;


public class ManagerForm3 extends JPanel {

    private JButton btnNewButton;
    private JScrollPane scrollPane;
    public ManagerForm3 manager3;
    ManagerForm5 panel5 = new ManagerForm5();
    ManagerEmpty panel1 = new ManagerEmpty();
 

    
    public ManagerForm3() {
		setLayout(null);
		add(getBtnNewButton());
		add(getScrollPane());
		
		
	
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		        panel5.setVisible(true);
		        setVisible(false);

				}
			});
			btnNewButton.setIcon(new ImageIcon("/Users/bagtaegwon/Downloads/Frame 8-2.png"));
			btnNewButton.setBounds(597, 56, 117, 29);
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(73, 121, 630, 354);
		}
		return scrollPane;
	}

   @Override
    protected void paintChildren (Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(new Color(255,255,255,100));

        super.paintChildren(g);
    }
    
    
}
