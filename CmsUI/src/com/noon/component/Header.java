/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.noon.component;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author kwonsoonhyong
 */
public class Header extends javax.swing.JPanel {

	/**
	 * Creates new form Header
	 */
	public Header() {
		initComponents();
		setOpaque(false);
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		lblName = new javax.swing.JLabel();
		lblShopName = new javax.swing.JLabel();
		jSeparator1 = new javax.swing.JSeparator();
		imageAvatar2 = new com.noon.swing.ImageAvatar();

		lblName.setForeground(new java.awt.Color(102, 102, 102));
		lblName.setText("Name");

		lblShopName.setForeground(new java.awt.Color(102, 102, 102));
		lblShopName.setText("Shop Name");

		jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
		jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
		jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

		imageAvatar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/noon/icon/logo.png"))); // NOI18N

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(206, Short.MAX_VALUE)
						.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(lblShopName)
						.addGap(5, 5, 5).addComponent(lblName)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(imageAvatar2, javax.swing.GroupLayout.PREFERRED_SIZE, 45,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(15, 15, 15)));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jSeparator1)
						.addComponent(lblShopName, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup().addContainerGap()
								.addComponent(imageAvatar2, javax.swing.GroupLayout.PREFERRED_SIZE, 45,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
	}// </editor-fold>//GEN-END:initComponents

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint g3 = new GradientPaint(0, 0, Color.decode("#F4D2C9"), getWidth(), 0, Color.decode("#FAF3E0"));
		g2.setPaint(g3);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
		g2.fillRect(0, 10, getWidth(), getHeight());
		g2.fillRect(0, 0, getWidth() - 30, getHeight());
		super.paintComponent(g);
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private com.noon.swing.ImageAvatar imageAvatar2;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JLabel lblName;

	public javax.swing.JLabel getLblName() {
		return lblName;
	}

	public void setLblName(javax.swing.JLabel lblName) {
		this.lblName = lblName;
	}

	public javax.swing.JLabel getLblShopName() {
		return lblShopName;
	}

	public void setLblShopName(javax.swing.JLabel lblShopName) {
		this.lblShopName = lblShopName;
	}

	public com.noon.swing.ImageAvatar getImageAvatar2() {
		return imageAvatar2;
	}

	public void setImageAvatar2(com.noon.swing.ImageAvatar imageAvatar2) {
		this.imageAvatar2 = imageAvatar2;
	}

	private javax.swing.JLabel lblShopName;
	// End of variables declaration//GEN-END:variables
}
