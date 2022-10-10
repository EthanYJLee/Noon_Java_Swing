package com.javalec.base;

import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;

public class TestProgram {

   public static void main(String[] args) {

      JFrame frame = new JFrame("Grid Layout");
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(1920,1080);
      JPanel panel = new JPanel();
      panel.setLayout(new GridLayout(6, 3, 100, 10));
      
      JLabel label1 = new JLabel("Hello");
      JLabel label2 = new JLabel("Hello2");
      JButton label3 = new JButton("Helasflo");
      JLabel label4 = new JLabel("Hello");
      JButton label5 = new JButton("Hello");
      JLabel label6 = new JLabel("Hellasfo");
      JButton label7 = new JButton("Hello");
      JLabel label8 = new JLabel("Helasfsaflo");
      JButton label9 = new JButton("Helasfaslo");
      JLabel label10 = new JLabel("Hello");
      JLabel label11 = new JLabel("Helasflo");
      JButton label12 = new JButton("Hello");
      JButton label13 = new JButton("Hello");
      JButton label14 = new JButton("Hello");
      JButton label15 = new JButton("Hello");
      JButton label16 = new JButton("Hello");
      JButton label17 = new JButton("Hello");
      JButton label18 = new JButton("Hello");
      
      panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
      
      
      panel.add(label1);
      panel.add(label3);
      panel.add(label2);
      panel.add(label4);
      panel.add(label5);
      panel.add(label6);
      panel.add(label7);
      panel.add(label8);
      panel.add(label9);
      panel.add(label10);
      panel.add(label11);
      panel.add(label12);
      panel.add(label13);
      panel.add(label14);
      panel.add(label15);
      panel.add(label16);
      panel.add(label17);
      panel.add(label18);
      frame.add(panel);
   }

}
