package com.noon.form.manager;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class ManagerForm3 extends JPanel {

    private JButton btnNewButton;
    private JScrollPane scrollPane;

    /**
     * Create the panel.
     */
    public ManagerForm3() {
        setLayout(null);
        setOpaque(false);
        add(getBtnNewButton());
        add(getScrollPane());

    }

    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
            btnNewButton = new JButton("");
            btnNewButton.setIcon(new ImageIcon("/Users/bigdata/Downloads/메뉴 추갛가ㅣ.png"));
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
